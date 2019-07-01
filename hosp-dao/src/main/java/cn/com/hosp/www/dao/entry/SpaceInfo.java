package cn.com.hosp.www.dao.entry;

import java.io.Serializable;

public class SpaceInfo implements Serializable {
    private Long id;

    private String spaceCode;

    private String spaceName;

    private String floor;

    private String wonGroup;

    private Long roleId;

    private String roleName;

    private Long proId;

    private String proNumber;

    private String proName;

    private Long structId;

    private String structNumber;

    private String structName;

    private Boolean jobType;

    private Long endTypeId;

    private String endTypeName;

    private Boolean batchJobStart;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpaceCode() {
        return spaceCode;
    }

    public void setSpaceCode(String spaceCode) {
        this.spaceCode = spaceCode == null ? null : spaceCode.trim();
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName == null ? null : spaceName.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getWonGroup() {
        return wonGroup;
    }

    public void setWonGroup(String wonGroup) {
        this.wonGroup = wonGroup == null ? null : wonGroup.trim();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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

    public Long getStructId() {
        return structId;
    }

    public void setStructId(Long structId) {
        this.structId = structId;
    }

    public String getStructNumber() {
        return structNumber;
    }

    public void setStructNumber(String structNumber) {
        this.structNumber = structNumber == null ? null : structNumber.trim();
    }

    public String getStructName() {
        return structName;
    }

    public void setStructName(String structName) {
        this.structName = structName == null ? null : structName.trim();
    }

    public Boolean getJobType() {
        return jobType;
    }

    public void setJobType(Boolean jobType) {
        this.jobType = jobType;
    }

    public Long getEndTypeId() {
        return endTypeId;
    }

    public void setEndTypeId(Long endTypeId) {
        this.endTypeId = endTypeId;
    }

    public String getEndTypeName() {
        return endTypeName;
    }

    public void setEndTypeName(String endTypeName) {
        this.endTypeName = endTypeName == null ? null : endTypeName.trim();
    }

    public Boolean getBatchJobStart() {
        return batchJobStart;
    }

    public void setBatchJobStart(Boolean batchJobStart) {
        this.batchJobStart = batchJobStart;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}