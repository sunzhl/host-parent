package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.common.utils.UUIDUtils;
import cn.com.hosp.www.dao.entry.CancelReason;
import cn.com.hosp.www.dao.entry.SpaceInfo;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.service.SpaceInfoService;
import cn.com.hosp.www.sys.web.form.PageForm;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @ClassName SpaceController
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 下午8:04
 * @Version 1.0
 */

@RestController
@RequestMapping("/space")
@Log4j2
public class SpaceController {

    @Autowired
    private SpaceInfoService spaceInfoService;


    @PostMapping("/add")
    @ResponseBody
    public Result save(HttpServletRequest request, @RequestBody SpaceInfo spaceInfo){
       spaceInfo.setSpaceCode(UUIDUtils.uuid());
       setModify(request, spaceInfo);
       return Result.success().withData(spaceInfoService.save(spaceInfo));
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(HttpServletRequest request, @RequestBody SpaceInfo spaceInfo){
        setModify(request,spaceInfo);
      return Result.success().withData(spaceInfoService.updateById(spaceInfo));
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(HttpServletRequest request, @PathVariable("id") long id){
         SpaceInfo info = new SpaceInfo();
         info.setId(id);
         info.setIsDeleted((short)1);
         return update(request, info);
    }

    @GetMapping("/query/{id}")
    @ResponseBody
    public Result query(@PathVariable("id") Long id){
        return Result.success().withData(spaceInfoService.getById(id));
    }

    @GetMapping("/queryPage/{currentPage}")
    @ResponseBody
    public Result query(@PathVariable("currentPage") int currentPage,
                        @RequestParam(required = false) Integer pageSize){

        SpaceInfo info = new SpaceInfo();
//        info.setProId(proId);
        info.setIsDeleted((short)0);
        PageForm form = new PageForm(currentPage, pageSize);
        return Result.success().withData(spaceInfoService.listByCondition(info, form));
    }


    @GetMapping("/query")
    @ResponseBody
    public Result query(SpaceInfo spaceInfo){
        SpaceInfo info = spaceInfo;
        if(info == null){
            info = new SpaceInfo();
        }
        info.setIsDeleted((short)0);
        return Result.success().withData(spaceInfoService.listByCondition(info));
    }


    private void setModify(HttpServletRequest request, SpaceInfo spaceInfo){
        Object userInfo = request.getSession().getAttribute("user_info");
        if(userInfo instanceof WorkerInfo){
            WorkerInfo workerInfo = (WorkerInfo) userInfo;
            spaceInfo.setModifyId(workerInfo.getId());
            spaceInfo.setModifyName(workerInfo.getWorkerName());
            spaceInfo.setModifyTime(LocalDateTime.now());
        }
    }

}
