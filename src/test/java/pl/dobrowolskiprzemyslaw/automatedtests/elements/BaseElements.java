package pl.dobrowolskiprzemyslaw.automatedtests.elements;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.dobrowolskiprzemyslaw.automatedtests.utils.AppiumHelper;
import pl.dobrowolskiprzemyslaw.automatedtests.utils.CostomConditions;
import pl.dobrowolskiprzemyslaw.automatedtests.utils.Manager;

import java.time.Duration;
import java.util.List;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class BaseElements {
    AndroidDriver driver = Manager.getDriver();
    TouchAction touchAction = Manager.getTouchAction();
    AppiumHelper appiumHelper = new AppiumHelper();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    By locator;

    protected BaseElements(By locator) {
        this.locator = locator;
    }
    protected WebElement waitUnilVisibeBase(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitUnilPresentedBase(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected void sendTextBase(String text){
        waitUnilVisibeBase().clear();
        waitUnilVisibeBase().sendKeys(text);
    }
    protected void clickOnElementBase(){
        waitUnilVisibeBase().click();
    }
    protected void scrollDownBase(){
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
                isDisplayed = isDisplayedBase();
            } catch (NoSuchElementException e) {
                System.out.println("WebElement isn't displayed.");
                if(++counter>10){
                    break;
                }
            }
        }
    }
    protected void scrollUpBase(){
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
                isDisplayed = isDisplayedBase();
            } catch (NoSuchElementException e) {
                System.out.println("WebElement isn't displayed.");
                if(++counter>10){
                    break;
                }
            }
        }
    }
    protected Select getSelectBase(){
        return new Select(waitUnilPresentedBase());
    }
    protected void selectByVisibleTextBase (String visibleText){
        getSelectBase().selectByVisibleText(visibleText);
    }
    protected void backBase()  {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    protected void goToBase(AndroidKey target)  {
        driver.pressKey(new KeyEvent(target));
    }
    protected void clickKeyBoardBase(AndroidKey button) {
        driver.pressKey(new KeyEvent(button));
    }
    protected List<String> getTextsBase(){
        waitUnilVisibeBase();
        List<WebElement> elements = driver.findElements(locator);
        List<String> values = elements.stream().map(e -> e.getText()).toList();
        return values;
    }
    protected void showContexts()  {
        waitUntilMoreThanOneContextBase(1);
        driver.getContextHandles().forEach(System.out::println);
    }
    protected void switchContext(String target)  {
        waitUntilMoreThanOneContextBase(1);
        driver.context(target);
    }
    protected void switchFrame(int target)  {
        driver.switchTo().frame(target);
    }
    protected void waitUntilVisibleAndClickBase() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }
    protected void waitUntilVisibleAndTryClickBase() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator).click();
        }catch (TimeoutException e){
            System.out.println("WebElement wasn't displayed");
        }
    }
    protected void waitUntilMoreThanOneContextBase(int expectedSizeContext) {
        wait.until(CostomConditions.contextSizeIs(expectedSizeContext));
    }
    protected void sendKeysBase(String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(text);
    }

    protected void checkBase() {
        if(driver.findElement(locator).getAttribute("checked").equals("false")){
            driver.findElement(locator).click();
        }
    }
    protected void uncheckBase() {
        if(driver.findElement(locator).getAttribute("checked").equals("true")){
            driver.findElement(locator).click();
        }
    }
    protected void clear() {
        driver.findElement(locator).clear();
    }
    protected boolean isSelectedBase() {
        return driver.findElement(locator).getAttribute("checked") == "true";
    }
    protected boolean isCheckedBase() {
        return driver.findElement(locator).getAttribute("checked").equals("true");
    }
    protected boolean isDisplayedBase() {
        return driver.findElement(locator).isDisplayed();
    }
    protected boolean isPresentBase() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean present;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            present = true;
        } catch (NoSuchElementException e) {
            System.out.println("WebElement isn't exist");
            present = false;
        } catch (TimeoutException e) {
            System.out.println("WebElement isn't displayed");
            present = false;
        }
        return present;
    }
    protected boolean isEnabledBase() {
        return driver.findElement(locator).isEnabled();
    }
    protected boolean exist() {
        return driver.findElements(locator).size()>0;
    }

    protected void tapBase2(String visibleText) {

        WebElement webElement = driver.findElement(MobileBy.xpath("//*[@text='"+visibleText+"']"));
        touchAction.tap(tapOptions().withElement(element(webElement))).perform();
    }
//    protected void longPressBase(String visibleText) {
//        WebElement webelement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+visibleText+"\"))");
//        touchAction.longPress(longPressOptions().withElement(element(webelement))).perform();
//    }
    protected void clickByText(String visibleText) {
        driver.findElement(MobileBy.xpath("//*[@text='"+visibleText+"']")).click();
    }
}
