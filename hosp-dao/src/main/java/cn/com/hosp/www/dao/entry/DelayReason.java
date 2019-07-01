package cn.com.hosp.www.dao.entry;

import java.io.Serializable;
import java.util.Date;

public class DelayReason implements Serializable {
    private Long id;

    private String delayCode;

    private String delayName;

    private Long proId;

    private String proNumber;

    private String proName;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDelayCode() {
        return delayCode;
    }

    public void setDelayCode(String delayCode) {
        this.delayCode = delayCode == null ? null : delayCode.trim();
    }

    public String getDelayName() {
        return delayName;
    }

    public void setDelayName(String delayName) {
        this.delayName = delayName == null ? null : delayName.trim();
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNumber() {
        return proNumber;
    }

    public void setProNumber(String proNumber) {
        this.proNumber = proNumber == null ? null : proNumber.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}