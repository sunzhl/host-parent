package cn.com.hosp.www.dao.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskType implements Serializable {

    private Long id;

    private String typeNumber;

    private String typeName;

    private Long  parentId;

    private Long defaultDest;
    private String defaultDestName;

    private Long transTimeCodeId;

    private Short grade;

    private Integer urgentTime;

    private Long proId;

    private String proName;

    private LocalDateTime createTime;

    private Short state;

    private Short isDeleted;

    private Long modifyId;

    private String modifyName;

    private LocalDateTime modifyTime;

    private static final long serialVersionUID = 1L;

}