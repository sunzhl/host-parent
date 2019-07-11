package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.common.utils.MD5Util;
import cn.com.hosp.www.dao.entry.*;
import cn.com.hosp.www.dao.mapper.*;
import cn.com.hosp.www.sys.service.UserService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import cn.com.hosp.www.sys.web.form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends BaseServiceImpl<WorkerInfoMapper, WorkerInfo> implements UserService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private WorkerInfoMapper workerInfoMapper;

    @Autowired
    private ProjectsMapper projectsMapper;
    @Autowired
    private StructuresMapper structuresMapper;

    @Autowired
    private WorkerTaskMapper workerTaskMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public WorkerInfo save(UserForm userForm) {
        Projects projects = projectsMapper.selectByPrimaryKey(userForm.getProId());
        if(projects == null){
            throw new HospException("指定的["+userForm.getProId()+"]项目不存在!");
        }
        Structures structures = structuresMapper.selectByPrimaryKey(userForm.getStructId());
        if(null == structures){
            throw new HospException("指定的负责建筑物不存在");
        }

        WorkerInfo workerInfo = new WorkerInfo();
        BeanUtils.copyProperties(userForm, workerInfo);
        workerInfo.setIdCardNo(userForm.getIdCardNo());
        workerInfo.setProName(projects.getProName());
        workerInfo.setProNumber(projects.getProNumber());
        workerInfo.setStructId(structures.getId());
        workerInfo.setStructNumber(structures.getStructNumber());
        workerInfo.setStructName(structures.getStructName());

        SysUsers users = new SysUsers();
        users.setMobile(userForm.getMobile());
        users.setUsername(userForm.getWorkerNumber());
        users.setUserType((short)1);
        users.setPassword(passwordEncoder.encode(userForm.getPassword()));
        sysUsersMapper.insert(users);
        WorkerInfo save = super.save(workerInfo);

        WorkerTask workerTask = new WorkerTask();
        workerTask.setWorkerId(save.getId());
        workerTaskMapper.insert(workerTask);
        return  save;
    }

    @Override
    public int updateStateByUserName(WorkerInfo workerInfo) {
        workerInfoMapper.updateState(workerInfo);
        return 0;
    }
}
