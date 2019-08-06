package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.utils.Utils;
import cn.com.hosp.www.dao.entry.*;
import cn.com.hosp.www.dao.mapper.*;
import cn.com.hosp.www.sys.service.MedicalCareService;
import cn.com.hosp.www.sys.service.UserService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;

    @Override
    @Transactional
    public MedicalCare save(MedicalCare medicalCare) {
         medicalCare.setMedicalNumber(Utils.activationCode());
         SysUsers users = new SysUsers();
         users.setMobile(medicalCare.getMobile());
         users.setUsername(medicalCare.getMedicalNumber());
         users.setUserType((short) 0);
         users = userService.save(users);
         medicalCare.setUserId(users.getId());
        log.info("医护人员[{}]插入数据为：{}", medicalCare.getMedicalNumber(), users);
        return super.save(medicalCare);
    }
}
