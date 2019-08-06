package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;

import cn.com.hosp.www.dao.entry.WorkTools;
import cn.com.hosp.www.sys.service.WorkToolService;
import cn.com.hosp.www.sys.web.form.PageForm;
import cn.com.hosp.www.sys.web.form.WorkToolForm;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
@Api("运送工具接口")
public class WorkToolController {

    @Autowired
    private WorkToolService workToolService;

    @ApiOperation(value = "新增运送工具")
    //@ApiImplicitParam(name = "workToolForm", value = "运送工具对象", required = true, dataType = "WorkToolForm", dataTypeClass = WorkToolForm.class)
    @PostMapping("/add")
    @ResponseBody
    public Result save(@RequestBody @Valid
                       @ApiParam(value = "运送工具对象", name = "workToolForm", required = true)
                                   WorkToolForm workToolForm){
        WorkTools workTools = new WorkTools();
        workTools.setToolName(workToolForm.getToolName());
        workTools.setProId(workToolForm.getProId());
        workTools.setProName(workToolForm.getProName());
        workTools.setToolCode(workToolForm.getToolCode());
        ///workTools.setToolCode(UUIDUtils.uuid());
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

    @ApiOperation(value = "运送工具分页查询借口", notes = "默认每页显示20条")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "proId", value = "项目ID", required = true, dataType = "java.lang.Long", paramType = "path"),
            @ApiImplicitParam(name = "currentPage", value = "当前页", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query")
     }
    )
    @GetMapping("/queryPage/{currentPage}")
    @ResponseBody
    public Result query(@PathVariable("currentPage") Integer currentPage,
                        @RequestParam(required = false) Integer pageSize){
        WorkTools info = new WorkTools();
        PageForm form = new PageForm();
        form.setPageNum(currentPage);
        form.setPageSize(pageSize);
        return Result.success().withData(workToolService.listByCondition(info, form));
    }


    @GetMapping("/query")
    @ResponseBody
    public Result query(WorkTools tools){
        if(tools == null){
            tools = new WorkTools();
        }
        return Result.success().withData(workToolService.listByCondition(tools));
    }


    @GetMapping("/query/{id}")
    @ResponseBody
    public Result query(@PathVariable("id") Long id){
        return Result.success().withData(workToolService.getById(id));
    }


}
