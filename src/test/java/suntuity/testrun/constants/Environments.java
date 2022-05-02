package suntuity.testrun.constants;

import java.util.HashMap;
import java.util.Map;

public class Environments {

	public  String getUrlTestScriptFilePath(String executionType,String environment){

		Map<String,Map<String,String>> environmentMap = new HashMap<String, Map<String,String>>();
		environmentMap.put("Smoke",getSmokeEnvironment());
		environmentMap.put("Regression",getRegressionEnvironment());
		environmentMap.put("NewScript",getNewScriptEnvironment());
		return environmentMap.get(executionType).get(environment);
	}

	private Map<String,String> getSmokeEnvironment(){
		Map<String,String> smokeEnvironmentMap = new HashMap<String,String>();
		smokeEnvironmentMap.put("DEV", ",Smoke\\Suntuity_Smoke_TestScripts_DEV.xls");
		smokeEnvironmentMap.put("QA", ",Smoke\\Suntuity_Smoke_TestScripts_QA.xls");
		return smokeEnvironmentMap;
	}

	private Map<String,String> getRegressionEnvironment(){
		Map<String,String> regressionEnvironmentMap = new HashMap<String,String>();
		regressionEnvironmentMap.put("DEV", ",Regression\\Suntuity_Regression_TestScripts_DEV.xls");
		regressionEnvironmentMap.put("QA", ",Regression\\Suntuity_Regression_TestScripts_QA.xls");
		return regressionEnvironmentMap;
	}

	private Map<String,String> getNewScriptEnvironment(){
		Map<String,String> newScriptEnvironmentMap = new HashMap<String, String>();
		newScriptEnvironmentMap.put("DEV", ",NewScript\\Suntuity_TestScripts_Dev.xls");
		newScriptEnvironmentMap.put("QA", ",NewScript\\Suntuity_TestScripts_QA.xls");	
		return newScriptEnvironmentMap;
	}
}

