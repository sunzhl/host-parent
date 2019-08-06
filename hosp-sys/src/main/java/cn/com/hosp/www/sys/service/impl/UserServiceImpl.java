package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.annotation.Log;
import cn.com.hosp.www.common.utils.MD5Util;
import cn.com.hosp.www.common.utils.StringUtils;
import cn.com.hosp.www.dao.entry.*;
import cn.com.hosp.www.dao.mapper.*;
import cn.com.hosp.www.sys.service.UserService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<SysUsersMapper, SysUsers> implements UserService {

    private static final String DEFAULT_PWD = "E10ADC3949BA59ABBE56E057F20F883E";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Log
    public SysUsers save(SysUsers sysUsers) {

        if(StringUtils.isBlank(sysUsers.getPassword())){
            sysUsers.setPassword(passwordEncoder.encode(DEFAULT_PWD));
        }else{
            String password = sysUsers.getPassword();
            try {
               password = MD5Util.encodeByMD5(password);
            } catch (Exception e) {
                log.error("处理密码出现异常", e);
            }
            sysUsers.setPassword(passwordEncoder.encode(password));
        }


        return super.save(sysUsers);
    }

}
