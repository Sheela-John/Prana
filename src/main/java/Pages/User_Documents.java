package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class User_Documents extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")
	WebElement documents;
	@FindBy(xpath="//*[@id=\"icon\"]")
	WebElement addDocuments;
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement fileName;
	@FindBy(xpath="//*[@id=\"customFile\"]")
	WebElement filePath;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-medical-records/div[4]/div/div/div[3]/button[1]")
	WebElement upload;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-medical-records/div[2]/div/div/div")
	WebElement NoDocMsg;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-user-medical-records/div[2]/div/div/div/button")
	WebElement uploadNow;
	public User_Documents() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[6]/a")));
		documents.click();	
	}
	public void toViewAllDocuments(String fileName)
	{
	List<WebElement> documentList = driver.findElements(By.xpath("//*[@id=\"container\"]/div/app-user-medical-records/div[2]/div"));
		
		for(int i=0;i<documentList.size();i++)
		{
			if(documentList.get(i).getText().contains(fileName)) {
				System.out.println("File Available");
			}
		}
	}
	public void toAddDocument(String fname,String path) throws InterruptedException
	{
		if(NoDocMsg.getText().contains("No Medical Records Uploaded!"))
		{
			uploadNow.click();
		}
		else
		{
		addDocuments.click();
		}
		Thread.sleep(2000);
		fileName.sendKeys(fname);
		Thread.sleep(2000);
		filePath.sendKeys(path);
		Thread.sleep(2000);
		upload.click();
		Thread.sleep(5000);
	}

	
}
