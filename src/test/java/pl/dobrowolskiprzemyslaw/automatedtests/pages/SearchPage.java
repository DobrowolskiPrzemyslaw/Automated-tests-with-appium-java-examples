package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Button;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.InputText;

public class SearchPage {
    private static final Logger logger = LoggerFactory.getLogger(SearchPage.class);
    InputText searchInput;
    Button item;

    public SearchPage(){
        searchInput = new InputText(By.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
        item = new Button(By.id("com.booking:id/view_disambiguation_destination_icon"));
    }
    @Step("Searching city: {0}")
    public void searchCity(String cityName){
        logger.info("Searching city: " + cityName);
        searchInput.sendText(cityName);
        item.click();
    }
}
