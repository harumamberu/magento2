package com.headcovers.tests.selenium.smoke;

import com.headcovers.tests.selenium.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest{
    @Test
    public void LoginRegisteredUser(){
        mainPage.navigatetoSignInPage()
                .navigatetoRegistrationPage()
                .registrateNewUser("testfirstname", "testlastname", "blackridgetesterloginTest@gmail.com", "q1w2E#R$", "q1w2E#R$")
                .logOut();
    }
}
