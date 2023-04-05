package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Button;
import pl.dobrowolskiprzemyslaw.automatedtests.test.BaseTest;
import pl.dobrowolskiprzemyslaw.automatedtests.utils.AppiumHelper;

public class CalendarPage {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    Button startData;
    Button endData;
    Button item;
    Button confirmButton;

    public CalendarPage(){
        item = new Button(By.xpath("//android.widget.TextView[text(),'London']"));
        confirmButton = new Button(By.id("com.booking:id/facet_date_picker_confirm"));
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
            startData = new Button(By.xpath("//android.view.View[@content-desc=\""+start+"\"]"));
            endData = new Button((By.id(end)));
            logger.info("Set correct date");
        }catch (TimeoutException e){
            System.out.println("Inputted incorrect date");
            logger.info("Inputted incorrect date");
        }
    }
}
