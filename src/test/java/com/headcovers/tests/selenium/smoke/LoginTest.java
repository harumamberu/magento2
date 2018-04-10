package com.headcovers.tests.selenium.smoke;

import com.headcovers.tests.selenium.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Before
    public void RegUsersForTestData(){
        mainPage.navigatetoSignInPage()
                .navigatetoRegistrationPage()
                .registrateNewUser("testfirstname", "testlastname", "blackridgetesterloginTest@gmail.com", "q1w2E#R$", "q1w2E#R$");
    }

    @Test
    public void LoginValidRegisteredUser(){
        mainPage.navigatetoSignInPage()
                .loginAs("blackridgetesterloginTest@gmail.com", "q1w2E#R$")
                .assertMyDashboardPresented();
    }
}
