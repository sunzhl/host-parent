package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.BeanUtils;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.common.utils.StringUtils;
import cn.com.hosp.www.common.utils.UUIDUtils;
import cn.com.hosp.www.dao.dto.TransportPatient;
import cn.com.hosp.www.dao.entry.*;
import cn.com.hosp.www.dao.mapper.*;
import cn.com.hosp.www.sys.service.TaskOperationRecordService;
import cn.com.hosp.www.sys.service.TransportTaskService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import cn.com.hosp.www.sys.vo.TransportTaskVo;
import cn.com.hosp.www.sys.web.form.TaskForm;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

/**
 * @ClassName TransportTaskServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 下午5:27
 * @Version 1.0
 */

@Service
public class TransportTaskServiceImpl extends BaseServiceImpl<TransportTaskMapper, TransportTask>
                                        implements TransportTaskService {
    @Autowired
    private PatientInfoMapper patientInfoMapper;

    @Autowired
    private TransportTaskMapper transportTaskMapper;

    @Autowired
    private WorkerInfoMapper workerInfoMapper;
    @Autowired
    private WorkerTaskMapper workerTaskMapper;

    @Autowired
    private TaskOperationRecordService recordService;

    @Override
    @Transactional
    public long save(TaskForm form) {
        TransportTask task = new TransportTask();
        BeanUtils.copyProperties(form, task);
        task.setTaskNumber(UUIDUtils.uuid());
        PatientInfo patientInfo = null;
        if(StringUtil.isNotEmpty(form.getPatientName())){
            String patientNumber = UUIDUtils.uuid();
            patientInfo = new PatientInfo();
            BeanUtils.copyProperties(form, patientInfo);
            patientInfo.setPatientNumber(patientNumber);
            task.setPatientNumber(patientNumber);
        }

        if(null != task.getWorkerId()){
           task.setState((short)1);
           workerTaskMapper.update(task.getWorkerId(), (short)1);
        }

        task.setTaskName("");
        task.setProNumber("0000000000");



        task = super.save(task);

        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setId(task.getCreateId());
        workerInfo.setWorkerName(task.getCreateName());
        recordService.save(task.getId(), workerInfo, "创建任务");
        if(null != patientInfo){
            patientInfo.setTaskId(task.getId());
            patientInfoMapper.insert(patientInfo);
        }
        return task.getId();
    }



    @Override
    @Transactional
    public long update(TaskForm form) {
        TransportTask task = new TransportTask();
        BeanUtils.copyProperties(form, task);
        PatientInfo patientInfo = null;
        if(StringUtil.isNotEmpty(form.getPatientName()) && form.getPid() == null){ //新增病人信息
            String patientNumber = UUIDUtils.uuid();
            patientInfo = new PatientInfo();
            BeanUtils.copyProperties(form, patientInfo);
            patientInfo.setPatientNumber(patientNumber);
            patientInfo.setTaskId(task.getId());
            task.setPatientNumber(patientNumber);
            patientInfoMapper.insert(patientInfo);
        }else if(form.getPid() != null){
            patientInfo = new PatientInfo();
            BeanUtils.copyProperties(form, patientInfo);
            patientInfo.setId(form.getPid());
            patientInfoMapper.updateByPrimaryKeySelective(patientInfo);
        }
        if(2 == form.getUpdateType()){
            workerTaskMapper.update(task.getWorkerId(), (short)1);
        }
        Integer integer = transportTaskMapper.updateByPrimaryKeySelective(task);
        saveTaskLog(task.getId(), form.getOperationId(), form.getUpdateType());
        return integer;
    }

    @Override
    public Page queryByPage(Map<String, Object> param) {
        long totalRow = transportTaskMapper.queryCount(param);
        List<TransportPatient> transportPatients = null;
        if(totalRow > 0){
            transportPatients = transportTaskMapper.queryByPage(param);
        }
        Page<TransportPatient> page =  Page.with(totalRow, transportPatients, (Integer) param.get("currentPage"), (Integer)param.get("pageSize"));
        return page;
    }

    @Override
    @Transactional
    public Result assignOrObtain(long id, long uid, long rid, short getType) {
        WorkerInfo workerInfo = workerInfoMapper.selectByPrimaryKey(rid);
        if(workerInfo == null){
           return Result.error("客户信息不存在");
        }
        int i = transportTaskMapper.assign(id, rid, workerInfo.getWorkerName(), getType);
        if(i > 0){
            workerTaskMapper.update(rid, getType);
             if(getType == 1){
                 recordService.save(id, uid, "分派任务");
             }else{
                 recordService.save(id, workerInfo, "自主获取任务");
             }
            return Result.success();
        }else {
            return  Result.error("任务已被分派或已被获取");
        }
    }

    @Override
    public TransportTaskVo query(Long id) {
        TransportTaskVo result = new TransportTaskVo();
        TransportTask transportTask = transportTaskMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(transportTask, result);
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.setTaskId(id);
        PatientInfo patientInfo1 = patientInfoMapper.selectOneByCriteria(patientInfo);
        if(patientInfo1 != null){
           BeanUtils.copyProperties(patientInfo1, result);
           result.setPid(patientInfo1.getId());
        }

        return result;
    }


    private void saveTaskLog(Long taskId, Long operationId, int type){
        String remark = "修改任务";
        if(1 == type){
            remark = "取消任务";
        }else if(3 == type){
            remark = "延迟任务";
        }
        recordService.save(taskId, operationId, remark);
    }

}
