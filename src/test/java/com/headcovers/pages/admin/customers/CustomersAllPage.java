package com.headcovers.pages.admin.customers;

import com.headcovers.pages.admin.WarpAdminPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomersAllPage extends WarpAdminPage{

    public CustomersAllPage(WebDriver driver){super(driver);  }
    private By fieldSearchKeyword = By.xpath("//*/input[@placeholder='Search by keyword']");
    //private By buttonSearchKeyword = By.xpath("//*/button[@type='button']/preceding-sibling::input[@placeholder='Search by keyword']");
    private By buttonSearchKeyword = By.xpath("//button[@type='button'and@class='action-submit']/span[contains(text(), 'Search')]/..");
    private By buttonActionSelect = By.xpath("//button[@class='action-select']");

    //filters
    private By buttonFilters = By.xpath("//*[@data-action='grid-filter-expand']");
    private By buttonApplyFilters = By.xpath("//*[@class='admin__data-grid-filters-footer']//button/*[contains(text(), 'Apply')]");
    private By fieldSearchByEmail = By.xpath("//span[contains(text(), 'Email')]/../..//input[@class='admin__control-text' and @name='email']");
    //*[@name='email']
    //*[@id="D5N8FL9"]
    //h1[contains(text(), 'Customers')]/../../../..//*[@name='email']

    //table actionssd
    private By dropdownMultiSelect = By.xpath("//*[@data-role='grid']//button[@class='action-multicheck-toggle']");
    private By buttonMultiSelectAll = By.xpath("//*[@id='container']/div/div[5]/table/thead/tr/th[1]/div/ul/li[1]/span");
    String table = "//table[@*='grid']";
    private By buttonActionListDelete = By.xpath("//div[@class='action-menu-items']//*[contains(text(), 'Delete')]");
    private By buttonActionListEdit = By.xpath("//div[@class='action-menu-items']//*[contains(text(), 'Edit')]");
    private By buttonActionListAssignCustomerGroup = By.xpath("//div[@class='action-menu-items']//*[contains(text(), 'Assign a Customer Group')]");
    //table elements
    private By checkboxRowUser = By.xpath(table+"//*[@*='data-grid-checkbox-cell-inner']");
    private By tableNoData =  By.className("data-grid-tr-no-data");
    private By textNoFindData = By.xpath("//*[contains(text(), 't find any records')]");


    public CustomersAllPage searchByKeyword(String string){
        invisibilityOf(spinner);
        fillField(fieldSearchKeyword, string);
        click(buttonSearchKeyword);
        return new CustomersAllPage(driver);
    }

    public CustomersAllPage searchByEmail(String email){
        invisibilityOf(spinner);
        click(buttonFilters);
        fillField(fieldSearchByEmail, email);
        return this;
    }

    public CustomersAllPage applyFilters(){
        click(buttonApplyFilters);
        return new CustomersAllPage(driver);
    }

    //deleteUsers
    public CustomersAllPage deleteUser(String username){
        invisibilityOf(spinner);
        searchByKeyword(username);
        click(checkboxRowUser);
        driver.findElement(checkboxRowUser).isSelected();
        click(buttonActionSelect);
        click(buttonActionListDelete);
        click(buttonOkActionPopUp);//Apply deleting
        return new CustomersAllPage(driver);
    }

    public CustomersAllPage deleteAllUsersByString(String string){
        invisibilityOf(spinner);
        searchByKeyword(string);
        click(dropdownMultiSelect);
        click(buttonMultiSelectAll);
        driver.findElement(checkboxRowUser).isSelected();
        click(buttonActionSelect);
        click(buttonActionListDelete);
        click(buttonOkActionPopUp);//Apply deleting
        return new CustomersAllPage(driver);
    }
    //delete users

    //assertions
    public CustomersAllPage asserTrueIfCheckboxRowUserIsDisplayed(){
        Assert.assertTrue(driver.findElement(checkboxRowUser).isDisplayed());
        return this;
    }

    public CustomersAllPage assertTrueCouldNotFindData(){
        Assert.assertTrue(driver.findElement(tableNoData).isDisplayed());
        Assert.assertTrue(driver.findElement(textNoFindData).isDisplayed());
        return this;
    }
}
