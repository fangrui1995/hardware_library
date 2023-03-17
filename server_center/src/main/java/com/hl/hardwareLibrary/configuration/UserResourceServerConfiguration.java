//package com.ahsh.home.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
//
///**
// * @EnableGlobalMethodSecurity(securedEnabled=true) 开启@Secured 注解过滤权限
// * @EnableGlobalMethodSecurity(jsr250Enabled=true)开启@RolesAllowed 注解过滤权限
// * @EnableGlobalMethodSecurity(prePostEnabled=true) 使用表达式时间方法级别的安全性         4个注解可用
// */
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//public class UserResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//    @Autowired
//    private AuthExceptionHandler authExceptionHandler;
//
//    @Bean
//    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
//        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
//        expressionHandler.setApplicationContext(applicationContext);
//        return expressionHandler;
//    }
//
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        // 配置资源 ID
//        resources.resourceId("backend-resources");
//        resources.accessDeniedHandler(authExceptionHandler)
//                .authenticationEntryPoint(authExceptionHandler);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .exceptionHandling()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user/login","/user/iptoken","/user/ssoLogin","/user/iscLogin","/user/consoleLogin","/linkDiagram/**").permitAll()
//                .antMatchers("/platform45/laIndex/**","/platform45/la/**","/platform45/laPersonnelSalaryAndScore/**","/platform45/laSalaryAndScore/**").permitAll()
//                //.antMatchers("/**").permitAll()
//                .anyRequest().authenticated();
//    }
//
//}
