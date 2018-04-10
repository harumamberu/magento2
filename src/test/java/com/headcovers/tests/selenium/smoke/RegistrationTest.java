package com.headcovers.tests.selenium.smoke;

import com.headcovers.tests.selenium.BaseTest;
import org.junit.Test;


public class RegistrationTest extends BaseTest {

    @Test
    public void RegistrationWithValidData() {
        mainPage.navigatetoSignInPage()
                .navigatetoRegistrationPage()
                .registrateNewUser("testfirstname", "testlastname", "blackridgetester" + dateByPatterNyyMMddHHmmss + "@gmail.com", "q1w2E#R$", "q1w2E#R$")
                .assertMyDashboardPresented();
    }

}
