//package com.ahsh.home.sys;
//
//import com.ahsh.home.dao.domain.*;
//import com.ahsh.home.dao.mapper.SysRoleUserMapper;
//import com.ahsh.home.dao.mapper.SysUserMapper;
//import com.ahsh.home.common.LoginAppUser;
//import com.ahsh.home.common.Result;
//import com.ahsh.home.enums.CommonEnum;
//import com.ahsh.home.model.LoginParam;
//import com.ahsh.home.model.SysUserParam;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import com.ahsh.home.utils.SpringUtil;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Service
//public class SysUserService {
//
//    @Resource
//    private SysUserMapper userMapper;
//
//    @Autowired
//    private SysUserRoleService userRoleService;
//
//    @Autowired
//    private SysRolePermissionService sysRolePermissionService;
//
//    @Autowired
//    private SysPermissionService sysPermissionService;
//
////    @Autowired
////    private DwaMoisNmscMemberMapper dwaMoisNmscMemberMapper;
//
////    @Autowired
////    private BCryptPasswordEncoder bCryptPasswordEncoder;
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
///*    @Value("${business.oauth2.access-token-uri}")
//    public String URL_OAUTH_TOKEN;*/
//
//    @Resource
//    public BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private SysRoleUserMapper sysRoleUserMapper;
//
//    @Autowired
//    private SysUserMapper sysUserMapper;
//
//
//    /**
//     * 获取UserDetails对象
//     * @param username
//     * @return
//     */
//    public LoginAppUser findByUsername(String username){
//        SysUser userParam = new SysUser();
//        userParam.setAccount(username);
//        userParam.setStatusInfo(CommonEnum.ENABLE.getKey());
//        SysUser sysUser = userMapper.selectOne(userParam);
//        if (sysUser != null) {
//            LoginAppUser loginAppUser = new LoginAppUser();
//            BeanUtils.copyProperties(sysUser, loginAppUser);
//            // 添加权限
//            List<SysRoleUser> userRoles = userRoleService.listByUserId(loginAppUser.getId());
//
//            loginAppUser.setSysRoles(userRoles);// 设置角色
//            //loginAppUser.setRegionCode(sysUser.getRegionCode());
//
//            if (!CollectionUtils.isEmpty(userRoles)) {
//                List<Integer> roleIds = userRoles.parallelStream().map(r -> r.getRoleId()).collect(Collectors.toList());
//                List<SysRolePermission> rolePermissions = sysRolePermissionService.listByRoleId(roleIds);
//                List<Long> permissionIds = rolePermissions.parallelStream().map(p -> p.getPermissionId()).collect(Collectors.toList());
//                List<SysPermission> sysPermissions = sysPermissionService.selectByIds(permissionIds);
//                if (!CollectionUtils.isEmpty(sysPermissions)) {
//                    List<String> permissions = sysPermissions.parallelStream().map(q -> q.getPermission())
//                            .collect(Collectors.toList());
//
//                    loginAppUser.setPermissions(permissions);// 设置权限集合
//                }
//
//            }
//            return loginAppUser;
//        }
//        return null;
//    }
//
//    public SysUser selectById(Integer id) {
//        return userMapper.selectByPrimaryKey(id);
//    }
//
//    public SysUser selectByName(String name) {
//        SysUser sysUser = new SysUser();
//        sysUser.setUserName(name);
//        return userMapper.selectOne(sysUser);
//    }
//
//
//    public SysUser selectByAccount(String account) {
//        SysUser sysUser = new SysUser();
//        sysUser.setAccount(account);
//        sysUser.setStatusInfo(1);
//        List<SysUser> select = userMapper.select(sysUser);
//
//        SysUser sysUser1 = new SysUser();
//        if(null!=select&&select.size()>0){
//            sysUser1 = select.get(0);
//        }
//
//        return sysUser1;
//    }
//
//    public int update(SysUser user){
//        return userMapper.updateByPrimaryKey(user);
//    }
//
//    /**
//     * 添加用户
//     * @param user
//     * @return
//     */
//    /**
//     *微信用户信息入库
//     * @param user
//     */
//    public int addUser(SysUser user){
//
//        //根据openId判断用户是否添加,不重复添加
//        SysUser sysUser = new SysUser();
//        sysUser.setAccount(user.getAccount());
//        SysUser selectOne = userMapper.selectOne(sysUser);
//
//        if(selectOne==null){
//            //初始密码
//            String password = bCryptPasswordEncoder.encode(user.getPassword());
//            user.setPassword(password);
//            user.setStatusInfo(CommonEnum.ENABLE.getKey());
//            user.setCreateTime(new Date());
//            user.setRoleId(user.getRoleId());
//            user.setLoginTime(new Date());
//            user.setRoleId(user.getRoleId());
//            userMapper.insert(user);
//
//            SysRoleUser sysRoleUser = new SysRoleUser();
//            sysRoleUser.setRoleId(user.getRoleId());
//            sysRoleUser.setUserId(user.getId());
//            return sysRoleUserMapper.insert(sysRoleUser);
//        }
//
//        return -1;
//
//    }
//
//
//
//
//
//
////    private ClientDetails getClient(String clientId, String clientSecret, RedisClientDetailsService clientDetailsService) {
////        if (clientDetailsService == null) {
////            clientDetailsService = SpringUtil.getBean(RedisClientDetailsService.class);
////        }
////        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
////
////        if (clientDetails == null) {
////            throw new UnapprovedClientAuthenticationException("clientId对应的信息不存在");
////        } else if (!passwordEncoder.matches(clientSecret, clientDetails.getClientSecret())) {
////            throw new UnapprovedClientAuthenticationException("clientSecret不匹配");
////        }
////        return clientDetails;
////    }
//
//    public Result updatePassword(LoginParam loginParam) {
//
//        SysUser sysUser = new SysUser();
//        sysUser.setAccount(loginParam.getUsername());
//        List<SysUser> select = userMapper.select(sysUser);
//
//        if(null==select||select.size()<=0){
//            return new Result(1,"没有该用户信息");
//        }
//        SysUser selectOne = select.get(0);
//
//
//
//        if(passwordEncoder.matches(loginParam.getPassword(),selectOne.getPassword())){
//            return new Result(1,"不能与原密码相同");
//        }
//
//
//        if(!passwordEncoder.matches(loginParam.getPasswordRaw(),selectOne.getPassword())){
//            return new Result(1,"原密码错误,请重新输入");
//        }
//
//        String password = bCryptPasswordEncoder.encode(loginParam.getPassword());
//        selectOne.setPassword(password);
//        selectOne.setUpdateTime(new Date());
//        userMapper.updateByPrimaryKeySelective(selectOne);
//
//        return new Result("修改成功");
//    }
//
//
//
//
//
//    public Result insertUser(SysUserParam sysUserParam) {
//
//        SysUser sysUser = new SysUser();
//
//        sysUser.setUserName(sysUserParam.getUserName());
//        sysUser.setAccount(sysUserParam.getAccount());
//        sysUser.setRoleId(sysUserParam.getRoleId());
//
//
//        sysUser.setCreateTime(new Date());
//        String encode = passwordEncoder.encode("#Ahhb2022!");
//        sysUser.setPassword(encode);
//        sysUser.setStatusInfo(1);
//
//        sysUserMapper.insert(sysUser);
//        return new Result("添加成功");
//
//    }
//}
