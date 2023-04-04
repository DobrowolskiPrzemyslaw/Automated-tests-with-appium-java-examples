package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Button;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.ListBox;

public class SelectRoomsAndGuestsPage {

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
        plusRoom = new Button(MobileBy.xpath("//*[@resource-id='com.booking:id/bui_input_stepper_add_button']"));
        plusAdult = new Button(MobileBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_add_button'])[2]"));
        plusChild = new Button(MobileBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_add_button'])[3]"));
        minusRoom = new Button(MobileBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[1]"));
        minusAdult = new Button(MobileBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[2]"));
        minusChild = new Button(MobileBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[3]"));
        rangeOfYearsChild = new Button(MobileBy.xpath("//android.widget.NumberPicker//android.widget.Button[2]"));
        selectAgeBox = new Button(MobileBy.id("com.booking:id/bui_input_container_icon"));
        selectAgeListBox = new ListBox(MobileBy.id("android:id/numberpicker_input"));
        applyButton = new Button(MobileBy.id("com.booking:id/group_config_apply_button"));
        ok = new Button(MobileBy.id("android:id/button1"));
    }
    @Step("Adding room")
    public void addRoom(){
        plusRoom.click();
    }
    @Step("Subtracting room")
    public void subtractRoom(){
        minusRoom.click();
    }
    @Step("Adding adult")
    public void addAdult(){
        plusAdult.click();
    }
    @Step("Subtracting adult")
    public void subtractAdult(){
        minusAdult.click();
    }
    @Step("Adding child")
    public void addChild(){
        plusChild.click();
        if(selectAgeBox.isPresent()){
            selectAgeBox.click();
        }
        rangeOfYearsChild.scrollDown();
        rangeOfYearsChild.click();
        ok.click();
    }
    @Step("Subtracting child")
    public void subtractChild(){
        minusChild.click();
    }
    @Step("Confirming changes")
    public void confirmChanges(){
        applyButton.click();
    }
}
