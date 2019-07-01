package cn.com.hosp.www.dao.mapper;

import cn.com.hosp.www.dao.entry.Projects;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProjectsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Projects record);

    int insertSelective(Projects record);

    Projects selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);

    List<Projects> queryAll();

    List<Projects> queryByParam(Projects projects);

}