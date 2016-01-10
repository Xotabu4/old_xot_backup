package com.example.fw;

import java.util.Properties;

public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private WebDriverHelper webDriverHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private VerifyHelper verifyHelper;
	private NavigationHelper navigationHelper;
	private Properties props;
	private HibernateHelper hibernateHelper;
	
	public static ApplicationManager getInstance() {
		if (singleton == null){
			singleton = new ApplicationManager();
		}
		return singleton;
	}
	
	public void stop() {
		if (webDriverHelper != null){
			webDriverHelper.stop();
		}
		
	}

	public WebDriverHelper getWebDriverHelper() {
        if (webDriverHelper == null) {
			webDriverHelper = new WebDriverHelper (this);
			
		}
		return webDriverHelper;
	}
	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			
			hibernateHelper = new HibernateHelper (this);
			
		}
		return hibernateHelper;
	}

    public GroupHelper getGroupHelper() {
		if (groupHelper == null) {
			
			groupHelper = new GroupHelper (this);
			
		}
		return groupHelper;
	}
    

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
			
			contactHelper = new ContactHelper (this);
			
		}
		return contactHelper;
	}
    
    public VerifyHelper getVerifyHelper() {
		if (verifyHelper == null) {
			
			verifyHelper = new VerifyHelper (this);
			
		}
		return verifyHelper;
	}
    
	public NavigationHelper getNavigationHelper() {
        if (navigationHelper == null) {
			
        	navigationHelper = new NavigationHelper (this);
			
		}
		return navigationHelper;
	}

	public void setProperties(Properties props) {
		this.props = props;
	}
	
	public String getProperty(String key)  {
		return props.getProperty(key);
	}
	
	public String getProperty(String key, String defaultValue)  {
		return props.getProperty(key, defaultValue);
	}

	
}
