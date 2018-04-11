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

public class BaseTest {
    protected WebDriver driver;
    protected WarpMainPage mainPage;
    public String dateByPatterNyyMMddHHmmss;
    public String baseUrl = "http://stage-php70.headcovers.silksoftware.net";
    Actions builder;


    @Before
    public void startUp(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        mainPage = new WarpMainPage(driver);
        dateByPatterNyyMMddHHmmss = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        driver.get(baseUrl);

        builder = new Actions(driver);
    }

    @After
    public void closeDriver(){
        driver.close();}
}
