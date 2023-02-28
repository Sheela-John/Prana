package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class User_Appointments extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")
	WebElement Appointments;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div/div[2]/select")
	WebElement StatusSelect;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-view-appointments/div[1]/div[1]/a")
	WebElement back;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div[1]/div[4]/div/div/button")
	WebElement cancel;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-view-appointments/div[2]/div/div/div[3]/button[1]")
	WebElement cancelConfirm;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div[1]/div[4]/div/div[1]/a")
	WebElement clickConsulatation;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div[1]/div[1]/div[2]/div/div/span")
	WebElement appointmentDateTime;
	@FindBy(xpath="//*[@id=\"consultation-details\"]/div/div[1]/div[1]/div[2]/div/div/span")
	WebElement consultationDateTime;
	@FindBy(xpath="//*[@id=\"headingTwo\"]/h5/button")
	WebElement paymentBillingDetails;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div/div[3]/div[5]/div/button")
	WebElement payNow;
	@FindBy(xpath="//*[@id=\"customRadio0\"]")
	WebElement visa;
	@FindBy(xpath="//*[@id=\"existingUSer\"]/div[1]/div/div/div[2]/div[1]/div/input")
	WebElement Cvv;
	@FindBy(xpath="//*[@id=\"existingUSer\"]/div[2]/button")
	WebElement visaPayNow;
	@FindBy(xpath="//*[@id=\"nav-tab\"]/a[1]")
	WebElement newCard;
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement nameNewCard;
	@FindBy(xpath="//*[@id=\"ccnumber\"]")
	WebElement creditCardNumber;
	@FindBy(xpath="//*[@id=\"ccmonth\"]")
	WebElement creditCardMonth;
	@FindBy(xpath="//*[@id=\"ccyear\"]")
	WebElement creditCardYear;
	@FindBy(xpath="//*[@id=\"cvc\"]")
	WebElement creditCVV;
	@FindBy(xpath="//*[@id=\"inputPhysicalStreet\"]")
	WebElement creditCardAddress;
	@FindBy(xpath="//*[@id=\"exampleCheck1\"]")
	WebElement saveForFuture;
	@FindBy(xpath="//*[@id=\"newUSer\"]/div/div/form/button")
	WebElement newCardPayNow;
	
	@FindBy(xpath="//*[@id=\"headingTwo\"]/h2/button")
	WebElement GroupClass;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div[1]/div[9]/button")
	WebElement JoinGroupClass;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-view-group-session/div[4]/div/div/div[3]/button[1]")
	WebElement acceptGroupClass;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div[1]/div[9]/button")
	WebElement payAndJoin;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div/div[1]/div[1]/div[9]/a")
	WebElement clickHereToJoinGroupClass;
	public User_Appointments() {
		PageFactory.initElements(driver, this);
	}
	
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[3]/a")));
		Appointments.click();	
	}
	public void toViewAllAppointments(String status,String cardStatus,String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
	{
	
		Thread.sleep(4000);
	List<WebElement> AppointmentList = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div"));
		
		for(int i=0;i< AppointmentList.size();i++)
		{
			try
			{ 
			
				Thread.sleep(6000);
				if( AppointmentList.get(i).getText().contains(status)) {
				System.out.println("try%%"+ AppointmentList.get(i).getText());
				 AppointmentList.get(i).click();
				 Thread.sleep(5000);
				 toviewPaymentBillingDetails(cardStatus, name, cardNumber, month, year, cvv, address);
				//back.click();
				break;
			}
			}
			//}
			catch(StaleElementReferenceException s)
			{
				
				List<WebElement>  AppointmentList1 = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div"));
			
				Thread.sleep(6000);
				Thread.sleep(6000);
				if( AppointmentList1.get(i).getText().contains(status)) {
				System.out.println("catch%%"+ AppointmentList.get(i).getText());
				 AppointmentList1.get(i).click();
				 Thread.sleep(5000);
				 toviewPaymentBillingDetails(cardStatus, name, cardNumber, month, year, cvv, address);
				 //back.click();
				break;
				
				}
			}
			
		}
	}
	
	public void toCancelAppoinments() throws InterruptedException
	{
		List<WebElement> AppointmentList = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div"));
		Thread.sleep(5000);
	
		for(int i=0;i< AppointmentList.size();i++)
		{
			
			try {
		System.out.println((AppointmentList.get(i).getText().contains("Payment Required")));
			if((AppointmentList.get(i).getText().contains("Payment Required"))) {
				
			
				AppointmentList.get(i).click();
				
				Thread.sleep(5000);
				cancel.click();
				Thread.sleep(3000);
				cancelConfirm.click();
				Thread.sleep(5000);
				List<WebElement> CancelledAppointmentList = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[1]/div[1]"));
				if(CancelledAppointmentList.get(0).getText().contains("Cancelled")) {
					System.out.println("Cancellation Success");
				}
				Thread.sleep(5000);
				break;
			}
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> AppointmentList1 = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div"));
				if((AppointmentList1.get(i).getText().contains("Payment Required"))) {
					AppointmentList1.get(i).click();
				
					Thread.sleep(5000);
					cancel.click();
					Thread.sleep(3000);
					cancelConfirm.click();
					Thread.sleep(5000);
					List<WebElement> CancelledAppointmentList = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[1]/div[1]"));
					if(CancelledAppointmentList.get(0).getText().contains("Cancelled")) {
						System.out.println("Cancellation Success");
					}
					Thread.sleep(5000);
					break;
				}
			}
		}
	}
		public void toViewConsultationDetailsForAppointments(String status)throws InterruptedException
		{
			List<WebElement> AppointmentList = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div"));
			Thread.sleep(5000);
			String appDate;
			String consultDate;
			User_Consultations consult=new User_Consultations();
			for(int i=0;i< AppointmentList.size();i++)
			{
				
				try {
			
				if((AppointmentList.get(i).getText().contains(status)) ) {
					AppointmentList.get(i).click();
					Thread.sleep(5000);
					appDate=appointmentDateTime.getText();
					System.out.println("app"+appDate);
					clickConsulatation.click();
					consult.toViewConsultationDetails();
					Thread.sleep(3000);
					consultDate=consultationDateTime.getText();
					System.out.println("consult"+consultDate);
					consult.toViewRecommenededVideo();
					consult.toViewPaymentDetails();
					Thread.sleep(5000);
					if(appDate.equalsIgnoreCase(consultDate))
					{
					Appointments.click();
					System.out.println("Success");
					}
					else
					{
						System.out.println("Error in Date");
						break;
					}
					
				}
				}
				catch(StaleElementReferenceException s)
				{
					List<WebElement> AppointmentList1 = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div"));
					
					if((AppointmentList1.get(i).getText().contains(status))) {
						AppointmentList1.get(i).click();
						Thread.sleep(5000);
						appDate=appointmentDateTime.getText();
						System.out.println("app"+appDate);
						clickConsulatation.click();
						consult.toViewConsultationDetails();
						Thread.sleep(3000);
						consultDate=consultationDateTime.getText();
						System.out.println("app"+appDate);
						consult.toViewRecommenededVideo();
						consult.toViewPaymentDetails();
						Thread.sleep(5000);	
						if(appDate.equalsIgnoreCase(consultDate))
						{
							Appointments.click();
							System.out.println("Success");
							}
							else
							{
								System.out.println("Error in Date");
								break;
							}
				}
			}
		}
		}
		public void toviewPaymentBillingDetails(String cardStatus,String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
		{
			try
			{
					 paymentBillingDetails.click();
					 Thread.sleep(5000);
					 List<WebElement> paymentList1 = driver.findElements(By.xpath("//*[@id=\"collapseTwo\"]/div/div[3]"));
					 System.out.println(paymentList1.get(0).getText());
							if(paymentList1.get(0).getText().contains("Paid"))
							{
								System.out.println("Already Paid");
							}
							else
							{
								payNow.click();
								if(cardStatus.contains("Save Card"))
								{ Thread.sleep(5000);
									 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", visa);
									Cvv.sendKeys("111");
									visaPayNow.click();
									 Thread.sleep(5000);
									 List<WebElement> paymentList = driver.findElements(By.xpath("//*[@id=\"collapseTwo\"]/div/div[3]"));
									 System.out.println(paymentList.get(0).getText());
											if(paymentList1.get(0).getText().contains("Paid"))
											{
												System.out.println(" Paid Success");
											}
									 
								}
								else
								{
									// ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newCard);
									
									addNewCard(name, cardNumber, month, year, cvv, address);
									 List<WebElement> paymentList = driver.findElements(By.xpath("//*[@id=\"collapseTwo\"]/div/div[3]"));
									 System.out.println(paymentList.get(0).getText());
											if(paymentList1.get(0).getText().contains("Paid"))
											{
												System.out.println(" Paid Success");
											}
								}
						
							}
					
			}
				
			
				
				catch(StaleElementReferenceException s)
				{
					 paymentBillingDetails.click();
					 Thread.sleep(5000);
					 List<WebElement> paymentList1 = driver.findElements(By.xpath("//*[@id=\"collapseTwo\"]/div/div[3]"));
					 System.out.println(paymentList1.get(0).getText());
							if(paymentList1.get(0).getText().contains("Paid"))
							{
								System.out.println("Already Paid");
							}
							else
							{
								System.out.println("To Pay");
								payNow.click();
								if(cardStatus.contains("Save Card"))
								{
									 Thread.sleep(5000);
									 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", visa);
									Cvv.sendKeys("111");
									visaPayNow.click();
									 Thread.sleep(5000);
									 List<WebElement> paymentList = driver.findElements(By.xpath("//*[@id=\"collapseTwo\"]/div/div[3]"));
									 System.out.println(paymentList.get(0).getText());
											if(paymentList1.get(0).getText().contains("Paid"))
											{
												System.out.println("Already Paid Success");
											}
									 
								}
								else
								{
									
									addNewCard(name, cardNumber, month, year, cvv, address);
									 List<WebElement> paymentList = driver.findElements(By.xpath("//*[@id=\"collapseTwo\"]/div/div[3]"));
											if(paymentList1.get(0).getText().contains("Paid"))
											{
												System.out.println("Already Paid Success");
											}
								}
							}
							
							
						
					
					}
		}
		public void addNewCard(String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", newCard);
			System.out.println("Inside of newCard");
			Thread.sleep(5000);
			nameNewCard.sendKeys(name);
			creditCardNumber.sendKeys(cardNumber);
			Select select = new Select(creditCardMonth);
			select.selectByVisibleText(month);
			Select select1 = new Select(creditCardYear);
			select1.selectByVisibleText(year);
			creditCVV.sendKeys(cvv);
			creditCardAddress.sendKeys(address);
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"newUSer\"]/div/div/form/div[5]/div/div[2]"));
			Thread.sleep(4000);
			action.moveToElement(we).click().build().perform();
			creditCardAddress.click();
			 Thread.sleep(5000);
			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveForFuture);
			 saveForFuture.click();
			 Thread.sleep(3000);
			 newCardPayNow.click();
			 Thread.sleep(5000);
		}
public void toViewGroupClass(String Title,String cardStatus,String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
{
	GroupClass.click();
	
	List<WebElement> GroupClassList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-user-appointments/div/div[4]/div/div/div"));
	
	for(int i=0;i< GroupClassList.size();i++)
	{
try {
	if(GroupClassList.get(i).getText().contains(Title))
	{
		
		GroupClassList.get(i).click();
		
		List<WebElement> GroupClassListDetails = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[1]/div[1]"));
		if(GroupClassListDetails.get(0).getText().contains("Pay & Join Group Class"))
		{
			
			payAndJoin.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", visa);
			Cvv.sendKeys("111");
			visaPayNow.click();
		}
		else if(GroupClassListDetails.get(0).getText().contains("Join Group Class"))
		{
		JoinGroupClass.click();
		Thread.sleep(3000);
		acceptGroupClass.click();
		Thread.sleep(5000);
		toviewPaymentBillingDetails(cardStatus, name, cardNumber, month, year, cvv, address);
		Thread.sleep(5000);
		}
		else
		{
		Thread.sleep(3000);
		toviewPaymentBillingDetails(cardStatus, name, cardNumber, month, year, cvv, address);
		Thread.sleep(3000);
		}
	}
}
catch(StaleElementReferenceException s)
{
	List<WebElement> GroupClassList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-user-appointments/div/div[4]/div/div/div"));
	if(GroupClassList1.get(i).getText().contains(Title))
	{
		
		GroupClassList1.get(i).click();
		
		List<WebElement> GroupClassListDetails = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[1]/div[1]"));
		if(GroupClassListDetails.get(0).getText().contains("Pay & Join Group Class"))
		{
			
			payAndJoin.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", visa);
			Cvv.sendKeys("111");
			visaPayNow.click();
		}
		else if(GroupClassListDetails.get(0).getText().contains("Join Group Class"))
		{
		JoinGroupClass.click();
		Thread.sleep(3000);
		acceptGroupClass.click();
		Thread.sleep(5000);
		toviewPaymentBillingDetails(cardStatus, name, cardNumber, month, year, cvv, address);
		Thread.sleep(5000);
		}
		else
		{
		Thread.sleep(3000);
		toviewPaymentBillingDetails(cardStatus, name, cardNumber, month, year, cvv, address);
		Thread.sleep(3000);
		}
}
	}
	}
}

public void toChecktheGroupWebinar(String title) throws InterruptedException
{
	GroupClass.click();
	List<WebElement> GroupClassList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-user-appointments/div/div[4]/div/div/div"));
	
	for(int i=0;i< GroupClassList.size();i++)
	{
		try {
	if(GroupClassList.get(i).getText().contains(title))
	{
		
		GroupClassList.get(i).click();
		
		List<WebElement> GroupClassListDetails = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[1]/div[1]"));
		if(GroupClassListDetails.get(0).getText().contains("Virtual Meeting") && GroupClassListDetails.get(0).getText().contains("Remaining"))		
		{
			clickHereToJoinGroupClass.click();
			Thread.sleep(3000);
			break;
		}
		break;
	}
		}
		catch(StaleElementReferenceException s)
		{
			List<WebElement> GroupClassList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-user-appointments/div/div[4]/div/div/div"));
			if(GroupClassList1.get(i).getText().contains(title))
			{
				GroupClassList1.get(i).click();
				List<WebElement> GroupClassListDetails = driver.findElements(By.xpath("//*[@id=\"collapseOne\"]/div/div[1]/div[1]"));
				if(GroupClassListDetails.get(0).getText().contains("Virtual Meeting") && GroupClassListDetails.get(0).getText().contains("Remaining"))		
				{
					clickHereToJoinGroupClass.click();
					Thread.sleep(3000);
					break;
				}
				break;
			}
		}
	}
		
}


}

	

