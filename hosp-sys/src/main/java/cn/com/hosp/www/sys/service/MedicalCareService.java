package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.dao.entry.MedicalCare;
import cn.com.hosp.www.sys.service.base.BaseService;
import cn.com.hosp.www.sys.web.form.UserForm;

/**
 * @ClassName MedicalCareService
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 下午4:34
 * @Version 1.0
 */

public interface MedicalCareService extends BaseService<MedicalCare> {

    MedicalCare save(UserForm form);

}
