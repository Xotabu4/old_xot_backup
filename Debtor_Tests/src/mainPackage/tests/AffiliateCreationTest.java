package mainPackage.tests;

import java.util.logging.Logger;

import mainPackage.frameWork.AffiliateObject;
import org.testng.annotations.Test;

public class AffiliateCreationTest extends TestBase{
	
	private Logger log = Logger.getLogger("GroupCreationTests");

	
	//@Test
	
	public void affiliateUnderAdminCanBeAdded() throws Exception {
		log.info("AffiliateCanBeAdded start");
		
		AffiliateObject validAffiliate = new AffiliateObject();
		
		validAffiliate.setFirstName(String.format("AffiliateFirstName_%s", app.getAffiliateHelper().generateRandomString(7)))
		.setLastName(String.format("AffiliateLastName_%s", app.getAffiliateHelper().generateRandomString(7)))
		.setAffiliateName(String.format("AffiliateName_%s", app.getAffiliateHelper().generateRandomString(7)))
		.setAffiliateEmail("AffMail_"+app.getAffiliateHelper().generateRandomString(5)+"@mailinator.com")
		.setAffiliatePhoneNumber(app.getAffiliateHelper().generateRandomNumericString(10))
		.setAffiliateSupportNumber(app.getAffiliateHelper().generateRandomNumericString(10))
		.setExtension(app.getAffiliateHelper().generateRandomNumericString(3))
		.setGmailURL(String.format("gmail%s.com", app.getAffiliateHelper().generateRandomString(5)))
		.setGroupID(app.getProperty("GroupIdForEnterpriseCreation"))
		.setAffiliateWelcomeMessage("Welcome message for"+validAffiliate.affiliateName);
		
	app.getNavigationHelper().logInAsAdmin();
	app.getAffiliateHelper().createAffiliate(validAffiliate);
	app.getVerifyHelper().verifyAffiliateAdded(validAffiliate);

	}
	

	@Test
	
	public void AffiliateCannotBeAddedWithEmptyFields() throws Exception {
		log.info("AffiliateCanBeAdded start");
		
		AffiliateObject emptyAffiliateObject = new AffiliateObject();
		
		app.getNavigationHelper().logInAsAdmin();
		app.getAffiliateHelper().createAffiliate(emptyAffiliateObject);
		
		app.getVerifyHelper().verifyThatValidationBlockCreating(7);
		
	}

}