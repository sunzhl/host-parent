package cn.com.hosp.www.sys.security.handler;

import cn.com.hosp.www.common.utils.UUIDUtils;
import cn.com.hosp.www.dao.entry.SysUsers;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.dao.entry.WorkerLog;
import cn.com.hosp.www.dao.entry.WorkerTask;
import cn.com.hosp.www.dao.mapper.SysUsersMapper;
import cn.com.hosp.www.sys.security.entity.HospUserDetails;
import cn.com.hosp.www.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

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
    private WorkerInfoService workerInfoService;

    @Autowired
    private MedicalCareService medicalCareService;

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private WorkerLogService workerLogService;

    @Autowired
    private WorkerTaskService workerTaskService;

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
            //userService.updateStateByUserName(workerInfo);
            WorkerInfo byCondition = workerInfoService.getByCondition(workerInfo);
            if(null != byCondition){
                workerInfo.setState((short)1); //在线
                workerInfo.setId(byCondition.getId());
                workerInfoService.updateById(workerInfo);
                SysUsers user = userDetails.getUser();
                user.setState((short)1);
                sysUsersMapper.updateByPrimaryKeySelective(user);
                userDetails.setWorkerInfo(byCondition);
                saveLog(byCondition);

                WorkerTask task = new WorkerTask();
                task.setWorkerId(byCondition.getId());
                task.setLastLoginTime(LocalDateTime.now());
                workerTaskService.update(task);
                request.getSession().setAttribute("user_info", byCondition);
            }

        }
        response.sendRedirect("/task/home");
    }


    private void saveLog(WorkerInfo workerInfo){
        WorkerLog log = new WorkerLog();
        log.setLogNumber(UUIDUtils.uuid());
        log.setLogType((short)0);
        log.setWorkerId(workerInfo.getId());
        log.setWorkerName(workerInfo.getWorkerName());
        workerLogService.save(log);
    }
}
