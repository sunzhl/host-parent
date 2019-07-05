package cn.com.hosp.www.dao.entry;

import cn.com.hosp.www.dao.mapper.base.annotation.NoColumn;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransportTask implements Serializable {
    private Long id;

    private String taskNumber;

    private String taskName;

    private Long createId;

    private String createName;

    private Long taskTypeId;

    private String taskTypeName;

    private Long setOutPlaceId;

    private String setOutPlaceName;

    private Long destinationId;

    private String destinationName;

    private LocalDateTime createTime;

    private String patientNumber;

    private LocalDateTime planStartTime;

    private Integer finishTime;

    private Integer bookTime;

    private Short priority;

    private Long toolId;

    private String toolName;

    private Long workerId;

    private String workerName;

    private Integer actualCount;

    private Short state;

    private String cancelReason;

    private String delayReason;

    private String taskDesc;

    private String taskRemark;

    private Long proId;

    private String proNumber;

    private String proName;

    @NoColumn
    private static final long serialVersionUID = 1L;

}