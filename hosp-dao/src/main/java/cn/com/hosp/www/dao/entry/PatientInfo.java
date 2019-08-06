package cn.com.hosp.www.dao.entry;

import lombok.*;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientInfo implements Serializable {
    private Long id;

    private Long taskId;

    private String patientNumber;

    private String patientName;

    private String bedNumber;

    private Short sex;

    private Integer age;

    private String number;

    private static final long serialVersionUID = 1L;


}