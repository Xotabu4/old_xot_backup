package com.example.fw;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateHelper extends HelperBase{

	public HibernateHelper(ApplicationManager manager) {
		super(manager);
	}
	
	 public String getLastGroupId() {
	      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction transaction = session.beginTransaction();
	      try {
	        return session.createSQLQuery("SELECT AUTO_INCREMENT FROM information_schema.TABLES where TABLE_SCHEMA = \"addressbook\" and TABLE_NAME = \"group_list\"").uniqueResult().toString();
	      } finally {
	        transaction.commit();
	      }
	    }

	public Set<GroupObject> getGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		try {
		
		List<GroupObject> list = session.createQuery("from GroupObject").list();
		Set<GroupObject> items = new HashSet<GroupObject>(list); 
		session.createQuery("from GroupObject").list();
		
		return items;
		} 
		
		finally {
			transaction.commit();
			}
	}

	 public String getLastContactId() {
	      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction transaction = session.beginTransaction();
	      try {
	        return session.createSQLQuery("SELECT AUTO_INCREMENT FROM information_schema.TABLES where TABLE_SCHEMA = \"addressbook\" and TABLE_NAME = \"addressbook\"").uniqueResult().toString();
	      } finally {
	        transaction.commit();
	      }
	    }
	

	public Set<ContactObject> getContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		try {
		List<ContactObject> list = session.createQuery("from ContactObject").list();
		Set<ContactObject> items = new HashSet<ContactObject>(list); 
		//session.createQuery("from ContactObject").list();
		
		return items;

		}
		finally {
			transaction.commit();
			}
	}
}
