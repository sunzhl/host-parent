package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.TaskType;
import cn.com.hosp.www.dao.mapper.TaskTypeMapper;
import cn.com.hosp.www.sys.service.TaskTypeService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName TaskTypeServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 下午8:19
 * @Version 1.0
 */

@Service
public class TaskTypeServiceImpl extends BaseServiceImpl<TaskTypeMapper, TaskType> implements TaskTypeService {
}
