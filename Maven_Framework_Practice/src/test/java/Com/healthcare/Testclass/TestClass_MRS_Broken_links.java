package Com.healthcare.Testclass;

import java.io.IOException;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;
import Com.healthcare.Pageclass.Login_MRS;
import Com.healthcare.Pageclass.PageClass_MRS_Broken_links;




public class TestClass_MRS_Broken_links extends BaseClass_OpenMRS {

	
	@Test
	public void TestMethod() throws IOException, InterruptedException {
		
		
		PageClass_MRS_Broken_links PCB = new PageClass_MRS_Broken_links(driver);
		
//		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
//		
//		Login_MRS LG= new Login_MRS(); // Created the obj
//		
//		LG.Setusername(Username);
//		
//		LG.SetPassword(Password);
//		LG.Wardclick();
//		LG.Login_Click();
		
		PCB.getLinks();

	}



}
