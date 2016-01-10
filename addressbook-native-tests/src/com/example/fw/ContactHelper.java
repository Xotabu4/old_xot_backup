package com.example.fw;

public class ContactHelper extends HelperBase{

	protected ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);

	}

	public void createContact(Contact contact) {
		initContactCreation();
		
		fillContactForm(contact);
		
		confirmContactCreation();
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("Add")
		.winWaitAndActivate("Add Contact", "", 5000);
	}
	
	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
		.send("TDBEdit12", contact.firstName)
		.send("TDBEdit11", contact.lastName);
	}
	
	private void confirmContactCreation() {
		manager.getAutoItHelper()
		.click("Save")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	public Contact getFirstContact() {
		selectFirstContact();
			manager.getAutoItHelper().click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
		.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
		.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
			.click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;
	}

	public void selectFirstContact() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("TListView1")
			.send("{DOWN}{SPACE}");
	}

	public void removeFirstContact() {
		selectFirstContact();
		manager.getAutoItHelper().click("Delete")
		.winWaitAndActivate("Confirm", "", 5000)
		.click("TButton2")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	public void checkContactRemoved() {
		selectFirstContact();
		//I click on edit, and look for Information window, it means that edit window not opened, so no contacts is presented in list.
		manager.getAutoItHelper().click("Edit")
		.winWaitAndActivate("Information", "", 5000)
		.click("OK");
		
	}

}
