package com.headcovers.tests.selenium.smoke.checkout;

import com.headcovers.pages.WarpMainPage;
import com.headcovers.tests.selenium.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.headcovers.pages.customer.product.CheckoutPage.radioButtonCashofDelivery;
import static com.headcovers.pages.customer.product.CheckoutPage.radioButtonFirstShippingMethod;

public class BuyAsLoggedCustomerTest extends BaseTest{

    @Before
    public void regUser(){
        mainPage.navigatetoSignInPage()
                .navigatetoRegistrationPage()
                .registrateNewUser(checkoutData.getFirstname(), checkoutData.getLastname(), checkoutData.getEmail(), checkoutData.getPass(), checkoutData.getPass());
                driver.quit();
        mainPage = new WarpMainPage(this.driver = new ChromeDriver()).open();
    }

    @Test
    public void buyAsLoggedCustomerTest(){
        mainPage.fillSearchField1by1character("w")
                .fillSearchField1by1character("i")
                .fillSearchField1by1character("g")
                .clickTheSmartsearchItem(1)
                .checkThatOpenedProductPageCorrespodToTheWordInSearch("wig")
                .chooseFirstColorBySwatcher()
                .clickAddToCartButton()
                .clickButtonViewCartAndCheckout()
                .clickButtonToCheckout()
                .choosePaymentMethod(radioButtonCashofDelivery)
                .fillFirstNameField(checkoutData.getFirstname())
                .fillLastNameField(checkoutData.getLastname())
                .fillFirstStreetField(checkoutData.getFirstStreet())
                .fillCityField(checkoutData.getCity())
                .fillTelephoneField(checkoutData.getTelephone())
                .chooseStateProvinceByText("Alaska")
                .chooseShippingMethod(radioButtonFirstShippingMethod)
                .clickPlaceOrderButton()
                .checkUrl();
    }
}
