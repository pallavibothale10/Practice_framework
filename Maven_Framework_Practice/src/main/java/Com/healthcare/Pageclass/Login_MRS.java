package Com.healthcare.Pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;

public class Login_MRS extends BaseClass_OpenMRS {

	

	public Login_MRS() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	public WebElement Username;

	@FindBy(xpath = "//input[@placeholder=\"Enter your password\"]")
	public WebElement Password;

	@FindBy(xpath = "//li[@id='Inpatient Ward']")
	public WebElement Ward_Tab;

	@FindBy(xpath = "//input[@id='loginButton']")
	public WebElement LoginButton;

	public void Setusername(String U_Name) {

		Username.sendKeys(U_Name);
	}

	public void SetPassword(String P_Pass) {

		Password.sendKeys(P_Pass);
	}

	public void Wardclick() {

		Ward_Tab.click();
	}

	public void Login_Click() {

		LoginButton.click();
	}

}