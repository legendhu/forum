package com.xxcyjd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.xxcyjd.dao.UserDao;
import com.xxcyjd.domain.User;
import com.xxcyjd.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

	public boolean insert(User u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql="insert into user values (?,?,?,?,?,?)";
			pstmt = JdbcUtil.prepareStmt(conn, sql);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2,u.getPassword());
			pstmt.setString(3, u.getMajor());
			pstmt.setString(4, u.getSex());
			pstmt.setString(5, u.getEmail());
			pstmt.setString(6, u.getTel());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			
		}	
		return true;
	}

	
	public int select(User user) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;	
		String sql= "select * from user "; 
		try{
			conn = JdbcUtil.getConnection();
			st = JdbcUtil.prepareStmt(conn, sql);
			rs = JdbcUtil.executeQuery(st, sql);
			while(rs.next()) { 
				String username = rs.getString("username");
				String pass= rs.getString("password");
				if(user.getUsername().equals(username)){
					if(user.getPassword().equals(pass)){
							int code=3;
							return code;//用户名密码均正确
						
					}else{
						int code=2;//密码不正确
						return code;	
					}
				}
			}
			}catch(SQLException e){
				e.printStackTrace();		
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(st);
				JdbcUtil.close(conn);
			}
				int code=1;//用户名不正确
				return code;
		}


	
	public User selectUser(String username) {
		Connection conn = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		User user = null;
		
		try{
			String sql= "select * from user where username =? ";
			user = new User();
			conn = JdbcUtil.getConnection();
			st =conn.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			while(rs.next()){
				if(username.equals(rs.getString("username"))){
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setMajor(rs.getString("major"));
					user.setSex(rs.getString("sex"));
					user.setTruename(rs.getString("truename"));
					user.setPhoto(rs.getString("photo"));
					user.setView_photo(rs.getString("view_photo"));
					user.setTel(rs.getString("tel"));
					
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();		
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(st);
			JdbcUtil.close(conn);
		}
		return user;
		
	}


	
	public boolean updateUser(User user) {
		Connection conn = null;
		PreparedStatement st = null;	
		String sql= "update user set truename=?,tel=?,email=? where username=?"; 
		try{
			conn = JdbcUtil.getConnection();
			st =conn.prepareStatement(sql);
			st.setString(1, user.getTruename());
			st.setString(2, user.getTel());
			st.setString(3, user.getEmail());
			st.setString(4, user.getUsername());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			
			JdbcUtil.close(st);
			JdbcUtil.close(conn);
		}
		
		return true;
	}
	
	public boolean changePass(User user){
		Connection conn = null;
		PreparedStatement st = null;	
		String sql= "update user set password=? where username=?"; 
		try{
			conn = JdbcUtil.getConnection();
			st =conn.prepareStatement(sql);
			st.setString(1, user.getPassword());
			st.setString(2, user.getUsername());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			
			JdbcUtil.close(st);
			JdbcUtil.close(conn);
		}
		
		return true;
	}

	
	public boolean updateStView(User user){
		Connection conn = null;
		PreparedStatement st = null;	
		String	sql =  "Update user set view_photo=? Where username=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, user.getView_photo());
			st.setString(2,user.getUsername());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.close(st);
			JdbcUtil.close(conn);
		}
		return true;
	}
	public boolean updateSt(User user){
		Connection conn = null;
		PreparedStatement st = null;	
		String	sql =  "Update user Set photo=? Where username=?";
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, user.getPhoto());
			st.setString(2,user.getUsername());
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			JdbcUtil.close(st);
			JdbcUtil.close(conn);
		}
		return true;
	}
	
}
