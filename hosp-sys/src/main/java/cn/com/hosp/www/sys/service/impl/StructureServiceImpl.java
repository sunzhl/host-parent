package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.common.utils.UUIDUtils;
import cn.com.hosp.www.dao.entry.Projects;
import cn.com.hosp.www.dao.entry.Structures;
import cn.com.hosp.www.dao.mapper.ProjectsMapper;
import cn.com.hosp.www.dao.mapper.StructuresMapper;
import cn.com.hosp.www.sys.service.StructureService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import cn.com.hosp.www.sys.vo.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName StructureServiceImpl
 * @Description TODO
 * @Author tome
 * @Date 19-6-27 下午7:36
 * @Version 1.0
 */

@Service
public class StructureServiceImpl extends BaseServiceImpl<StructuresMapper, Structures> implements StructureService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StructureServiceImpl.class);

    @Autowired
    private StructuresMapper structuresMapper;
    @Autowired
    private ProjectsMapper projectsMapper;


    @Override
    @Transactional
    public Structures save(@NotNull Structures structures) {
        /*ReturnCode returnCode = new ReturnCode();
        Projects projects = projectsMapper.selectByPrimaryKey(structures.getProId());
        if(null == projects){
           returnCode.setType("E");
           returnCode.setMessage("关联的项目[" + structures.getProId() + "], 不存在");
           return null;
        }
        structures.setProName(projects.getProName());*/
        structures.setStructNumber(UUIDUtils.uuid());
        structuresMapper.insert(structures);
        return structures;
    }

    @Override
    public Structures selectOneById(@NotNull Long id) {
        return structuresMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Structures> selectAll() {
        return structuresMapper.selectAll(null);
    }

    @Override
    public List<Structures> selectAllByParam(@NotNull Structures structures) {
        return structuresMapper.selectByCriteria(structures);
    }
}
