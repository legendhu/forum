package com.xxcyjd.dao.factory;

import com.xxcyjd.dao.ArticleDao;
import com.xxcyjd.dao.impl.ArticleDaoImpl;

public class ArticleDaoFactory {
	public static ArticleDao getInstance(){
		return new ArticleDaoImpl();
	}

}
