package cn.com.hosp.www.common.utils;

import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * @ClassName MD5Util
 * @Description TODO
 * @Author tome
 * @Date 19-6-27 下午6:28
 * @Version 1.0
 */

public class MD5Util {

    private static final String[] HEXI_CHAR = {
            "0", "1", "2", "3",
            "4", "5", "6", "7",
            "8", "9", "a", "b",
            "c", "d", "e", "f"};
    private static final String ALGORITHM = "MD5";

    public static String encodeByMD5(String data) throws Exception{
        return encodeByMD5(data, "UTF-8");
    }

    public static String encodeByMD5(String data, String charsetName) throws Exception{
        if(!StringUtils.hasText(data)){
            throw new IllegalArgumentException("参数[data]不能为空.");
        }
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
        byte[] bytes;
        if(null != charsetName && !"".equals(charsetName)){
            bytes = data.getBytes(Charset.forName(charsetName));
        }else{
            bytes = data.getBytes();
        }
        return byteArrayToHexString(digest.digest(bytes)).toUpperCase();
    }


    public static String byteArrayToHexString(byte[] array){

        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < array.length; i++){
            buffer.append(byteToHexString(array[i]));
        }
        return buffer.toString();
    }


    public static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEXI_CHAR[d1] + HEXI_CHAR[d2];
    }

}
