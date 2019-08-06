package cn.com.hosp.www.common.utils;

import java.util.HashSet;
import java.util.Set;
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

    private static final String[] NUMBERS = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
    };

    private static final String[] CHARS = {
            "a", "b", "c", "d", "e", "f", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z"
    };

    public static boolean isMobile(final String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][34578][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }


    public static String jvm(){
        String property = System.getProperty("java.jvm");
        if(StringUtils.isBlank(property)){
            return "01";
        }else{
            return property;
        }
    }


    public static String activationCode(){
        StringBuffer buffer = new StringBuffer(jvm());
        for(int i = 0; i < 6; i++){

            int hashCode = UUIDUtils.uuid().hashCode();
            if(hashCode < 0){
                hashCode *= -1;
            }
            buffer.append(CHARS[hashCode % CHARS.length]);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        for (int i =0 ;i < 100; i++){
            strings.add(activationCode());


        }
        System.out.println(strings.size());
    }


}
