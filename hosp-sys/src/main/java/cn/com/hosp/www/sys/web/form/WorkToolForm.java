package cn.com.hosp.www.sys.web.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName WorkToolForm
 * @Description TODO
 * @Author tome
 * @Date 19-7-8 上午11:31
 * @Version 1.0
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "运送工具对象")
public class WorkToolForm implements Serializable {

    @ApiModelProperty(hidden = true)
    private String toolCode;

    @ApiModelProperty(value = "运送工具名称", name = "toolName", required = true)
    @NotBlank(message = "运送工具名称不能为空")
    private String toolName;

    @ApiModelProperty(value = "所属项目ID", name = "proId", required = true)
    @NotNull(message = "所属项目不能为空")
    private Long proId;

    @ApiModelProperty(value = "所属项目名称", required = true, name = "proName")
    @NotBlank(message = "所属项目名称不能为空")
    private String proName;

    private static final long serialVersionUID = 1L;
}
