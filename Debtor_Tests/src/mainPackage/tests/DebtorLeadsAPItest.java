package mainPackage.tests;

import java.util.logging.Logger;

import mainPackage.frameWork.Leads_and_Leads_providers.LeadsCSVGeneration;
import mainPackage.frameWork.Leads_and_Leads_providers.LeadsObject;

import org.testng.annotations.Test;

public class DebtorLeadsAPItest extends TestBase{

	private static final String CORRECTLEADS_FROM_FILE = "CorrectleadsFromFile";
	

	private Logger log = Logger.getLogger("TEST");
	
	//Positive tests
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICanBeUsedWithCorrectDataAndAssigment(LeadsObject LeadsObject) throws Exception {

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, true));
		
		app.getAPIHelper().sendAPIrequestWithAffiliateAssigment(LeadsObject);
		app.getAPIHelper().assertCorrectOKAnswer();
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICanBeUsedWithZeroAge(LeadsObject LeadsObject) throws Exception {
		
		LeadsObject.setLeadAge(0);

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectOKAnswer();
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICanBeUsedWithoutAssigment(LeadsObject LeadsObject) throws Exception {
		
		LeadsObject.setLeadEmail("lead"+app.getAPIHelper().generateRandomString(5)+"@mailinator.com");

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectOKAnswer();
		}
	
	//Negative tests
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICantBeUsedWithEmptyData(LeadsObject LeadsObject) throws Exception {
		
		LeadsObject.setLeadFirstName("");
		LeadsObject.setLeadLastName("");
		LeadsObject.setLeadEmail("");
		LeadsObject.setLeadPhoneNumber("");
		LeadsObject.setLeadDebtAmount("");
		LeadsObject.setLeadAge(0);

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectError("\"FIRST_NAME_OF_LEAD_IS_NOT SPECIFIED\", -1");
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICantBeUsedWithEmptyLastNameData(LeadsObject LeadsObject) throws Exception {
		LeadsObject.setLeadLastName("");

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectError("\"LAST_NAME_OF_LEAD_IS_NOT_SPECIFIED\", -1");
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICantBeUsedWithEmptyEmailData(LeadsObject LeadsObject) throws Exception {
		LeadsObject.setLeadEmail("");

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectError("\"EMAIL_OF_LEAD_IS_NOT_SPECIFIED\", -1");
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICantBeUsedWithEmptyPhoneData(LeadsObject LeadsObject) throws Exception {
		LeadsObject.setLeadPhoneNumber("");

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectError("\"PHONE_OF_LEAD_IS_NOT_SPECIFIED\", -1");
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICantBeUsedWithWrongPhoneData(LeadsObject LeadsObject) throws Exception {
		LeadsObject.setLeadPhoneNumber(app.getAPIHelper().generateRandomString(10));

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectError("\"PHONE_OF_LEAD_IS_NOT_SPECIFIED\", -1");
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICantBeUsedWithEmptyDebtAmountData(LeadsObject LeadsObject) throws Exception {
		LeadsObject.setLeadDebtAmount("");

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectError("\"DEBT_OF_LEAD_IS_NOT_SPECIFIED\", -1");
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICantBeUsedWithWrongFormatAgeData(LeadsObject LeadsObject) throws Exception {
		LeadsObject.setLeadAge(app.getAPIHelper().generateRandomNumberInRange(-100, -1));

		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, false));
		
		app.getAPIHelper().sendAPIrequest(LeadsObject);
		app.getAPIHelper().assertCorrectError("\"LEAD_AGE_IS_IN_WRONG_FORMAT\", -1");
		}
	
	@Test
	(dataProvider = CORRECTLEADS_FROM_FILE, dataProviderClass = LeadsCSVGeneration.class)	
	public void APICantBeUsedWithExistEmailAssigmentData(LeadsObject LeadsObject) throws Exception {

		LeadsObject.setLeadEmail("EMAIL@ADDRESS.you");


		log.info(app.getAPIHelper().ConfigureAPILink(LeadsObject, true));
		
		app.getAPIHelper().sendAPIrequestWithAffiliateAssigment(LeadsObject);
		
		app.getAPIHelper().assertCorrectError("\"TRYING_TO_ASSIGN_LEAD_WHICH_IS_NOT_VALID_WITH_ALREADY_EXISTING_EMAIL\", -1");
		}

	
}
