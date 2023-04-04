package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Button;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.InputText;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Link;
import pl.dobrowolskiprzemyslaw.automatedtests.test.BaseTest;

public class SearchPage {
    private static Logger logger = LoggerFactory.getLogger(SearchPage.class);
    InputText searchInput;
    Button item;

    public SearchPage(){
        searchInput = new InputText(MobileBy.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
        item = new Button(MobileBy.id("com.booking:id/view_disambiguation_destination_icon"));
    }
    @Step("Searching city: {0}")
    public void searchCity(String cityName){
        logger.info("Searching city: " + cityName);
        searchInput.sendText(cityName);
        item.click();
    }
}
