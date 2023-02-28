package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.AppointmentsGroupClass;
import Pages.Consultations;
import Pages.Login;
import Pages.Patients;
import Pages.Patients_Appointments;
import Pages.Patients_ClientRecommandVideo;
import Pages.Patients_Profile;
import Pages.Patients_RecommandVideo;
import Pages.Profile_clinician;
import Pages.RecommendedVideos;
import Pages.UserReport;
import Pages.VideoLibrary;
import Pages.WorkingHours;

public class Login_TC extends TestBase {
		Login loginPage;
		Profile_clinician profile;
		Patients patient;
		Patients_Profile patients_profile;
		Patients_Appointments patients_appointments;
		Patients_RecommandVideo recvideo;
		Patients_ClientRecommandVideo client;
		Consultations consult;
		UserReport report;
		VideoLibrary video;
		WorkingHours whours;
		AppointmentsGroupClass app;
		RecommendedVideos rec;
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
			consult=new Consultations();
			report=new UserReport();
			video=new VideoLibrary();
			whours=new WorkingHours();
			app =new AppointmentsGroupClass();
			rec=new RecommendedVideos();
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
			profile.addProfileData("Sachin","Nutritionist,Personal Trainer","01-12-1994","578 Sandringham Road, Sandringham, Auckland 1025, New Zealand","sachinc@demo.com","sachinc@demo.com","9","Male","+6432345666","Grafton Clinic,Jeeva clinic");
			//profile.toCheckProfileDetails("Sachin","Nutritionist,Personal Trainer","01-12-1994","578 Sandringham Road, Sandringham, Auckland 1025, New Zealand","sachinc@demo.com","sachinc@demo.com","9","Male","+6432345666","Grafton Clinic,Jeeva clinic");
		}
		@Test
		public void patientsTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			patient.view();
			patient.searchPatients("Tester","Mr" ,"Tester","Roja","26-05-1994","Female","Brihtlinroja@deemsys.in","Indian", "Bright", "Location","Jenny","+6439885679","+6439885679","+6439885679","Description", "Angina ", "Osteoporosis", "Heart Surgery", "Dolo,Citrzin","shell fish","No Health Issues","Yes", "123", "Light", "14-12-2022", "8","30", "AM","Yes", "Yes", "Home", "At Sea","Remuera","ABC1234", "IT", "Bright","Bright@gmail.com", "+6439885679", "8 Arrenway Drive","Miss", "Brightlin", "Roja", "Bright@gmail.com", "+6439885679", "Apollo", "+6439885679", "Bright", "1234", "bright", "Remuera","Reimers Avenue");
			
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
			patients_appointments.searchPatients("Tester","All");
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
		@Test
		public void ConsultationsTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			consult.view();
			consult.viewConsultationsDetails("18-01-2023","Completed","Tester");
		}
		@Test
		public void UserReportTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			report.view();
			//report.viewUserReports();
			report.toViewHistoryOfSpecificClient("Tester", "1-January-2023","18-January-2023");
		}
		@Test
		public void VideoLibraryTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			video.view();
			video.viewVideoLibrary();
		}
		@Test
		public void WorkingHoursTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			whours.viewWorkingHours();
			whours.toEnabletheDay("ACC Initial,massage Theraphy", "Friday", "2:00", "3:00","Jeeva clinic");
			
		}
		@Test
		public void AppointmentGroupClassTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			app.view();
			//app.viewCalendar();
			//app.createNewUser("Grace", "Grace@gmail.com", "12345678", "26-05-1994","Female");
			//app.toPerformActions("Grace", "grace@gmail.com", "+6439885600", "26-05-1994","Female"," Exercise-Based Rehabilitation - 30 "," Room 1 ","Brightlin","Brightlin,DEEMSYS","Bright","GroupClass","6:50","Pre Paid","250","3","DEEMSYS","Sachin","In Clinic");
			//app.rightClickViewAppointments(" ACC Initial ", "04-01-2023", "7:00", "7:30");
			//app.toCreateConsultation();
			//app.toEditAppointments(" ACC Initial ", " Room 2 ", "4-1-2023", "7:00", "7:30");
			//app.toCancelAppointment();
			//app.toUpdateDragandDrop();
			//app.createGroupClass("Testing 200","Description", "8:30", "Pre Paid", "300", "4", "Sachin", "Sachin", "Virtual Meeting");
			//app.toCreateConsultationForGroupClass("Testing 200");
			//app.toEditGroupClass("Testing 200");
			app.toInvieUsersForGroupClass("Testing 200","sheelak@deemsys.in");
			
		}
		@Test
		public void RecommandVideosTest() throws InterruptedException
		{
			profile=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			rec.view();
			rec.viewConsultationsDetails1("13-01-2023","Not Started","Brightlin","All-Rotation");
		}
		
		
	}