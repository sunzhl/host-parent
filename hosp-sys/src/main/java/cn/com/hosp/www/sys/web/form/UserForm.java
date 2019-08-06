package cn.com.hosp.www.sys.web.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName Worker
 * @Description TODO
 * @Author tome
 * @Date 19-6-27 下午6:43
 * @Version 1.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("运送员信息")
public class UserForm {

    @ApiModelProperty(value = "运送员编号", name = "workerNumber", required = true)
    private String workerNumber;

    @ApiModelProperty(value = "运送员姓名", name = "workerName", required = true)
    private String workerName;

    @ApiModelProperty(value = "身份证号码", name = "idCardNo")
    private String idCardNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Short sex;

    private String phone;

    private String mobile;

    private String urgentName;

    private String urgentPhone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
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


}
