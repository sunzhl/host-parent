package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.WorkerTask;
import cn.com.hosp.www.dao.mapper.WorkerTaskMapper;
import cn.com.hosp.www.sys.service.WorkerTaskService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerTaskServiceImpl extends BaseServiceImpl<WorkerTaskMapper, WorkerTask> implements WorkerTaskService {

    @Autowired
    private WorkerTaskMapper workerTaskMapper;

    @Override
    public int update(WorkerTask workerTask) {
        return workerTaskMapper.updateByWorkerId(workerTask);
    }

    @Override
    public int resetTodayCount() {
        return workerTaskMapper.resetTodayCount();
    }


}
