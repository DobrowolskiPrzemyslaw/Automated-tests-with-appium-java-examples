package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Button;
import pl.dobrowolski.przemyslaw.automatedtests.utils.AppiumHelper;

public class SelectRoomsAndGuestsPage {
    
    private static final Logger logger = LoggerFactory.getLogger(SelectRoomsAndGuestsPage.class);
    private final Button minusRoom;
    private final Button plusRoom;
    private final Button minusAdult;
    private final Button plusAdult;
    private final  Button plusChild;
    private final Button selectAgeBox;
    private final Button applyButton;
    private final Button rangeOfYearsChild;
    private final Button ok;

    public SelectRoomsAndGuestsPage(){
        plusRoom = new Button(AppiumBy.xpath("//*[@resource-id='com.booking:id/bui_input_stepper_add_button']"));
        plusAdult = new Button(AppiumBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_add_button'])[2]"));
        plusChild = new Button(AppiumBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_add_button'])[3]"));
        minusRoom = new Button(AppiumBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[1]"));
        minusAdult = new Button(AppiumBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[2]"));
        rangeOfYearsChild = new Button(AppiumBy.xpath("//android.widget.NumberPicker//android.widget.Button[2]"));
        selectAgeBox = new Button(AppiumBy.id("com.booking:id/bui_input_container_icon"));
        applyButton = new Button(AppiumBy.id("com.booking:id/group_config_apply_button"));
        ok = new Button(AppiumBy.id("android:id/button1"));
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
