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

public class Consultations extends TestBase {

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
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/div[2]/div/div/button")
	WebElement joinMeeting;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-meeting/div/nav/a[3]")
	WebElement recommendVideo;
	@FindBy(xpath="//*[@id=\"recommendVideos\"]/div/div/div/div/ng-multiselect-dropdown/div/div[1]/span")
	WebElement videoCategory;
	public Consultations() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")));
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
	public void viewConsultationsDetails(String date,String status,String pname) throws InterruptedException
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
						 if(details.contains(pname))
						 {
							 System.out.println("&"+details);
							 Thread.sleep(4000);
						 consultList.get(i).click();
						 Thread.sleep(4000);
						 viewConsultationDetails();
						 viewRelatedConsultations();
						 viewRecommandedVideos();
				     }	
					}
				}
				catch(StaleElementReferenceException s)
				{
					 List<WebElement> consultList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-consultations/div[2]/div[2]/div"));
					Iterator<WebElement> iterator = consultList1.iterator();

					while (iterator.hasNext()) {
						 details = consultList1.get(i).getText();	
						 if(details.contains(pname))
						 {
							 System.out.println("&"+details);
							 Thread.sleep(4000);
						 consultList1.get(i).click();
						 Thread.sleep(7000);
						 //viewConsultationDetails();
						 viewRelatedConsultations();
						 viewRecommandedVideos();
				     }	
				     }	
					
				}
				
			}
			Thread.sleep(5000);
	}
	public void viewConsultationsDetails1(String date,String status,String pname) throws InterruptedException
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
							 if(details.contains(pname))
							 {
						 consultList.get(i).click();
						 Thread.sleep(4000);
						 viewConsultationDetails();
							 }
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
							 if(details.contains(pname))
							 {
						 consultList1.get(i).click();
						 Thread.sleep(7000);
						 viewConsultationDetails();
							 }
				     }	
				     }	
					
				}
				
			}
			Thread.sleep(5000);
	}
	public void viewConsultationDetails() throws InterruptedException
	{
		String details="";
		Thread.sleep(3000);
		 List<WebElement> consultDetailsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-consultation/div/div[2]/div/div[1]/div"));
		System.out.println(consultDetailsList.get(0).getText());
			for (int i = 0; i < consultDetailsList.size(); i++) {
				
				 details = consultDetailsList.get(i).getText();
				 startMeeting.click();
				 String category="Anti-Rotation";
				 Thread.sleep(20000);
				
				// joinMeeting.click();
				// Thread.sleep(20000);
				 System.out.println("$"+details);
	}
	}
	public void viewRelatedConsultations()throws InterruptedException
	{
		relatedConsultations.click();
		String details="";
		 List<WebElement> consultDetailsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-consultation/div/div[2]/div/div[4]/div"));
			
			for (int i = 0; i < consultDetailsList.size(); i++) {
				
				 details = consultDetailsList.get(i).getText();
				 System.out.println(details);
	}
	}
	public void viewRecommandedVideos() throws InterruptedException
	{
		recommandedVideos.click();
		String details="";
		 List<WebElement> videoDetailsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-consultation/div/div[2]/div/div[5]/div[1]"));
			
			for (int i = 0; i < videoDetailsList.size(); i++) {
				
				 details = videoDetailsList.get(i).getText();
				 System.out.println(details);
	}
	}
}
