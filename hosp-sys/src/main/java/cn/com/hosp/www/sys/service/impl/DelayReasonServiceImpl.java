package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.DelayReason;
import cn.com.hosp.www.dao.mapper.DelayReasonMapper;
import cn.com.hosp.www.sys.service.DelayReasonService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DelayReasonServiceImpl extends BaseServiceImpl<DelayReasonMapper, DelayReason> implements DelayReasonService {
}
