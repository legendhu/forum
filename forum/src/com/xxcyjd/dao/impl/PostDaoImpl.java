package com.xxcyjd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xxcyjd.dao.PostDao;
import com.xxcyjd.domain.Article;
import com.xxcyjd.util.JdbcUtil;

public class PostDaoImpl implements PostDao {

	public void post(Article a) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		try {
			conn = JdbcUtil.getConnection();
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			int rootId = -1;
			int pid = 0;
			String sql="insert into article values (null,?,?,?,?,?,now(),?,?)";
			pstmt = JdbcUtil.prepareStmt(conn, sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,0);
			pstmt.setInt(2,rootId);
			pstmt.setInt(3,0);
			pstmt.setString(4,a.getTitle());
			pstmt.setString(5,a.getContent());
			pstmt.setInt(6,0);  
			pstmt.setString(7,a.getAuthor());
			pstmt.executeUpdate();
			ResultSet rsKey = pstmt.getGeneratedKeys();
			rsKey.next();
			rootId = rsKey.getInt(1);
		    stmt = JdbcUtil.createStmt(conn);
			stmt.executeUpdate("update article set rootId="+rootId+ " where id= " + rootId);
			conn.commit();
			conn.setAutoCommit(autoCommit);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
		
		
		

	}

}
