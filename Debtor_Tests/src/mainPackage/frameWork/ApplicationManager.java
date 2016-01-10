package mainPackage.frameWork;

import java.util.Properties;

import mainPackage.frameWork.Counselor.TaxHelper;
import mainPackage.frameWork.Enterprise.EnterpriseHelper;
import mainPackage.frameWork.Leads_and_Leads_providers.APIHelper;
import mainPackage.frameWork.Leads_and_Leads_providers.DebtorLeadsHelper;
import mainPackage.frameWork.Leads_and_Leads_providers.LeadProviderHelper;
import mainPackage.frameWork.SQL.HibernateHelper;

public class ApplicationManager {
	
	private TaxHelper taxHelper;
	private NavigationHelper navigationHelper;
	private WebDriverHelper webDriverHelper;
	private EnterpriseHelper enterpriseHelper;
	private AffiliateHelper affiliateHelper;
	private VerifyHelper verifyHelper;
	private APIHelper apiHelper;
	private DebtorLeadsHelper debtorLeadsHelper;
	
	private static ApplicationManager singleton;
	private Properties props;
	private SalesHelper salesHelper;
	private LeadProviderHelper leadProviderHelper;
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
	
	
    public NavigationHelper getNavigationHelper() {
		
        if (navigationHelper == null) {
        	navigationHelper = new NavigationHelper (this);
			
		}
        
		return navigationHelper;
		
	}
	
	public EnterpriseHelper getEnterpriseHelper() {
		if (enterpriseHelper == null) {
			
			enterpriseHelper = new EnterpriseHelper (this);
			
		}
		return enterpriseHelper;
	}

	public AffiliateHelper getAffiliateHelper() {
		  if (affiliateHelper == null) {
			  affiliateHelper = new AffiliateHelper (this);
				
			}
	        
			return affiliateHelper;
			
	}

	public SalesHelper getSalesHelper() {
		  if (salesHelper == null) {
			  salesHelper = new SalesHelper (this);
				
			}
	        
			return salesHelper;
	}
	
	public LeadProviderHelper getLeadProviderHelper() {
		  if (leadProviderHelper == null) {
			  leadProviderHelper = new LeadProviderHelper (this);
				
			}
	        
			return leadProviderHelper;
			
	}

	public TaxHelper getTaxHelper() {
		
        if (taxHelper == null) {
        	taxHelper = new TaxHelper (this);
			
		}
        
		return taxHelper;

	}
	
	public APIHelper getAPIHelper() {
		
        if (apiHelper == null) {
        	apiHelper = new APIHelper (this);
			
		}
        
		return apiHelper;

	}
	
	public VerifyHelper getVerifyHelper() {
		  if (verifyHelper == null) {
			  verifyHelper = new VerifyHelper (this);
				
			}
	        
			return verifyHelper;
			
	}
	
	public DebtorLeadsHelper getDebtorLeadsHelper() {
		if (debtorLeadsHelper == null) {
			debtorLeadsHelper = new DebtorLeadsHelper (this);
				
			}
	        
			return debtorLeadsHelper;
			
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
