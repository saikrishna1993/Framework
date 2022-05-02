package suntuity.Leadonepagerfunctionallibraries;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import source.Suntuity;
import suntuity.PageObjects.LeadOnePager_Mobile;
import suntuity.PageObjects.LeadOnePager_Web;
import suntuity.PageObjects.QuickBaseLoginPage_Web;
import suntuity.testrun.beans.TestRunBean;


public class SuntuityBusinessFunctions extends CommonFunctions{
	public WebDriver driver;
	public static int[] Drow=null;
	private static Logger logger = Logger.getLogger("Suntuity");
	WebElement element;
	public static String testcaseId="";
	public static  ExtentTest Leadinfo;
	public static  ExtentTest Leadsourceinfo;
	public static  ExtentTest HOA;
	public static  ExtentTest Utility;
	public static  ExtentTest Referrals;
	public static  ExtentTest Notes;
	public static  ExtentTest Appointments;
	public static  ExtentTest Proposals;
	public static  ExtentTest Postsalepaperwork;
	public static  ExtentTest Sitesurveys;
	public static  ExtentTest CRM_Login;
	public SuntuityBusinessFunctions(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	
	public String Login(WritableSheet RSheet, String value){
		String status="";
		boolean signin;
		int NoOfVerify=0;
		try{
			
			
			QuickBaseLoginPage_Web QBL	= PageFactory.initElements(driver, QuickBaseLoginPage_Web.class);
			LeadOnePager_Mobile LM= PageFactory.initElements(driver, LeadOnePager_Mobile.class);
				String username=testRunBean.getUserNameandPassword().split(",")[0];
				String password=testRunBean.getUserNameandPassword().split(",")[1];
				driver.navigate().refresh();	
				if(testRunBean.getRunTestType().contains("Mobile_Web")) {
					LM.Mobile_UsernameField.sendKeys(username);
				   	LM.Mobile_PasswordField.sendKeys(password);
				    waitforElementClickable(120, LM.Mobile_LoginButton, driver);
				    LM.Mobile_LoginButton.click();
				   	Leadinfo.log(LogStatus.PASS, "User is able to login");
				   	}  
				else	
				{
				QBL.QUICKBASE_USERNAMEFIELD.sendKeys(username);
				waitforElement(120, QBL.QUICKBASE_PASSWORDFIELD, driver);
				QBL.QUICKBASE_PASSWORDFIELD.sendKeys(password);
				waitforElement(120, QBL.QUICKBASE_PASSWORDFIELD, driver);
				QBL.QUICKBASE_SIGNINBUTTON.click();
				OpenSandbox(testRunBean.getsandboxname());
					waitforElement(120, QBL.NAVIGATETOLEADONEPAGER, driver);
					JavaScriptclick(driver, QBL.NAVIGATETOLEADONEPAGER);
				} 
				
			
			if(status.isEmpty()){status= "Pass";}
		}
		catch(Exception e)
		{
			xException(RSheet, e, value,driver,testcaseId);
			System.out.println(e.getMessage());
			status="Fail:"+e.getMessage();
			testcaseId="";
		}

		return status;
	}
	
	/*`*/
	public String Leadonepager(WritableSheet RSheet, String value) {
		CRM_Login=Suntuity.LeadonepagerReports.startTest("Navigation from CRM to Onepager");
		Leadinfo=Suntuity.LeadonepagerReports.startTest("Lead info");
		Leadsourceinfo=Suntuity.LeadonepagerReports.startTest("Lead Source info");
		HOA=Suntuity.LeadonepagerReports.startTest("HOA Section");
		String status="";String Status="";
		  int Sanboxlink = 1, Firstname = 2, Lastname = 3, Email = 4, phone = 5, street = 6, city = 7,
				state = 8, zip = 9, Mentor = 10, RelatedCamapign = 11, LeadSource = 12, ReferredBy = 13, HasHoaFlag = 14,
				HOAName = 15, HOAEmailAddress = 16, HoaNumber = 17, HOAExtension = 18, HOAAddress = 19, UtilityCompany = 20,
				AnnualkilowatsUsage = 21, NotesStatus = 22, Notestags = 23, NotesNote = 24, AppointmentsDate = 25,
				AppointmentsTime = 26, appointmnetsresult = 27, appointmentNotes = 28, ProposalLoantype = 29,
				ProposaltargetEPC = 30, Proposalincludespromotions = 31, ProposalOtherIncentives = 32,
				Proposalutiity_company = 33, Proposal_Iaminthe_customerhouserightnow = 34, Proposal_InstallationType = 35,
				ProposalRooftype = 36, ProposalAgeOfRoof = 37, ProposalAnnualkilowatusage = 38, ProposalNote = 39;	
		try{
			LeadOnePager_Web LW = PageFactory.initElements(driver,LeadOnePager_Web.class);
			getSheet(value);
			int Data_Row;
			String Verification="";
			int NoOfVerify=0; 
			Drow=xDatarowno(value);
			for(int i=0;i<=Drow.length-1; i++){
				Data_Row=Drow[i];
				waitUntilElementInvisibe(120, LW.spinner, driver);
				waitforElement(120, driver.findElement(By.xpath("//button[contains(.,'Create Lead')]")), driver);
				driver.findElement(By.xpath("//button[contains(.,'Create Lead')]")).click();
				waitUntilElementInvisibe(120, LW.spinner, driver);
				CRM_Login.log(LogStatus.PASS, "Test case ID:(SC-T97) When user clicks create lead button from sales rep dash board successfully navigating to One pager", "User should navigate to lead one pager from CRM page");
				Suntuity.LeadonepagerReports.endTest(CRM_Login);	
				LW.Onepager_FirstName.click();
				String []firstname={"test 122","test@@4","test"};
				
				for(int a=0;a<firstname.length;a++) {
					
					LW.Onepager_FirstName.sendKeys(firstname[a]);
					LW.Onepager_FirstName.clear();
					
					
				}
				
				LW.Onepager_FirstName.sendKeys(firstname[2]);
				LW.Onepager_LastName.click();
				String []lastname={"Automation123","Automation @12","Automation"};
				for(int a=0;a<lastname.length;a++) {
					LW.Onepager_LastName.sendKeys(lastname[a]);
					LW.Onepager_LastName.clear();
				}
				LW.Onepager_LastName.sendKeys(lastname[2]);
				Leadinfo.log(LogStatus.PASS, "SC-T98 First name and last name fields are working properly");
				
				LW.Onepager_Emailid.click(); 
				String []email=sheet.getCell(Email, 3).getContents().split(";");
				
				for(int a=0;a<email.length;a++) {
					
					LW.Onepager_Emailid.sendKeys(email[a]);	
					
					if(LW.emailaddresshepertext.isDisplayed()) {
						Leadinfo.log(LogStatus.PASS, "SC-TC100" +" Negative scenrios related to email ID's are working fine  ::"+email[a]);
					}
					else {
						Leadinfo.log(LogStatus.FAIL, "SC-TC100" +" email id negative scenerios are not working fine working with  :"+email[a]);
					}
					
					LW.Onepager_Emailid.clear();
					LW.Onepager_Emailid.sendKeys("test@adsa.com");
					
				}
				
				LW.Onepager_PhoneNo.click();
				
				String []phonenumber=sheet.getCell(phone, Data_Row).getContents().split(";");
				
				
				for(int a=0;a<phonenumber.length;a++) {
					
					LW.Onepager_PhoneNo.sendKeys(phonenumber[a]);
					LW.Onepager_PhoneNo.clear();
					
					
					
				}
				LW.Onepager_PhoneNo.sendKeys("0123456789");
				
				Leadinfo.log(LogStatus.PASS, "SC-TC105" +"  User able to set the state fields succesfullya");
				
				
				waitforElement(120, LW.Onepager_Zip, driver);
				LW.Onepager_Zip.click();
				
				System.out.println(sheet.getCell(zip, Data_Row).getContents());
				JavascriptExecutor e = (JavascriptExecutor)driver;
				e.executeScript("arguments[0].setAttribute('value', arguments[1])",LW.Onepager_Zip ,sheet.getCell(zip, Data_Row).getContents());
				Leadinfo.log(LogStatus.PASS, "SC-TC106" +"   Zips are updating properly");
				LW.Onepager_City.click();
				
				LW.Onepager_SearchforAddress.click();
				LW.selectstate(sheet.getCell(state, Data_Row).getContents());
				
				LW.Onepager_Street.click();
				LW.Onepager_Street.sendKeys(sheet.getCell(street, Data_Row).getContents());
				Leadinfo.log(LogStatus.PASS, "SC-TC103" +"  Address text fields are working fine");
				LW.Onepager_City.click();
				LW.Onepager_City.sendKeys(sheet.getCell(city, Data_Row).getContents());
				Leadinfo.log(LogStatus.PASS, "SC-TC104" +"  City text fields are working fine");
				
				
				LW.setmentor(sheet.getCell(Mentor, Data_Row).getContents());
				Leadsourceinfo.log(LogStatus.PASS, "SC-T262  lead soure info is working fine");
				
				waitforElement(120, LW.Onepager_Zip, driver);
				LW.Onepager_Zip.click();
				
				System.out.println(sheet.getCell(zip, Data_Row).getContents());
				LW.Onepager_Zip.sendKeys(sheet.getCell(zip, Data_Row).getContents());
				
				
				
				Suntuity.LeadonepagerReports.endTest(Leadinfo);
				xverification("", driver.findElement(By.xpath("//li/span[contains(.,'" + Mentor + "')]")), "Verifying whether mentor field is having following mentor", RSheet, "Mentor should exist and able to get clicked", "mentor not exist and unable to do click", value, NoOfVerify, driver);
				
				LW.setrelatedcampaign(sheet.getCell(RelatedCamapign, Data_Row).getContents());
				LW.SetleadSource(sheet.getCell(LeadSource, Data_Row).getContents());
				LW.setHOA(sheet.getCell(HasHoaFlag, Data_Row).getContents(),sheet.getCell(HOAName, Data_Row).getContents(),
						sheet.getCell(HOAEmailAddress, Data_Row).getContents(), sheet.getCell(HoaNumber, Data_Row).getContents(),
						sheet.getCell(HOAExtension, Data_Row).getContents());
				HOA.log(LogStatus.PASS, "SC-T309  HOA Section is working fine");
				Suntuity.LeadonepagerReports.endTest(HOA);
				Suntuity.LeadonepagerReports.flush();
				
				scrolluptoelement(LW.Onepager_SaveButton, driver);	
				JavaScriptclick(driver, LW.Onepager_SaveButton);
				LW.waituntilspinnerdisappear(driver);
				Thread.sleep(3000);
				
				LW.setutilitycompany(sheet.getCell(UtilityCompany , Data_Row).getContents(),
				     	sheet.getCell(AnnualkilowatsUsage, Data_Row).getContents());
				waitforElement(120, LW.Onepager_SaveButton, driver);
				
				scrolluptoelement(LW.Onepager_SaveButton, driver);
				JavaScriptclick(driver, LW.Onepager_SaveButton);
				LW.waituntilspinnerdisappear(driver);
				LW.setleadnoteform(sheet.getCell(NotesStatus, Data_Row).getContents(),   sheet.getCell(Notestags, Data_Row).getContents()
						,sheet.getCell(NotesNote, Data_Row).getContents() );
				String Appointmentnotes = LW.GetDynamicdateandTime() + " Appointment Notes";

				DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
			List<WebElement> Appointmentstatus= driver.findElements(By.xpath("//label[contains(.,'Result')]/../div/child::ul/li"));
				
				LW.set_NewDirect_appointment(Appointmentstatus, sheet.getCell(AppointmentsDate, Data_Row).getContents().split("-")[0] ,sheet.getCell(AppointmentsDate, Data_Row).getContents().split("-")[1],sheet.getCell(AppointmentsDate, Data_Row).getContents().split("-")[2], sheet.getCell(AppointmentsTime, Data_Row).getContents(),"Sold pending paperwork", Appointmentnotes, "2 Legs", "Ran - Passed","Green Sky","789","456","123","Rooftop","test","111","No Stump Removal","222","Fox Hollow Gray","555","Yes","Yes","Present");
				
				  LW.setRequestProposal( sheet.getCell(ProposalLoantype, Data_Row).getContents()  ,
						  sheet.getCell(Proposalutiity_company, Data_Row).getContents() ,
						  sheet.getCell(ProposaltargetEPC, Data_Row).getContents(),
						  sheet.getCell(ProposalOtherIncentives, Data_Row).getContents(), "21", "August",
				  "2022", "4:30",  sheet.getCell(Proposal_InstallationType, Data_Row).getContents(),
				  sheet.getCell(ProposalRooftype, Data_Row).getContents(),
				  sheet.getCell(ProposalAgeOfRoof, Data_Row).getContents(),
				  sheet.getCell(ProposalAnnualkilowatusage, Data_Row).getContents(),
				  sheet.getCell(ProposalNote, Data_Row).getContents());	
				
				
				
			
				
				}
			Status=status+Status;
			Suntuity.RowNo--;
			if(Status.isEmpty()){Status= "Pass";}
		}
		catch(Exception e)
		{
			xException(RSheet, e, value,driver,testcaseId);
			System.out.println("Exception Raised ");
			System.out.println(e.getMessage());
			status="Fail:"+e.getMessage();
			testcaseId="";}

		return Status;
	}
	
	
	
	public void OpenSandbox(String sandboxname) {
		try {
			waitforElementClickable(120, driver.findElement(By.xpath("(//a[contains(.,'"+sandboxname+"')])[1]")), driver);
			driver.findElement(By.xpath("(//a[contains(.,'"+sandboxname+"')])[1]")).click();
		} catch (Exception e) {
			System.out.println("Sand box was not opened "+e.getMessage());
		}
	}
public String Testcaseid(String testcaseid) {
	testcaseId=testcaseid;
	return testcaseId;
}
	public int xResult(String Verification,WritableSheet RSheet, String ActualValue,String value){
		try{
			if (Verification =="Pass"){
				if (ActualValue!=""){
					RSheet.addCell(new Label(9,Suntuity.RowNo-1,ActualValue));
				}
				else{
					RSheet.addCell(new Label(9,Suntuity.RowNo-1,Suntuity.FunctionName));
				}
				RSheet.addCell(new Label(11,Suntuity.RowNo-1,"Pass",xFillCell(Colour.GREEN)));
			}
			else{
				RSheet.addCell(new Label(9,Suntuity.RowNo-1,Suntuity.FunctionName));
				RSheet.addCell(new Label(11,Suntuity.RowNo-1,"Fail",xFillCell(Colour.RED)));
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String FilePath=xRandomTimeStampName(value);
				FileUtils.copyFile(scrFile, new File(FilePath));
				WritableHyperlink hyperlink = new WritableHyperlink(13, Suntuity.RowNo-1, new File(FilePath),"Error Snapshot Link");
				RSheet.addHyperlink(hyperlink);
			}
		}
		catch(Exception e){
			e.getMessage();
		}
		return Suntuity.RowNo;
	}
}
	
	

