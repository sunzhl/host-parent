package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.SpaceInfo;
import cn.com.hosp.www.dao.mapper.SpaceInfoMapper;
import cn.com.hosp.www.sys.service.SpaceInfoService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName SpaceInfoServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 下午8:00
 * @Version 1.0
 */

@Service
public class SpaceInfoServiceImpl extends BaseServiceImpl<SpaceInfoMapper, SpaceInfo> implements SpaceInfoService {
}
