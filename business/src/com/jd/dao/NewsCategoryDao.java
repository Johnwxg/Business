package com.jd.dao;

import java.util.List;

import com.jd.model.NewsCategory;

public interface NewsCategoryDao {
	public List<NewsCategory> findAllCategory();//查询新闻分类所有信息
	public int findLevel(int cid);//查询level
	public int insertCategory(NewsCategory newsCategory);//插入分类,返回值为受影响的行数
	public NewsCategory findOneByCid(int cid);//查询某个分类信息
	public int updateCategory(NewsCategory newsCategory);//修改分类信息
	public int findByFid(int cid);//根据cid查找数据库中与其相等的fid
	public int deleteCategory(int cid);//根据cid删除分类信息
}
