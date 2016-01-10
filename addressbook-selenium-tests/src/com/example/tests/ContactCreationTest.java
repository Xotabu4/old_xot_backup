	package com.example.tests;
	
	import java.util.Set;

import org.testng.annotations.Test;

import com.example.fw.ContactDataGenerator;
import com.example.fw.ContactObject;
	
	public class ContactCreationTest extends TestBase {
		
	
	@Test 
	(dataProvider = "contactsFromFile", dataProviderClass = ContactDataGenerator.class)	
	
	public void testContactWithValidDataCanBeCreated(ContactObject validContact) throws Exception {
		
	Set<ContactObject> oldList = app.getContactHelper().getContacts();
	//Action
	app.getContactHelper().createContact(validContact);
	//Verification
	Set<ContactObject> newList = app.getHibernateHelper().getContacts();
	app.getVerifyHelper().verifyContacts(oldList, newList);
	
	}
	
	
	@Test
	public void testContactWithEmptyDataCanBeCreated() throws Exception {
		//This test will leave blank text fields. Dropdowns is skipped.
	ContactObject EmptyContact = new ContactObject()
		.setContactFirstName("")
		.setContactLastName("")
		.setContactAddressText("")
		.setContactHomePhone("")
		.setContactMobilePhone("")
		.setContactWork("")
		.setContactEmail("")
		.setContactEmail2("")
		.setContactByEar("")
		.setContactAddress2("")
		.setContactPhone2("");	
	
	
	Set<ContactObject> oldList = app.getContactHelper().getContacts();
	//Action
	app.getContactHelper().createContact(EmptyContact);
	//Verification
	Set<ContactObject> newList = app.getHibernateHelper().getContacts();
	app.getVerifyHelper().verifyContacts(oldList, newList);
	
	}
	
	
	@Test
	public void testContactWithIncorrectDataCantBeCreated() throws Exception {
		//This test will try to create contact with symbols in text fields
	ContactObject IncorrectContact = new ContactObject().setContactFirstName("!@#$%^&*()_+-='")
		.setContactLastName("!@#$%^&*()_+-='")
		.setContactAddressText("!@#$%^&*()_+-='")
		.setContactHomePhone("!@#$%^&*()_+-='")
		.setContactMobilePhone("!@#$%^&*()_+-='")
		.setContactWork("!@#$%^&*()_+-='")
		.setContactEmail("!@#$%^&*()_+-='")
		.setContactEmail2("!@#$%^&*()_+-='")
		.setContactByEar("!@#$%^&*()_+-='")
		.setContactAddress2("!@#$%^&*()_+-='")
		.setContactPhone2("!@#$%^&*()_+-='")
		.setBdaySelect(7)
		.setBmountSelect(3)
		.setGroupSelect(3);	
	
	    
	    Set<ContactObject> oldList = app.getContactHelper().getContacts();
		//Action
	    app.getContactHelper().createContact(IncorrectContact);
		//Verification
		Set<ContactObject> newList = app.getHibernateHelper().getContacts();
		app.getVerifyHelper().verifyContacts(oldList, newList);
	}
	
	}