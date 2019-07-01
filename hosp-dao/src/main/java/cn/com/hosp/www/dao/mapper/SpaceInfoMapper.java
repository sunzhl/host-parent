package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.SpaceInfo;

public interface SpaceInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpaceInfo record);

    int insertSelective(SpaceInfo record);

    SpaceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpaceInfo record);

    int updateByPrimaryKey(SpaceInfo record);
}