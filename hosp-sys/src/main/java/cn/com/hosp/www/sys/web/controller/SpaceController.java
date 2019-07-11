package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.common.utils.UUIDUtils;
import cn.com.hosp.www.dao.entry.SpaceInfo;
import cn.com.hosp.www.sys.service.SpaceInfoService;
import cn.com.hosp.www.sys.web.form.PageForm;
import jdk.nashorn.internal.objects.annotations.Getter;
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
       spaceInfo.setSpaceCode(UUIDUtils.uuid());
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

    @GetMapping("/queryPage/{currentPage}")
    @ResponseBody
    public Result query(@PathVariable("currentPage") int currentPage,
                        @RequestParam(required = false) Integer pageSize){

        SpaceInfo info = new SpaceInfo();
//        info.setProId(proId);
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
        return Result.success().withData(spaceInfoService.listByCondition(info));
    }

}
