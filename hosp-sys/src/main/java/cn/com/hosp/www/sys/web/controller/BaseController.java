package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.dao.entry.WorkerInfo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class BaseController<T> {



    protected void setModify(HttpServletRequest request, T t){
        Object userInfo = request.getSession().getAttribute("user_info");
        if(userInfo instanceof WorkerInfo){
            WorkerInfo workerInfo = (WorkerInfo) userInfo;
            try {

                Field modifyId = t.getClass().getDeclaredField("modifyId");

                modifyId.setAccessible(true);
                modifyId.set(t, workerInfo.getId());

                Field modifyName = t.getClass().getDeclaredField("modifyName");
                modifyName.setAccessible(true);
                modifyName.set(t, workerInfo.getWorkerName());


                Field modifyTime = t.getClass().getDeclaredField("modifyTime");
                modifyTime.setAccessible(true);
                modifyTime.set(t, LocalDateTime.now());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

}
