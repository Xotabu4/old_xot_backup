package mainPackage.frameWork;

import org.openqa.selenium.By;

public class SalesHelper extends HelperWithWebDriverBase{

	public SalesHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createSales(SalesObject sales) {
		
		manager.getNavigationHelper().openAddSalesPage();
		fillSalesFields(sales);
		click(By.id("MainBodyPlaceHolder_ContentPlaceHolder1_ImageButton1"));
		
	}

	private void fillSalesFields(SalesObject sales) {
		type(By.id(MakeFullLink("tbFirstName")), sales.firstName);
		type(By.id(MakeFullLink("tbLastName")), sales.lastName);
		type(By.id(MakeFullLink("tbEmail")), sales.Email);
		type(By.id(MakeFullLink("tbPhoneNumber")), sales.phone);
		
	}

}
