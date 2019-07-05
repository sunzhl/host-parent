package cn.com.hosp.www.common.utils;

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

}
