package com.xz.user.service;

import java.util.List;

import com.xz.user.entity.User;

public interface IUserManager {
	public abstract boolean addUser(User user);

	public abstract boolean delUser(User user);

	public abstract boolean updateUser(User user);

	public abstract User getOneUser(User user);

	public abstract List<User> getAllUser();
}
