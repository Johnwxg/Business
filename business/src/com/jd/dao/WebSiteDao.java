package com.jd.dao;

import com.jd.model.Website;

public interface WebSiteDao {
	public Website findAll();//查询站点信息
	public int updateWebsite(Website website);//更新站点信息->返回的是数据受影响行数
}
