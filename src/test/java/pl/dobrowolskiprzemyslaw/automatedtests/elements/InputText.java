package pl.dobrowolskiprzemyslaw.automatedtests.elements;

import org.openqa.selenium.By;

public class InputText extends BaseElements {

    public InputText(By locator){
        super(locator);
    }
    public void sendText(String text){
        sendTextBase(text);
    }
    public void focusOn(){
        clickOnElementBase();
    }
}
