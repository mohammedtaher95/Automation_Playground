package listeners.testng;

import driverfactory.Driver;
import org.testng.*;
import utilities.ScreenShotManager;

public class TestNGListener implements IExecutionListener, ITestListener {

    @Override
    public void onExecutionStart() {
        System.out.println("**************** Welcome to Selenium Framework *****************");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Generating Report........");
        System.out.println("********************* End of Execution *********************");
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("*******  Starting Test: " + result.getName() + " ***************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*******  Success of Test: " + result.getName() + " ***************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
        System.out.println("Taking screen shot.....");
        ScreenShotManager.captureScreenshot(Driver.get(), result.getName());

        System.out.println("******* Failure of Test: " + result.getName() + " ***************");


    }
}
