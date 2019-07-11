package cn.com.hosp.www.sys.web.controller;

import cn.com.hosp.www.common.annotation.Log;
import cn.com.hosp.www.common.result.Page;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.common.utils.BeanUtils;
import cn.com.hosp.www.common.utils.CollectionUtils;
import cn.com.hosp.www.common.utils.StringUtils;
import cn.com.hosp.www.dao.entry.TransportTask;
import cn.com.hosp.www.dao.entry.WorkerInfo;
import cn.com.hosp.www.sys.service.TransportTaskService;
import cn.com.hosp.www.sys.web.form.PageForm;
import cn.com.hosp.www.sys.web.form.TaskForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName TransportTaskController
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 下午5:34
 * @Version 1.0
 */

@Controller
@RequestMapping("/task")
@Slf4j
public class TransportTaskController {

    private static Pattern pattern = Pattern.compile("\\d+");

    @Autowired
    private TransportTaskService transportTaskService;

    @PostMapping("/add")
    @ResponseBody
    @Log
    public Result create(@RequestBody TaskForm form){
        transportTaskService.save(form);
        return Result.success();
    }

    /**
     * 修改任务状态
     * @param id 任务编号
     * @param uid 修改者
     * @param state 修改状态
     * @return 返回修改后的对象
     */
    @PutMapping("/changeState/{id}/{uid}/{state}")
    @ResponseBody
    @Log
    public Result updateState(@PathVariable("id") Long id,
                              @PathVariable("uid") long uid,
                              @PathVariable("state") int state,
                              ModelMap modelMap){
        TransportTask task = new TransportTask();
        task.setId(id);
        task.setState((short) state);
        task.setWorkerId(uid);
        TransportTask task1 = transportTaskService.updateById(task);
        log.info("任务{}修改成功，修改人：{}, 修改后的状态： {}", id, uid, state);
        return Result.success();
    }

    /**
     * 任务分派
     * @param id 任务ID
     * @param uid 分配者ID
     * @param rid 接收者ID
     * @return
     */
    @PutMapping("/assign/{id}/{uid}/{rid}")
    @ResponseBody
    @Log
    public Result assign(@PathVariable("id") long id,
                         @PathVariable("uid") long uid,
                         @PathVariable("rid") long rid){
        return transportTaskService.assignOrObtain(id, uid, rid, (short) 1);
    }

    @PutMapping("/obtain/{id}/{uid}")
    @ResponseBody
    public Result obtain(@PathVariable("id") long id,
                         @PathVariable("uid") long uid){
        return transportTaskService.assignOrObtain(id, 0, uid, (short) 2);
    }

    /**
     * 根据项目ID和状态分页查询任务信息
     * @param proId 项目ID
     * @param state  状态, 如果查询所有状态的 传入 -1
     * @param pageForm 分页对象 指定起始页和每页显示条数
     * @return 返回符合条件的记录, 及总条数
     */
    @GetMapping("/query/{proId}/{state}")
    @ResponseBody
    public Result queryByPage(@PathVariable("proId") long proId,
                           @PathVariable("state") int state,
                           @RequestBody PageForm pageForm,
                           ModelMap modelMap){

        TransportTask task = new TransportTask();
        if(state != -1){
            task.setState((short)state);
        }
        task.setProId(proId);
        Map<String, Object> resMap = CollectionUtils.newMap();
        Long aLong = transportTaskService.countByCondition(task);
        resMap.put("totalRow", aLong);
        resMap.put("data", transportTaskService.listByCondition(task, pageForm));
        return Result.success().withData(resMap);
    }

    @GetMapping("/query")
    @ResponseBody
    public Result query(@RequestBody TaskForm taskForm, @RequestBody PageForm pageForm){
        TransportTask task = new TransportTask();
        BeanUtils.copyProperties(taskForm, task);
        return Result.success().withData(transportTaskService.listByCondition(task, pageForm));
    }


    @GetMapping("/queryByState/{proId}/{states}/{currentPage}/{size}")
    public Result queryByPage(@PathVariable("proId") long proId,
                              @PathVariable("states") String states,
                              @PathVariable("currentPage") int page,
                              @PathVariable("size") int size){

        List<Integer> list = null;
        if(StringUtils.isNotBlank(states)){
            String[] arrays = states.split(",");
            list = Stream.of(arrays).map(s -> s.trim())
                                    .filter(s -> StringUtils.isNotBlank(s) && pattern.matcher(s).matches())
                                    .map(array -> Integer.parseInt(array))
                                    .collect(Collectors.toList());
        }
         Map<String, Object> params = CollectionUtils.newMap();
        params.put("states", list != null && list.size() > 0? list: null);
        params.put("start", (page - 1) * size);
        params.put("pageSize", size);
        params.put("proId", proId);
        return Result.success().withData(transportTaskService.queryByPage(params));
    }



    @GetMapping("/home")
    public String home(HttpServletRequest request, ModelMap modelMap){
        TransportTask task = new TransportTask();
        Object userInfo = request.getSession().getAttribute("user_info");
        if(userInfo instanceof WorkerInfo){
           WorkerInfo workerInfo = (WorkerInfo) userInfo;
           task.setProId(workerInfo.getProId());
        }
        task.setProId(1L);
        Long aLong = transportTaskService.countByCondition(task);
        modelMap.put("totalRow", aLong);
        PageForm form = new PageForm();
        form.setPageSize(20);
        form.setPageNum(1);
        Page<TransportTask> taskPage = transportTaskService.listByCondition(task, form);
        modelMap.put("data", taskPage.getList());
        modelMap.put("userInfo", userInfo);
        return "/home";
    }



}
