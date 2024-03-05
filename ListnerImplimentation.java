package CommonUtils;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentation implements ITestListener{
	ExtentReports report;
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName= result.getMethod().getMethodName();
		Reporter.log(methodName+" TestScript execution is started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName= result.getMethod().getMethodName();
		//Reporter.log(methodName+" TestScript execution is Passed");
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodName= result.getMethod().getMethodName();
		Reporter.log(methodName+" TestScript execution is Failure"+message);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		String methodName= result.getMethod().getMethodName();
		Reporter.log(methodName+" TestScript execution is Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("Execution is started",true);
		
		JavaUtil jutil=new JavaUtil();
		//ExtentSparkReporter class just to configure extent report
		//Create the object of ExtentSparkReporter
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extentReport/report"+jutil.getRandomNumber()+".html");
		//to give the title to a report
		reporter.config().setDocumentTitle("vtigerCRM");
		//to set the theme for extent report
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Gauri");
		
		//Create the object of ExtentReports to generate extent report
	    report=new ExtentReports();
		//to attach the configurations
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Chromeversion", "121");
		report.setSystemInfo("Author", "Gauri Bhirad");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("Execution is finished",true);
		report.flush();
		
	}
	

}
