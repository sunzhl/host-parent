package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.dao.dto.TransportPatient;
import cn.com.hosp.www.dao.entry.*;
import cn.com.hosp.www.dao.mapper.WorkerInfoMapper;
import cn.com.hosp.www.dao.mapper.WorkerTaskMapper;
import cn.com.hosp.www.sys.service.UserService;
import cn.com.hosp.www.sys.service.WorkerInfoService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import cn.com.hosp.www.sys.vo.WorkerInfoVo;
import cn.com.hosp.www.sys.web.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName WorkerInfoServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-7-11 下午5:40
 * @Version 1.0
 */

@Service
@Slf4j
public class WorkerInfoServiceImpl extends BaseServiceImpl<WorkerInfoMapper, WorkerInfo> implements WorkerInfoService {

    @Autowired
    private WorkerTaskMapper workerTaskMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private WorkerInfoMapper workerInfoMapper;

    @Override
    @Transactional
    public WorkerInfo save(UserForm userForm) {

        WorkerInfo workerInfo = new WorkerInfo();
        BeanUtils.copyProperties(userForm, workerInfo);
        workerInfo.setIdCardNo(userForm.getIdCardNo());

        SysUsers users = new SysUsers();
        users.setMobile(userForm.getMobile());
        users.setUsername(userForm.getWorkerNumber());
        users.setUserType((short)1);
        users = userService.save(users);

        workerInfo.setUserId(users.getId());
        WorkerInfo save = super.save(workerInfo);
        WorkerTask workerTask = new WorkerTask();
        workerTask.setWorkerId(save.getId());
        workerTaskMapper.insert(workerTask);

        return  save;
    }


    @Override
    public WorkerInfoVo query(Long proId) {
        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setProId(proId);
        workerInfo.setIsDeleted((short)0);
        List<WorkerInfo> workerInfos = this.listByCondition(workerInfo);
        List<WorkerInfo> effective = workerInfos.stream().filter(workerInfo1 -> workerInfo1.getState() != (short) 2).collect(Collectors.toList());
        Map<Short, List<WorkerInfo>> collect = effective.stream().collect(Collectors.groupingBy(WorkerInfo::getState));
        WorkerInfoVo result = new WorkerInfoVo();
        collect.forEach((state, list) -> {
            if((short)1 == state){
              result.setOnlineList(list);
            }else if((short)0 == state){
              result.setOfflineList(list);
            }
        });
        result.setTotalSize(effective.size()); //总人数
        result.setOnLineSize(collect.get((short)1) != null? collect.get((short)1).size(): 0); //在线人数
        log.info("查询的结果为{}", collect);
        return result;
    }

    @Override
    public Page<WorkerInfo> queryByPage(Map<String, Object> param) {
        Map<String, Object> result = CollectionUtils.newMap();
        long totalRow = workerInfoMapper.queryCount(param);
        List<WorkerInfo> workerInfos = null;
        if(totalRow > 0){
            workerInfos = workerInfoMapper.queryByPage(param);
        }
        result.put("list", workerInfos);
        result.put("total", totalRow);

        Page<WorkerInfo> page = Page.with(totalRow, workerInfos, (Integer) param.get("currentPage"), (Integer) param.get("pageSize"));

        return page;

    }


}
