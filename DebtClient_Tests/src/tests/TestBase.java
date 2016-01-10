package tests;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import frameWork.ApplicationManager;

public class TestBase {
	
	private Logger log = Logger.getLogger("TEST");

	protected ApplicationManager app;
	
	
	@BeforeClass
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = "application.properties";
		}
		
		Properties props = new Properties();
		props.load(new FileReader(configFile));
		
		log.info("setUp start");
		app = ApplicationManager.getInstance();
		app.setProperties(props);
		log.info("setUp end");
	}

	@AfterTest
	public void tearDown() throws Exception {
		log.info("tearDown start");
		ApplicationManager.getInstance().stop();
		log.info("tearDown end");
		
	}

}    
    