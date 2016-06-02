package com.jd.exception;

public class SiteException extends Exception {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	public SiteException(){
		super.getMessage();//super对象，调用方法
	}
	public SiteException(String message){//重载
		super(message);//提交异常信息
	}
}
