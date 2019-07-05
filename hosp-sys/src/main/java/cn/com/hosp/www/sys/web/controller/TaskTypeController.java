package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.dao.entry.TaskType;
import cn.com.hosp.www.sys.service.TaskTypeService;
import cn.com.hosp.www.sys.web.form.PageForm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName TaskTypeController
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 下午8:20
 * @Version 1.0
 */

@RestController
@RequestMapping("/type")
@Log4j2
public class TaskTypeController {

    @Autowired
    private TaskTypeService taskTypeService;

    @PostMapping("/add")
    @ResponseBody
    public Result save(@RequestBody TaskType taskType){

        return Result.success().withData(taskTypeService.save(taskType));
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(@RequestBody TaskType taskType){
        return Result.success().withData(taskTypeService.updateById(taskType));
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") long id){

        return Result.success().withData(taskTypeService.deleteById(id));
    }

    @GetMapping("/query/{proId}")
    @ResponseBody
    public Result query(@PathVariable("proId") long proId, @RequestBody PageForm form){
        TaskType info = new TaskType();
        info.setProId(proId);
        Long aLong = taskTypeService.countByCondition(info);
        Map<String, Object> res = CollectionUtils.newMap();
        if(aLong != null && aLong > 0){
            res.put("list", taskTypeService.listByCondition(info, form));
        }
        res.put("total", aLong);
        return Result.success().withData(res);
    }
}
