package testCase;

import java.io.IOException;
import java.util.Date;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.User_Appointments;
import Pages.User_BookAppointment;
import Pages.User_ConsentForm;
import Pages.User_Consultations;
import Pages.User_Documents;
import Pages.User_ExerciseLibrary;
import Pages.User_GroupClassConsultations;
import Pages.User_Login;
import Pages.User_Profile;


public class User_Login_TC extends TestBase {
	User_Login login;
	User_Profile profile;
	User_BookAppointment book;
	User_ConsentForm consent;
	User_Documents doc;
	User_Consultations consult;
	User_Appointments app;
	User_GroupClassConsultations group;
	User_ExerciseLibrary exercise;
	public User_Login_TC() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		login=new User_Login();
		profile=new User_Profile();
		book=new User_BookAppointment();
		consent=new User_ConsentForm();
		doc=new User_Documents();
		consult=new User_Consultations();
		app=new User_Appointments();
		group=new User_GroupClassConsultations();
		exercise=new User_ExerciseLibrary();
	}
	@Test
	public void loginTest() throws IOException, InterruptedException {
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		Thread.sleep(4000);
	}
	@Test
	public void ProfileTest() throws InterruptedException
	{
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		Thread.sleep(4000);
		profile.view();
		profile.toEditProfile("Tester","1994-04-10", "Male","AuckLand","Tester@gmail.com","jeniferj@deemsys.in","+919677055044","167","60","heart","BP","no","No","Diet","No","No");
		Thread.sleep(3000);
		//profile.checkingAllDetails("Tester","1994-04-10", "Male","AuckLand","Tester@gmail.com","jeniferj@deemsys.in","+919677055044","167","60","heart","BP","no","No","Diet","No","No");
	}
	@Test
	public void BookAppointment() throws InterruptedException
	{
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		book.view();
		book.toBookAppointment("Grafton Clinic","Exercise Based Rehabilitation - 45","45","Sachin","19:30 - 20:15","01/17/2023","Booked","Pay Now","Deemsys", "4111111111111111 ", "5", "2030", "111","13 Manu Tapu Drive");
		Thread.sleep(4000);
	}
	@Test
	public void ConsentFormTest() throws InterruptedException
	{
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		consent.view();
		//consent.toAddPersonalInformationInConsentForm("Mr", "Tester", "test", "12-12-1994", "Male", "Tester@gmail.com", "Indian", "Bright", "Location", "Jenifer", "+6439885679", "+6439885679", "+6439885679");
		//consent.toAddMedicalInformationInConsentForm("Medical Information", "Diabetes,Artificial Implants", "Heart Surgery", "Paracetamol", "Egg", "No other Issues", "Yes", "1234", "Light", "3-January-2023", "8", "30", "PM", "No","Yes", "Home", "At Sea");
		//consent.toAddVenueInformationInConsentForm("13 Earl Street");
		//consent.toAddProfessionalInformation("1234", "Doctor", "John", "John@gmail.com", "+123456689", "135 Albert Street");
		//consent.toAddGPInformationInConsentForm("Mr", "Tester", "Roja", "Brightlin@gmail.com", "+6439885600", "Apollo", "+6439885600", "readCodesNames", "12345", "readcodes", "122 Remuera Road", "122 Remuera Road");
		//consent.tocheckboxAlltheconsent();
		consent.tocheckPersonalDetailsInConsentForm("Mr", "Tester", "test", "12-12-1994","Male", "Tester@gmail.com", "Indian", "Bright", "Location", "Jenifer", "+6439885679", "+6439885679", "+6439885679");
		consent.tocheckMedicalDetailsInConsentForm("Medical Information", "Diabetes,Artificial Implants", "Heart Surgery", "Paracetamol", "Egg", "No other Issues", "yes", "1234", "Light", "03-01-2023", "8", "30", "PM", "No","Yes", "Home", "At Sea");
		consent.toCheckVenueDetailsInConsentForm("13 Earl Street");
		consent.toCheckProfessionalDetailsInConsentForm("1234", "Doctor", "John", "John@gmail.com", "+123456689", "135 Albert Street");
		consent.toCheckGPDetailsInConsentForm("Mr", "Tester", "Roja", "Brightlin@gmail.com", "+6439885600", "Apollo", "+6439885600", "readCodesNames", "12345", "readcodes", "122 Remuera Road", "122 Remuera Road");
	}
	@Test
	public void DocumentTest() throws InterruptedException
	{
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		doc.view();
		doc.toViewAllDocuments("Testing");
		//doc.toAddDocument("Testing", "C:\\Users\\DSS-Test-1\\Desktop\\Testing.pdf");
	}
	@Test
	public void CounsultationsTest() throws InterruptedException
	{
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		consult.view();
		//consult.toViewAllConsultations("Not Started");
		consult.toCheckJoinMeeing("Sachin", "18-01-2023","Jan 18","Not Started", "Started", "Tester");
		
	}
	@Test
	public void AppointmentTest() throws InterruptedException
	{
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		app.view();
		//app.toViewAllAppointments("Booked", "New Card", "Deemsys", "4111111111111111 ", "3", "2025", "111","13 Manu Tapu Drive");
		//app.toCancelAppoinments();
		//app.toViewConsultationDetailsForAppointments("Completed");
		//app.toviewPaymentBillingDetails( "New Card", "Deemsys", "4111111111111111 ", "3", "2025", "111","13 Manu Tapu Drive");
		//app.toViewGroupClass("Testing for Group for Consultations","Save Card", "Deemsys", "4111111111111111 ", "3", "2025", "111","13 Manu Tapu Drive");
		app.toChecktheGroupWebinar("Testing for Group for Consultations");
	}
	@Test
	public void GroupClassConsultationsTest() throws InterruptedException
	{
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
		group.view();
		//group.toViewGroupClass("Not Started");
		group.toCheckJoinMeetingInGroupClass("Testing for Tester");
	}
	@Test
	public void ExerciseLibraryTest() throws InterruptedException
	{
		login.login(prop.getProperty("useremail"), prop.getProperty("userpassword"));
	exercise.view();
	//exercise.toViewAllVideos("Anti-Rotation","Left - Cable Half-Kneeling Chop");
	exercise.toViewPurchasedVideos("Left - Cable Half-Kneeling Chop");
	}
}
