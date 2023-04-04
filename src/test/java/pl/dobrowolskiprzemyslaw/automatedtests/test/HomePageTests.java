package pl.dobrowolskiprzemyslaw.automatedtests.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.dobrowolskiprzemyslaw.automatedtests.pages.HomePage;
import pl.dobrowolskiprzemyslaw.automatedtests.pages.LoginPage;
import pl.dobrowolskiprzemyslaw.automatedtests.pages.SavedPage;

import java.net.MalformedURLException;
import java.util.List;

public class HomePageTests extends BaseTest {
    @Test
    @Feature("Saved Page")
    @Description("Showing good text labels on Saved Page")
    public void savedPageTest() throws MalformedURLException {

        LoginPage lp = new LoginPage();
        HomePage hp = new HomePage();
        SavedPage sp = new SavedPage();

        lp.login();
        hp.openSaved();
        List<String> labelsList = sp.getTextLabels();
        SoftAssert softAssert = new SoftAssert();
        if(labelsList.size()>9){
            softAssert.assertEquals(labelsList.get(0),"Saved");
            softAssert.assertEquals(labelsList.get(1),"Lists");
            softAssert.assertEquals(labelsList.get(2),"Alerts");
            softAssert.assertEquals(labelsList.get(3),"Keep what you like at hand");
            softAssert.assertEquals(labelsList.get(4),"Save all the properties that you like from your search right here");
            softAssert.assertEquals(labelsList.get(5),"Start your first list");
            softAssert.assertEquals(labelsList.get(6),"Search");
            softAssert.assertEquals(labelsList.get(7),"Saved");
            softAssert.assertEquals(labelsList.get(8),"Bookings");
            softAssert.assertEquals(labelsList.get(9),"Profile");
        }else{
            softAssert.assertEquals(labelsList.get(0),"Saved");
            softAssert.assertEquals(labelsList.get(1),"Keep what you like at hand");
            softAssert.assertEquals(labelsList.get(2),"Save all the properties that you like from your search right here");
            softAssert.assertEquals(labelsList.get(3),"Start your first list");
            softAssert.assertEquals(labelsList.get(4),"Travelers' top saves in London");
            softAssert.assertEquals(labelsList.get(5),"Search");
            softAssert.assertEquals(labelsList.get(6),"Saved");
            softAssert.assertEquals(labelsList.get(7),"Bookings");
            softAssert.assertEquals(labelsList.get(8),"Profile");
        }
        softAssert.assertAll();
    }
}
