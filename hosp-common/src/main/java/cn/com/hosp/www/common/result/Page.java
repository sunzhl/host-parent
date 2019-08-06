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

    private Integer currentPage; //当前页

    private Integer pageSize;  //页面大小

    private Long pageCount; //总页数

    private Integer currentPageCount; //当前页条数

    private Page(Long total, List<T> list) {
        this.total = total;
        this.list = list;
        currentPageCount = list.size();
    }

    public static <T> Page<T> with(Long total, List<T> data, Integer currentPage, Integer pageSize) {
        Page<T> tPage = new Page<>(total, data);
        tPage.setPageSize(pageSize);
        tPage.setCurrentPage(currentPage);
        return tPage;
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

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageCount() {

        pageCount = (total % pageSize == 0)? total / pageSize: total / pageSize + 1;

        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurrentPageCount() {
        return currentPageCount;
    }

    public void setCurrentPageCount(Integer currentPageCount) {
        this.currentPageCount = currentPageCount;
    }
}
