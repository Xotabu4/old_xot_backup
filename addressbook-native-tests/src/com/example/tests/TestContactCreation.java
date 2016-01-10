package com.example.tests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.example.fw.Contact;



public class TestContactCreation extends TestBase{
	
	@Test
	public void shouldCreateCotnactWithValidData(){
		Contact contact = new Contact().setFirstName("tester").setLastName("test");
		app.getContactHelper().createContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);
		
		//Clear the added contact for correct running next text.
		app.getContactHelper().removeFirstContact();
	}

}
