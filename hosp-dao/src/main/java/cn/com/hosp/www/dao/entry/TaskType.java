package cn.com.hosp.www.dao.entry;

import java.io.Serializable;
import java.util.Date;

public class TaskType implements Serializable {
    private Long id;

    private String typeNumber;

    private String typeName;

    private String parentNumber;

    private Long defaultDest;

    private Long transTimeCodeId;

    private Boolean grade;

    private Integer urgentTime;

    private Long proId;

    private String proNumber;

    private String proName;

    private Date createTime;

    private Boolean state;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(String typeNumber) {
        this.typeNumber = typeNumber == null ? null : typeNumber.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber == null ? null : parentNumber.trim();
    }

    public Long getDefaultDest() {
        return defaultDest;
    }

    public void setDefaultDest(Long defaultDest) {
        this.defaultDest = defaultDest;
    }

    public Long getTransTimeCodeId() {
        return transTimeCodeId;
    }

    public void setTransTimeCodeId(Long transTimeCodeId) {
        this.transTimeCodeId = transTimeCodeId;
    }

    public Boolean getGrade() {
        return grade;
    }

    public void setGrade(Boolean grade) {
        this.grade = grade;
    }

    public Integer getUrgentTime() {
        return urgentTime;
    }

    public void setUrgentTime(Integer urgentTime) {
        this.urgentTime = urgentTime;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}