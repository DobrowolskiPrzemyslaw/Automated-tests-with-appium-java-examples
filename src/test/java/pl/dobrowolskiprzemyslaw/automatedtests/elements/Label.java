package pl.dobrowolskiprzemyslaw.automatedtests.elements;

import org.openqa.selenium.By;
import java.util.List;

public class Label extends BaseElements{

    public Label(By locator){
        super(locator);
    }
    public List<String> getTexts(){
        return getTextsBase();
    }
}
