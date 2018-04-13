package com.headcovers.pages;

import com.headcovers.pages.customer.SignInPage;
import com.headcovers.pages.customer.categories.CategoryWarpPage;
import com.headcovers.pages.customer.product.ProductWarpPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WarpMainPage extends WarpPage{
    public WarpMainPage(WebDriver driver){
        super(driver);
    }

    //String headerId = "page-header";
    public By linkSignIn = By.xpath("//*[@id='page-header']//a[contains(text(), 'Sign in')]");
    public By linkSignOut = By.xpath("//*[@id='page-header']//a[contains(text(), 'Sign out')]");
    public By fieldSearch = By.id("search");
    public By buttonSearch = By.xpath("//*[@id='header-sticky-mobile']//button[@title='Search']");
    public By smartSearchDrowndownResult = By.xpath("//*[@class='c-smartsearch__wrapper--inner']");
    public By linkSmartSearchDrowndownFirst = By.xpath("//*[@class='c-smartsearch__wrapper--inner']/*/div[1]/a");
    public By linkSmartSearchDrowndownSecond = By.xpath("//*[@class='c-smartsearch__wrapper--inner']/*/div[2]/a");
    public By linkSmartSearchDrowndownThird = By.xpath("//*[@class='c-smartsearch__wrapper--inner']/*/div[3]/a");
    public By linkSmartSearchDrowndownFours = By.xpath("//*[@class='c-smartsearch__wrapper--inner']/*/div[4]/a");
    public By linkSmartSearchDrowndownLast = By.xpath("//*[@class='c-smartsearch__wrapper--inner']/*/div[5]/a");
    public By buttonMyBag = By.xpath("//a[contains(@href, '/checkout/cart')]");
    public static By navBarCategoryDROPDOWNMENU = By.xpath("");


    public SignInPage navigatetoSignInPage(){
        click(linkSignIn);
        return new SignInPage(driver);
    }

    public WarpMainPage assertLogOutSucces(){
        Assert.assertTrue(driver.findElement(linkSignIn).isDisplayed());
        return this;
    }

    public CatalogSearchResultPage searchByTextConfigurableProduct(String text){
        fillField(fieldSearch, text);
        click(buttonSearch);
        return new CatalogSearchResultPage(driver);
    }

    public CategoryWarpPage searchByTextThatMatchesAsCategory(String text){
        fillField(fieldSearch, text);
        click(buttonSearch);
        return new CategoryWarpPage(driver);
    }

    public ProductWarpPage searchProductThatMatchs100percent(String text){
        fillField(fieldSearch, text);
        click(buttonSearch);
        return new ProductWarpPage(driver);
    }

    public WarpMainPage fillSearchField(String text){
        fillField(fieldSearch, text);
        click(fieldSearch);
        return this;
    }

    public ProductWarpPage clickButtonSearch(){
        click(buttonSearch);
        return new ProductWarpPage(driver);
    }

    public WarpMainPage fillSField(String string){
        driver.findElement(fieldSearch).sendKeys(string);
        click(fieldSearch);
        return this;
    }

    public ProductWarpPage clickTheSmartsearchItem(int number){
        switch(number){
            case 1:
                presenceOfElementInDOM(linkSmartSearchDrowndownFirst);
                click(linkSmartSearchDrowndownFirst);
                break;
            case 2:
                presenceOfElementInDOM(linkSmartSearchDrowndownSecond);
                click(linkSmartSearchDrowndownSecond);
                break;
            case 3:
                presenceOfElementInDOM(linkSmartSearchDrowndownThird);
                click(linkSmartSearchDrowndownThird);
                break;
            case 4:
                presenceOfElementInDOM(linkSmartSearchDrowndownFours);
                click(linkSmartSearchDrowndownFours);
                break;
            case 5:
                presenceOfElementInDOM(linkSmartSearchDrowndownLast);
                click(linkSmartSearchDrowndownLast);
                break;
        }
        return new ProductWarpPage(driver);
    }

}
