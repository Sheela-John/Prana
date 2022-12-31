package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Patients_RecommandVideo extends TestBase {
	
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement patients;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[1]/div/div/input")
	WebElement search;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/nav/div/a[3]")
	WebElement recommand_video;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[1]/span/span[1]")
	WebElement videoType;
	public Patients_RecommandVideo() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		patients.click();
	}
	public void searchPatients(String patientName,String type1, String type2) throws InterruptedException
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
			toSelectVideo(type1);
			toSelectVideo(type2);
			Thread.sleep(5000);
			toViewVideos();
			
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> patientsList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[2]/div"));
				System.out.println("patient Details : "+patientsList1.get(i).getText());
				patientsList1.get(i).click();
				toSelectVideo(type1);
				toSelectVideo(type2);
				Thread.sleep(5000);
				toViewVideos();
			}
			Thread.sleep(5000);
			}
		}
	}

	public void toSelectVideo(String Type) throws InterruptedException
	{
		recommand_video.click();
		Thread.sleep(3000);
		videoType.click();
		if(Type.contains("Anti-Rotation") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/input")));
		  }
		}
		else if(Type.contains("Balance") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/input")));
		  }
		}
		else if(Type.contains("Conditioning") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]/input")));
		  }
		}
		else if(Type.contains("Mobility") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[4]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[4]/input")));
		  }
		}
		else if(Type.contains("Power") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[5]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[5]/input")));
		  }
		}
		else if(Type.contains("Strength") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[6]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[6]/input")));
		  }
		}
		else if(Type.contains("Task-specific training") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[7]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[7]/input")));
		  }
		}
		else if(Type.contains("Integrated Movement (Shoulder and Hips)") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[8]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[8]/input")));
		  }
		}
		else if(Type.contains("Hip Complex") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[9]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[9]/input")));
		  }
		}
		else if(Type.contains("Management") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[10]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[10]/input")));
		  }
		}
		else if(Type.contains("Movement Integration") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[11]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[11]/input")));
		  }
		}
		else if(Type.contains("Thoracic Mobility") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[12]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[12]/input")));
		  }
		}
		else if(Type.contains("Neck and Shoulder") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[13]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[13]/input")));
		  }
		}
		else if(Type.contains("Spinal Health") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[14]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[14]/input")));
		  }
		}
		else if(Type.contains("Dynamic balance") )
		{
		try {
		     driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[15]/input")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[15]/input")));
		  }
		}
}
	public void toViewVideos() throws InterruptedException
	{
		List<WebElement>videoList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[2]/div"));
		for(int i=0;i<videoList.size();i++)
		{
		 {
			//System.out.println("patient Details : "+patientsList.get(0).getText());
			try
			{
				System.out.println("video Details : "+videoList.get(i).getText());
								
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> videoList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/div[2]/div"));
				System.out.println("video Details : "+videoList1.get(i).getText());
				
			}
			Thread.sleep(5000);
			}
		}
	}
}