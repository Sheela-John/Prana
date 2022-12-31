package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
	@FindBy(xpath="//*[@id=\"container\"]/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/input")
	WebElement therapist;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/input")
	WebElement physiotherapist;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]/input")
	WebElement physiotherapy_Assistant;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[4]/input")
	WebElement nutritionist;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[5]/input")
	WebElement personal_Trainer;
	
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
	public Profile_clinician() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")));
		profile.click();
		
	}
	public void addProfileData(String fname,String special,String special1,String dob,String address1,String email1,String semail,String exp,String gender,String mNumber,String clinic1,String clinic2) throws InterruptedException
	{
		fullName.clear();
		fullName.sendKeys(fname);
		specialization.click();
		
		toSelectSpecialization(special);
	
		
		toSelectSpecialization(special1);
		
		
		DOB.clear();
		DOB.sendKeys(dob);
		address.clear();
		address.sendKeys(address1);
		
		email.clear();
		email.sendKeys(email1);
		secondary_Email.clear();
		secondary_Email.sendKeys(semail);
		experience.clear();
		experience.sendKeys(exp);
		if(gender.contains("Male"))
		{
			try {
			     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[1]/input")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[1]/input")));
			  }
		}
		else if(gender.contains("Female"))
		{
			try {
			     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[2]/input")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[2]/input")));
			  }
		}
		else
		{
			try {
			     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[3]/input")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[1]/div[11]/div[2]/div[1]/div/div[3]/input")));
			  }
		}
		
		mobileNumber.clear();
		mobileNumber.sendKeys(mNumber);
		
		clinic_Name.click();
		
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[1]/li[1]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[1]/li[1]/input")));
		  }
		toSelectClinic(clinic1);
		
		toSelectClinic(clinic2);
		updateProfile.click();
		Thread.sleep(5000);
		
	}
	public void toSelectClinic(String clinic1)
	{
		if(clinic1.contains("Grafton Clinic") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/input")));
		  }
		}
		else if(clinic1.contains("Balmoral Medical Centre") )
		{;
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/input")));
		  }
		}
		else if(clinic1.contains("Hunter's Corner Medical Centre"))
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[7]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]/input")));
		  }
		}
	}
	public void toSelectSpecialization(String special)
	{
		if(special.contains("Therapist") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/input")));
		  }
		}
		else if(special.contains("Physiotherapist") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/input")));
		  }
		}
		else if(special.contains("Physiotherapy Assistant"))
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]/input")));
		  }
		}
		else if(special.contains("Nutritionist"))
		{
			
			try {
			     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[4]/input")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[4]/input")));
			  }
			
		}
		else if(special.contains("Personal Trainer"))
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[5]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-clinician-profile/div[2]/form/div/div[3]/div[2]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[5]/input")));
		  }
		}
	
	}
}
