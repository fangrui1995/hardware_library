package com.hl.hardwareLibrary.utils;

/**
 * @Description: 工具类
 * @Author: lojic
 * @Date: 2020/2/22
 * @see:
 */

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class CommonUtils {
    /**
     * Auth2.0 异常封装
     * @param request
     * @param response
     * @param authException
     * @param objectMapper
     * @throws IOException
     */
    public static void authException (HttpServletRequest request, HttpServletResponse response, Exception authException, ObjectMapper objectMapper) throws IOException {
        log.info("认证失败，禁止访问 {}", request.getRequestURI());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
//        R<String> result = new R(1001,"认证失败，禁止访问",authException);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("code",102);
        jsonObject.put("msg","请重新登录");
        log.error("访问失败："+authException.getMessage());
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(jsonObject));
    }
}

