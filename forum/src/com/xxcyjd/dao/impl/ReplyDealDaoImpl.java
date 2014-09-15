package com.xxcyjd.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import com.xxcyjd.dao.ReplyDealDao;
import com.xxcyjd.domain.Article;
import com.xxcyjd.util.JdbcUtil;

public class ReplyDealDaoImpl implements ReplyDealDao {

	
	public void insert(Article a) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		try {
			conn = JdbcUtil.getConnection();
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			String sql="insert into article values (null,?,?,?,?,?,now(),?,?)";
			pstmt = JdbcUtil.prepareStmt(conn, sql);
			pstmt.setInt(1,a.getPid());
			pstmt.setInt(2,a.getRootId());
			pstmt.setInt(3,a.getCount());
			pstmt.setString(4,a.getTitle());
			pstmt.setString(5,a.getContent());
			pstmt.setInt(6,0);  
			pstmt.setString(7,a.getAuthor());
			pstmt.executeUpdate();
		    stmt = JdbcUtil.createStmt(conn);
			stmt.executeUpdate("update article set isLeaf=1,count=count+1 where id="+a.getPid());
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
