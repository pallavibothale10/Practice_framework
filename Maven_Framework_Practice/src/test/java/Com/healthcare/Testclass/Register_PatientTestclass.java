package Com.healthcare.Testclass;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;
import Com.healthcare.Pageclass.Login_MRS;
import Com.healthcare.Pageclass.Register_Patient;

public class Register_PatientTestclass extends BaseClass_OpenMRS{

	@Test
	public void Enroll_Patient() throws InterruptedException {
		
		Login_MRS LG= new Login_MRS(); // Created the object of the 
		
		LG.Setusername("Admin");
		Thread.sleep(2000);
		LG.SetPassword("Admin123");
		Thread.sleep(2000);
		LG.Wardclick();
		Thread.sleep(2000);
		LG.Login_Click();
		
		Thread.sleep(2000);
		
		Register_Patient RP = new Register_Patient();
		Thread.sleep(2000);
		RP.Click_Register();
		Thread.sleep(2000);
		RP.First_Name("Pallavi");
		Thread.sleep(2000);
		RP.Middle_Name("Banduji");
		Thread.sleep(2000);
		RP.Last_Name("Bothale");
		Thread.sleep(2000);
		RP.Forward();
		
		RP.Gender_T1();
		
		RP.Forward1();
		
		// DOB
		RP.Day_click("10");
		RP.Month_click();
		RP.Year_click("1996");
		RP.Forward2();
		// Address
		
		RP.Address("Pune");
		RP.Forward3();
		
		// Phone
		RP.Click_Phone("8855947443");
		RP.Forward4();
		
		// Relation Person
		RP.Relation_R1();
		RP.Person_Name("Suraj");		
		RP.Forward5();
		
	 // Submit
		
		RP.Submit1();
		
		//validate title of the page
		boolean Title= driver.findElement(By.xpath("//title[contains(text(),\"Home\")]")).isDisplayed();
		System.out.println(Title);
		
	}
}