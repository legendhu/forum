package com.xxcyjd.dao;

import com.xxcyjd.domain.User;

public interface UserDao {
	public boolean insert(User u);
	public int select(User user);
	public User selectUser(String username);
	public boolean updateUser(User user);
	public boolean changePass(User user);
	public boolean updateStView(User user);
	public boolean updateSt(User user);

}
