package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.TaskOperationRecord;

public interface TaskOperationRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskOperationRecord record);

    int insertSelective(TaskOperationRecord record);

    TaskOperationRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskOperationRecord record);

    int updateByPrimaryKey(TaskOperationRecord record);
}