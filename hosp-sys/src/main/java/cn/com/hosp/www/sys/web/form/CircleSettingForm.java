package cn.com.hosp.www.sys.web.form;

import cn.com.hosp.www.dao.entry.CirclePoints;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CircleSettingForm implements Serializable {

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
    private LocalDateTime modifyTime ;


    private List<CirclePointsForm> circlePoints;
    private static final long serialVersionUID = 1L;

}
