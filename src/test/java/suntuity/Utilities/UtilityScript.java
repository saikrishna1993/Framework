package suntuity.Utilities;


import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.util.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import jxl.*;
import jxl.format.Colour;
import jxl.format.Pattern;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import source.Suntuity;

import javax.imageio.*;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty7.util.ajax.JSON;
import org.testng.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.google.common.base.Joiner;
import com.google.gson.JsonArray;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



import suntuity.testrun.beans.TestRunBean;
import suntuity.Utilities.TestProperties;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class UtilityScript extends TestData{

	public String NewFileNamePath;
	public static String Cell_Value;
	public static String returnvalue;
	public static String Filingfreq;
	public static String Cell_Header;
	public static String CategoryType;
	public static String Col_Row_Content;
	private static String TSETUP = null;
	public static String processName;
	public static String processName1;
	public static String processName2;
	public static String processName3;
	protected static TestProperties _properties = new TestProperties();
	private static SecureRandom random = new SecureRandom();
	public static String  DownloadedFileName;
	public static String Filepath;
	public static String BillAmount;
	public static Date TestEndDate;
	protected static TestRunBean testRunBean;
	
	Calendar cal = Calendar.getInstance();
	public static String listoffiles="";
	public static CSVReader reader;
	public static CSVWriter csvOutput;
	public static ATUTestRecorder recorder;
	public static String FileName;
	public static boolean TestNGRunflag = false;
	public static String gettestruntype="";
	//Creating the JavascriptExecutor interface object by Type casting		
    public static JavascriptExecutor js = (JavascriptExecutor)Suntuity.driver;

	// To kill the process in Task Manager
	public void kill() throws Exception
	{
		processName ="iexplore.exe";
		processName1="IEDriverServer.exe";
		processName2="chromedriver.exe";
		processName3="EXCEL.EXE";
		if (isRunning())
		{
			getRuntime().exec("taskkill /F /IM " + processName);
			getRuntime().exec("taskkill /F /IM " + processName1);
			getRuntime().exec("taskkill /F /IM " + processName2);
			getRuntime().exec("taskkill /F /IM " + processName3);
		}
	}

	private boolean isRunning() throws Exception
	{
		Process listTasksProcess = getRuntime().exec("tasklist");
		BufferedReader tasksListReader = new BufferedReader(
				new InputStreamReader(listTasksProcess.getInputStream()));

		String tasksLine;

		while ((tasksLine = tasksListReader.readLine()) != null)
		{
			if (tasksLine.contains(processName3) ||tasksLine.contains(processName) || tasksLine.contains(processName1)||tasksLine.contains(processName2)) //matches(processName))
			{
				return true;
			}
		}

		return false;
	}

	private Runtime getRuntime()
	{
		return Runtime.getRuntime();
	}

	// Get date time
	public java.lang.String xGetDateTime() throws Exception {
		// get current date time with Date() to create unique file name
		DateFormat dateFormat = new SimpleDateFormat("hh_mm_ssaadd_MMM_yyyy");
		// get current date time with Date()
		Date date = new Date();
		return (dateFormat.format(date));
	}

	// DateFormat = "MM/dd/yyyy '-' h:mm a";
	public java.lang.String xGetDTAP() throws Exception {
		Date dNow = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy '-' h:mm a");
		//System.out.println("Current Date: " + ft.format(dNow));
		return (ft.format(dNow));
	}

	// DateFormat = "MMM dd, yyyy";
	public java.lang.String xGetDate(String DateFormat) throws Exception {
		// get current date time with Date() to create unique file name
		DateFormat dateFormat = new SimpleDateFormat(DateFormat);
		// get current date time with Date()
		Date date = new Date();
		return (dateFormat.format(date));
	}

	// Get date time with SelText
	public java.lang.String xGetDateTimeSel() throws Exception {
		// get current date time with Date() to create unique file name
		DateFormat dateFormat = new SimpleDateFormat("hh_mm_ssaadd_MMM_yyyy");
		// get current date time with Date()
		Date date = new Date();
		return ("S_" + dateFormat.format(date));
	}

	public java.lang.String xPreviousDate(String DateFormat) throws Exception {
		// get current date time with Date() to create unique file name
		DateFormat dateFormat = new SimpleDateFormat(DateFormat);
		// get current date time with Date()
		cal.add(Calendar.DATE, -1);
		return (dateFormat.format(cal.getTime()));
	}

	// Get date time with System IP
	public java.lang.String xGetDateTimeIP() throws Exception {
		// get current date time with Date() to create unique file name
		DateFormat dateFormat = new SimpleDateFormat("hh_mm_ssaa_dd_MMM_yyyy");
		// get current date time with Date()
		Date date = new Date();
		// To identify the system
		InetAddress ownIP = InetAddress.getLocalHost();
		return (dateFormat.format(date) + "_IP" + ownIP.getHostAddress());
	}

	//Get date time sec stamp
	public static String RND() throws Exception {
		String DTStamp = (((new Date()).getMonth())+1)+((new Date()).getDate())+((new Date()).getYear())+""+((new Date()).getHours())+((new Date()).getMinutes())+((new Date()).getSeconds());
		return (DTStamp);
	}

	//Get browser to run the test
	public static String xBrowser() throws Exception {
		String browser=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		if(TestNGRunflag == true){
		switch(testRunBean.getRunTestType()) {
        case "Desktop_Web":
        	browser =testRunBean.getBrowserAndVersion();
        	
			break;
		case "Mobile_Web":
			if(testRunBean.getMobileOS().equals("Android")) {
			
				browser="Chrome";
			}
			else {
				browser="Safari";
			}
			break;
		}
	}
		//logic should change 
		if(TestNGRunflag == true){
			browser =testRunBean.getBrowserAndVersion();
		}else{
			browser = sheet.getCell(1,6).getContents(); 
		}  
		return (browser);
	}

	public static String xNode() throws Exception {
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		String Node = sheet.getCell(1,22).getContents();
		return (Node);
	}

	
	//Get Testpath to run the test
	public static String xTestPath() throws Exception {
		String TestScript=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		File directory = new File(".//");
		String TestLoc = directory.getCanonicalPath();
		if(TestNGRunflag == true){
			TestScript = testRunBean.getTestScriptFilepathAndName();
		}else{TestScript = sheet.getCell(1,11).getContents();}
		String TestPath = TestLoc+"\\"+"TestScripts"+"\\"+TestScript;
		return (TestPath);
	}

	//Get TestResult to run the test
	public static String xTestResult() throws Exception {
		String TestResult=null;
		File directory = new File(".//");
		String ResultLoc = directory.getCanonicalPath();		 
		TestResult= ResultLoc+"\\"+"Result";
		return (TestResult);
	}

	//Get TestSuite name
	public static String xTestSuite() throws Exception {
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		String TestSuite = sheet.getCell(1,4).getContents();
		return (TestSuite);
	}

	public static String xEnvironmentType() throws Exception {
		String Environmenttype=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");  
		if(TestNGRunflag == true){
			Environmenttype = testRunBean.getEnvironment();
		}else{
			Environmenttype = sheet.getCell(1,9).getContents();
		}
		return (Environmenttype);
	}

	public static String xProducts() throws Exception {
		String Products=null;
		File directory = new File(".//");
		String ProductsLoc = directory.getCanonicalPath();
		Products = ProductsLoc +"\\"+"UploadingFiles";
		return (Products);
	}

	public static String xDownloadFiles(String FolderName) throws Exception {
		String DownloadFiles=null;
		File directory = new File(".//");
		String DownloadLoc = directory.getCanonicalPath();
		DownloadFiles = DownloadLoc +"\\"+"DownloadingFiles"+"\\"+FolderName;
		File CreateFolder = new File(DownloadFiles);
		if (!CreateFolder.exists()){
			CreateFolder.mkdir();
		}

		return (DownloadFiles);
	}

	public static String xUploadAdjustmentFile(String FolderName) throws Exception {
		String AdjustmentFiles=null;
		File directory = new File(".//");
		String AdjstLoc = directory.getCanonicalPath();		 
		AdjustmentFiles = AdjstLoc +"\\"+"UploadingFiles"+"\\"+FolderName;
		return (AdjustmentFiles);
	}

	public static String xExecutionType() throws Exception {
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		String ExecutionType = sheet.getCell(1,7).getContents();
		return (ExecutionType);
	}

	public static String xEnvironment() throws Exception {
		String Environment=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		if(TestNGRunflag == true){
			Environment =testRunBean.getUrl();
			if(Environment.equals("")){Environment = sheet.getCell(1,10).getContents();}}
		else{
			Environment = sheet.getCell(1,10).getContents();}
		return (Environment);
	}

	public static int[] xDatasetno() throws Exception {
		int count=0,Sdno=0,edno=0,Dtar=0;
		String Dtno=null;
		String[] Dataset =null;
		int[] Rdts = null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		if(TestNGRunflag == true){
			Dtno =testRunBean.getDatasetNumbers();
		}else{
			Dtno = sheet.getCell(1,22).getContents();
		}  
		if(!Dtno.isEmpty())
		{
			if(Dtno.contains(","))
			{
				Dataset = Dtno.split(",");
				int Datacount =Dataset.length;
				for(int Dset=0;Dset<Datacount;Dset++)
				{
					if(Dataset[Dset].contains("-"))
					{
						String[] stdata = Dataset[Dset].split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
						for(int i=Sdno;i<=edno;i++)
						{
							count++;
						}
					}
					else{count++;}
				}
				Rdts = new int[count];
				for(int Dset=0;Dset<Datacount;Dset++)
				{
					if(Dataset[Dset].contains("-"))
					{
						String[] stdata = Dataset[Dset].split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
						for(int i=Sdno;i<=edno;i++)
						{
							Rdts[Dtar]=i+15;
							Dtar++;
						}
					}
					else
					{
						int Val =Integer.parseInt(Dataset[Dset]);
						Rdts[Dtar]=Val+15;
						Dtar++;
					}
				}
			}
			else if (Dtno.contains("-"))
			{
				String[] stdata = Dtno.split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
				for(int i=Sdno;i<=edno;i++)
				{
					count++;
				}
				Rdts = new int[count];
				for(int i=Sdno;i<=edno;i++)
				{
					Rdts[Dtar]=i+15;
					Dtar++;
				}

			}
			else
			{
				Rdts = new int[1];
				int dtval = Integer.parseInt(Dtno);
				Rdts[0]=dtval+15;
			}
			return (Rdts);
		}
		else
			return null;
	}

	public static String xAutoIT() throws Exception {
		String AutoIT=null;
		File directory = new File(".//");
		String AutoLoc = directory.getCanonicalPath();		 
		AutoIT = AutoLoc +"\\"+"AutoIT";
		return (AutoIT);
	}

	public static void Wait(int MilliSec) throws InterruptedException {
		Thread.sleep(MilliSec);
	}

	public void Print(String Text) {
		System.out.println(Text);
		Reporter.log(Text);
		String Temp = Text;
		sMessages = sMessages + Temp.replaceAll(" ", "_") + "#";
		//System.out.println(Temp);
		//System.out.println(sMessages);
	}

	public java.lang.String xAddMinutesToTheDateTime(String Date_TimeFormat,
			int NumberOfMinutes) throws InterruptedException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DateTimeFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(Date_TimeFormat));
		c.add(Calendar.MINUTE, NumberOfMinutes); // number of minutes
		String str = sdf.format(c.getTime());
		String delimiter = "_";
		String[] temp;
		temp = str.split(delimiter);
		for (int i = 0; i < temp.length - 1; i++) {
			NewDate = temp[i];
			NewTime = temp[i + 1];
		}
		// Print(NewDate);
		// Print(NewTime);

		return (str); // dt is now the new date
	}

	public java.lang.String xAddDaysToTheDateTime(String CurrentDate,
			int NumberOfDays, String DateFormat)
					throws InterruptedException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(CurrentDate));
		c.add(Calendar.DATE, NumberOfDays); // number of days
		String str = sdf.format(c.getTime());
		return (str); // dt is now the new date
	}

	//printing first date of the month
	public static java.lang.String xMonthsFirstDate(String CurrentDate, int NumberOfMonths, String DateFormat) throws InterruptedException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(CurrentDate));
		c.add(Calendar.MONTH, NumberOfMonths); // number of days
		String str = sdf.format(c.getTime());
		return (str); // dt is now the new date
	}

	public java.lang.String xGetCurrentDateEST(String DateFormat) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormat);
		dateFormat.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
		NewDate = dateFormat.format(new Date());
		return (NewDate);
	}

	public java.lang.String xGetCurrentTimeEST() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		dateFormat.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
		NewTime = dateFormat.format(new Date());
		return (NewTime);
	}

	public java.lang.String xGetCurrentTime() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		NewTime = dateFormat.format(new Date());
		return (NewTime);
	}

	public void xUpdateXML(String fileName, String TruID,String Postingdate) throws Exception{
		try {
			File directory = new File(".//");
			String XMLLoc = directory.getCanonicalPath();		 
			String filePath = XMLLoc +"\\"+"UploadingFiles"+"\\"+"DataChecks"+"\\"+fileName;			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filePath);

			Node Login = doc.getElementsByTagName("Login").item(0);
			NodeList list = Login.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if ("TrustedId".equals(node.getNodeName())) {
					node.setTextContent(TruID);
				}
			}	
			Node req = doc.getElementsByTagName("VertexEnvelope").item(0).getChildNodes().item(3);
			//Node invoicereq = doc.getElementsByTagName("InvoiceRequest").item(0)
			NamedNodeMap attr = req.getAttributes();
			attr.getNamedItem("documentDate").setNodeValue(Postingdate);
			attr.getNamedItem("postingDate").setNodeValue(Postingdate);

			//write the updated document to file or console
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);

			System.out.println("DONE");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

	public String xTotalExecutionTime(String StartTime, String EndTime) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(StartTime);
		Date date2 = format.parse(EndTime);
		String strDate1=format.format(date1);
		String strDate2=format.format(date2);
		if (strDate2.split(":")[0].contains("00") && (!strDate1.split(":")[0].contains("00"))) {
			String endtime24=strDate2.split(":")[0].replace("00", "24");
			String formatdatenew=endtime24+":"+strDate2.split(":")[1]+":"+strDate2.split(":")[2];
			TestEndDate = format.parse(formatdatenew);
		} else{
			TestEndDate = format.parse(strDate2);
		}
		long difference = TestEndDate.getTime() - date1.getTime();
		long diffSeconds = difference / 1000 % 60;
		long diffMin = difference / (60 * 1000) % 60;
		long diffHours = difference / (60 * 60 * 1000) % 24;
		//long diffDays = diff / (24 * 60 * 60 * 1000);
		String TotalTime = diffHours+":" + diffMin+":" + diffSeconds;
		return(TotalTime);
	}

	public void xKillIEs() throws Exception {
		Wait(3000);
		File directory = new File(".//");
		try {
			Runtime.getRuntime().exec("wscript.exe " + directory.getCanonicalPath() + "\\KillIEs.vbs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Wait(5000); 
	}

	public void xKillExcel() throws Exception {
		Wait(3000);
		File directory = new File(".//");
		try {
			Runtime.getRuntime().exec("wscript.exe " + directory.getCanonicalPath() + "\\KillExcel.vbs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Wait(5000); 
	}

	public void xTestScriptUpdate() throws Exception {
		Wait(3000);
		File directory = new File(".//");
		try {
			Runtime.getRuntime().exec("wscript.exe " + directory.getCanonicalPath() + "\\TestScriptUpdate.vbs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Wait(5000); 
	}

	public boolean xFileExist(String FileNameWithPath) throws Exception {
		java.io.File myDir = new java.io.File(FileNameWithPath);
		if (myDir.exists()) {
			Print("file exist");
			return true;
		} else {
			Print("file does not exist");
			//assertTrue(false);
			return false;
		}
	}

	public void xMakeFileCopy(String NewFileNameWithPath,
			String FileNameWithPath) throws Exception {
		java.io.File base = new java.io.File(FileNameWithPath);
		java.io.File newfile = new java.io.File(NewFileNameWithPath);
		if (xFileExist(FileNameWithPath)) {
			FileUtils.copyFile(base, newfile);
		} else {
			Print("file does not existcould not copy");
			//assertTrue(false);
		}
		if (xFileExist(NewFileNameWithPath)) {
			Print("file copied sucessfully");
		}

	}

	public void xDeleteFile(String FileNameWithPath) throws Exception {
		java.io.File file = new java.io.File(FileNameWithPath);
		if (xFileExist(FileNameWithPath)) {
			FileUtils.cleanDirectory(file);
			Print("Files Deleted Successfully");
		} else {
			Print("files does not exist.Could not Delete");
			// assertTrue(false);
		}
	}

	public static void xScreenShot() {
		try {

			String NewFileNamePath;
			java.awt.Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();

			Rectangle rectangle = new Rectangle(resolution);

			// Get the dir path
			File directory = new File(".//");
			// System.out.println(directory.getCanonicalPath());

			// get current date time with Date() to create unique file name
			DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy__hh_mm_ssaa");
			// get current date time with Date()
			Date date = new Date();
			// System.out.println(dateFormat.format(date));

			// To identify the system
			InetAddress ownIP = InetAddress.getLocalHost();
			// System.out.println("IP of my system is := "+ownIP.getHostAddress());

			NewFileNamePath = directory.getCanonicalPath() + "\\ScreenShots\\" + Method + "___" + dateFormat.format(date) + "_"  + ownIP.getHostAddress() + ".png";
			//System.out.println(NewFileNamePath);

			// Capture the screen shot of the area of the screen defined by the
			// rectangle
			Robot robot = new Robot();
			//BufferedImage bi = new BufferedImage();
			BufferedImage bi = robot.createScreenCapture(new Rectangle(rectangle));
			ImageIO.write(bi, "png", new File(NewFileNamePath));
			NewFileNamePath = "<a href=" + NewFileNamePath + ">ScreenShot"+ "</a>";
			// Place the reference in TestNG web report
			Reporter.log(NewFileNamePath);

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void xErrorScreenShot(int i) {
		try {

			String NewFileNamePath;
			java.awt.Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rectangle = new Rectangle(resolution);

			// Get the dir path
			File directory = new File(".//");
			// System.out.println(directory.getCanonicalPath());

			// get current date time with Date() to create unique file name
			DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy__hh_mm_ssaa");
			// get current date time with Date()
			Date date = new Date();
			// System.out.println(dateFormat.format(date));

			NewFileNamePath = directory.getCanonicalPath() + "\\ErrorScreenShots\\" + Method + i+"___" + dateFormat.format(date) + ".png";
			System.out.println(NewFileNamePath);

			// Capture the screen shot of the area of the screen defined by the
			// rectangle
			Robot robot = new Robot();
			//BufferedImage bi = new BufferedImage();
			BufferedImage bi = robot.createScreenCapture(new Rectangle(rectangle));
			ImageIO.write(bi, "png", new File(NewFileNamePath));
			NewFileNamePath = "<a href=" + NewFileNamePath + ">ScreenShot"+ "</a>";
			// Place the reference in TestNG web report
			Reporter.log(NewFileNamePath);

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*public static void xUpdateTestDetails(String Status) throws Exception   {
		File directory = new File(".//");
		String Temp = Method + "_" + Status;
		if (Method != ""){
			try {
				Runtime.getRuntime().exec( "wscript.exe " + directory.getCanonicalPath() + "\\UpdateTestDetails.vbs "+ Temp + " " + sMessages);
				Method = "";
				sMessages = "";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Wait(5000); // Allow OS to kill the process
	}  */
	public WritableCellFormat xFillCell(Colour colour) throws WriteException{
		WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
		WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setBackground(colour);
		return cellFormat;
	}

	public WritableCellFormat xFormatCell(Pattern pattern) throws WriteException{
		WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
		WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
		cellFormat.setBackground(Colour.BLACK,pattern);
		return cellFormat;
	}

	public static String getRandomString(int length) {
		String result = new BigInteger(Long.SIZE * length, random).toString(32);
		return result.substring(0, length);
	}

	public static String xGetCustomizedDate(int Day_argument,int Month_argument, int Year_argument) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 

		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, Day_argument);

		cal.add(Calendar.MONTH, Month_argument);		

		cal.add(Calendar.YEAR, Year_argument);

		String CustomizedDate=dateFormat.format(cal.getTime());

		return(CustomizedDate);
	}

	public static String xLabelRND(String[] DataValue) throws Exception {

		String	VertexRNDName="";		
		if (DataValue.length>1) {
			if (DataValue[1].equalsIgnoreCase("RND")) {
				String RandomValue=RND();
				VertexRNDName=DataValue.length == 3 ? DataValue[0]+RandomValue+DataValue[2]:  DataValue[0]+RandomValue;
			}
		}
		else {VertexRNDName=DataValue[0];}
		return (VertexRNDName);	
	}

	public String xGetPDFLabel(String Filepath, String Text) throws Exception {

		String PDFText="";
		PdfReader reader = new PdfReader(Filepath);
		System.out.println("This PDF has "+reader.getNumberOfPages()+" pages.");
		for (int PageCnt=1;PageCnt<=reader.getNumberOfPages();PageCnt++)
		{
			String page = PdfTextExtractor.getTextFromPage(reader, PageCnt);
			java.util.List<String> Line= Arrays.asList(page.split("\n"));
			for(int i=0;i<Line.size();i++)
			{
				String sVal=Line.get(i);
				if(sVal.matches(Text)){
					PDFText= Line.get(i);
				}
			}	
		}
		return (PDFText);	
	}

	public String xGetCSVCellValue(String Filepath, String Text) throws Exception {
		String status="";
		try{
			CSVReader reader = new CSVReader(new FileReader(Filepath));
			ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				ArrayList<String> list = new ArrayList<String>();
				for (int i=0;i<nextLine.length;i++) { 
					list.add(nextLine[i]);
				}
				array.add(list);
			}
			// Nested loop to display results
			end:for(int x=0;x<array.size();x++) {
				for(int y=0;y<array.get(x).size();y++) {
					String Cell_Name=array.get(x).get(y);
					System.out.println(Cell_Name);
					Cell_Header=array.get(x).get(y);
					if (Cell_Name.equalsIgnoreCase(Text)) {					
						//System.out.println(Cell_Header);
						status=(Cell_Header.equalsIgnoreCase(Text))==true? status: status+ "Fail, Column Value doesnot match;";
						//Cell_Value=array.get(x+1).get(y);
						if(array.size()>1 && array.get(x+1).get(y)!=null)
						{
							Cell_Value=array.get(x+1).get(y);
							//System.out.println("cell value is "+Cell_Value);
						}
						break end;
					}
				}			
			}
		}catch(Exception e){
			throw e;
		}
		return status;

	}

	public String xGetCSVCell(String Filepath, String Text, String Taxpayer, String returnname,String filingfreqvalue) throws Exception {
		String status="";
		try{
			CSVReader reader = new CSVReader(new FileReader(Filepath));
			ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				ArrayList<String> list = new ArrayList<String>();
				for (int i=0;i<nextLine.length;i++) { 
					list.add(nextLine[i]);
				}
				array.add(list);
			}
			String content = Joiner.on(",").join(array);
			// Nested loop to display results
			end:	for(int x=0;x<array.size();x++) {
				for(int y=0;y<array.get(x).size();y++) {
					String Cell_Name=array.get(x).get(y);
					System.out.println(Cell_Name);
					Cell_Header=array.get(x).get(y);
					if (Cell_Name.equalsIgnoreCase(Text)) {
						System.out.println(Cell_Header);
						status=(Cell_Header.equalsIgnoreCase(Text))==true? status: status+ "Fail, Column Value doesnot match;";
						for(int c=1;c<array.size();c++){
							Cell_Value=array.get(x+c).get(y);
							System.out.println("cell value is "+Cell_Value);
							if(Cell_Value.equalsIgnoreCase(Taxpayer)){
								returnvalue=array.get(x+c).get(y+1);
								Filingfreq=array.get(x+c).get(y+5);
								if(returnvalue.equalsIgnoreCase(returnname)){
									System.out.println("returnname="+returnname);
									//break;
								}
								if(Filingfreq.equalsIgnoreCase(filingfreqvalue))
								{
									System.out.println("filingfreqvalue="+filingfreqvalue);
									//break;
								}
								//break taxpayersearch;
								//break end;
							}

						}
					}				
				}
			}
		}catch(Exception e){
			return e.getMessage()+status;
		}
		return status;

	}

	public String xExtractZiReadContents(String ZipFilepath, String UnZipFilepath, String FileName, String Text) throws Exception {

		//Extract the zip file 
		FileInputStream fis = null;
		ZipInputStream zis = null;
		ZipEntry zEntry = null;
		String ExtractFileName="";
		String FiletobeVerified="";
		try {
			fis = new FileInputStream(ZipFilepath);
			zis = new ZipInputStream(new BufferedInputStream(fis));
			while((zEntry = zis.getNextEntry()) != null){
				try{
					byte[] tmp = new byte[4*1024];
					FileOutputStream fos = null;
					FiletobeVerified=zEntry.getName();
					ExtractFileName =UnZipFilepath+zEntry.getName();
					System.out.println("Extracting file to "+ExtractFileName);
					fos = new FileOutputStream(ExtractFileName);
					int size = 0;
					while((size = zis.read(tmp)) != -1){
						fos.write(tmp, 0 , size);
					}
					fos.flush();
					fos.close();
				} catch(Exception ex){

				}
				if (FiletobeVerified.split("\\.")[0].equalsIgnoreCase(FileName)) System.out.println("Yes."); else System.out.println("NO.");
				//Read Extracted File and their Content 
				BufferedReader Breader = new BufferedReader(new FileReader(ExtractFileName));
				try {
					StringBuilder Strbuilder = new StringBuilder();
					String line = Breader.readLine();

					while (line != null) {
						Strbuilder.append(line);
						Strbuilder.append("\n");
						line = Breader.readLine();
					}
					String fileContent= Strbuilder.toString();

					boolean hasState= fileContent.toUpperCase().contains(Text);
					if(hasState){
						System.out.println("Yes. Text File Contains "+Text);
					}else{
						System.out.println("NO. Text File doesnt Contain "+Text);
					}
				} finally {
					Breader.close();
				}
			}

			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Text;			
	}

	public String xGetXLSXCellValue(String Filepath, String Text) throws Exception {

		FileInputStream fis = new FileInputStream(Filepath);
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int Num_rows=sheet.getLastRowNum();
		System.out.println("Number of rows in the sheet :" +Num_rows);
		XSSFRow HeaderRow = sheet.getRow(0); // 3rd row is my header row
		int columnsCount=HeaderRow.getLastCellNum();
		System.out.println("Number of columns in the sheet :" +columnsCount);
		end:for (int i=0; i<=Num_rows; i++)
		{      
			XSSFRow Rows = sheet.getRow(i);
			for(int col=0; col< columnsCount; col++) 
			{
				XSSFCell atColumn = HeaderRow.getCell(col);
				String Column_Value=atColumn.getStringCellValue();
				XSSFRow HeaderRow1 = sheet.getRow(1);
				XSSFCell atColumn1 = HeaderRow1.getCell(col);
				//String Column_Value=atColumn.getStringCellValue();


				if (Column_Value.equalsIgnoreCase(Text)) {
					switch (Rows.getCell(col).getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						int Numeric_Value=(int) Rows.getCell(col).getNumericCellValue();
						System.out.println(Numeric_Value);						

						break;
					case Cell.CELL_TYPE_STRING:
						String Str_Value=Rows.getCell(col).getStringCellValue();
						System.out.println(Str_Value);
						if (Column_Value.equalsIgnoreCase(Text)) {

							double billingamount=atColumn1.getNumericCellValue();

							System.out.println(billingamount);

							BillAmount=Double.toString(billingamount);

							System.out.println(BillAmount);
						}
						break; 
					default:
						Date date_Value=Rows.getCell(col).getDateCellValue();
						System.out.println(date_Value);
						break;
					}
					break end;
				}
			}
		}
		fis.close();
		return (BillAmount);
	}

	public String xGetCustomizedXLSXCellValue(String Filepath, String Sheet, String State, String Categoty) throws Exception {

		FileInputStream fis = new FileInputStream(Filepath);
		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(Sheet);
		int Num_rows=sheet.getLastRowNum();
		int temp=0;
		String CategoryType="";
		for (int i=0; i<Num_rows; i++) {
			org.apache.poi.ss.usermodel.Row Row = sheet.getRow(i);
			int columnsCount=Row.getLastCellNum();
			for(int col=0; col<columnsCount; col++)	
			{
				org.apache.poi.ss.usermodel.Cell atColumn = Row.getCell(col);
				String Column_Value= (!(atColumn==null))?atColumn.toString().trim():"";
				if (Column_Value.equalsIgnoreCase(State))
				{
					temp=col;
					break;
				}
				if(col==temp&& Row.getCell(0)!=null && Row.getCell(0).toString().trim().equalsIgnoreCase(Categoty))
				{
					org.apache.poi.ss.usermodel.Row sample = sheet.getRow(i);
					System.out.println(Row.getCell(0).toString().trim()+"==>"+sheet.getRow(1).getCell(temp)+"==>"+sample.getCell(temp));
					CategoryType=sample.getCell(temp).toString();
					System.out.println(CategoryType);
				}
			}
			fis.close();
		}
		return (CategoryType);
	}

	public String XGetXLSValue(String Filepath, String Text) throws Exception {

		Workbook workbook =Workbook.getWorkbook(new File(Filepath));
		Sheet sheet = workbook.getSheet(0);
		int Rows=sheet.getRows();
		int Columns=sheet.getColumns();
		for (int i=0; i<Rows; i++) {
			for (int j=0; j<Columns; j++) {	
				String C_Header=sheet.getCell(j, i).getContents();
				if (C_Header.equalsIgnoreCase(Text)) {
					Col_Row_Content=sheet.getCell(j, i+1).getContents();
					System.out.println(Col_Row_Content);
				}
			}
		}
		return Text;
	}

	public String xRandomTimeStampName(String MethodName) throws Exception {

		try{
			// Get the dir path
			File directory = new File(".//");

			// get current date time with Date() to create unique file name
			DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy__hh_mm_ssaa");

			// get current date time with Date()
			Date date = new Date();

			// To identify the system
			InetAddress ownIP = InetAddress.getLocalHost();
			if (MethodName.contains(":")){
				MethodName = MethodName.replace(":", "-");}
			NewFileNamePath = directory.getCanonicalPath() + "\\ScreenShots\\"+ MethodName + "_" + dateFormat.format(date) + "_" + ownIP.getHostAddress()+".png";}
		catch(Exception e){
			e.getMessage();
		}
		return NewFileNamePath;
	}

	public String PDFConversion(String FilePath, String FileExt) throws Exception {

		PDDocument pd;
		BufferedWriter wr;
		try {
			File input = new File(FilePath);  // The PDF file from where you would like to extract
			String[] OutPutFilePath=FilePath.split("\\.");
			File output = new File(OutPutFilePath[0]+FileExt); // The file where you are going to store the extracted data in txt, csv,xls, doc etc..
			pd = PDDocument.load(input);
			System.out.println(pd.getNumberOfPages());
			PDFTextStripper stripper = new PDFTextStripper();
			wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
			stripper.writeText(pd, wr);
			if (pd != null) {
				pd.close();
			}
			wr.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return FileExt; 
	}

	public String RunTimeTestCaseStatus(int iTestCaseExecuting,int iTotalTestCasesToBeExecuted,int iTotalPassed,int iTotalFailed,String iFailedTestCases) throws Exception 
	{       
		File directory = new File (".//");
		try
		{                
			System.out.println("wscript.exe "+directory.getCanonicalPath()+"\\Intermediatestatus.vbs "+iTestCaseExecuting+" "+iTotalTestCasesToBeExecuted+" "+iTotalPassed+" "+iTotalFailed+" "+iFailedTestCases);
			Runtime.getRuntime().exec("wscript.exe "+directory.getCanonicalPath()+"\\Intermediatestatus.vbs "+iTestCaseExecuting+" "+iTotalTestCasesToBeExecuted+" "+iTotalPassed+" "+iTotalFailed+" "+iFailedTestCases);
		} 
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Pass";
	}

	public String CleanupfilesinFolder() throws Exception 
	{       
		File directory = new File (".//"+"DownloadingFiles");
		//String strDirectory=directory.getCanonicalPath()+"\\"+"DownloadingFiles";
		try
		{  
			/*for(File f: directory.listFiles()) {
				f.delete();}*/
			//FileUtils.cleanDirectory(directory);
			//Runtime.getRuntime().exec("wscript.exe "+directory.getCanonicalPath()+"\\CleanupFiles.vbs " +strDirectory);
			if (directory.isDirectory()) {
				for (File Folders : directory.listFiles()) {
					if (!Folders.getName().contains(".gitkeep")) {
						if(Folders.isFile())
						{
							Folders.delete();
						}
						else{
							for(File subFolders : Folders.listFiles())
							{
								subFolders.delete();
							}
							Folders.delete();
						}
					}
				}
			}
		} 
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Pass";
	}

	public String CleanupinSystemDownFolder() throws Exception 
	{       
		String DownloadFilePath= System.getProperty("user.home") + "\\Downloads";
		File directory = new File(DownloadFilePath);
		try
		{  
			for(File f: directory.listFiles()) {
				f.delete();}
		} 
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Pass";
	}

	public String MoveLatestDownloadFileFromOnedirtoAnother(String Targetpath) throws Exception {
		String DownloadFilePath;
		if(System.getProperty("os.name").contains("Windows XP")){
			DownloadFilePath= System.getProperty("user.home") + "\\My Documents" + "\\Downloads";
		}
		else{DownloadFilePath= System.getProperty("user.home") + "\\Downloads";}

		File dir = new File(DownloadFilePath);
		File [] files  = dir.listFiles();
		Arrays.sort(files);
		Arrays.sort(files, new Comparator<Object>()
				{
			public int compare(Object o1, Object o2) {
				return compare( (File)o1, (File)o2);
			}
			private int compare( File f1, File f2){
				long result = f2.lastModified() - f1.lastModified();
				if( result > 0 ){
					return 1;
				} else if( result < 0 ){
					return -1;
				} else {
					return 0;
				}
			}
				});

		String LatestDownloadedFile=Arrays.asList(files[0]).toString();
		String regex = "\\[|\\]";
		String DownloadPath = LatestDownloadedFile.replaceAll(regex, "");
		System.out.println("Download Path :"+DownloadPath);
		String[] arrFileName=LatestDownloadedFile.split("\\\\");
		String FileName=arrFileName[arrFileName.length-1];
		String[] arrFileNames=FileName.split("]");
		String arrFileReName=arrFileNames[0].replaceAll(" \\(.*\\)", "");
		System.out.println("Downloaded FileName is "+arrFileReName);
		Path RSource = Paths.get(DownloadPath);
		Path RTarget= Paths.get(Targetpath+"\\"+arrFileReName);
		Files.move(RSource, RTarget, REPLACE_EXISTING);
		return Targetpath;					
	}

	public String MoveLatestDownloadFileFromOnedirtoAnother(String SourcePath, String Targetpath) throws Exception {
		try{

			File dir = new File(SourcePath);
			File [] files  = dir.listFiles();
			Arrays.sort(files);
			Arrays.sort(files, new Comparator<Object>()
					{
				public int compare(Object o1, Object o2) {
					return compare( (File)o1, (File)o2);
				}
				private int compare( File f1, File f2){
					long result = f2.lastModified() - f1.lastModified();
					if( result > 0 ){
						return 1;
					} else if( result < 0 ){
						return -1;
					} else {
						return 0;
					}
				}
					});

			String LatestDownloadedFile=Arrays.asList(files[0]).toString();
			String regex = "\\[|\\]";
			String DownloadPath = LatestDownloadedFile.replaceAll(regex, "");
			System.out.println("Download Path :"+DownloadPath);
			String[] arrFileName=LatestDownloadedFile.split("\\\\");
			String FileName=arrFileName[arrFileName.length-1];
			String[] arrFileNames=FileName.split("]");
			String arrFileReName=arrFileNames[0].replaceAll(" \\(.*\\)", "");
			System.out.println("Downloaded FileName is "+arrFileReName);
			Path RSource = Paths.get(DownloadPath);
			Path RTarget= Paths.get(Targetpath+"\\"+arrFileReName);
			Files.move(RSource, RTarget,REPLACE_EXISTING);

		} catch (Exception e) {

			e.getMessage();
		}
		return SourcePath;

	}

	public String PDFComparison(String ExpectedFile, String ActualFile) throws Exception 
	{       
		String status="";
		try {
			PdfReader Dreader = new PdfReader(ExpectedFile); //to get the file
			PdfReader Oreader = new PdfReader(ActualFile); //to get the file
			int DPageCnt=Dreader.getNumberOfPages();
			int OPageCnt=Oreader.getNumberOfPages();
			if (DPageCnt==OPageCnt) {
				String Dpage = PdfTextExtractor.getTextFromPage(Dreader, DPageCnt); 
				String Opage = PdfTextExtractor.getTextFromPage(Oreader, OPageCnt); 
				List<String> DLine= Arrays.asList(Dpage.split("\n")); 
				List<String> OLine= Arrays.asList(Opage.split("\n")); 
				if (DLine.size()==OLine.size()) {
					for(int i=0;i<DLine.size();i++) 
					{
						String DVal=DLine.get(i);
						String OVal=OLine.get(i);
						status=(DVal.equalsIgnoreCase(OVal))==true? status: status+ "Fail, Expected and Actual Pdf files Lines content match and mismatched contents in both files are "+DVal+" and "+OVal+";";
					}	
				} else {
					status=status+ "Fail, Expected and Actual Pdf file lines Size does not match;";
				}
			} else {
				status=status+ "Fail, Expected and Actual Pdf file Page Count does not match;";
			}

		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	/*pdf comparing using a text file
	declare in function with and as
	LatestDownloadedFile();
	PDFCompare(Filepath);*/
	/*public String PDFCompare(String ActualFile,String ExpectedFile) throws Exception 
	{
		try{
			//String File=LatestDownloadedFile()+"//"+ActualFile;
			//LatestDownloadedFile();
			FileInputStream fileToParse = new FileInputStream(ActualFile);
			PDFParser parser = new PDFParser(fileToParse);
			parser.parse();

			// Store the pdf text into string
			String output = new PDFTextStripper().getText(parser.getPDDocument());

			// Remove all spaces, tab, new lines		
			output = output.replaceAll("\\s", "");
			output = output.substring(0,output.length()-20);//21 is for Generated Date EX:04/17/201510:01:54AM

			parser.getPDDocument().close();

			// Convert the sample file to string for comparison. Also Remove all spaces, tab, new lines
			FileInputStream fileToParse1 = new FileInputStream(ExpectedFile);
			PDFParser parser1 = new PDFParser(fileToParse1);
			parser1.parse();
			//File file = new File(ExpectedFile);
			String fileContent =new PDFTextStripper().getText(parser1.getPDDocument());	
			fileContent = fileContent.replaceAll("\\s", "");
			fileContent = fileContent.substring(0,fileContent.length()-20);
			parser1.getPDDocument().close();
			// Compare the sample and resultant file
			assertEquals((output.compareTo(fileContent)), 0);
			System.out.println("Content Matched");
		} catch (AssertionError e) {
			return e.getMessage();
		}
		return "pass";
	}
	 */
	public String AnyfileCompare(File ActualFile,File ExpectedFile) throws Exception 
	{
		try{
			HashSet<String> f1 = new HashSet<String>(FileUtils.readLines(ActualFile));
			HashSet<String> f2 = new HashSet<String>(FileUtils.readLines(ExpectedFile));
			f1.removeAll(f2);
			System.out.println("f1 size is "+f1.size());
			//assertTrue(f1.size()==0);
			if(f1.size()==0){
				System.out.println("comparision for success files is equal");
			}else{System.out.println("fail, comparision success files not equal");
			}			
		} catch (AssertionError e) {
			return e.getMessage();
		}
		return "pass";
	}

	public String ZipfilesCompare(String filepath1,String filepath2) throws Exception 
	{
		ZipFile file1;
		try {
			file1 = new ZipFile(filepath1);
		} catch (IOException e) {
			System.out.println("Could not open zip file : " + e);
			return "fail";
			// return;
		}

		ZipFile file2;
		try {
			file2 = new ZipFile(filepath2);
		} catch (IOException e) {
			System.out.println("Could not open zip file : " + e);
			return "fail";
			//  return;
		}    

		Set set1 = new LinkedHashSet();
		for (Enumeration e = file1.entries(); e.hasMoreElements();)
			set1.add(((ZipEntry) e.nextElement()).getName());

		Set set2 = new LinkedHashSet();
		for (Enumeration e = file2.entries(); e.hasMoreElements();)
			set2.add(((ZipEntry) e.nextElement()).getName());

		int errcount = 0;
		int filecount = 0;
		String name=null;
		for (Iterator i = set1.iterator(); i.hasNext();) {
			name = (String) i.next();
			if (!set2.contains(name)) {
				name=name + " not found in " + filepath2;
				System.out.println(name);
				errcount += 1;
				continue;
			}
			try {
				set2.remove(name);
				if (!streamsEqual(file1.getInputStream(file1.getEntry(name)), file2.getInputStream(file2.getEntry(name)))) {
					name=name + " does not match";
					System.out.println(name);
					errcount += 1;
					continue;
				}
			} catch (Exception e) {
				name=name + ": IO Error " + e;
				System.out.println(name);
				e.printStackTrace();
				errcount += 1;
				continue;
			}
			filecount += 1;
		}
		for (Iterator i = set2.iterator(); i.hasNext();) {
			name = (String) i.next();
			name=name + " not found in " + filepath1;
			System.out.println(name);
			errcount += 1;
		}
		System.out.println(filecount + " entries matched");
		if (errcount > 0) {
			System.out.println(errcount + " entries did not match");
			return "fail";
		}
		if(name==""){
			return "Pass"+filecount + " entries matched"+errcount + " entries did not match";}
		else{
			return name+"does not match/not found"+filecount + " entries matched"+errcount + " entries did not match";
		}

	}

	static boolean streamsEqual(InputStream stream1, InputStream stream2) throws IOException {
		byte[] buf1 = new byte[4096];
		byte[] buf2 = new byte[4096];
		boolean done1 = false;
		boolean done2 = false;

		try {
			while (!done1) {
				int off1 = 0;
				int off2 = 0;

				while (off1 < buf1.length) {
					int count = stream1.read(buf1, off1, buf1.length - off1);
					if (count < 0) {
						done1 = true;
						break;
					}
					off1 += count;
				}
				while (off2 < buf2.length) {
					int count = stream2.read(buf2, off2, buf2.length - off2);
					if (count < 0) {
						done2 = true;
						break;
					}
					off2 += count;
				}
				if (off1 != off2 || done1 != done2)
					return false;
				for (int i = 0; i < off1; i++) {
					if (buf1[i] != buf2[i])
						return false;
				}
			}
			return true;
		} finally {
			stream1.close();
			stream2.close();
		}
	}

	/**
	 * Get the List of File Names in a Directory
	 * Author :Sai krishna.
	 * param directory
	 * @return
	 */
	public ArrayList<String> GetListofFileNames(String directory) {

		File dir = new File(directory);
		File[] listOfFiles = dir.listFiles();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				list.add(listOfFiles[i].getName());
			}
		}
		return list;

	}

	/**
	 * Compare the CSV and XLS files row and column based
	 * Author :Sai krishna.
	 * param ActualFile,sheet
	 * @return
	 */
	@SuppressWarnings("resource")
	public String CSVXLSFilesCompare(String ActualFile, Sheet sheet) throws Exception{
		String status="";
		try{
			CSVReader reader = new CSVReader(new FileReader(ActualFile));
			ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				ArrayList<String> list = new ArrayList<String>();
				for (int j=0;j<nextLine.length;j++) { 
					list.add(nextLine[j]);
				}
				array.add(list);
			}
			int oRCount=sheet.getRows();
			int DRowCount=array.size();
			if (oRCount==DRowCount) {
				int oColCount=sheet.getColumns();
				int DcolCount= array.get(0).size();
				for(int r=0; r<DRowCount;r++){
					if (oColCount==DcolCount) {

						for(int c=0;c< DcolCount;c++){
							String dContent= array.get(r).get(c);
							String oContent= sheet.getCell(DcolCount, c).getContents();
							if (dContent==oContent) {

								status=status+"Fail, NO. Expected WorkSheets Report Content Does not match with Actual; ";

							} 
						}
					} else {
						status=status+"Fail, NO. Expected WorkSheets Column Numbers Does not match with Actual; ";
					}

				}
			} else {

				status=status+"Fail, NO. Expected WorkSheets Row Numbers Does not match with Actual; ";

			}
			if(status=="")
			{
				status="Pass";
			}
		}
		catch(Exception e){
			return e.getMessage()+status;
		}

		return status;
	}

	/**
	 * Compare the XLSX and XLSX files row and column based
	 * Author :Sai krishna.
	 * param ExpectedFile,ActualFile
	 * @return
	 */

	public String XLSXtoXLSXFilesCompare(String ExpectedFile, String ActualFile) throws Exception{
		String status="";
		try {
			FileInputStream Ex_fis = new FileInputStream(ExpectedFile);
			XSSFWorkbook Ex_workbook = new XSSFWorkbook (Ex_fis);
			XSSFSheet Ex_sheet = Ex_workbook.getSheetAt(0);
			int Num_rows=Ex_sheet.getLastRowNum();
			XSSFRow HeaderRow = Ex_sheet.getRow(0); //1st row is my header row
			FileInputStream Ac_fis = new FileInputStream(ActualFile);
			XSSFWorkbook Ac_workbook = new XSSFWorkbook (Ac_fis);
			XSSFSheet Ac_sheet = Ac_workbook.getSheetAt(0);
			int Ac_Num_rows=Ac_sheet.getLastRowNum();
			XSSFRow Ac_HeaderRow = Ac_sheet.getRow(0); //1st row is Ac_Num_rows header row
			if (Ac_Num_rows==Num_rows){
				int columnsCount=HeaderRow.getLastCellNum();
				int Ac_columnsCount=Ac_HeaderRow.getLastCellNum();
				if (columnsCount==Ac_columnsCount){
					for (int i=0; i<=Num_rows; i++)
					{      
						for(int col=0; col< columnsCount; col++) 
						{
							XSSFCell Ex_Content = HeaderRow.getCell(col);
							XSSFCell Ac_Content = Ac_HeaderRow.getCell(col);
							String Ex_Content_Value=Ex_Content.getStringCellValue().trim();
							String Ac_Content_Value=Ac_Content.getStringCellValue().trim();
							status=(Ex_Content_Value.equalsIgnoreCase(Ac_Content_Value))==true? status: status+ "Fail, File Content does not match and mismatched contents in both files are "+Ex_Content_Value+" and "+Ac_Content_Value+";";
						}
					}

				}else{
					status=status+ "Fail, Expected and Actual XLSX files Columns Count does not match;";
				}
			} else {
				status=status+ "Fail, Expected and Actual XLSX files Row Count does not match;";
			}

		} catch (Exception e) {
			return e.getMessage()+status;
		}
		return status;
	}

	/**
	 * Rename the file name in the Downloading Files folder
	 * Author :Sai krishna.
	 * param OldFileName,NewFileName
	 * @return
	 */
	public String RenameFileName(String OldFileName, String NewFileName) {
		try{
			File oldName = new File(OldFileName);
			File newName = new File(NewFileName);

			if(oldName.renameTo(newName)) {
				System.out.println("renamed");
			} else {
				System.out.println("Error");
			}

		}catch (Exception e){
			return e.getMessage();
		}
		return NewFileName;

	}
	

	

	public void xResult(final WebDriver driver,WritableSheet RSheet, String value) throws Exception{

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String FilePath=xRandomTimeStampName(value);
		FileUtils.copyFile(scrFile, new File(FilePath));
		
	}

	public void xCatchexception(WritableSheet RSheet, int Rownumber, String error) throws RowsExceededException, WriteException {

		RSheet.addCell(new Label(11,Rownumber-1,error));
		RSheet.addCell(new Label(10,Rownumber-1,"Fail",xFillCell(Colour.RED)));

	}	

	/**
	 * Unzip it
	 * Author :Sai krishna.
	 * @param zipFile input zip file
	 * @param output zip file output folder
	 */
	public void unZipIt(String zipFile, String outputFolder){

		byte[] buffer = new byte[1024];

		try{

			//create output directory is not exists
			File folder = new File(outputFolder);
			if(!folder.exists()){
				folder.mkdir();
			}

			//get the zip file content
			ZipInputStream zis = 
					new ZipInputStream(new FileInputStream(zipFile));
			//get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while(ze!=null){

				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);

				String filename=newFile.getAbsoluteFile().getName();
				listoffiles=filename+";"+listoffiles;
				System.out.println("List of file names in the folder are :"+listoffiles);

				//create all non exists folders
				//else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);             

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();   
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

		}catch(IOException ex){
			ex.printStackTrace(); 
		}

	}

	/**
	 * Compare the two csv files row and column based
	 * Author :Sai krishna.
	 * param File1,File2
	 * @return
	 */
	@SuppressWarnings({ "resource", "unused" })
	public String csvFilesCompare(String File1, String File2) throws Exception {
		String status="";
		try{
			CSVReader reader1 = new CSVReader(new FileReader(File1));
			CSVReader reader2 = new CSVReader(new FileReader(File2));
			ArrayList<ArrayList<String>> array1 = new ArrayList<ArrayList<String>>();
			ArrayList<ArrayList<String>> array2 = new ArrayList<ArrayList<String>>();
			String[] nextLine1;
			while ((nextLine1 = reader1.readNext()) != null) {
				ArrayList<String> list1 = new ArrayList<String>();
				for (int i=0;i<nextLine1.length;i++) { 
					list1.add(nextLine1[i]);
				}
				array1.add(list1);
			}
			String[] nextLine2;
			while ((nextLine2 = reader2.readNext()) != null) {
				ArrayList<String> list2 = new ArrayList<String>();
				for (int i=0;i<nextLine2.length;i++) { 
					list2.add(nextLine2[i]);
				}
				array2.add(list2);
			}
			// Nested loop to display results
			int arraysize = 0;
			int arraycolumnsize = 0;
			int filesize1=array1.size();
			int filesize2=array2.size();
			if (filesize1>filesize2) {
				arraysize=filesize1;
			} else if(filesize1<filesize2) {
				arraysize=filesize2;
			} else {
				arraysize=filesize1;
			}

			for(int rf1=0; rf1<arraysize;rf1++) {

				int filesizec1=array1.get(rf1).size();
				int filesizec2=array2.get(rf1).size();
				if (filesizec1>filesizec2) {
					arraycolumnsize=filesizec1;
				} else if(filesizec1<filesizec2) {
					arraycolumnsize=filesizec2;
				} else {

					arraycolumnsize=filesizec1;
				}


				for(int cf1=0;cf1<arraycolumnsize;cf1++) {
					String file1content = null;
					String file2content = null;
					try {
						file1content=array1.get(rf1).get(cf1);
						file2content=array2.get(rf1).get(cf1);
						status=(file1content.equalsIgnoreCase(file2content))==true? status: status+ "Fail, File Content does not match and mismatched contents in both files are in row "+rf1+" and column "+cf1+";";
					}catch (Exception e) {
						status= status+"Fail, File Content does not match and mismatched contents in both files are in row "+rf1+" and column "+cf1+";";
					}

				}			
			}

		}catch(Exception e){
			return e.getMessage()+status;
		}
		return status;

	}

	/**
	 * merge the multiple csv files to the new csv file
	 * Author :Sai krishna.
	 * param File1,File2
	 * @return
	 */
	public String mergecsvfilestonewcsv(String filenames, String outputFile) throws Exception {

		try {
			String path=filenames.split(";")[0];
			String[] tfile=filenames.split(";");
			int len=tfile.length;
			for (int i=1; i<len; i++) {
				if (i==1) {
					reader = new CSVReader(new FileReader(path+"\\"+tfile[i]));
					List<String[]> allRows = reader.readAll();
					csvOutput = new CSVWriter(new FileWriter(outputFile, true));
					csvOutput.writeAll(allRows);
					csvOutput.close();
					reader.close();

				} else {
					reader = new CSVReader(new FileReader(path+"\\"+tfile[i]), ',', '\'', 1);
					List<String[]> allRows = reader.readAll();
					csvOutput = new CSVWriter(new FileWriter(outputFile, true));
					csvOutput.writeAll(allRows);
					csvOutput.close();
					reader.close();
				}
			}

		} catch (Exception e) {

			e.getMessage();
		}
		return filenames;
	}

	/**
	 * Create the video file and start the recording
	 * Author :Sai krishna.
	 * @return
	 * @throws ATUTestRecorderException 
	 * @throws Exception 
	 */
	public void xStartRecorder() throws ATUTestRecorderException, Exception {
		try {
			File directory = new File (".//");
			String TestSuiteName = xTestSuite();
			String DataTime = xGetDateTime();
			String RecorderFilename=TestSuiteName+"_TestVideos_"+DataTime;
			recorder = new ATUTestRecorder(directory.getCanonicalPath()+"\\RecordedTestScripts\\",RecorderFilename,false);
			recorder.start();
		}catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Stop the recording video
	 * Author :Sai krishna.
	 * @throws ATUTestRecorderException 
	 */
	public void xStopRecorder() throws ATUTestRecorderException {
		try {
			recorder.stop();
		}catch (Exception e) {
			e.getMessage();
		}
	}

	public String xReadJSONobject(String JSONfilepath, String ObjectName) throws Exception {
		JSONParser parser = new JSONParser();
		String Value =null;

		try {
			Object obj = parser.parse(new FileReader(JSONfilepath));
			JSONObject jsonObject =  (JSONObject) obj;
			switch(ObjectName){
					}    	
		} catch (Exception e) {
			Value = e.getMessage();
		}
		return Value;
	}

	public String LatestDownloadedFile(String FolderName, boolean isFromChrome) throws Exception {
		try{

			if(!isFromChrome){
				File directory = new File(".//");
				String DownloadFilePath=directory.getCanonicalPath()+"\\"+"DownloadingFiles";
				File dir = new File(DownloadFilePath);
				File [] files  = dir.listFiles();
				Arrays.sort(files);
				Arrays.sort(files, new Comparator()
				{
					public int compare(Object o1, Object o2) {
						return compare( (File)o1, (File)o2);
					}
					private int compare( File f1, File f2){
						long result = f2.lastModified() - f1.lastModified();
						if( result > 0 ){
							return 1;
						} else if( result < 0 ){
							return -1;
						} else {
							return 0;
						}
					}
				});
				String LatestDownloadedFile=Arrays.asList(files[0]).toString();
				String regex = "\\[|\\]";
				String DownloadPath = LatestDownloadedFile.replaceAll(regex, "");

				String[] arrFileName=LatestDownloadedFile.split("\\\\");
				FileName=arrFileName[arrFileName.length-1];
				if(FileName.contains("(")){
					String[] splitfilename=FileName.split("\\(");
					FileName=splitfilename[0];
					System.out.println("split filename "+splitfilename[0]);}
				String[] arrFileNames=FileName.split("\\.");
				String FileNames=arrFileNames[0];				
				DownloadedFileName=FileNames;
				String s=xDownloadFiles(FolderName);
				Filepath=s+"\\"+FileName.replace("]", "");
				Path RSource = Paths.get(DownloadPath);
				Path RTarget= Paths.get(Filepath);
				Files.move(RSource, RTarget,REPLACE_EXISTING);
			}
			else
			{
				String DownloadFilePath = xDownloadFiles(FolderName);

				File dir = new File(DownloadFilePath);
				File [] files  = dir.listFiles();
				Arrays.sort(files);
				Arrays.sort(files, new Comparator()
				{
					public int compare(Object o1, Object o2) {
						return compare( (File)o1, (File)o2);
					}
					private int compare( File f1, File f2){
						long result = f2.lastModified() - f1.lastModified();
						if( result > 0 ){
							return 1;
						} else if( result < 0 ){
							return -1;
						} else {
							return 0;
						}
					}
				});
				String LatestDownloadedFile=Arrays.asList(files[0]).toString();
				String regex = "\\[|\\]";
				String DownloadPath = LatestDownloadedFile.replaceAll(regex, "");
				Filepath=DownloadPath;
				String[] arrFileName=LatestDownloadedFile.split("\\\\");
				FileName=arrFileName[arrFileName.length-1];
				if(FileName.contains("(")){
					String[] splitfilename=FileName.split("\\(");
					FileName=splitfilename[0];
					System.out.println("split filename "+splitfilename[0]);}
				String[] arrFileNames=FileName.split("\\.");
				String FileNames=arrFileNames[0];				
				DownloadedFileName=FileNames;
			}
		}catch (Exception e){
			return e.getMessage();
		}
		return Filepath;
	}

	

	

	@SuppressWarnings("resource")

	public static String xCSVtoTXT(String FileName)
	{
		try{
			@SuppressWarnings("unused")
			FileWriter writer=null;
			String csv=null;
			String Temp="";
			File file=new File(FileName);
			System.out.println(file);
			Scanner scan=new Scanner(file);
			while(scan.hasNext()){
				csv=scan.nextLine().replace("|", " ");
				if(csv.contains(".0")){
					csv=csv.replace(".0", "");
				}
				if(csv.contains(".00")){
					csv=csv.replaceAll(".00", "");
				}
				Temp=Temp+csv;}
			FileName=Temp;
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return 	FileName;

	}

	

	/**
	 * it will copy the original file and save into the tempfile, update the temp file dates based keyword provided in the sheet 
	 * Author :Sai krishna.
	 * param Originalfilepath
	 * param tempfilepath
	 * @return
	 */
	public String AdjustmentFiledateupdate(String Originalfilepath,String tempfilepath) throws Exception 
	{       
		File directory = new File (".//");
		try
		{                
			Runtime.getRuntime().exec("wscript.exe "+directory.getCanonicalPath()+"\\UpdateAdjustmentfileDates.vbs "+Originalfilepath+" "+tempfilepath);
		} 
		catch(Exception e)
		{
			return e.getMessage();
		}
		return "Pass";
	}

	public void writeJsonFile(String jsonRespose, String filename)
	{
		try {

			File directory = new File(".//"+"DownloadingFiles");
			File file=new File(directory.getCanonicalPath()+"\\"+filename);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jsonRespose);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static class CreateZipFolder {

		public static List<String> fileList = new ArrayList<>();

		public static void compressDirectory(String dir, String zipFile) {
			File directory = new File(dir);
			getFileList(directory);

			try {
				File[] files = directory.listFiles();
				if (files != null && files.length > 0) {
					if(null != fileList && !fileList.isEmpty()) {
						FileOutputStream fos  = new FileOutputStream(zipFile);
						ZipOutputStream zos = new ZipOutputStream(fos);

						for (String filePath : fileList) {
							System.out.println("Compressing: " + filePath);
							// Creates a zip entry.
							String name = filePath.substring(directory.getAbsolutePath().length() + 1,
									filePath.length());
							ZipEntry zipEntry = new ZipEntry(name);

							zos.putNextEntry(zipEntry);
							// Read file content and write to zip output stream.
							FileInputStream fis = new FileInputStream(filePath);
							byte[] buffer = new byte[1024];
							int length;
							while ((length = fis.read(buffer)) > 0) {
								zos.write(buffer, 0, length);
							}
							// Close the zip entry and the file input stream.
							zos.closeEntry();
							fis.close();
						}
						zos.close();
						fos.close();
					}

					// Close zip output stream and file output stream. This will
					// complete the compression process.

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Get files list from the directory recursive to the sub directory.
		 */
		public static void getFileList(File directory) {
			try{
				File[] files = directory.listFiles();
				if (files != null && files.length > 0) {
					for (File Folder : files) {
						if (Folder.isDirectory() && !Folder.getName().contains(".zip")) {
							if (null != Folder.listFiles() && Folder.listFiles().length > 0) {
								for (File File : Folder.listFiles()) {
									fileList.add(File.getAbsolutePath());
								}
							}
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public static class DeleteFolder {

		public static void deleteFile(File Dir) {

			if (Dir.isDirectory()) {
				for (File Folders : Dir.listFiles()) {
					if (!Folders.getName().contains(".zip")) {
						if(Folders.isFile())
						{
							Folders.delete();
						}
						else
						{
							for(File subFolders : Folders.listFiles()){
								subFolders.delete();
							}
							Folders.delete();
						}
					}
				}
			}
		}
	}


	public static String xRunasForm() throws Exception {
		String RunasForm=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		RunasForm = sheet.getCell(1,7).getContents();		
		return (RunasForm);
	}	

	public static String xRuntestType() throws Exception {
		String RuntestType = testRunBean.getRunTestType();
		return (RuntestType);
	}

	public static String xMobileOs() throws Exception {
		String RuntestType = testRunBean.getOSType();
		return (RuntestType);
	}

	public static String xAutomationName() throws Exception {
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		String AutomationName = sheet.getCell(3,2).getContents();
		return (AutomationName);
	}

	public static String xPlatformName() throws Exception {
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		String PlatformName = sheet.getCell(3,3).getContents();
		return (PlatformName);
	}

	public static String xPlatformversion() throws Exception {
		String PlatformVersion=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		//String PlatformVersion = sheet.getCell(3,4).getContents();
		if(xExecutionType().equalsIgnoreCase("Scheduler"))
		{PlatformVersion = sheet.getCell(3,4).getContents();}
		else{PlatformVersion = testRunBean.getPlatformversion();
		System.out.println("platform version"+testRunBean.getPlatformversion());}
		return (PlatformVersion);
	}

	public static String xDeviceName() throws Exception {
		String DeviceName=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		if(xExecutionType().equalsIgnoreCase("Scheduler")){
			DeviceName = sheet.getCell(3,5).getContents();
		}else{
			DeviceName = testRunBean.getDeviceName();
			System.out.println("DeviceName"+testRunBean.getDeviceName());}
		return (DeviceName);
	}

	public static String xApppacakage() throws Exception {
		String Apppacakage=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		if(xExecutionType().equalsIgnoreCase("Scheduler")){
			Apppacakage = sheet.getCell(3,7).getContents();
		}else{
			Apppacakage = testRunBean.getApppacakage();
			System.out.println("Apppacakage"+testRunBean.getApppacakage());}
		return (Apppacakage);
	}

	public static String xAppActivity() throws Exception {
		String Appactivity=null;
		TSETUP = _properties.getProperty(TestProperties.TESTSETUP);
		Workbook workbook = Workbook.getWorkbook(new File(TSETUP));
		Sheet sheet = workbook.getSheet("TestSetup");
		if(xExecutionType().equalsIgnoreCase("Scheduler")){
			Appactivity = sheet.getCell(3,8).getContents();	
		}else{
			Appactivity = testRunBean.getAppActivity();
			System.out.println("Appactivity"+testRunBean.getAppActivity());}
		return (Appactivity);
	}

	public static String xAppium() throws Exception {
		String AdjustmentFiles=null;
		File directory = new File(".//");
		String AdjstLoc = directory.getCanonicalPath();		 
		AdjustmentFiles = AdjstLoc +"\\"+"Appium";
		return (AdjustmentFiles);
	}

	public static String xSikuli() throws Exception {
		String Sikulifile=null;
		File directory = new File(".//");
		String AdjstLoc = directory.getCanonicalPath();		 
		Sikulifile = AdjstLoc +"\\"+"Sikuli";
		return (Sikulifile);
	}

	public static int[] xDatarowno(String value) throws Exception {
		int count=0,Sdno=0,edno=0,Dtar=0;
		String[] Dataset =null;
		int[] Rdts = null;
		String[] Data;
		Data = value.split(";");
		String Dtno = Data[2];
		if(!Dtno.isEmpty())
		{
			if(Dtno.contains(","))
			{
				Dataset = Dtno.split(",");
				int Datacount =Dataset.length;
				for(int Dset=0;Dset<Datacount;Dset++)
				{
					if(Dataset[Dset].contains("-"))
					{
						String[] stdata = Dataset[Dset].split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
						for(int i=Sdno;i<=edno;i++)
						{
							count++;
						}
					}
					else{count++;}
				}
				Rdts = new int[count];
				for(int Dset=0;Dset<Datacount;Dset++)
				{
					if(Dataset[Dset].contains("-"))
					{
						String[] stdata = Dataset[Dset].split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
						for(int i=Sdno;i<=edno;i++)
						{
							Rdts[Dtar]=i;
							Dtar++;
						}
					}
					else
					{
						int Val =Integer.parseInt(Dataset[Dset]);
						Rdts[Dtar]=Val;
						Dtar++;
					}
				}
			}
			else if (Dtno.contains("-"))
			{
				String[] stdata = Dtno.split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
				for(int i=Sdno;i<=edno;i++)
				{
					count++;
				}
				Rdts = new int[count];
				for(int i=Sdno;i<=edno;i++)
				{
					Rdts[Dtar]=i;
					Dtar++;
				}

			}
			else
			{
				Rdts = new int[1];
				int dtval = Integer.parseInt(Dtno);
				Rdts[0]=dtval;
			}
			return (Rdts);
		}
		else
			return null;
	}

	public static int[] xsubDatarowno(String value) throws Exception {
		int count=0,Sdno=0,edno=0,Dtar=0;
		String[] Dataset =null;
		int[] Rdts = null;
		if(!value.isEmpty())
		{
			if(value.contains(","))
			{
				Dataset = value.split(",");
				int Datacount =Dataset.length;
				for(int Dset=0;Dset<Datacount;Dset++)
				{
					if(Dataset[Dset].contains("-"))
					{
						String[] stdata = Dataset[Dset].split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
						for(int i=Sdno;i<=edno;i++)
						{
							count++;
						}
					}
					else{count++;}
				}
				Rdts = new int[count];
				for(int Dset=0;Dset<Datacount;Dset++)
				{
					if(Dataset[Dset].contains("-"))
					{
						String[] stdata = Dataset[Dset].split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
						for(int i=Sdno;i<=edno;i++)
						{
							Rdts[Dtar]=i;
							Dtar++;
						}
					}
					else
					{
						int Val =Integer.parseInt(Dataset[Dset]);
						Rdts[Dtar]=Val;
						Dtar++;
					}
				}
			}
			else if (value.contains("-"))
			{
				String[] stdata = value.split("-");Sdno=Integer.parseInt(stdata[0]);edno = Integer.parseInt(stdata[1]);
				for(int i=Sdno;i<=edno;i++)
				{
					count++;
				}
				Rdts = new int[count];
				for(int i=Sdno;i<=edno;i++)
				{
					Rdts[Dtar]=i;
					Dtar++;
				}

			}
			else
			{
				Rdts = new int[1];
				int dtval = Integer.parseInt(value);
				Rdts[0]=dtval;
			}
			return (Rdts);
		}
		else
			return null;
	}

	public double TitleAttributevalue(WebElement Ee) throws Exception{
		double cashAvailable=0;
		String TCA="";
		try{
			String[] tile=Ee.getText().split("\\$");
			if(!tile[0].equals("")){
			 tile[0] = tile[0].replaceAll("[^\\d.]", "");}
			if(tile[0].contains("-")){
				//String TcasH1=tile[0]+tile[1];
				switch(tile.length){
				case 1:
					TCA=tile[0];
					cashAvailable=Double.parseDouble(TCA);
					//System.out.printf("%.2f", cashAvailable1);
					break;
				case 2:
					tile[1] = tile[1].replaceAll("[^\\d.]", "");
					TCA=tile[0]+tile[1];
					cashAvailable=Double.parseDouble(TCA);
					break;
				case 3:
					tile[1] = tile[1].replaceAll("[^\\d.]", "");
					tile[2] = tile[2].replaceAll("[^\\d.]", "");
					TCA=tile[0]+tile[0]+tile[1]+tile[2];
					cashAvailable=Double.parseDouble(TCA);
					break;
				case 4:
					tile[1] = tile[1].replaceAll("[^\\d.]", "");
					tile[2] = tile[2].replaceAll("[^\\d.]", "");
					tile[3] = tile[3].replaceAll("[^\\d.]", "");
					TCA=tile[0]+tile[0]+tile[1]+tile[2]+tile[3];
					cashAvailable=Double.parseDouble(TCA);
					break;
				}
			}
			else{
				switch(tile.length){
				case 1:
					TCA=tile[0];
					cashAvailable=Double.parseDouble(TCA);
					break;
				case 2:
					TCA=tile[0]+tile[1];
					cashAvailable=Double.parseDouble(TCA);
					break;	
				case 3:
					TCA=tile[0]+tile[1]+tile[2];
					cashAvailable=Double.parseDouble(TCA);
					break;	
				}
			}
		}
		catch(Exception e)
		{
		String [] tile = Ee.getText().split("\\$");
		/*if(!tile[0].equals("")){
			 tile[0] = String.format("%.2f", tile[0]);}*/
		tile[0] = tile[0].replaceAll("[^\\d.]", "");
		if(tile[0].contains("-")){
			//String TcasH1=tile[0]+tile[1];
			switch(tile.length){
			case 1:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[1];
				cashAvailable=Double.parseDouble(TCA);
				break;
			case 2:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[0]+tile[1];
				cashAvailable=Double.parseDouble(TCA);
				break;
			case 3:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				tile[2] = tile[2].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[0]+tile[1]+tile[2];
				cashAvailable=Double.parseDouble(TCA);
				break;
			case 4:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				tile[2] = tile[2].replaceAll("[^\\d.]", "");
				tile[3] = tile[3].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[0]+tile[1]+tile[2]+tile[3];
				cashAvailable=Double.parseDouble(TCA);
				break;
			}
		}
		else{
			switch(tile.length){
			case 1:
				TCA=tile[0];
				cashAvailable=Double.parseDouble(TCA);
				break;
			case 2:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[1];
				cashAvailable=Double.parseDouble(TCA);
				break;	
			case 3:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
     			tile[2] = tile[2].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[1]+tile[2];
				cashAvailable=Double.parseDouble(TCA);
				break;	
			}
		}
			return cashAvailable;
		}
		return cashAvailable;
	}
	
	public float fTitleAttributevalue(WebElement Ee) throws Exception{
		float cashAvailable=0;
		String TCA="";
		try{
			String[] tile = Ee.getAttribute("title").split("\\$");
			tile[0] = tile[0].replaceAll("[^\\d.]", "");
			/*tile[1] = tile[1].replaceAll("[^\\d.]", "");
			tile[2] = tile[2].replaceAll("[^\\d.]", "");
			tile[3] = tile[3].replaceAll("[^\\d.]", "");*/
			         
			if(tile[0].contains("-")){
				//String TcasH1=tile[0]+tile[1];
				switch(tile.length){
				case 1:
					TCA=tile[0];
					cashAvailable=Float.parseFloat(TCA);
					//System.out.printf("%.2f", cashAvailable1);
					break;
				case 2:
					tile[1] = tile[1].replaceAll("[^\\d.]", "");
					TCA=tile[0]+tile[1];
					cashAvailable=Float.parseFloat(TCA);
					break;
				case 3:
					tile[1] = tile[1].replaceAll("[^\\d.]", "");
					tile[2] = tile[2].replaceAll("[^\\d.]", "");
					TCA=tile[0]+tile[0]+tile[1]+tile[2];
					cashAvailable=Float.parseFloat(TCA);
					break;
				case 4:
					tile[1] = tile[1].replaceAll("[^\\d.]", "");
					tile[2] = tile[2].replaceAll("[^\\d.]", "");
					tile[3] = tile[3].replaceAll("[^\\d.]", "");
					TCA=tile[0]+tile[0]+tile[1]+tile[2]+tile[3];
					cashAvailable=Float.parseFloat(TCA);
					break;
				}
			}
			else{
				switch(tile.length){
				case 1:
					TCA=tile[0];
					cashAvailable=Float.parseFloat(TCA);
					break;
				case 2:
					TCA=tile[0]+tile[1];
					cashAvailable=Float.parseFloat(TCA);
					break;	
				case 3:
					TCA=tile[0]+tile[1]+tile[2];
					cashAvailable=Float.parseFloat(TCA);
					break;	
				}
			}
		}
		catch(Exception e)
		{
			String[] tile = Ee.getAttribute("title").split("\\$");
			tile[0] = tile[0].replaceAll("[^\\d.]", "");
			//String[] tile= str[0].split("\\k");
		if(tile[0].contains("-")){
			//String TcasH1=tile[0]+tile[1];
			switch(tile.length){
			case 1:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[1];
				cashAvailable=Float.parseFloat(TCA);
				break;
			case 2:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[0]+tile[1];
				cashAvailable=Float.parseFloat(TCA);
				break;
			case 3:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				tile[2] = tile[2].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[0]+tile[1]+tile[2];
				cashAvailable=Float.parseFloat(TCA);
				break;
			case 4:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				tile[2] = tile[2].replaceAll("[^\\d.]", "");
				tile[3] = tile[3].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[0]+tile[1]+tile[2]+tile[3];
				cashAvailable=Float.parseFloat(TCA);
				break;
			}
		}
		else{
			switch(tile.length){
			case 1:
				TCA=tile[0];
				cashAvailable=Float.parseFloat(TCA);
				break;
			case 2:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[1];
				cashAvailable=Float.parseFloat(TCA);
				break;	
			case 3:
				tile[1] = tile[1].replaceAll("[^\\d.]", "");
				tile[2] = tile[2].replaceAll("[^\\d.]", "");
				TCA=tile[0]+tile[1]+tile[2];
				cashAvailable=Float.parseFloat(TCA);
				break;	
			}
		}
			return cashAvailable;
		}
		return cashAvailable;
	}

	
	
	
	public BigDecimal DecimalRound(double portfolioAUMInfoo,int Round){
		String Pc="";
		BigDecimal b3 = null;
		float Portfoliovalue = 0;
		try{
			Pc=String.valueOf(portfolioAUMInfoo);
			BigDecimal bg=new BigDecimal(portfolioAUMInfoo);
			b3=bg.movePointLeft(0);
			b3=b3.setScale(Round, BigDecimal.ROUND_HALF_UP);

		}
		catch(Exception e)
		{
			e.getMessage();}
		return b3;
	}
	
	public BigDecimal DecimalRound(float portfolioAUMInfoo){
		String Pc="";
		BigDecimal b3 = null;
		float Portfoliovalue = 0;
		try{
			Pc=String.valueOf(portfolioAUMInfoo);
			BigDecimal bg=new BigDecimal(portfolioAUMInfoo);
			b3=bg.movePointLeft(0);
			b3=b3.setScale(2, BigDecimal.ROUND_HALF_UP);

		}
		catch(Exception e)
		{
			e.getMessage();}
		return b3;
	}

	public BigDecimal DecimalRound2(double portfolioAUMInfoo){
		String Pc="";
		BigDecimal b3 = null;
		double Portfoliovalue = 0.00;
		try{
			Pc=String.valueOf(portfolioAUMInfoo);
			BigDecimal bg=new BigDecimal(portfolioAUMInfoo);
			b3=bg.movePointLeft(0);
			b3=b3.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		}
		catch(Exception e)
		{
			e.getMessage();}
		return b3;
	}
	
	public BigDecimal DecimalRound3(float portfolioAUMInfoo){
		String Pc="";
		BigDecimal b3 = null;
		float Portfoliovalue = 0.00f;
		try{
			Pc=String.valueOf(portfolioAUMInfoo);
			BigDecimal bg=new BigDecimal(portfolioAUMInfoo);
			b3=bg.movePointLeft(0);
			b3=b3.setScale(3, BigDecimal.ROUND_HALF_EVEN);

		}
		catch(Exception e)
		{
			e.getMessage();}
		return b3;
	}
	
	public BigDecimal DecimalRound4(double portfolioAUMInfoo){
		String Pc="";
		BigDecimal b3 = null;
		double Portfoliovalue = 0.00;
		try{
			Pc=String.valueOf(portfolioAUMInfoo);
			BigDecimal bg=new BigDecimal(portfolioAUMInfoo);
			b3=bg.movePointLeft(0);
			b3=b3.setScale(4, BigDecimal.ROUND_HALF_EVEN);

		}
		catch(Exception e)
		{
			e.getMessage();}
		return b3;
	}
	public int xResult(String Verification,WritableSheet RSheet,String ExpectedValue,String ActualValue,String value,int NoOfVerify ,String TestcaseNumber){
		try{
			if (Verification ==""){
				if (ExpectedValue!="") {
					RSheet.addCell(new Label(0,Suntuity.RowNo-1,Suntuity.DataSetValue));
					RSheet.addCell(new Label(1,Suntuity.RowNo-1,Suntuity.StepNo+"("+NoOfVerify+")"));
					RSheet.addCell(new Label(7,Suntuity.RowNo-1,ExpectedValue));
				}
				else{
					RSheet.addCell(new Label(0,Suntuity.RowNo-1,Suntuity.DataSetValue));
					RSheet.addCell(new Label(1,Suntuity.RowNo-1,Suntuity.StepNo+"("+NoOfVerify+")"));
					RSheet.addCell(new Label(7,Suntuity.RowNo-1,ExpectedValue));
				}
				if (ActualValue!=""){RSheet.addCell(new Label(9,Suntuity.RowNo-1,ActualValue));}
				else{RSheet.addCell(new Label(9,Suntuity.RowNo-1,Suntuity.FunctionName));
				}
				RSheet.addCell(new Label(10,Suntuity.RowNo-1,TestcaseNumber));
				RSheet.addCell(new Label(11,Suntuity.RowNo-1,"Pass",xFillCell(Colour.GREEN)));
			}

			else{
				RSheet.addCell(new Label(0,Suntuity.RowNo-1,Suntuity.DataSetValue));
				RSheet.addCell(new Label(1,Suntuity.RowNo-1,Suntuity.StepNo+"("+NoOfVerify+")"));
				RSheet.addCell(new Label(7,Suntuity.RowNo-1,ExpectedValue));
				if (ActualValue!=""){RSheet.addCell(new Label(9,Suntuity.RowNo-1,ActualValue));}
				else{RSheet.addCell(new Label(9,Suntuity.RowNo-1,Suntuity.FunctionName));}
				RSheet.addCell(new Label(10,Suntuity.RowNo-1,TestcaseNumber));
				RSheet.addCell(new Label(12,Suntuity.RowNo-1,Verification));
				RSheet.addCell(new Label(11,Suntuity.RowNo-1,"Fail",xFillCell(Colour.RED)));
				
				File scrFile = ((TakesScreenshot)Suntuity.driver).getScreenshotAs(OutputType.FILE);
				String FilePath=xRandomTimeStampName(value);
				FileUtils.copyFile(scrFile, new File(FilePath));
				WritableHyperlink hyperlink = new WritableHyperlink(13, Suntuity.RowNo-1, new File(FilePath),"Error Snapshot Link");
				RSheet.addHyperlink(hyperlink);
			}
			Suntuity.RowNo++;
		}
		catch(Exception e){
			Suntuity.RowNo++;
			e.getMessage();
		}
		return Suntuity.RowNo;
	}
	
}
