package com.adapters;

import com.entities.M_Barang;
import com.others.BaseAdapter;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class M_BarangAdapter extends BaseAdapter {

//	public String setModule() {
//		return "MU-";
//	}
	
	public List<M_Barang> getAllBarang() {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Barang"
		); 
		List<M_Barang> barangList = query.list();
		session.close();
		return barangList;
    }
	
	public List<M_Barang> getBarangByIdBarang(String id_barang) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Barang where id_barang = '"+ id_barang +"'"
		); 
		List<M_Barang> barangList = query.list();
		session.close();
		return barangList;
    }
	
	public List<M_Barang> getBarangByNamaBarang(String nama_barang) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Barang where nama_barang like '%"+ nama_barang +"%'"
		); 
		List<M_Barang> barangList = query.list();
		session.close();
		return barangList;
    }
	
	public Boolean deleteByIdBarang(String id_barang) {
		try {
			Session session = sfApotek.openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery( 
					"Delete from m_barang where id_barang = '" + id_barang + "'"
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
