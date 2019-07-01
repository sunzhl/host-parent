package cn.com.hosp.www.sys.security.service;

import cn.com.hosp.www.dao.entry.SysRole;
import cn.com.hosp.www.dao.entry.SysUsers;
import cn.com.hosp.www.dao.mapper.SysRoleMapper;
import cn.com.hosp.www.dao.mapper.SysUsersMapper;
import cn.com.hosp.www.sys.security.entity.HospUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static cn.com.hosp.www.sys.security.entity.HospUserDetails.MOBLIE;

/**
 * @ClassName HostUserDetailsService
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 上午9:53
 * @Version 1.0
 */

@Service("hospUserDetailsService")
public class HospUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        byte type = (byte)0;
        SysUsers users = new SysUsers();
        users.setUsername(username);
        SysUsers user = sysUsersMapper.selectOneByCriteria(users);
        if(user == null){
           users.setUsername(null);
           users.setMobile(username);
           type = MOBLIE;
           user = sysUsersMapper.selectOneByCriteria(users);
        }
        if(user == null){
          throw new UsernameNotFoundException("用户不存在");
        }
        List<SysRole> sysRoles = sysRoleMapper.selectByUserId(user.getId());
        Collection<GrantedAuthority> grantedAuthorities = new LinkedList<>();
        if(sysRoles != null && sysRoles.size() > 0){
            grantedAuthorities = sysRoles.stream().map(sysRole -> new SimpleGrantedAuthority(sysRole.getRoleCode())).collect(Collectors.toList());
        }
        return new HospUserDetails(user, grantedAuthorities, type);
    }
}
