package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperWithWebDriverBase {
	
	public NavigationHelper (ApplicationManager manager) {
		super(manager);
	}
	public void goToGroupList() {
		//if (findElement(By.tagname("h1") != )
		findElement(By.linkText("groups")).click();
	}
	protected void openMainPage() {
		//if main page opened already - do nothing
		openURL(manager.getProperty("baseURL"));
	}
	protected void clickingHomeLink() {
		findElement(By.linkText("home page")).click();
	}
	public void openPrintPhonesPage() {
		click(By.linkText("print phones"));
	}
	
}
