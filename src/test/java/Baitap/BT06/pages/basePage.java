package Baitap.BT06.pages;

import Baitap.keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basePage {

    private WebDriver driver;

    public basePage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuProduct = By.xpath("//span[normalize-space()='Products']");
    public By menuAllProduct = By.xpath("//span[normalize-space()='All products']");
    public By menuCategory = By.xpath("//span[normalize-space()='Category']");
    public By menuCustomer = By.xpath("//span[normalize-space()='Customers']");

    public CategoryPage clickmenuCategory(){
        WebUI.clickElement(menuProduct);
        WebUI.clickElement(menuCategory);

        return new CategoryPage(driver);
    }

    public ProductPage clickmenuProduct(){
        WebUI.clickElement(menuProduct);
        WebUI.clickElement(menuAllProduct);

        return new ProductPage(driver);
    }
}
