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
public class DelayReason implements Serializable {
    private Long id;

    private String delayCode;

    private String delayName;

    private Long proId;

    private String proName;

    private Short isDeleted;

    private Long modifyId;

    private String modifyName;

    private Date createTime;

    private static final long serialVersionUID = 1L;


}