package cn.com.hosp.www.dao.entry;

import java.io.Serializable;

public class SysUsersRole implements Serializable {
    private Long id;

    private Long sysUsersId;

    private Long sysRoleId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysUsersId() {
        return sysUsersId;
    }

    public void setSysUsersId(Long sysUsersId) {
        this.sysUsersId = sysUsersId;
    }

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}