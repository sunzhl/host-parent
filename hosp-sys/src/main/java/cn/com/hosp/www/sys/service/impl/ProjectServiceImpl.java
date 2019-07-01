package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.Projects;
import cn.com.hosp.www.dao.mapper.ProjectsMapper;
import cn.com.hosp.www.sys.service.ProjectService;
import cn.com.hosp.www.sys.vo.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName ProjectServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-6-27 下午7:09
 * @Version 1.0
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectsMapper projectsMapper;

    @Override
    @Transactional
    public ReturnCode save(Projects project) {
         ReturnCode returnCode = new ReturnCode();
        if(project != null){
            int i = projectsMapper.insertSelective(project);
            if(i == 1){
               returnCode.setType(ReturnCode.Type.S.getValue());
               returnCode.setMessage("插入成功!");
            }else{
                returnCode.setMessage("插入失败!");
                returnCode.setType(ReturnCode.Type.E.getValue());
            }
        }
        return returnCode;
    }

    @Override
    public List<Projects> queryAll() {
        return projectsMapper.queryAll();
    }

    @Override
    public List<Projects> queryByParam(@NotNull Projects projects) {

        List<Projects> projects1 = projectsMapper.queryByParam(projects);

        return projects1;
    }

    @Override
    public Projects queryById(Long id) {
        return projectsMapper.selectByPrimaryKey(id);
    }
}
