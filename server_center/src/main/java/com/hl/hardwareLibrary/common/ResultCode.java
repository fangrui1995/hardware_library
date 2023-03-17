package com.hl.hardwareLibrary.common;

public interface ResultCode 
{
	int OK	                     = 0 ; //成功
	int NO_SERVER                = -1; //系统内部错误
	int NO_PRIVILIGE             = 100; //权限不足
	int NO_PARAMETER             = 101; //参数错误
	int NO_SESSION               = 102; //未登录 
	int USER_ACCOUNT_EXIST       = 103; //用户已存在
	int USER_NO_SESSION          = 104; //用户名或密码错误
	int USER_NAME_SESSION          = 105; //用户名不合法
	int USER_PASS_SESSION          = 106; //密码不合法
	int USER_KAPTCHA               = 107; //验证码错误
	int IS_TRADE_DAY                  = 108; //非交易时间
	int NO_CITY_PRIVILIGE             = 109; //无地市定制化场景权限
	int REQUEST_ERROR             = 110; //无地市定制化场景权限
	int TEMPLATE_ERROR             = 111; //无地市定制化场景权限

}
