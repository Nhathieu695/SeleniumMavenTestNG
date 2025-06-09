package Baitap.BT05.pages;

import Baitap.keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage extends basePage {

    private WebDriver driver;

    public ProductPage (WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);

    }

    private By headerProductPage = By.xpath("//h1[normalize-space()='All products']");


    public void verifyToProductPage(){
        Assert.assertTrue(WebUI.checkElementExist(headerProductPage), "the product page is not display");
        Assert.assertEquals(WebUI.getElementText(headerProductPage), "All products", "The product header page not match.");
    }
}
