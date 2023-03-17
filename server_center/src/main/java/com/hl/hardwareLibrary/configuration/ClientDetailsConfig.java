//package com.ahsh.home.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
//import com.ahsh.home.sys.RedisAuthorizationCodeServices;
//import com.ahsh.home.sys.RedisClientDetailsService;
//import com.ahsh.home.utils.OkHttpClientUtil;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//@Configuration
//public class ClientDetailsConfig {
//    @Resource
//    private DataSource dataSource;
//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;
//
//    /**
//     * 声明 ClientDetails实现
//     */
//    @Bean(name="RedisClientDetailsService")
//    public RedisClientDetailsService clientDetailsService() {
//        RedisClientDetailsService clientDetailsService = new RedisClientDetailsService(dataSource);
//        clientDetailsService.setRedisTemplate(redisTemplate);
//        return clientDetailsService;
//    }
//
//    @Bean
//    public RandomValueAuthorizationCodeServices authorizationCodeServices() {
//        RedisAuthorizationCodeServices redisAuthorizationCodeServices = new RedisAuthorizationCodeServices();
//        redisAuthorizationCodeServices.setRedisTemplate(redisTemplate);
//        return redisAuthorizationCodeServices;
//    }
//
//    @Bean
//    public OkHttpClientUtil getOkHttpClient() {
//        return OkHttpClientUtil.getInstance();
//    }
//}
