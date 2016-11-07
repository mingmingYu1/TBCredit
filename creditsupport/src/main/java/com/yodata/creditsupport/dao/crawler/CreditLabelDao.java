package com.yodata.creditsupport.dao.crawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

/**
 * 代理商标签信息数据库操作
 * @author wenli.qu
 */
@Component
public class CreditLabelDao {
	private MysqlDatabase db = new MysqlDatabase();
	private Connection conn;
	private PreparedStatement pstmt;
	// 查询该代理商名称在标签表里是否有信息
	public boolean isExistence(String compName) {
		conn = db.getConn();
		String sql = "select id from label_info where parent_id = 58 and availably = 1 and label_name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, compName);
			if(pstmt.executeQuery().first()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeAll(pstmt, conn);
		}
		return false;
	}
	public static void main(String[] args) {
		String compName = "成都八千翼网络科技有限公司";
		CreditLabelDao cld = new CreditLabelDao();
		boolean rs = cld.isExistence(compName);
	}
}

class MysqlDatabase {
	String url = "jdbc:mysql://172.17.130.101:3306/label_lifecycle_tb";
	String user = "root";
	String pwd = "tempus";
	
	// 加载驱动
	public MysqlDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 创建连接
	public Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 释放资源
	public void closeAll(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
