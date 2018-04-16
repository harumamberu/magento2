package com.headcovers.pages.customer.interfaces;

import org.openqa.selenium.By;

public interface Minicart {
    public By buttonViewCartAndCheckout = By.xpath("//*[@id='minicart-content-wrapper']//a[contains(@href, '/checkout/cart')]");

}
