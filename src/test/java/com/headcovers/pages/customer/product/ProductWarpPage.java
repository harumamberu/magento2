package com.headcovers.pages.customer.product;

import com.headcovers.pages.WarpMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductWarpPage extends WarpMainPage{
    public ProductWarpPage(WebDriver driver){
        super(driver);
    }

    protected By sku = By.xpath("//*[@itemprop='sku']");
    protected By productName = By.xpath("//*[@itemprop='name']");
    protected By price = By.xpath("//*[@class='price']");

    public ProductWarpPage checkThatOpenedProductPageCorrespodToTheWordInSearch(String oneWord){
        Assert.assertTrue(driver.findElement(productName).getText().equalsIgnoreCase(oneWord));
        return this;
    }

    public ProductWarpPage checkThatOpenedProductPageCorrespodToTheWordInSearch(String firstWord, String secondWords){

        return this;
    }

    public ProductWarpPage checkThatOpenedProductPageCorrespodToTheWordInSearch(String firstWord, String secondWords, String thirdWords){

        return this;
    }

}
