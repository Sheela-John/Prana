package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;import org.bouncycastle.asn1.x509.qualified.TypeOfBiometricData;
import org.jsoup.internal.FieldsAreNonnullByDefault;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class AppointmentsGroupClass extends TestBase {

	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")
	WebElement appointments;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[1]/a")
	WebElement back;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[4]/div/div/button[1]")
	WebElement edit;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[12]/div[2]/div[1]/div/input")
	WebElement isPaidYes;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[3]/button[2]")
	WebElement update;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[2]/div[1]/h5/button")
	WebElement paymentAndBillingDetails;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[4]/div[1]/h5/button")
	WebElement userAppointments;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/div/div/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement searchByName;
	@FindBy(xpath="//div[@class='ng2-dropdown-container']")
	WebElement element;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[8]/div/div/div[2]/form/div[3]/div[3]/div[1]/input")
	WebElement endTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[8]/div/div/div[2]/form/div[6]/div/textarea")
	WebElement reasonForBlocking;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[8]/div/div/div[3]/button[1]")
	WebElement blockSession;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[8]/div/div/div[2]/form/div[5]/div/ng-multiselect-dropdown/div/div[1]/span")
	WebElement clinician;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[1]/div/input")
	WebElement groupClassTitle;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[3]/div[1]/textarea")
	WebElement groupClassDescription;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[5]/div[2]/input")
	WebElement groupClassEndTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[6]/div/div[1]/div/div[1]/input")
	WebElement groupClassPayment_PrePaid;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[6]/div/div[1]/div/div[2]/input")
	WebElement groupClassPayment_PostPayment;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[7]/div[1]/input")
	WebElement groupClassAmount;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[8]/div[1]/input")
	WebElement groupClassNoOfSpots;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[10]/div/ng-multiselect-dropdown/div/div[1]/span")
	WebElement GClinician;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[11]/div/div[1]/div/div[1]/input")
	WebElement Glocation_inclinic;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[11]/div/div[1]/div/div[2]/input")
	WebElement Glocation_virtual;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[3]/button[1]")
	WebElement createGroupClass;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[3]/button[1]")
	WebElement create;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/nav/div/a[1]")
	WebElement createNewUser;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[1]/form/div[1]/div/div[1]/input")
	WebElement userFullName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[1]/form/div[2]/div/div[1]/input")
	WebElement userEmail;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[1]/form/div[3]/div/ngx-intl-tel-input/div/input")
	WebElement userPhone;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[1]/form/div[4]/div/div[1]/input")
	WebElement userDOB;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[1]/form/div[5]/div/div[1]/div/div[1]/input")
	WebElement userMale;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[1]/form/div[5]/div/div[1]/div/div[2]/input")
	WebElement userFemale;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[1]/form/div[5]/div/div[1]/div/div[3]/input")
	WebElement userOther;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[1]/form/div[6]/div/div[1]/input")
	WebElement userAgree;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[3]/button[1]")
	WebElement registerUser;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[2]/div/form/div[9]/div/div[1]/input")
	WebElement newAppointmentDate;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[2]/div/form/div[10]/div[1]/input")
	WebElement newStartTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[2]/div/form/div[10]/div[2]/div[1]/input")
	WebElement newEndTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[2]/div/form/div[13]/div[2]/div[1]/div/input")
	WebElement newIsPaidYes;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[3]/button[2]")
	WebElement newUpdate;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[3]/button[2]")
	WebElement reschedule;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[4]/div/div/button[2]")
	WebElement viewReschedule;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[9]/div/div[1]/input")
	WebElement rescheduleAppointmentDate;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[10]/div[1]/input")
	WebElement rescheduleStartTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[10]/div[2]/div[1]/input")
	WebElement rescheduleEndTime;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[7]/div/div/div[2]/div[2]/input")
	WebElement reasonForCancellation;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[7]/div/div/div[3]/button[1]")
	WebElement cancelSession;
	
	@FindBy(xpath="//div[@class='form-group warning-color p-2']")
	WebElement warning;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[3]/button[2]")
	WebElement close_createSession;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-view-group-session/div[1]/div[1]/a")
	WebElement backGroupClass;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div[1]/div[8]/div/div/button[3]")
	WebElement createConsultationForGroupClass;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div[1]/div[8]/div/div[1]/a")
	WebElement clicktoViewConsultationDetailsforGroupClass;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-view-group-session-consultation/div[1]/div[1]/a")
	WebElement backForViewConsultaionDetailsForGroupClass;
	@FindBy(xpath="//*[@id=\"consultation-details\"]/div/div[1]/div[3]/div/div/button")
	WebElement startMeetingForGroupClass;
	@FindBy(xpath="//*[@id=\"consultation-details\"]/div/div[1]/div[3]/div/div/div/button")
	WebElement EndConsultationForGroupClass;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-view-group-session-consultation/div[2]/div/div/div[3]/button[1]")
	WebElement endMeetingForGroupClass;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[13]/div/div/div[2]/form/div/textarea")
	WebElement inviteUsers;
	@FindBy(xpath="//*[@id=\"clinicTabContent\"]/div[13]/div/div/div[3]/button[1]")
	WebElement inviteBtn;
	
	public AppointmentsGroupClass() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		appointments.click();
	}
	public void viewCalendar() throws InterruptedException
	{
	//	List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[2]"));
			Thread.sleep(5000);
			
				List<WebElement> appointmentList = driver.findElements(By.xpath("//div[@class ='cal-event-container cal-draggable cal-starts-within-day cal-ends-within-day ng-star-inserted']"));
				//System.out.println(appointmentList.size());
				for(int j=0;j<appointmentList.size();j++)
				{
				Thread.sleep(3000);
				try {
			//	System.out.println("#"+appointmentList.get(j).getText());
				if(appointmentList.get(j).getText().contains("Sachin"))
				{
					System.out.println("#"+appointmentList.get(j).getText());
				appointmentList.get(j).click();
				Thread.sleep(5000);
				
				edit.click();
				 JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[12]/div[2]/div[1]/div/input")));
				//isPaidYes.click();
				Thread.sleep(3000);
				update.click();
				Thread.sleep(3000);
				viewPaymentAndBillingDetails();
				Thread.sleep(2000);
				viewUserAppointments();
				 executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[1]/a")));
				//back.click();
				}
				}
				catch(StaleElementReferenceException s)
				{
					List<WebElement> appointmentList1 = driver.findElements(By.xpath("//div[@class ='cal-event-container cal-draggable cal-starts-within-day cal-ends-within-day ng-star-inserted']"));
					System.out.println("#"+appointmentList1.get(j).getText());
					if(appointmentList.get(j).getText().contains("Brightlin"))
					{
					appointmentList1.get(j).click();
					Thread.sleep(5000);
					
					edit.click();
					 JavascriptExecutor executor = (JavascriptExecutor) driver;
				     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[12]/div[2]/div[1]/div/input")));
				//	isPaidYes.click();
					Thread.sleep(3000);
					update.click();
					Thread.sleep(3000);
					viewPaymentAndBillingDetails();
					Thread.sleep(2000);
					viewUserAppointments();
					 executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[1]/a")));
					//back.click();
				}
				}
				
				Thread.sleep(3000);
				}
			
		
	}
	public void viewPaymentAndBillingDetails()throws InterruptedException
	{
		paymentAndBillingDetails.click();
		List<WebElement> paymentList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[2]/div[2]/div"));
	//	System.out.println(paymentList.get(0).getText());
		for(int i=0;i<paymentList.size();i++)
		{
			System.out.println("Details : "+paymentList.get(i).getText());
		}
	}
	public void viewUserAppointments() throws InterruptedException
	{
		userAppointments.click();
		List<WebElement> userAppointmentList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[1]/div[2]/div/div[4]/div[2]/div/div[2]"));
		//	System.out.println(paymentList.get(0).getText());
			for(int i=0;i<userAppointmentList.size();i++)
			{
				System.out.println("Details : "+userAppointmentList.get(i).getText());
			}
	}
	public void toPerformActions(String fname,String email,String phone,String dob,String gender,String service,String rooms,String clinicianName,String clinicianList,String GTitle,String GDesc,String GendTime,String paytype,String GAmount,String GSpots,String GHost,String GdoctorsNameList,String Glocation) throws InterruptedException
	{
		List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[1]"));
		for(int i=0;i<calendar.size();i++)
		{
		//	System.out.println("Details : "+calendar.get(i).getText());
			Thread.sleep(3000);
			
			//createNewUser(fname,email, phone, dob, gender);
			createSession(service,rooms,clinicianName);
			//blockSession(clinicianList);
			//createGroupClass(GTitle,GDesc,GendTime,paytype, GAmount, GSpots, GHost, GdoctorsNameList, Glocation);
			Thread.sleep(8000);
		}
	}
	public void createSession(String service,String rooms,String clinicianName) throws InterruptedException
	{
		List<WebElement> calendar = driver.findElements(By.xpath("//mwl-calendar-week-view-hour-segment[@class='ng-star-inserted']"));
		
		for(int i=0;i<calendar.size();i++)
		{
			//System.out.println(calendar.get(i).getText());
			//System.out.println(i);
			
				//System.out.println(calendar.get(i).getText());
				//System.out.println(i);
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div/mwl-calendar-week-view-hour-segment/div[@class='cal-hour-segment cal-hour-start ng-star-inserted bg-white']"));
		actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(4000);
		searchByName.sendKeys("Bright");
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("/html/body/ng2-dropdown-menu/div/div"));
		Thread.sleep(8000);
		
		action.moveToElement(we).click().build().perform();
		
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[6]/select")));
		select.selectByVisibleText(service);
		Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[8]/select")));
		select1.selectByIndex(1);
		Select select2 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[13]/select")));
		select2.selectByVisibleText(rooms);
		Select select3 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[14]/select")));
		select3.selectByVisibleText(clinicianName);
		System.out.println(warning.isDisplayed());
		if(!warning.isDisplayed())
		{
		create.click();
		}
		else
		{
			System.out.println("Already there is an appointment");
			close_createSession.click();
		}
		//break;
			}
		
		
	//	Thread.sleep(8000);
	}
	public void blockSession(String doctorsNameList) throws InterruptedException
	{
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='cal-hour-segment cal-hour-start ng-star-inserted bg-white']"));
		actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(3000);
		endTime.sendKeys("6:30");
		clinician.click();
		String[] doctorsarr = doctorsNameList.split(","); 
		
		for (String doctor : doctorsarr) {
			
			{
			String specxpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[8]/div/div/div[2]/form/div[5]/div/ng-multiselect-dropdown/div/div[2]/ul/li/input[@aria-label='" + doctor  + "']";		
			WebElement Spec_dropdown = driver.findElement(By.xpath(specxpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);
			}
		}
	
		clinician.click();
		Thread.sleep(3000);
		reasonForBlocking.sendKeys("Block");
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[8]/div/div/div[3]/button[1]")));
		//blockSession.click();
	}
	public void createGroupClass(String GTitle,String GDesc,String GendTime,String paytype,String GAmount,String GSpots,String GHost,String GdoctorsNameList,String Glocation) throws InterruptedException
	{
		Thread.sleep(5000 );
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='cal-hour-segment cal-after-hour-start ng-star-inserted bg-white']"));
		actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(3000);
		groupClassTitle.sendKeys(GTitle);
		groupClassDescription.sendKeys(GDesc);
		groupClassEndTime.sendKeys(GendTime);
		if(paytype.contains("Pre Paid"))
		{
			  executor.executeScript("arguments[0].click();", groupClassPayment_PrePaid);
			//groupClassPayment_PrePaid.click();
		}
		else
		{
			 executor.executeScript("arguments[0].click();", groupClassPayment_PostPayment);
			//groupClassPayment_PostPayment.click();
		}
		groupClassAmount.sendKeys(GAmount);
		groupClassNoOfSpots.sendKeys(GSpots);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[9]/div[1]/select")));
		select.selectByVisibleText(GHost);
		GClinician.click();
		String[] doctorsarr = GdoctorsNameList.split(","); 
		
		for (String doctor : doctorsarr) {
			
			{
			String specxpath = "/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[11]/div/div/div[2]/form/div/div/div[10]/div/ng-multiselect-dropdown/div/div[2]/ul/li/input[@aria-label='" + doctor  + "']";		
			WebElement Spec_dropdown = driver.findElement(By.xpath(specxpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);
			}
		}
		GClinician.click();
		
		if(Glocation.contains("Virtual Meeting"))
		{
			 executor.executeScript("arguments[0].click();", Glocation_virtual);
			//Glocation_virtual.click();
		}
		else
		{
			 executor.executeScript("arguments[0].click();", Glocation_inclinic);
			//Glocation_inclinic.click();
		}
		Thread.sleep(5000);
		createGroupClass.click();
		Thread.sleep(5000);
	}
	public void createNewUser(String fname,String email,String phone,String dob,String gender) throws InterruptedException
	{
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='cal-hour-segment cal-hour-start ng-star-inserted bg-white']"));
		actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		createNewUser.click();
		userFullName.sendKeys(fname);
		userEmail.sendKeys(email);
		userPhone.sendKeys(phone);
		userDOB.sendKeys(dob);
		if(gender.contains("Male"))
		{
			 executor.executeScript("arguments[0].click();", userMale);
			//userMale.click();
		}
		else if(gender.contains("Female"))
		{
			 executor.executeScript("arguments[0].click();", userFemale);
		}
		else
		{
			 executor.executeScript("arguments[0].click();", userOther);
			
		}
		userAgree.click();
		registerUser.click();
	}
	public void rightClickViewAppointments(String newService,String date,String nstartTime,String nendTime) throws InterruptedException
	{
		List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[1]"));
		for(int i=0;i<calendar.size();i++)
		{
		//	
		Thread.sleep(5000);
		//System.out.println("#"+appointmentList.get(j).getText());
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='cal-event cal-starts-within-day cal-ends-within-day']"));
		actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(3000);
		toReschedule(newService, date, nstartTime, nendTime);
		//back.click();
		Thread.sleep(3000);
		}
	}
	public void toCreateConsultation() throws InterruptedException
	{
		List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[1]"));
		for(int i=0;i<calendar.size();i++)
		{
		//	
		Thread.sleep(5000);
		//System.out.println("#"+appointmentList.get(j).getText());
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='cal-event cal-starts-within-day cal-ends-within-day']"));
		actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(3000);
		//back.click();
		}
	}
	public void toEditAppointments(String newService,String newroom,String date,String nstartTime,String nendTime) throws InterruptedException
	{
		List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[1]"));
		for(int i=0;i<calendar.size();i++)
		{
		//	
		Thread.sleep(5000);
		//System.out.println("#"+appointmentList.get(j).getText());
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='cal-event cal-starts-within-day cal-ends-within-day']"));
		actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[2]/div/form/div[4]/select")));
		select.selectByVisibleText(newService);
		Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[2]/div/form/div[6]/select")));
		select1.selectByIndex(1);
		Select select2 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[2]/div/form/div[8]/div/div[1]/select")));
		select2.selectByVisibleText(newroom);
		newAppointmentDate.sendKeys(date);
		newStartTime.sendKeys(nstartTime);
		newEndTime.sendKeys(nendTime);
		Select select3 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[3]/div/div/div[2]/div/form/div[11]/select")));
		select3.selectByIndex(1);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
	     executor.executeScript("arguments[0].click();",newIsPaidYes);
	     newUpdate.click();
	     Thread.sleep(5000);
	}
	}
	public void toReschedule(String newService,String date,String nstartTime,String nendTime) throws InterruptedException
	{
		viewReschedule.click();
		Thread.sleep(5000);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[4]/select")));
		select.selectByVisibleText(newService);
		Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-view-appointments/div[4]/div/div/div[2]/div/form/div[6]/select")));
		select1.selectByIndex(1);
		Thread.sleep(3000);
		//rescheduleAppointmentDate.clear();
		
		//rescheduleAppointmentDate.sendKeys(date);
		//Thread.sleep(3000);
		//rescheduleStartTime.clear();
	//	rescheduleStartTime.sendKeys(nstartTime);
	//	Thread.sleep(3000);
		//rescheduleEndTime.clear();
	//	rescheduleEndTime.sendKeys(nendTime);
		//Thread.sleep(3000);
		
	     reschedule.click();
	    
	}
	public void toCancelAppointment() throws InterruptedException
	{
		List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[1]"));
		for(int i=0;i<calendar.size();i++)
		{
		//	
		Thread.sleep(5000);
		//System.out.println("#"+appointmentList.get(j).getText());
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='cal-event cal-starts-within-day cal-ends-within-day']"));
		actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(3000);
		reasonForCancellation.sendKeys("Reason");
		cancelSession.click();
		Thread.sleep(8000);
		}
		
	}
	public void toUpdateDragandDrop() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement From=driver.findElement(By.xpath("//div[@class='cal-event cal-starts-within-day cal-ends-within-day']"));	
        
        //Element on which need to drop.		
        WebElement To=driver.findElement(By.xpath("//div[5]/mwl-calendar-week-view-hour-segment/div[@class='cal-hour-segment cal-hour-start ng-star-inserted bg-white']"));					
        		
        //Using Action class for drag and drop.		
        Actions act=new Actions(driver);					

	//Dragged and dropped.		
        act.dragAndDrop(From, To).build().perform();
		Thread.sleep(3000);
		WebElement update=driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[4]/div/div/div[3]/button[1]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("arguments[0].click();", update);
	//	update.click();
		Thread.sleep(6000);
	}
	
	public void toCreateConsultationForGroupClass(String title) throws InterruptedException
	{
		List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[1]"));
		for(int i=0;i<calendar.size();i++)
		{
		//	
		Thread.sleep(5000);
		//System.out.println("#"+appointmentList.get(j).getText());
		List<WebElement> GroupClass = driver.findElements(By.xpath("//div[@style='background-color: rgb(240, 0, 239); border-color: rgb(30, 144, 255);']"));
		{System.out.println("##"+GroupClass.get(0).getText());
		System.out.println(GroupClass.size());
			for(int j=0;j<GroupClass.size();j++)
			{
				System.out.println("&"+GroupClass.get(j).getText());
				
				if(GroupClass.get(j).getText().contains(title))
				{System.out.println(title);
				Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"clinicsList._id\"]/div[2]/div/mwl-day-view-scheduler/div/div[2]/div[2]/div[4]/div["+(j+1)+"]/mwl-calendar-week-view-event/a/div"));
				actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
				Thread.sleep(6000);
				List<WebElement> GroupClassConsultaionDetails = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[1]/div[1]"));
				if(GroupClassConsultaionDetails.get(0).getText().contains("Create Consultation"))
				{
					createConsultationForGroupClass.click();
					Thread.sleep(3000);
					backGroupClass.click();
					Thread.sleep(3000);
				}
				else
				{
					clicktoViewConsultationDetailsforGroupClass.click();
					Thread.sleep(4000);
					toStartGroupClassMeeting();
				//	backForViewConsultaionDetailsForGroupClass.click();
					//appointments.click();
					Thread.sleep(3000);
				}
			//	backGroupClass.click();
				Thread.sleep(5000);
				break;
			}
			}
		}
		
	}
	}
	public void toStartGroupClassMeeting() throws InterruptedException
	{
		Thread.sleep(3000);
		List<WebElement> GroupClass = driver.findElements(By.xpath("//*[@id=\"consultation-details\"]/div"));
		
		//System.out.println(GroupClass.get(0).getText());
		if(GroupClass.get(0).getText().contains(("End")))
		{
			EndConsultationForGroupClass.click();
			Thread.sleep(3000);
			endMeetingForGroupClass.click();
			Thread.sleep(5000);
		}
		else if(GroupClass.get(0).getText().contains(("Start")))
					{
				Thread.sleep(3000);
				startMeetingForGroupClass.click();
				Thread.sleep(25000);
					}
			else
			{
				System.out.println(GroupClass.get(0).getText());
			}
	}
	public void toEditGroupClass(String title) throws InterruptedException
	{

		List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[1]"));
		for(int i=0;i<calendar.size();i++)
		{
		//	
		Thread.sleep(5000);
		//System.out.println("#"+appointmentList.get(j).getText());
		List<WebElement> GroupClass = driver.findElements(By.xpath("//div[@style='background-color: rgb(240, 0, 239); border-color: rgb(30, 144, 255);']"));
		
			for(int j=0;j<GroupClass.size();j++)
			{
				if(GroupClass.get(j).getText().contains(title))
				{
				Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"clinicsList._id\"]/div[2]/div/mwl-day-view-scheduler/div/div[2]/div[2]/div[4]/div["+(j+1)+"]/mwl-calendar-week-view-event/a/div"));
				actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
				Thread.sleep(3000);
				}
			}
		}
	}
	public void toInvieUsersForGroupClass(String title,String EmailId) throws InterruptedException
	{
		List<WebElement> calendar = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-appointments-groupclass/div[2]/div/div[1]/div[2]/div/mwl-day-view-scheduler/div/div[1]"));
		for(int i=0;i<calendar.size();i++)
		{
		//	
		Thread.sleep(5000);
		//System.out.println("#"+appointmentList.get(j).getText());
		List<WebElement> GroupClass = driver.findElements(By.xpath("//div[@style='background-color: rgb(240, 0, 239); border-color: rgb(30, 144, 255);']"));
		
			for(int j=0;j<GroupClass.size();j++)
			{
				if(GroupClass.get(j).getText().contains(title))
				{
				Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"clinicsList._id\"]/div[2]/div/mwl-day-view-scheduler/div/div[2]/div[2]/div[4]/div["+(j+1)+"]/mwl-calendar-week-view-event/a/div"));
				actions.contextClick(elementLocator).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
				Thread.sleep(6000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
			    jse.executeScript("arguments[0].click();", inviteUsers);
				jse.executeScript("arguments[0].value='sheelak@deemsys.in';",inviteUsers);
				//Thread.sleep(5000);
				String text = (String) jse.executeScript("return arguments[0].value", inviteUsers);  
				System.out.println(text);  
				Thread.sleep(5000);
				jse.executeScript("arguments[0].click();", inviteBtn);
				//Thread.sleep(5000);
			//	inviteBtn.click();
				Thread.sleep(5000);
				}
			}
		}
	}
	
}
