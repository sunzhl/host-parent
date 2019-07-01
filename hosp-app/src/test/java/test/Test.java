package test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName Test
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午11:55
 * @Version 1.0
 */

public class Test {


    public static void main(String[] args) {

        Integer[] ids = {1,2,3,4,5,6,7,8,9};

        Object[] objects = Stream.of(ids).filter(integer -> integer > 4).toArray();

        Stream.of(objects).forEach(integer -> System.out.println(integer));

    }

}
