package cn.com.hosp.www.sys.service.impl;

import cn.com.hosp.www.dao.entry.ProjectUser;
import cn.com.hosp.www.dao.mapper.ProjectUserMapper;
import cn.com.hosp.www.sys.service.ProjectUserService;
import cn.com.hosp.www.sys.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProjectUserServiceImpl extends BaseServiceImpl<ProjectUserMapper, ProjectUser> implements ProjectUserService {
}
