package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class UserReport extends TestBase{
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[7]/a")
	WebElement userReports;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-user-report/div[1]/div[2]/div/div/div[2]/div/button")
	WebElement viewReports;
	@FindBy(xpath="//*[@id=\"headingTwo\"]/h5/button")
	WebElement history;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div/div/div/div/form/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement searchName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-user-report/div[1]/div[2]/div/div/div[3]/div[2]/div/div/div/div/form/div/div[4]/div[1]/input")
	WebElement StartDate;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-user-report/div[1]/div[2]/div/div/div[3]/div[2]/div/div/div/div/form/div/div[5]/div[1]/input")
	WebElement EndDate;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div/div/div/div/button")
	WebElement view;
	public UserReport() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		userReports.click();
		
	}
	public void viewUserReports()throws InterruptedException
	{
	
		viewReports.click();
		List<WebElement> UserReportList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-user-report/ng-custom-table/div/div[2]/div/table/tbody"));
		System.out.println(UserReportList.get(0).getText());
		for(int i=0;i<UserReportList.size();i++)
		{
		 	
				System.out.println("patient Details : "+UserReportList.get(i).getText());
			
		}
	}
	public void toViewHistoryOfSpecificClient(String cname,String sdate,String edate) throws InterruptedException
	{
		history.click();
		searchName.sendKeys(cname);
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div/div/div/div/form/div/div[1]/tag-input/tag-input-dropdown/ng2-dropdown/div"));
		action.moveToElement(we).click().build().perform();
		Thread.sleep(4000);
		StartDate.click();
		String splitter[] = sdate.split("-");
		String month_year = splitter[1];
		String day = splitter[0]; 
		selectDate(month_year,day); 
		Thread.sleep(3000);
		
		EndDate.click();
		System.out.println(edate);
		String splitter1[] = edate.split("-");
		String month_year1 = splitter1[1];
		System.out.println(splitter1[0]);
		String day1 = splitter1[0]; 
		System.out.println(month_year1);
		System.out.println(day1);
		selectDate(month_year1,day1); 
		Thread.sleep(4000);
		view.click();
		List<WebElement> UserReportList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-user-report/div[2]/div/div/ng-custom-table/div/div[2]/div/table/tbody"));
		System.out.println(UserReportList.get(0).getText());
		for(int i=0;i<UserReportList.size();i++)
		{
			System.out.println("patient Details : "+UserReportList.get(i).getText());
			
		}
	}

	public void selectDate(String month_year, String select_day) throws InterruptedException
	{ 
	List<WebElement> elements = driver.findElements(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]"));

	for (int i=0; i<elements.size();i++)
	{
	
	if(elements.get(i).getText().contains(month_year))
	{ 
	List<WebElement> days = driver.findElements(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr/td"));
	for (WebElement d:days)
	{ 
	if(d.getText().equals(select_day))
	{
	d.click();
	Thread.sleep(10000);
	break;
	}
	} 

	} 

	}

	}
}
