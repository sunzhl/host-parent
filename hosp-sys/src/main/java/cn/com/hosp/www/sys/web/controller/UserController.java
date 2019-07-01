package cn.com.hosp.www.sys.web.controller;


import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.sys.service.UserService;
import cn.com.hosp.www.sys.web.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/{type}")
    @ResponseBody
    public Result register(@PathVariable("type") String type, @Valid @RequestBody UserForm userForm){
         if("worker".equals(type)){
            return Result.success().withData(userService.save(userForm));
         }
         return Result.success();
    }


}
