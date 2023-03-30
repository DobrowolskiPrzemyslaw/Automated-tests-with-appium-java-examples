package pl.dobrowolskiprzemyslaw.automatedtests.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CostomConditions {
    public static ExpectedCondition<Boolean> contextSizeIs(final int expectedContextSize) {
        return new ExpectedCondition<Boolean>() {
            private int contextSize;
            public Boolean apply(WebDriver driver) {
                AndroidDriver androidDriver = (AndroidDriver)driver;
                contextSize = androidDriver.getContextHandles().size();
                return contextSize == expectedContextSize;
            }

            public String toString() {
                return String.format("Expected context size to be \"%s\". Current context size: \"%s\"", expectedContextSize, contextSize);
            }
        };
    }
}
