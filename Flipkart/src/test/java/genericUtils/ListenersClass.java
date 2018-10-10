package genericUtils;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;

import baseClassFloder.BaseClass;

public class ListenersClass extends BaseClass implements ITestListener 
{
	
	Logger log=Logger.getLogger(ListenersClass.class);
	public void onFinish(ITestContext result) {
		
		
	}

	public void onStart(ITestContext result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		log.error(result.getName()+" failed due to......"+ result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		log.error(result.getName()+" skipped due to......"+ result.getThrowable());
		
	}

	public void onTestStart(ITestResult result) {
		log.info(result.getName()+" started......");
		
	}

	public void onTestSuccess(ITestResult result) {
		log.info(result.getName()+" successfully completed......");
		
	}

}
