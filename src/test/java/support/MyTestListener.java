package support;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Logger;

public class MyTestListener extends TestListenerAdapter {
    static private ExtentReports report;
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
		Logger.initLogFile();
    	Logger.Info("onStart: Configuring extent report");
    	report = new ExtentReports();
    	ExtentSparkReporter spark = new ExtentSparkReporter("target/results/TestReport.html");
        report.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {
		Logger.Info("onTestStart: Creating entry in the report");
    	test.set(report.createTest(result.getName().split(" ")[0]));
    	test.get().log(Status.INFO, "Test started");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	if(!result.isSuccess()) {
    		test.get().log(Status.FAIL, result.getThrowable());
/*
    		Object currentTestInstance = result.getInstance(); //This will return an instance of TestRunner class
			//TestRunner tr = (TestRunner)currentTestInstance;
			//WebDriver driver = tr.getBaseTest().getDriver();
			//File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		File src= ((TakesScreenshot)((BaseTest)currentTestInstance).getDriver()).getScreenshotAs(OutputType.FILE);
    		String currentWorkingDir = System.getProperty("user.dir");
    		String filename = "error_"+result.getName().split(" ")[0]+".png";
        	String filePath = currentWorkingDir+"\\target\\results\\images\\"+filename;
      
        	try {
        		FileUtils.copyFile(src, new File(filePath));
        	}
        	catch (IOException e){
        		Logger.Error("onTestFailure: error taking screenshot: "+e.getMessage());
        	}
        	test.get().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath("images\\"+filename).build());*/
    	}
    }

	@Override
	public void onFinish(ITestContext context) {
		Logger.Info("onFinish: Closing log writer");
		Logger.closeWriter();
	}
}
