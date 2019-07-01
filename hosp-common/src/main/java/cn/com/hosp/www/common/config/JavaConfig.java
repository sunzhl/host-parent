package cn.com.hosp.www.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName JavaConfig
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 上午10:27
 * @Version 1.0
 */

@Configuration
public class JavaConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


   /* public static void main(String[] args) {


        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String encode = encoder.encode("123456");

        System.out.println(encode);


    }*/

}
