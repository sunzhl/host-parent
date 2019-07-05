package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.dao.entry.*;
import cn.com.hosp.www.dao.mapper.*;
import cn.com.hosp.www.sys.service.MedicalCareService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import cn.com.hosp.www.sys.web.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName MedicalCareServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 下午4:35
 * @Version 1.0
 */

@Service
@Slf4j
public class MedicalCareServiceImpl extends BaseServiceImpl<MedicalCareMapper, MedicalCare> implements MedicalCareService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private MedicalCareMapper medicalCareMapper;

    @Autowired
    private ProjectsMapper projectsMapper;

    @Autowired
    private SpaceInfoMapper spaceInfoMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MedicalCare save(UserForm form) {
        Projects projects = projectsMapper.selectByPrimaryKey(form.getProId());

        if(projects == null){
            throw new HospException("指定的[" + form.getProId()+"]项目不存在!");
        }

        SpaceInfo spaceInfo = spaceInfoMapper.selectByPrimaryKey(form.getSpaceId());

        if(null == spaceInfo){
          throw new HospException("对应的空间代码不存在");
        }

        MedicalCare care = new MedicalCare();
        BeanUtils.copyProperties(form, care);
        care.setProId(projects.getId());
        care.setProName(projects.getProName());
        care.setProNumber(projects.getProNumber());
        care.setMedicalSex(form.getSex());
        care.setSpaceId(spaceInfo.getId());
        care.setSpaceCode(spaceInfo.getSpaceCode());
        care.setSpaceName(spaceInfo.getSpaceName());

        SysUsers users = new SysUsers();
        users.setUsername(form.getWorkerNumber());
        users.setMobile(form.getMobile());
        users.setUserType((short)0);
        users.setPassword(passwordEncoder.encode(form.getPassword()));
        Integer insert = sysUsersMapper.insert(users);
        return super.save(care);
    }
}
