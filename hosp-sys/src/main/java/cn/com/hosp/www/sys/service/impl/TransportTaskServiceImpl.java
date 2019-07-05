package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.utils.BeanUtils;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.common.utils.UUIDUtils;
import cn.com.hosp.www.dao.dto.TransportPatient;
import cn.com.hosp.www.dao.entry.PatientInfo;
import cn.com.hosp.www.dao.entry.TransportTask;
import cn.com.hosp.www.dao.mapper.PatientInfoMapper;
import cn.com.hosp.www.dao.mapper.TransportTaskMapper;
import cn.com.hosp.www.sys.service.TransportTaskService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
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
        task = super.save(task);
        if(null != patientInfo){
            patientInfo.setTaskId(task.getId());
            patientInfoMapper.insert(patientInfo);
        }
        return task.getId();
    }

    @Override
    public Map<String, Object> queryByPage(Map<String, Object> param) {
        Map<String, Object> result = CollectionUtils.newMap();
        int totalRow = transportTaskMapper.queryCount(param);
        List<TransportPatient> transportPatients = null;
        if(totalRow > 0){
            transportPatients = transportTaskMapper.queryByPage(param);
        }
        result.put("list", transportPatients);
        result.put("total", totalRow);
        return result;
    }
}
