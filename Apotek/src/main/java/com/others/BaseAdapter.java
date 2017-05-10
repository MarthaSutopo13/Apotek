package com.others;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseAdapter {
	
	@Autowired 
	@Qualifier("sfApotek")  
	protected SessionFactory sfApotek;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sfApotek = sessionFactory;
    }
	
	public boolean addObject(Object object) {
        Session session = sfApotek.openSession();
        try {
	        session.beginTransaction();
	        session.save(object);
	        session.getTransaction().commit();
        } catch(HibernateException e) { 
        	session.getTransaction().rollback(); 
        	return false;
        } finally {
        	session.close();
        }
        return true;
    }
	
	public boolean deleteObject(Object object, String docNo) {
    	Session session = sfApotek.openSession();
        try {
	        session.beginTransaction();
	        session.load(object,docNo);
	        session.delete(object);
	        session.getTransaction().commit();
        } catch(HibernateException e) { 
        	session.getTransaction().rollback(); 
        	return false;
        } finally {
        	session.close();
        }
        return true;
    }
    
    public boolean updateObject(Object object) {
    	Session session = sfApotek.openSession();
        try {
	        session.beginTransaction();
	        session.update(object);
	        session.getTransaction().commit();
        } catch(HibernateException e) { 
        	session.getTransaction().rollback(); 
        	System.out.println(e);
        	return false;
        } finally {
        	session.close();
        }
        return true;
    }
    
//    public String getDocNoBW(String moduleCode, String groupCode){
//    	Session session = sfApotek.openSession();
//        try {
//        	Query query = session.createSQLQuery(
//    			"SELECT MYRSAPBW.GETDOCNO('"+ moduleCode +"', '"+ groupCode +"') FROM DUAL"  
//    		);  
//        	System.out.println("1");
//    		Object docNoList = query.uniqueResult();
//    		System.out.println("2");
//    		System.out.println(docNoList);
//    		return docNoList.toString();
//        } catch(HibernateException e) { 
//        	session.getTransaction().rollback(); 
//        	return null;
//        } finally {
//        	session.close();
//        }
//	}

}
