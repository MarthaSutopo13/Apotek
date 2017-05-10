package com.adapters;

import com.entities.M_Kategori;
import com.others.BaseAdapter;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class M_KategoriAdapter extends BaseAdapter {

//	public String setModule() {
//		return "MU-";
//	}
	
	public List<M_Kategori> getAllKategori() {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Kategori"
		); 
		List<M_Kategori> kategoriList = query.list();
		session.close();
		return kategoriList;
    }
	
	public List<M_Kategori> getKategoriByIdKategori(String id_kategori) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Kategori where id_kategori = '"+ id_kategori +"'"
		); 
		List<M_Kategori> kategoriList = query.list();
		session.close();
		return kategoriList;
    }
	
	public List<M_Kategori> getKategoriByNamaKategori(String nama_kategori) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Kategori where nama_kategori like '%"+ nama_kategori +"%'"
		); 
		List<M_Kategori> kategoriList = query.list();
		session.close();
		return kategoriList;
    }
	
	public Boolean deleteByIdKategori(String id_kategori) {
		try {
			Session session = sfApotek.openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery( 
					"Delete from m_kategori where id_kategori = '" + id_kategori + "'"
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
