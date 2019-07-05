package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.dao.entry.TransportTimeCode;
import cn.com.hosp.www.sys.service.TransportTimeCodeService;
import cn.com.hosp.www.sys.web.form.PageForm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName TransportTimeCodeController
 * @Description TODO
 * @Author tome
 * @Date 19-7-4 下午8:41
 * @Version 1.0
 */

@RestController
@RequestMapping("/tcode")
@Log4j2
public class TransportTimeCodeController {

    @Autowired
    private TransportTimeCodeService service;

    @PostMapping("/add")
    @ResponseBody
    public Result save(@RequestBody TransportTimeCode workTools){

        return Result.success().withData(service.save(workTools));
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(@RequestBody TransportTimeCode workTools){
        return Result.success().withData(service.updateById(workTools));
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") long id){

        return Result.success().withData(service.deleteById(id));
    }

    @GetMapping("/query/{proId}")
    @ResponseBody
    public Result query(@PathVariable("proId") long proId, @RequestBody PageForm form){
        TransportTimeCode info = new TransportTimeCode();
        info.setProId(proId);
        Long aLong = service.countByCondition(info);
        Map<String, Object> res = CollectionUtils.newMap();
        if(aLong != null && aLong > 0){
            res.put("list", service.listByCondition(info, form));
        }
        res.put("total", aLong);
        return Result.success().withData(res);
    }

}
