package Com.healthcare.Testclass;

import org.testng.annotations.Test;



import Com.healthcare.Baseclass.BaseClass_OpenMRS;
import Com.healthcare.Pageclass.Login_MRS;

public class Login_TestClass  extends BaseClass_OpenMRS{

	@Test
	public void Login() throws InterruptedException {
		
	Login_MRS LG= new Login_MRS(); // Created the obj

	
	LG.Setusername(UserName);
	
    logger.info("loginname");
	LG.SetPassword(PassWord);
    logger.info("password");


	LG.Wardclick();
	

	LG.Login_Click();


	Thread.sleep(3000);
	
	
	
	}
	
}
