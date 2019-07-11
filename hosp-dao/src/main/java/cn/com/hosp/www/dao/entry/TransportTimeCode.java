package cn.com.hosp.www.dao.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransportTimeCode implements Serializable {
    private Long id;

    private String codeName;

    private Long proId;

    private String proNumber;

    private String proName;

    private Date effectiveTime;

    private Integer reserveTime;

    private Integer standardTime;

    private Integer warnTime;

    private Integer criticalTime;

    private static final long serialVersionUID = 1L;

}