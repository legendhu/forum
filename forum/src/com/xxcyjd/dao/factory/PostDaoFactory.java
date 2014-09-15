package com.xxcyjd.dao.factory;

import com.xxcyjd.dao.PostDao;
import com.xxcyjd.dao.impl.PostDaoImpl;

public class PostDaoFactory {
	public static PostDao getInstance(){
		return new PostDaoImpl();
	}

}
