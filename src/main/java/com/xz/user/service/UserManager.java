package com.xz.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.user.dao.IUserDao;
import com.xz.user.entity.User;

@Service
public class UserManager implements IUserManager {
	@Autowired
	private IUserDao userDao;

	@Override
	public User getOneUser(User user) {
		return userDao.getOneUser(user);
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean delUser(User user) {
		return userDao.delUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
}
