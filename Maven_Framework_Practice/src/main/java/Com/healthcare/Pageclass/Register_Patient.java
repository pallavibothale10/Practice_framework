package Com.healthcare.Pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;

public class Register_Patient extends BaseClass_OpenMRS {

	public Register_Patient() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[normalize-space()='Register a patient'])[1]")
	public WebElement Register1;

	@FindBy(xpath = "//input[@name=\"givenName\"]") // Name field
	public WebElement Name;

	@FindBy(xpath = "//input[@class=\"ui-autocomplete-input\"]") // Name middle field
	public WebElement Middle;

	@FindBy(xpath = "//input[@name=\"familyName\"]") // Name last field
	public WebElement Last;

	@FindBy(xpath = "//button[@id='next-button']") // Next Arrow to the Gender field
	public WebElement Next;
	
	@FindBy(xpath = "//select[@id=\"gender-field\"]")
	public WebElement GenderTab;
	
	@FindBy(xpath = "//icon[@class=\"fas fa-chevron-right\"]")
	public WebElement Next1;
	
	@FindBy(xpath = "//input[@id=\"birthdateDay-field\"]")
	public WebElement Day;
	
	@FindBy(xpath = "//select[@name=\"birthdateMonth\"]")
	public WebElement Month;
	
	@FindBy(xpath = "//input[@id=\"birthdateYear-field\"]")
	public WebElement Year;
	
	@FindBy(xpath = "//icon[@class=\"fas fa-chevron-right\"]")
	public WebElement Next2;
	
	@FindBy(xpath = "//input[@id=\"address1\"]")
	public WebElement Address;
	
	@FindBy(xpath = "//icon[@class=\"fas fa-chevron-right\"]")
	public WebElement Next3;
	
	@FindBy(xpath = "//input[@name=\"phoneNumber\"]")
	public WebElement PhoneNo;
	
	@FindBy(xpath = "//icon[@class=\"fas fa-chevron-right\"]")
	public WebElement Next4;
	
	@FindBy(xpath = "//select[@id=\"relationship_type\"]")
	public WebElement Relation;
	
	@FindBy(xpath = "//input[@placeholder=\"Person Name\"]")
	public WebElement Input_relation;
	
	@FindBy(xpath = "//icon[@class=\"fas fa-chevron-right\"]")
	public WebElement Next5;
	
	@FindBy(xpath = "//input[@id=\"submit\"]")
	public WebElement Submit;
	


	public void Click_Register() {

		Register1.click();
	}

	public void First_Name(String F_Name) {

		Name.sendKeys(F_Name);
		
	}

	public void Middle_Name(String M_Name) {

		Middle.sendKeys(M_Name);
		
	}

	public void Last_Name(String L_Name) {

		Last.sendKeys(L_Name);
		
	}

	public void Forward() {

		Next.click();
	}
	
	public void Gender_T1() {
		
		GenderTab.click();
		Select S1= new Select(GenderTab);
		S1.selectByVisibleText("Female");
	}
	
	public void Forward1() {

		Next1.click();
	}
	
	public void Day_click(String V1) {

		Day.sendKeys(V1);
	}
	
	public void Month_click() {

		Month.click();
		Select S2= new Select(Month);
		S2.selectByVisibleText("June");
	}
	
	public void Year_click(String V2) {

		Year.sendKeys(V2);
	}
	
	public void Forward2() {

		Next2.click();
	}
	
	public void Address(String Add1) {

		Address.sendKeys(Add1);;
	}
	
	public void Forward3() {

		Next3.click();
	}
	
	public void Click_Phone(String P1) {

		PhoneNo.sendKeys(P1);
	}
	
	public void Forward4() {

		Next3.click();
	}
	
	public void Relation_R1() {

		Relation.click();
		Select S3=  new Select(Relation );
		S3.selectByVisibleText("Sibling");
	}
	
	public void Person_Name(String P1) {

		Input_relation.sendKeys(P1);
	}
	
	public void Forward5() {

		Next5.click();
	}
	
	public void Submit1() {

		Submit.click();
	}
	
	
	
	

}