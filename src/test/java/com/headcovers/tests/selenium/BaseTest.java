package com.headcovers.tests.selenium;

import com.headcovers.data.CheckoutData;
import com.headcovers.pages.WarpMainPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WarpMainPage mainPage;
    public String dateByPatterNyyMMddHHmmss;
    public CheckoutData checkoutData;
    Actions builder;


    @Rule
    public TestWatcher screenshotOnFail = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description) {
            try {
                makeScreenshotOnFailure("Screenshot on failure", description);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }
    };

    //@Attachment(value = "{0}", type = "image/png")
    public void makeScreenshotOnFailure(String attachName, Description description) throws IOException {
        File screenshotWD = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(".\\target\\TakesScreenshot\\"+ getDateByPattern("yyyy") + "\\" + getDateByPattern("MM") + "\\" + getDateByPattern("dd") + "\\" + description.getMethodName() + getDateByPattern("HH_mm_ss") + ".png");
        screenshot.getParentFile().mkdirs();
        FileUtils.copyFile(screenshotWD, screenshot);
    }

    @Before
    public void startUp(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        mainPage = new WarpMainPage(driver).open();
        checkoutData = new CheckoutData();
        builder = new Actions(driver);
    }


    public String getDateByPattern(String pattern){
        return new SimpleDateFormat(pattern).format(new Date());
    }

    @After
    public void closeDriver(){
        //driver.close();
    }
}
