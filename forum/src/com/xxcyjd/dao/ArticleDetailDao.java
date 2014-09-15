package com.xxcyjd.dao;

import java.util.List;

import com.xxcyjd.domain.Article;

public interface ArticleDetailDao {
	public Article selectArticleDetail(int id);
	public List<Article> selectKids(int id);
	
}
