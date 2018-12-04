package com.embryoai.acloud.dto;



public class Rsp {
	public static String REP_CODE = "code";
	public static String REP_MSG = "message";
	public static String REP_DATA = "data";

	public static String REP_CODE_SUCC = "200";//成功
	public static String REP_CODE_ERR = "400";//业务逻辑问题
	public static String REP_CODE_FAIL = "500";//系统异常
	public static String REP_MSG_FAIL = "失败";
	public static String REP_MSG_SUCC = "成功";
	public static String REP_AUT_FAIL = "401";//登录失败
	
	public static BaseResult succ(String msg , Object obj){
		BaseResult  result = new BaseResult();
		result.setCode(REP_CODE_SUCC);
		msg = msg==null|| "".equals(msg)?REP_MSG_SUCC:msg;
		result.setMessage("请求成功!");
		result.setData(obj);
		return result;
	}
	
	public static BaseResult err(String msg ,Object obj){
		BaseResult  result = new BaseResult();
		result.setCode(REP_CODE_ERR); 
		msg = msg==null|| "".equals(msg)?REP_MSG_SUCC:msg;
		result.setMessage("请求成功!响应结果:" + msg);
		result.setData(obj);
		return result;
	}
	
	public static BaseResult fail(String msg ,Object obj){
		BaseResult  result = new BaseResult();
		result.setCode(REP_CODE_FAIL); 
		msg = msg==null|| "".equals(msg)?REP_MSG_SUCC:msg;
		result.setMessage("请求失败!" + msg);
		result.setData(obj);
		return result;
	}
	
	/**
	 * 登录超时,验证失败
	 * @param msg
	 * @param obj
	 * @return
	 */
	public static BaseResult authorityFail(){
		BaseResult  result = new BaseResult();
		result.setCode(REP_AUT_FAIL); 
		result.setMessage("登录失败");
		result.setData(null);
		return result;
	}
	
	public static BaseResult authorityFail(String msg){
		BaseResult  result = new BaseResult();
		result.setCode(REP_AUT_FAIL); 
		result.setMessage(msg);
		result.setData(null);
		return result;
	}
}
