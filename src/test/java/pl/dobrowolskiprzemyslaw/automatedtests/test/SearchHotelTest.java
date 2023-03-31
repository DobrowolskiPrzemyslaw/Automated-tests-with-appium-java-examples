package pl.dobrowolskiprzemyslaw.automatedtests.test;

import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pl.dobrowolskiprzemyslaw.automatedtests.pages.*;

import java.util.List;

public class SearchHotelTest extends BaseTest {
    @Test
    public void searchHotel() {
        LoginPage lp = new LoginPage();
        HomePage hp = new HomePage();
        SearchPage sp = new SearchPage();
        CalendarPage cp = new CalendarPage();
        EndPage ep = new EndPage();
        SelectRoomsAndGuestsPage sradp = new SelectRoomsAndGuestsPage();

        lp.login();
        hp.focusOnSearchInput();
        sp.searchCity("London");
        cp.inputTravelData("31 March 2023","01 May 2023");
        hp.changeTraveler();
        sradp.addRoom();
        sradp.addAdult();
        sradp.addAdult();
        sradp.subtractAdult();
        sradp.addChild();
        sradp.confirmChanges();
        Assert.assertTrue(driver.findElement(MobileBy.id("com.booking:id/facet_entry_point_item_label")).isDisplayed());
        hp.search();
        List<String> labelsList = ep.getTextLabels();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(labelsList.get(0),"Sort");
        softAssert.assertEquals(labelsList.get(1),"Filter");
        softAssert.assertEquals(labelsList.get(2),"Map");
        softAssert.assertAll();
    }
}
