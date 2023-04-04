package pl.dobrowolskiprzemyslaw.automatedtests.elements;

import org.openqa.selenium.By;

public class Button extends BaseElements{

    public Button(By locator){
        super(locator);
    }
    public void click(){
        clickOnElementBase();
    }
    public boolean isPresent(){
        return isPresentBase();
    }
    public void scrollDown(){
        scrollDownBase();
    }
    public void scrollUp(){
        scrollUpBase();
    }
}