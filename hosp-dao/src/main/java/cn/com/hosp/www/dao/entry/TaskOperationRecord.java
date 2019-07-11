package cn.com.hosp.www.dao.entry;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskOperationRecord implements Serializable {
    private Long id;

    private String recNumber;

    private Long taskId;

    private Long operationId;

    private String operationMan;

    private Date operationTime;

    private String remark;

    private static final long serialVersionUID = 1L;

}