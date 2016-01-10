package mainPackage.frameWork.Counselor;

import java.util.Random;

import mainPackage.frameWork.ApplicationManager;
import mainPackage.frameWork.HelperWithWebDriverBase;

import org.openqa.selenium.By;

public class CounselorHelper extends HelperWithWebDriverBase{

	public CounselorHelper (ApplicationManager manager) {
		super(manager);
	}

	Random rnd = new Random();
	
	public void fillClientInfoPage() {
		
		type(By.name("FirstName"), "Autotest");
		type(By.name("LastName"), "Autotest");
		type(By.name("EmailAddress"), "Autotest_" + rnd.nextInt(10000)+1 + "@mailinator.com");
		type(By.name("HomePhone"), "1234567890");
		type(By.name("AlternatePhone"), "1234567890");
		
		checkValidStates();
		dropdownSelectByIndex("StateId", 3);
		
		checkValidEmployerStatuses();
		dropdownSelectByIndex("EmployerStatusId", 3);
		//Click to next page
		clickNextStepButton();

	}

	private void clickNextStepButton() {
		click(By.cssSelector("input.next-step-button"));
	}

	protected void checkValidStates() {
		String statesInDropdown = findElement(By.name("StateId")).getText();
		manager.getVerifyHelper().checkThatStatesInDropdownIsValid(statesInDropdown);

	}
	
	protected void checkValidEmployerStatuses() {
		String statusesInDropdown = findElement(By.name("EmployerStatusId")).getText();
		manager.getVerifyHelper().checkEmployerStatusesInDropdown(statusesInDropdown);

	}

	public void fillAdditionalClientInfoPage() throws Exception {
		//TODO This check runs very slow. Need to do something with it

		
		type(By.id("Applicant_SsnForSaler"),"123123123");
		type(By.id("Applicant_BirthDateForSaler"), "11/26/1995");
		type(By.id("Applicant_Address"), "ApplicantAddress");
		type(By.id("Applicant_City"), "ApplicantCity");
		type(By.id("Applicant_Zip"), "12345");
		
		click(By.id("mailing_adress_same_as_above"));
		
		type(By.id("Applicant_Employeer"), "Employer");
		type(By.id("Applicant_WorkPhone"), "123-456-7890");
		type(By.id("Applicant_Fax"), "123-456-7890");
		
		click(By.id("CoApplicantExists_0"));
		
		type(By.id("CoApplicantMain_FirstName"), "CoappFirstName");
		type(By.id("CoApplicantMain_LastName"), "CoappLastName");
		type(By.id("CoApplicant_BirthDate"), "11/26/1995");
		type(By.id("CoApplicant_Ssn"), "123-45-6789");
		type(By.id("CoApplicantMain_EmailAddress"), "Coappemail_" +rnd.nextInt(10000)+1 + "@mailinator.com");
		type(By.id("CoApplicant_Fax"), "123-456-7890");
		type(By.id("CoApplicantMain_HomePhone"), "123-456-7890");
		type(By.id("CoApplicantMain_AlternatePhone"), "123-456-7890");
		
		click(By.id("co_mailing_adress_same_as_above"));
		
		type(By.id("CoApplicant_Employeer"), "Employer");
		type(By.id("CoApplicant_Title"), "Title");
		type(By.id("CoApplicant_WorkPhone"), "123-456-7890");
		
		clickNextStepButton();

	}

	public void fillHardShipInfoPage() throws Exception {

		click(By.id("LayOff"));
		click(By.id("Disability"));
		click(By.id("PersonalInjury"));
		click(By.id("CompanySlowdown"));
		click(By.id("PayCut"));
		click(By.id("Divorce"));
		click(By.id("Medical"));
		click(By.id("LossOfFinancialProvider"));
		click(By.id("otherReasonCb"));
		
		type(By.id("OtherReason"), "OtherFieldText");
		type(By.id("Explanation"), "ExplanationText");

		clickNextStepButton();
	}
	
	
}
