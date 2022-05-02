package source;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import suntuity.Leadonepagerfunctionallibraries.SuntuityBusinessFunctions;
import suntuity.Utilities.TestProperties;
import atu.testrecorder.ATUTestRecorder;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import suntuity.Utilities.UtilityScript;
import suntuity.testrun.beans.TestRunBean;

public class Suntuity extends UtilityScript {
	

	public static WebDriver driver;
	public static final String AUTOMATE_USERNAME = "saikrishnaadidam1";
	public static final String AUTOMATE_ACCESS_KEY = "ayvHpVyydUWhYsHn9N87";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	protected static TestProperties _properti5es = new TestProperties();
	private static Logger logger = Logger.getLogger("Suntuity");
	public static String resultWriteSheet;
	public static int RowNo = 0;
	public static String DataSetValue=null;
	public static String StepNo = null;	                                           
	public static String FunctionName = null;
	public static WritableSheet RSheet;
	public static WritableWorkbook resultWritebook;
	public static Workbook tempResultWorkbook;
	public static FirefoxProfile Prof;
	public static ATUTestRecorder recorder;
	
	public static ExtentReports LeadonepagerReports;
	public String Status;
	@BeforeClass(alwaysRun = true)
	protected void setUp() throws Exception {
		File directory = new File (".//");
		kill();
		CleanupfilesinFolder();	
		PropertyConfigurator.configure("config/log4j.properties");
		String Testruntype=testRunBean.getRunTestType();
		System.out.println("Run type is"+Testruntype);
		System.out.println("login started");
		LeadonepagerReports = new ExtentReports(xTestResult()+"\\"+"ExtentReportResults.html");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		switch(Testruntype) {
		case "Desktop_Web":
			String browser =xBrowser();
			
			switch(browser) {

	        case "Chrome":
	            caps.setCapability("os", "Windows");
	            caps.setCapability("os_version", "10");
	            caps.setCapability("browser", "Chrome");
	            caps.setCapability("browser_version", "89.0");
	            caps.setCapability("project", "Lead One Pager");
	            caps.setCapability("build", "LeadOnePager");
	            caps.setCapability("name", "LeadOnePagerwith-[Chrome]");
	            caps.setCapability("browser_version", "latest");
	            caps.setCapability("browserstack.local", "false");
	            caps.setCapability("browserstack.networkLogs", "true");
	        	caps.setCapability("browserstack.selenium_version", "3.13.0");
	        	caps.setCapability("browserstack.debug", "true");
	        	driver = new RemoteWebDriver(new URL(URL), caps); 
	        	driver.manage().deleteAllCookies();
	    		driver.manage().window().maximize();
	        	
	        	break;
	        case "Firefox": 
	        	caps.setCapability("os", "Windows");
	        	caps.setCapability("os_version", "10");
	        	caps.setCapability("browser", "Firefox");
	        	caps.setCapability("browser_version", "latest");
	        	caps.setCapability("project", "Lead One Pager");
	        	caps.setCapability("build", "LeadOnePager");
	        	caps.setCapability("name", "LeadOnePagerwith-[Firefox]");
	        	caps.setCapability("browserstack.local", "false");
	        	caps.setCapability("browserstack.networkLogs", "true");
	        	caps.setCapability("browserstack.selenium_version", "3.13.0");
	        	caps.setCapability("browserstack.debug", "true");
	        	 driver = new RemoteWebDriver(new URL(URL), caps);
	        	 driver.manage().deleteAllCookies();
	     		driver.manage().window().maximize();
	        	break;
	        	       
	        case "Safari":
	        	caps.setCapability("os", "OS X");
	        	caps.setCapability("os_version", "Catalina");
	        	caps.setCapability("browser", "Safari");
	        	caps.setCapability("browser_version", "13.0");
	        	caps.setCapability("project", "Lead One Pager");
	        	caps.setCapability("build", "LeadOnePager");
	        	caps.setCapability("name", "LeadOnePagerwith- [Safari]");
	        	caps.setCapability("browserstack.local", "false");
	        	caps.setCapability("browserstack.networkLogs", "true");
	        	caps.setCapability("browserstack.selenium_version", "3.13.0");
	        	caps.setCapability("browserstack.debug", "true");
	        	 driver = new RemoteWebDriver(new URL(URL), caps);
	        	 driver.manage().deleteAllCookies();
	     		driver.manage().window().maximize();
	        	break;
			}
			break;
		case "Mobile_Web":
			switch(testRunBean.getMobileOS()) {	
		case "Android":
			switch(testRunBean.getAndroidDevice()) {
			case"Samsung S10":		
				caps.setCapability("os_version", "9.0");
				caps.setCapability("device", "Samsung Galaxy S10");
				caps.setCapability("project", "Suntuity ");
				caps.setCapability("build", "Mobile One pager on Samsung S10");
				caps.setCapability("name", "lead one pager");
				caps.setCapability("browserstack.idleTimeout", "300");
				caps.setCapability("automationName", "Appium");
				caps.setCapability("browserstack.idleTimeout", "120");
				caps.setCapability("browserstack.acceptInsecureCerts", "true");
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability("browserstack.networkLogs", "true");
				caps.setCapability("browserstack.networkProfile", "4g-lte-high-latency");
				 driver = new RemoteWebDriver(new URL(URL), caps);
				break;
			case "Samsung S20":
				caps.setCapability("os_version", "11.0");
				caps.setCapability("device", "Samsung Galaxy S20");
				caps.setCapability("project", "Suntuity ");
				caps.setCapability("build", "Mobile One pager on Samsung S20");
				caps.setCapability("name", "lead one pager");
				caps.setCapability("browserstack.idleTimeout", "300");
				caps.setCapability("browserstack.idleTimeout", "120");
				caps.setCapability("browserstack.acceptInsecureCerts", "true");
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability("browserstack.networkLogs", "true");
				caps.setCapability("browserstack.networkProfile", "4g-lte-high-latency");
				driver = new RemoteWebDriver(new URL(URL), caps);
				break;
			case "Google Pixel 3":
				// Use Java Client v6.0.0 or above
				caps.setCapability("os_version", "9.0");
				caps.setCapability("device", "Google Pixel 3");
				caps.setCapability("project", "Suntuity ");		
				caps.setCapability("build", "Mobile One pager on google pixel 3");
				caps.setCapability("name", "lead one pager");
				caps.setCapability("browserstack.idleTimeout", "300");			
				caps.setCapability("browserstack.idleTimeout", "120");
				caps.setCapability("browserstack.acceptInsecureCerts", "true");
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability("browserstack.networkLogs", "true");
				caps.setCapability("browserstack.networkProfile", "4g-lte-high-latency");
				driver = new RemoteWebDriver(new URL(URL), caps);
				break;
			}
			break;
			
		case"IOS":
		switch(testRunBean.getIOSDevice()) {
		case"IPhone X":
			caps.setCapability("os_version", "11");
			caps.setCapability("device", "iPhone X");
			caps.setCapability("project", "Suntuity ");
			caps.setCapability("build", "Mobile One pager on iphone X");
			caps.setCapability("name", "lead one pager");
			caps.setCapability("browserstack.idleTimeout", "300");
			caps.setCapability("browserstack.idleTimeout", "120");
			caps.setCapability("browserstack.acceptInsecureCerts", "true");
			caps.setCapability("browserstack.debug", "true");
			caps.setCapability("browserstack.networkLogs", "true");
			caps.setCapability("browserstack.networkProfile", "4g-lte-high-latency");
			 driver = new RemoteWebDriver(new URL(URL), caps);	
			break;
		}
			break;
			
			}	
		}
		if(TestNGRunflag == true){
			testRunBean.getLoadingPanel().setVisible(false);
			}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass(alwaysRun = true)
	protected void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void Test() throws Exception,InterruptedException {
		int currenthour=0;
		
		SuntuityBusinessFunctions SuntuityBusinessFunction=new SuntuityBusinessFunctions(driver);
		String TestSuiteName = xTestSuite();
		MethodName = MethodName + TestSuiteName; //Used while sending email to report the test cases executed
		Method = TestSuiteName; //Used while sending email to report the test cases executed
		Print("Start:" + xGetDateTimeIP());
		String DataTime = xGetDateTime();
		String TestPath = xTestPath();
		String ResultPath = xTestResult();
		File targetFile = null;
		File fileExisting = new File(ResultPath+"\\"+TestSuiteName+"_Result.xls");  
		if (fileExisting.exists()){
			Path RSource = Paths.get(ResultPath+"\\"+TestSuiteName+"_Result.xls");
			Path RTarget= Paths.get(ResultPath+"\\"+TestSuiteName+"_Result_"+DataTime+".xls");
			Files.copy(RSource, RTarget);
		}
		File fileExisting_Temp = new File(ResultPath+"\\"+TestSuiteName+"_ResultTemp.xls");  
		if (fileExisting_Temp.exists()){
			Path RSource = Paths.get(ResultPath+"\\"+TestSuiteName+"_ResultTemp.xls");
			Path RTarget= Paths.get(ResultPath+"\\"+TestSuiteName+"_ResultTemp_"+DataTime+".xls");
			Files.copy(RSource, RTarget);
		}

		Path source = Paths.get(TestPath);
		Path target = Paths.get(ResultPath+"\\"+TestSuiteName+"_Result.xls");
		Files.copy(source, target,REPLACE_EXISTING);
		Workbook DriverscriptWorkbook =Workbook.getWorkbook(new File(TestPath));
		resultWritebook = Workbook.createWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"));
		WritableSheet resultWriteSheet = resultWritebook.createSheet("Results",0);
		RSheet = resultWritebook.createSheet("TestSteps",1);
		Sheet testscriptSheet = DriverscriptWorkbook.getSheet("TestScript");
		Sheet teststeps=DriverscriptWorkbook.getSheet("TestSteps");
		int startRow, startCol, endRow, endCol,Rcol, totalCols;
		String  temp = null,temp2 = null, property = null, Action = null, expectedResult = null,value = null,xPath = null,Error =null,Function = null,SKIPValue =null,HandleBefore = null, iFailedTestCases="", Dataset_Number=""; 
		int iTotalTestCasesToBeExecuted=0,iTestCaseExecuting=0,iTotalPassed=0,iTotalFailed=0,Datacount=0;
		totalCols = testscriptSheet.getColumns();
		Cell tableStart= testscriptSheet.findCell("TestScriptStart");
		startRow=tableStart.getRow();
		startCol=tableStart.getColumn();	
		Cell tableEnd= testscriptSheet.findCell("TestScriptEnd", startCol,startRow, 100, 64000,  false);
		endRow=tableEnd.getRow();
		endCol=tableEnd.getColumn();
		resultWriteSheet.addCell(new Label(0,0,"DataSetNo",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(1,0,"StepNo",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(2,0,"PageName",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(3,0,"Property",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(4,0,"FieldName",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(5,0,"xPath",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(6,0,"Value",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(7,0,"ExpectedResult",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(8,0,"Action",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(9,0,"ActualResult",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(10,0,"Testcase ID",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(11,0,"Result",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(12,0,"Error",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(13,0,"Error Snapshot",xFillCell(Colour.GRAY_50)));
		resultWriteSheet.addCell(new Label(14,0,"Start Time",xFillCell(Colour.YELLOW2)));
		resultWriteSheet.addCell(new Label(15,0,"End Time",xFillCell(Colour.YELLOW2)));
		resultWriteSheet.addCell(new Label(16,0,"Total Time",xFillCell(Colour.YELLOW2)));

		RowNo=1;
		String StartTime = xGetCurrentTime();
		Print("Start Time:" + StartTime);
		resultWriteSheet.addCell(new Label(14,1,StartTime));
		
		resultWritebook.write();
		resultWritebook.close();

		int[] x= xDatasetno();
		if(x != null){
			int dtarr=0;
			while(dtarr < x.length ){
				int dcol=x[dtarr];
				DataSetValue =testscriptSheet.getCell(dcol,1).getContents();
				dtarr++;
				iTotalTestCasesToBeExecuted++;
			}
		}else {
			for (int dcol=16,dtarr=0;dcol<totalCols||dtarr<Datacount;dcol++,dtarr++){
				String GetYes = testscriptSheet.getCell(dcol,startRow+1).getContents();  
				if (GetYes.equalsIgnoreCase("YES")){
					iTotalTestCasesToBeExecuted++;
				}
			}
		}
		for (int dcol=16,dtarr=0;dcol<totalCols||dtarr<Datacount;dcol++,dtarr++)
		{
			String ab ="";
			try {if(xDatasetno()!=null){
				int[] Rdts = xDatasetno(); Datacount=Rdts.length;dcol=Rdts[dtarr];}
			DataSetValue =testscriptSheet.getCell(dcol,1).getContents();
			String DataName = testscriptSheet.getCell(dcol,0).getContents();
			//parent=extent.startTest(DataName);
			} 
			catch (Exception e) {
				try {if(Datacount==dtarr){break;}}
				catch (Exception e1) {Error= e1.getMessage();}
				Error= e.getMessage();}

			try {
			String DataSkip;
			DataSkip = testscriptSheet.getCell(dcol,2).getContents();
			DataSkip = DataSkip.toUpperCase();
			if(DataSkip.equals("NO")){
				continue;
			} 
			boolean ispassed=true;
			if(DataSetValue.equals(null)||DataSetValue == ""){
				break;
				}
			else
			{
				Dataset_Number = testscriptSheet.getCell(dcol,startRow).getContents();
				iTestCaseExecuting++;

				TestCaseLoop:
					for (int i=startRow+1;i<endRow;i++){
						Rcol =0;
						StepNo=testscriptSheet.getCell(endCol-8,i).getContents();
						SKIPValue=testscriptSheet.getCell(dcol,i).getContents();
						if(StepNo.contains("?")==false){
							if(SKIPValue.contentEquals("SKIP")==false){

								//*****WRITING RESULTS FOR EACH & EVERY METHOD******
								try{
									tempResultWorkbook = Workbook.getWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"));
									resultWritebook = Workbook.createWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"), tempResultWorkbook);
									resultWriteSheet = resultWritebook.getSheet("Results");}
								catch(Exception excel){
								}

								for (int j=startCol+1;j<endCol;j++,Rcol++){
									if (Rcol==0){resultWriteSheet.addCell(new Label(Rcol,RowNo,DataSetValue)); j = j-1;}
									else if(Rcol==6){temp =testscriptSheet.getCell(dcol,i).getContents();
									resultWriteSheet.addCell(new Label(Rcol,RowNo,temp));j = j-1;}
									else {temp2 =testscriptSheet.getCell(j,i).getContents();
									resultWriteSheet.addCell(new Label(Rcol,RowNo,temp2));}
								}
								RowNo++;
							}}
						property=testscriptSheet.getCell(endCol-5,i).getContents();
						xPath=testscriptSheet.getCell(endCol-4,i).getContents();
						value=testscriptSheet.getCell(dcol,i).getContents();
						expectedResult=testscriptSheet.getCell(endCol-3,i).getContents();
						Action=testscriptSheet.getCell(endCol-2,i).getContents();
						FunctionName = testscriptSheet.getCell(endCol-1,i).getContents();
						String[] fName = value.split(";");
						FunctionName = fName[0];
						property = property.toUpperCase();
						String TempValue = value.toUpperCase();
						Action = Action.toUpperCase();
						if((StepNo.contains("?"))||(TempValue.equals("SKIP"))){
							Action = "SKIP";
							}
						String appname="";
						switch(appname) {
						case"Onepager":
						switch(Action){
						case "OPEN":
							if(property.equals("PAGETITLE")){
								try {
									ispassed=ispassed&true; 
									if(value.equals("")){ 
										value = xEnvironment();}
									resultWriteSheet.addCell(new Label(6,RowNo-1,value));
									//driver.manage().deleteAllCookies();									
									driver.get(value);
									logger.debug("User navigating to the URL");
									resultWriteSheet.addCell(new Label(11,RowNo-1,"Pass", xFillCell(Colour.GREEN)));
									HandleBefore = driver.getWindowHandle();
									driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
									}
								catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("User not navigating to the URL");
									Error= e.getMessage();
									try{
										xCatchexception(resultWriteSheet, RowNo, Error);
									}
									catch(Exception e1){
										xCatchexception(resultWriteSheet, RowNo, Error);
									}
									xResult(driver,resultWriteSheet, value);	
									break TestCaseLoop;
								}}
							break;
						case "TYPE":
							if(property.equals("TEXTFIELD")||property.equals("INPUT")){try {
								ispassed=ispassed&true;
								String[] Data = value.split(";");
								if (Data.length >1){if (Data[1].equals("RND")){value=Data[0]+RND()+Data[2];
								resultWriteSheet.addCell(new Label(6,RowNo-1,value));}}
								driver.findElement(By.xpath(xPath)).sendKeys(value);
								logger.debug("User Type the text into the Inputbox/Textfield");
								resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass", xFillCell(Colour.GREEN)));}
							catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not Type the text into the Inputbox/Textfield");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}}			
							break;
						case "CLICK":	
							if(property.equals("LINK")||property.equals("A")){try {
								ispassed=ispassed&true;
								driver.findElement(By.xpath(xPath)).click();
								logger.debug("User clickd on the link/anchor tag link");
								resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass", xFillCell(Colour.GREEN)));
							} catch (Exception e) {
								try{
									ispassed=ispassed&true;
									driver.findElement(By.linkText(xPath)).click();
									logger.debug("User clickd on the link/anchor tag link");
								}catch (Exception e1) {
									ispassed=ispassed&false;
									logger.debug("User not clickd on the link/anchor tag link");
									Error= e1.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}}}
							if(property.equals("BUTTON")){
								ispassed=ispassed&true;
								try {driver.findElement(By.xpath(xPath)).click();logger.debug("User clickd on the button");}
								catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("User not clickd on the button");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}}
							if(property.equals("RADIOBUTTON")){
								try {ispassed=ispassed&true; driver.findElement(By.xpath(xPath)).click();logger.debug("User clickd on the radio button");resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass", xFillCell(Colour.GREEN)));}
								catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("User not clickd on the button");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}}
							if(property.equals("CHECKBOX")){try {
								ispassed=ispassed&true;
								driver.findElement(By.xpath(xPath)).click();
								logger.debug("User check the check box");
								resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass", xFillCell(Colour.GREEN)));
							} catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not check the check box");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}}
							break;
						case "SELECT":
							if(property.equals("COMBOBOX")||property.equals("SELECT")){
								try {ispassed=ispassed&true;
								Select selectbox = new Select(driver.findElement(By.xpath(xPath)));
								selectbox.selectByVisibleText(value);
								logger.debug("User select the value from Combobox/Listbox");
								resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass", xFillCell(Colour.GREEN)));
								} catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("User not select the value from Combobox/Listbox");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}}
							break;
						case "DRAGANDDROP":
							if(property.equals("DRAGOBJECT")){try {
								ispassed=ispassed&true;
								String[] str_array = xPath.split(",");
								String Src = str_array[0];
								String Trg = str_array[1];		
								WebElement objsource = driver.findElement(By.xpath(Src));
								WebElement objtarget = driver.findElement(By.xpath(Trg));
								(new Actions(driver)).dragAndDrop(objsource, objtarget).perform();
								logger.debug("User Drag and Drop the WebElement from source to destination");
							} catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not Drag and Drop the WebElement from source to destination");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}}
							break;
						case "CSVComparision":
							if(property.equals("DRAGOBJECT")){try {
								ispassed=ispassed&true;
								String[] str_array = xPath.split(",");
								String Src = str_array[0];
								String Trg = str_array[1];		
								WebElement objsource = driver.findElement(By.xpath(Src));
								WebElement objtarget = driver.findElement(By.xpath(Trg));
								(new Actions(driver)).dragAndDrop(objsource, objtarget).perform();
								logger.debug("User Drag and Drop the WebElement from source to destination");
							} catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not Drag and Drop the WebElement from source to destination");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}}
							break;
						case "VERIFY":
							switch(property){
							case "NOTPRESENT":
								try {ispassed=ispassed&true;
								if(!driver.findElement(By.xpath(xPath)).isDisplayed()){ ispassed=ispassed&true;logger.debug("Webelement not present in the page");resultWriteSheet.addCell(new Label(9,RowNo-1,driver.findElement(By.xpath(xPath)).getText()));resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass",xFillCell(Colour.GREEN)));}else{ ispassed=ispassed&false;resultWriteSheet.addCell(new Label(9,RowNo-1,driver.findElement(By.xpath(xPath)).getText()));resultWriteSheet.addCell(new Label(10,RowNo-1,"Fail", xFillCell(Colour.RED)));}
								}catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("Webelement present in the page");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
								break;
							case "PAGETITLE":
								try {
									if(driver.getTitle().equals(expectedResult)){ 
										ispassed=ispassed&true;
										logger.debug("Actual and Expected Page Title match");
										resultWriteSheet.addCell(new Label(9,RowNo-1,driver.getTitle()));
										resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass",xFillCell(Colour.GREEN)));
									}else { 
										ispassed=ispassed&false;
										resultWriteSheet.addCell(new Label(9,RowNo-1,driver.getTitle()));
										resultWriteSheet.addCell(new Label(11,RowNo-1,"Expected and Actual Title does not match"));
										resultWriteSheet.addCell(new Label(10,RowNo-1,"Fail", xFillCell(Colour.RED)));
										logger.debug("Actual and Expected Page Title does not match");
										xResult(driver,resultWriteSheet, value);
									}
								}catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("Actual and Expected Page Title does not match");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
								break;
							case "LINK":
								try {
									if(driver.findElement(By.xpath(xPath)).isDisplayed()){ispassed=ispassed&true; logger.debug("Webelement Link present in the page");resultWriteSheet.addCell(new Label(9,RowNo-1,driver.findElement(By.xpath(xPath)).getText()));resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass",xFillCell(Colour.GREEN)));}else{ispassed=ispassed&false;resultWriteSheet.addCell(new Label(9,RowNo-1,driver.findElement(By.xpath(xPath)).getText()));resultWriteSheet.addCell(new Label(10,RowNo-1,"Fail", xFillCell(Colour.RED)));}
								} catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("Webelement link not present in the page");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
								break;
							case "LABEL":
								try {
									if(driver.findElement(By.xpath(xPath)).isDisplayed())
									{ispassed=ispassed&true;logger.debug("Lable present in the page");resultWriteSheet.addCell(new Label(9,RowNo-1,driver.findElement(By.xpath(xPath)).getText()));
									resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass", xFillCell(Colour.GREEN)));}
								} catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("Lable not present in the page");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
								break;
							case "BUTTON":
								try {
									if(driver.findElement(By.xpath(xPath)).isDisplayed()){ispassed=ispassed&true;logger.debug("Button present in the page");resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass",xFillCell(Colour.GREEN)));}else {ispassed=ispassed&false;resultWriteSheet.addCell(new Label(10,RowNo-1,"Fail",xFillCell(Colour.RED)));}
								}catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("Button present in the page");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
								break;
							case "RADIOBUTTON":
								try {
									if(driver.findElement(By.xpath(xPath)).isDisplayed()){ispassed=ispassed&true;logger.debug("Radio Button present in the page");resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass",xFillCell(Colour.GREEN)));}else {ispassed=ispassed&false;resultWriteSheet.addCell(new Label(10,RowNo-1,"Fail",xFillCell(Colour.RED)));}
								}catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("Radio Button not present in the page");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
								break;
							case "CHECKBOX":
								try {
									if(driver.findElement(By.xpath(xPath)).isDisplayed()){ispassed=ispassed&true;logger.debug("Checkbox present in the page");resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass",xFillCell(Colour.GREEN)));}else {ispassed=ispassed&false;resultWriteSheet.addCell(new Label(10,RowNo-1,"Fail",xFillCell(Colour.RED)));}
								}catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("Checkbox not present in the page");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
								break;
							case "TEXTFIELD":
								try {
									if(driver.findElement(By.xpath(xPath)).isDisplayed()){ispassed=ispassed&true;logger.debug("TextField present in the page");resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass",xFillCell(Colour.GREEN)));}else {ispassed=ispassed&false;resultWriteSheet.addCell(new Label(10,RowNo-1,"Fail",xFillCell(Colour.RED)));}
								}catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("TextField not present in the page");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
								break;
							case "SELECT":
								try {
									if(driver.findElement(By.xpath(xPath)).isDisplayed()){ispassed=ispassed&true;logger.debug("Dropdown/ComboBox/ListBox present in the page");resultWriteSheet.addCell(new Label(10,RowNo-1,"Pass",xFillCell(Colour.GREEN)));}else {ispassed=ispassed&false;resultWriteSheet.addCell(new Label(10,RowNo-1,"Fail",xFillCell(Colour.RED)));}
								}catch (Exception e) {
									ispassed=ispassed&false;
									logger.debug("Dropdown/ComboBox/ListBox not present in the page");
									Error= e.getMessage();
									xCatchexception(resultWriteSheet, RowNo, Error);
									xResult(driver,resultWriteSheet, value);
									break;
								}
							}
							break;
						case "SWITCHTO":
							if(property.equals("IFRAME")){try {
								ispassed=ispassed&true;
								WebElement iframe=driver.findElement(By.tagName("iframe"));
								driver.switchTo().frame(iframe);
								logger.debug("Switch to Frame Successfully");
							}catch (Exception e) { 
								ispassed=ispassed&false;
								logger.debug("Switch to Frame not Successfully");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}}
							if(property.equals("POPUP")){try {
								ispassed=ispassed&true;
								for (String handle : driver.getWindowHandles()) {
									if(!handle.equals(HandleBefore)){
										driver.switchTo().window(handle);
										break;}
								}
								logger.debug("Switch to Window Successfully");
							}catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("Switch to Window not Successfully");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}}
							break;
						case "CALL":
							String status = null;
							Function = FunctionName.toUpperCase();
							//child = extent.startTest(Function);
							System.out.println("Present executing method "+Function);
							Cell check= testscriptSheet.findCell("TestScriptStart");
							
							
							
							switch(Function){
							case"LOGIN":
								status = SuntuityBusinessFunction.Login(resultWriteSheet, value);
								if (status =="Pass"){ispassed=ispassed&true; logger.debug("Login functionality working successfully");}else{ispassed=ispassed&false; logger.debug("Login functionality is not working Properly");}
								SuntuityBusinessFunction.xResult(status, resultWriteSheet, "", value);	
								break;
							case"LEADONEPAGER":
								status = SuntuityBusinessFunction.Leadonepager(resultWriteSheet, value);
								if (status =="Pass"){ispassed=ispassed&true; logger.debug("Lead one pager is Working");}else{ispassed=ispassed&false; logger.debug("Lead one pager functionality not working");}
								SuntuityBusinessFunction.xResult(status, resultWriteSheet, "", value);
								break;
							}
							/*
							 * case "WAIT": Thread.sleep(Integer.parseInt(value)); break;
							 */
						case "SWITCHBACK":
							if(property.equals("IFRAME")){driver.switchTo().defaultContent();logger.debug("User Switch back to main frame");}
							if(property.equals("POPUP")){
								for (String handle : driver.getWindowHandles()) {
									if(handle.equals(HandleBefore)){
										driver.switchTo().window(handle);
										break;}
								}logger.debug("User Switch back to parent window");}
							break;
						case "SKIP":
							break;
						case "RUN":
							break;
						case "SCREENSHOT":
							xResult(driver,resultWriteSheet, value);
							break;
						
						
						case "ENTER":
							try {
								ispassed=ispassed&true;
								driver.findElement(By.xpath(xPath)).sendKeys(Keys.RETURN);
								logger.debug("User able to return the webelement value");
							}catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not able to return the webelement value");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}
							break;
						case "KEYDOWN":
							try {
								ispassed=ispassed&true;
								driver.findElement(By.xpath(xPath)).sendKeys(Keys.DOWN);
								logger.debug("User able to keydown the webelement value");
							}catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not able to keydown the webelement value");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}
							break;
						case "NEWTAB":
							try {
								ispassed=ispassed&true;
								driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
								driver.switchTo().window(value);
								logger.debug("User able to control/open the new tab");
							}catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not able to control/open the new tab");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}
							break;
						case "CTRLTAB":
							try {
								ispassed=ispassed&true;
								String ctrltab = Keys.chord(Keys.CONTROL,Keys.TAB);
								driver.findElement(By.cssSelector("body")).sendKeys(ctrltab);
								driver.switchTo().window(value);
								logger.debug("User able to control/open the new tab");
							}catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not able to control/open the new tab");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}
							break;
						case "CLEAR":
							try {
								ispassed=ispassed&true;
								driver.findElement(By.xpath(xPath)).clear();
								logger.debug("User able to clear the data inside the inputbox");
							}catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not able to clear the data inside the inputbox");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}
							break;
						case "DOUBLECLICK":
							try {
								ispassed=ispassed&true;
								Actions userAction = new Actions(driver);
								WebElement Element = driver.findElement(By.xpath(xPath));
								userAction.doubleClick(Element).build().perform();
								logger.debug("User able to Double Click on WebElement");
							}catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not able to Double Click on WebElement");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}
							break;
						case "MOUSEOVER":
							try {
								ispassed=ispassed&true;
								Actions builder = new Actions(driver);
								WebElement tagElement = driver.findElement(By.xpath(xPath));
								builder.moveToElement(tagElement).build().perform();
								logger.debug("User able to MouseHover on WebElement");
							}catch (Exception e) {
								ispassed=ispassed&false;
								logger.debug("User not able to MouseHover on WebElement");
								Error= e.getMessage();
								xCatchexception(resultWriteSheet, RowNo, Error);
								xResult(driver,resultWriteSheet, value);
								break;
							}
							break;
						}
						break;
						
						case"Enerflo":
							
							
							
							break;
						
						
						}
						if(!Action.equalsIgnoreCase("SKIP")){
							try{
								String EndTime = xGetCurrentTime();
								String TotalTime = xTotalExecutionTime(StartTime,EndTime);
								resultWriteSheet.addCell(new Label(15,1,EndTime));
								resultWriteSheet.addCell(new Label(16,1,TotalTime));
								resultWritebook.write();
								resultWritebook.close();
								//******COPYING THE FILE TO RESULT TEMP FILE****
								String srcfile = ResultPath+"\\"+TestSuiteName+"_Result.xls";
								String destfile = ResultPath+"\\";
								File sourceFile = new File(srcfile);
								targetFile = new File(destfile+TestSuiteName+"_ResultTemp.xls");
								if(targetFile.exists()){
									targetFile.delete();
								}
								//copy file and paste with another name
								FileUtils.copyFile(sourceFile, targetFile);
								tempResultWorkbook = Workbook.getWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"));
								resultWritebook = Workbook.createWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"), tempResultWorkbook);
								resultWriteSheet = resultWritebook.getSheet("Results");
								resultWritebook.write();
								resultWritebook.close();
							}
							catch(Exception e){
							}
						}
					}
			}
 			if (ispassed){
				iTotalPassed++;
			}else {
				iTotalFailed++;
				iFailedTestCases=iFailedTestCases + Dataset_Number + ";";
			}
			if (iFailedTestCases.isEmpty()) {
				RunTimeTestCaseStatus(iTestCaseExecuting,iTotalTestCasesToBeExecuted,iTotalPassed,iTotalFailed,"0");							
			} else {
				RunTimeTestCaseStatus(iTestCaseExecuting,iTotalTestCasesToBeExecuted,iTotalPassed,iTotalFailed,iFailedTestCases);
			}
			}
		
			catch (Exception e) {
				Error= e.getMessage();
				logger.error(Error);
				resultWritebook.write();
				resultWritebook.close();
				String EndTime = xGetCurrentTime();
				Print("End Time:" + EndTime);
				String TotalTime = xTotalExecutionTime(StartTime,EndTime);
				Print("Total Execution Time:" + TotalTime);
				tempResultWorkbook = Workbook.getWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"));
				resultWritebook = Workbook.createWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"), tempResultWorkbook);
				resultWriteSheet = resultWritebook.getSheet("Results");
				resultWriteSheet.addCell(new Label(15,1,EndTime));
				resultWriteSheet.addCell(new Label(16,1,TotalTime));
				resultWritebook.write();
				resultWritebook.close();
				if(targetFile.exists()){
					targetFile.delete();
				}
			}
		}
		/*if(Status.isEmpty()){
		parent.log(LogStatus.PASS, "Pass");
		//test.log(LogStatus.PASS,"Pass");
	}
	else{
		parent.log(LogStatus.FAIL, "Fail");
		//test.log(LogStatus.FAIL,"Fail");

	}
	extent.flush();*/
		String EndTime = xGetCurrentTime();
		Print("End Time:" + EndTime);
		String TotalTime = xTotalExecutionTime(StartTime,EndTime);
		Print("Total Execution Time:" + TotalTime);
		System.out.println(ResultPath+"\\"+TestSuiteName+"_Result.xls");
	try {
		tempResultWorkbook = Workbook.getWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"));
		resultWritebook = Workbook.createWorkbook(new File(ResultPath+"\\"+TestSuiteName+"_Result.xls"), tempResultWorkbook);
		resultWriteSheet = resultWritebook.getSheet("Results");
		resultWriteSheet.addCell(new Label(15,1,EndTime));
		resultWriteSheet.addCell(new Label(16,1,TotalTime));
		resultWritebook.write();
		resultWritebook.close();
		if(targetFile.exists()){
			targetFile.delete();
		}
	}
	catch(Exception e) {
	e.printStackTrace();
		
	}
	}

	
	
	
	

}
