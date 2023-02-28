package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class User_Profile  extends TestBase {
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")
	WebElement profile;
	 @FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[1]/div[1]/div[1]/input")
	WebElement name;
	 @FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[2]/div[1]/div[1]/input")
	WebElement DOB;
	@FindBy(xpath="//*[@id=\"GenderRadio1\"]")
	WebElement gender_male;
	@FindBy(xpath="//*[@id=\"GenderRadio2\"]")
	WebElement gender_female;
	@FindBy(xpath="//*[@id=\"GenderRadio3\"]")
	WebElement gender_other;
 @FindBy(id="inputPhysicalStreet")
	WebElement address;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[3]/div[1]/div[1]/input")
	WebElement email;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[3]/div[2]/div[1]/input")
	WebElement secEmail;
	 @FindBy(xpath="//*[@id=\"phone\"]")
	WebElement phone;
	 @FindBy(xpath="//*[@id=\"pills-home\"]/div/div/input")
	WebElement height;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[4]/div[2]/div/div[2]/div/div/input")
	WebElement weight;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[5]/div/div[1]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement surgeries;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[5]/div/div[2]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement chronicDisease;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[5]/div/div[3]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement healthConditions;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[5]/div/div[4]/div/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement allergies;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[6]/div/div[1]/div[1]/div[1]/tag-input/div/div/tag-input-form/form/input")
	WebElement diet;
	@FindBy(xpath="//*[@id=\"SmokeRadio1\"]")
	WebElement smokeYes;
	@FindBy(xpath="//*[@id=\"SmokeRadio2\"]")
	WebElement smokeNo;
	@FindBy(xpath="//*[@id=\"AlcoholRadio1\"]")
	WebElement alcoholYes;
	@FindBy(xpath="//*[@id=\"AlcoholRadio2\"]")
	WebElement alcoholNo;
	@FindBy(xpath="//*[@id=\"head\"]/form/div/div/div[7]/div/button")
	WebElement saveChanges;
	public User_Profile() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")));
		profile.click();	
	}
	public void toEditProfile(String fname,String dob,String gender,String newaddress,String emailId,String secEmailId,String phoneNum,String height1,String weight1,String surgery,String chronic,String health,String allergy,String diet1,String smoke,String alcohol) throws InterruptedException
	{ JavascriptExecutor executor = (JavascriptExecutor) driver;
		name.clear();
		name.sendKeys(fname);
		DOB.clear();
		DOB.sendKeys(dob);
		if(gender.contains("Male"))
		{
			
		     executor.executeScript("arguments[0].click();",gender_male);
		}
		else if(gender.contains("Female"))
		{
			 executor.executeScript("arguments[0].click();",gender_female);
		}
		else
		{
			 executor.executeScript("arguments[0].click();",gender_other);
		}
	
		address.clear();
		address.sendKeys(newaddress);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"head\"]/form/div/div/div[2]/div[2]/div[2]"));
		Thread.sleep(3000);
		action.moveToElement(we).click().build().perform();
		Thread.sleep(4000);
		email.clear();
		email.sendKeys(emailId);
		secEmail.clear();
		secEmail.sendKeys(secEmailId);
		phone.clear();
		phone.sendKeys(phoneNum);
		height.sendKeys(height1);
		weight.sendKeys(weight1);
		surgeries.sendKeys(surgery);
		chronicDisease.sendKeys(chronic);
		healthConditions.sendKeys(health);
		allergies.sendKeys(allergy);
		diet.sendKeys(diet1);
		if(smoke.contains("yes"))
		{
			executor.executeScript("arguments[0].click();",smokeYes);
		}
		else
		{
			executor.executeScript("arguments[0].click();",smokeNo);
		}
		if(alcohol.contains("Yes"))
		{
			executor.executeScript("arguments[0].click();",alcoholYes);
		}
		else
		{
			executor.executeScript("arguments[0].click();",alcoholNo);
		}
		saveChanges.click();
		Thread.sleep(8000);
	}
	public void checkingAllDetails(String fname,String dob,String gender,String newaddress,String emailId,String secEmailId,String phoneNum,String height1,String weight1,String surgery,String chronic,String health,String allergy,String diet1,String smoke,String alcohol) throws InterruptedException
	{
		
		if(name.getAttribute("value").equals(fname))
		{
			if(DOB.getAttribute("value").contains(dob))
			{
				if(email.getAttribute("value").contains(emailId))
					
				{
					if(secEmail.getAttribute("value").contains(secEmailId))
					{
					if(phone.getAttribute("value").contains(phoneNum))
					{
						if(height.getAttribute("value").contains(height1))
						{
							if(weight.getAttribute("value").contains(weight1))
							{
								if(surgeries.getAttribute("value").contains(surgery))
								{
									if(chronicDisease.getAttribute("value").contains(chronic))
									{
										if(healthConditions.getAttribute("value").contains(health))
										{
											if(allergies.getAttribute("value").contains(allergy))
											{
												if(diet.getAttribute("value").contains(diet1))
												{
													System.out.println("success");
												}
												else
												{
													System.out.println("Error in Diet");
												}
											}
											else
											{
												System.out.println("Error in Allergies");
											}
										}
										else
										{
											System.out.println("Error in Health Condition");
										}
									}
									else
									{
										System.out.println("error in chronic");
									}
								}
								else
								{
									System.out.println("Error in surgery");
								}
								
							}
						}
					}
			//	System.out.println("success");
				}
			}
		
		}
	}
	}
}
