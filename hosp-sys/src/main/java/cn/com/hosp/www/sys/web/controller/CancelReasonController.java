package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.CancelReason;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.web.form.CancelReasonForm;
import cn.com.hosp.www.sys.service.CancelReasonService;
import cn.com.hosp.www.sys.web.form.PageForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public Result save(HttpServletRequest request, @RequestBody CancelReason reason){

        setModify(request, reason);

        return Result.success().withData(cancelReasonService.save(reason));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(HttpServletRequest request, @PathVariable("id") Long id){
        CancelReason reason = new CancelReason();
        reason.setId(id);
        reason.setIsDeleted((short)1);
        return update(request, reason);
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(HttpServletRequest request, @RequestBody CancelReason cancelReason){
        setModify(request, cancelReason);
        return Result.success().withData(cancelReasonService.updateById(cancelReason));
    }


    @GetMapping("/query/{id}")
    @ResponseBody
    public Result query(@PathVariable("id") Long id){

        return Result.success().withData(cancelReasonService.getById(id));
    }


    @GetMapping("/query")
    @ResponseBody
    public Result queryAll(CancelReason cancelReason){
        if(cancelReason == null){
            cancelReason = new CancelReason();
        }
        cancelReason.setIsDeleted((short)0);
        return Result.success().withData(cancelReasonService.listByCondition(cancelReason));
    }

    @GetMapping("/query/{currentPage}/{pageSize}")
    public Result query(@PathVariable("currentPage") Integer currentPage,
                        @PathVariable("pageSize") Integer pageSize,
                        CancelReason cancelReason){
        if(cancelReason == null){
            cancelReason = new CancelReason();
        }
        cancelReason.setIsDeleted((short)0);
        return Result.success().withData(cancelReasonService.listByCondition(cancelReason, new PageForm(currentPage, pageSize)));
    }


    private void setModify(HttpServletRequest request, CancelReason reason){
        Object userInfo = request.getSession().getAttribute("user_info");
        if(userInfo instanceof WorkerInfo){
            WorkerInfo workerInfo = (WorkerInfo) userInfo;
            reason.setModifyId(workerInfo.getId());
            reason.setModifyName(workerInfo.getWorkerName());
        }
    }

}
