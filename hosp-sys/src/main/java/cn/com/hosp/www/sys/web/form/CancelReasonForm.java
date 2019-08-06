package cn.com.hosp.www.sys.web.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName CancelResonForm
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午11:13
 * @Version 1.0
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CancelReasonForm {

    private String cancelCode;

    private String cancelName;

    private Long proId;

    private String proName;


}
