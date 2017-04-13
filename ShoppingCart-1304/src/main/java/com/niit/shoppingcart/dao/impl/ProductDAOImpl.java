package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
		// TODO Auto-generated constructor stub
	}

	public List<Product> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Product> products = session.createQuery("from Product").list();
		tx.commit();
		session.flush();
		session.close();
		return products;
		// select * from category -SQL query - mention the table name
		// march 27th sunday
		// return sessionFactory.getCurrentSession().createQuery("from
		// Product").list();

	}

	public boolean save(Product product) {

		try {
			// sessionFactory.getCurrentSession().save(category);
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Product product) {

		try {
			System.out.println("ProductDao Update is called");
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(product);

			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("ProductDao Update finished");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(id);
			session.getTransaction().commit();
			session.flush();
			session.close();

			return true;
		} catch (Exception e) {
			// e.printStackTrace();->it will print the exception in console
			// it will print package,class,method line number from which place
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletebyname(String name) {
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(name));
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(name);
			session.getTransaction().commit();
			session.flush();
			session.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
			session.flush();
			session.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductByID(String id) {
		// get method means ->select * from Category where id=?
		// return (Category)
		// sessionFactory.getCurrentSession().get(Category.class, id);
		// here get method is excepting a class
		// we can write query also as below here + is concatenation
		// 1->sessionFactory.getCurrentSession().createQuery("from Category
		// where id= '"+id+"'" ).list().get(0);
		// 1st or 2nd query meaning same
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id= '" + id + "'")
				.uniqueResult();
	}

	public Product getProductBYName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = (Product) session.createQuery("from Product where name='" + name + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return product;

		// here based on name we are fetching the record
		// correct---->return (Product)
		// sessionFactory.getCurrentSession().createQuery("from Product where
		// name= '" + name + "'").list().get(0);

	}

	public Product getProductByID(int id) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id= " + id).uniqueResult();
	}

}
