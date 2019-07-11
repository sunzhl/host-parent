package cn.com.hosp.www.sys.security.handler;

import cn.com.hosp.www.dao.entry.SysUsers;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.dao.mapper.SysUsersMapper;
import cn.com.hosp.www.sys.security.entity.HospUserDetails;
import cn.com.hosp.www.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginSuccessHandler
 * @Description 登录成功后的处理类
 * @Author tome
 * @Date 19-7-8 下午1:28
 * @Version 1.0
 */

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object details = authentication.getPrincipal();
        if(details instanceof HospUserDetails){
            HospUserDetails userDetails = (HospUserDetails) details;
            String username = userDetails.getUsername();
            WorkerInfo workerInfo = new WorkerInfo();
            if(userDetails.getType() == HospUserDetails.MOBLIE){
                workerInfo.setMobile(username);
            }else{
                workerInfo.setWorkerNumber(username);
            }
            workerInfo.setState((short)1); //在线
            //userService.updateStateByUserName(workerInfo);
            WorkerInfo byCondition = userService.getByCondition(workerInfo);
            workerInfo.setId(byCondition.getId());
            userService.updateById(workerInfo);
            SysUsers user = userDetails.getUser();
            user.setState((short)1);
            sysUsersMapper.updateByPrimaryKeySelective(user);
            userDetails.setWorkerInfo(byCondition);
            request.getSession().setAttribute("user_info", byCondition);
        }
        response.sendRedirect("/task/home");
    }
}
