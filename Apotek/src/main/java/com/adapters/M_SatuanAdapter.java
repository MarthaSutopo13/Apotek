package com.adapters;

import com.entities.M_Satuan;
import com.others.BaseAdapter;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class M_SatuanAdapter extends BaseAdapter {

//	public String setModule() {
//		return "MU-";
//	}
	
	public List<M_Satuan> getAllSatuan() {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Satuan"
		); 
		List<M_Satuan> satuanList = query.list();
		session.close();
		return satuanList;
    }
	
	public List<M_Satuan> getSatuanByIdSatuan(String id_satuan) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Satuan where id_satuan = '"+ id_satuan +"'"
		); 
		List<M_Satuan> satuanList = query.list();
		session.close();
		return satuanList;
    }
	
	public List<M_Satuan> getSatuanByNamaSatuan(String nama_satuan) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Satuan where nama_satuan like '%"+ nama_satuan +"%'"
		); 
		List<M_Satuan> satuanList = query.list();
		session.close();
		return satuanList;
    }
	
	public Boolean deleteByIdSatuan(String id_satuan) {
		try {
			Session session = sfApotek.openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery( 
					"Delete from m_satuan where id_satuan = '" + id_satuan + "'"
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
