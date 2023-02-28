package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class RecommendedVideos extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[4]/a")
	WebElement consultations;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-consultations/div[2]/div[1]/div[2]/input")
	WebElement date;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-consultation/div/div[2]/nav/div/a[2]")
	WebElement relatedConsultations;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-consultation/div/div[2]/nav/div/a[3]")
	WebElement recommandedVideos;
	@FindBy(xpath="//*[@id=\"consultation-details\"]/div/div[1]/div[4]/div/div/button")
	WebElement startMeeting;
	@FindBy(xpath="//*[@id=\"recommendVideos\"]/div/div/div/div/ng-multiselect-dropdown/div/div[1]/span")
	WebElement videoCategory;
	@FindBy(xpath="//*[@id=\"consultation-details\"]/div/div[1]/div[4]/div/div/div/span/button")
	WebElement statMeeting1;
	@FindBy(xpath="//*[@id=\"wc-footer\"]/div/div[1]/div/button")
	WebElement joinAudio;
	public RecommendedVideos() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")));
		consultations.click();	
	}
	public void setDateValue(String dateval) throws InterruptedException
	{
		date.clear();
		date.sendKeys(dateval);
		System.out.println(dateval);
	}
	public void setStatus(String status) throws InterruptedException
	{
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-consultations/div[2]/div[1]/div[4]/select")));
		select.selectByIndex(2);
		select.selectByVisibleText(status);
		
		Thread.sleep(3000);
	}
	public void viewConsultationsDetails1(String date,String status,String pname,String category) throws InterruptedException
	{
		setDateValue(date);
		setStatus(status);
		Thread.sleep(6000);
		String details="";
		 List<WebElement> consultList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-consultations/div[2]/div[2]/div"));
		
			for (int i = 0; i < consultList.size(); i++) {
			
				try {
				 details = consultList.get(i).getText();
				 System.out.println("&"+details);
				 Iterator<WebElement> iterator = consultList.iterator();
					while (iterator.hasNext()) {
						 details = consultList.get(i).getText();
						
						 {
							 System.out.println("&"+details);
							 Thread.sleep(4000);
						 consultList.get(i).click();
						 Thread.sleep(4000);
						 viewConsultationDetails(category);
						
				     }	
					}
				}
				catch(StaleElementReferenceException s)
				{
					 List<WebElement> consultList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-consultations/div[2]/div[2]/div"));
					Iterator<WebElement> iterator = consultList1.iterator();

					while (iterator.hasNext()) {
						 details = consultList1.get(i).getText();	
						
						 {
							 System.out.println("&"+details);
							 Thread.sleep(4000);
						 consultList1.get(i).click();
						 Thread.sleep(7000);
						 viewConsultationDetails(category);
					
				     }	
				     }	
					
				}
				
			}
			Thread.sleep(5000);
	}
	public void viewConsultationDetails(String category) throws InterruptedException
	{
		String details="";
		Thread.sleep(3000);
		 List<WebElement> consultDetailsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-consultation/div/div[2]/div/div[1]/div"));
		System.out.println(consultDetailsList.get(0).getText());
			for (int i = 0; i < consultDetailsList.size(); i++) {
				
				 details = consultDetailsList.get(i).getText();
				 startMeeting.click();
				
				// statMeeting1.click();
				 Thread.sleep(25000);
				 joinAudio.click();
				 Thread.sleep(3000);
				 recommandedVideos.click();
				 videoCategory.click();
				 String[] conditionarr = category.split(","); 
					for (String con : conditionarr) {
						{
						String specxpath = "//input[@aria-label='" + con + "']";		
						WebElement Spec_dropdown = driver.findElement(By.xpath(specxpath));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);	
						}
					}
					videoCategory.click();
					
					List<WebElement> videoList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-user-medical-records/div[2]/div"));
					
					for(int j=0;j<videoList.size();i++)
					{
						System.out.println(videoList.get(j).getText());
					}
				}
				// joinMeeting.click();
				// Thread.sleep(20000);
				 System.out.println("$"+details);
	}

}

