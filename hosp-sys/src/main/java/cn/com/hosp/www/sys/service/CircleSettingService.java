package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.dao.dto.CircleSettingDto;
import cn.com.hosp.www.dao.entry.CircleSetting;
import cn.com.hosp.www.sys.service.base.BaseService;
import cn.com.hosp.www.sys.web.form.CircleSettingForm;
import cn.com.hosp.www.sys.web.form.PageForm;

public interface CircleSettingService extends BaseService<CircleSetting> {


    CircleSetting save(CircleSettingForm circleSetting);

    CircleSetting update(CircleSettingForm circleSettingForm);

    Page<CircleSettingDto> queryByPage(PageForm pageForm);


}
