package cn.com.hosp.www.dao.entry;

import java.io.Serializable;
import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
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

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Integer getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Integer reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Integer getStandardTime() {
        return standardTime;
    }

    public void setStandardTime(Integer standardTime) {
        this.standardTime = standardTime;
    }

    public Integer getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Integer warnTime) {
        this.warnTime = warnTime;
    }

    public Integer getCriticalTime() {
        return criticalTime;
    }

    public void setCriticalTime(Integer criticalTime) {
        this.criticalTime = criticalTime;
    }
}