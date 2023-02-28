package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Patients_Appointments extends TestBase {
			
			
			@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
			WebElement patients;
			@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[1]/div/div/input")
			WebElement search;
			@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/nav/div/a[2]")
			WebElement appointments;
			
			public Patients_Appointments() {
				PageFactory.initElements(driver, this);
			}
			public void view() throws InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(driver, 40);
				WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
				patients.click();
			}
			public void searchPatients(String patientName,String status) throws InterruptedException
			{
				search.sendKeys(patientName+Keys.ENTER);
				List<WebElement> patientsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[2]/div"));
				for(int i=0;i<patientsList.size();i++)
				{
				 {
					//System.out.println("patient Details : "+patientsList.get(0).getText());
					try
					{
						Thread.sleep(3000);
						System.out.println("patient Details : "+patientsList.get(i).getText());
					patientsList.get(i).click();
					toViewAppointments(status);
					
					}
					catch(StaleElementReferenceException s)
					{
						Thread.sleep(3000);
						List<WebElement> patientsList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[2]/div"));
						System.out.println("patient Details : "+patientsList1.get(i).getText());
						patientsList1.get(i).click();
						toViewAppointments(status);
					}
					Thread.sleep(5000);
					}
				}
			}
			
			public void toViewAppointments(String status) throws InterruptedException
			{
				appointments.click();
				Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[2]/div/div[1]/div/div[2]/select")));
				select.selectByVisibleText(status);
				List<WebElement>appointmentList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]"));
				for(int i=0;i<appointmentList.size();i++)
				{
				 {
					//System.out.println("patient Details : "+patientsList.get(0).getText());
					try
					{
						System.out.println("patient Details : "+appointmentList.get(i).getText());
										
					}
					catch(StaleElementReferenceException s)
					{
						List<WebElement> appointmentList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]"));
						System.out.println("patient Details : "+appointmentList1.get(i).getText());
						
					}
					Thread.sleep(5000);
					}
				}
			}
}
