package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.dao.entry.SysUsers;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.dao.entry.WorkerTask;
import cn.com.hosp.www.sys.service.UserService;
import cn.com.hosp.www.sys.service.WorkerInfoService;
import cn.com.hosp.www.sys.service.WorkerLogService;
import cn.com.hosp.www.sys.service.WorkerTaskService;
import cn.com.hosp.www.sys.web.form.PageForm;
import cn.com.hosp.www.sys.web.form.UserForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName WorkerInfoController
 * @Description TODO
 * @Author tome
 * @Date 19-7-11 下午6:08
 * @Version 1.0
 */

@RestController
@RequestMapping("/worker")
@Valid
@Slf4j
@Api("运送员操作接口")
public class WorkerInfoController {

    @Autowired
    private WorkerInfoService workerInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private WorkerLogService workerLogService;

    @Autowired
    private WorkerTaskService workerTaskService;



    @ApiOperation("新增运送员")
    @ApiImplicitParam(value = "运送员信息", name = "userForm", required = true, dataTypeClass = UserForm.class)
    @PostMapping("/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Result save(@Valid  @RequestBody UserForm userForm) {
        return Result.success().withData(workerInfoService.save(userForm));
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") Long id){
        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setId(id);
        workerInfo.setIsDeleted((short)1);
       return update(workerInfo);
    }


    @PutMapping("/update")
    public Result update(@RequestBody WorkerInfo workerInfo){
        return Result.success().withData(workerInfoService.updateById(workerInfo));
    }

    @GetMapping("/query/{id}")
    public Result queryById(@PathVariable("id") Long id){
        WorkerInfo workerInfo = workerInfoService.getById(id);
        if(workerInfo == null){
           return Result.error("未查询到数据");
        }
       /* SysUsers sysUsers = userService.getById(workerInfo.getUserId());
        Map<String, Object> objMap = CollectionUtils.newMap();
        objMap.put("worker", workerInfo);
        objMap.put("user", sysUsers);*/
        return Result.success().withData(workerInfo);
    }


    @GetMapping("/queryByPage/{currentPage}/{pageSize}")
    @ResponseBody
    public Result query(@PathVariable("currentPage") Integer currentPage,
                        @PathVariable("pageSize") Integer pageSize,
                        WorkerInfo workerInfo){
        Map<String, Object> params = CollectionUtils.newMap();
        if (workerInfo != null && null != workerInfo.getState()){
            params.put("states", Arrays.asList(workerInfo.getState()));
        }else{
            params.put("states", Arrays.asList((short)0, (short)1));

        }
        workerInfo.setIsDeleted((short)0);
        params.put("start", (currentPage - 1) * pageSize);
        params.put("pageSize", pageSize);
        params.put("currentPage", currentPage);
        Page<WorkerInfo> workerInfoPage = workerInfoService.queryByPage(params);
        return Result.success().withData(workerInfoPage);
    }

    @GetMapping("/query")
    @ResponseBody
    public Result query(WorkerInfo workerInfo){
        if(workerInfo == null){
            workerInfo = new WorkerInfo();
        }
        workerInfo.setIsDeleted((short)0);
        List<WorkerInfo> workerInfos = workerInfoService.listByCondition(workerInfo);
        List<WorkerInfo> collect = workerInfos.stream().filter(workerInfo1 -> workerInfo1.getState() != (short) 2).collect(Collectors.toList());
        return Result.success().withData(collect);
    }

    @GetMapping("/queryAll/{proId}")
    @ResponseBody
    public Result query(@PathVariable("proId") Long proId){
       return Result.success().withData(workerInfoService.query(proId));
    }


    @GetMapping("/queryInfo/{id}")
    @ResponseBody
    public Result queryInfo(@PathVariable("id") Long id){
        WorkerTask workerTask = new WorkerTask();
        workerTask.setWorkerId(id);
        return Result.success().withData(workerTaskService.getByCondition(workerTask));
    }

}
