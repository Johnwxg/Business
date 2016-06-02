package com.jd.service;

import com.jd.dao.WebSiteDao;
import com.jd.dao.impl.WebSiteDaoImpl;
import com.jd.exception.SiteException;
import com.jd.model.Website;

public class WebSiteService {
	private WebSiteDao webSiteDao; //调用dao层变量
	private Website website;
	//查询站点中信息
	public Website findAll(){
		webSiteDao = new WebSiteDaoImpl();//创建实例对象
		website = webSiteDao.findAll();
		if(website.getId()==0){//website中是否有数据
			try {
				throw new SiteException("没有查询到该站点信息");//抛出异常
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		return website;
	}
	//更新站点信息
	public void updateWebSite(Website website){
		webSiteDao = new WebSiteDaoImpl();
		if(webSiteDao.updateWebsite(website)==0){
			try {
				throw new SiteException("更新站点错误");
			} catch (SiteException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
	}
}
