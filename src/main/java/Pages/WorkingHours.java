package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class WorkingHours extends TestBase{
	@FindBy(xpath = "/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[5]/a")
	WebElement WorkingHours;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-working-hours/div[2]/div[2]/div/div[1]/div[1]/div/div/input")
	WebElement enableDisable;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-working-hours/div[2]/div[2]/div/div[2]/div/div/div[2]/form/div[1]/div[1]/input")
	WebElement startTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-working-hours/div[2]/div[2]/div/div[2]/div/div/div[2]/form/div[1]/div[2]/input")
	WebElement endTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-working-hours/div[2]/div[2]/div/div[1]/div[2]/button")
	WebElement createSession;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-working-hours/div[2]/div[1]/div[1]/form/div[1]/ng-multiselect-dropdown/div")
	WebElement Categories;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-working-hours/div[2]/div[1]/div[2]/button")
	WebElement saveCategory;
	 public WorkingHours() {
		PageFactory.initElements(driver, this);
	}
	public void viewWorkingHours()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[5]/a")));
		WorkingHours.click();
	}
	public void SetDayValue(String day) throws InterruptedException
	{
		Thread.sleep(3000);
		 List<WebElement> DayList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-working-hours/div[2]/nav/div/a"));
			for (int j = 0; j <= DayList.size() - 1; j++) {	
				String details = DayList.get(j).getText();
				 if (details.contains(day))
				 {
						DayList.get(j).click();
						Thread.sleep(7000);
						break;
				}
		}
		 
	}
	public void toEnabletheDay(String category1,String day,String strTime,String eTime,String clinic) throws InterruptedException {
		
		toSelectCategory(category1);
	//	toSelectCategory(category2);
		SetDayValue(day);
	
		System.out.println(enableDisable.isEnabled());
		
		
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-working-hours/div[2]/div[2]/div/div[1]/div[1]/div/div/input")));
		  
		
			Thread.sleep(8000);
			startTime.sendKeys(strTime);
			Thread.sleep(4000);
			System.out.println("Start");
			Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-working-hours/div[2]/div[2]/div/div[2]/div/div/div[2]/form/div[3]/select")));
			select.selectByVisibleText(clinic);
			Thread.sleep(4000);
			endTime.sendKeys(eTime);
			System.out.println("end");
			Thread.sleep(5000);
	
		
		
	
	}
	public void toSelectCategory(String category) throws InterruptedException
	{
		Categories.click();
		
		String[] conditionarr = category.split(","); 
		for (String con : conditionarr) {
			{
			String specxpath = "//input[@aria-label='" + con + "']";		
			WebElement Spec_dropdown = driver.findElement(By.xpath(specxpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);	
			}
		}
		Thread.sleep(3000);
		saveCategory.click();
	}
}
