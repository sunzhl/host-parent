package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Structures implements Serializable {
    private Long id;

    private String structNumber;

    @NotNull(message = "序列号不能为空!")
    private Integer serial;

    @NotBlank(message = "建筑物名称不能为空")
    private String structName;

    private String remark;

    @NotNull(message = "必须指定所属项目")
    private Long proId;

    private String proName;

    private String structArea;

    private Date createTime;

    private Short isDeleted;

    private Long modifyId;

    private String modifyName;

    private LocalDateTime modifyTime;

    private static final long serialVersionUID = 1L;


}