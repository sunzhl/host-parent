package cn.com.hosp.www.sys.security.handler;

import cn.com.hosp.www.common.utils.UUIDUtils;
import cn.com.hosp.www.dao.entry.SysUsers;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.dao.entry.WorkerLog;
import cn.com.hosp.www.dao.mapper.SysUsersMapper;
import cn.com.hosp.www.sys.security.entity.HospUserDetails;
import cn.com.hosp.www.sys.service.WorkerInfoService;
import cn.com.hosp.www.sys.service.WorkerLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    @Autowired
    private WorkerInfoService workerInfoService;

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private WorkerLogService workerLogService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object details = authentication.getPrincipal();
        if (details instanceof HospUserDetails) {
            HospUserDetails userDetails = (HospUserDetails) details;
            String username = userDetails.getUsername();
            WorkerInfo workerInfo = new WorkerInfo();
            if (userDetails.getType() == HospUserDetails.MOBLIE) {
                workerInfo.setMobile(username);
            } else {
                workerInfo.setWorkerNumber(username);
            }
            workerInfo.setState((short) 0); //在线
            workerInfo.setId(userDetails.getWorkerInfo().getId());
            workerInfoService.updateById(workerInfo);
            SysUsers user = userDetails.getUser();
            user.setState((short) 0);
            sysUsersMapper.updateByPrimaryKeySelective(user);
            saveLog(userDetails.getWorkerInfo());
            request.getSession().removeAttribute("user_info");
        }

        response.sendRedirect("/login");
    }

    private void saveLog(WorkerInfo workerInfo){
        WorkerLog log = new WorkerLog();
        log.setLogNumber(UUIDUtils.uuid());
        log.setLogType((short)2);
        log.setWorkerId(workerInfo.getId());
        log.setWorkerName(workerInfo.getWorkerName());
        workerLogService.save(log);
    }
}
