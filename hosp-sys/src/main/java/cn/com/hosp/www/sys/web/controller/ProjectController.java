package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.dao.entry.ProjectUser;
import cn.com.hosp.www.dao.entry.Projects;
import cn.com.hosp.www.sys.service.ProjectService;
import cn.com.hosp.www.sys.service.ProjectUserService;
import cn.com.hosp.www.sys.vo.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProjectController
 * @Description TODO
 * @Author tome
 * @Date 19-6-28 上午10:42
 * @Version 1.0
 */


@Controller
@RequestMapping("/project")
public class ProjectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectUserService projectUserService;

    @PostMapping("/save")
    @ResponseBody
    public ReturnCode add(@RequestBody @Valid Projects projects){
        ReturnCode returnCode = projectService.save(projects);
        return  returnCode;
    }


    @GetMapping("/queryAll")
    @ResponseBody
    public Map<String, Object> queryAll(){
        return this.queryByParam(null);
    }


    @GetMapping("/query/{id}")
    @ResponseBody
    public Map<String, Object> queryById(@PathVariable("id") Long id){
        if(id == null){
           throw new HospException("参数[id]不能为空!");
        }
        Projects projects = projectService.queryById(id);
        ReturnCode code = new ReturnCode();
        if(projects != null){
           code.setMessage("查询成功");
           code.setType(ReturnCode.Type.S.getValue());
        }else{
            code.setType(ReturnCode.Type.E.getValue());
            code.setMessage("未查询到[" + id + "]对应的数据");
        }
        Map<String, Object> result = new HashMap<>();
        result.put("returnCode", code);
        result.put("data", projects);
        return result;
    }


    @GetMapping("/queryOne")
    @ResponseBody
    public Map<String, Object> queryByParam(@RequestBody Projects project){
        if(project == null){
            project = new Projects();
        }
        List<Projects> projects = projectService.queryByParam(project);
        Map<String, Object> result = new HashMap<>();
        ReturnCode returnCode = new ReturnCode();
        if(projects != null && projects.size() > 0){
            returnCode.setMessage("查询成功");
            returnCode.setType(ReturnCode.Type.S.getValue());
            result.put("size", projects.size());
        }else{
            returnCode.setType(ReturnCode.Type.E.getValue());
            returnCode.setMessage("未查询到数据");
            result.put("size", 0);
        }
        result.put("returnCode", returnCode);
        result.put("data", projects);
        return result;
    }


    @GetMapping("/up/{uid}")
    @ResponseBody
    public Result queryProject(@PathVariable("uid") Long uid){
        ProjectUser projectUser = new ProjectUser();
        projectUser.setUserId(uid);
        return Result.success().withData(projectUserService.listByCondition(projectUser));
    }

}
