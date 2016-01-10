package com.example.fw;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactHelper extends HelperWithWebDriverBase {
	
	private Set<ContactObject> contactModel;
	private int lastContactId;
	
	public ContactHelper (ApplicationManager manager) {
		super(manager);
		
		lastContactId = Integer.parseInt (
				manager.getHibernateHelper().getLastContactId());
	}
	
    public Set<ContactObject> getContacts() {
		
		if (contactModel == null) {
			contactModel = manager.getHibernateHelper().getContacts();
		}
		return contactModel;
	}
	
    public Set<ContactObject> getUiContacts() {
    	
    		HashSet<ContactObject> set  = new HashSet<ContactObject>();
    	
		  manager.getNavigationHelper().openMainPage();
		  WebElement table = findElement(By.id("maintable"));
		  List<WebElement> rows = table.findElements(By.name("entry"));
		   
		  for (WebElement row: rows) {
		   List<WebElement> cells = row.findElements(By.tagName("td"));
		   String fname = cells.get(1).getText();
		   String lname = cells.get(2).getText();
		   String Email = cells.get(3).getText();
		   String Telephone = cells.get(4).getText();
		   
		   ContactObject contact = new ContactObject()
		   .setContactFirstName(lname)
		   .setContactLastName(fname)
		   .setContactEmail(Email)
		   .setContactHomePhone(Telephone)
		   .setId(row.findElement(By.cssSelector("input")).getAttribute("value"));
		   
		   set.add(contact);

		  }
		  return new HashSet<ContactObject>(set);
	}
    
   /* public Set<ContactObject> getPrintPhonesTable() {
    	Set<ContactObject> printContactPhones = new HashSet<ContactObject>();
    	
    	manager.getNavigationHelper().openMainPage();
    	manager.getNavigationHelper().openPrintPhonesPage();
    	WebElement table = findElement(By.id("view"));
    	List<WebElement> rows = table.findElements(By.xpath("/html/body/div/div/table/tbody/tr"));
    	System.out.println(rows);
    	for (WebElement row: rows){
    		List<WebElement> cells = row.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td"));
    		String allCellInfo = cells.get(0).getText();
 		    System.out.println(allCellInfo);
    		//Pattern p = Pattern.compile(".*\\((.*)\\)");
			//Matcher m = p.matcher(allCellInfo);
			//if (m.matches()) {

				//String fnameWithlname = m.group(1);
				//String Email = 
				//String Telephone = null;
					
				
			//}
 		   ContactObject contactCell = new ContactObject()
		   .setContactFirstNameWithLastName(allCellInfo);
		   //.setContactLastName(fname)
		   //.setContactHomePhone(Telephone)
 		  printContactPhones.add(contactCell);
    	}
    	
		//TODO finish this
		return printContactPhones;
	}*/
    
	public void createContact(ContactObject ContactObject) {
		manager.getNavigationHelper().openMainPage();
		clickingAddNewContactlink();
		fillingContactFields(ContactObject);
	    submitCreation();
		manager.getNavigationHelper().clickingHomeLink();
		
		//This "if" needed for correct assertion when creates contact with incorrect data -
		                  //no need to add contact to model, because contact not added in this case
		
		if (ContactObject.contactFirstName != "!@#$%^&*()_+-='"){
			
			ContactObject.setId("" + lastContactId);
			contactModel.add(ContactObject);
			lastContactId = Integer.parseInt ( manager.getHibernateHelper().getLastContactId());
		}	
	}
	
	public void removeContact(ContactObject ContactToRemove) {

		manager.getNavigationHelper().openMainPage();
		clickOnEditContact(ContactToRemove);
		click(By.xpath("//input[@name='update' and @value='Delete']"));
		manager.getNavigationHelper().clickingHomeLink();
		contactModel.remove(ContactToRemove);
		
	}
	
    public void ModifyContact(ContactObject oldContact, ContactObject modifiedContact) {
		
		clickOnEditContact(oldContact);
		fillingContactFields(modifiedContact);
		click(By.xpath("//html/body/div/div[4]/form/input[11]"));
		
		modifiedContact.setId(oldContact.id);

		contactModel.remove(oldContact);
		
		contactModel.add(modifiedContact);
		
		manager.getNavigationHelper().openMainPage();
		
	}
	
	protected void clickingAddNewContactlink() {
		
		click(By.linkText("add new"));
	}
	
	protected void fillingContactFields(ContactObject ContactObject) {
		
		type("firstname", ContactObject.contactFirstName);
		type("lastname", ContactObject.contactLastName);
		type("address", ContactObject.contactAddressText);
		type("home", ContactObject.contactHomePhone);
		type("mobile", ContactObject.contactMobilePhone);
		type("work", ContactObject.contactWork);
		type("email", ContactObject.contactEmail);
		type("email2", ContactObject.contactEmail2);
		type("byear", ContactObject.contactByEar);
		type("address2", ContactObject.contactAddress2);
		type("phone2", ContactObject.contactPhone2);
		
		//This "if" added, because some tests not contain dropdown selects. (Incorrect info, modifyContact)
		if (ContactObject.bdaySelect != 0){
			dropdownSelect("bday", ContactObject.bdaySelect);
		}
		
		if (ContactObject.bmountSelect != 0){
			dropdownSelect("bmonth", ContactObject.bmountSelect);
		}
		
		if (ContactObject.groupSelect != 0){
			dropdownSelect("new_group", ContactObject.groupSelect);
		}
		
	}
	
	private void submitCreation() {
		click(By.name("submit"));
	}

	private void clickOnEditContact(ContactObject Contact) {
		//I find "Edit" image by css add "someContact" id to this query and click on matching link
		click(By.cssSelector(".center>a[href='edit.php?id=" + Contact.id + "']"));
	}

	public ContactObject getSomeContact() {
		
		ContactObject someContact = contactModel.iterator().next();
		
		return someContact;
	}

}

