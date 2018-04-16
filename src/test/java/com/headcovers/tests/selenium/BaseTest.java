package com.headcovers.tests.selenium;

import com.headcovers.pages.WarpMainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WarpMainPage mainPage;
    public String dateByPatterNyyMMddHHmmss;

    Actions builder;


    @Before
    public void startUp(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        dateByPatterNyyMMddHHmmss = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        driver.manage().window().maximize();

        mainPage = new WarpMainPage(driver).open();

        builder = new Actions(driver);
    }

    public String getdateByPatterNyyMMddHHmmss(){
        return new SimpleDateFormat("yyMMddHHmmss").format(new Date());
    }

    @After
    public void closeDriver(){
        driver.close();}
}
