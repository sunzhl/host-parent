package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerInfo implements Serializable {
    private Long id;

    private String workerNumber;

    private String workerName;

    private String idCardNo;

    private Date birthday;

    private Short sex;

    private String phone;

    private String mobile;

    private String urgentName;

    private String urgentPhone;

    private Date joinTime;

    private String job;

    private Integer loopTime;

    private Long proId;

    private String proNumber;

    private String proName;

    private Long structId;

    private String structNumber;

    private String structName;


    private String province;

    private String city;

    private String address;

    private String personnelNumber;

    private String remark;

    private Short state;

    private static final long serialVersionUID = 1L;


}