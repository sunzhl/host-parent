package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.DictSex;

public interface DictSexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictSex record);

    int insertSelective(DictSex record);

    DictSex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DictSex record);

    int updateByPrimaryKey(DictSex record);
}