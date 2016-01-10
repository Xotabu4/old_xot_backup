package pageObjects;

import org.openqa.selenium.support.PageFactory;

import frameWork.ApplicationManager;

public class Page {
	
	private LoginPage loginPage;
	private ApplicationManager manager;
	
	public Page(ApplicationManager manager) {
		this.manager = manager;
	}

	public LoginPage loginPage() {
        if (loginPage == null) {
        	loginPage = 
//        	PageFactory.initElements(driver, LoginPage.class);
        			new LoginPage (manager);
			
		}
		return loginPage;
	}

}