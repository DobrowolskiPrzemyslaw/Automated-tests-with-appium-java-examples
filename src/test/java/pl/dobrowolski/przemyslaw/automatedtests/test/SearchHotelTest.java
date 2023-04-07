package pl.dobrowolski.przemyslaw.automatedtests.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.dobrowolski.przemyslaw.automatedtests.pages.*;
import pl.dobrowolski.przemyslaw.automatedtests.utils.AppiumHelper;
import pl.dobrowolski.przemyslaw.automatedtests.utils.Listener;
import java.util.List;

@Listeners(value = {Listener.class})
public class SearchHotelTest extends BaseTest {

    @Test(dataProvider = "data")
    @Feature("Feature")
    @Story("Story")
    @Description("Description")
    public void searchHotel(String cityName,String startDate,String returnnDate) {
        LoginPage lp = new LoginPage();
        HomePage hp = new HomePage();
        SearchPage sp = new SearchPage();
        CalendarPage cp = new CalendarPage();
        EndPage ep = new EndPage();
        SelectRoomsAndGuestsPage sradp = new SelectRoomsAndGuestsPage();

        lp.login();
        hp.focusOnSearchInput();
        sp.searchCity(cityName);
        cp.inputTravelDate(startDate,returnnDate);
        hp.changeTraveler();
        sradp.addRoom(2);
        sradp.subtractRoom(1);
        sradp.addAdult(2);
        sradp.subtractAdult(1);
        sradp.addChild();
        sradp.confirmChanges();
        Assert.assertTrue(driver.findElement(By.id("com.booking:id/facet_entry_point_item_label")).isDisplayed());
        hp.search();
        List<String> labelsList = ep.getTextLabels();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(labelsList.get(0),"Sort");
        softAssert.assertEquals(labelsList.get(1),"Filter");
        softAssert.assertEquals(labelsList.get(2),"Map");
        AppiumHelper.takeScreenshot();
        softAssert.assertAll();
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider(){
        return new Object[][] {
                {"Roma","25 April 2023","15 May 2023"},
                {"London","26 April 2023","20 May 2023"},
                {"Warsaw","27 April 2023","25 May 2023"}};
    }
}
