package pl.dobrowolskiprzemyslaw.automatedtests.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.BaseElements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

public class AppiumHelper {
    TouchAction touchAction = Manager.getTouchAction();
    AndroidDriver driver  = Manager.getDriver();
    public void scrollTo(String visibleText) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+visibleText+"\"))");
    }
    @Attachment
    public static byte[] takeScreenshot() throws MalformedURLException {
        return ((TakesScreenshot)Manager.getDriver()).getScreenshotAs(OutputType.BYTES);

    }
    public void swipeVerticalBase(int start, int end) {
        int width = driver.manage().window().getSize().getWidth();
        if(end>=0 && end<=width && start>=0 && start<=width) {
            touchAction.press(PointOption.point(100, start))
                    .moveTo(PointOption.point(100, end))
                    .release()
                    .perform();
        }
    }
    public void swipeHorizontalBase(int start, int end) {
        int height = driver.manage().window().getSize().getHeight();
        if(end>=0 && end<=height && start>=0 && start<=height) {
            touchAction.press(PointOption.point(start,100))
                    .moveTo(PointOption.point(end,100))
                    .release()
                    .perform();
        }
    }
}
