package frameWork;

import java.util.Properties;

import pageObjects.Page;


public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private WebDriverHelper webDriverHelper;
	private Properties props;
	private AdminActions adminActions;
	private Page page;
	
	public static ApplicationManager getInstance() {
		if (singleton == null){
			singleton = new ApplicationManager();
		}
		return singleton;
	}

	public WebDriverHelper getWebDriverHelper() {
        if (webDriverHelper == null) {
			webDriverHelper = new WebDriverHelper (this);
			
		}
		return webDriverHelper;
	}
	
	public Page pageObj() {
		if (page == null) {
			page = new Page(this);
		}
		return page;
	}
	
	public AdminActions getAdminActions() {
		if (adminActions == null) {
			adminActions = new AdminActions(this);
		}
		return adminActions;
	}
	
	public void stop() {
		if (webDriverHelper != null){
			webDriverHelper.stop();
		}
		
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
