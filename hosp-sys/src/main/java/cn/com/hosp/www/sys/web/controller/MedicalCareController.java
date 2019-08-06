package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.MedicalCare;
import cn.com.hosp.www.sys.service.MedicalCareService;
import cn.com.hosp.www.sys.web.form.PageForm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName MedicalCareController
 * @Description TODO
 * @Author tome
 * @Date 19-7-11 下午2:52
 * @Version 1.0
 */

@RestController
@RequestMapping("/care")
@Log4j2
public class MedicalCareController {

    @Autowired
    private MedicalCareService careService;

    @PostMapping("/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Result save(@RequestBody MedicalCare medicalCare){
        return Result.success().withData(careService.save(medicalCare));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") Long id){

        MedicalCare medicalCare = new MedicalCare();
        medicalCare.setId(id);
        medicalCare.setIsDeleted((short)1);
        return  update(medicalCare);
    }

    @PutMapping("/update")
    public Result update(@RequestBody MedicalCare medicalCare){

        return Result.success().withData(careService.updateById(medicalCare));
    }

    @GetMapping("/queryByPage/{currentPage}/{pageSize}")
    @ResponseBody
    public Result query(@PathVariable("currentPage") Integer currentPage,
                        @PathVariable("pageSize") Integer pageSize,
                        MedicalCare medicalCare){
        if(medicalCare == null){
            medicalCare = new MedicalCare();
        }
        medicalCare.setIsDeleted((short)0);
        return Result.success()
                .withData(careService.listByCondition(medicalCare, new PageForm(currentPage, pageSize)));
    }


    @GetMapping("/query/{id}")
    @ResponseBody
    public Result query(@PathVariable("id") Long id){
        return Result.success().withData(careService.getById(id));
    }

    @GetMapping("/query")
    @ResponseBody
    public Result query(String username){
        MedicalCare care = new MedicalCare();
        care.setMedicalNumber(username);
        MedicalCare byCondition = careService.getByCondition(care);
        if(byCondition == null){
            return Result.error();
        }
        return Result.success();
    }




}
