package pl.dobrowolski.przemyslaw.automatedtests.utils;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import pl.dobrowolski.przemyslaw.automatedtests.elements.BaseElements;

import java.time.Duration;

public class AppiumHelper {
    @Attachment
    public static byte[] takeScreenshot() {
       return ((TakesScreenshot)Manager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
    public static void scrollDown(BaseElements element){
        AndroidDriver driver = Manager.getDriver();
        Sequence sequence = Manager.getSequence();
        PointerInput finger = Manager.getFinger();
        Dimension screenSize = driver.manage().window().getSize();
        int height = screenSize.getHeight();
        int width = screenSize.getWidth();
        int centerX = width/2;
        boolean isDisplayed = false;
        int counter = 0;
        while(!isDisplayed) {
            sequence.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,height/2));
            sequence.addAction(finger.createPointerDown(0));
            sequence.addAction(finger.createPointerMove(Duration.ofSeconds(700),PointerInput.Origin.viewport(),centerX,height/4));
            sequence.addAction(finger.createPointerUp(0));
            try {
                isDisplayed= element.isDisplayedBase();
            } catch (NoSuchElementException e) {
                System.out.println("WebElement isn't displayed.");
                if(++counter>10){
                    break;
                }
            }
        }
    }
    public static void scrollUp(BaseElements element){
        AndroidDriver driver = Manager.getDriver();
        Sequence sequence = Manager.getSequence();
        PointerInput finger = Manager.getFinger();
        Dimension screenSize = driver.manage().window().getSize();
        int height = screenSize.getHeight();
        int width = screenSize.getWidth();
        int centerX = width/2;
        boolean isDisplayed = false;
        int counter = 0;
        while(!isDisplayed) {
            sequence.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,height/4));
            sequence.addAction(finger.createPointerDown(0));
            sequence.addAction(finger.createPointerMove(Duration.ofSeconds(700),PointerInput.Origin.viewport(),centerX,height/2 ));
            sequence.addAction(finger.createPointerUp(0));
            try {
                isDisplayed = element.isDisplayedBase();
            } catch (NoSuchElementException e) {
                System.out.println("WebElement isn't displayed.");
                if(++counter>10){
                    break;
                }
            }
        }
    }
}
