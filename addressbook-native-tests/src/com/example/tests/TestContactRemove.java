package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.Contact;



public class TestContactRemove extends TestBase{
	
	@Test
	public void shoudRemoveContact(){
		//Creating contact for test
		Contact contact = new Contact().setFirstName("tester").setLastName("test");
		app.getContactHelper().createContact(contact);
		//Removing the contact
		app.getContactHelper().removeFirstContact();
		app.getContactHelper().checkContactRemoved();

	}

}
