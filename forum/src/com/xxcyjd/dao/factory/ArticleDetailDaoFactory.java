package com.xxcyjd.dao.factory;

import com.xxcyjd.dao.ArticleDetailDao;
import com.xxcyjd.dao.impl.ArticleDetaiDaoImpl;

public class ArticleDetailDaoFactory {
	public static ArticleDetailDao getInstance(){
		return new ArticleDetaiDaoImpl();
	}

}
