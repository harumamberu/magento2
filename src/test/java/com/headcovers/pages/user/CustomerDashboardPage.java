package com.headcovers.pages.user;

import com.headcovers.pages.WarpMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerDashboardPage extends WarpMainPage{
    public CustomerDashboardPage(WebDriver driver){
        super(driver);
    }

    public By textMyDashboard = By.xpath("//*[contains(text(), 'My Dashboard')]");

    public CustomerDashboardPage assertMyDashboardPresented(){
        Assert.assertTrue(driver.findElement(textMyDashboard).isDisplayed());
        return new CustomerDashboardPage(driver);
    }

    public RegistrationPage logOut(){
        click(linkSignOut);
        return new RegistrationPage(driver);
    }
}
