package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.SysUsersRole;

public interface SysUsersRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUsersRole record);

    int insertSelective(SysUsersRole record);

    SysUsersRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUsersRole record);

    int updateByPrimaryKey(SysUsersRole record);
}