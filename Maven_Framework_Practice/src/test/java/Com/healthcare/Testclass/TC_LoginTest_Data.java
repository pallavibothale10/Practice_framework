package Com.healthcare.Testclass;

import static org.testng.Assert.assertTrue;


import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;
import Com.healthcare.Pageclass.Login_MRS;
import Com.healthcare.Utilities.ExcelUtils;


public class TC_LoginTest_Data extends BaseClass_OpenMRS {


		@Test(dataProvider="Logindata")
		public void Login(String User, String Pass, String Expected) throws InterruptedException {
			Login_MRS LG= new Login_MRS(); // Created the obj
		
			LG.Setusername(User);
			//logger.info("Enter username");
			
			LG.SetPassword(Pass);
			//logger.info("Enter password");

			LG.Wardclick();
			//logger.info("click ward button");

			LG.Login_Click();
			//logger.info("Click login button");

			Thread.sleep(3000);
	
//		String exe_title = "nopCommerce demo store";
//
//		String act_title = driver.getTitle();
//
//		if (result.equals("valid")) {
//
//			if (act_title.equals(exe_title)) {
//
//				driver.findElement(By.xpath("//a[@href=\"/logout\"]")).click();
//
//				Assert.assertTrue(true);
//				logger.info("login test pass");
//
//			} else {
//
//				assertTrue(false);
//				logger.info("login test failed");
//			}
//		} else if (result.equals("invalid")) {
//			if (act_title.equals(exe_title)) {
//				logger.info("login test failed");
//				assertTrue(false);
//			} else {
//				Assert.assertTrue(true);
//				logger.info("login test pass");
//			}
//		}
//
//	}
			String Act_Title=driver.getTitle();
			String Exp_Title="Home";

					
					if(Expected.equals("Valid")) {
						if(Act_Title.equals(Exp_Title)) {
						
							Assert.assertTrue(true);
						//logger.info("Login test case pass");
					}
					else {
						Assert.assertTrue(false);
						//logger.info("login test case failed");
						}
					}
						else if(Expected.equals("Invaild")) {
							if(Act_Title.equals(Exp_Title)) {
								assertTrue(false);
								//logger.info("Login test case pass");
						}
							else {
								Assert.assertTrue(true);
								//logger.info("Login test case failed");
							}
					}
					
				}
	
	@DataProvider(name = "Logindata")
	public String[][] Getdata() throws IOException{
		
		//String Path = "C:\\Users\\A\\eclipse-workspace1\\Pallavi_New_Maven\\src\\test\\java\\Com\\Ecommers\\TestCases\\11Match_TestData.xlsx";
		
		String Path ="C:\\Users\\A\\eclipse-workspace1\\Maven_Framework_Practice\\src\\test\\resources\\DataPrivider.xlsx";
		
		int R1 = ExcelUtils.GetRowcount(Path, "Sheet1");
		int C1 = ExcelUtils.GetCellcount(Path, "Sheet1", 1);
		
		String logindata[][]= new String[R1][C1];
		
		for(int i=1; i<=R1; i++) {
			
			for(int j=0; j<C1; j++) {
				
				logindata[i-1][j] = ExcelUtils.GetCelldata(Path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
	
}