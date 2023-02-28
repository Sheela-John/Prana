package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class User_ExerciseLibrary extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[8]/a")
	WebElement exerciseLibrary;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-exercise-library-details/div[2]/div/div[2]")
	WebElement videoDetails;
	@FindBy(xpath="//*[@id=\"headingTwo\"]/h2/button")
	WebElement purchasedVideos;
	public User_ExerciseLibrary() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")));
		exerciseLibrary.click();	
	}
	public void toViewAllVideos(String video,String videoName) throws InterruptedException
	{
		Thread.sleep(5000);
	List<WebElement> videoList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-exercise-library/div[2]/div/div/div[2]/div/div/div/div/div"));
		
		for(int i=0;i<videoList.size();i++)
		{
			try
			{
			if(videoList.get(i).getText().contains(video)) {
				System.out.println(videoList.get(i).getText());
				videoList.get(i).click();
				Thread.sleep(8000);
				List<WebElement> videoListDetails = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-exercise-library/div[2]/div/div/div[2]/div/div/div/div/div"));
				for(int j=0;j<videoListDetails.size();j++)
				{
					System.out.println(videoListDetails.get(i).getText().contains(videoName));
				if(videoListDetails.get(j).getText().contains(videoName))
				{
					
					videoListDetails.get(j).click();
					Thread.sleep(8000);
					if(videoDetails.getText().contains("$"))
					{
						System.out.println("Its a Paid Video");
					}
					else
					{
						System.out.println("Its a Free Video");
					}
					break;
				}
				}
				break;
			}
			}
			catch(StaleElementReferenceException l)
			{
				List<WebElement> videoList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-exercise-library/div[2]/div/div/div[2]/div/div/div/div/div"));
				if(videoList1.get(i).getText().contains(video)) {
					System.out.println(videoList1.get(i).getText());
					videoList1.get(i).click();
					Thread.sleep(8000);
					List<WebElement> videoListDetails = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-exercise-library/div[2]/div/div/div[2]/div/div/div/div/div"));
					for(int j=0;j<videoListDetails.size();j++)
					{
						System.out.println(videoListDetails.get(i).getText().contains(videoName));
					if(videoListDetails.get(j).getText().contains(videoName))
					{
						videoListDetails.get(j).click();
						Thread.sleep(8000);
						if(videoDetails.getText().contains("$"))
						{
							System.out.println("Its a Paid Video");
						}
						else
						{
							System.out.println("Its a Free Video");
						}
					}
					}
				}
			}
		}
	}
	
	public void toViewPurchasedVideos(String Name)
	
	{
		purchasedVideos.click();
		List<WebElement> videoList = driver.findElements(By.xpath("//*[@id=\"collapseTwo\"]/div/div/div/div"));
		
		for(int i=0;i<videoList.size();i++)
		{
			if(videoList.get(i).getText().contains(Name)) {
				System.out.println("Video Available");
			}
		}
	}
	
}

