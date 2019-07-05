package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.dao.entry.SpaceInfo;
import cn.com.hosp.www.sys.service.SpaceInfoService;
import cn.com.hosp.www.sys.web.form.PageForm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result save(@RequestBody SpaceInfo spaceInfo){

       return Result.success().withData(spaceInfoService.save(spaceInfo));
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(SpaceInfo spaceInfo){
      return Result.success().withData(spaceInfoService.updateById(spaceInfo));
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") long id){

         return Result.success().withData(spaceInfoService.deleteById(id));
    }

    @GetMapping("/query/{proId}")
    @ResponseBody
    public Result query(@PathVariable("proId") long proId, @RequestBody PageForm form){

        SpaceInfo info = new SpaceInfo();
        info.setProId(proId);
        Long aLong = spaceInfoService.countByCondition(info);
        Map<String, Object> res = CollectionUtils.newMap();
        if(aLong != null && aLong > 0){
           res.put("list", spaceInfoService.listByCondition(info, form));
        }
        res.put("total", aLong);
        return Result.success().withData(res);
    }

}
