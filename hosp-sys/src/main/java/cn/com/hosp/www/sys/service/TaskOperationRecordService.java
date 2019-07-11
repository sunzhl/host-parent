package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.dao.entry.TaskOperationRecord;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.service.base.BaseService;

/**
 * @ClassName TaskOperationRecordService
 * @Description TODO
 * @Author tome
 * @Date 19-7-5 下午4:22
 * @Version 1.0
 */

public interface TaskOperationRecordService extends BaseService<TaskOperationRecord> {


    TaskOperationRecord save(long taskId, long workerId, String remark);

    TaskOperationRecord save(long taskId, WorkerInfo workerInfo, String remark);

}
