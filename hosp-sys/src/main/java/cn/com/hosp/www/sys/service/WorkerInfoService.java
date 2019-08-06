package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.service.base.BaseService;
import cn.com.hosp.www.sys.vo.WorkerInfoVo;
import cn.com.hosp.www.sys.web.form.UserForm;

import java.util.Map;

/**
 * @ClassName WorkerInfoService
 * @Description TODO
 * @Author tome
 * @Date 19-7-11 下午5:39
 * @Version 1.0
 */

public interface WorkerInfoService extends BaseService<WorkerInfo> {

     WorkerInfo save(UserForm userForm);


     WorkerInfoVo query(Long proId);

     Page<WorkerInfo> queryByPage(Map<String, Object> param);

}
