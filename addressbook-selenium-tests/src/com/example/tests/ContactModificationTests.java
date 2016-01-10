	package com.example.tests;
	
import java.util.Set;
import org.testng.annotations.Test;
import com.example.fw.ContactObject;
	
	public class ContactModificationTests extends TestBase {
			
	@Test
		
	public void testContactCanBeModified() throws Exception{
	
	Set<ContactObject> oldList = app.getContactHelper().getContacts();
	
	ContactObject oldContact = app.getContactHelper().getSomeContact();

	ContactObject modifiedContact = new ContactObject ()
	        .setContactFirstName("FirstNameTextModified") 
	        .setContactLastName("LastNameTextModified") 
	        .setContactAddressText("addressTextModified")
			.setContactHomePhone("0987654321")
			.setContactMobilePhone("0987654321")
			.setContactWork("workTextModified" )
			.setContactEmail("emailModified@mail.mail")
			.setContactEmail2("email2Modified@mail.mail")
			.setContactByEar("1992")
			.setContactAddress2("address2TextModified")
			.setContactPhone2("0987654321")
			.setBdaySelect(5)
			.setBmountSelect(4);	
	
	//Action
	
	app.getContactHelper().ModifyContact(oldContact, modifiedContact);
	System.out.println("Old list" + oldList);
	oldList = app.getContactHelper().getContacts();
	//Verification
	Set<ContactObject> dBList = app.getHibernateHelper().getContacts();
	System.out.println("DB list" + dBList);
	app.getVerifyHelper().verifyContacts(oldList, dBList);
	}
	
	}
