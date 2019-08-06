package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.dto.CircleSettingDto;
import cn.com.hosp.www.dao.entry.CirclePoints;
import cn.com.hosp.www.dao.entry.CircleSetting;
import cn.com.hosp.www.sys.service.CirclePointsService;
import cn.com.hosp.www.sys.service.CircleSettingService;
import cn.com.hosp.www.sys.web.form.CirclePointsForm;
import cn.com.hosp.www.sys.web.form.CircleSettingForm;
import cn.com.hosp.www.sys.web.form.PageForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/circle")
public class CircleSettingController extends BaseController<CircleSettingForm> {

    @Autowired
    private CircleSettingService circleSettingService;

    @Autowired
    private CirclePointsService circlePointsService;

    @PostMapping("/add")
    @ResponseBody
    public Result save(HttpServletRequest request, @RequestBody CircleSettingForm circleSetting){
        setModify(request, circleSetting);
        return Result.success().withData(circleSettingService.save(circleSetting));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(HttpServletRequest request, @PathVariable("id") Long id){
        CircleSettingForm circleSettingForm = new CircleSettingForm();
        circleSettingForm.setId(id);
        circleSettingForm.setIsDeleted((short)1);
        update(request, circleSettingForm);
        return Result.success();
    }


    @PutMapping("/update")
    @ResponseBody
    public Result update(HttpServletRequest request, @RequestBody CircleSettingForm circleSettingForm){
        setModify(request, circleSettingForm);
        circleSettingService.update(circleSettingForm);
        return Result.success();
    }


    @GetMapping("/queryByPage/{currentPage}/{pageSize}")
    @ResponseBody
    public Result query(@PathVariable("currentPage") Integer currentPage,
                        @PathVariable("pageSize") Integer pageSize,
                        CircleSetting circleSetting){
        if (null == circleSetting){
            circleSetting = new CircleSetting();
        }
        circleSetting.setIsDeleted((short)0);
        Page<CircleSettingDto> page = circleSettingService.queryByPage(new PageForm(currentPage, pageSize));
        return Result.success().withData(page);
    }


    @GetMapping("/query/{id}")
    @ResponseBody
    public Result query(@PathVariable("id") Long id){

        CircleSetting circleSetting = circleSettingService.getById(id);

        CirclePoints circlePoints = new CirclePoints();
        circlePoints.setCircleId(id);
        List<CirclePoints> circlePointsList = circlePointsService.listByCondition(circlePoints);
        CircleSettingForm circleSettingForm = new CircleSettingForm();
        BeanUtils.copyProperties(circleSetting, circleSettingForm);

        if(circlePointsList != null && circlePointsList.size() > 0){
            List<CirclePointsForm> circlePointsForms = circlePointsList.stream().map(circlePoints1 -> {
                CirclePointsForm circlePointsForm = new CirclePointsForm();
                BeanUtils.copyProperties(circlePoints1, circlePointsForm);
                return circlePointsForm;
            }).collect(Collectors.toList());
            circleSettingForm.setCirclePoints(circlePointsForms);
        }

        return Result.success().withData(circleSettingForm);
    }



}
