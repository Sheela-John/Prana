package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Profile_clinician extends TestBase {
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")
	WebElement profile;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[1]/input")
	WebElement fullName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[1]")
	WebElement specialization;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[5]/div/div[1]/div/input")
	WebElement DOB;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[7]/input")
	WebElement address;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[9]/input")
	WebElement email;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[9]/input")
	WebElement secondary_Email;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[1]/div[1]/div/input")
	WebElement experience;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[1]/input")
	WebElement male;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[2]/input")
	WebElement female;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[3]/input")
	WebElement other;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[11]/ngx-intl-tel-input/div/input")
	WebElement mobileNumber;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[1]/span")
	WebElement clinic_Name;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[1]/li[1]/input")
	WebElement unSelectAll;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/div/div/div/button")
	WebElement updateProfile;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[1]/span")
	WebElement Specialization;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[1]/span")
	WebElement Clinic;
	public Profile_clinician() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")));
		profile.click();
		
	}
	public void addProfileData(String fname,String special,String dob,String address1,String email1,String semail,String exp,String gender,String mNumber,String clinic1) throws InterruptedException
	{
		fullName.clear();
		fullName.sendKeys(fname);
		specialization.click();
		toSelectSpecialization(special);
		DOB.clear();
		DOB.sendKeys(dob);
		address.clear();
		address.sendKeys(address1);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"container\"]/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[8]"));
		Thread.sleep(3000);
		action.moveToElement(we).click().build().perform();
		toSelectClinic(clinic1);
		email.clear();
		email.sendKeys(email1);
		secondary_Email.clear();
		secondary_Email.sendKeys(semail);
		experience.clear();
		experience.sendKeys(exp);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		if(gender.contains("Male"))
		{
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[1]/input")));
		}
		else if(gender.contains("Female"))
		{
			  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[2]/input")));  
		}
		else
		{
			    executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[3]/input")));
		}
		
		mobileNumber.clear();
		mobileNumber.sendKeys(mNumber);
		Thread.sleep(5000);
		//clinic_Name.click();
		//  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[1]/li[1]/input")));
	
		updateProfile.click();
		Thread.sleep(9000);
		
	}
	public void toSelectClinic(String clinic) throws InterruptedException
	{
		Clinic.click();
	
		String[] conditionarr = clinic.split(","); 
		
		for (String con : conditionarr) {
			{
			String specxpath = "//input[@aria-label='" + con + "']";		
			WebElement Spec_dropdown = driver.findElement(By.xpath(specxpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);
				
			}
		}
	
		//Clinic.click();
		
	}
	public void toSelectSpecialization(String special)
	{
		Specialization.click();
	String[] conditionarr = special.split(","); 
	
	for (String con : conditionarr) {
		{
		String specxpath = "//input[@aria-label='" + con  + "']";		
		WebElement Spec_dropdown = driver.findElement(By.xpath(specxpath));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);
		}
	}

	Specialization.click();
	}
	
	public void toCheckProfileDetails(String fname,String special,String dob,String address1,String email1,String semail,String exp,String gender,String mNumber,String clinic1) throws InterruptedException
	{
		if(fullName.getAttribute("value").contains(fname))
		{
			if(DOB.getAttribute("value").contains(dob))
			{
				if(address.getAttribute("value").contains(address1))
				{
					if(email.getAttribute("value").contains(email1))
					{
						if(secondary_Email.getAttribute("value").contains(semail))
						{
							if(experience.getAttribute("value").contains(exp))
							{
								if(mobileNumber.getAttribute("value").contains(mNumber))
								{
									System.out.println("Success in Profile");
								}
								else {System.out.println("Error in Mobile Number");}
							}
							else {System.out.println("Error in Experience");}
						}
						else {System.out.println("Error in secondary email");}
					}
					else {System.out.println("Error in Email");}
				}
				else {System.out.println("Error in Address");}
			}
			else {System.out.println("Error in DOB");}
		}
		else {System.out.println("Error in Name");}
	}
}
