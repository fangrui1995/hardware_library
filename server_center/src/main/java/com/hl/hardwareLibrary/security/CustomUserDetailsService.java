//package com.ahsh.home.security;
//
//import com.ahsh.home.common.LoginAppUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import com.ahsh.home.sys.SysUserService;
//
//
//@Primary
//@Service("userDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private SysUserService userService;
//
//    @Override
//    public LoginAppUser loadUserByUsername(String username) throws UsernameNotFoundException {
//        // 从数据库中取出用户信息
//        LoginAppUser loginAppUser = userService.findByUsername(username);
//
//        // 判断用户是否存在
//        if(loginAppUser == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//
//        return loginAppUser;
//
//    }
//
//}
