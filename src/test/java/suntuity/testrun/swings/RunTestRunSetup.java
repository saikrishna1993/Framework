package suntuity.testrun.swings;


import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import suntuity.testrun.beans.TestRunBean;



public class RunTestRunSetup {

	public static TestRunBean runTest() throws InterruptedException {
		TestRunBean testRunBean = new  TestRunBean();
		TestRunSetup.runTest(testRunBean);
		int count =0;
		while(true){	
			try {
				Thread.sleep(1000);
				if(testRunBean.isRunTest()){
					break;
				}
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		}

		return testRunBean;
	}
}

