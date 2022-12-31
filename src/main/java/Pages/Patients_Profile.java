package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Patients_Profile extends TestBase {
	
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement patients;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/nav/div/a[1]")
	WebElement profile;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[1]/div/div/input")
	WebElement search;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[1]/form/div/div[1]/div[2]/tag-input/div/div/tag-input-form/form/input")
	WebElement surgeries;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[1]/form/div/div[2]/div[2]/tag-input/div/div/tag-input-form/form/input")
	WebElement chronicDisease;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[1]/form/div/div[3]/div[2]/tag-input/div/div/tag-input-form/form/input")
	WebElement healthConditions;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[1]/form/div/div[4]/div[2]/tag-input/div/div/tag-input-form/form/input")
	WebElement allergies;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[1]/form/div/div[7]/div/button")
	WebElement update;
	public Patients_Profile() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		patients.click();
	}
	public void searchPatients(String patientName,String surgery,String chronic,String conditions,String allergy) throws InterruptedException
	{
		search.sendKeys(patientName+Keys.ENTER);
		List<WebElement> patientsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[2]/div"));
		for(int i=0;i<patientsList.size();i++)
		{
		 {
			//System.out.println("patient Details : "+patientsList.get(0).getText());
			try
			{
				System.out.println("patient Details : "+patientsList.get(i).getText());
			patientsList.get(i).click();
			toEditProfileData(surgery, chronic, conditions, allergy);
			
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> patientsList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[2]/div"));
				System.out.println("patient Details : "+patientsList1.get(i).getText());
				patientsList1.get(i).click();
				toEditProfileData(surgery, chronic, conditions, allergy);
			}
			Thread.sleep(5000);
			}
		}
	}
	public void  toEditProfileData(String surgery,String chronic,String conditions,String allergy)
	{
		profile.click();
		surgeries.sendKeys(surgery);
		chronicDisease.sendKeys(chronic);
		healthConditions.sendKeys(conditions);
		allergies.sendKeys(allergy);
		List<WebElement> DietList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[1]/form/div/div[6]"));
		System.out.println(DietList.size());
		for(int i=0;i<DietList.size();i++)
		{
			String details=DietList.get(i).getText();
			System.out.println(details);
		}
		update.click();
	}
}
