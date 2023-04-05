package pl.dobrowolskiprzemyslaw.automatedtests.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.BaseElements;

public class AppiumHelper {
    @Attachment
    public static byte[] takeScreenshot() {
       return ((TakesScreenshot)Manager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
    public static void scrollDown(BaseElements element){
        AndroidDriver driver = Manager.getDriver();
        TouchAction touchAction = Manager.getTouchAction();
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        boolean isDisplayed = false;
        int counter = 0;
        while(!isDisplayed) {
            touchAction.longPress(PointOption.point(width/2, height / 2))
                    .moveTo(PointOption.point(width/2, height / 2 - height / 8))
                    .release()
                    .perform();
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
        TouchAction touchAction = Manager.getTouchAction();
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        boolean isDisplayed = false;
        int counter = 0;
        while(!isDisplayed) {
            touchAction.longPress(PointOption.point(width/2, height / 2 - height / 8))
                    .moveTo(PointOption.point(width/2, height / 2))
                    .release()
                    .perform();
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
