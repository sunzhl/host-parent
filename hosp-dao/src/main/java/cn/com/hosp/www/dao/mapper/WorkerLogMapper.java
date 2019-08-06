package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.entry.WorkerLog;
import cn.com.hosp.www.dao.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface WorkerLogMapper  extends BaseMapper<WorkerLog> {


    @Select("select id, log_number, worker_id, worker_name, task_id, log_type, position, log_time from worker_log" +
            " where log_type = #{type, jdbcType=TINYINT} and worker_id = #{workerId, jdbcType=BIGINT} order by log_time " +
            " desc limit 0, 1")
    @Results(id = "resultMap", value = {
            @Result(column = "id", property = "id", id = true, jdbcType = JdbcType.BIGINT),
            @Result(column = "log_number", property = "logNumber", jdbcType = JdbcType.VARCHAR),
            @Result(column = "worker_id", property = "workerId", jdbcType = JdbcType.BIGINT),
            @Result(column = "worker_name", property = "workerName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "task_id", property = "taskId", jdbcType = JdbcType.BIGINT),
            @Result(column = "log_type", property = "logType", jdbcType = JdbcType.TINYINT),
            @Result(column = "position", property = "position", jdbcType = JdbcType.VARCHAR),
            @Result(column = "log_time", property = "logTime", jdbcType = JdbcType.TIMESTAMP)
    })
    WorkerLog query(Short type, Long workerId);

}