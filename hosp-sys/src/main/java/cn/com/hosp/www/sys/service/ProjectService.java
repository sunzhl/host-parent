package cn.com.hosp.www.sys.service;

import cn.com.hosp.www.dao.entry.Projects;
import cn.com.hosp.www.sys.vo.ReturnCode;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName ProjectService
 * @Description 所属项目 管理类
 * @Author tome
 * @Date 19-6-27 下午7:07
 * @Version 1.0
 */

public interface ProjectService {

    ReturnCode save(@NotNull Projects project);

    List<Projects> queryAll();

    List<Projects> queryByParam(@NotNull Projects projects);

    Projects queryById(@NotNull Long id);




}
