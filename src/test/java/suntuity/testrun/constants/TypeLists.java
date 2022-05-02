package suntuity.testrun.constants;


import java.util.HashMap;
import java.util.Map;

public class TypeLists {

	public static String[] getTesttype(){
		String[] Testtype = {"Select Test Type ","Desktop_Web","Mobile_Web"};
		return Testtype;
	}

	public static String[] getappname(){
		String[] Apps = {"AppName","Onepager","Enerflo"};
		return Apps;
	}
	public static String[] getWindowsBrowsers(){
		String[] browsers = {"Select Browser","Firefox","IE","Chrome"};
		return browsers;
	}	
	
	public static String[] getIOSBrowser(){
		String[] browsers = {"Select Browser","Safari"};
		return browsers;
	}
	
	public static String[] getBrowsers(){
		String[] browsers = {"Select Browser","Firefox","IE","Chrome","Safari"};
		return browsers;
	}
	
	public static String[] getDesktopOS(){
		String[] Mobile = {"Select Test Type","Windows","IOS"};
		return Mobile;
	}

	public static String[] getMobileos(){
		String[] Mobile = {"Select Test Type","Android","IOS"};
		return Mobile;
	}

	public static String[] getMobilebrowser(){
		String[] Mobile = {"Chrome","Safari","Browser"};
		return Mobile;
	}

	public static String[] getExecutionTypes(){
		//NewScript,Smoke can be added here 
		String[] executionTypes ={"Select Execution Type","Regression"};
		return executionTypes;
	}

	public static String[] getEnvironment(){
		//DEV
		String[] environment = {"Select Environment Type","QA" };
		return environment;
	}

	public static String[] getPlatformversion(){
		String[] Platformversion = {"4.4.2","4.4.4","4.2.2","5.1.1"};
		return Platformversion;
	}

	public static String[] getandroiddevicelist(){
		String[] AndroidDevices = {"Samsung S10","Samsung S20","Google Pixel 3"};
		return AndroidDevices;
	}
	
	public static String[] GetCRMROLES() {
		String[] CRMROLES= {"Set Role","ALL Users", "IT-Admin","Sales Rep"};
		
		return CRMROLES;
	}

	public static String[] getIOSDevicelist() {
		String []IOSDevices = {"IPhone X"};
		return IOSDevices;
	}
	public static String[] getExecutionOn(){
		String[] ExecutionType = {"Select Execution On","App","Browser"};
		return ExecutionType;
	}

	public static String[] getApppacakage(){
		String[] Apppacakage = {"Select App Package"};
		return Apppacakage;
	}

	public static String[] getAppActivity(){
		String[] Apppacakage = {"Select App Activity"};
		return Apppacakage;
	}

	public static String[] getAppType(){
		String[] AppType = {"Select App Type","type 1","type 2"};
		return AppType;
	}

	public static String[] getIOSApp(){
		String[] AppType = {"Select IOS App","ios app 1","ios app 2"};
		return AppType;
	}

	public static String[] getSchedulerEnvironments(){
		String[] environment = {"CS","PROD"};
		return environment;
	}

	public static String[] getExecutionTypeTypelist(String executionType){
		Map<String,String[]> executionTypesMap = new HashMap<String,String[]>();

		executionTypesMap.put("Smoke",getEnvironment() );
		executionTypesMap.put("Regression",getRegressionEnvironments() );
		executionTypesMap.put("NewScript", getNewScriptEnvironments());

		return executionTypesMap.get(executionType);
	}

	public static String[] getRunTestTypeTypelist(String browserAndVersion){
		Map<String,String[]> TestTypesMap = new HashMap<String,String[]>();
		
		TestTypesMap.put("Desktop_Web",getBrowsers());
		TestTypesMap.put("Mobile_Web",getMobilebrowser());
		return TestTypesMap.get(browserAndVersion);
	}

	private static String[] getRegressionEnvironments(){
		String[] environment = {"Select Environment Type","QA"};
		return environment;
	}

	private static String[] getNewScriptEnvironments(){
		String[] environment = {"Select Environment Type","DEV","QA"};
		return environment;
	}

}
