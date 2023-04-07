package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Label;

import java.util.List;

public class EndPage {

    private final Label topLabels;

    public EndPage(){
        topLabels = new Label(AppiumBy.id("com.booking:id/toolbar_item_label"));
    }

    @Step("Getting text from labels")
    public List<String> getTextLabels(){
        return topLabels.getTexts();
    }
}
