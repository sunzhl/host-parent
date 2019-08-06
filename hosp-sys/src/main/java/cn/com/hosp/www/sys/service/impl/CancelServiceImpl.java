package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.dao.entry.CancelReason;
import cn.com.hosp.www.dao.entry.Projects;
import cn.com.hosp.www.dao.mapper.CancelReasonMapper;
import cn.com.hosp.www.dao.mapper.ProjectsMapper;
import cn.com.hosp.www.sys.service.CancelReasonService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CancelServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午10:57
 * @Version 1.0
 */

@Service
public class CancelServiceImpl extends BaseServiceImpl<CancelReasonMapper, CancelReason> implements CancelReasonService {

    @Override
    public CancelReason save(CancelReason form) {

        return super.save(form);
    }
}
