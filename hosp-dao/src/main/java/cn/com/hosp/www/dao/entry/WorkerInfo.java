package cn.com.hosp.www.dao.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerInfo implements Serializable {
    private Long id;

    private Long userId;

    private String workerNumber;

    private String workerName;

    private String idCardNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Short sex;

    private String phone;

    private String mobile;

    private String urgentName;

    private String urgentPhone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinTime;

    private String job;

    private Long workerGroup;

    private Integer loopTime;

    private Long proId;

    private String proName;

    private Long structId;

    private String structName;

    private String province;

    private String city;

    private String address;

    private String personnelNumber;

    private String remark;

    private Short state;

    private Short isDeleted;

    private static final long serialVersionUID = 1L;


}