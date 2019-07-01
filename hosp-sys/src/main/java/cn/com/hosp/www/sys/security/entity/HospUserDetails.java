package cn.com.hosp.www.sys.security.entity;

import cn.com.hosp.www.dao.entry.SysUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @ClassName HospUserDetails
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 上午9:55
 * @Version 1.0
 */

public class HospUserDetails implements UserDetails {

    public static final byte MOBLIE = (byte)1;

    private SysUsers user;

    private byte type;

    private Collection<GrantedAuthority> grantedAuthorities;

    public HospUserDetails(SysUsers user, Collection<GrantedAuthority> grantedAuthorities, byte type) {
        this.user = user;
        this.type = type;
        this.grantedAuthorities = grantedAuthorities;
    }

    public HospUserDetails(SysUsers user, Collection<GrantedAuthority> grantedAuthorities) {
        this.user = user;
        this.grantedAuthorities = grantedAuthorities;
    }

    public HospUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        if(type == MOBLIE){
           return user.getMobile();
        }else{
            return user.getUsername();
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public SysUsers getUser() {
        return user;
    }

    public void setUser(SysUsers user) {
        this.user = user;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public Collection<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }
}
