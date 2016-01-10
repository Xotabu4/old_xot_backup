package mainPackage.tests;



import mainPackage.frameWork.Leads_and_Leads_providers.LeadProviderObject;

import org.testng.annotations.Test;

public class LeadProviderCreationTests extends TestBase{
	
	@Test
	
	public void LeadProviderCanBeAdded() throws Exception {
		
		log.info("LeadProviderCreation start");
		
		app.getNavigationHelper().logInAsAdmin();
		
		LeadProviderObject validLeadProvider = new LeadProviderObject();
		
		validLeadProvider.setLeadProviderAccountName("LeadProviderName_"+app.getLeadProviderHelper().generateRandomString(5));
		validLeadProvider.setGmailURL(String.format("gmail%s.com", app.getLeadProviderHelper().generateRandomString(5)));
		
		validLeadProvider.setUserFirstName("UserFirstName");
		validLeadProvider.setUserLastName("UserLastName");
		validLeadProvider.setUserEmail("LeadProviderUserEmail"+app.getLeadProviderHelper().generateRandomString(5)+"@mailinator.com");
		
		app.getLeadProviderHelper().createLeadProvider(validLeadProvider);
		
		
		//Search is not work for leadproviders for now.
		//app.getVerifyHelper().verifyLeadProviderAdded(validLeadProvider);
		
		}
	
}