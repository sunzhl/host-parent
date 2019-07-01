package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.DictState;

public interface DictStateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictState record);

    int insertSelective(DictState record);

    DictState selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DictState record);

    int updateByPrimaryKey(DictState record);
}