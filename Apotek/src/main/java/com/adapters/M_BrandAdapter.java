package com.adapters;

import com.entities.M_Brand;
import com.models.KendoWindowBrowse;
import com.others.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class M_BrandAdapter extends BaseAdapter {

//	public String setModule() {
//		return "MU-";
//	}
	
	public List<M_Brand> getAllBrand() {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Brand"
		); 
		List<M_Brand> brandList = query.list();
		session.close();
		return brandList;
    }
	
	public List<M_Brand> getBrandByIdBrand(String id_brand) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Brand where id_brand = '"+ id_brand +"'"
		); 
		List<M_Brand> brandList = query.list();
		session.close();
		return brandList;
    }
	
	public List<M_Brand> getBrandByNamaBrand(String nama_brand) {
		Session session = sfApotek.openSession();
		Query query = session.createQuery(  
				"from M_Brand where nama_Brand like '%"+ nama_brand +"%'"
		); 
		List<M_Brand> brandList = query.list();
		session.close();
		return brandList;
    }
	
	public Boolean deleteByIdBrand(String id_brand) {
		try {
			Session session = sfApotek.openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery( 
					"Delete from m_brand where id_brand = '" + id_brand + "'"
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
	
	public List<KendoWindowBrowse> getWindowDataBrand(String search) { 
		Session session = sfApotek.openSession();
		Query query = session.createQuery(
				"from M_Brand where (upper(nama_brand) like :search or upper(nama_brand) like :search) order by id_brand asc"
		).setString("search", "%"+search.toUpperCase()+"%")
		.setMaxResults(1000);  
		List<M_Brand> brand = query.list(); 
		session.close();
		List<KendoWindowBrowse> list = new ArrayList<KendoWindowBrowse>();
		for (int i = 0; i < brand.size(); i++) {
			list.add(new KendoWindowBrowse(brand.get(i).getId_brand(), brand.get(i).getNama_brand()));
		}
		return list;
    }
}
