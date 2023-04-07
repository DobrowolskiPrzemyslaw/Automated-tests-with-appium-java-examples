package pl.dobrowolski.przemyslaw.automatedtests.elements;

import org.openqa.selenium.By;

public class Picture extends BaseElements{

    public Picture(By locator){
        super(locator);
    }

    public void click(){
        clickOnElementBase();
    }
}
