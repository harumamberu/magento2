package com.headcovers.tests.selenium.smoke.checkout;

import com.headcovers.tests.selenium.BaseTest;
import org.junit.Test;

public class BuyAsLoggedCustomerTest extends BaseTest{

    public void buyAsLoggedCustomerTest(){
        mainPage.searchProductThatMatchs100percent("Three Seam Turban");
    }
}
