package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
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
    public void setData(String start, String end){
        try{
            startData = new Button(MobileBy.xpath("//android.view.View[@content-desc=\""+start+"\n" + "\"]"));
            endData = new Button((MobileBy.AccessibilityId(end)));
        }catch (TimeoutException e){
            System.out.println("Inputted incorrect date");
        }
    }
    public void inputTravelData(String start, String end){
        setData(start, end);
        startData.scrollDown();
        startData.click();
        endData.scrollDown();
        endData.click();
        item.click();
        confirmButton.click();
    }
}
