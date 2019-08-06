package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.CirclePoints;
import cn.com.hosp.www.dao.mapper.CirclePointsMapper;
import cn.com.hosp.www.sys.service.CirclePointsService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CirclePointsServiceImpl extends BaseServiceImpl<CirclePointsMapper, CirclePoints> implements CirclePointsService {
}
