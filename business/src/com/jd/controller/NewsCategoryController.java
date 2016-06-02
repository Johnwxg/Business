package com.jd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.model.NewsCategory;
import com.jd.service.NewsCategoryService;

public class NewsCategoryController extends HttpServlet {
	//定义一个list类型的引用变量，接收返回值以便判断；定义service层引用变量
	private List<NewsCategory> categories;
	private NewsCategoryService newsCategoryService;
	private NewsCategory newsCategory;
	private String act=null;
 	/**
	 * 对象序列化
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		act = request.getParameter("act");
		if(act!=null && act.equals("show_insert_page")){//添加分类
			//创建service层对象
			newsCategoryService = new NewsCategoryService();
			//调用service层查询所有分类方法，用引用变量接收
			categories = newsCategoryService.findAllCategory();
			//获取排序后的分类，添加到Request作用域中   0表示最顶级或最高级分类
			request.setAttribute("categories", newsCategoryService.getSortCategories(categories, 0));
			//跳转到view视图层
			request.getRequestDispatcher("/admin/news/addNewsClass.jsp").forward(request, response);
		}else if(act!=null && act.equals("show_list_page")){//显示所有分类信息
			//创建service层对象
			newsCategoryService = new NewsCategoryService();
			//调用service层查询所有分类方法，用引用变量接收
			categories = newsCategoryService.findAllCategory();
			//获取排序后的分类，添加到Request作用域中   0表示最顶级或最高级分类
			request.setAttribute("categories", newsCategoryService.getSortCategories(categories, 0));
			//跳转到view视图层
			request.getRequestDispatcher("/admin/news/showNewsClass.jsp").forward(request, response);
		}else if(act!=null && act.equals("show_update_page")){//更新-显示
			int cid = Integer.parseInt(request.getParameter("cid"));//获取cid
			newsCategoryService = new NewsCategoryService();
			//根据cid从数据库中找到所有分类信息
			request.setAttribute("category", newsCategoryService.findOneByCid(cid));
			
			categories = newsCategoryService.findAllCategory();
			//获取排序后的分类，添加到Request作用域中   0表示最顶级或最高级分类
			request.setAttribute("categories", newsCategoryService.getSortCategories(categories, 0));
			request.getRequestDispatcher("/admin/news/updateNewsClass.jsp").forward(request, response);
		}else if(act!=null && act.equals("delete_category")){
			int count,num;
			int cid = Integer.parseInt(request.getParameter("cid"));//获取cid
			
			//从数据库中找到fid与视图层传回的cid比较，若相等说明他有子类则不能删除
			newsCategoryService = new NewsCategoryService();
			count = newsCategoryService.findByFid(cid);//根据cid查找数据库中与其相等的fid
			if(count != 0){//不为0，则说明有与该cid相等是fid，不能执行删除操作，跳转到出错页面传去错误信息，但视图层还要显示信息,
				request.getRequestDispatcher("/error.jsp?act=show_list_page&controller=NewsCategoryController&message=dne").forward(request, response);
				return;//终止其执行
			}
			
			num = newsCategoryService.deleteCategory(cid);
			if(num == 1){
				request.getRequestDispatcher("/success.jsp?act=show_list_page&controller=NewsCategoryController").forward(request, response);
				return;
			}
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//从视图层获取标识符
		act = request.getParameter("act");
		//插入操作
		if(act!=null && act.equals("insert")){
			int level;
			newsCategory = new NewsCategory();
			newsCategory.setCname(request.getParameter("cname"));
			newsCategory.setFid(Integer.parseInt(request.getParameter("cid")));
			newsCategoryService = new NewsCategoryService();//创建service层对象
			//获取level
			level = newsCategoryService.findLevel(Integer.parseInt(request.getParameter("cid")));
			newsCategory.setLevel(level);
			//执行插入
			newsCategoryService.insertCategory(newsCategory);
			response.sendRedirect("/business/success.jsp?act=show_list_page&controller=NewsCategoryController");
		}else if(act!=null && act.equals("update")){
			int cid = Integer.parseInt(request.getParameter("id"));//获取提交id 根据隐藏框
			newsCategory = new NewsCategory();//创建实体bean对象，并赋值
			newsCategory.setCid(cid);
			newsCategory.setCname(request.getParameter("cname"));
			newsCategory.setFid(Integer.parseInt(request.getParameter("cid")));
			newsCategoryService = new NewsCategoryService();//创建service层对象
			//获取level
			int level,count;
			level = newsCategoryService.findLevel(Integer.parseInt(request.getParameter("cid")));
			newsCategory.setLevel(level);
			//执行更新
			count = newsCategoryService.updateCategory(newsCategory);//获取受影响行数
			if(count == 1){//每次只能更新一条分类数据
				//实现页面调跳转，并将act标识符和控制器传过去
				response.sendRedirect("/business/success.jsp?act=show_list_page&controller=NewsCategoryController");
			}
			
		}
		
	}

}
