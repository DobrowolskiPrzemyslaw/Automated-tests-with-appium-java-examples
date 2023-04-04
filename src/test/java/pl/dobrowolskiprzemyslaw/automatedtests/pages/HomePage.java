package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Button;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.InputText;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Picture;
import pl.dobrowolskiprzemyslaw.automatedtests.utils.AppiumHelper;

import java.net.MalformedURLException;

public class HomePage {
    InputText searchInput;
    Button searchButton;
    Button changeTravelers;
    Picture savedPicture;
    Picture searchPicture;
    Picture bookingsPicture;
    Picture profilePicture;

    public HomePage(){
        searchInput = new InputText(MobileBy.AccessibilityId("Enter your destination"));
        searchButton = new Button(MobileBy.xpath("//android.widget.TextView[text(),\"Search\"]/../android.widget.Button"));
        changeTravelers = new Button(MobileBy.AccessibilityId("1 room, 2 adults, 0 children"));
        searchPicture = new Picture(MobileBy.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[1]"));
        savedPicture = new Picture(MobileBy.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[2]"));
        bookingsPicture = new Picture(MobileBy.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[3]"));
        profilePicture = new Picture(MobileBy.xpath("(//android.widget.ImageView[@resource-id=\"com.booking:id/navigation_bar_item_icon_view\"])[4]"));
    }
    @Step("Focusing on search input")
    public void focusOnSearchInput(){
        searchInput.focusOn();
    }
    @Step("Changing travelers additional data")
    public void changeTraveler(){
        changeTravelers.click();
    }
    @Step("Clicking search button")
    public void search(){
        searchButton.click();
    }
    @Step("Opening Saved Page")
    public void openSaved() throws MalformedURLException {
        savedPicture.click();
        AppiumHelper.takeScreenshot();
    }
    @Step("Opening Booking Page")
    public void openBookings(){
        bookingsPicture.click();
    }
    @Step("Opening Profile Page")
    public void openProfile(){
        profilePicture.click();
    }
}
