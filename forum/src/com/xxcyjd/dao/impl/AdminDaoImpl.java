package com.xxcyjd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xxcyjd.dao.AdminDao;
import com.xxcyjd.domain.Admin;
import com.xxcyjd.util.JdbcUtil;

public class AdminDaoImpl implements AdminDao {

	public boolean select(Admin admin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String sql = "select * from admin";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String username = rs.getString("username");
				String pass= rs.getString("password");
				if(admin.getUsername().equals(username)){
					if(admin.getPassword().equals(pass)){
						return true;
					}
				}
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return false;
	}
	
	
	public boolean update(Admin admin) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql= "update admin set username=?,password=? where id=1";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, admin.getUsername());
			st.setString(2, admin.getPassword());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();	
			return false;
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(st);
			JdbcUtil.close(conn);
		}
		return true;
	}

}
