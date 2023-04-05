package pl.dobrowolskiprzemyslaw.automatedtests.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(Listener.class);
    @Override
    public void onTestStart(final ITestResult result) {
        logger.info("Wystartowal test");
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
        logger.info("Test ended with a success");
    }

    @Override
    public void onTestFailure(final ITestResult result) {
        AppiumHelper.takeScreenshot();
        logger.info("Test ended with a failure");
    }

    @Override
    public void onTestSkipped(final ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(final ITestResult result) {

    }

    @Override
    public void onStart(final ITestContext context) {

    }

    @Override
    public void onFinish(final ITestContext context) {

    }
}
