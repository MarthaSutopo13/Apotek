package com.adapters;

import com.others.BaseAdapter;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.entities.M_Customer;

public class M_CustomerAdapter extends BaseAdapter {

//	public String setModule() {
//		return "CU";
//	}
	
	public List<M_Customer> getAllCustomer() {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Customer"
		); 
		List<M_Customer> customerList = query.list();
		session.close();
		return customerList;
    }
	
	public List<M_Customer> getCustomerByIdCustomer(String id_customer) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Customer where id_customer = '"+ id_customer +"'"
		); 
		List<M_Customer> customerList = query.list();
		session.close();
		return customerList;
    }
	
	public List<M_Customer> getCustomerByNamaCustomer(String nama_customer) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Customer where nama_customer like '%"+ nama_customer +"%'"
		); 
		List<M_Customer> customerList = query.list();
		session.close();
		return customerList;
    }
	
	public Boolean deleteByIdCustomer(String id_customer) {
		try {
			Session session = sfApotek.openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery( 
					"Delete from m_customer where id_customer = '" + id_customer + "'"
			); 
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }
}
