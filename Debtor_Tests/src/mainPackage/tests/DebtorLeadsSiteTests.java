package mainPackage.tests;

import java.util.logging.Logger;
import org.testng.annotations.Test;

public class DebtorLeadsSiteTests extends TestBase{
	
	private Logger log = Logger.getLogger("TEST");
	
	
	@Test
	public void FilterByStatusWorksCorrect() throws Exception {
		
		app.getDebtorLeadsHelper().openUnassignedLeadsPage();
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("Valid");
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("NotValid");
		
		log.info("Unassigned leads page status change PASSED");
		
		app.getDebtorLeadsHelper().openAssignedLeadsPage();
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("Valid");
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("CoClientEmailSent");
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("NewApplicant");
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("eSignSent");
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("PdfSent");
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("ApplicatReview");
		
		app.getDebtorLeadsHelper().selectAndAssertStatus("Customer");
		
		log.info("Assigned leads page status change PASSED");
		
		}
	
	
	@Test
	public void getLeadsFromSQL() throws Exception {
		System.out.println(app.getHibernateHelper().getLeads());
	}
	
}
