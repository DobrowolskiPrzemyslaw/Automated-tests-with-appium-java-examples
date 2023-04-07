package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Button;
import pl.dobrowolski.przemyslaw.automatedtests.test.BaseTest;
import pl.dobrowolski.przemyslaw.automatedtests.utils.AppiumHelper;

public class CalendarPage {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private Button startData;
    private Button endData;
    private final Button item;
    private final Button confirmButton;

    public CalendarPage(){
        item = new Button(AppiumBy.xpath("//android.widget.TextView[text(),'London']"));
        confirmButton = new Button(AppiumBy.id("com.booking:id/facet_date_picker_confirm"));
    }

    @Step("Setting a travel date from {0} to {1}")
    public void inputTravelDate(String start, String end){
        logger.info("Setting a travel date from " +start+ " to "+end);
        setDate(start, end);
        AppiumHelper.scrollDown(startData);
        startData.click();
        AppiumHelper.scrollDown(endData);
        endData.click();
        item.click();
        confirmButton.click();
    }

    public void setDate(String start, String end){
        try{
            startData = new Button(AppiumBy.xpath("//android.view.View[@content-desc=\""+start+"\"]"));
            endData = new Button(AppiumBy.xpath("//android.view.View[@content-desc=\""+end+"\"]"));
            logger.info("Set correct date");
        }catch (TimeoutException e){
            System.out.println("Inputted incorrect date");
            logger.info("Inputted incorrect date");
        }
    }
}
