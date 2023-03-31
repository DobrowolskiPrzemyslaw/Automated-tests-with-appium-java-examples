package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Button;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.InputText;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Link;

public class SearchPage {

    InputText searchInput;
    Button item;

    public SearchPage(){
        searchInput = new InputText(MobileBy.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
        item = new Button(MobileBy.id("com.booking:id/view_disambiguation_destination_icon"));
    }
    public void searchCity(String cityName){
        searchInput.sendText(cityName);
        item.click();
    }
}
