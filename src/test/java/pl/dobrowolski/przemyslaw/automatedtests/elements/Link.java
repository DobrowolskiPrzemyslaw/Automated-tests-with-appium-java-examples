package pl.dobrowolski.przemyslaw.automatedtests.elements;

import org.openqa.selenium.By;

public class Link extends BaseElements{

    public Link(By locator){
        super(locator);
    }

    public void click(){
        clickOnElementBase();
    }
}
