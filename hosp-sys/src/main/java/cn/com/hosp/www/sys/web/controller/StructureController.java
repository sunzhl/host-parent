package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.Structures;
import cn.com.hosp.www.sys.service.StructureService;
import cn.com.hosp.www.sys.vo.ResponseData;
import cn.com.hosp.www.sys.vo.ReturnCode;
import cn.com.hosp.www.sys.web.form.PageForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName StructureController
 * @Description TODO
 * @Author tome
 * @Date 19-6-28 下午5:26
 * @Version 1.0
 */

@Controller
@RequestMapping("/structure")
public class StructureController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StructureController.class);

    @Autowired
    private StructureService structureService;

    @PostMapping("/add")
    @ResponseBody
    public Result save(@RequestBody @Valid Structures structure){
        return Result.success().withData(structureService.save(structure));
    }


    @GetMapping("/queryByPage/{currentPage}")
    @ResponseBody
    public Result queryAll(@PathVariable("currentPage") int currentPage,
                           @RequestParam(required = false) Integer pageSize){
        PageForm pageForm = new PageForm();
        pageForm.setPageNum(currentPage);
        pageForm.setPageSize(pageSize);
        return Result.success().withData(structureService.listByCondition(new Structures(), pageForm));
    }


    @GetMapping("/querySome")
    @ResponseBody
    public Result query(Structures structure){
        Structures structure1 = structure;
        if(structure1 == null){
           structure1 = new Structures();
        }
        List<Structures> structures = structureService.selectAllByParam(structure1);
        return Result.success().withData(structures);
    }

    @GetMapping("/query/{id}")
    @ResponseBody
    public Result query(@PathVariable("id") Long id){
        return Result.success().withData(structureService.getById(id));
    }

}
