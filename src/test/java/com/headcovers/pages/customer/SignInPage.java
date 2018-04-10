package com.headcovers.pages.customer;

import com.headcovers.pages.WarpMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends WarpMainPage{
    public SignInPage(WebDriver driver){
        super(driver);
    }

    private By linkRegisterNow = By.xpath("//*[@id='zoo-main-content']//a[contains(@href, '/customer/account/create')]");
    private By fieldEmail = By.id("email");
    private By fieldPass = By.id("pass");
    private By buttonLogin = By.id("send2");

    public CustomerDashboardPage loginAs(String email, String pass){
        fillField(fieldEmail, email);
        fillField(fieldPass, pass);
        click(buttonLogin);
        return new CustomerDashboardPage(driver);
    }

    public RegistrationPage navigatetoRegistrationPage(){
        click(linkRegisterNow);
        return new RegistrationPage(driver);
    }

}
