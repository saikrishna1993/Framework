package suntuity.testrun.beans;



import javax.swing.JFrame;
import javax.swing.JWindow;


public class TestRunBean {

	//private String RuntestType;
	private String browserAndVersion;
	private String executionType;
	private String buildInfo;
	private String environment;
	private String url;
	private String testScriptFilepathAndName;
	private String DatasetNumbers;
	private String Platformversion;
	private String DeviceName;
	private String ExecutionOn;
	private String Apppacakage;
	private String AppActivity;
	private String RunTestType;
	//private String DeviceType;
	private String AppType;
	private String IOSApp;
	private String OSType;
	private String MobileOS;
	private String androidevice;
	private String IOSDevice;
	private String UserName;
	private String Password;
	private String sandboxname;
	private JWindow loadingPanel;


	public boolean runTest;

	public boolean isRunTest() {
		return runTest;
	}
	public void setRunTest(boolean runTest) {
		this.runTest = runTest;
	}

	public void setsandboxname(String Sandboxname) {
		sandboxname=Sandboxname;
		
	}
	
	public String getsandboxname() {
		return sandboxname;
	}
	public String getRunTestType() {
		return RunTestType;
	}
	public void setRunTestType(String runTestType) {
		RunTestType = runTestType;
	}
	public String getOSType() {
		return OSType;
	}
	public void setOSType(String oSType) {
		OSType = oSType;
	}
	public void setAndroidDevice(String Androiddevice) {
		androidevice=Androiddevice;
		
	}
	public void setUserNameAndPassword(String Username,String password) {
		
		UserName=Username;
		Password=password;
	}
	
	public String getUserNameandPassword() {
		System.out.println(UserName+","+Password);
		return UserName+","+Password;
		
	}
	
	public String getAndroidDevice() {
		return androidevice;
	}
	
	public void setIOSDevice(String IOsDevice) {
		IOSDevice=IOsDevice;
		
	}
	
	public String getIOSDevice() {
		return IOSDevice;
	}
	
	public void setMobileOSType(String mobileOS) {
		MobileOS=mobileOS;	
	}
	public String getMobileOS() {
		return MobileOS;
		
		
	} 
	/*public String getDeviceType() {
		return DeviceType;
	}
	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}*/

	public String getBrowserAndVersion() {
		return browserAndVersion;
	}
	public void setBrowserAndVersion(String browserAndVersion) {
		this.browserAndVersion = browserAndVersion;
	}
	/*public String getRuntestType() {
		return browserAndVersion;
	}
	public void setRuntestType(String RuntestType) {
		this.RuntestType = RuntestType;
	}*/
	public String getExecutionType() {
		return executionType;
	}
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
	public String getBuildInfo() {
		return buildInfo;
	}
	public void setBuildInfo(String buildInfo) {
		this.buildInfo = buildInfo;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTestScriptFilepathAndName() {
		return testScriptFilepathAndName;
	}
	public void setTestScriptFilepathAndName(String testScriptFilepathAndName) {
		this.testScriptFilepathAndName = testScriptFilepathAndName;
	}
	public String getDatasetNumbers() {
		return DatasetNumbers;
	}
	public void setDatasetNumbers(String datasetNumbers) {
		DatasetNumbers = datasetNumbers;
	}
	public String getPlatformversion() {
		return Platformversion;
	}
	public void setPlatformversion(String platformversion) {
		Platformversion = platformversion;
	}

	public String getDeviceName() {
		return DeviceName;
	}
	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}

	public String getExecutionOn() {
		return ExecutionOn;
	}
	public void setExecutionOn(String executionOn) {
		ExecutionOn = executionOn;
	}	

	public String getApppacakage() {
		return Apppacakage;
	}
	public void setApppacakage(String apppacakage) {
		Apppacakage = apppacakage;
	}
	public String getAppActivity() {
		return AppActivity;
	}
	public void setAppActivity(String appActivity) {
		AppActivity = appActivity;
	}
	public JWindow getLoadingPanel() {
		return loadingPanel;
	}
	public void setLoadingPanel(JWindow loadingPanel) {
		this.loadingPanel = loadingPanel;
	}

	public String getAppType() {
		return AppType;
	}
	public void setAppType(String appType) {
		AppType = appType;
	}
	public String getIOSApp() {
		return IOSApp;
	}
	public void setIOSApp(String iOSApp) {
		IOSApp = iOSApp;
	}

}
