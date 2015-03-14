package com.xz.user.dao;

import java.util.List;

import com.xz.user.entity.User;

public interface IUserDao {
	public abstract boolean addUser(User user);

	public abstract boolean delUser(User user);

	public abstract boolean updateUser(User user);

	public abstract List<User> getAllUser();

	public abstract User getOneUser(User user);
}
