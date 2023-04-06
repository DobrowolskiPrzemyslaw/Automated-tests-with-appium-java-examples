package pl.dobrowolski.przemyslaw.automatedtests.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.dobrowolski.przemyslaw.automatedtests.utils.Manager;

public class BaseTest {
    protected AndroidDriver driver;
    protected Sequence sequence;

    @BeforeMethod
    public void setUp() {
        driver = Manager.getDriver();
        sequence = Manager.getSequence();
    }
    @AfterMethod
    public void tearDown() {
        Manager.resetDriver();
        Manager.resetSequence();
        Manager.resetFingere();
        driver.quit();
    }
}
