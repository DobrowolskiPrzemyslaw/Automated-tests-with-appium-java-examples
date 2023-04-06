package pl.dobrowolski.przemyslaw.automatedtests.elements;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.dobrowolski.przemyslaw.automatedtests.utils.Manager;

import java.time.Duration;
import java.util.List;

public class BaseElements {
    AndroidDriver driver = Manager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    By locator;
    protected BaseElements(By locator) {
        this.locator = locator;
    }
    protected WebElement waitUnilVisibeBase(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void sendTextBase(String text){
        waitUnilVisibeBase().clear();
        waitUnilVisibeBase().sendKeys(text);
    }
    protected void clickOnElementBase(){
        waitUnilVisibeBase().click();
    }

    protected List<String> getTextsBase(){
        waitUnilVisibeBase();
        List<WebElement> elements = driver.findElements(locator);
        return elements.stream().map(WebElement::getText).toList();
    }
    public boolean isDisplayedBase() {
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
}
