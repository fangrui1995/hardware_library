//package com.ahsh.home.utils;
//
//import cn.hutool.core.bean.BeanUtil;
//import com.ahsh.home.common.LoginAppUser;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.OAuth2Request;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
//
//import java.util.Map;
//
//public class SysUserUtil {
//
//	/**
//	 * 获取登陆的 LoginAppUser
//	 *
//	 * @return
//	 */
//	public static LoginAppUser getLoginAppUser() {
//
//		// 当OAuth2AuthenticationProcessingFilter设置当前登录时，直接返回
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication instanceof OAuth2Authentication) {
//			OAuth2Authentication oAuth2Auth = (OAuth2Authentication) authentication;
//			authentication = oAuth2Auth.getUserAuthentication();
//
//			if (authentication instanceof UsernamePasswordAuthenticationToken) {
//				UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthBCryptPasswordEncoderenticationToken) authentication;
//
//				if(authenticationToken.getPrincipal() instanceof LoginAppUser){
//					return (LoginAppUser) authenticationToken.getPrincipal();
//				}else if (authenticationToken.getPrincipal() instanceof Map){
//					Map<String, Object>  authMap = (Map) authenticationToken.getPrincipal();
//					LoginAppUser loginAppUser = BeanUtil.mapToBean((Map) authMap.get("principal"), LoginAppUser.class, true);
//					return loginAppUser;
//				}
//
//
//			} else if (authentication instanceof PreAuthenticatedAuthenticationToken) {
//				// 刷新token方式
//				PreAuthenticatedAuthenticationToken authenticationToken = (PreAuthenticatedAuthenticationToken) authentication;
//				return (LoginAppUser) authenticationToken.getPrincipal();
//
//			}
//		}
//
//		// 当内部服务，不带token时，内部服务
//		/*String accessToken = TokenUtil.getToken();
//
//		if(accessToken!=null){
//			RedisTemplate redisTemplate = SpringUtils.getBean(RedisTemplate.class);
//			Map<String, Object> params = (Map<String, Object>) redisTemplate.opsForValue()
//					.get(UaaConstant.TOKEN + ":" + accessToken);
//			if (params != null) {
//				return (LoginAppUser) params.get(UaaConstant.AUTH);
//			}
//		}*/
//
//
//		return null;
//	}
//
//	public static OAuth2Authentication updatePrinciple(LoginAppUser loginAppUser,OAuth2Request oAuth2Request) {
//		OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
//		// 生成新的认证信息
//		Authentication newAuth = new UsernamePasswordAuthenticationToken(loginAppUser, authentication.getCredentials(), authentication.getAuthorities());
//		OAuth2Authentication oAuth2Auth = new OAuth2Authentication(oAuth2Request,newAuth);
//		// 重置认证信息
//		SecurityContextHolder.getContext().setAuthentication(oAuth2Auth);
//
//		return  oAuth2Auth;
//	}
//
//
//}
