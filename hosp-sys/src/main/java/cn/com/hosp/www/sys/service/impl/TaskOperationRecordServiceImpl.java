package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.utils.UUIDUtils;
import cn.com.hosp.www.dao.entry.TaskOperationRecord;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.dao.mapper.TaskOperationRecordMapper;
import cn.com.hosp.www.dao.mapper.WorkerInfoMapper;
import cn.com.hosp.www.sys.service.TaskOperationRecordService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TaskOperationRecordServiceimpl
 * @Description TODO
 * @Author tome
 * @Date 19-7-5 下午4:23
 * @Version 1.0
 */

@Service
public class TaskOperationRecordServiceImpl extends BaseServiceImpl<TaskOperationRecordMapper, TaskOperationRecord>
                                            implements TaskOperationRecordService {


    @Autowired
    private WorkerInfoMapper workerInfoMapper;


    @Override
    public TaskOperationRecord save(long taskId, long workerId, String remark) {
        return save(taskId, workerInfoMapper.selectByPrimaryKey(workerId), remark);
    }

    @Override
    public TaskOperationRecord save(long taskId, WorkerInfo workerInfo, String remark) {
        TaskOperationRecord record = new TaskOperationRecord();
        record.setTaskId(taskId);
        record.setOperationId(workerInfo.getId());
        record.setOperationMan(workerInfo.getWorkerName());
        record.setRecNumber(UUIDUtils.uuid());
        record.setRemark(remark);
        return super.save(record);
    }
}
