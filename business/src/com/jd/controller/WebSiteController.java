package com.jd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.exception.SiteException;
import com.jd.model.Website;
import com.jd.service.WebSiteService;

public class WebSiteController extends HttpServlet {
	private WebSiteService webSiteService;
	private Website website;
	
	/**
	 * 站点基本信息控制器->序列化
	 */
	private static final long serialVersionUID = 1L;

	//从数据库中获取站点信息，在后台页面显示
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//编码格式
		webSiteService = new WebSiteService();//创建WebSiteService对象，供下面调用其方法
		website = webSiteService.findAll();
		request.setAttribute("website", website);
		request.getRequestDispatcher("/admin/system/website.jsp").forward(request, response);
		
	}

	//站点信息->提交表单
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		website = new Website();
		//判空
		if(request.getParameter("id")==null || request.getParameter("keywords")==null ||request.getParameter("descption")==null||request.getParameter("copy")==null ||request.getParameter("addr")==null||  request.getParameter("mobile")==null){
			try {
				throw new SiteException("数据不能为空或数据不合法！");//抛出异常
			} catch (SiteException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		//从前台获取站点信息
		website.setId(Integer.parseInt(request.getParameter("id")));
		website.setKeywords(request.getParameter("keywords"));
		website.setDescption(request.getParameter("descption"));
		website.setCopy(request.getParameter("copy"));
		website.setAddr(request.getParameter("addr"));
		website.setMobile(Long.parseLong(request.getParameter("mobile")));
		/*转service*/
		//从WebSiteService中，调用service层方法
		webSiteService.updateWebSite(website);
		response.sendRedirect("/business/WebSiteController");//重定向到servlet控制器，即doGet中来实现站点信息的录入、更新
	}

}
