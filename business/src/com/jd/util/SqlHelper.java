package com.jd.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class SqlHelper {
	//链接数据库
	//定义需要的变量
		private static	Connection ct=null;
		private static	PreparedStatement ps=null;
		//链接数据库参数
		private static String url="";
		private static String user="";
		private static String pwd="";
		private static String driver="";
		//读配置文件信息
		private static  Properties pp=null;
		//加载驱动，只需一次
		static{
			try{
				//实例化配置文件文件对象
				pp= new Properties();
				//拿到配置文件的输入流
				//得到类加载器对象
				ClassLoader cl = SqlHelper.class.getClassLoader();
				//通过类加载器对象得到指定资源的字节流
				InputStream in = cl.getResourceAsStream("/dbinfo.properties");
				//将配置文件的输入流加载进pp对象
				pp.load(in);
				url=pp.getProperty("url");//获取属性值
				user=pp.getProperty("user");
				pwd=pp.getProperty("pwd");
				driver=pp.getProperty("driver");
				Class.forName(driver);
			}catch(Exception e){
				
			}finally{
				
			}
			
		}
		//获得链接
		public static Connection getConnection(){
			try{
			ct=DriverManager.getConnection(url, user, pwd);
			}catch(Exception e){
				
			}
			return ct;
		}
		//关闭连接
		public static  void closeConnect(){
			
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
