package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.dao.entry.TransportTimeCode;
import cn.com.hosp.www.sys.service.TransportTimeCodeService;
import cn.com.hosp.www.sys.web.form.PageForm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
public class TransportTimeCodeController extends BaseController<TransportTimeCode>{

    @Autowired
    private TransportTimeCodeService service;

    @PostMapping("/add")
    @ResponseBody
    public Result save(HttpServletRequest request, @RequestBody TransportTimeCode transportTimeCode){

        setModify(request, transportTimeCode);

        return Result.success().withData(service.save(transportTimeCode));
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(HttpServletRequest request, @RequestBody TransportTimeCode transportTimeCode){
        setModify(request, transportTimeCode);
        return Result.success().withData(service.updateById(transportTimeCode));
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(HttpServletRequest request, @PathVariable("id") long id){
        TransportTimeCode transportTimeCode = new TransportTimeCode();
        transportTimeCode.setIsDeleted((short)1);
        transportTimeCode.setId(id);
        return update(request, transportTimeCode);
    }

    @GetMapping("/query/{id}")
    @ResponseBody
    public Result queryById(@PathVariable("id") Long id){
        return Result.success().withData(service.getById(id));
    }

    @GetMapping("/query/{currentPage}/{pageSize}")
    @ResponseBody
    public Result query(@PathVariable("currentPage") Integer currentPage,
                        @PathVariable("pageSize") Integer pageSize,
                        TransportTimeCode transportTimeCode){
        TransportTimeCode info = transportTimeCode;
        if(info == null){
            info = new TransportTimeCode();
        }
        info.setIsDeleted((short)0);
        return Result.success().withData(service.listByCondition(info, new PageForm(currentPage, pageSize)));
    }


    @GetMapping("/queryAll")
    @ResponseBody
    public Result queryAll(TransportTimeCode transportTimeCode){
        if (transportTimeCode == null){
            transportTimeCode = new TransportTimeCode();
        }
        transportTimeCode.setIsDeleted((short)0);
        return Result.success().withData(service.listByCondition(transportTimeCode));
    }

}
