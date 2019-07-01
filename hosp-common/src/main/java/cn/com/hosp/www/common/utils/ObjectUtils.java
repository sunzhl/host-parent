package cn.com.hosp.www.common.utils;

import java.lang.reflect.Array;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName ObjectUtils
 * @Description TODO
 * @author  tome
 * @date 19-6-28 下午9:41
 * @Version 1.0
 */

public class ObjectUtils {


    /**
     * 把数组中的类型转换成元数据类型
     * @param objs  转换前对象数组
     * @param clazz  转换后数组对象类型
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] cast(Object[] objs, Class<T> clazz) {
        int length = objs.length;
        if (length == 0) {
            return (T[]) new Object[0];
        }
        T[] newArr = (T[]) Array.newInstance(clazz, objs.length);
        for (int i = 0; i < length; i++) {
            newArr[i] = clazz.cast(objs[i]);
        }
        return newArr;
    }

    public static boolean isCollection(Object obj) {
        return obj instanceof Collection;
    }

    public static boolean isMap(Object obj) {
        return obj instanceof Map;
    }

    public static boolean isNumber(Object obj) {
        return obj instanceof Number;
    }

    public static boolean isBoolean(Object obj) {
        return obj instanceof Boolean;
    }

    public static boolean isEnum(Object obj) {
        return obj instanceof Enum;
    }

    public static boolean isDate(Object obj) {
        return obj instanceof Date || obj instanceof TemporalAccessor;
    }

    public static boolean isCharSequence(Object obj) {
        return obj instanceof CharSequence;
    }

    /**
     * 判断对象是否为八大基本类型包装类除外即(boolean, byte, char, short, int, long, float, and double)<br/>
     *
     * @param obj
     * @return
     */
    public static boolean isPrimitive(Object obj) {
        return obj != null && obj.getClass().isPrimitive();
    }

    /**
     * 判断对象是否为包装类或者非包装类的基本类型
     * @param obj
     * @return
     */
    public static boolean isWrapperOrPrimitive(Object obj) {
        return isPrimitive(obj) || isNumber(obj) || isCharSequence(obj) || isBoolean(obj);
    }

    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

}
