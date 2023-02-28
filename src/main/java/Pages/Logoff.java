package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Logoff  extends TestBase {
	@FindBy(xpath="/html/body/app-dashboard/app-header/ul/li/a")
	WebElement toLogoff;
	@FindBy(xpath="/html/body/app-dashboard/app-header/ul/li/div/a[2]")
	WebElement logout;

	public Logoff() {
		PageFactory.initElements(driver, this);
	}

	public  void logOff() throws InterruptedException {
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
	toLogoff.click();
	Thread.sleep(2000);
	 executor.executeScript("arguments[0].click();", logout);
	//logout.click();
	Thread.sleep(3000);
	}
}
