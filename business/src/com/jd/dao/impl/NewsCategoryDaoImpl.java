package com.jd.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jd.dao.NewsCategoryDao;
import com.jd.model.NewsCategory;
import com.jd.util.SqlHelper;

public class NewsCategoryDaoImpl implements NewsCategoryDao {
	private NewsCategory newsCategory;
	//提取公共部分
	private PreparedStatement ps=null;//获取sql语句，创建对象
	private String sql="";//sql语句
	private ResultSet rs=null;//结果集
	List<NewsCategory> categories;//创建存放NewsCategory（新闻分类）列表
	private int count = 0;
	
	@Override
	public List<NewsCategory> findAllCategory() {
		// TODO Auto-generated method stub
		sql = "select * from new_class";//1、查询语句
		try {
			ps = SqlHelper.getConnection().prepareStatement(sql);//2、与数据库建立连接,创建PreparedStatement对象
			rs = ps.executeQuery();//3、执行查询  接收结果集
			categories = new ArrayList<NewsCategory>();//4、创建存放NewsCategory（新闻分类）列表
			//5、遍历结果集，将实体放入列表存储器
			while(rs.next()){
				newsCategory = new NewsCategory();//创建实体对象
				newsCategory.setCid(rs.getInt("cid"));
				newsCategory.setCname(rs.getString("cname"));
				newsCategory.setLevel(rs.getInt("level"));
				newsCategory.setFid(rs.getInt("fid"));
				categories.add(newsCategory);//将实体存入list列表中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;//返回集合对象
	}
	
	/**
	 * 查找level
	 * */
	@Override
	public int findLevel(int cid) {
		// TODO Auto-generated method stub
		sql = "select level from new_class where cid=?";
		int level=1;//表示分类等级处于最高级
		try {
			ps = SqlHelper.getConnection().prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			if(rs.next()){
				level = rs.getInt("level") + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return level;
	}
	/*
	 * 插入新闻分类
	 * */
	@Override
	public int insertCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		sql = "insert into new_class set cname=?,fid=?,level=?";
		try {
			ps = SqlHelper.getConnection().prepareStatement(sql);
			ps.setString(1, newsCategory.getCname());
			ps.setInt(2, newsCategory.getFid());
			ps.setInt(3, newsCategory.getLevel());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	/*
	 * 查询某个分类信息
	 * */
	@Override
	public NewsCategory findOneByCid(int cid) {
		// TODO Auto-generated method stub
		sql = "select * from new_class where cid=?";
		newsCategory = new NewsCategory();
		try {
			ps = SqlHelper.getConnection().prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			if(rs.next()){
				newsCategory.setCid(rs.getInt("cid"));
				newsCategory.setCname(rs.getString("cname"));
				newsCategory.setLevel(rs.getInt("level"));
				newsCategory.setFid(rs.getInt("fid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsCategory;
	}
	/*
	 * 修改分类信息
	 * */
	@Override
	public int updateCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		sql = "update new_class set cname=?,fid=?,level=? where cid=?";
		try {
			ps = SqlHelper.getConnection().prepareStatement(sql);
			ps.setString(1, newsCategory.getCname());
			ps.setInt(2, newsCategory.getFid());
			ps.setInt(3, newsCategory.getLevel());
			ps.setInt(4, newsCategory.getCid());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/*
	 * 根据cid，查找Fid,判断是否有和cid相等的fid
	 * */
	@Override
	public int findByFid(int cid) {
		// TODO Auto-generated method stub
		sql = "select count(*) from new_class where fid = ?";
		try {
			ps = SqlHelper.getConnection().prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			if(rs.next()){//若结果集中有数据，说明有和cid相等的fid
				count = rs.getInt(1);//获取第一个值
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/*
	 * 根据cid删除分类信息
	 * */
	@Override
	public int deleteCategory(int cid) {
		// TODO Auto-generated method stub
		sql = "delete from new_class where cid = ?";
		try {
			ps = SqlHelper.getConnection().prepareStatement(sql);
			ps.setInt(1, cid);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}
