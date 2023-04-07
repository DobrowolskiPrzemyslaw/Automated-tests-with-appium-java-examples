package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import pl.dobrowolski.przemyslaw.automatedtests.elements.InputText;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Button;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Picture;
import pl.dobrowolski.przemyslaw.automatedtests.utils.AppiumHelper;

public class HomePage {

    private final InputText searchInput;
    private final Button searchButton;
    private final Button changeTravelers;
    private final Picture savedPicture;

    public HomePage(){
        searchInput = new InputText(AppiumBy.xpath("//*[@content-desc=\"Enter your destination\"]"));
        searchButton = new Button(AppiumBy.xpath("//android.widget.TextView[text(),\"Search\"]/../android.widget.Button"));
        changeTravelers = new Button(AppiumBy.xpath("//*[@content-desc=\"1 room, 2 adults, 0 children\"]"));
        savedPicture = new Picture(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[2]"));
    }

    @Step("Focusing on search input")
    public void focusOnSearchInput(){
        searchInput.focusOn();
    }

    @Step("Changing travelers additional data")
    public void changeTraveler(){
        AppiumHelper.scrollUp(changeTravelers);
        changeTravelers.click();
    }

    @Step("Clicking search button")
    public void search(){
        searchButton.click();
    }

    @Step("Opening Saved Page")
    public void openSaved() {
        savedPicture.click();
        AppiumHelper.takeScreenshot();
    }
}
