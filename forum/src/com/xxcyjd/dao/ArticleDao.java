package com.xxcyjd.dao;

import java.sql.Connection;
import java.util.List;

import com.xxcyjd.domain.Article;

public interface ArticleDao {
	public void tree(List<Article> articles, int id , int grade);
	public List<Article> selectRoots();
	//public int getTotalRecord();
	//public List getPageArticle(int startindex, int pagesize);
}
