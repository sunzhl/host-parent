package cn.com.hosp.www.dao.mapper;


import cn.com.hosp.www.dao.dto.TransportPatient;
import cn.com.hosp.www.dao.entry.TransportTask;
import cn.com.hosp.www.dao.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TransportTaskMapper extends BaseMapper<TransportTask> {

//
//    @Select("select t.id, t.task_name, t.create_name, t.create_time,\n" +
//            "  t.task_type_name, t.set_out_place_name, t.destination_name,\n" +
//            "  t.plan_start_time, t.finish_time, t.book_time, t.worker_name, t.worker_id,\n" +
//            "  t.priority, t.state, t.pro_id, t.pro_number,t.pro_name, t.tool_name, \n" +
//            "  p.patient_name, p.id as pid, p.age, p.bed_number, p.number,p.sex\n" +
//            "from transport_task as t\n" +
//            "left join patient_info as p on t.id = p.task_id\n" +
//            "where t.pro_id = #{id, jdbcType=BIGINT} and t.state in ();")

    List<TransportPatient> queryByPage(Map<String, Object> params);


    int queryCount(Map<String, Object> params);

}