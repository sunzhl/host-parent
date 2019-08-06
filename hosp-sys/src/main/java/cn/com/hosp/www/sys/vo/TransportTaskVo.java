package cn.com.hosp.www.sys.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportTaskVo {

    private Long pid;

    private Long taskId;

    private String patientNumber;

    private String patientName;

    private String bedNumber;

    private short sex;

    private Integer age;

    private String number;

    private Long id;

    private String taskNumber;

    private String taskName;

    private Long taskTypeId;

    private Long setOutPlaceId;

    private Long destinationId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planStartTime;

    private Integer finishTime;

    private Integer bookTime;

    private Short priority;

    private Long toolId;

    private Long workerId;

    private Integer actualCount;

    private Short state;

    private String taskDesc;

    private String taskRemark;
}
