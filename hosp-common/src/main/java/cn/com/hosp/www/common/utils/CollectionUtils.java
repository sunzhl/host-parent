package cn.com.hosp.www.common.utils;

import java.util.*;

/**
 * @ClassName NewFactory
 * @Description TODO
 * @Author tome
 * @Date 19-6-28 下午5:34
 * @Version 1.0
 */

public class CollectionUtils {

    public static <K, V> Map<K, V> newMap(){
        return new HashMap<>();
    }

    public static <E> List<E> newArrayList(){
        return new ArrayList<>();
    }

    public static <E> List<E> newLinkedList(){
        return new LinkedList<>();
    }
}
