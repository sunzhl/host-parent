package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.dao.entry.SpaceInfo;
import cn.com.hosp.www.dao.entry.WorkTools;
import cn.com.hosp.www.sys.service.WorkToolService;
import cn.com.hosp.www.sys.web.form.PageForm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName WorkToolController
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 下午8:21
 * @Version 1.0
 */

@RestController
@RequestMapping("/tool")
@Log4j2
public class WorkToolController {

    @Autowired
    private WorkToolService workToolService;

    @PostMapping("/add")
    @ResponseBody
    public Result save(@RequestBody WorkTools workTools){

        return Result.success().withData(workToolService.save(workTools));
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(@RequestBody WorkTools workTools){
        return Result.success().withData(workToolService.updateById(workTools));
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") long id){

        return Result.success().withData(workToolService.deleteById(id));
    }

    @GetMapping("/query/{proId}")
    @ResponseBody
    public Result query(@PathVariable("proId") long proId, @RequestBody PageForm form){
        WorkTools info = new WorkTools();
        info.setProId(proId);
        Long aLong = workToolService.countByCondition(info);
        Map<String, Object> res = CollectionUtils.newMap();
        if(aLong != null && aLong > 0){
            res.put("list", workToolService.listByCondition(info, form));
        }
        res.put("total", aLong);
        return Result.success().withData(res);
    }
}
