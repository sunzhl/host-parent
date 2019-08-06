package cn.com.hosp.www.dao.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransportTimeCode implements Serializable {
    private Long id;

    private String codeName;

    private String timeCode;

    private Long proId;

    private String proName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date effectiveTime;

    private Integer reserveTime;

    private Integer standardTime;

    private Integer warnTime;

    private Integer criticalTime;

    private Short isDeleted;

    private Long modifyId;

    private String modifyName;

    private LocalDateTime modifyTime;

    private static final long serialVersionUID = 1L;

}