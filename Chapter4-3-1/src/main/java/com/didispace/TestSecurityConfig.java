package com.didispace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * description: TestSecurityConfig <br>
 * date: 2019/12/25 11:55 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@Configuration
@EnableWebSecurity
public class TestSecurityConfig extends WebSecurityConfigurerAdapter implements UserDetailsService {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //http.authorizeRequests()方法有多个子节点，每个macher按照他们的声明顺序执行
                .authorizeRequests()
                //我们指定任何用户都可以访问多个URL的模式。
                //任何用户都可以访问以"/resources/","/signup", 或者 "/about"开头的URL。
                .antMatchers("/resources/**", "/signup", "/about").permitAll()
                //以 "/admin/" 开头的URL只能让拥有 "ROLE_ADMIN"角色的用户访问。
                //请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀。
                .antMatchers("/admin/**").hasRole("ADMIN")
                //任何以"/db/" 开头的URL需要同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"权限的用户才可以访问。
                //和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                //任何以"/db/" 开头的URL只需要拥有 "ROLE_ADMIN" 和 "ROLE_DBA"其中一个权限的用户才可以访问。
                //和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
                .antMatchers("/db/**").hasAnyRole("ADMIN", "DBA")
                //尚未匹配的任何URL都要求用户进行身份验证
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
