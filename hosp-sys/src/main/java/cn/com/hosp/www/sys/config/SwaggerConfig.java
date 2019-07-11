package cn.com.hosp.www.sys.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author tome
 * @Date 19-7-5 下午6:00
 * @Version 1.0
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                  .apiInfo(apiInfo())
                  .select()
                  .apis(RequestHandlerSelectors.basePackage("cn.com.hosp.www.sys.web.controller"))
                  .paths(PathSelectors.any())
                  .build();
    }


    public ApiInfo apiInfo(){

        return new ApiInfoBuilder()
                  .title("智能后勤管理系统API文档")
                  .description("利用 Swagger 生成文档")
                  .termsOfServiceUrl("http://localhost:8080/")
                  .version("1.0.0")
                .build();

    }


}
