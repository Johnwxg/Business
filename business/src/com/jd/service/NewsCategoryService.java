package com.jd.service;

import java.util.ArrayList;
import java.util.List;

import com.jd.dao.NewsCategoryDao;
import com.jd.dao.impl.NewsCategoryDaoImpl;
import com.jd.exception.SiteException;
import com.jd.model.NewsCategory;

public class NewsCategoryService {
	//定义一个list类型的引用变量，接收返回值以便判断；定义dao层引用变量
	private List<NewsCategory> categories;
	private NewsCategoryDao newsCategoryDao;
	private List<NewsCategory> cates = new ArrayList<NewsCategory>();
	private int count = 0;
	private NewsCategory newsCategory;
	/*
	 * 查询所有新闻类别
	 * */
	public List<NewsCategory> findAllCategory(){
		//创建dao层对象,接口不能调用
		newsCategoryDao = new NewsCategoryDaoImpl();
		//调用dao层查询分类方法
		categories = newsCategoryDao.findAllCategory();
		//引用变量，判空，抛出异常
		if(categories.isEmpty()){
			try {
				throw new SiteException("无新闻分类信息");
			} catch (SiteException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return categories;//返回list对象
	}
	
	/*
	 * 分类排序   根据视图层传回的cid值，作为排序对象的父节点，然后和当前分类对象的父节点匹配
	 * */
	public List<NewsCategory> getSortCategories(List<NewsCategory> cats, int fid){
		for(int i=0; i<cats.size(); i++){
			if(fid == cats.get(i).getFid()){//将传回的cid值，和当前分类对象的父节点匹配
				cates.add(cats.get(i));//加入集合对象
				getSortCategories(cats, cats.get(i).getCid());//迭代查询
			}
		}
		return cates;
	}
	/**
	 * 无限分类得到层级level
	 */
	public int findLevel(int fid){
		newsCategoryDao = new NewsCategoryDaoImpl();
		return newsCategoryDao.findLevel(fid);
	}
	/**
	 * 分类插入
	 */
	public int insertCategory(NewsCategory newsCategory){
		
		newsCategoryDao = new NewsCategoryDaoImpl();
		count = newsCategoryDao.insertCategory(newsCategory);
		if(count == 0){
			try {
				throw new SiteException("添加分类错误");
			} catch (SiteException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return count;
	}
	/**
	 * 查询某个分类
	 * 
	 */
	public NewsCategory findOneByCid(int cid){
		newsCategoryDao = new NewsCategoryDaoImpl();
		newsCategory = new NewsCategory();
		newsCategory = newsCategoryDao.findOneByCid(cid);
		if(newsCategory.getCid() == 0){
			try {
				throw new SiteException("查询信息失败");
			} catch (SiteException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return newsCategory;
	}
	/*
	 * 修改分类信息
	 * */
	public int updateCategory(NewsCategory newsCategory){
		newsCategoryDao = new NewsCategoryDaoImpl();
		count = newsCategoryDao.updateCategory(newsCategory);
		if(count == 0){
			try {
				throw new SiteException("更新分类失败");
			} catch (SiteException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return count;
	}
	/*
	 * 根据cid查找数据库中与其相等的fid
	 * */
	public int findByFid(int cid){
		newsCategoryDao = new NewsCategoryDaoImpl();
		count = newsCategoryDao.findByFid(cid);
		return count;
	}
	/*
	 * 根据cid删除分类信息
	 * */
	public int deleteCategory(int cid){
		newsCategoryDao = new NewsCategoryDaoImpl();
		count = newsCategoryDao.deleteCategory(cid);
		if(count == 0){
			try {
				throw new SiteException("删除分类失败");
			} catch (SiteException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return count;
	}
}
