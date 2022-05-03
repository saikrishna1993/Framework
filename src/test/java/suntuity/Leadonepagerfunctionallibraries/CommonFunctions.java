package suntuity.Leadonepagerfunctionallibraries;

import static io.restassured.RestAssured.given;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableHyperlink;
import jxl.write.WritableSheet;
import source.Suntuity;
import suntuity.Utilities.UtilityScript;

public class CommonFunctions extends UtilityScript{

	public static String FileName;
	public static String  DownloadedFileName;
	public static String Filepath;
	public String[] Data;
	public Sheet sheet;
	public Workbook WorkBook;
    public boolean flag=false;
    public  boolean singnin;
	/**
	 * it will wait until element invisible on the web page within specified time
	 *  @author Sai Krishna
	 *  @param int Timeout
	 *  @param String objxpath
	 *  @param final WebDriver aDriver 
	 * @throws Exception 
	 */
//test
	public void waitUntilElementInvisibe(int Timeout, String objxpath, final WebDriver aDriver) throws Exception{
		try{
			new FluentWait<WebDriver>(aDriver)
			//.withTimeout(Timeout,TimeUnit.SECONDS)
			//.pollingEvery(5,TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class)
			.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(objxpath)));
		}catch(Exception e){
		}
	}
	
	
	public String GetRestDataFromQuickBase(String TableName,String FieldID,String SelectFunction) {
		String ReturnValue="";
		try {
		String TableID="";
		
		switch(TableName){
			case "Leads":
				TableID="bqwwm3sxd";
				break;
			case "Opportunities":
				TableID="bqwwm3te3";
				break;
			case "Proposals":
				TableID="bqwwm3tj3";
				break;
			case "Appointments":
				TableID="bqwwm3tmt";
				break;
				default:
					System.out.println("Wrong Table Name");
					break;
			
		}
	String quickbase_token="QB-USER-TOKEN b5iysd_g536_0_6e6gkmevmtz9ds9zew243kmrj";
		Response  Responce=given().contentType(ContentType.JSON).header("QB-Realm-Hostname","Suntuity").headers("Authorization", quickbase_token)
		.baseUri("https://api.quickbase.com").body("{\r\n"
				+ "  \"from\": \""+TableID+"\",\r\n"
				+ "   \"select\": [\r\n"
				+ "    "+FieldID+"\r\n"
				+ "    \r\n"
				+ "    \r\n"
				+ "  ],\r\n"
				+ "  \"where\": \""+SelectFunction+"\"\r\n"
				+ " \r\n"
				+ "\r\n"
				+ "}").when().post("/v1/records/query").then().contentType(ContentType.JSON).extract().response(); 
		JsonPath jsonPathEvaluator = Responce.jsonPath();
		 ReturnValue= jsonPathEvaluator.getString("data[0]."+FieldID+".value");
				}
		catch(Exception e) {
			e.printStackTrace();
		}
		 return ReturnValue;
			
	}

	//It will untill spinner present on screen
	public void waituntilspinnerdisappear(final WebDriver driver) {
		
		try {
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1[contains(.,'Loading')]")));
		
			wait.ignoring(org.openqa.selenium.NoSuchElementException.class);
			
			try {
				
				if(driver.findElement(By.xpath("//button[contains(.,'I am the button')]")).isDisplayed()) {
					
					JavaScriptclick(driver, driver.findElement(By.xpath("//button[contains(.,'I am the button')]")));
					
					
				}
			}
			catch(Exception e) {
			
			}
			try {
				if(driver.findElement(By.xpath("(//span[contains(.,'autorenew')])[2]")).isDisplayed()) {	
					wait=new WebDriverWait(driver,360);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[contains(.,'autorenew')])[2]")));	
					wait.ignoring(org.openqa.selenium.NoSuchElementException.class);
			}
			}
			catch(Exception e) {
				
			}
		}
		catch(Exception e) {
			System.out.println("Issue with Spinner");
		}
		
	}

	
	
	
	
	public void dragdrop(By ByFrom, By ByTo, final WebDriver aDriver) {
		WebElement LocatorFrom = aDriver.findElement(ByFrom);
		WebElement LocatorTo = aDriver.findElement(ByTo);
		String xto=Integer.toString(LocatorTo.getLocation().x);
		String yto=Integer.toString(LocatorTo.getLocation().y);
		((JavascriptExecutor)aDriver).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
				"simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
				LocatorFrom,xto,yto);
	}

	/**
	 * it will wait until element visible on the web page within specified time
	 *  @author Sai Krishna
	 *  @param int Timeouty
	 *  @param String objxpath
	 *  @param final WebDriver aDriver 
	 * @throws Exception 
	 */

	public void waitforElement(int Timeout, String objxpath, final WebDriver aDriver) throws Exception{
		try{
			new FluentWait<WebDriver>(aDriver)
			.withTimeout(Timeout,TimeUnit.SECONDS)
			.pollingEvery(5,TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class)
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objxpath)));
		}catch(Exception e){
		}
	}
	/**
	 * it will wait until element visible on the web page within specified time
	 *  @author Sai Krishna
	 *  @param int Timeout
	 *  @param final WebElement key
	 *  @param final WebDriver aDriver 
	 * @throws Exception 
	 */

	public void waitforElement(int Timeout, final WebElement key, final WebDriver aDriver) throws Exception{
		try{
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(aDriver)
					.withTimeout(Timeout, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);             
			wait.until(ExpectedConditions.visibilityOf(key));
		}
		catch(Exception e){
		}
	}

	public void waitforElementClickable(int Timeout, final WebElement key, final WebDriver aDriver) throws Exception{
		try{
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(aDriver)
					.withTimeout(Timeout, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);             
			wait.until(ExpectedConditions.elementToBeClickable(key));
		}
		catch(Exception e){
		}
	}

	/**
	 * Type value in given webelement field
	 *  @author Sai Krishna
	 * @param webelement key
	 * @param String value
	 * @throws Exception 
	 */

	public void type(WebElement key, String value) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(value);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * it will perform the tab action on given webelement field
	 *  @author Sai Krishna
	 * @param webelement
	 * @throws Exception 
	 */

	public void sendkeysTab(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.TAB);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * it will perform the Back Space action on given webelement field
	 *  @author Sai Krishna
	 * @param webelement key
	 * @throws Exception 
	 */

	public void sendkeybackSpace(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.BACK_SPACE);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * it will perform the Enter action on given webelement field
	 *  @author Sai Krishna
	 * @param webelement key
	 * @throws Exception 
	 */

	public void sendkeysEnter(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.ENTER);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * it will perform the Return action on given webelement field
	 *  @author Sai Krishna
	 * @param webelement key
	 * @throws Exception 
	 */

	public void sendkeysReturn(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.RETURN);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * Type value in given webelement field using JavaScript Executor
	 * @author Sai Krishna
	 * @param WebDriver
	 * @param webelement
	 * @param value
	 * @throws Exception 
	 */

	public void JavaScripttype(final WebDriver aDriver, WebElement key, String value) throws Exception {
		if (key.isDisplayed()) {
			JavascriptExecutor jse = ((JavascriptExecutor) aDriver);
			jse.executeScript("arguments[0].value='"+value+"';", key);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * it will perform the Back Space action on given webelement field using Javascript executor
	 * @author Sai Krishna
	 * @param WebDriver
	 * @param webelement
	 * @param value
	 * @throws Exception 
	 */

	public void JavaScripttypespace(final WebDriver aDriver, WebElement key, String value) throws Exception {
		if (key.isDisplayed()) {
			JavascriptExecutor jse = ((JavascriptExecutor) aDriver);
			jse.executeScript("arguments[0].value='"+value+" "+"';", key);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	public void JavaScripttypebackspace(final WebDriver aDriver, WebElement key, String value) throws Exception {
		if (key.isDisplayed()) {
			JavascriptExecutor jse = ((JavascriptExecutor) aDriver);
			jse.executeScript("arguments[0].value='"+value+" "+"';", key);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}
	/**
	 * Click on the given webelement field
	 * @author Sai Krishna
	 * @param webelement key
	 * @throws Exception 
	 * @throws InterruptedException 
	 */

	public void click(WebElement key) throws Exception {

		if (key.isDisplayed()) {
			key.click();
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	public void Doubleclick(WebElement key) throws Exception {

		if (key.isDisplayed()) {
			key.click();
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * Click on the given webelement field using JavaScript Executor
	 * @author Sai Krishna
	 * @param WebDriver
	 * @param webelement
	 * @throws Exception 
	 * @throws InterruptedException 
	 */

	public void JavaScriptclick(final WebDriver aDriver, WebElement key) throws Exception {

		if (key.isDisplayed() || !key.isDisplayed()) {
			JavascriptExecutor jse=(JavascriptExecutor)aDriver;
			jse.executeScript("arguments[0].click();",key);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}
	
	/**
	 * it will perform the Mouse Hover action on given webelement field using Javascript executor
	 * @author Sai Krishna
	 * @param WebDriver
	 * @param webelement
	 * @throws Exception 
	 * @throws InterruptedException 
	 */

	public void JavaScriptMousehover(final WebDriver aDriver, WebElement key) throws Exception  {
		if (key.isDisplayed()) {
			String mouseOverScript = "if(document.createEvent){ "
					+ "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initEvent('mouseover',true, false); "
					+ "arguments[0].dispatchEvent(evObj);} "
					+ "else if(document.createEventObject) { "
					+ "arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) aDriver).executeScript(mouseOverScript,key);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * Click on the given maskedit textboxes webelement field and send the data into the WebElement Field
	 * @author Sai Krishna
	 * maskedit textboxes (Phone Number, Zip etc......)
	 * @param webelement
	 * @param String
	 * @throws Exception 
	 * @throws InterruptedException 
	 */

	public boolean Clickable(final WebDriver aDriver, WebElement element) throws Exception {
		try {
			aDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			if (element.isDisplayed())
				element.click();
			;
			return true;
		} catch (Exception e) {
			return false;	
		}
	}

	public void clickandtype(WebElement key, String value) throws Exception {

		if (key.isDisplayed()) {
			key.click();
			key.sendKeys(value);
		} else {
			throw new Exception(key+ "is not found");	
		}
	}

	/**
	 * Get innerText of given webelement from html doc
	 * @author Sai Krishna
	 * @param key
	 * @return visible inner html text
	 * @throws Exception 
	 */

	public String getText(WebElement key) throws Exception {

		if (key.isDisplayed()) {
			key.getText();
		} else {
			throw new Exception(key+ "is not found");	
		}
		return key.isDisplayed() ? key.getText() : null;
	}

	/**
	 * Get Attribute name based on id, name, class, value of given webelement from html doc
	 * @author Sai Krishna
	 * @param key
	 * @param String
	 * @return visible inner html text
	 * @throws Exception 
	 */

	public String getAttribute(WebElement key, String AttributeName) throws Exception {

		if (key.isDisplayed()) {
			key.getAttribute(AttributeName);
		} else {
			throw new Exception(key+ "is not found");	
		}
		return key.isDisplayed() ? key.getAttribute(AttributeName) : null;
	}

	/**
	 * Verifying the webelement field using isDisplayed method
	 * @author Sai Krishna
	 * @param WebDriver aDriver
	 * @param webelement element
	 * @throws InterruptedException 
	 */

	public boolean VerifyObject(final WebDriver aDriver, WebElement element) throws Exception {
		try {
			aDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			if (element.isDisplayed())
				;
			return true;
		} catch (Exception e) {
			return false;	
		}
	}

	/**
	 * Verifying the webelement field using isDisplayed method
	 * @author Sai Krishna
	 * @param WebDriver aDriver
	 * @param String objxpath
	 * @throws InterruptedException 
	 */

	public boolean VerifyObject(final WebDriver aDriver, String objxpath) throws Exception {
		try {
			aDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			if (aDriver.findElement(By.xpath(objxpath)).isDisplayed())
				;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Clear the input value from webelement field
	 * @author Sai Krishna
	 * @param webelement
	 * @throws Exception 
	 * @throws InterruptedException 
	 */

	public void clear(final WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.clear();
		} else {
			throw new Exception(key+ "is not found");
		}
	}
	
	
	public void startreport(String Report) {
		
	}
	public void getreport(String status,String Reason) {
			
	}
	public void closereport() {
		
	}

	/**
	 * Select value in given webelement field
	 * @author Sai Krishna
	 * @param webelement
	 * @param value
	 * @throws Exception 
	 */

	public void selectByValue(final WebElement key, final String value) throws Exception {
		if (key.isDisplayed()) {
			new Select(key).selectByVisibleText(value);
			;
		} else {
			throw new Exception(key+ "is not found");
		}
	}

	/**
	 * Select value in given webelement field based on Index
	 * @author Sai Krishna
	 * @param webelement
	 * @param int index
	 * @throws Exception 
	 */

	public void selectByIndex(final WebElement key, final int value) throws Exception {
		if (key.isDisplayed()) {
			new Select(key).selectByIndex(value);
			;
		} else {
			throw new Exception(key+ "is not found");
		}
	}



	/* it is used to down the page based on WebElement
	 * @author Sai Krishna
	 * @param webelement
	 * @throws Exception 
	 */

	public void sendKeysPagedown(final WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.PAGE_DOWN);
			;
		} else {
			throw new Exception(key+ "is not found");
		}
	}

	/**
	 * Switch to the Frame based on the id or name
	 * @author Sai Krishna
	 * @param WebDriver
	 * @param String
	 */

	public void switchToFrame(final WebDriver aDriver, String frameName) {
		aDriver.switchTo().frame(frameName);
	}

	/**
	 * Switch to the Frame based on the frame index
	 * @author Sai Krishna
	 * @param WebDriver
	 * @param int
	 */

	public void switchToFrame(final WebDriver aDriver, int frameindex) {
		aDriver.switchTo().frame(frameindex);
	}

	/**
	 * Switch to the Frame based on the WebElement field
	 * @author Sai Krishna
	 * @param WebDriver
	 * @param WebElement
	 */

	public void switchToFrame(final WebDriver aDriver, WebElement frameName) {
		aDriver.switchTo().frame(frameName);
	}

	/**
	 * Switch to the default Content
	 * @author Sai Krishna
	 * @param WebDriver
	 */

	public void switchToMain(final WebDriver aDriver) {
		aDriver.switchTo().defaultContent();
	}

	/**
	 * Switch to the Alert window and then Accept
	 * @author Sai Krishna
	 * @param WebDriver
	 */

	public void switchToAlertAccept(final WebDriver aDriver) {
		Alert alert=aDriver.switchTo().alert();
		alert.accept();
	}	

	/**
	 * Switch to the Alert window and then Dismiss
	 * @author Sai Krishna
	 * @param WebDriver
	 */

	public void switchToAlertDismiss(final WebDriver aDriver) {
		Alert alert=aDriver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * Switch to the Alert Prompt box and then type value and Accept
	 * @author Sai Krishna
	 * @param WebDriver
	 * @param String
	 */

	public void switchToAlertPrompttypeandAccept(final WebDriver aDriver, String value) {
		Alert alert=aDriver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}

	/**
	 * Return true if alert present else return false
	 * @author Sai Krishna
	 * @param WebDriver
	 * @throws Exception 
	 */

	public boolean isAlertPresent(final WebDriver aDriver) throws Exception {

		try {
			aDriver.switchTo().alert();		   
			return true;		 
		} catch (Exception e) {
			throw new Exception("alert is not found");
		}
	}

	/**
	 * if condition to compare expected and actual
	 * @author Sai Krishna
	 * @param String expected
	 * @param String actual
	 */

	public void ifcondition(String expected, String actual) {

		if (expected.equals(actual)) {

			System.out.println("expected matches with actual");
		}
	}

	/**
	 * Switch to the child window from parent window
	 * @author Sai Krishna
	 * @param String
	 * @param WebDriver
	 */

	public void switchToChildWindow(String parentHandler, final WebDriver aDriver) {

		for (String winHandle : aDriver.getWindowHandles()) {
			if (!winHandle.equals(parentHandler)) {
				aDriver.switchTo().window(winHandle);
			}
		}
	}

	/**
	 * Close the Child Window and Switch to the Parent Window
	 * @author Sai Krishna
	 * @param String
	 * @param WebDriver
	 */

	public void switchTomainWindow(String parentHandler, final WebDriver aDriver) {

		aDriver.close();
		aDriver.switchTo().window(parentHandler);
	}

	/**
	 * get the title of the page
	 * @author Sai Krishna
	 * @param WebDriver
	 */

	public String gettitle(final WebDriver aDriver) {

		return aDriver.getTitle();
	}

	/**
	 * Scroll down page using the Java script 
	 * @author Sai Krishna
	 * @param WebDriver
	 */

	public void scrollDown(final WebDriver aDriver) {

		JavascriptExecutor js = (JavascriptExecutor) aDriver;           
		js.executeScript("scroll(0,300)");
	}

	//this will scroll upto webelement if webelement exist
	public void scrolluptoelement(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	/**
	 * Scroll Up page using the Java script 
	 * @author Sai Krishna
	 * @param WebDriver
	 */

	public void scrollUp(final WebDriver aDriver) {

		JavascriptExecutor js = (JavascriptExecutor) aDriver;           
		js.executeScript("scroll(300,0)");
	}

	public boolean VerifyText(WebDriver driver,String Object, String text) throws Exception {

		try{
			WebElement element=driver.findElement(By.xpath(Object));
			String elementText = element.getText();
			System.out.println(elementText);
			if (elementText.equalsIgnoreCase(text)){
				return true;}
		}
		catch(NoSuchElementException e)
		{
			throw new Exception(Object+ "is not found");

		}
		return false;
	}

	public void sendkeysArrowdownEnter(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			Thread.sleep(2000);
			key.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			key.sendKeys(Keys.ENTER);
		} else {
			throw new Exception(key+ "is not found"); 
		}
	}

	/**
	 * it will perform scroll action from given webelement field using Javascript executor
	 * @author Sai Krishna 
	 * @param WebDriver
	 * @param webelement
	 * @param value
	 * @throws Exception 
	 */

	public void JavaScriptscroll(final WebDriver aDriver, WebElement key) throws Exception {
		if(VerifyObject(aDriver, key)){
			JavascriptExecutor jse = ((JavascriptExecutor) aDriver);
			jse.executeScript("arguments[0].scrollIntoView();", key);
		}else
		{
			throw new Exception(key+ "does not exist");
		}
	}
	
	public void JavaScriptscroll(final WebDriver aDriver, String value) throws Exception {
		if(VerifyObject(aDriver, value)){
			JavascriptExecutor jse = ((JavascriptExecutor) aDriver);
			jse.executeScript("arguments[0].scrollIntoView();", value);
		}else
		{
			throw new Exception(value+ "does not exist");
		}
	}

	@SuppressWarnings("unchecked")
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


	public void getSheet(String value) throws Exception {
		Data = value.split(";");
		String TestPath = xTestPath();
		WorkBook = Workbook.getWorkbook(new File(TestPath));
		sheet = WorkBook.getSheet(Data[1]);
	}

	public void xEXCEPTION(WritableSheet RSheet, Exception e, String value,WebDriver driver){
		try{
			RSheet.addCell(new Label(0,Suntuity.RowNo-1,Suntuity.DataSetValue));
			RSheet.addCell(new Label(1,Suntuity.RowNo-1,Suntuity.StepNo));
			RSheet.addCell(new Label(6,Suntuity.RowNo-1,value));
			RSheet.addCell(new Label(9,Suntuity.RowNo-1,"Exception Caught in "+Suntuity.FunctionName+""));
			RSheet.addCell(new Label(11,Suntuity.RowNo-1,"Fail",xFillCell(Colour.RED)));
			RSheet.addCell(new Label(12,Suntuity.RowNo-1,""+e+""));
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String FilePath=xRandomTimeStampName(value);
			FileUtils.copyFile(scrFile, new File(FilePath));
			WritableHyperlink hyperlink = new WritableHyperlink(13, Suntuity.RowNo-1, new File(FilePath),"Error Snapshot Link");
			RSheet.addHyperlink(hyperlink);;
			Suntuity.RowNo++;}
		catch(Exception e1){
			e1.getMessage();
		}
	}
	
	public String xverification(String TestcaseID,WebElement E,String fdescription, WritableSheet RSheet, String Expecetd, String Actual,String value, int NoOfVerify,WebDriver driver) throws Exception {
		String status="",Verification="";
		Verification=VerifyObject(driver,E)==true? Verification: Verification+"Fail, "+fdescription+";";
		status=status+Verification;
		Suntuity.RowNo=xResult(Verification, RSheet, Expecetd, Actual, value, NoOfVerify,TestcaseID);
		return status;
	}
	
	public String xverification(boolean bvalue,String fdescription, String Verification, WritableSheet RSheet, String Expecetd, String Actual,String value, int NoOfVerify,String testcaseid) {
		String status="";
		Verification=bvalue==true? Verification: Verification+"Fail, "+fdescription+";";
		status=status+Verification;
		Suntuity.RowNo=xResult(Verification, RSheet, Expecetd, Actual, value, NoOfVerify,testcaseid);
		return status;
	}

	public void xException(WritableSheet RSheet, Exception e, String value,WebDriver driver,String Testcaseid ){
		try{
			RSheet.addCell(new Label(0,Suntuity.RowNo-1,Suntuity.DataSetValue));
			RSheet.addCell(new Label(1,Suntuity.RowNo-1,Suntuity.StepNo));
			RSheet.addCell(new Label(6,Suntuity.RowNo-1,value));
			RSheet.addCell(new Label(9,Suntuity.RowNo-1,"Exception Caught in "+Suntuity.FunctionName+""));
			RSheet.addCell(new Label(10,Suntuity.RowNo-1,Testcaseid,xFillCell(Colour.RED)));
			RSheet.addCell(new Label(11,Suntuity.RowNo-1,"Fail",xFillCell(Colour.RED)));
			RSheet.addCell(new Label(12,Suntuity.RowNo-1,""+e+""));
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String FilePath=xRandomTimeStampName(value);
			FileUtils.copyFile(scrFile, new File(FilePath));
			WritableHyperlink hyperlink = new WritableHyperlink(13, Suntuity.RowNo-1, new File(FilePath),"Error Snapshot Link");
			RSheet.addHyperlink(hyperlink);
			Suntuity.RowNo++;}
		catch(Exception e1){
			e1.getMessage();
		}
	}

	
	
	

}


