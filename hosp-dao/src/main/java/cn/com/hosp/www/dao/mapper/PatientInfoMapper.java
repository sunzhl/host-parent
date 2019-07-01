package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.PatientInfo;

public interface PatientInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PatientInfo record);

    int insertSelective(PatientInfo record);

    PatientInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PatientInfo record);

    int updateByPrimaryKey(PatientInfo record);
}