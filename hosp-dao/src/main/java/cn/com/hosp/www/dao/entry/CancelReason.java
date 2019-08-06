package cn.com.hosp.www.dao.entry;

import cn.com.hosp.www.dao.mapper.base.annotation.NoColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CancelReason implements Serializable {
    private Long id;

    private String cancelCode;

    private String cancelName;

    private Long proId;

    private String proName;

    private Short isDeleted;

    private Long modifyId;

    private String modifyName;

    private LocalDateTime createTime;

    @NoColumn
    private static final long serialVersionUID = 1L;



}