package cn.com.hosp.www.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 上午11:04
 * @Version 1.0
 */

public class Utils {

    public static boolean isMobile(final String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][34578][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }


}
