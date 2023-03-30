package pl.dobrowolskiprzemyslaw.automatedtests.utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AppiumDriver {

    public void tap(String visibleText)  {
        scrollTo(visibleText);
        tapByText(visibleText);
    }
    public void back()  {
        AndroidDriver driver = Manager.getDriver();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void goTo(AndroidKey target)  {
        AndroidDriver driver = Manager.getDriver();
        driver.pressKey(new KeyEvent(target));
    }
    public void clickKeyBoardButton(AndroidKey button) {
        AndroidDriver driver = Manager.getDriver();
        driver.pressKey(new KeyEvent(button));
    }
    public void click(String visibleText)  {
        scrollTo(visibleText);
        clickByText(visibleText);
    }
    public void takeScreenshot() throws IOException {
        AndroidDriver driver = Manager.getDriver();
        File file = driver.getScreenshotAs(OutputType.FILE);
        String unikatowyText = UUID.randomUUID().toString();
        FileUtils.copyFile(file, new File("src/test/resources/"+unikatowyText+".png"));
    }
    public String getText(By locator)  {
        AndroidDriver driver = Manager.getDriver();
        return driver.findElement(locator).getText();
    }
    //src/main/java/javaTips/streems/BoardGame.java
    public static List<String> getTexts(By locator)  {
        AndroidDriver driver = Manager.getDriver();
        List<WebElement> elements = driver.findElements(locator);
        List<String> values = elements.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        return values;
    }
    public static void showTexts(By locator)  {
        AndroidDriver driver = Manager.getDriver();
        List<WebElement> elements = driver.findElements(locator);
        List<String> values = elements.stream().map(WebElement::getText)
                .toList();
        for(String value: values){
            System.out.println(value);
        }
    }
    public void showContexts()  {
        AndroidDriver driver = Manager.getDriver();
        waitUntilMoreThanOneContext(1);
        driver.getContextHandles().forEach(System.out::println);
    }
    public void switchContext(String target)  {
        AndroidDriver driver = Manager.getDriver();
        waitUntilMoreThanOneContext(1);
        driver.context(target);
    }

    public void switchFrame(int target)  {
        AndroidDriver driver = Manager.getDriver();
        driver.switchTo().frame(target);
    }
    public void click(By locator) {
        AndroidDriver driver = Manager.getDriver();
        driver.findElement(locator).click();
    }
    public void waitUntilVisibleAndClick(By locator) {
        AndroidDriver driver = Manager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }
    public void waitUntilVisibleAndTryClick(By locator) {
        AndroidDriver driver = Manager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5L);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator).click();
        }catch (TimeoutException e){
            System.out.println("WebElement wasn't displayed");
        }
    }
    public void waitUntilMoreThanOneContext(int expectedSizeContext) {
        AndroidDriver driver = Manager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(CostomConditions.contextSizeIs(expectedSizeContext));
    }
    public void dragAndDrop(MobileElement starElement, MobileElement endElement) {
        TouchAction touchAction = Manager.getTouchAction();
        touchAction.longPress(longPressOptions().withElement(element(starElement)).withDuration(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endElement.getCenter()))
                .release()
                .perform();
    }
    public void swipeVertical(int start, int end) {
        TouchAction touchAction = Manager.getTouchAction();
        AndroidDriver driver = Manager.getDriver();
        int width = driver.manage().window().getSize().getWidth();
        if(end>=0 && end<=width && start>=0 && start<=width) {
            touchAction.press(PointOption.point(100, start))
                    .moveTo(PointOption.point(100, end))
                    .release()
                    .perform();
        }
    }
    public void swipeHorizontal(int start, int end) {
        AndroidDriver driver = Manager.getDriver();
        TouchAction touchAction = Manager.getTouchAction();
        int height = driver.manage().window().getSize().getHeight();
        if(end>=0 && end<=height && start>=0 && start<=height) {
            touchAction.press(PointOption.point(start,100))
                    .moveTo(PointOption.point(end,100))
                    .release()
                    .perform();
        }
    }
    public void sendKeys(By locator, String text) {
        AndroidDriver driver = Manager.getDriver();
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(text);
    }

    public void check(By locator) {
        AndroidDriver driver = Manager.getDriver();
        if(driver.findElement(locator).getAttribute("checked").equals("false")){
            driver.findElement(locator).click();
        }
    }
    public void uncheck(By locator) {
        AndroidDriver driver = Manager.getDriver();
        if(driver.findElement(locator).getAttribute("checked").equals("true")){
            driver.findElement(locator).click();
        }
    }
    public void clear(By locator) {
        AndroidDriver driver = Manager.getDriver();
        driver.findElement(locator).clear();
    }
    public boolean isSelected(By locator) {
        AndroidDriver driver = Manager.getDriver();
        return driver.findElement(locator).getAttribute("checked") == "true";
    }
    public boolean isChecked(By locator) {
        AndroidDriver driver = Manager.getDriver();
        return driver.findElement(locator).getAttribute("checked").equals("true");
    }
    public boolean isDisplayed(By locator) {
        AndroidDriver driver = Manager.getDriver();
        return driver.findElement(locator).isDisplayed();
    }
    public boolean isEnabled(By locator) {
        AndroidDriver driver = Manager.getDriver();
        return driver.findElement(locator).isEnabled();
    }
    public boolean exist(By locator) {
        AndroidDriver driver = Manager.getDriver();
        return driver.findElements(locator).size()>0;
    }
    public boolean exist2(By locator) {
        boolean exist = false;
        AndroidDriver driver = Manager.getDriver();
        try{
            driver.findElement(locator);
            exist = true;
        }catch (NoSuchElementException e){
            System.out.println("Element not found");
        }
        return exist;
    }
    public void longPress(String visibleText) {
        scrollTo(visibleText);
        longPressByText(visibleText);
    }
    public void scrollTo(String visibleText) {
        AndroidDriver driver = Manager.getDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+visibleText+"\"))");
    }
    public void scrollUpTo(By locator) {
        AndroidDriver driver = Manager.getDriver();
        int height = driver.manage().window().getSize().getHeight();
        boolean isDisplayed = false;
        int counter = 0;
        while(!isDisplayed) {
            TouchAction touchAction = Manager.getTouchAction();
            touchAction.longPress(PointOption.point(300, height / 2))
                    .moveTo(PointOption.point(300, height / 2 - height / 4))
                    .release()
                    .perform();
            try {
                isDisplayed = isDisplayed(locator);
            } catch (NoSuchElementException e) {
                System.out.println("WebElement isn't displayed.");
                if(++counter>10){
                    break;
                }
            }
        }
    }
    private void tapByText(String visibleText) {
        AndroidDriver driver = Manager.getDriver();
        TouchAction touchAction = Manager.getTouchAction();
        WebElement webElement = driver.findElement(MobileBy.xpath("//*[@text='"+visibleText+"']"));
        touchAction.tap(tapOptions().withElement(element(webElement))).perform();
    }
    private void longPressByText(String visibleText) {
        AndroidDriver driver = Manager.getDriver();
        TouchAction touchAction = Manager.getTouchAction();
        WebElement webelement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+visibleText+"\"))");
        touchAction.longPress(longPressOptions().withElement(element(webelement))).perform();
    }
    private void clickByText(String visibleText) {
        AndroidDriver driver = Manager.getDriver();
        driver.findElement(MobileBy.xpath("//*[@text='"+visibleText+"']")).click();
    }
}
