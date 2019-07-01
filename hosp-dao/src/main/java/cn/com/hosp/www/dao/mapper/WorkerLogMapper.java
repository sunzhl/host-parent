package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.WorkerLog;

public interface WorkerLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WorkerLog record);

    int insertSelective(WorkerLog record);

    WorkerLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkerLog record);

    int updateByPrimaryKey(WorkerLog record);
}