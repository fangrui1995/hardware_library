//package com.ahsh.home.controller.sys;
//
//import com.ahsh.home.annotation.SystemControllerLog;
//import com.ahsh.home.common.LoginAppUser;
//import com.ahsh.home.common.Result;
//import com.ahsh.home.common.ResultCode;
//import com.ahsh.home.dao.domain.ext.SysMenuExt;
//import com.ahsh.home.model.LoginParam;
//import com.ahsh.home.sys.RedisClientDetailsService;
//import com.ahsh.home.sys.SysMenuService;
//import com.ahsh.home.sys.SysRoleMenuService;
//import com.ahsh.home.sys.SysUserService;
//import com.ahsh.home.utils.SpringUtil;
//import com.ahsh.home.utils.SysUserUtil;
//import com.google.common.collect.Maps;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections.MapUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
//import org.springframework.security.oauth2.provider.ClientDetails;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.OAuth2Request;
//import org.springframework.security.oauth2.provider.TokenRequest;
//import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
//import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Description:
// * @Author: lojic
// * @Date: 2020/7/9
// * @see: com.wtkj.internalsimulation.controller
// */
//@Slf4j
//@RestController
//@RequestMapping(value = "/user")
//@Api(value = "Web - LoginController", tags = {"用户登录相关方法"}, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
//public class LoginController {
//
//    @Value("${business.oauth2.grant_type}")
//    public String oauth2GrantType;
//
//    @Value("${business.oauth2.client_id}")
//    public String oauth2ClientId;
//
//    @Value("${business.oauth2.client_secret}")
//    public String oauth2ClientSecret;
//
//
//
//    @Autowired
//    public SysUserService sysUserService;
//
//    @Resource
//    public BCryptPasswordEncoder passwordEncoder;
//
//    @Resource
//    private AuthorizationServerTokenServices authorizationServerTokenServices;
//
//    @Autowired
//    private ConsumerTokenServices consumerTokenServices;
//
//
//    @Autowired
//    private SysMenuService sysMenuService;
//
//    @Autowired
//    private SysRoleMenuService sysRoleMenuService;
//
//
//
//
//    @ApiOperation(value = "获取当前登录用户信息")
//    @GetMapping(value = "/current")
//    @SystemControllerLog(description = "用户登录-获取当前登录用户信息",
//            firstMenu = "用户登录", interName = "获取当前登录用户信息")
//    public Result getCurrentUser(HttpServletRequest request) {
//        LoginAppUser loginAppUser = SysUserUtil.getLoginAppUser();
//        if (null == loginAppUser) {
//            return new Result(ResultCode.NO_SESSION, "请重新登录");
//        }
//
//        //添加是否是初始密码标识
//        if(passwordEncoder.matches("#Ahhb2022!",loginAppUser.getPassword())){
//            loginAppUser.setFlag("0");
//        }
//
//        return new Result(loginAppUser);
//    }
//
//    @ApiOperation(value = "退出登录")
//    @GetMapping(value = "/logOut")
//    @SystemControllerLog(description = "退出登录",
//            firstMenu = "退出登录",interName = "退出登录")
//    public Result logOut(@ApiParam("accessToken") @RequestParam()  String accessToken){
//        boolean isSuccess = consumerTokenServices.revokeToken(accessToken);
//        if(isSuccess){
//            return Result.ok;
//        }else {
//            return new Result(ResultCode.NO_SERVER,"退出失败");
//        }
//    }
//
//
//
//    @ApiOperation(value = "获取密码")
//    @GetMapping(value = "/getPassword")
//    @SystemControllerLog(description = "获取密码",
//            firstMenu = "获取密码",interName = "获取密码")
//    public Result getPassword(@ApiParam("accessToken") @RequestParam()  String password){
//
//        String encode = passwordEncoder.encode(password);
//        return new Result(encode);
//
//    }
//
//
//
//
//
//    @ApiOperation(value = "修改密码")
//    @PostMapping(value = "/updatePassword")
//    @SystemControllerLog(description = "获取密码",
//            firstMenu = "修改密码",interName = "修改密码")
//    public Result updatePassword(@ApiParam("loginParam") @RequestBody LoginParam loginParam){
//
//
//        return sysUserService.updatePassword(loginParam);
//
//
//    }
//
//
//    @ApiOperation(value = "通过用户名密码获取token")
//    @PostMapping(value = "/consoleLogin")
//    @SystemControllerLog(description = "用户登录-通过用户名密码获取token",
//            firstMenu = "用户登录",interName = "通过用户名密码获取token")
//    public Result consoleLogin(@RequestBody LoginParam loginParam) {
//        try {
//            String userName = loginParam.getUsername();
//            if(StringUtils.isBlank(userName)){
//                return  new Result(ResultCode.NO_SESSION,"用户不存在");
//            }else {
//                LoginAppUser tempUser = sysUserService.findByUsername(userName);
//                if(null == tempUser){
//                    return  new Result(ResultCode.NO_PARAMETER,"用户不存在");
//                }else if(!passwordEncoder.matches(loginParam.getPassword(),tempUser.getPassword())){
//                    return  new Result(ResultCode.NO_PARAMETER,"密码错误，请重新输入");
//                }else {
//                    ClientDetails clientDetails = getClient(oauth2ClientId, oauth2ClientSecret, null);
//                    TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, oauth2ClientId, clientDetails.getScope(),
//                            "password");
//                    OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
//
//                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName ,loginParam.getPassword());
//                    AuthenticationManager authenticationManager = SpringUtil.getBean(AuthenticationManager.class);
//                    Authentication authentication = authenticationManager.authenticate(token);
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                    OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
//                    OAuth2AccessToken oAuth2AccessToken = authorizationServerTokenServices
//                            .createAccessToken(oAuth2Authentication);
//                    oAuth2Authentication.setAuthenticated(true);
//
//                    // 封装返回的结果集
//                    Map<String, Object> resultData = Maps.newHashMap();
//                    List<Long> menuIds = sysRoleMenuService.getMenuIdsByRoleId(tempUser.getRoleId());
//                    List<SysMenuExt> menus = sysMenuService.listWithTree(sysMenuService.getMenuByMenuIds(menuIds));
//                    tempUser.setConsoleMenus(menus);
//
//                    //添加是否是初始密码标识
//                    if(passwordEncoder.matches("#Ahhb2022!",tempUser.getPassword())){
//                        tempUser.setFlag("0");
//                    }
//
//
//                    resultData.put("user",tempUser);
//                    resultData.put("token", oAuth2AccessToken.getValue());
//
//                    tempUser.setLoginTime(new Date());
//                    sysUserService.update(tempUser);
//
//                    return new Result(resultData);
//                }
//            }
//        }catch (Exception e){
//            log.error("登录异常",e);
//            log.error("sign：{}",loginParam.getSign());
//            return new Result(ResultCode.NO_SESSION,"登录异常");
//        }
//    }
//
//
//    private ClientDetails getClient(String clientId, String clientSecret, RedisClientDetailsService clientDetailsService) {
//        if (clientDetailsService == null) {
//            clientDetailsService = SpringUtil.getBean(RedisClientDetailsService.class);
//        }
//        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
//
//        if (clientDetails == null) {
//            throw new UnapprovedClientAuthenticationException("clientId对应的信息不存在");
//        } else if (!passwordEncoder.matches(clientSecret, clientDetails.getClientSecret())) {
//            throw new UnapprovedClientAuthenticationException("clientSecret不匹配");
//        }
//        return clientDetails;
//    }
//
//}
