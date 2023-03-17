package com.hl.hardwareLibrary.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResult<T> {


    public static ServiceResult error_nopriv = new ServiceResult(ResultCode.NO_PRIVILIGE);
    public static ServiceResult error_noparameter = new ServiceResult(ResultCode.NO_PARAMETER);
    public static ServiceResult error_nosession = new ServiceResult(ResultCode.NO_SESSION);
    public static ServiceResult ok = new ServiceResult(ResultCode.OK);
    public static ServiceResult error_tradeDay = new ServiceResult(ResultCode.IS_TRADE_DAY);
    public static ServiceResult NO_SERVER = new ServiceResult(ResultCode.NO_SERVER, "服务器错误");

    private int code;
    private String msg;
    private long size;
    @ApiModelProperty("响应内容")
    private T object;
    private long pages;

    public static ServiceResult ok(Object obj) {
		ServiceResult result=new ServiceResult();
		result.setObject(obj);
		result.setMsg("OK");
		result.setCode(ResultCode.OK);
    	return result;
    }
    public ServiceResult(Object obj) {
        this.code = ResultCode.OK;
        this.msg= "OK";
        this.object = (T) obj;
    }

    public ServiceResult(@SuppressWarnings("rawtypes") List ojbs)
    {
        this.code = ResultCode.OK;
        this.msg= "OK";
        this.object = (T) ojbs;
        this.size = ojbs.size();
    }

    public ServiceResult(int code) {
        this.code = code;
        this.msg = "";
    }

    public ServiceResult(int code,String msg) {
        this.code = code;
        this.msg=msg;
    }

    public ServiceResult(int code,Object ojbs,String msg) {
        this.code = code;
        this.msg=msg;
        this.object = (T) ojbs;
    }

    public ServiceResult(int code,Object ojbs,String msg,long size) {
        this.code = code;
        this.msg=msg;
        this.object = (T) ojbs;
        this.size = size;
    }

    public ServiceResult(int code,Object ojbs,String msg,long size,long pages) {
        this.code = code;
        this.msg=msg;
        this.object = (T) ojbs;
        this.size = size;
        this.pages = pages;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public T getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = (T) object;
    }

}
