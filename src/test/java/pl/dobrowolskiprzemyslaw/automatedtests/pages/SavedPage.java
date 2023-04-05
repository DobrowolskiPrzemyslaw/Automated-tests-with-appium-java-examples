package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Label;
import java.util.List;

public class SavedPage {
    Label topLabels;
    public SavedPage(){
        topLabels = new Label(By.xpath("//android.widget.TextView"));
    }
    @Step("Getting text from labels")
    public List<String> getTextLabels(){
        return topLabels.getTexts();
    }
}
