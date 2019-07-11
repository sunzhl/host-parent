package cn.com.hosp.www.sys.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author tome
 * @Date 19-7-1 上午9:52
 * @Version 1.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    @Qualifier("hospUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationProvider provider;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return this.userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .loginProcessingUrl("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/bootstrap/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();


    }
}
