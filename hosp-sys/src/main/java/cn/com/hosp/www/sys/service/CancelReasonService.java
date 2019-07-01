package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.dao.entry.CancelReason;
import cn.com.hosp.www.sys.service.base.BaseService;

/**
 * @ClassName CancelReasonServer
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午10:15
 * @Version 1.0
 */

public interface CancelReasonService extends BaseService<CancelReason> {

    CancelReason save(CancelReason form);
}
