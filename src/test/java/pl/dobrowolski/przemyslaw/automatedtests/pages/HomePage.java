package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pl.dobrowolski.przemyslaw.automatedtests.elements.InputText;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Button;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Picture;
import pl.dobrowolski.przemyslaw.automatedtests.utils.AppiumHelper;

public class HomePage {
    InputText searchInput;
    Button searchButton;
    Button changeTravelers;
    Picture savedPicture;
    Picture searchPicture;
    Picture bookingsPicture;
    Picture profilePicture;

    public HomePage(){
        searchInput = new InputText(By.xpath("//*[@content-desc=\"Enter your destination\"]"));
        searchButton = new Button(By.xpath("//android.widget.TextView[text(),\"Search\"]/../android.widget.Button"));
        changeTravelers = new Button(By.xpath("//*[@content-desc=\"1 room, 2 adults, 0 children\"]"));
        searchPicture = new Picture(By.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[1]"));
        savedPicture = new Picture(By.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[2]"));
        bookingsPicture = new Picture(By.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[3]"));
        profilePicture = new Picture(By.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[4]"));
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
