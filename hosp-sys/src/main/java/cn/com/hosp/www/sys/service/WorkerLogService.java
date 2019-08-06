package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.dao.entry.WorkerLog;
import cn.com.hosp.www.sys.service.base.BaseService;

public interface WorkerLogService extends BaseService<WorkerLog> {

    WorkerLog queryPosition(Short type, Long workerId);

}
