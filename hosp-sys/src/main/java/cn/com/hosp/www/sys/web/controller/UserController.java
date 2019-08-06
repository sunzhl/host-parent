package cn.com.hosp.www.sys.web.controller;


import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.service.MedicalCareService;
import cn.com.hosp.www.sys.service.UserService;
import cn.com.hosp.www.sys.service.WorkerInfoService;
import cn.com.hosp.www.sys.web.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private WorkerInfoService workerInfoService;

    @PostMapping("/register")
    @ResponseBody
    public Result register(@Valid @RequestBody UserForm userForm){
         return Result.success().withData(workerInfoService.save(userForm));
    }


    @DeleteMapping("/{type}/{id}")
    @ResponseBody
    public Result delete(@PathVariable("type") String type, @PathVariable("id") Long id){


        return Result.success();
    }


    @GetMapping("/query")
    @ResponseBody
    public Result query(WorkerInfo workerInfo){
        if(workerInfo == null){
            workerInfo = new WorkerInfo();
        }
        return Result.success().withData(workerInfoService.listByCondition(workerInfo));
    }


}
