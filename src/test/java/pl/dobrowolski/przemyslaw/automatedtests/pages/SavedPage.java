package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Label;
import java.util.List;

public class SavedPage {

    private final Label topLabels;

    public SavedPage(){
        topLabels = new Label(AppiumBy.xpath("//android.widget.TextView"));
    }

    @Step("Getting text from labels")
    public List<String> getTextLabels(){
        return topLabels.getTexts();
    }
}
