package pl.dobrowolskiprzemyslaw.automatedtests.pages;

import io.appium.java_client.MobileBy;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Button;
import pl.dobrowolskiprzemyslaw.automatedtests.elements.Link;

public class LoginPage {
    Button accept;
    Button continueWithGoogle;
    Link mycount;

    public LoginPage(){
        accept = new Button(MobileBy.id("com.booking:id/bt_accept"));
        continueWithGoogle = new Button(MobileBy.id("com.booking:id/auth_bui_button"));
        mycount = new Link(MobileBy.id("com.google.android.gms:id/account_name"));
    }
    public void login (){
        accept.click();
        continueWithGoogle.click();
        mycount.click();
    }
}
