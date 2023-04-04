package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Label;

import java.util.List;

public class SavedPage {
    Label topLabels;

    public SavedPage(){
        topLabels = new Label(MobileBy.xpath("//android.widget.TextView"));
    }
    @Step("Getting text from labels")
    public List<String> getTextLabels(){
        return topLabels.getTexts();
    }
}
