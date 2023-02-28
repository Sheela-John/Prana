package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class User_GroupClassConsultations extends TestBase{
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[5]/a")
	WebElement groupClassConsultations;
	
 public User_GroupClassConsultations()  {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[5]/a")));
		groupClassConsultations.click();	
	}
	public void toViewGroupClass(String title) throws InterruptedException
	{
		Thread.sleep(5000);
		List<WebElement> groupClassList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-group-session-consultation/div[2]/div[1]/div"));
	
		for(int i=0;i<groupClassList.size();i++)
		{
			try {
		 	if(groupClassList.get(i).getText().contains(title)) {
		 		groupClassList.get(i).click();
		 		Thread.sleep(3000);
		 		List<WebElement> ConsultationList = driver.findElements(By.xpath("//*[@id=\"consultation-details\"]/div"));
		 		System.out.println(ConsultationList.get(0).getText());
		 		break;
		 	}
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> groupClassList1 = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-group-session-consultation/div[2]/div[1]/div"));
				if(groupClassList1.get(i).getText().contains(title)) {
			 		groupClassList1.get(i).click();
			 		Thread.sleep(3000);
			 		List<WebElement> ConsultationList1 = driver.findElements(By.xpath("//*[@id=\"consultation-details\"]/div"));
			 		System.out.println(ConsultationList1.get(0).getText());
			 		break;
			 	}
			}
			
		}
		
	}
	public void toViewJoinMeetingInGroupClass(String title) throws InterruptedException
	{
		Thread.sleep(5000);
		List<WebElement> groupClassList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-group-session-consultation/div[2]/div[1]/div"));
	
		for(int i=0;i<groupClassList.size();i++)
		{
			try {
		 	if(groupClassList.get(i).getText().contains(title)) {
		 		groupClassList.get(i).click();
		 		Thread.sleep(3000);
		 		List<WebElement> ConsultationList = driver.findElements(By.xpath("//*[@id=\"consultation-details\"]/div"));
		 		//toCheckJoinMeetingInGroupClass(title);
		 		if(ConsultationList.get(0).getText().contains("Join"))
		 		{
		 			System.out.println("Join Meeting is There");
		 		}
		 		//System.out.println(ConsultationList.get(0).getText());
		 		break;
		 	}
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> groupClassList1 = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-group-session-consultation/div[2]/div[1]/div"));
				if(groupClassList1.get(i).getText().contains(title)) {
			 		groupClassList1.get(i).click();
			 		Thread.sleep(3000);
			 		List<WebElement> ConsultationList1 = driver.findElements(By.xpath("//*[@id=\"consultation-details\"]/div"));
			 	//	toCheckJoinMeetingInGroupClass(title);
			 		if(ConsultationList1.get(0).getText().contains("Join"))
			 		{
			 			System.out.println("Join Meeting is There");
			 		}
			 		break;
			 	}
			}
			
		}
	}
	public void toCheckJoinMeetingInGroupClass(String title) throws InterruptedException
	{
		Thread.sleep(3000);
		Logoff log=new Logoff();
		log.logOff();
		Login login=new Login();
		User_Login ulogin=new User_Login();
		login.login(prop.getProperty("email"), prop.getProperty("password"));
		AppointmentsGroupClass app_Clinician=new AppointmentsGroupClass();
		Thread.sleep(3000);
		app_Clinician.view();
		app_Clinician.toCreateConsultationForGroupClass(title);
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		ulogin.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		groupClassConsultations.click();
		toViewJoinMeetingInGroupClass(title);
	}

}
