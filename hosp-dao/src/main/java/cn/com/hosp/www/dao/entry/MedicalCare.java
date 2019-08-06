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
public class MedicalCare implements Serializable {
    private Long id;

    private String medicalNumber;

    private Long userId;

    private String medicalName;

    private String mobile;

    private String telephone;

    private Long spaceId;

    private String spaceName;

    private Long proId;

    private String proName;

    private Short receiveMsg;

    private Short state;

    private String remark;

    private Short medicalSex;

    private Short isDeleted;

    private static final long serialVersionUID = 1L;

}