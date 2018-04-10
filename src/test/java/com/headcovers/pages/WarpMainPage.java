package com.headcovers.pages;

import com.headcovers.pages.user.SignInPage;
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


    public SignInPage navigatetoSignInPage(){
        click(linkSignIn);
        return new SignInPage(driver);
    }

    public WarpMainPage assertLogOutSucces(){
        Assert.assertTrue(driver.findElement(linkSignIn).isDisplayed());
        return this;
    }


}
