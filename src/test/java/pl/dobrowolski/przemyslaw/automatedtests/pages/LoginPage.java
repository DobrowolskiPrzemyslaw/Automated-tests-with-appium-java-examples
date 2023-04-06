package pl.dobrowolski.przemyslaw.automatedtests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Button;
import pl.dobrowolski.przemyslaw.automatedtests.elements.Link;

public class LoginPage {
    Button accept;
    Button continueWithGoogle;
    Link mycount;
    public LoginPage(){
        accept = new Button(By.id("com.booking:id/bt_accept"));
        continueWithGoogle = new Button(By.id("com.booking:id/auth_bui_button"));
        mycount = new Link(By.id("com.google.android.gms:id/account_name"));
    }
    @Step("Loging to profile")
    public void login (){
        accept.click();
        continueWithGoogle.click();
        mycount.click();
    }
}
