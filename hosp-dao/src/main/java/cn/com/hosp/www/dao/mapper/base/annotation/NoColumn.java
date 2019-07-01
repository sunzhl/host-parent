package cn.com.hosp.www.dao.mapper.base.annotation;


import java.lang.annotation.*;

/**
 *@ClassName NoColumn
 *@Description 表示实例属性不作为表列注解
 *@Author tome
 *@Date 2019-06-28
 *@Version 1.0
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoColumn {
}
