package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Button;
public class CalendarPage {

    Button startData;
    Button endData;
    Button item;
    Button confirmButton;

    public CalendarPage(){
        item = new Button(MobileBy.xpath("//android.widget.TextView[text(),'London']"));
        confirmButton = new Button(MobileBy.id("com.booking:id/facet_date_picker_confirm"));
    }
    @Step("Setting a travel date from {0} to {1}")
    public void inputTravelDate(String start, String end){
        setDate(start, end);
        startData.scrollDown();
        startData.click();
        endData.scrollDown();
        endData.click();
        item.click();
        confirmButton.click();
    }

    public void setDate(String start, String end){
        try{
            startData = new Button(MobileBy.xpath("//android.view.View[@content-desc=\""+start+"\n" + "\"]"));
            endData = new Button((MobileBy.AccessibilityId(end)));
        }catch (TimeoutException e){
            System.out.println("Inputted incorrect date");
        }
    }
}
