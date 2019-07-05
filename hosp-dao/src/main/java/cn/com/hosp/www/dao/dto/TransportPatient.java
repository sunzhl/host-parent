package cn.com.hosp.www.dao.dto;

import lombok.*;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @ClassName TransportPatient
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 上午11:29
 * @Version 1.0
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportPatient implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String taskName;
    private String createName;
    private LocalDateTime createTime;
    private String taskTypeName;
    private String setOutPlaceName;
    private String destinationName;
    private LocalDateTime planStartTime;
    private Integer finishTime;
    private Integer bookTime;
    private String workerName;
    private Long workerId;
    private Short priority;
    private Short state;
    private Long proId;
    private String proNumber;
    private String proName;
    private String toolName;
    private String patientName;
    private Long pid;
    private Integer age;
    private String bedNumber;
    private Integer number;
    private Short sex;

}
