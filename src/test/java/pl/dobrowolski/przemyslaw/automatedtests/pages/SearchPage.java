package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Button;
import pl.dobrowolski.przemyslaw.automatedtests.elements.InputText;

public class SearchPage {
    
    private static final Logger logger = LoggerFactory.getLogger(SearchPage.class);
    private final InputText searchInput;
    private final Button item;

    public SearchPage(){
        searchInput = new InputText(AppiumBy.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
        item = new Button(AppiumBy.id("com.booking:id/view_disambiguation_destination_icon"));
    }
    
    @Step("Searching city: {0}")
    public void searchCity(String cityName){
        logger.info("Searching city: " + cityName);
        searchInput.sendText(cityName);
        item.click();
    }
}
