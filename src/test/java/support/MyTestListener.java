package support;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import utils.Logger;

public class MyTestListener extends TestListenerAdapter {;

    @Override
    public void onStart(ITestContext context) {
		Logger.initLogFile();
    	Logger.Info("onStart: Init log file");
    }

    @Override
    public void onTestStart(ITestResult result) {
		Logger.Info("onTestStart: Test started "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	if(!result.isSuccess()) {
            /*Logger.Info("onTestFailure: Saving screenshot into the report.");
    		test.get().log(Status.FAIL, result.getThrowable());
            MyContext context = MyContext.getInstance();
			String filename =(String)context.getData("screenshot_name");
            System.out.println("FN: " +filename);
            test.get().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath("images\\"+filename).build());


        	try {
        		FileUtils.copyFile(src, new File(filePath));
        	}
        	catch (IOException e){
        		Logger.Error("onTestFailure: error taking screenshot: "+e.getMessage());
        	}
        	test.get().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath("images\\"+filename).build());
    	*/
    	}
    }

	@Override
	public void onFinish(ITestContext context) {
		Logger.Info("onFinish: Closing log writer");
		Logger.closeWriter();
	}
}
