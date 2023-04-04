package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Label;

import java.util.List;

public class EndPage {
    Label topLabels;

    public EndPage(){
        topLabels = new Label(MobileBy.id("com.booking:id/toolbar_item_label"));
    }
    @Step("Getting text from labels")
    public List<String> getTextLabels(){
        return topLabels.getTexts();
    }
}
