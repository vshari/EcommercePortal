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
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
		// TODO Auto-generated constructor stub
	}

	public List<Supplier> list() {
		
		// select * from category -SQL query - mention the table name
		//return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Supplier> suppliers = session.createQuery("from Category").list();
		tx.commit();
		session.flush();
		session.close();
		return suppliers;

	}

	@Transactional

	public boolean save(Supplier supplier) {

		try {
			// sessionFactory.getCurrentSession().save(category);
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(supplier);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Supplier supplier) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.saveOrUpdate(supplier);

			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getSupplierByID(id));
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
				sessionFactory.getCurrentSession().delete(getSupplierBYName(name));
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(name);
				session.getTransaction().commit();
				session.flush();
				session.close();
				
				return true;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return false;
			}
	}

	public boolean delete(Supplier supplier) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(supplier);
			session.getTransaction().commit();
			session.flush();
			session.close();

			return true;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public Supplier getSupplierByID(int id) {
		// get method means ->select * from Category where id=?
		// return (Category)
		// sessionFactory.getCurrentSession().get(Category.class, id);
		// here get method is excepting a class
		// we can write query also as below here + is concatenation
		// 1->sessionFactory.getCurrentSession().createQuery("from Category
		// where id= '"+id+"'" ).list().get(0);
		// 1st or 2nd query meaning same
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where id= '" + id + "'")
				.uniqueResult();
	}

	public Supplier getSupplierBYName(String name) {

		// here based on name we are fetching the record
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where name= '" + name + "'")
				.list().get(0);
	}

}
