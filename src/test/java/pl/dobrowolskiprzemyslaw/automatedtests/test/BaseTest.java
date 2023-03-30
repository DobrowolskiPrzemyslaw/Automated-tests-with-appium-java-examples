package pl.dobrowolskiprzemyslaw.automatedtests.test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import pl.dobrowolskiprzemyslaw.automatedtests.utils.Manager;

public class BaseTest {
    AndroidDriver driver;
    TouchAction touchAction;

    @Before
    public void setUp() {
        driver = Manager.getDriver();
        touchAction = Manager.getTouchAction();
    }
    @After
    public void tearDown() {
//        driver.quit();
    }
}
