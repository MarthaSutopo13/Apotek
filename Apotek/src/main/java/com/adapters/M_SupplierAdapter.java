package com.adapters;

import com.others.BaseAdapter;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.entities.M_Supplier;

public class M_SupplierAdapter extends BaseAdapter {

//	public String setModule() {
//		return "MU-";
//	}
	
	public List<M_Supplier> getAllSupplier() {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Supplier"
		); 
		List<M_Supplier> supplierList = query.list();
		session.close();
		return supplierList;
    }
	
	public List<M_Supplier> getSupplierByIdSupplier(String id_supplier) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Supplier where id_supplier = '"+ id_supplier +"'"
		); 
		List<M_Supplier> supplierList = query.list();
		session.close();
		return supplierList;
    }
	
	public List<M_Supplier> getSupplierByNamaSupplier(String nama_supplier) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Supplier where nama_supplier like '%"+ nama_supplier +"%'"
		); 
		List<M_Supplier> supplierList = query.list();
		session.close();
		return supplierList;
    }
	
	public Boolean deleteByIdSupplier(String id_supplier) {
		try {
			Session session = sfApotek.openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery( 
					"Delete from m_supplier where id_supplier = '" + id_supplier + "'"
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
