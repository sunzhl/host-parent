package cn.com.hosp.www.dao.mapper;

import cn.com.hosp.www.dao.entry.WorkerTask;
import cn.com.hosp.www.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 * @ClassName WorkerTaskMapper
 * @Description TODO
 * @Author tome
 * @Date 19-7-5 上午11:38
 * @Version 1.0
 */

@Component
public interface WorkerTaskMapper extends BaseMapper<WorkerTask> {


    @Update("<script>" +
            "update worker_task set " +
            "<if test='type == 1'> total_count = total_count + 1, today_count = today_count + 1 </if>" +
            "<if test='type == 2'> self_count = self_count + 1, today_self_count = today_self_count + 1 </if>" +
            " where worker_id = #{workerId, jdbcType=BIGINT}" +
            "</script>")
    int update(@Param("workerId") Long workerId, @Param("type") Short type);

    @Update("update worker_task set today_count = 0, today_self_count = 0")
    int resetTodayCount();


    @Update("<script>" +
            "update worker_task set " +
            "<if test='lastLoginTime != null'> last_login_time = #{lastLoginTime, jdbcType=TIMESTAMP} </if>" +
            "<if test='scanTime != null'> scan_time = #{scanTime, jdbcType=TIMESTAMP} </if>" +
            "<if test='currentPosition != null'> current_position = #{currentPosition, jdbcType=varchar} </if>" +
            " where worker_id=#{workerId, jdbcType=BIGINT}" +
            "</script>")
    int updateByWorkerId(WorkerTask workerTask);

}
