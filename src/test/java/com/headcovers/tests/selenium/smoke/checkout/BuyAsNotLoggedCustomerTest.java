package com.headcovers.tests.selenium.smoke.checkout;

import com.headcovers.tests.selenium.BaseTest;
import org.junit.Test;

import static com.headcovers.pages.customer.product.CheckoutPage.*;

public class BuyAsNotLoggedCustomerTest extends BaseTest{
    @Test
    public void buyAsNotLoggedCustomerTest(){
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
                .fillEmailField(checkoutData.getEmail())
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
