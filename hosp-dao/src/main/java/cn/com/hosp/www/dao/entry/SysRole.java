package cn.com.hosp.www.dao.entry;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class SysRole implements Serializable {
    private Long id;

    private String roleCode;

    private String roleName;

    private Short roleState;

    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Short getRoleState() {
        return roleState;
    }

    public void setRoleState(Short roleState) {
        this.roleState = roleState;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}