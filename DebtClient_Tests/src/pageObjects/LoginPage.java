package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameWork.ApplicationManager;

public final class LoginPage extends PageBase{
	
	public LoginPage(ApplicationManager manager) {
		super(manager);
		
	}
	
	@FindBy(id="UserName") 
	@CacheLookup
	private WebElement userNameField;
	
	@FindBy(id="Password") 
	private WebElement passwordField;
	
	@FindBy(css=".login-submit>input") 
	private WebElement logInButton;

	
	
	public void open(){
		
		openURL(manager.getProperty("baseURL"));
		PageFactory.initElements(driver, LoginPage.class);
	}
	
	public void clickLoginButton() {
		
	}

	public void login(String userName, String password){
		
//		open();
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
//		type(passwordField, password);
		
	}
	
}