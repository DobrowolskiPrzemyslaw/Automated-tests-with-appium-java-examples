package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Button;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Link;

public class LoginPage {

    private final Button accept;
    private final Button continueWithGoogle;
    private final Link mycount;

    public LoginPage(){
        accept = new Button(AppiumBy.id("com.booking:id/bt_accept"));
        continueWithGoogle = new Button(AppiumBy.id("com.booking:id/auth_bui_button"));
        mycount = new Link(AppiumBy.id("com.google.android.gms:id/account_name"));
    }

    @Step("Loging to profile")
    public void login (){
        accept.click();
        continueWithGoogle.click();
        mycount.click();
    }
}
