package com.xz.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xz.user.entity.User;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	@Override
	public boolean delUser(User user) {
		User user1 = this.getOneUser(user);
		sessionFactory.getCurrentSession().delete(user1);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User");
		List<User> userlist = query.list();
		return userlist;
	}

	public User getOneUser(User user) {
		User user1 = (User) sessionFactory.getCurrentSession().load(User.class,
				user.getId());
		return user1;
	}
}
