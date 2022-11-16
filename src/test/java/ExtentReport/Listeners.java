package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest extentTest;



    @Override
    public void onTestStart(ITestResult result) {

        extentTest= extent.createTest(result.getMethod().getMethodName());
    }


    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.log(Status.PASS, "Test case"+" "+ result.getMethod().getMethodName()+" "+ "has passed");

    }

    @Override
    public void onFinish(ITestContext result) {
        extent.flush();
    }

    public void onStart(ITestContext Result){
        extent=ExtentReportManager.extemtSetup();
    }



}
