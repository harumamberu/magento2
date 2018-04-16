package com.headcovers.tests.selenium.smoke;

import com.headcovers.tests.selenium.BaseTest;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;


public class RegistrationTest extends BaseTest {

    @Test
    public void RegistrationWithValidData() {
        mainPage.navigatetoSignInPage()
                .navigatetoRegistrationPage()
                .registrateNewUser("testfirstname", "testlastname", "blackridgetester" + getdateByPatterNyyMMddHHmmss() + "@gmail.com", "q1w2E#R$", "q1w2E#R$")
                .assertMyDashboardPresented();
    }

    @After
    public void delAllUsers(){
        try{
            mainPage.openAdminLoginPage()
                    .loginAs()
                    .navigateToCustomersAllPage()
                    .deleteAllUsersByString("testfirstname");
        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }
}
