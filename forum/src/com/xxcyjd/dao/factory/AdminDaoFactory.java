package com.xxcyjd.dao.factory;

import com.xxcyjd.dao.AdminDao;
import com.xxcyjd.dao.impl.AdminDaoImpl;

public class AdminDaoFactory {
	public static AdminDao getInstance(){
		return new AdminDaoImpl();
	}

}
