package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.TransportTimeCode;

public interface TransportTimeCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransportTimeCode record);

    int insertSelective(TransportTimeCode record);

    TransportTimeCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransportTimeCode record);

    int updateByPrimaryKey(TransportTimeCode record);
}