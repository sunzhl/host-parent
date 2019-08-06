package cn.com.hosp.www.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

/**
 * @ClassName UUIDUtils
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 上午9:30
 * @Version 1.0
 */

public class UUIDUtils {




    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


    public static void main(String[] args) {

        String pwd = "E10ADC3949BA59ABBE56E057F20F883E";

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encode = passwordEncoder.encode(pwd);
        System.out.println(encode);


    }

}
