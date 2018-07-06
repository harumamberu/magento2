package com.headcovers.pages.customer.product;

import com.headcovers.pages.WarpMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductWarpPage extends WarpMainPage{
    public ProductWarpPage(WebDriver driver){
        super(driver);
    }

    protected By sku = By.xpath("//*[@itemprop='sku']");
    protected By productNameLocator = By.xpath("//h1/*[@itemprop='name']");
    protected By price = By.xpath("//*[@class='price']");
    protected By popupHoveredSwatcher = By.xpath("//*[@id='floatBox_ajax']");
    protected By colorNameOfLastHoveredSwatcher = By.xpath("//*[@id='floatBox_ajax']/h5");
    protected By buttonAddToCart = By.id("product-addtocart-button");
    protected By alertRequiredField = By.id("attribute92-error");

    //attributes, all colors in swatchers//protected List<By>
    protected By colorSwatcherBlock = By.id("color-swatch-attribute-92");

    private List<WebElement> colorsInSwatcher = driver.findElements(By.xpath("//*[@id='color-swatch-attribute-92']/li"));
    private static final By firstSwatcher = By.xpath("//*[@id='color-swatch-attribute-92']//img");

    public List<WebElement> getColorsInSwatcher(){
        return colorsInSwatcher;
    }

    public ProductWarpPage chooseFirstColorBySwatcher(){
        waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='product-options-wrapper']//select"))));
        click(firstSwatcher);
        return this;
    }

    public ProductWarpPage chooseColorBySwatcher(String chooseByText){
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
        String productName = driver.findElement(productNameLocator).getText().toLowerCase();
        Assert.assertTrue(productName.contains(firstWord));
        return this;
    }

    public ProductWarpPage clickAddToCartButton(){
        click(buttonAddToCart);
        if(isVisable(alertRequiredField)){
            chooseFirstColorBySwatcher();
            click(buttonAddToCart);
        }
        return new ProductWarpPage(driver);
    }


}
