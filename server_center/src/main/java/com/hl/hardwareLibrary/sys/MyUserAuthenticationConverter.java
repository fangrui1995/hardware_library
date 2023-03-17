//package com.ahsh.home.sys;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
//import org.springframework.stereotype.Service;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Service
//public class MyUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
//
//
//    @Override
//    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
//        Map<String, Object> response = new LinkedHashMap();
//        response.put("user_name", authentication);
//        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
//            response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
//        }
//        return response;
//    }
//
//}