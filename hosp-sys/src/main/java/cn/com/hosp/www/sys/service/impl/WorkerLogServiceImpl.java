package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.WorkerLog;
import cn.com.hosp.www.dao.mapper.WorkerLogMapper;
import cn.com.hosp.www.sys.service.WorkerLogService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerLogServiceImpl extends BaseServiceImpl<WorkerLogMapper, WorkerLog> implements WorkerLogService {

    @Autowired
    private WorkerLogMapper workerLogMapper;

    @Override
    public WorkerLog queryPosition(Short type, Long workerId) {
        return workerLogMapper.query(type, workerId);
    }
}
