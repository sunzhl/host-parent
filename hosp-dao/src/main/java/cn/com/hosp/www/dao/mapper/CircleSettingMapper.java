package cn.com.hosp.www.dao.mapper;

import cn.com.hosp.www.dao.dto.CircleSettingDto;
import cn.com.hosp.www.dao.entry.CircleSetting;
import cn.com.hosp.www.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CircleSettingMapper extends BaseMapper<CircleSetting> {


    @Select("select cs.id as id, cs.worker_id as workerId, cs.worker_name as workerName, \n" +
            "       cs.pro_id as proId, cs.pro_name as proName, cs.finish_count as finishCount, \n" +
            "       cs.finish_time as finishTime, cp.spaces as spaces\n" +
            " from circle_setting as cs\n" +
            " LEFT JOIN\n" +
            " (select circle_id, GROUP_CONCAT(space_name separator ',') as spaces from circle_points group by circle_id) as cp\n" +
            " on cs.id = cp.circle_id where cs.is_deleted = 0 limit #{start, jdbcType=INTEGER}, #{pageSize, jdbcType=INTEGER}")
    List<CircleSettingDto> queryByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    @Select("select count(*)\n" +
            "from circle_setting as cs\n" +
            "LEFT JOIN\n" +
            "(select circle_id, GROUP_CONCAT(space_name separator ',') as spaces from circle_points group by circle_id) as cp\n" +
            "on cs.id = cp.circle_id where cs.is_deleted = 0 ")
    long queryCount();

}
