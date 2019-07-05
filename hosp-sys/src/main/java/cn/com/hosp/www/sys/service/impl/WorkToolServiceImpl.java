package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.WorkTools;
import cn.com.hosp.www.dao.mapper.WorkToolsMapper;
import cn.com.hosp.www.sys.service.WorkToolService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName WorkToolServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 下午8:18
 * @Version 1.0
 */

@Service
public class WorkToolServiceImpl extends BaseServiceImpl<WorkToolsMapper, WorkTools> implements WorkToolService {
}
