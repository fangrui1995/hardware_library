package com.hl.hardwareLibrary.common;

import java.util.List;

public class Result{
	
	
	public static Result error_nopriv       = new Result(ResultCode.NO_PRIVILIGE);
	public static Result error_noparameter  = new Result(ResultCode.NO_PARAMETER);
	public static Result error_nosession    = new Result(ResultCode.NO_SESSION);	
	public static Result ok                 = new Result(ResultCode.OK);
	public static Result error_tradeDay     = new Result(ResultCode.IS_TRADE_DAY);
	public static Result NO_SERVER          = new Result(ResultCode.NO_SERVER,"服务器错误");                 
	
	private int code;
	private String msg;
	private long size;
	private Object object;
	private long pages;

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	public Result() {

	}

	public Result(Object obj) {
		this.code = ResultCode.OK;
		this.msg= "OK";
		this.object = obj;
	}
	
	public Result(@SuppressWarnings("rawtypes") List ojbs)
	{
		this.code = ResultCode.OK;
		this.msg= "OK";
		this.object = ojbs;
		this.size = ojbs.size();
	}
	
	public Result(int code) {
		this.code = code;
		this.msg = "";
	}

	public Result(String msg) {
		this.msg=msg;
		this.code = ResultCode.OK;
	}
	
	public Result(int code,String msg) {
		this.code = code;
		this.msg=msg;
	}

	public Result(int code,Object ojbs,String msg) {
		this.code = code;
		this.msg=msg;
		this.object = ojbs;
	}

	public Result(int code,Object ojbs,String msg,long size) {
		this.code = code;
		this.msg=msg;
		this.object = ojbs;
		this.size = size;
	}

	public Result(int code,Object ojbs,String msg,long size,long pages) {
		this.code = code;
		this.msg=msg;
		this.object = ojbs;
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
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}
