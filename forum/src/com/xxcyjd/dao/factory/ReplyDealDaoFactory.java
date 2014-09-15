package com.xxcyjd.dao.factory;

import com.xxcyjd.dao.ReplyDealDao;
import com.xxcyjd.dao.impl.ReplyDealDaoImpl;

public class ReplyDealDaoFactory {
	public static ReplyDealDao getInstance(){
		return new ReplyDealDaoImpl();
	}
}
