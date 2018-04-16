package com.headcovers.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WarpPage{
    protected WebDriver driver;
    WebDriverWait waiter;

    //general subject
    public String baseUrl = "http://stage-php70.headcovers.silksoftware.net";
    public String adminUrl = "//admintux221/admin";
    public By buttonCloseInfoPopUp = By.xpath("//*[contains(@class,'modal-inner-wrap')]//button[@class='action-close']");

    public WarpPage(WebDriver driver){
        this.driver = driver;
    }

    public void click(By by){

        try {
            visibilityOf(by);
            clickableOf(by);
            driver.findElement(by).isDisplayed();
            driver.findElement(by).click();
        }catch (WebDriverException e){
            e.getMessage();
            clickJS(by);
        }
    }

    public void clickJS(By by) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", driver.findElement(by));
    }

    public void clickableOf(By by) {
        waiter = new WebDriverWait(driver, 5);
        waiter.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void visibilityOf(By by) {
        waiter = new WebDriverWait(driver, 5);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public void invisibilityOf(By by) {
        waiter = new WebDriverWait(driver, 5);
        waiter.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void presenceOfElementInDOM(By by){
        waiter = new WebDriverWait(driver, 5);
        waiter.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void fillField(By by, String string){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(string);
    }


    public void assertTrueForVisabilityOfWebElemenet(By by){
        Assert.assertTrue(driver.findElement(by).isDisplayed());
    }

    public void logOut(By by){click(by);};

    public boolean isClickable(By by, WebDriver driver) {
        try{
            waiter = new WebDriverWait(driver, 5);
            waiter.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
