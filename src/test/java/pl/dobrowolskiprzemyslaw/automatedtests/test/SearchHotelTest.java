package pl.dobrowolskiprzemyslaw.automatedtests.test;

import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Test;
import pl.dobrowolskiprzemyslaw.automatedtests.utils.AppiumDriver;

public class SearchHotelTest extends BaseTest {
    AppiumDriver appDriver = new AppiumDriver();
    @Test
    public void searchHotel() {
        appDriver.waitUntilVisibleAndClick(MobileBy.id("com.booking:id/bt_accept"));
        appDriver.waitUntilVisibleAndClick(MobileBy.id("com.booking:id/auth_bui_button"));
        appDriver.waitUntilVisibleAndClick(MobileBy.id("com.google.android.gms:id/account_name"));
        appDriver.waitUntilVisibleAndClick(MobileBy.AccessibilityId("Enter your destination"));
        appDriver.waitUntilVisibleAndClick(MobileBy.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
        appDriver.sendKeys(MobileBy.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"), "London");
        appDriver.waitUntilVisibleAndClick(MobileBy.xpath("//android.widget.TextView[text(),'London']"));
        appDriver.waitUntilVisibleAndClick(MobileBy.xpath("//android.view.View[@content-desc=\"30 March 2023\n" + "\"]"));
        appDriver.scrollUpTo(MobileBy.AccessibilityId("29 May 2023"));
        appDriver.waitUntilVisibleAndClick(MobileBy.AccessibilityId("29 May 2023"));
        appDriver.waitUntilVisibleAndClick(MobileBy.id("com.booking:id/facet_date_picker_confirm"));
        appDriver.waitUntilVisibleAndClick(MobileBy.AccessibilityId("1 room, 2 adults, 0 children"));
        appDriver.waitUntilVisibleAndClick(MobileBy.xpath("//*[@resource-id='com.booking:id/bui_input_stepper_add_button']"));
        appDriver.waitUntilVisibleAndClick(MobileBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_remove_button'])[2]"));
        appDriver.waitUntilVisibleAndClick(MobileBy.xpath("(//*[@resource-id='com.booking:id/bui_input_stepper_add_button'])[3]"));
        appDriver.waitUntilVisibleAndTryClick(MobileBy.id("com.booking:id/bui_input_container_icon"));
        appDriver.scrollUpTo(MobileBy.xpath("//android.widget.NumberPicker//android.widget.Button[2]"));
        appDriver.waitUntilVisibleAndClick(MobileBy.xpath("//android.widget.NumberPicker//android.widget.Button[2]"));
        appDriver.waitUntilVisibleAndClick(MobileBy.id("android:id/button1"));
        Assert.assertTrue(appDriver.isDisplayed(MobileBy.xpath("//android.widget.TextView[text(),\"Children's ages will be used to find you the best match in beds, room, size, and special prices.\"]")));
        appDriver.waitUntilVisibleAndTryClick(MobileBy.id("com.booking:id/group_config_apply_button"));
        Assert.assertTrue(appDriver.isDisplayed(MobileBy.id("com.booking:id/facet_entry_point_item_label")));
        appDriver.waitUntilVisibleAndClick(MobileBy.xpath("//android.widget.TextView[text(),'Search']/../android.widget.Button"));
        Assert.assertEquals("Panther House by Oval",appDriver.getText(MobileBy.xpath("//android.widget.TextView[text(),'Panther House by Oval']")));
    }
}
