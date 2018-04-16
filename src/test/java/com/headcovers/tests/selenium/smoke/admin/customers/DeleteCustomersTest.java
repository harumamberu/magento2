package com.headcovers.tests.selenium.smoke.admin.customers;

import com.headcovers.tests.selenium.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class DeleteCustomersTest extends BaseTest{

    //@Before
    public void regTestDataUser(){}

    @Test
    public void deleteRigesteredCustomerByEmail(){
        //used for manual running only until DB woyld be fixed. can parametrize any test
        int emailNumberForTestData = 9;
        String delTestEmail = "DeleteTest" + emailNumberForTestData;
        mainPage.navigatetoSignInPage()
                .navigatetoRegistrationPage()
                .registrateNewUser("testfirstname", "testlastname", "blackridgetester" + delTestEmail + "@gmail.com", "q1w2E#R$", "q1w2E#R$")
                .assertMyDashboardPresented()
                .openAdminLoginPage()
                .loginAs()
                .navigateToCustomersAllPage()
                .searchByEmail("blackridgetester" + delTestEmail + "@gmail.com")
                .applyFilters()
                .asserTrueIfCheckboxRowUserIsDisplayed()
                .deleteAllUsersByString("blackridgetester" + delTestEmail + "@gmail.com")
                .assertTrueCouldNotFindData();
                //.deleteAllUsersByString("blackridgetester" + "DeleteTest" + "@gmail.com");
    }

}
