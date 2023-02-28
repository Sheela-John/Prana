package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import lombok.experimental.NonFinal;

public class User_ConsentForm  extends TestBase {
	
	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[7]/a")
	WebElement ConsentForm;
	@FindBy(xpath="//*[@id=\"inputTitle\"]")
	WebElement Title;
	@FindBy(xpath="//*[@id=\"inputFirstName\"]")
	WebElement firstName;
	@FindBy(xpath="//*[@id=\"inputLastName\"]")
	WebElement lastName;
	@FindBy(xpath="//*[@id=\"dob\"]")
	WebElement DOB;
	@FindBy(xpath="//*[@id=\"inputEmail\"]")
	WebElement emailId;
	@FindBy(xpath="//*[@id=\"inputKnownAs\"]")
	WebElement knownAs;
	@FindBy(xpath="//*[@id=\"inputReferrerName\"]")
	WebElement referrerName;
	@FindBy(xpath="//*[@id=\"phone\"]")
	WebElement homeNumber;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-consent-form/div[2]/div[1]/form/div[2]/div[6]/div[2]/ngx-intl-tel-input/div/input")
	WebElement mobileNumber;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-consent-form/div[2]/div[1]/form/div[2]/div[6]/div[3]/ngx-intl-tel-input/div/input")
	WebElement workPhone;
	
	@FindBy(xpath="//*[@id=\"headingTwo\"]/h2/button")
	WebElement medicalInformation;
	@FindBy(xpath="//*[@id=\"inputInjuryDescription\"]")
	WebElement descriptionForInjury;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div[2]/div/ng-multiselect-dropdown/div/div[1]/span/span[1]")
	WebElement conditions;
	@FindBy(xpath="//*[@id=\"inputRecentSurgery\"]")
	WebElement recentSurgery;
	@FindBy(xpath="//*[@id=\"allMedications\"]")
	WebElement allMedicationsList;
	@FindBy(xpath="//*[@id=\"inputAllergies\"]")
	WebElement allergies;
	@FindBy(xpath="//*[@id=\"inputOtherHealthIssues\"]")
	WebElement otherHealthIssues;
	@FindBy(xpath="//*[@id=\"inputClaimNumber\"]")
	WebElement claimNumber;
	@FindBy(xpath="//*[@id=\"date_of_Injury\"]")
	WebElement dateOfInjury;
	@FindBy(xpath="//*[@id=\"injuryMinutes\"]")
	WebElement timeOfInjuryMinute;
	@FindBy(xpath="//*[@id=\"option1\"]")
	WebElement timeOfInjuryAM;
	@FindBy(xpath="//*[@id=\"option2\"]")
	WebElement timeOfInjuryPM;
	@FindBy(xpath="//*[@id=\"customRadioInline1\"]")
	WebElement WorkRelatedInjuryYes;
	@FindBy(xpath="//*[@id=\"customRadioInline2\"]")
	WebElement WorkRelatedInjuryNo;
	@FindBy(xpath="//*[@id=\"customMotorAccident1\"]")
	WebElement motorAccidentYes;
	@FindBy(xpath="//*[@id=\"customMotorAccident2\"]")
	WebElement motorAccidentNo;
	@FindBy(xpath="//*[@id=\"headingThree\"]/h2/button")
	WebElement venueInformation;
	@FindBy(xpath="//*[@id=\"inputPhysicalStreet\"]")
	WebElement enterLocation;
	@FindBy(xpath="//*[@id=\"headingFour\"]/h2/button")
	WebElement professionalInformation;
	@FindBy(xpath="//*[@id=\"inputnhiNumber\"]")
	WebElement nhiNumber;
	@FindBy(xpath="//*[@id=\"inputClientOccupation\"]")
	WebElement clientOccupation;
	@FindBy(xpath="//*[@id=\"inputEmployerName\"]")
	WebElement employerName;
	@FindBy(xpath="//*[@id=\"inputEmployerEmail\"]")
	WebElement employerEmail;
	@FindBy(xpath="//*[@id=\"phone\"]")
	WebElement employerPhone;
	@FindBy(xpath="//*[@id=\"inputEmployerStreetName\"]")
	WebElement employerAddress;
	@FindBy(xpath="//*[@id=\"headingFive\"]/h2/button")
	WebElement GPInformation;
	@FindBy(xpath="//*[@id=\"inputGPFirstName\"]")
	WebElement GPfirstName;
	@FindBy(xpath="//*[@id=\"inputGPLastName\"]")
	WebElement GPlastName;
	@FindBy(xpath="//*[@id=\"inputGPEmail\"]")
	WebElement GPEmail;
	@FindBy(xpath="//*[@id=\"phone\"]")
	WebElement GPPhone;
	@FindBy(xpath="//*[@id=\"inputGPClinicName\"]")
	WebElement GPclinicName;
	@FindBy(xpath="//*[@id=\"phone\"]")
	WebElement GPClinicPhone;
	@FindBy(xpath="//*[@id=\"inputReadCodesNames\"]")
	WebElement readCodeNames;
	@FindBy(xpath="//*[@id=\"inputAccNo\"]")
	WebElement GPAccNumber;
	@FindBy(xpath="//*[@id=\"inputReadCodes\"]")
	WebElement readCodes;
	@FindBy(xpath="//*[@id=\"inputgpStreetName\"]")
	WebElement GPAddress;
	@FindBy(xpath="//*[@id=\"inputgpClinicStreetName\"]")
	WebElement GPClinicAddress;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-consent-form/div[2]/button")
	WebElement submit;
	@FindBy(xpath="//*[@id=\"exampleCheck1\"]")
	WebElement sameAsPhysical;
	@FindBy(xpath="//*[@id=\"inputGender\"]")
	WebElement Gender;
	@FindBy(xpath="//*[@id=\"inputEthnicGroup\"]")
	WebElement EthnicGroup;
	@FindBy(xpath="//*[@id=\"collapseOne\"]/div[5]/div[1]/select")
	WebElement WhyChoosingUs;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div[5]/div[1]/select")
	WebElement AccInjury;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div[6]/div[1]/select")
	WebElement WorkIntensity;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div[6]/div[3]/div/div/div/div/div[1]/select")
	WebElement TimeOfInjury;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div[8]/div[1]/select")
	WebElement Scene;
	@FindBy(xpath="//*[@id=\"collapseTwo\"]/div[8]/div[2]/select")
	WebElement Location;
	@FindBy(xpath="//*[@id=\"inputPostalStreet\"]")
	WebElement postalAddress;
	@FindBy(xpath="//*[@id=\"inputGPTitle\"]")
	WebElement GPtitle;
	public User_ConsentForm() {
		PageFactory.initElements(driver, this);
		
	}
		
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[1]/a")));
		ConsentForm.click();	
	}
	public void toAddPersonalInformationInConsentForm(String title,String fname,String lname,String dob,String gender,String email,String ethenicGroup,String knownAs1,String whychoosingus,String rname,String hnumber,String mnumber,String wnumber)
	{
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"inputTitle\"]")));
		select.selectByVisibleText(title);
		firstName.clear();
		firstName.sendKeys(fname);
		lastName.clear();
		lastName.sendKeys(lname);
		DOB.clear();
		DOB.sendKeys(dob);
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"inputGender\"]")));
		select1.selectByVisibleText(gender);
		emailId.clear();
		emailId.sendKeys(email);
		Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"inputEthnicGroup\"]")));
		select2.selectByVisibleText(ethenicGroup);
		knownAs.clear();
		knownAs.sendKeys(knownAs1);
		Select select3 = new Select(driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div[5]/div[1]/select")));
		select3.selectByVisibleText(whychoosingus);
		referrerName.clear();
		referrerName.sendKeys(rname);
		homeNumber.clear();
		homeNumber.sendKeys(hnumber);
		mobileNumber.clear();
		mobileNumber.sendKeys(mnumber);
		workPhone.clear();
		workPhone.sendKeys(wnumber);	
	}
	public void toSelectMedicalCondition(String condition)
	{
		conditions.click();
		String[] conditionarr = condition.split(","); 
		
		for (String con : conditionarr) {
			
			{
			String specxpath = "//input[@aria-label='" + con  + "']";		
			WebElement Spec_dropdown = driver.findElement(By.xpath(specxpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);
			}
		}
	
		conditions.click();
	
	}
	public void toAddMedicalInformationInConsentForm(String description,String condition1,String surgery,String medicList,String allergy,String healthIssues,String accidentInjury,String clNumber,String workIntensity,String dateofinjury1,String timeOfInjuryHour,String timeofinjuryMinutes,String timeOFInjuryAMPM,String workRelatedInjuryYesNo,String motorRelatedAccidentYesNo,String scene,String location) throws InterruptedException
	{
		medicalInformation.click();
		descriptionForInjury.clear();
		descriptionForInjury.sendKeys(description);
		toSelectMedicalCondition(condition1);
		recentSurgery.clear();
		recentSurgery.sendKeys(surgery);
		allMedicationsList.clear();
		allMedicationsList.sendKeys(medicList);
		allergies.clear();
		allergies.sendKeys(allergy);
		otherHealthIssues.clear();
		otherHealthIssues.sendKeys(healthIssues);
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div[5]/div[1]/select")));
		select.selectByVisibleText(accidentInjury);
		claimNumber.clear();
		claimNumber.sendKeys(clNumber);
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div[6]/div[1]/select")));
		select1.selectByVisibleText(workIntensity);
		dateOfInjury.clear();
		toselectDateOfInjury(dateofinjury1);
		Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div[6]/div[3]/div/div/div/div/div[1]/select")));
		select2.selectByVisibleText(timeOfInjuryHour);
		timeOfInjuryMinute.clear();
		timeOfInjuryMinute.sendKeys(timeofinjuryMinutes);
		   JavascriptExecutor executor = (JavascriptExecutor) driver;
		if(timeOFInjuryAMPM.contains("AM"))
		{
			     executor.executeScript("arguments[0].click();", timeOfInjuryAM);
		}
		else
		{
			     executor.executeScript("arguments[0].click();", timeOfInjuryPM);
		}
		
		if(workRelatedInjuryYesNo.contains("Yes"))
		{
			     executor.executeScript("arguments[0].click();",WorkRelatedInjuryYes);
		}
		else
		{
			     executor.executeScript("arguments[0].click();",WorkRelatedInjuryNo); 
		}
		if(motorRelatedAccidentYesNo.contains("Yes"))
		{
			     executor.executeScript("arguments[0].click();",motorAccidentYes); 
		}
		else
		{
			     executor.executeScript("arguments[0].click();",motorAccidentNo); 
		}
		Select select3 = new Select(driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div[8]/div[1]/select")));
		select3.selectByVisibleText(scene);
		Select select4 = new Select(driver.findElement(By.xpath("//*[@id=\"collapseTwo\"]/div[8]/div[2]/select")));
		select4.selectByVisibleText(location);
	
	}
	public void toselectDateOfInjury(String dateofinjury) throws InterruptedException
	{
		String splitter[] = dateofinjury.split("-");
		String month_year = splitter[1];
		String day = splitter[0]; 
		System.out.println(day);
		dateOfInjury.click();
		selectDate(month_year,day); 
	}

	public void selectDate(String month_year, String select_day) throws InterruptedException
	{ 
	List<WebElement> elements = driver.findElements(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view"));

	for (int i=0; i<elements.size();i++)
	{

	if(elements.get(i).getText().contains(month_year))
	{ 
	List<WebElement> days = driver.findElements(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr/td"));
	for (WebElement d:days)
	{ 
	
	if(d.getText().contains(select_day))
	{
	d.click();
	break;
	}
	} 
	} 
	}
}
	public void toAddVenueInformationInConsentForm(String location) throws InterruptedException
	{
		venueInformation.click();
		enterLocation.clear();
		enterLocation.sendKeys(location);
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"collapseThree\"]/div/div[1]/div/div/div[2]/div"));
	
		action.moveToElement(we).click().build().perform();
		enterLocation.click();
		
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"collapseThree\"]/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/label")));
		     enterLocation.click();
		     Thread.sleep(3000);
		     executor.executeScript("arguments[0].click();", sameAsPhysical);
		     //sameAsPhysical.click();
		     Thread.sleep(4000);
		    
	}
	public void toAddProfessionalInformation(String nhiNum,String cOccupation,String eName,String eEmail,String ePhone,String eAddress) throws InterruptedException
	{
		professionalInformation.click();
		Thread.sleep(4000);
		nhiNumber.clear();
		nhiNumber.sendKeys(nhiNum);
		clientOccupation.clear();
		clientOccupation.sendKeys(cOccupation);
		employerName.clear();
		employerName.sendKeys(eName);
		employerEmail.clear();
		employerEmail.sendKeys(eEmail);
//		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(employerPhone));
	//	employerPhone.sendKeys(ePhone);
		employerAddress.clear();
		employerAddress.sendKeys(eAddress);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"collapseFour\"]/div/div[2]/div/div/div/div/div/div/div[2]/div"));
		Thread.sleep(5000);
		action.moveToElement(we).click().build().perform();
		employerAddress.click();
		Thread.sleep(5000);
	}
	
	public void toAddGPInformationInConsentForm(String GPTitle,String GPfname,String GPlname,String GPemail,String GPphone,String GPCname,String GPclinicphone,String GPreadCodeName,String AccNum,String GPreadCodes,String GPaddress,String GPclinicaddress) throws InterruptedException
	{
		GPInformation.click();
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"inputGPTitle\"]")));
		select.selectByVisibleText(GPTitle);
		GPfirstName.clear();
		GPfirstName.sendKeys(GPfname);
		GPlastName.clear();
		GPlastName.sendKeys(GPlname);
		GPEmail.clear();
		GPEmail.sendKeys(GPemail);
		//GPPhone.sendKeys(GPphone);
		GPclinicName.clear();
		GPclinicName.sendKeys(GPCname);
		//GPClinicPhone.sendKeys(GPclinicphone);
		readCodeNames.clear();
		readCodeNames.sendKeys(GPreadCodeName);
		GPAccNumber.clear();
		GPAccNumber.sendKeys(AccNum);
		readCodes.clear();
	    readCodes.sendKeys(GPreadCodes);
	    GPAddress.clear();
	    GPAddress.sendKeys(GPaddress);
	    Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"collapseFive\"]/div[5]/div[1]/div/div/div[2]/div"));
		Thread.sleep(5000);
		action.moveToElement(we).click().build().perform();
		GPAddress.click();
		GPClinicAddress.clear();
		GPClinicAddress.sendKeys(GPclinicaddress);
		WebElement we1 = driver.findElement(By.xpath("//*[@id=\"collapseFive\"]/div[5]/div[2]/div/div/div[2]/div"));
		Thread.sleep(5000);
		action.moveToElement(we1).click().build().perform();
		GPClinicAddress.click();
		Thread.sleep(5000);
	}
	public void tocheckboxAlltheconsent() throws InterruptedException {
		
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"I hereby give permission for Physiotherapy which is treatment based on manual therapy such as soft tissue & joint mobilisation and exercise based rehabilitation.  The aim is to produce a functional outcome.\"]")));
		 
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"I have the right to question any stage of the treatment process.\"]")));
		 
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"I may withdraw my consent for treatment at anytime and request a second opinion.\"]")));
		
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"Confidentiality of all records/information will be maintained in accordance with the Privacy Act (1994).\"]")));
		 
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"In some circumstances ACC or registered insurers may refuse payment cover. By signing this you acknowledge responsibility for the full payment in the event of this occurring.\"]")));
		 
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"I also agree to pay for any appointments that have been missed without prior notice of 6 hours.\"]")));	
		submit.click();
		Thread.sleep(7000);
	}
	
	
	public void tocheckPersonalDetailsInConsentForm(String title,String fname,String lname,String dob,String gender,String email,String ethenicGroup,String knownAs1,String whychoosingus,String rname,String hnumber,String mnumber,String wnumber)
	{
		String gen="";
		if(gender.contains("Male"))
		{
			gen="0";
		}
		else if(gender.contains("Female"))
		{
			gen="1";
		}
		else
		{
			gen="2";
		}
		//System.out.println(WhyChoosingUs.getAttribute("value"));
		if(Title.getAttribute("value").contains(title))
		{
		if(firstName.getAttribute("value").contains(fname)) 
		{
			if(lastName.getAttribute("value").contains(lname))
			{
				if(DOB.getAttribute("value").contains(dob))
				{
					if(Gender.getAttribute("value").contains(gen))
					{
					if(emailId.getAttribute("value").contains(email))
					{
						if(EthnicGroup.getAttribute("value").contains(ethenicGroup))
						{
							
						if(knownAs.getAttribute("value").contains(knownAs1))
						{
							if(WhyChoosingUs.getAttribute("value").contains(whychoosingus)) {
								
							if(referrerName.getAttribute("value").contains(rname))
							{
								if(homeNumber.getAttribute("value").contains(hnumber))
								{
									if(mobileNumber.getAttribute("value").contains(mnumber))
									{
										if(workPhone.getAttribute("value").contains(wnumber))
										{
											System.out.println("Success in Personnal Information");
										}
										else {System.out.println("Error in Work Phone");}
									}
									else {System.out.println("Error in Mobile Number");}
								}
								else {System.out.println("Error in Home Number");}
							}
							else{System.out.println("Error in referrer Name");}
						}else {System.out.println("Error in Why choosing Us");}
						}
						else{System.out.println("Error in Known As");}
					}else {System.out.println("Error in Ethnic Group");}
					}
					else{System.out.println("Error in Email");}
				}
					else {System.out.println("Error in Gender");}
				}
				
				else{System.out.println("Erro in DOB");}
			}
			else{System.out.println("Error in last Name");}
		}
		else{System.out.println("Error in FirstName");}
		}
		
		else {System.out.println("Error in Title");}
	}
	
	public void tocheckMedicalDetailsInConsentForm(String description,String condition1,String surgery,String medicList,String allergy,String healthIssues,String accidentInjury,String clNumber,String workIntensity,String dateofinjury1,String timeOfInjuryHour,String timeofinjuryMinutes,String timeOFInjuryAMPM,String workRelatedInjuryYesNo,String motorRelatedAccidentYesNo,String scene,String location) throws InterruptedException
	{
		medicalInformation.click();
		if(descriptionForInjury.getAttribute("value").contains(description))
		{
			if(recentSurgery.getAttribute("value").contains(surgery))
			{
				if(allMedicationsList.getAttribute("value").contains(medicList))
				{
					if(allergies.getAttribute("value").contains(allergy))
					{
						if(otherHealthIssues.getAttribute("value").contains(healthIssues))
						{
							if(AccInjury.getAttribute("value").contains(accidentInjury))
							{
								if(claimNumber.getAttribute("value").contains(clNumber))
								{
									if(WorkIntensity.getAttribute("value").contains(workIntensity))
									{
										if(dateOfInjury.getAttribute("value").contains(dateofinjury1))
										{
											if(TimeOfInjury.getAttribute("value").contains(timeOfInjuryHour))
											{
												if(timeOfInjuryMinute.getAttribute("value").contains(timeofinjuryMinutes))
												{
													if(Scene.getAttribute("value").contains(scene))
													{
														if(Location.getAttribute("value").contains(location))
														{
															System.out.println("Success In Medical Information");
														}
														else {System.out.println("Error in Location");}
													}
													else {System.out.println("Error in Scene");}
												}
												else {System.out.println("Error in Time Of Injury Minutes");}
											}
											else {System.out.println("Error in Time of Injury");}
										}
										else {System.out.println("Error in Date of Injury");}
									}
									else {System.out.println("Error in WorkIntensity");}
								}
								else {System.out.println("Error in Claim Number");	}
							}
							else {System.out.println("Error in Accident Injury");}
						}
						else {System.out.println("Error in Other Health Issues");}
					}
					else {System.out.println("Error in allergies");}
				}
				else {System.out.println("Error in Medication List");}
			}
			else {System.out.println("Error in surgery");}
		}
		else{System.out.println("Error in Description");}
		
	}

	public void toCheckVenueDetailsInConsentForm(String location) throws InterruptedException
	{
		
		venueInformation.click();
		if(enterLocation.getAttribute("value").contains(location)) {
			if(postalAddress.getAttribute("value").contains(location))
				{
						System.out.println("Success in Venue Information");
				}
				else {System.out.println("Error in Postal Address");}
			
		}
		else
		{
			System.out.println("Error in Venue Location");
		}
	}

	public void toCheckProfessionalDetailsInConsentForm(String nhiNum,String cOccupation,String eName,String eEmail,String ePhone,String eAddress) throws InterruptedException
{
	professionalInformation.click();
	if(nhiNumber.getAttribute("value").contains(nhiNum))
	{
		if(clientOccupation.getAttribute("value").contains(cOccupation))
		{
			if(employerName.getAttribute("value").contains(eName))
			{
				if(employerEmail.getAttribute("value").contains(eEmail))
				{
					if(employerAddress.getAttribute("value").contains(eAddress)) {
						System.out.println("Success in Professional Information");
					}
					else {System.out.println("Error in Employer Address");}
				}
				else {System.out.println("Error in Employer Email");}
			}
			else {System.out.println("Error in Employer Name");}
		}
		else {System.out.println("Error in Client Occupation");}
	}
	else {System.out.println("Error in nhi Number");}
}
	
	public void toCheckGPDetailsInConsentForm(String GPTitle,String GPfname,String GPlname,String GPemail,String GPphone,String GPCname,String GPclinicphone,String GPreadCodeName,String AccNum,String GPreadCodes,String GPaddress,String GPclinicaddress) throws InterruptedException
	{
		GPInformation.click();
		if(GPtitle.getAttribute("value").contains(GPTitle))
		{
			if(GPfirstName.getAttribute("value").contains(GPfname))
			{
				if(GPlastName.getAttribute("value").contains(GPlname))
				{
					if(GPEmail.getAttribute("value").contains(GPemail))
					{
						if(GPclinicName.getAttribute("value").contains(GPCname))
						{
							if(readCodeNames.getAttribute("value").contains(GPreadCodeName))
							{
								if(GPAccNumber.getAttribute("value").contains(AccNum))
								{
									if(readCodes.getAttribute("value").contains(GPreadCodes))
									{
										if(GPAddress.getAttribute("value").contains(GPaddress))
										{
											if(GPClinicAddress.getAttribute("value").contains(GPclinicaddress))
											{
												System.out.println("Success in GP Information");
											}
											else {System.out.println("Error in GP Clinic Address");}
										}
										else {System.out.println("Error in GP Address");}
									}
									else {System.out.println("Error in Read Codes");}
								}
								else {System.out.println("Eoor in Account Number");}
							}
							else {System.out.println("Error in GP Read Code Names ");}
						}
						else {System.out.println("Error in Clinic Name");}
					}
					else {System.out.println("Error in GP Email");}
				}
				else {System.out.println("Error In GP LastName");}
			}
			else {System.out.println("Error in GP FirstName");}
		}
		else {System.out.println("Error in GP Title");}
	}
	}