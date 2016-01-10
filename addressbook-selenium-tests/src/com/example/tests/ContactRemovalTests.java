package com.example.tests;

import java.util.Set;

import org.testng.annotations.Test;

import com.example.fw.ContactObject;

public class ContactRemovalTests extends TestBase {

	
	
	@Test
	
	public void testContactCanBeRemoved() throws Exception {
      
		Set<ContactObject> oldList = app.getContactHelper().getContacts();
		ContactObject ContactToRemove = app.getContactHelper().getSomeContact();
		//Action
		app.getContactHelper().removeContact(ContactToRemove);
		//Verification
		Set<ContactObject> newList = app.getHibernateHelper().getContacts();
		app.getVerifyHelper().verifyContacts(oldList, newList);
	}
	
}

