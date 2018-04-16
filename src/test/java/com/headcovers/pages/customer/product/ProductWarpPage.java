package com.headcovers.pages.customer.product;

import com.headcovers.pages.WarpMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProductWarpPage extends WarpMainPage{
    public ProductWarpPage(WebDriver driver){
        super(driver);
    }

    protected By sku = By.xpath("//*[@itemprop='sku']");
    protected By productNameLocator = By.xpath("//*[@itemprop='name']");
    protected By price = By.xpath("//*[@class='price']");

    //attributes, all colors in swatchers//protected List<By>
    protected By colorSwatcherBlock = By.id("color-swatch-attribute-92");
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@id=\"color-swatch-attribute-92\"]/li")
    })private List<WebElement> colorsInSwatcher;

    public ProductWarpPage chooseFirstColorBySwatcher(){
        colorsInSwatcher.get(1).click();
        return this;
    }

    public ProductWarpPage chooseColordBySwatcher(String chooseByText){
        //implement choosing by text
        return this;
    }


    public ProductWarpPage checkThatOpenedProductPageCorrespodToTheWordInSearch(String oneWord, String secondChar, String thirdChar){
        String productName = driver.findElement(productNameLocator).getText();
        Assert.assertTrue(productName.contains(oneWord+secondChar+thirdChar));
        return this;
    }

    public ProductWarpPage checkThatOpenedProductPageCorrespodToTheWordInSearch(String firstWord, String secondWords){

        return this;
    }

    public ProductWarpPage checkThatOpenedProductPageCorrespodToTheWordInSearch(String firstWord){

        return this;
    }

}
