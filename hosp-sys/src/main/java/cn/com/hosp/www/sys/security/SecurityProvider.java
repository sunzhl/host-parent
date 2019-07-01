package cn.com.hosp.www.sys.security;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecurityProvider
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 上午11:21
 * @Version 1.0
 */

@Component
@Slf4j
public class SecurityProvider implements AuthenticationProvider {

    @Autowired
    @Qualifier("hospUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        log.info("用户{}开始认证操作", username);
        if(StringUtils.isBlank(username)){
            throw new IllegalArgumentException("用户名不能问为空");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if(null == userDetails){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        if(!encoder.matches((CharSequence) token.getCredentials(), userDetails.getPassword())){
            throw new HospException("密码错误!");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
