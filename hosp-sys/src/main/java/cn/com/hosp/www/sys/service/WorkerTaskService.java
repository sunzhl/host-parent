package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.dao.entry.WorkerTask;
import cn.com.hosp.www.sys.service.base.BaseService;

public interface WorkerTaskService extends BaseService<WorkerTask> {

    int update(WorkerTask workerTask);


    int resetTodayCount();
}
