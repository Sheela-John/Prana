package Pages;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.jsoup.internal.FieldsAreNonnullByDefault;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class Patients extends TestBase {
	

	@FindBy(xpath="/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")
	WebElement patients;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-my-patients/div/div[2]/div[1]/div/div/input")
	WebElement search;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/nav/div/a[1]")
	WebElement profile;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/nav/div/a[5]")
	WebElement consentForm;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/input")
	WebElement firstName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[1]/div[2]/div[1]/input")
	WebElement lastName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[2]/div[1]/div[1]/input")
	WebElement DOB;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[3]/div[1]/div[1]/input")
	WebElement emailId;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[4]/div/div/input")
	WebElement knownAs;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[5]/div[2]/div/input")
	WebElement referrerName;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[6]/div[1]/ngx-intl-tel-input/div/input")
	WebElement homeNumber;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[6]/div[2]/ngx-intl-tel-input/div/input")
	WebElement mobileNumber;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[6]/div[3]/ngx-intl-tel-input/div/input")
	WebElement workPhone;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[3]/h2/button")
	WebElement medicalInformation;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[1]/div/div/textarea")
	WebElement descriptionForInjury;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[2]/div/ng-multiselect-dropdown/div/div[1]/span")
	WebElement medicalCondition;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[3]/div[1]/textarea")
	WebElement recentSurgery;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[3]/div[2]/textarea")
	WebElement allMedicationsList;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[4]/div[1]/input")
	WebElement allergies;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[4]/div[2]/input")
	WebElement otherHealthIssues;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[5]/div[2]/input")
	WebElement claimNumber;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[6]/div[2]/div/div/input")
	WebElement dateOfInjury;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[6]/div[3]/div/div/div/div/div[2]/input")
	WebElement timeOfInjuryMinute;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[6]/div[3]/div/div/div/div/div[3]/div[1]/label[1]/input")
	WebElement timeOfInjuryAm;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[6]/div[3]/div/div/div/div/div[3]/div[1]/label[2]/input")
	WebElement timeOfInjuryPM;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[7]/div[1]/div[2]/div/input")
	WebElement workRelatedInjuryYes;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[7]/div[1]/div[3]/div/input")
	WebElement workRelatedInjuryNo;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[7]/div[2]/div[2]/div/input")
	WebElement motorVehicleAccidentYes;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[7]/div[2]/div[3]/div/input")
	WebElement motorVehicleAccidentNo;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[5]")
	WebElement venueInformation;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[6]/div/div[1]/div/div/div[2]/input")
	WebElement enterLocation;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[6]/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/input")
	WebElement sameAsPhysicalAddress;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[7]/h2/button")
	WebElement professionalInformation;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[8]/div/div[1]/div[1]/input")
	WebElement nhiNumber;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[8]/div/div[1]/div[2]/input")
	WebElement clientOccupation;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[8]/div/div[1]/div[3]/div/input")
	WebElement employerName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[8]/div/div[1]/div[4]/div/input")
	WebElement employerEmail;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[8]/div/div[1]/div[5]/ngx-intl-tel-input/div/input")
	WebElement employerPhone;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[8]/div/div[2]/div/div/div/div/div/div[2]/input")
	WebElement employerAddress;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[9]/h2/button")
	WebElement GPInformation;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[1]/div[1]/div/div/div[2]/div/input")
	WebElement GPfirstName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[1]/div[2]/div/input")
	WebElement GPlastName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[2]/div[1]/div/input")
	WebElement GPEmail;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[2]/div[2]/ngx-intl-tel-input/div/input")
	WebElement GPPhone;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[3]/div[1]/input")
	WebElement GPclinicName;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[3]/div[2]/ngx-intl-tel-input/div/input")
	WebElement GPClinicPhone;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[4]/div[1]/input")
	WebElement readCodeNames;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[4]/div[2]/div/div/div[1]/input")
	WebElement GPAccNumber;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[4]/div[2]/div/div/div[2]/input")
	WebElement readCodes;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[5]/div[1]/div/div/div[2]/input")
	WebElement GPAddress;
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[5]/div[2]/div/div/div[2]/input")
	WebElement GPClinicAddress;
	
	@FindBy(xpath="/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/button")
	WebElement submit;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-patient-details/div/div[2]/div/div[1]/div/div/div[3]/form/div/div[1]/input")
	WebElement patientName;
	@FindBy(xpath="//*[@id=\"phone\"]")
	WebElement patientPhone;
	@FindBy(xpath="//*[@id=\"inputPhysicalStreet\"]")
	WebElement patientLocation;
	@FindBy(xpath="//*[@id=\"inputDOB\"]")
	WebElement patientDOB;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-patient-details/div/div[2]/div/div[1]/div/div/div[3]/form/div/div[12]/input")
	WebElement patientHeight;
	@FindBy(xpath="//*[@id=\"container\"]/div/app-patient-details/div/div[2]/div/div[1]/div/div/div[3]/form/div/div[13]/input")
	WebElement patientWeight;
	public Patients() {
		PageFactory.initElements(driver, this);
	}
	public void view() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-link[2]/a")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",patients);	
		//patients.click();
	}
	public void searchPatients(String patientName,String title,String fname,String lname,String dob,String gender,String email,String ethenicGroup,String knownAs1,String whychoosingus,String rname,String hnumber,String mnumber,String wnumber,String description,String condition1,String condition2,String surgery,String medicList,String allergy,String healthIssues,String accidentInjury,String clNumber,String workIntensity,String dateofinjury,String timeOfInjuryHour,String timeofinjuryMinutes,String timeOFInjuryAMPM,String workRelatedInjuryYesNo,String motorRelatedAccidentYesNo,String scene,String location,String venueLocation,String nhiNum,String cOccupation,String eName,String eEmail,String ePhone,String eAddress,String GPTitle,String GPfname,String GPlname,String GPemail,String GPphone,String GPCname,String GPclinicphone,String GPreadCodeName,String AccNum,String GPreadCodes,String GPaddress,String GPclinicaddress) throws InterruptedException
	{
		search.sendKeys(patientName+Keys.ENTER);
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"container\"]/div/app-my-patients/div/div[2]/div[2]/div"));
		
		action.moveToElement(we).click().build().perform();
		Thread.sleep(6000);		
			toviewPersonnalDetails();
//			consentForm.click();
//			toEnterPesonalDetailsForConsentForm(title, fname, lname, dob, gender, email, ethenicGroup, knownAs1, whychoosingus, rname, hnumber, mnumber, wnumber);
//			toEnterMedicalDetailsForConsentForm( description, condition1, condition2, surgery, medicList, allergy, healthIssues, accidentInjury, clNumber, workIntensity, dateofinjury, timeOfInjuryHour, timeofinjuryMinutes, timeOFInjuryAMPM, workRelatedInjuryYesNo, motorRelatedAccidentYesNo, scene, location);
//			toEnterVenueInformation(venueLocation);
//			toEnterProfessionalInformation(nhiNum, cOccupation, eName, eEmail, ePhone, eAddress);
//			toEnterGPInformation(GPTitle, GPfname, GPlname, GPemail, GPphone, GPCname, GPclinicphone, GPreadCodeName, AccNum, GPreadCodes, GPaddress,GPclinicaddress);
//			consentForTreatment();
			
			}
			
	public void toviewPersonnalDetails() throws InterruptedException
	{
		String[] patientDetails = new String[7];
		patientDetails[1]=patientName.getAttribute("value");
		patientDetails[2]=patientPhone.getAttribute("value");
		patientDetails[3]=patientDOB.getAttribute("value");
		patientDetails[4]=patientLocation.getAttribute("value");
		patientDetails[5]=patientHeight.getAttribute("value");
		patientDetails[6]=patientWeight.getAttribute("value");
		for(int i=1;i<patientDetails.length;i++)
		{
			System.out.println(patientDetails[i]);
		}
		Logoff log=new Logoff();
		log.logOff();
		User_Login ulogin=new User_Login();
		ulogin.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		Thread.sleep(6000);
		User_Profile user=new User_Profile();
		if(user.email.getAttribute("value").contains(patientDetails[1]))
		{
			if(user.phone.getAttribute("value").contains(patientDetails[2]))
			{
				if(user.DOB.getAttribute("value").contains(patientDetails[3]))
				{
					if(user.address.getAttribute("value").contains(patientDetails[4]))
					{
						if(user.height.getAttribute("value").contains(patientDetails[5]))
						{
							if(user.weight.getAttribute("value").contains(patientDetails[6]))
							{
								System.out.println("Success");
							}
						}
								
					}
				}
			}
			
		}
		
	}
	public void toEnterPesonalDetailsForConsentForm(String title,String fname,String lname,String dob,String gender,String email,String ethenicGroup,String knownAs1,String whychoosingus,String rname,String hnumber,String mnumber,String wnumber)
	{
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div/div[1]/select")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		DOB.sendKeys(dob);
		Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[2]/div[2]/div[1]/select")));
		select1.selectByVisibleText(gender);
		emailId.sendKeys(email);
		Select select2 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[3]/div[2]/select")));
		select2.selectByVisibleText(ethenicGroup);
		knownAs.sendKeys(knownAs1);
		Select select3 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[2]/div[5]/div[1]/select")));
		select3.selectByVisibleText(whychoosingus);
		referrerName.sendKeys(rname);
		homeNumber.sendKeys(hnumber);
		mobileNumber.sendKeys(mnumber);
		workPhone.sendKeys(wnumber);	
		
	}
	public void toSelectMedicalCondition(String condition)
	{
		medicalCondition.click();
		String[] conditionarr = condition.split(","); 
		for (String con : conditionarr) {
			{
			String specxpath = "//input[@aria-label='" + con + "']";		
			WebElement Spec_dropdown = driver.findElement(By.xpath(specxpath));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Spec_dropdown);	
			}
		}
		
		
	
	}
	public void toEnterMedicalDetailsForConsentForm(String description,String condition1,String condition2,String surgery,String medicList,String allergy,String healthIssues,String accidentInjury,String clNumber,String workIntensity,String dateofinjury,String timeOfInjuryHour,String timeofinjuryMinutes,String timeOFInjuryAMPM,String workRelatedInjuryYesNo,String motorRelatedAccidentYesNo,String scene,String location)
	{
		medicalInformation.click();
		descriptionForInjury.sendKeys(description);
		medicalCondition.click();
		toSelectMedicalCondition(condition1);
		toSelectMedicalCondition(condition2);
		recentSurgery.sendKeys(surgery);
		allMedicationsList.sendKeys(medicList);
		allergies.sendKeys(allergy);
		otherHealthIssues.sendKeys(healthIssues);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[5]/div[1]/select")));
		select.selectByVisibleText(accidentInjury);
		claimNumber.sendKeys(clNumber);
		Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[6]/div[1]/select")));
		select1.selectByVisibleText(workIntensity);
		dateOfInjury.sendKeys(dateofinjury);
		Select select2 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[6]/div[3]/div/div/div/div/div[1]/select")));
		select2.selectByVisibleText(timeOfInjuryHour);
		timeOfInjuryMinute.sendKeys(timeofinjuryMinutes);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		if(timeOFInjuryAMPM.contains("AM"))
		{			    
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[6]/div[3]/div/div/div/div/div[3]/div[1]/label[1]/input")));
		}
		else
		{
			
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[6]/div[3]/div/div/div/div/div[3]/div[1]/label[2]/input")));	  
		}
		
		if(workRelatedInjuryYesNo.contains("Yes"))
		{
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[7]/div[1]/div[2]/div/input")));
	    }
		else
		{
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[7]/div[1]/div[3]/div/input")));
		}
		if(motorRelatedAccidentYesNo.contains("Yes"))
		{
			
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[7]/div[2]/div[2]/div/input")));
		}
		else
		{
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[7]/div[2]/div[3]/div/input")));	  
		}
		Select select3 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[8]/div[1]/select")));
		select3.selectByVisibleText(scene);
		Select select4 = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[4]/div[8]/div[2]/select")));
		select4.selectByVisibleText(location);
	}
	
	public void toEnterVenueInformation(String location) throws InterruptedException
	{
		venueInformation.click();
		//Thread.sleep(8000);
		enterLocation.sendKeys(location);
		
		enterLocation.sendKeys(Keys.ENTER);
		
		List<WebElement> patientVenueDetailsList = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[6]/div/div[1]/div/div/div"));
		System.out.println(patientVenueDetailsList.size());
		for(int i=0;i<patientVenueDetailsList.size();i++)
		{
			String details=patientVenueDetailsList.get(i).getText();
			System.out.println(details);
		}
		Thread.sleep(8000);
		
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[6]/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/input")));
		  
		Thread.sleep(8000);
		List<WebElement> patientVenueDetailsList1 = driver.findElements(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[6]/div/div[2]/div/div/div[3]/div"));
		System.out.println(patientVenueDetailsList1.size());
		for(int i=0;i<patientVenueDetailsList1.size();i++)
		{
			String details=patientVenueDetailsList1.get(i).getText();
			System.out.println(details);
		}
	}
	
	public void toEnterProfessionalInformation(String nhiNum,String cOccupation,String eName,String eEmail,String ePhone,String eAddress) throws InterruptedException
	{
		professionalInformation.click();
		Thread.sleep(4000);
		nhiNumber.sendKeys(nhiNum);
		clientOccupation.sendKeys(cOccupation);
		employerName.sendKeys(eName);
		employerEmail.sendKeys(eEmail);
		employerPhone.sendKeys(ePhone);
		employerAddress.sendKeys(eAddress);
	}
	public void toEnterGPInformation(String GPTitle,String GPfname,String GPlname,String GPemail,String GPphone,String GPCname,String GPclinicphone,String GPreadCodeName,String AccNum,String GPreadCodes,String GPaddress,String GPclinicaddress) throws InterruptedException
	{
		GPInformation.click();
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[1]/form/div[10]/div[1]/div[1]/div/div/div[1]/select")));
		select.selectByVisibleText(GPTitle);
		GPfirstName.sendKeys(GPfname);
		GPlastName.sendKeys(GPlname);
		GPEmail.sendKeys(GPemail);
		GPPhone.sendKeys(GPphone);
		GPclinicName.sendKeys(GPCname);
		GPClinicPhone.sendKeys(GPclinicphone);
		readCodeNames.sendKeys(GPreadCodeName);
		GPAccNumber.sendKeys(AccNum);
	    readCodes.sendKeys(GPreadCodes);
	    GPAddress.sendKeys(GPaddress);
		GPClinicAddress.sendKeys(GPclinicaddress);
	}
	public void consentForTreatment()
	{
		
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[2]/div/div[1]/input")));
		  
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[2]/div/div[2]/input")));
		 
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[2]/div/div[3]/input")));
		
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[2]/div/div[4]/input")));
		 
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[2]/div/div[5]/input")));
		 
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/div/app-patient-details/div/div[2]/div/div[2]/div/div/div/div[5]/app-consent-form/div[2]/div[2]/div/div[6]/input")));
		submit.click();
	}
}
