package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.SysRole;
import cn.com.hosp.www.dao.mapper.base.BaseMapper;
import com.fasterxml.jackson.databind.JavaType;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("select r.id, r.role_code, r.role_name, r.role_state, r.create_time from sys_users as u\n" +
            "left join sys_users_role ur on u.id = ur.sys_users_id\n" +
            "left join sys_role r on ur.sys_role_id = r.id\n" +
            "where u.id = #{id, jdbcType=BIGINT};\n")
    @Results(id = "resultMap", value = {
            @Result(column = "id", property = "id", id = true, jdbcType = JdbcType.BIGINT),
            @Result(column = "role_code", property = "roleCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role_state", property = "roleState", jdbcType = JdbcType.TINYINT, javaType = Short.class),
            @Result(column = "create_time", property = "createTime", javaType = LocalDateTime.class)
    })
    List<SysRole> selectByUserId(Long id);
}