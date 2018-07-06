package com.headcovers.pages.admin;

import com.headcovers.pages.WarpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage extends WarpPage {
    public AdminLoginPage(WebDriver driver){
        super(driver);
    }

    private By fieldUser = By.id("username");
    private By fieldPass = By.id("login");
    private By buttonLogin = By.className("action-login");

    public WarpAdminPage loginAs(String adminName, String adminPass){
        fillField(fieldUser, adminName);
        fillField(fieldPass, adminPass);
        return new WarpAdminPage(driver);
    }

    public WarpAdminPage loginAs(){
        fillField(fieldUser, "silk.andrii");
        fillField(fieldPass, "andrii12345");
        click(buttonLogin);
        return new WarpAdminPage(driver);
    }
}
