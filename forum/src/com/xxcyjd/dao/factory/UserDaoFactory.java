package com.xxcyjd.dao.factory;

import com.xxcyjd.dao.UserDao;
import com.xxcyjd.dao.impl.UserDaoImpl;

public class UserDaoFactory {
	public static UserDao getInstance(){
		return new UserDaoImpl();
	}
}
