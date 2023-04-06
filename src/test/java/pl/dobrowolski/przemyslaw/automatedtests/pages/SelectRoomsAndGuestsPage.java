package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Button;
import pl.dobrowolski.przemyslaw.automatedtests.elements.ListBox;
import pl.dobrowolski.przemyslaw.automatedtests.utils.AppiumHelper;

public class SelectRoomsAndGuestsPage {
    private static final Logger logger = LoggerFactory.getLogger(SelectRoomsAndGuestsPage.class);
    Button minusRoom;
    Button plusRoom;
    Button minusAdult;
    Button plusAdult;
    Button plusChild;
    Button minusChild;
    Button selectAgeBox;
    ListBox selectAgeListBox;
    Button applyButton;
    Button rangeOfYearsChild;
    Button ok;

    public SelectRoomsAndGuestsPage(){
        plusRoom = new Button(By.xpath("//*[@resource-id='com.booking:id/bui_input_stepper_add_button']"));
        plusAdult = new Button(By.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_add_button'])[2]"));
        plusChild = new Button(By.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_add_button'])[3]"));
        minusRoom = new Button(By.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[1]"));
        minusAdult = new Button(By.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[2]"));
        minusChild = new Button(By.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[3]"));
        rangeOfYearsChild = new Button(By.xpath("//android.widget.NumberPicker//android.widget.Button[2]"));
        selectAgeBox = new Button(By.id("com.booking:id/bui_input_container_icon"));
        selectAgeListBox = new ListBox(By.id("android:id/numberpicker_input"));
        applyButton = new Button(By.id("com.booking:id/group_config_apply_button"));
        ok = new Button(By.id("android:id/button1"));
    }
    @Step("Adding room")
    public void addRoom(int numberOfRooms){
        for(int i=0;i<numberOfRooms;i++){
            plusRoom.click();
        }
    }
    @Step("Subtracting room")
    public void subtractRoom(int numberOfRooms){
        for(int i=0;i<numberOfRooms;i++){
            minusRoom.click();
        }
    }
    @Step("Adding adult")
    public void addAdult(int numberOfAdults){
        for(int i=0;i<numberOfAdults;i++){
            plusAdult.click();
        }
    }
    @Step("Subtracting adult")
    public void subtractAdult(int numberOfAdults){
        for(int i=0;i<numberOfAdults;i++){
            minusAdult.click();
        }
    }
    @Step("Adding child")
    public void addChild(){
        plusChild.click();
        boolean isPresentSelectAgeBox = selectAgeBox.isPresent();
        logger.info("isPresentSelectAgeBox: "+ isPresentSelectAgeBox);
        if(isPresentSelectAgeBox){
            selectAgeBox.click();
        }
        AppiumHelper.scrollDown(rangeOfYearsChild);
        rangeOfYearsChild.click();
        ok.click();
    }
    @Step("Confirming changes")
    public void confirmChanges(){
        applyButton.click();
    }
}
