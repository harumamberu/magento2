package com.headcovers.pages.user;

import com.headcovers.pages.WarpMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends WarpMainPage{
    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    private By fieldFirstName = By.id("firstname");
    private By fieldLastName = By.id("lastname");
    private By fieldEmail = By.id("email_address");
    private By fieldPassword = By.id("password");
    private By fieldPasswordConfirm = By.id("password-confirmation");
    private By checkboxSignUpForNews = By.id("is_subscribed");
    private By checkboxRememberMe = By.id("remember_meoujsBgusIb");
    private By buttonCreateAccount = By.xpath("//button[contains(@title, 'Create an Account')]");

    public CustomerDashboardPage registrateNewUser(String FirstName, String LastName, String Email, String Pass, String PassConfirm){
        fillField(fieldFirstName, FirstName);
        fillField(fieldLastName, LastName);
        fillField(fieldEmail, Email);
        fillField(fieldPassword, Pass);
        fillField(fieldPasswordConfirm, PassConfirm);
        click(buttonCreateAccount);
        return new CustomerDashboardPage(driver);
    }



}
