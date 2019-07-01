package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.MedicalCare;

public interface MedicalCareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MedicalCare record);

    int insertSelective(MedicalCare record);

    MedicalCare selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MedicalCare record);

    int updateByPrimaryKeyWithBLOBs(MedicalCare record);

    int updateByPrimaryKey(MedicalCare record);
}