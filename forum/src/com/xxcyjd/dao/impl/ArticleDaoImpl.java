package com.xxcyjd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.xxcyjd.dao.ArticleDao;
import com.xxcyjd.domain.Article;
import com.xxcyjd.util.JdbcUtil;

public class ArticleDaoImpl implements ArticleDao {

	public void tree(List<Article> articles, int id , int grade) {
		String sql = "select * from article where pid = "+id;
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = JdbcUtil.createStmt(conn);
		ResultSet rs = JdbcUtil.executeQuery(stmt,sql);
		try{
			while(rs.next()){
				Article a = new Article();
				a.initFromRs(rs);
				a.setGrade(grade);
				articles.add(a);
				if(!a.isLeaf()){
					tree(articles,a.getId(),grade+1);
				}
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
		
	}

	//查询所有的主帖
	public List<Article> selectRoots() {
		List<Article> roots = new ArrayList<Article>();
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = JdbcUtil.createStmt(conn);
		ResultSet rs = JdbcUtil.executeQuery(stmt, "select * from article where pid = 0");
		try {
			while(rs.next()){
				Article a = new Article();
				a.initFromRs(rs);
				roots.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
		return roots;
	}
	
	/*public int getTotalRecord(){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try{
			conn  = JdbcUtil.getConnection();
			String sql = "select count(*) from article";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(st);
			JdbcUtil.close(conn);
		}
		
		return 0;
	}*/
	
	
	/*public List getPageArticle(int startindex, int pagesize) {
		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List articles = new ArrayList();
		
		try{
			conn = JdbcUtil.getConnection();
			String sql = "select * from article order by date desc limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1,startindex);
			st.setInt(2,pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				Article article = new Article();
				article.initFromRs(rs);
				articles.add(article);
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(st);
			JdbcUtil.close(conn);
			
		}
		return articles;
		
	}*/

}
