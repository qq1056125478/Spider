package com.cn.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBaseConnection {
	 Connection conn=null;
	 private String driver=null;
	 private String url=null;
	 private String user=null;
	 private String pass=null;
	 
	 
	public  Connection  getConnection(){
		try{ /*专门读取属性文件：*/
		ResourceBundle  rb=ResourceBundle.getBundle("hnlg.com.cn.comm.conn");
		driver=rb.getString("driver");
		url=rb.getString("url");
		user=rb.getString("user");
		pass=rb.getString("password");
		System.out.println(driver);
		System.out.println(user);
		System.out.println(url);
		System.out.println(pass);
		Class.forName(driver); //加载驱动程序
		conn=DriverManager.getConnection(url,user,pass);/*获取数据库连接对象*/
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return  conn;
    }
	/*获取序列的公共方法*/
	public synchronized int  getSeq(Connection conn,String seqname){
		PreparedStatement ps=null;
		ResultSet rs=null;
		int m=0;
		try{
			String sql="select  "+seqname+".Nextval as b from dual";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){ //如果查询有数据
				m=rs.getInt("b");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{try {
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
		return m;
	}
	
	
	
	public static void main(String args[])
	{
		Connection conn=new DataBaseConnection().getConnection();
		System.out.println("con====="+conn);
		
	}
}