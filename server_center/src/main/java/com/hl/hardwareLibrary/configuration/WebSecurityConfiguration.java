//package com.ahsh.home.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import com.ahsh.home.security.CustomUserDetailsService;
//
//
///**
// * 安全配置
// */
//@Configuration
//@EnableWebSecurity
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    private AuthExceptionHandler authExceptionHandler;
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception{
//        return new CustomUserDetailsService();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//        auth
//                .userDetailsService(userDetailsServiceBean());
//    }
//
//    /**
//     * 用于支持 password 模式
//     *
//     * @return
//     * @throws Exception
//     */
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    public void configure(WebSecurity web){
//        web.ignoring()
//                .antMatchers("/user/login","/user/iscLogin","/user/ssoLogin","/user/testLogin","/v2/api-docs", "/com/ahsh/home/configuration/ui/**", "/swagger-resources/**", "/com/ahsh/home/configuration/com.ahsh.home.security",
//                        "/swagger-ui.html", "/webjars/**", "/doc.html", "/login.html","/error");
//        web.ignoring().antMatchers("/js/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.exceptionHandling()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//}
