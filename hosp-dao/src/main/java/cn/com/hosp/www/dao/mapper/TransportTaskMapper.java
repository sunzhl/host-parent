package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.TransportTask;

public interface TransportTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransportTask record);

    int insertSelective(TransportTask record);

    TransportTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransportTask record);

    int updateByPrimaryKey(TransportTask record);
}