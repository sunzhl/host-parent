package cn.com.hosp.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.com.hosp.www.dao.mapper")
public class HospWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospWebApplication.class, args);
    }

}
