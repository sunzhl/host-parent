package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface WorkerInfoMapper extends BaseMapper<WorkerInfo> {


    @Update("<script> update worker_info set state = #{state, jdbcType=TINYINT} where " +
            "<if test='workerNumber != null'> worker_number = #{workerNumber, jdbcType=VARCHAR}</if>" +
            "<if test='mobile != null'> mobile = #{mobile, jdbcType=VARCHAR}</if>" +
            "</script>")
    int updateState(WorkerInfo workerInfo);


    List<WorkerInfo> queryByPage(Map<String, Object> params);

    long queryCount(Map<String, Object> params);





}