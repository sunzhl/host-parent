package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName LoginController
 * @Description TODO
 * @Author tome
 * @Date 19-7-9 上午10:30
 * @Version 1.0
 */

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(ModelMap model){
        model.put("token", UUIDUtils.uuid());
        return "/login";
    }

    @GetMapping("/init")
    public String initialization(HttpServletRequest request, ModelMap model){
        model.put("userInfo", request.getSession().getAttribute("user_info"));
        return "/init/initialization";
    }

}
