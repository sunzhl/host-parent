package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.DelayReason;

public interface DelayReasonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DelayReason record);

    int insertSelective(DelayReason record);

    DelayReason selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DelayReason record);

    int updateByPrimaryKey(DelayReason record);
}