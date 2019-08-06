package cn.com.hosp.www.sys.web.controller;


import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.CancelReason;
import cn.com.hosp.www.dao.entry.DelayReason;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.service.DelayReasonService;
import cn.com.hosp.www.sys.web.form.PageForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("delay")
@Slf4j
public class DelayReasonController {

    @Autowired
    private DelayReasonService delayReasonService;

    @PostMapping("/add")
    @ResponseBody
    public Result save(HttpServletRequest request, @RequestBody DelayReason delayReason){
         setModify(request, delayReason);
        return Result.success().withData(delayReasonService.save(delayReason));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(HttpServletRequest request, @PathVariable("id") Long id){
        DelayReason reason = new DelayReason();
        reason.setId(id);
        reason.setIsDeleted((short)1);
        return update(request, reason);
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(HttpServletRequest request, @RequestBody DelayReason delayReason){
        setModify(request, delayReason);
        delayReason.setCreateTime(new Date());
        return Result.success().withData(delayReasonService.updateById(delayReason));
    }


    @GetMapping("/query")
    @ResponseBody
    public Result queryAll(DelayReason delayReason){
        if(delayReason == null){
           delayReason = new DelayReason();
        }
        delayReason.setIsDeleted((short)0);
        return Result.success().withData(delayReasonService.listByCondition(delayReason));
    }

    @GetMapping("/query/{id}")
    public Result query(@PathVariable("id") Long id){

        return Result.success().withData(delayReasonService.getById(id));
    }

    @GetMapping("/query/{currentPage}/{pageSize}")
    public Result query(@PathVariable("currentPage") Integer currentPage,
                        @PathVariable("pageSize") Integer pageSize,
                        DelayReason delayReason){
            if(delayReason == null){
                delayReason = new DelayReason();
            }
            delayReason.setIsDeleted((short)0);
        Page<DelayReason> page = delayReasonService.listByCondition(delayReason, new PageForm(currentPage, pageSize));
        return Result.success().withData(page);
    }



    private void setModify(HttpServletRequest request, DelayReason reason){
        Object userInfo = request.getSession().getAttribute("user_info");
        if(userInfo instanceof WorkerInfo){
            WorkerInfo workerInfo = (WorkerInfo) userInfo;
            reason.setModifyId(workerInfo.getId());
            reason.setModifyName(workerInfo.getWorkerName());
        }
    }
}
