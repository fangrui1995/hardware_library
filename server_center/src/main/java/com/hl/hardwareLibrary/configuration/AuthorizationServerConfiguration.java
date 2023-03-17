///*
// * Copyright 2002-2019 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.ahsh.home.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
//import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//import com.ahsh.home.sys.MyUserAuthenticationConverter;
//
//import javax.sql.DataSource;
//
//
///**
// * 认证服务器
// */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Qualifier("dataSource")
//    @Autowired
//    DataSource dataSource;
//
//    /**
//     * 注入用于支持 password 模式
//     */
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public TokenStore tokenStore() {
//        // 基于 JDBC 实现，令牌保存到数据库
//        return new RedisTokenStore(redisConnectionFactory);
//    }
//
//    @Bean
//    public ClientDetailsService jdbcClientDetailsService() {
//        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
//        return new JdbcClientDetailsService(dataSource);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        DefaultAccessTokenConverter defaultAccessTokenConverter=new DefaultAccessTokenConverter();
//        defaultAccessTokenConverter.setUserTokenConverter(new MyUserAuthenticationConverter());
//
//        endpoints
//                // 用于支持密码模式
//                .authenticationManager(authenticationManager)
//                .accessTokenConverter(defaultAccessTokenConverter)
//                .tokenStore(tokenStore());
//
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//                // 允许客户端访问 /oauth/check_token 检查 token
//                .checkTokenAccess("isAuthenticated()")
//                .allowFormAuthenticationForClients();
//    }
//
//    /**
//     * 配置客户端
//     *
//     * @param clients
//     * @throws Exception
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // 客户端配置
//        clients.withClientDetails(jdbcClientDetailsService());
//    }
//}
