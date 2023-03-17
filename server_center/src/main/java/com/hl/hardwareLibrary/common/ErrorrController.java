package com.hl.hardwareLibrary.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class ErrorrController implements ErrorController
{
    private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping
    @ResponseBody
    public JSONObject doHandleError(HttpServletRequest request) {
        Map<String, Object> errorAttributesData = this.getErrorAttributes(request, true);
        Integer status = (Integer) errorAttributesData.get("status");  //状态码
        String path = (String) errorAttributesData.get("path");        //请求路径
        String messageFound = (String) errorAttributesData.get("message");   //异常信息

        JSONObject reData = new JSONObject();
        reData.put("code", status);
        reData.put("path_", path);
        reData.put("msg", messageFound);
        return reData;
    }

    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        WebRequest webRequest = new ServletWebRequest(request);
        return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }
}
