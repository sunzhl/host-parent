package cn.com.hosp.www.sys.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassName PageForm
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午10:40
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageForm {

    private static final int DEFAULT_SIZE = 20;

    @NotNull

    private Integer pageNum;

    @NotNull
    @Size(min = 1, max = 20)
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if(pageSize == null || pageSize == 0){
            return DEFAULT_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
