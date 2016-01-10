package com.example.tests;

import java.util.Set;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.example.fw.ContactObject;
import com.example.fw.GroupObject;

public class DBTests extends TestBase {
	
	private Logger log = Logger.getLogger("DbTests");
	
	@Test

    public void testGroupsCanBeRecieved() throws Exception {
		log.info("testInfoFromDbCanBeRecieved start");
		
		System.out.println(app.getHibernateHelper().getGroups());
		
		log.info("testInfoFromDbCanBeRecieved end");
    }
	
	@Test

    public void testContactCanBeRecieved() throws Exception {
		log.info("testContactCanBeRecieved start");
		
		System.out.println(app.getHibernateHelper().getContacts());
		
		log.info("testContactCanBeRecieved end");
    }
	
	@Test

    public void testGroupsUiAndDbConformsWithGroupsModel() {
		log.info("Checking parameter for launch this test");
		
		if (app.getProperty("CheckDB") != "false"){
			
		log.info("Parameter = true");
			
			Set<GroupObject> modelList = app.getGroupHelper().getGroups();
			Set<GroupObject> dBList = app.getHibernateHelper().getGroups();
			Set<GroupObject> UiList = app.getGroupHelper().getUiGroups();
		
			app.getVerifyHelper().verifyGroups(dBList, modelList);
			app.getVerifyHelper().verifyGroups(UiList, modelList);
			app.getVerifyHelper().verifyGroups(UiList, dBList);
		
		log.info("testGroupsUiConformsWithGroupsDB end");
		}
			else {
		log.info("Parameter = false. testGroupsUiAndDbConformsWithGroupsModel will not be performed");
			}
		
		}
		
	@Test

	public void testContactUiAndDbConformsWithContactModel() {
		log.info("Checking parameter for launch testContactUiAndDbConformsWithContactModel");
			
			if (app.getProperty("CheckDB") != "false"){
				
		log.info("Parameter = true. Starting of testContactUiAndDbConformsWithContactModel");
				
			Set<ContactObject> modelList = app.getContactHelper().getContacts();
			log.info("modelList "+modelList);
			Set<ContactObject> dBList = app.getHibernateHelper().getContacts();
			log.info("dBList "+dBList);
			Set<ContactObject> UiList = app.getContactHelper().getUiContacts();
			log.info("UiList "+UiList);
			
			app.getVerifyHelper().verifyContacts(dBList, modelList);
			app.getVerifyHelper().verifyContacts(UiList, modelList);
			app.getVerifyHelper().verifyContacts(UiList, dBList);
			
		log.info("testContactUiAndDbConformsWithContactModel end");
			}
			else {
		log.info("Parameter = false. testContactUiAndDbConformsWithContactModel not be performed");
			}		
	
  
    	}

}
