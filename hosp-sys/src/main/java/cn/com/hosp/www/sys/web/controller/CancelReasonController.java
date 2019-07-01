package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.CancelReason;
import cn.com.hosp.www.sys.web.form.CancelReasonForm;
import cn.com.hosp.www.sys.service.CancelReasonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CancelReasonController
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午11:10
 * @Version 1.0
 */

@RestController
@RequestMapping("/cancel")
public class CancelReasonController {

    @Autowired
    private CancelReasonService cancelReasonService;

    @PostMapping("/add")
    @ResponseBody
    public Result save(@RequestBody CancelReasonForm form){
        CancelReason reason = new CancelReason();
        BeanUtils.copyProperties(form, reason);
        return Result.success().withData(cancelReasonService.save(reason));
    }


    @GetMapping("/queryAll")
    @ResponseBody
    public Result queryAll(){
        return Result.success().withData(cancelReasonService.listAll());
    }

    @GetMapping("/queryByProId/{id}")
    @ResponseBody
    public Result queryByProId(@PathVariable("id") Long id){
        CancelReason reason = new CancelReason();
        reason.setProId(id);
        return Result.success().withData(cancelReasonService.listByCondition(reason));
    }


}
