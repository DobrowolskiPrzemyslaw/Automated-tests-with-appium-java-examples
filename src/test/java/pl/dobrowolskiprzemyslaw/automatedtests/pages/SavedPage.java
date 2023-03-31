package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Label;

import java.util.List;

public class SavedPage {
    Label topLabels;

    public SavedPage(){
        topLabels = new Label(MobileBy.xpath("//android.widget.TextView"));
    }
    public List<String> getTextLabels(){
        return topLabels.getTexts();
    }
}
