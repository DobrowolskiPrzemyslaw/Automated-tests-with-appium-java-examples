package pl.dobrowolskiprzemyslaw.automatedtests.test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.dobrowolskiprzemyslaw.automatedtests.utils.Manager;

public class BaseTest {
    AndroidDriver driver;
    TouchAction touchAction;

    @BeforeMethod
    public void setUp() {
        driver = Manager.getDriver();
        touchAction = Manager.getTouchAction();
    }
    @AfterMethod
    public void tearDown() {
        Manager.resetDriver();
        Manager.resetTouchAction();
        driver.quit();
    }
}
