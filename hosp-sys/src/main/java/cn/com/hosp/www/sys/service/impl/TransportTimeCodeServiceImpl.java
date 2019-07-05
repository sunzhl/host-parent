package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.TransportTimeCode;
import cn.com.hosp.www.dao.mapper.TransportTimeCodeMapper;
import cn.com.hosp.www.sys.service.TransportTimeCodeService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName TransportTimeCodeServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 下午8:39
 * @Version 1.0
 */

@Service
public class TransportTimeCodeServiceImpl extends BaseServiceImpl<TransportTimeCodeMapper, TransportTimeCode>
                                          implements TransportTimeCodeService {
}
