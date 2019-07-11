package cn.com.hosp.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@MapperScan("cn.com.hosp.www.dao.mapper")
public class HospWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospWebApplication.class, args);
    }

}
