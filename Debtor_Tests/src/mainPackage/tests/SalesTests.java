package mainPackage.tests;

import mainPackage.frameWork.SalesObject;
import org.testng.annotations.Test;

public class SalesTests extends TestBase{
	
	@Test
	
	public void salesUnderAdminCanBeCreated() throws Exception {
		log.info("salesUnderAdminCanBeCreated start");
		
		SalesObject validSales = new SalesObject();
		
		validSales.setFirstName(String.format("SalesFirstName_%s", app.getSalesHelper().generateRandomString(7)))
		.setLastName(String.format("SalesLastName_%s", app.getSalesHelper().generateRandomString(7)))
		.setEmail("SalesMail_"+app.getSalesHelper().generateRandomString(5)+"@mailinator.com")
		.setPhone(app.getSalesHelper().generateRandomNumericString(10));
		
	app.getNavigationHelper().logInAsAdmin();
	app.getSalesHelper().createSales(validSales);
	app.getVerifyHelper().verifySalesAdded(validSales);

	}
	
	@Test
	
	public void salesCannotBeAddedWithEmptyFields() throws Exception {
		log.info("salesUnderAdminCanBeCreated start");
		
		SalesObject emptySales = new SalesObject();
		
		app.getNavigationHelper().logInAsAdmin();
		app.getSalesHelper().createSales(emptySales);
		
		app.getVerifyHelper().verifyThatValidationBlockCreating(3);
	
	}
	

}
