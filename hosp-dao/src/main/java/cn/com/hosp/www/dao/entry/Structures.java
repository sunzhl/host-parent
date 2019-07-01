package cn.com.hosp.www.dao.entry;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Structures implements Serializable {
    private Long id;

    @NotBlank(message = "建筑物编号不能为空")
    private String structNumber;

    @NotNull(message = "序列号不能为空!")
    private Integer serial;

    @NotBlank(message = "建筑物名称不能为空")
    private String structName;

    private String remark;

    @NotNull(message = "必须指定所属项目")
    private Long proId;

    private String proNumber;

    private String proName;

    private String structArea;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStructNumber() {
        return structNumber;
    }

    public void setStructNumber(String structNumber) {
        this.structNumber = structNumber == null ? null : structNumber.trim();
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getStructName() {
        return structName;
    }

    public void setStructName(String structName) {
        this.structName = structName == null ? null : structName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getStructArea() {
        return structArea;
    }

    public void setStructArea(String structArea) {
        this.structArea = structArea == null ? null : structArea.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}