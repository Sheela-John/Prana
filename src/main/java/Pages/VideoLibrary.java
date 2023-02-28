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

public class VideoLibrary extends TestBase {
	
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement patients;
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")
	WebElement videoLibrary;
	
	public VideoLibrary() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		videoLibrary.click();
	}
	public void viewVideoLibrary() throws InterruptedException
	{
		Thread.sleep(5000);
		List<WebElement> videosList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-video-library/app-exercise-library/div[2]/div/div/div[2]/div/div/div"));
		for(int i=0;i<videosList.size();i++)
		{
		 {
			//System.out.println("patient Details : "+patientsList.get(0).getText());
			try
			{
				System.out.println("patient Details : "+videosList.get(i).getText());
				videosList.get(i).click();
			
			
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> videosList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-video-library/app-exercise-library/div[2]/div/div/div[2]/div/div/div"));
				System.out.println("patient Details : "+videosList1.get(i).getText());
				videosList1.get(i).click();
				
			}
			Thread.sleep(5000);
			}
		}
	}
}
