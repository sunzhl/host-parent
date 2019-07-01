package cn.com.hosp.www.sys.service;


import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.service.base.BaseService;
import cn.com.hosp.www.sys.web.form.UserForm;

public interface UserService extends BaseService<WorkerInfo> {


    WorkerInfo save(UserForm userForm);


}
