package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.dao.entry.Structures;
import cn.com.hosp.www.sys.service.StructureService;
import cn.com.hosp.www.sys.vo.ResponseData;
import cn.com.hosp.www.sys.vo.ReturnCode;
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
    public ReturnCode save(@RequestBody @Valid Structures structure){
        return structureService.save(structure);
    }


    @GetMapping("/queryAll")
    @ResponseBody
    public ResponseData<List<Structures>> queryAll(){
       return this.query((Structures)null);
    }


    @GetMapping("/querySome")
    @ResponseBody
    public ResponseData<List<Structures>> query(@RequestBody Structures structure){
        Structures structure1 = structure;
        if(structure1 == null){
           structure1 = new Structures();
        }
        List<Structures> structures = structureService.selectAllByParam(structure1);
        ResponseData<List<Structures>> data = new ResponseData();
        data.setData(structures);
        if(structures != null && structures.size() > 0){
           data.setSuccess("查询成功");
        }else{
            data.setSuccess("未查询到记录!");
        }
        return  data;
    }

    @GetMapping("/query/{id}")
    @ResponseBody
    public ResponseData<Structures> query(@PathVariable("id") Long id){
        if(id == null){
            throw new HospException("查询条件不能为空!");
        }
        Structures structures = new Structures();
        structures.setId(id);
        ResponseData<List<Structures>> query = query(structures);
        ResponseData<Structures> result = new ResponseData<>();
        List<Structures> data = query.getData();
        if(data != null && data.size() > 0){
            result.setData(data.get(0));
        }
        result.setReturnCode(query.getReturnCode());
        return result;
    }

}
