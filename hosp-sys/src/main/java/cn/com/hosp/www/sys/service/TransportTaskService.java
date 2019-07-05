package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.TransportTask;
import cn.com.hosp.www.sys.service.base.BaseService;
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

    Map<String, Object> queryByPage(Map<String, Object> param);


}
