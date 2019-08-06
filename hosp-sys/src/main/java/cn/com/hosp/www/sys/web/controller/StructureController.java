package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.SpaceInfo;
import cn.com.hosp.www.dao.entry.Structures;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.service.StructureService;
import cn.com.hosp.www.sys.vo.ResponseData;
import cn.com.hosp.www.sys.vo.ReturnCode;
import cn.com.hosp.www.sys.web.form.PageForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
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
public class StructureController extends BaseController<Structures>{
    private static final Logger LOGGER = LoggerFactory.getLogger(StructureController.class);

    @Autowired
    private StructureService structureService;

    @PostMapping("/add")
    @ResponseBody
    public Result save(HttpServletRequest request, @RequestBody @Valid Structures structure){
        setModify(request, structure);
        return Result.success().withData(structureService.save(structure));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(HttpServletRequest request, @PathVariable("id") Long id){

          Structures structures = new Structures();
          structures.setId(id);
          structures.setIsDeleted((short)1);
          return update(request, structures);
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(HttpServletRequest request, @RequestBody Structures structures){
        setModify(request, structures);
        return Result.success().withData(structureService.updateById(structures));
    }

    @GetMapping("/queryByPage/{currentPage}")
    @ResponseBody
    public Result queryAll(@PathVariable("currentPage") int currentPage,
                           @RequestParam(required = false) Integer pageSize){
        PageForm pageForm = new PageForm();
        pageForm.setPageNum(currentPage);
        pageForm.setPageSize(pageSize);
        Structures structures = new Structures();
        structures.setIsDeleted((short)0);
        return Result.success().withData(structureService.listByCondition(structures, pageForm));
    }


    @GetMapping("/querySome")
    @ResponseBody
    public Result query(Structures structure){
        Structures structure1 = structure;
        if(structure1 == null){
           structure1 = new Structures();
        }
        structure1.setIsDeleted((short)0);
        List<Structures> structures = structureService.selectAllByParam(structure1);
        return Result.success().withData(structures);
    }

    @GetMapping("/query/{id}")
    @ResponseBody
    public Result query(@PathVariable("id") Long id){
        return Result.success().withData(structureService.getById(id));
    }

}
