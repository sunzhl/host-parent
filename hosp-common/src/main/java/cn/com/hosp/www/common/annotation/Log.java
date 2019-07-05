package cn.com.hosp.www.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Log
 * @Description 记录操作日志 标志了此注解的方法记录操作日志
 * @Author tome
 * @Date 19-7-1 下午5:53
 * @Version 1.0
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
     String value() default "";
}
