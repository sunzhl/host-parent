package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CircleSetting implements Serializable {

    private Long id         ;
    private Long workerId   ;
    private String workerName  ;
    private Long proId      ;
    private String proName    ;
    private Integer finishCount;
    private Integer finishTime ;
    private Long spaceId    ;
    private Short isDeleted  ;
    private Long modifyId   ;
    private String modifyName ;
    private String modifyTime ;
    private static final long serialVersionUID = 1L;
}
