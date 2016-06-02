package com.jd.model;

import java.io.Serializable;
/*
 * 新闻分类实体
 * */
public class NewsCategory implements Serializable {
	/**
	 * 对象序列化
	 */
	private static final long serialVersionUID = 1L;
	private int cid;	//新闻分类id
	private String cname;	//新闻分类名
	private int level;  //分类等级    默认为1(最高级)
	private int fid;  //上级ID（父id）  默认为0(最高级)
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	
}
