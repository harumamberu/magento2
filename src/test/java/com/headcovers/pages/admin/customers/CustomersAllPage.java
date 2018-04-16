package com.headcovers.pages.admin.customers;

import com.headcovers.pages.admin.WarpAdminPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomersAllPage extends WarpAdminPage{
    public CustomersAllPage(WebDriver driver){super(driver);  }
    private By fieldSearchKeyword = By.xpath("//*/input[@placeholder='Search by keyword']");
    //private By buttonSearchKeyword = By.xpath("//*/button[@type='button']/preceding-sibling::input[@placeholder='Search by keyword']");
    private By buttonSearchKeyword = By.xpath("//button[@type='button'and@class='action-submit']/span[contains(text(), 'Search')]/..");
    private By buttonActionSelect = By.xpath("//button[@class='action-select']");
    private By dropdownMultiSelect = By.xpath("//*[@data-role='grid']//button[@class='action-multicheck-toggle']");
    private By buttonMultiSelectAll = By.xpath("//*[@id='container']/div/div[5]/table/thead/tr/th[1]/div/ul/li[1]/span");
    String table = "//table[@*='grid']";
    private By buttonActionListDelete = By.xpath("//div[@class='action-menu-items']//*[contains(text(), 'Delete')]");
    private By buttonActionListEdit = By.xpath("//div[@class='action-menu-items']//*[contains(text(), 'Edit')]");
    private By buttonActionListAssignCustomerGroup = By.xpath("//div[@class='action-menu-items']//*[contains(text(), 'Assign a Customer Group')]");
    private By checkboxRowUser = By.xpath(table+"//*[@*='data-grid-checkbox-cell-inner']");
//div[@class='action-menu-items']//span[@class='action-menu-item' and contains(text(), 'Delete')]

    public CustomersAllPage searchByKeyword(String string){
        invisibilityOf(spinner);
        fillField(fieldSearchKeyword, string);
        click(buttonSearchKeyword);
        return new CustomersAllPage(driver);
    }

    //28.03
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

}
