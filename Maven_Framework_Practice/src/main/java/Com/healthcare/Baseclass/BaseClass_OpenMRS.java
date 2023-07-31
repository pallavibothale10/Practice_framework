package Com.healthcare.Baseclass;


import java.time.Duration;
import org.apache.log4j.Logger;

import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import Com.healthcare.Configuration.ReadConfiguration_MRS;


public class BaseClass_OpenMRS {
	
	public static WebDriver driver;
public static Logger logger;
	
	ReadConfiguration_MRS ReadConfigFile= new ReadConfiguration_MRS();
	
	public String BaseURL = ReadConfigFile.getApplicationURL();
	public String UserName = ReadConfigFile.MethodUsername();
	public String PassWord = ReadConfigFile.MethodPassword();
    public String ChromeDriver =ReadConfigFile.getChromepath();

	
	
	@SuppressWarnings("static-access")
	@BeforeMethod
	public void LaunchBrowser() throws InterruptedException {
 
		//System.setProperty("webdriver.Chrome.Driver",
			//	"C:\\Users\\A\\eclipse-workspace1\\Maven_Framework_Practice\\src\\test\\resources\\Drive\\chromedriver.exe");

		
		
	  logger= logger.getLogger("Automaton Framework");
	
		//PropertyConfigurator.configure("log4jj.properties");
	PropertyConfigurator.configure("C:\\Users\\A\\eclipse-workspace1\\Maven_Framework_Practice\\src\\test\\resources\\Configuration\\log4j.properties");
		
		System.setProperty("webdriver.Chrome.Driver",ChromeDriver);
		
		
		driver = new ChromeDriver();
logger.info("Hie url");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get(BaseURL);
		logger.info("HIT URL");
//		Login_MRS LG= new Login_MRS(); // Created the obj
//
//		
//		LG.Setusername(UserName);
//		logger.info("Enter username");
//		
//		LG.SetPassword(PassWord);
//		logger.info("Enter password");
//
//		LG.Wardclick();
//		logger.info("click ward button");
//
//		LG.Login_Click();
//		logger.info("Click login button");
//
//		Thread.sleep(3000);


	}

	@AfterMethod
	public void TearDown() throws InterruptedException {

		Thread.sleep(3000);
		// driver.close();
	}
}


