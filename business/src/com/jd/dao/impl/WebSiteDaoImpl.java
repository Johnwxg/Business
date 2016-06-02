package com.jd.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jd.dao.WebSiteDao;
import com.jd.model.Website;
import com.jd.util.SqlHelper;

public class WebSiteDaoImpl implements WebSiteDao {
	private Website website;//所有数据都存放在bean中，先声明bean对象
	//提取公共部分
	private PreparedStatement ps=null;
	private String sql="";//sql语句
	private ResultSet rs=null;//结果集
	
	//查询站点中信息
	@Override
	public Website findAll() {
		// TODO Auto-generated method stub
		sql = "select * from website";
		try {
			
			ps=SqlHelper.getConnection().prepareStatement(sql);//与数据库建立连接
			rs=ps.executeQuery();//执行查询  接收结果集
			website = new Website();//创建Website对象，以便下面调用其方法
			//遍历结果集
			while(rs.next()){
				website.setId(rs.getInt("id"));
				website.setKeywords(rs.getString("keywords"));
				website.setDescption(rs.getString("descption"));
				website.setCopy(rs.getString("copy"));
				website.setAddr(rs.getString("addr"));
				website.setMobile(rs.getLong("mobile"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return website;
	}
	//更新站点信息
	@Override
	public int updateWebsite(Website website) {
		// TODO Auto-generated method stub
		sql = "update website set keywords=?,descption=?,copy=?,addr=?,mobile=? where id=?";
		int count = 0;
		try {
			ps=SqlHelper.getConnection().prepareStatement(sql);
			ps.setString(1,website.getKeywords());
			ps.setString(2, website.getDescption());
			ps.setString(3, website.getCopy());
			ps.setString(4, website.getAddr());
			ps.setLong(5, website.getMobile());
			ps.setInt(6, website.getId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}
