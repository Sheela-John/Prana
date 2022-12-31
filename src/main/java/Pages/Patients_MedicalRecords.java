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

public class Patients_MedicalRecords extends TestBase {
	
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement patients;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/nav/div/a[6]")
	WebElement medicalRecords;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[1]/div/div/input")
	WebElement search;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[6]/app-user-medical-records/div[2]/div/div/div/button")
	WebElement uploadNow;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[6]/app-user-medical-records/div[4]/div/div/div[2]/form/div[1]/div/div[1]/input")
	WebElement fileName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[6]/app-user-medical-records/div[4]/div/div/div[2]/form/div[2]/input")
	WebElement choosefile;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[6]/app-user-medical-records/div[4]/div/div/div[3]/button[1]")
	WebElement upload;
	public Patients_MedicalRecords() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		patients.click();
	}
	public void searchPatients(String patientName) throws InterruptedException
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
			
			
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> patientsList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[2]/div"));
				System.out.println("patient Details : "+patientsList1.get(i).getText());
				patientsList1.get(i).click();
				
			}
			Thread.sleep(5000);
			}
		}
	}
	public void toAddMedicalRecords(String name,String path) throws InterruptedException
	{
		medicalRecords.click();
		uploadNow.click();
		Thread.sleep(3000);
		fileName.sendKeys(name);
		choosefile.sendKeys(path);
		upload.click();
		
	}
}
