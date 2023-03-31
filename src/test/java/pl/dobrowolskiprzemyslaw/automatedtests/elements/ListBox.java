package pl.dobrowolskiprzemyslaw.automatedtests.elements;

import org.openqa.selenium.By;

public class ListBox extends BaseElements{

    public ListBox(By locator){
        super(locator);
    }
    public void click(){
        clickOnElementBase();
    }
    public void selectByVisibleText(String text){
        selectByVisibleTextBase(text);
    }
}
