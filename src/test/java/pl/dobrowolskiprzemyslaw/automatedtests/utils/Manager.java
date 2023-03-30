package pl.dobrowolskiprzemyslaw.automatedtests.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Manager {
    private static AndroidDriver driver;
    private static TouchAction touchAction;
    public static AndroidDriver getDriver() {
        try {
            if (driver == null) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "firstEmulator");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
                desiredCapabilities.setCapability("appPackage","com.booking");
                desiredCapabilities.setCapability("appActivity","com.booking.startup.HomeActivity");
                URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
                driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            }
        }catch (MalformedURLException e){
            e.getStackTrace();
        }
        return driver;
    }
    public static TouchAction getTouchAction() {
        driver = Manager.getDriver();
        if(touchAction == null){
            touchAction =  new TouchAction(driver);
        }
        return touchAction;
    }
}