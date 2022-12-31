package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Login;
import Pages.Patients;
import Pages.Patients_Appointments;
import Pages.Patients_ClientRecommandVideo;
import Pages.Patients_Profile;
import Pages.Patients_RecommandVideo;
import Pages.Profile_clinician;

public class Login_TC extends TestBase {
		Login loginPage;
		Profile_clinician profile;
		Patients patient;
		Patients_Profile patients_profile;
		Patients_Appointments patients_appointments;
		Patients_RecommandVideo recvideo;
		Patients_ClientRecommandVideo client;
		public Login_TC() {
			super();
		}

		@BeforeMethod
		public void setUp() {

			loginPage = new Login();
			profile = new Profile_clinician();
			patient=new Patients();
			patients_profile =new Patients_Profile();
			patients_appointments=new Patients_Appointments();
			recvideo=new Patients_RecommandVideo();
			client=new Patients_ClientRecommandVideo();
		}
		@Test
		public void loginTest() throws IOException, InterruptedException {
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(4000);
			profile.view();
			System.out.println("Logged In");
		}
		@Test
		public void profileTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			
			profile.view();
			profile.addProfileData("DEEMSYS","Nutritionist","Personal Trainer","26-05-1994","578 A Sandringham Road, Sandringham, Auckland 1025, New Zealand","incdeemsys@gmail.com","brightlinroja9@gmail.com","9","Female","+649025094956","Balmoral Medical Centre","Hunter's Corner Medical Centre");
		}
		@Test
		public void patientsTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			patient.view();
			patient.searchPatients("BrightLin","Ms" ,"BrightLin","Roja","26-05-1994","Female","Brihtlinroja@deemsys.in","Indian", "Bright", "Location","Jenny","+6439885679","+6439885679","+6439885679","Description", "Angina ", "Osteoporosis", "Heart Surgery", "Dolo,Citrzin","shell fish","No Health Issues","Yes", "123", "Light", "14-12-2022", "8","30", "AM","Yes", "Yes", "Home", "At Sea","Remuera","ABC1234", "IT", "Bright","Bright@gmail.com", "+6439885679", "8 Arrenway Drive","Miss", "Brightlin", "Roja", "Bright@gmail.com", "+6439885679", "Apollo", "+6439885679", "Bright", "1234", "bright", "Remuera","Reimers Avenue");
			
		}
		@Test
		public void patientsProfileTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			patients_profile.view();
			patients_profile.searchPatients("Brightlin","Heart", "BP", "No", "shellfish");
			//patients_profile.toEditProfileData("Heart", "BP", "No", "shellfish");
		}
		@Test
		public void patientsAppointmentsTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			patients_appointments.view();
			patients_appointments.searchPatients("Brightlin","All");
			//patients_profile.toEditProfileData("Heart", "BP", "No", "shellfish");
		}
		@Test
		public void patientsRecommandVideoTest() throws InterruptedException 
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			recvideo.view();
			recvideo.searchPatients("Brightlin","Movement Integration","Hip Complex");
		}
		@Test
		public void patientsClientRecommandedVideoTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			client.view();
			client.searchPatients("Brightlin","Movement Integration","Hip Complex");
		}
	}