package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class User_BookAppointment extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement bookAppointment;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[3]/div[4]/div/div/div[1]/span")
	WebElement DateandMonth;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[3]/div[4]/div/div/div[1]/a[2]")
	WebElement next;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[3]/div[4]/div/div/div[2]/div[1]")
	WebElement timeLimit;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-book-appointment/div[3]/div/div/div[3]/button[1]")
	WebElement BookNow;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-book-appointment/app-flash-message")
	WebElement ErrorMessage;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div/div/div[2]/div/div/form/div/div[2]/div[3]/button[1]")
	WebElement BookAppointmentBtn;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[2]/div[5]/div[1]/button")
	WebElement payInClinic;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[2]/div[5]/div[2]/button")
	WebElement AddNewCardPay;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[3]/div[4]/div[2]/button")
	WebElement confirmBooking;
	@FindBy(xpath="//*[@id=\"customRadio0\"]")
	WebElement visa1;
	@FindBy(xpath="//*[@id=\"customRadio1\"]")
	WebElement visa2;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/div/input")
	WebElement CVV;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[3]/div[2]/button")
	WebElement payAndBook;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[3]/div[2]")
	WebElement paymentError;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[3]/div/div/button")
	WebElement myAppointments;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[2]/div[5]/div[2]/button")
	WebElement payNow;
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement cardName;
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
	
	public User_BookAppointment() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")));
		bookAppointment.click();	
	}
	public void toBookAppointment(String clinicname,String service,String servicetime,String clinicianName,String time,String date,String status,String paymentMethod,String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
	{
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
			Thread.sleep(3000);
		List<WebElement> clinicList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[2]/div"));
	
		for(int i=0;i<clinicList.size();i++)
		{
			try {
			if(clinicList.get(i).getText().contains(clinicname))
				
					{
					clinicList.get(i).click();
					Thread.sleep(3000);
					List<WebElement> ServiceList = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-12 ng-star-inserted']"));
					for(int j=0;j<ServiceList.size();j++)
					{
					if(ServiceList.get(j).getText().contains(service))
					{
						
						ServiceList.get(j).click();
						Thread.sleep(3000);
						List<WebElement> ServiceTimeList = driver.findElements(By.xpath("//div[@class='pl-2']"));
						for(int k=0;k<ServiceTimeList.size();k++)
						if(ServiceTimeList.get(k).getText().contains(servicetime))
						{
							
							ServiceTimeList.get(k).click();
							Thread.sleep(3000);
							List<WebElement> ServiceTimeList1 = driver.findElements(By.xpath("//div[@class='pl-2']"));
							for(int l=0;l<ServiceTimeList1.size();l++)
							{
							System.out.println(ServiceTimeList1.get(l).getText());
							if(ServiceTimeList1.get(l).getText().contains(clinicianName))
							{
								
								ServiceTimeList1.get(l).click();
								Thread.sleep(3000);
								toSelectDateAndTime(time,date,status,paymentMethod,name,cardNumber,month,year,cvv,address);
								break;
							}
							}
							break;
						}
					}
					}
					}
					break;
			}
			catch(StaleElementReferenceException s)
			{
				List<WebElement> clinicList1 = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-book-appointment/div[2]/div[2]/div[1]/div"));
				if(clinicList1.get(i).getText().contains(clinicname))
						{
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", clinicList1.get(i));
					//	clinicList1.get(i).click();
						Thread.sleep(3000);
						List<WebElement> ServiceList = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-12 ng-star-inserted']"));
						for(int j=0;j<ServiceList.size();j++)
						{
						if(ServiceList.get(j).getText().contains(service))
						{
							
							ServiceList.get(j).click();
							Thread.sleep(3000);
							List<WebElement> ServiceTimeList = driver.findElements(By.xpath("//div[@class='pl-2']"));
							for(int k=0;k<ServiceTimeList.size();k++)
							if(ServiceTimeList.get(k).getText().contains(servicetime))
							{
								
								ServiceTimeList.get(k).click();
								Thread.sleep(3000);
								List<WebElement> ServiceTimeList1 = driver.findElements(By.xpath("//div[@class='pl-2']"));
								for(int l=0;l<ServiceTimeList1.size();l++)
								{
								System.out.println(ServiceTimeList1.get(l).getText());
								if(ServiceTimeList.get(l).getText().contains(clinicianName))
								{
									
									ServiceTimeList.get(l).click();
									Thread.sleep(3000);
									toSelectDateAndTime(time,date,status,paymentMethod,name,cardNumber,month,year,cvv,address);
									break;
								}
								}
								break;
							}
							break;
						}
						}
						break;
						}
						
			}
		}
	}
	public void toSelectDateAndTime(String time,String date,String status,String paymentMethod,String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
	{
		for(int k=0;k<30;k++)
		{
		if(DateandMonth.getText().contains(date))
		{	
			Thread.sleep(5000);
			tochooseTime(time,status, paymentMethod, name, cardNumber, month, year, cvv, address);
		
			break;
		}
		next.click();
			
		}
			
			
	}
	public void tochooseTime(String time,String status,String paymentMethod,String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
	{
		
		for(int k=0;k<30;k++)
		{
		if((timeLimit.getText().contains("Clinician not available")))
		{
			next.click();
			Thread.sleep(5000);
		}
		else
		{
			break;
		}
		}
		Thread.sleep(5000);
		List<WebElement> TimeList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-book-appointment/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/div/div"));
		for(int i=0;i<TimeList.size();i++)
		{
		
		if(TimeList.get(i).getText().contains(time))
		{
//			String elementClass=TimeList.get(i).getAttribute("class");
//			if(elementClass.contains("col-md-4 col-lg-3 col-sm-4 sessionSlots pointer ng-star-inserted"))
//			{
			TimeList.get(i).click();
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", BookNow);
			
			Thread.sleep(6000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", BookAppointmentBtn);
		//	BookAppointmentBtn.click();
			System.out.println("Book");
			Thread.sleep(6000);
			toselectPaymentMethod(status,paymentMethod,name,cardNumber,month,year,cvv,address);
			//}
			break;
			//}
		}
		}
//		else
//		{
//			Thread.sleep(4000);
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", next);
//			Thread.sleep(5000);
//			tochooseTime(time,status,paymentMethod, name, cardNumber, month, year, cvv, address);
//		//	next.click();
//			Thread.sleep(5000);
//			
//		}
		//}
	}
	public void toselectPaymentMethod(String status,String paymentMethod,String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
	{
		if(paymentMethod.contains("Pay In Clinic"))
		{
			payInClinic.click();
			confirmBooking.click();
			Thread.sleep(4000);
			tocheckAppoinmentInMyAppointments(status, paymentMethod, name, cardNumber, month, year, cvv, address);
			
		}
		else if(paymentMethod.contains("Pay Now"))
		{
			if(paymentError.getText().contains("No cards added, Add a new card by clicking the Add Card button"))
			{
				payNow.click();
				Thread.sleep(3000);
				cardName.sendKeys(name);
				creditCardNumber.sendKeys(cardNumber);
				Select select = new Select(creditCardMonth);
				select.selectByVisibleText(month);
				Select select1 = new Select(creditCardYear);
				select1.selectByVisibleText(year);
				creditCVV.sendKeys(cvv);
				creditCardAddress.sendKeys(address);
				Actions action = new Actions(driver);
				WebElement we = driver.findElement(By.xpath("//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[3]/div[2]/div/form/div[5]/div/div[2]"));
				Thread.sleep(4000);
				action.moveToElement(we).click().build().perform();
				creditCardAddress.click();
				 Thread.sleep(5000);
				// ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveForFuture);
				 payAndBook.click();
				 Thread.sleep(5000);
			}
			else
			{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", visa1);
		CVV.sendKeys("111");
		payAndBook.click();
		Thread.sleep(5000);
		tocheckAppoinmentInMyAppointments(status, paymentMethod, name, cardNumber, month, year, cvv, address);
			List<WebElement> cardList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-user-payment/div[2]/div[2]/div[3]/div[2]/div"));
//			for(int i=0;i<cardList.size();i++)
//			{
//				System.out.println(cardList.get(i).getText());
//				if(cardList)
//			}
			}
		}
		else
		{
			AddNewCardPay.click();
			User_Appointments app=new User_Appointments();
			app.addNewCard(name,cardNumber,month,year,cvv,address);
			Thread.sleep(5000);
			tocheckAppoinmentInMyAppointments(status, paymentMethod, name, cardNumber, month, year, cvv, address);
			Thread.sleep(3000);
		}
	}
	public void tocheckAppoinmentInMyAppointments(String status,String cardStatus,String name,String cardNumber,String month,String year,String cvv,String address) throws InterruptedException
	{
		myAppointments.click();
		User_Appointments app=new User_Appointments();
		app.toViewAllAppointments("Booked", "New Card", "Deemsys", "4111111111111111 ", "3", "2025", "111","13 Manu Tapu Drive");
	}
	
}

