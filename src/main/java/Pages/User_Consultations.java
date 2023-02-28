package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class User_Consultations  extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a")
	WebElement consultations;
	@FindBy(xpath="//*[@id=\"related-consultation-tab\"]")
	WebElement realtedConsultations;
	
	@FindBy(xpath="//*[@id=\"recommended-video-tab\"]")
	WebElement recommendedVideo;
	@FindBy(xpath="//*[@id=\"payment-details-tab\"]")
	WebElement paymentDetails;
	
	public User_Consultations() {
		PageFactory.initElements(driver, this);
	}
	
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a")));
		consultations.click();	
	}
	 
	public void toViewAllConsultations(String status) throws InterruptedException
	{
		String details="";
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		//WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"container\\\"]/div/app-consultations/div[2]/div[1]/div")));
		Thread.sleep(8000);
		List<WebElement> consultationsList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-consultations/div[2]/div[1]/div"));
		
		for(int i=0;i<consultationsList.size();i++)
		{
			try
			{ 
				//System.out.println("##"+status);
				Thread.sleep(6000);
				
				if(consultationsList.get(i).getText().contains(status)) {
				
				consultationsList.get(i).click();
				toViewConsultationDetails();
				toViewRelatedConsultations();
				toViewRecommenededVideo();
				toViewPaymentDetails();
				break;
			}
			}
			//}
			catch(StaleElementReferenceException s)
			{
				
				List<WebElement> consultationstList1 = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-consultations/div[2]/div[1]/div"));
			//	System.out.println("##"+status);
				Thread.sleep(6000);
				details=consultationstList1.get(i).getText();
				
				if(consultationstList1.get(i).getText().contains(status)) 
				{
						 
				
					consultationstList1.get(i).click();
					toViewConsultationDetails();
					toViewRelatedConsultations();
					toViewRecommenededVideo();
					toViewPaymentDetails();
					break;
				
				}
			}
			
		}
		Thread.sleep(3000);
	}
	public void toViewConsultationDetails() throws InterruptedException
	{
		List<WebElement> consultationstList = driver.findElements(By.xpath("//*[@id=\"consultation-details\"]/div"));
		Thread.sleep(6000);
		for(int i=0;i<consultationstList.size();i++)
		{
			if(consultationstList.get(i).getText().contains("Join"))
			{
				System.out.println("Join Meeting Is There");
			}
		System.out.println("Consultation Details:"+consultationstList.get(i).getText());
		}
	}
	public void toViewRelatedConsultations()
	{
		realtedConsultations.click();
		List<WebElement> consultationstList = driver.findElements(By.xpath("//*[@id=\"related-consultation\"]/div/a/div"));
		
		for(int i=0;i<consultationstList.size();i++)
		{
		System.out.println("Related Consultation Details:"+consultationstList.get(i).getText());
		}
	}
	public void toViewRecommenededVideo()
	{
		recommendedVideo.click();
		List<WebElement> videosList = driver.findElements(By.xpath("//*[@id=\"recommended-video\"]/div/div[2]"));
		
		for(int i=0;i<videosList.size();i++)
		{
		System.out.println("Video Details:"+videosList.get(i).getText());
		}
	}
	public void toViewPaymentDetails()
	{
		paymentDetails.click();
		List<WebElement> paymentList = driver.findElements(By.xpath("//*[@id=\"payment-details\"]/div/div/div"));
		
		for(int i=0;i<paymentList.size();i++)
		{
		System.out.println("Payment Details:"+paymentList.get(i).getText());
		}
	}
	public void toCheckJoinMeeing(String clinicianName, String date,String date1,String statusClinician,String statusUser,String pName) throws InterruptedException
	{
		Logoff log=new Logoff();
		log.logOff();
		Login login=new Login();
		User_Login ulogin=new User_Login();
		login.login(prop.getProperty("email"), prop.getProperty("password"));
		Consultations consult=new Consultations();
		consult.view();
		consult.viewConsultationsDetails1(date, statusClinician, pName);
	
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		ulogin.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		consultations.click();
		toViewAllConsultations(statusUser);
		Thread.sleep(6000);
	}
	}


