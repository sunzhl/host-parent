package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.WorkTools;

public interface WorkToolsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WorkTools record);

    int insertSelective(WorkTools record);

    WorkTools selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkTools record);

    int updateByPrimaryKey(WorkTools record);
}