package cn.com.hosp.www.common.utils;

/**
 * @ClassName BeanUtils
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 下午3:06
 * @Version 1.0
 */

public class BeanUtils {



    public static void copyProperties(Object src, Object target){
        if(target == null || src == null){
            throw new IllegalArgumentException("参数不能为空");
        }

        org.springframework.beans.BeanUtils.copyProperties(src, target);
    }


}
