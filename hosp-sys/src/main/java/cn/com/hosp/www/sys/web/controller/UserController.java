package cn.com.hosp.www.sys.web.controller;


import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.sys.service.MedicalCareService;
import cn.com.hosp.www.sys.service.UserService;
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
    private UserService userService;

    @Autowired
    private MedicalCareService medicalCareService;

    @PostMapping("/register/{type}")
    @ResponseBody
    public Result register(@PathVariable("type") String type, @Valid @RequestBody UserForm userForm){
         log.info("传入的类型为：{}", type);
         if("worker".equals(type)){
            return Result.success().withData(userService.save(userForm));
         }else if("care".equals(type)){
             return Result.success().withData(medicalCareService.save(userForm));
         }
         return Result.serverError("传入的类型[" + type + "]不正确");
    }


    @DeleteMapping("/{type}/{id}")
    @ResponseBody
    public Result delete(@PathVariable("type") String type, @PathVariable("id") Long id){


        return Result.success();
    }



}
