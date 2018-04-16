package com.headcovers.pages.admin;

import com.headcovers.pages.WarpPage;
import com.headcovers.pages.admin.customers.CustomersAllPage;
import com.headcovers.pages.admin.customers.CustomersOnlinePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WarpAdminPage extends WarpPage {

    public WarpAdminPage(WebDriver driver){
        super(driver);
    }

    //Menu customers
    public By customersMenu = By.xpath("//li[@id='menu-magento-customer-customer']/*/span[contains(text(), 'Customers')]/..");
    public By customersAll = By.xpath("//*/li[@id='menu-magento-customer-customer']//*/span[contains(text(), 'All Customers')]");
    public By customersOnline = By.xpath("//*/li[@id='menu-magento-customer-customer']//*/span[contains(text(), 'Online')]");
    public By helpDeskMX = By.xpath("//*/li[@id='menu-magento-customer-customer']//*/span[contains(text(), 'Help Desk')]");
    public By spinner = By.className("admin__data-grid-loading-mask");
    //

    //ActionsList
    public By buttonCloseActionPopUp = By.xpath("//*/div[@class='modal-inner-wrap']/*/button[@class='action-close']')]");
    public By buttonOkActionPopUp = By.xpath("//*/div[@class='modal-inner-wrap']//*[contains(text(), 'OK')]");

    public void checkPopUp(){
        if(isClickable(buttonCloseInfoPopUp, driver)){
            click(buttonCloseInfoPopUp);
        }
    }

    public CustomersAllPage navigateToCustomersAllPage(){
        checkPopUp();
        click(customersMenu);
        click(customersAll);
        return new CustomersAllPage(driver);
    }

    public CustomersOnlinePage navigateToCustomersOnlinePage(){
        checkPopUp();
        click(customersMenu);
        return new CustomersOnlinePage(driver);
    }

}
