package cn.com.hosp.www.common.result;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Page
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午10:18
 * @Version 1.0
 */

public class Page<T> implements Serializable {

    private Long total;

    private List<T> list;

    private Page(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public static <T> Page<T> with(Long total, List<T> data) {
        return new Page<>(total, data);
    }

    public static <T> Page<T> empty() {
        return new Page<T>(0L, Collections.emptyList());
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> data) {
        this.list = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
