package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.TaskType;

public interface TaskTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskType record);

    int insertSelective(TaskType record);

    TaskType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskType record);

    int updateByPrimaryKey(TaskType record);
}