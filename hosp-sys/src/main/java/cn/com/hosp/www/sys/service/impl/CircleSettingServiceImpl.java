package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.utils.BeanUtils;
import cn.com.hosp.www.dao.dto.CircleSettingDto;
import cn.com.hosp.www.dao.entry.CirclePoints;
import cn.com.hosp.www.dao.entry.CircleSetting;
import cn.com.hosp.www.dao.mapper.CirclePointsMapper;
import cn.com.hosp.www.dao.mapper.CircleSettingMapper;
import cn.com.hosp.www.sys.service.CircleSettingService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import cn.com.hosp.www.sys.web.form.CirclePointsForm;
import cn.com.hosp.www.sys.web.form.CircleSettingForm;
import cn.com.hosp.www.sys.web.form.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CircleSettingServiceImpl extends BaseServiceImpl<CircleSettingMapper, CircleSetting> implements CircleSettingService {


    @Autowired
    private CirclePointsMapper circlePointsMapper;

    @Autowired
    private CircleSettingMapper circleSettingMapper;

    @Override
    @Transactional
    public CircleSetting save(CircleSettingForm circleSettingForm) {
        CircleSetting circleSetting = new CircleSetting();
        BeanUtils.copyProperties(circleSettingForm, circleSetting);
        List<CirclePointsForm> circlePointsForms = circleSettingForm.getCirclePoints();
        CircleSetting setting = super.save(circleSetting);
        List<CirclePoints> circlePoints = circlePointsForms.stream().map(form -> new CirclePoints(setting.getId(), form.getSpaceId(), form.getSpaceName())).collect(Collectors.toList());
        circlePointsMapper.saveBatch(circlePoints);
        return setting;
    }

    @Override
    @Transactional
    public CircleSetting update(CircleSettingForm circleSettingForm) {
        CircleSetting circleSetting = new CircleSetting();
        BeanUtils.copyProperties(circleSettingForm, circleSetting);
        CircleSetting circleSetting1 = super.updateById(circleSetting);
        List<CirclePointsForm> circlePointsForms = circleSettingForm.getCirclePoints();
        if(circlePointsForms != null && circlePointsForms.size() > 0){
            Map<String, List<CirclePointsForm>> listMap = circlePointsForms.stream().collect(Collectors.groupingBy(CirclePointsForm::getType));
            List<CirclePointsForm> addPointsForms = listMap.get("add");
            if(addPointsForms != null && addPointsForms.size() > 0){
                List<CirclePoints> addCirclePoints = addPointsForms.stream().map(addPointsForm -> new CirclePoints(circleSetting.getId(), addPointsForm.getSpaceId(), addPointsForm.getSpaceName()))
                        .collect(Collectors.toList());
                circlePointsMapper.saveBatch(addCirclePoints);
            }
            List<CirclePointsForm> deletePointsForms = listMap.get("del");
            if(deletePointsForms != null && deletePointsForms.size() > 0){
                List<Long> deletePoints = deletePointsForms.stream().map(CirclePointsForm::getId).collect(Collectors.toList());
                circlePointsMapper.deleteBath(deletePoints);
            }
        }
        return circleSetting1;
    }

    @Override
    public Page<CircleSettingDto> queryByPage(PageForm pageForm) {
        long count = circleSettingMapper.queryCount();
        List<CircleSettingDto> circleSettingDtos = circleSettingMapper.queryByPage((pageForm.getPageNum() - 1) * pageForm.getPageSize(), pageForm.getPageSize());
        return Page.with(count, circleSettingDtos, pageForm.getPageNum(), pageForm.getPageSize());
    }
}
