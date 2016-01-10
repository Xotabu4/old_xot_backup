package mainPackage.frameWork.SQL;

import java.util.List;


import mainPackage.frameWork.ApplicationManager;
import mainPackage.frameWork.HelperBase;
import mainPackage.frameWork.Leads_and_Leads_providers.LeadsObject;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateHelper extends HelperBase{

	public HibernateHelper(ApplicationManager manager) {
		super(manager);
	}

	public List<LeadsObject> getLeads() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		try {
		
		List<LeadsObject> list = session.createQuery("from Leads where email = 'mary@dom.com'").list();

		return list;
		} 
		
		finally {
			transaction.commit();
			}
	}

}
