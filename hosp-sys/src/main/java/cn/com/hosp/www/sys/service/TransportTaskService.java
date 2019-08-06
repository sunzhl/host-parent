package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.dto.TransportPatient;
import cn.com.hosp.www.dao.entry.TransportTask;
import cn.com.hosp.www.sys.service.base.BaseService;
import cn.com.hosp.www.sys.vo.TransportTaskVo;
import cn.com.hosp.www.sys.web.form.TaskForm;

import java.util.Map;

/**
 * @ClassName TransportTaskService
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 下午5:27
 * @Version 1.0
 */

public interface TransportTaskService extends BaseService<TransportTask> {


    long save(TaskForm form);

    long update(TaskForm form);

    Page<TransportPatient> queryByPage(Map<String, Object> param);


    /**
     * 领取或者分派任务
     * @param id  任务ID
     * @param uid 分配者ID 如果领取此值为0
     * @param rid 接受者ID,领取这ID
     * @param getType 类型 1-分派，2-领取
     * @return
     */
    Result assignOrObtain(long id, long uid, long rid, short getType);


    TransportTaskVo query(Long id);



}
