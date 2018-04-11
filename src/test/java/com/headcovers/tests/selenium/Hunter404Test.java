package com.headcovers.tests.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.headcovers.pages.WarpMainPage.navBarCategoryDROPDOWNMENU;

public class Hunter404Test extends BaseTest{
    int n;
    private By categoryStaticXpath = By.xpath("//*[@id=\"menu-5acd9dcf73fb9\"]/ul/li[" + n + "]/a");

    @Test
    public void hunter404Test(){
        do{
            int navBarCategory, subCategory, product;
            //nav bar menu(xpath need to be fixed, cuz now ALL links in navbar matches
            List<WebElement> navBarCategories = driver.findElements(By.id("//*[@id='menu-5acbe8fe96b4f']/*/li/*/a"));
            //for each navbar menu
            for (navBarCategory = 0; navBarCategory <= navBarCategories.size(); navBarCategory++){
                navBarCategories.get(navBarCategory).click();

                //for each subcategory in one navbar menu
                List<WebElement> subCategories = driver.findElements(By.xpath("sub categories xpath"));
                for (subCategory = 0; subCategory <= subCategories.size() || subCategories.listIterator().hasNext(); subCategory++){
                    if(!driver.findElement(navBarCategoryDROPDOWNMENU).isDisplayed()){
                        navBarCategories.get(navBarCategory).click();
                    }
                    subCategories.get(subCategory).click();

                    //load all products in subcategory on this page
                    while(driver.findElement(By.id("//*[contains(text(), 'Load more')]")).isDisplayed() || driver.findElement(By.id("\"//*[contains(text(), 'Load more')]\"")).isEnabled()){
                        driver.findElement(By.id("//*[contains(text(), 'Load more')]")).click();
                    }

                    //for each product check the 404 message
                    List<WebElement> allProductOnThePage = driver.findElements(By.id("products"));
                    for(product = 0; product <= allProductOnThePage.size() || allProductOnThePage.listIterator().hasNext(); product++){
                        navBarCategories.get(subCategory).click();
                        allProductOnThePage.get(product).click();
                        //assert false if 404 error is displayed
                        Assert.assertFalse("404 was found" + allProductOnThePage.get(subCategory).getText(), driver.findElement(By.id("")).isDisplayed());
                    }
                }
            }

        }while (true);
    }



}
