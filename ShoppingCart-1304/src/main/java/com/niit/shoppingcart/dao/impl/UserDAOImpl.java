package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

import org.hibernate.Transaction;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// List All users
	public List<User> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> users = session.createQuery("from User").list();

		tx.commit();

		session.flush();
		session.close();
		return users;

	}

	// GetUserById
	public User getUser(int id) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			User user = (User) session.get(User.class, id);
			tx.commit();
			session.flush();
			session.close();
			return user;

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// GetUserByName
	public User getUserByName(String name) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "from User where name='" + name + "'";

			User user = (User) session.createQuery(hql).uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return user;

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// save user
	public boolean save(User user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			user.setRole("ROLE_USER");
			user.setEnable(true);
			session.save(user);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			System.out.println("exception occured******");
			e.printStackTrace();
			return false;
		}

	}

	// upadating the user
	public boolean update(User user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// validate the User
	public boolean validate(String name, String password) {
		// select * from user where id='manu' and password='manu';
		// String hql="from user where id='manu' and password='manu';

		String hql = "from User where name='" + name + "'and password='" + password + "'";
		Session session = sessionFactory.openSession();
		User user = (User) session.createQuery(hql).uniqueResult();
		session.close();
		if (user == null)
			return false;

		return true;
	}
}