package com.xxcyjd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xxcyjd.dao.ArticleDetailDao;
import com.xxcyjd.domain.Article;
import com.xxcyjd.util.JdbcUtil;

public class ArticleDetaiDaoImpl implements ArticleDetailDao{
	public Article selectArticleDetail(int id){
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = JdbcUtil.createStmt(conn);
		String sql = "select * from article where id = " + id;
		ResultSet rs = JdbcUtil.executeQuery(stmt, sql);
		Article a = null;
		try {
			if(rs.next()){
				a = new Article();
				a.initFromRs(rs);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
		return a;
		
	
	}

	//查询所有的子帖
	public List<Article> selectKids(int id) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Article> kids = null;
		
		try {
				conn = JdbcUtil.getConnection();
				stmt= JdbcUtil.createStmt(conn);
				String sql = "select * from article where rootid = " + id + " order by date asc";
				rs = JdbcUtil.executeQuery(stmt, sql);
				kids= new ArrayList<Article>();
				while(rs.next()){
					Article a  = new Article();
					a.initFromRs(rs);
					kids.add(a);
				}
			}catch (SQLException e) {
			e.printStackTrace();
			}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
			}
		return kids;
	}
	
}
