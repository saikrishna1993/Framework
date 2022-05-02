package source;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import suntuity.Utilities.UtilityScript;
import suntuity.testrun.swings.RunTestRunSetup;

public class initilize extends UtilityScript {
		
	@Test
	public void Test_initilize_main() throws Exception {
		
		File directory = new File (".//");
		String MainFolder=directory.getCanonicalPath()+"\\";
		String[] command = {"C:/WINDOWS/system32/cmd.exe", "/c", "C:/WINDOWS/system32/wscript.exe"+" "+directory.getCanonicalPath()+"\\initilize.vbs"+" "+MainFolder};
		try {
			System.out.println(command);
		  	Process p = Runtime.getRuntime().exec(command);
			p.waitFor();
			//Runtime.getRuntime().exec("wscript.exe "+directory.getCanonicalPath()+"\\initilize.vbs " +MainFolder);
		if(!xRunasForm().equalsIgnoreCase("Beta Test")){
			testRunBean=RunTestRunSetup.runTest();
			TestNGRunflag = true;}
		}
		catch(Exception e){e.printStackTrace();
		}
		//xKillIEs(); 
		Wait(3000);
	}
}