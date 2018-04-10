package com.headcovers.pages;

import com.headcovers.pages.customer.SignInPage;
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
    public By buttonMyBag = By.xpath("//a[contains(@href, '/checkout/cart')]");


    public SignInPage navigatetoSignInPage(){
        click(linkSignIn);
        return new SignInPage(driver);
    }

    public WarpMainPage assertLogOutSucces(){
        Assert.assertTrue(driver.findElement(linkSignIn).isDisplayed());
        return this;
    }

    public SearchPage searchByText(String text){
        fillField(fieldSearch, text);
        click(buttonSearch);
        return new SearchPage(driver);
    }

}
