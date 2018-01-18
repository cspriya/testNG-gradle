package utils.Listners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import utils.Reporter.Reporter;

/**
 * Created by N.Khmurych on 12.06.2017.
 */
public class Listner extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result){
        Reporter.saveScreenshot(result);
        Reporter.getBrowserLog(result);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.saveScreenshot(result);
    }
}
