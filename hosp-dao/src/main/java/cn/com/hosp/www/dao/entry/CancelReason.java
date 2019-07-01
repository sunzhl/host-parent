package cn.com.hosp.www.dao.entry;

import cn.com.hosp.www.dao.mapper.base.annotation.NoColumn;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CancelReason implements Serializable {
    private Long id;

    private String cancelCode;

    private String cancelName;

    private Long proId;

    private String proNumber;

    private String proName;

    private LocalDateTime createTime;

    @NoColumn
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCancelCode() {
        return cancelCode;
    }

    public void setCancelCode(String cancelCode) {
        this.cancelCode = cancelCode == null ? null : cancelCode.trim();
    }

    public String getCancelName() {
        return cancelName;
    }

    public void setCancelName(String cancelName) {
        this.cancelName = cancelName == null ? null : cancelName.trim();
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

}