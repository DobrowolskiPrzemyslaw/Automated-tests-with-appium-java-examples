package pl.dobrowolskiprzemyslaw.automatedtests.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Manager {
    private static AndroidDriver driver;
    private static Sequence sequence;
    private static PointerInput finger;
    public static AndroidDriver getDriver() {
        try {
            if (driver == null) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "firstEmulator");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "motorola moto g(60)");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
                desiredCapabilities.setCapability("appPackage","com.booking");
                desiredCapabilities.setCapability("appActivity","com.booking.startup.HomeActivity");
//                URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub"); //for emulator
                URL remoteUrl = new URL("http://127.0.0.1:4723");   // for really
                driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            }
        }catch (MalformedURLException e){
            e.getStackTrace();
        }
        return driver;
    }
    public static void resetDriver(){
        driver = null;
    }
    public static void resetSequence(){
        sequence = null;
    }
    public static void resetFingere(){
        finger = null;
    }
    public static Sequence getSequence() {
        driver = Manager.getDriver();
        if(sequence == null){
            finger = getFinger();
            sequence =  new Sequence(finger,1);
        }
        return sequence;
    }

    public static PointerInput getFinger() {
        if(finger == null){
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        }
        return finger;
    }
}
