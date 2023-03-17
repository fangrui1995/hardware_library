package com.hl.hardwareLibrary.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemControllerLog {

    /**
     * 描述业务操作 例:Xxx管理-执行Xxx操作
     * 支持动态入参，例：新增应用{applicationName}，其中applicationName是请求参数名
     * @return
     */
    String description() default "";

    String firstMenu() default "";

    String secondMenu() default "";

    String thirdMenu() default "";

    String fourthMenu() default "";

    //1234 对应 增删改查
    String operateType() default "4";

    //日志类型 1-业务日志 2-系统日志
    String logType() default "1";

    //接口名称
    String interName() default "";

}
