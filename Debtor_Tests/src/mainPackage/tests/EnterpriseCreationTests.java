package mainPackage.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.logging.Logger;

import mainPackage.frameWork.Enterprise.EnterpriseDataGenerator;
import mainPackage.frameWork.Enterprise.EnterpriseUserObject;


public class EnterpriseCreationTests extends TestBase {
private Logger log = Logger.getLogger("GroupCreationTests");

 
	@Test
	(dataProvider = "enterpiseFromFile", dataProviderClass = EnterpriseDataGenerator.class)
	public void EnterpriseCanBeAdded(EnterpriseUserObject validEnterprise) throws Exception {
		
		log.info("EnterpriseCanBeAdded start");
		
		app.getNavigationHelper().logInAsAdmin();
		
		
		validEnterprise.setEnterpriseUserEmail("EntUser_"+app.getEnterpriseHelper().generateRandomString(5)+"@mailinator.com");
		validEnterprise.setEnterpriseName("EntName"+app.getEnterpriseHelper().generateRandomString(5));
		
		app.getEnterpriseHelper().createEnterprise(validEnterprise);
		
		app.getVerifyHelper().verifyEnterpriseAdded(validEnterprise);
		
		}
	
	@Test
	(dataProvider = "enterpiseFromFile", dataProviderClass = EnterpriseDataGenerator.class)
	public void EnterpriseCanBeAddedWithExistingNameThatCorrectedToNonExistingName(EnterpriseUserObject validEnterprise) throws Exception {
		log.info("EnterpriseCanBeAdded start");
		
		app.getNavigationHelper().logInAsAdmin();
		
		
		validEnterprise.setEnterpriseUserEmail("EntUser_"+app.getEnterpriseHelper().generateRandomString(5)+"@mailinator.com");
		validEnterprise.setEnterpriseName("AmeriCal");
		
		app.getEnterpriseHelper().createEnterprise(validEnterprise);
		
		app.getVerifyHelper().verifyExistNameErrorIsAppear();
		
		validEnterprise.setEnterpriseName("EntName"+app.getEnterpriseHelper().generateRandomString(5));
		
		app.getEnterpriseHelper().type(By.id(app.getEnterpriseHelper().MakeFullLink("tbResellerName")), validEnterprise.enterpriseName );
		app.getEnterpriseHelper().type(By.id(app.getEnterpriseHelper().MakeFullLink("tbWelcomeUrl")), "Welcome message for"+validEnterprise.enterpriseName );
		
		app.getEnterpriseHelper().submitCreation();
		
		app.getVerifyHelper().verifyEnterpriseAdded(validEnterprise);
		}
	
	
	
	@Test
	/*(dataProvider = "enterpiseFromFile", dataProviderClass = EnterpriseDataGenerator.class)	*/
	public void EnterpriseCannotBeAddedWithEmptyFields() throws Exception {
		
		EnterpriseUserObject emptyEnterprise = new EnterpriseUserObject();
		
		emptyEnterprise.setClickOnAllowDDS("false")
		.setClickOnAllowDDSDiscount("false")
		.setClickOnAllowFCRA("false")
		.setClickOnAllowFDCPA("false");
		
		log.info("EnterpriseCanBeAdded start");
		
		app.getNavigationHelper().logInAsAdmin();
		
		app.getEnterpriseHelper().createEnterprise(emptyEnterprise);
		
		app.getVerifyHelper().verifyThatValidationBlockCreating(16);
		
		}
	
}