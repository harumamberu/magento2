package com.headcovers.pages.user;

import com.headcovers.pages.WarpMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends WarpMainPage{
    public SignInPage(WebDriver driver){
        super(driver);
    }

    private By linkRegisterNow = By.xpath("//*[@id='zoo-main-content']//a[contains(@href, '/customer/account/create')]");

    public RegistrationPage navigatetoRegistrationPage(){
        click(linkRegisterNow);
        return new RegistrationPage(driver);
    }

}
