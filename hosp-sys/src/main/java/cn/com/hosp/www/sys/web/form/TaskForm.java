package cn.com.hosp.www.sys.web.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName TaskForm
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 下午5:29
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskForm {

    private String taskNumber;

    @NotBlank(message = "任务名称不能为空")
    private String taskName;

    @NotNull(message = "创建者ID不能为空!")
    private Long createId;

    private String createName;

    private Long taskTypeId;

    private String taskTypeName;

    private Long setOutPlaceId;

    private String setOutPlaceName;

    private Long destinationId;

    private String destinationName;

    private String patientNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planStartTime;

    private Integer finishTime;

    private Integer bookTime;

    private short priority;

    private Long toolId;

    private String toolName;

    private Long workerId;

    private String workerName;

    private Integer actualCount;

    private short state;

    private String cancelReason;

    private String delayReason;

    private String taskDesc;

    private String taskRemark;

    private Long proId;

    private String proNumber;

    private String proName;

    private String patientName;

    private String bedNumber;

    private short sex;

    private Integer age;

    private String number;

}
