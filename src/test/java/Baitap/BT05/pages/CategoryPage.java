package Baitap.BT05.pages;

import Baitap.keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryPage extends basePage{

    private WebDriver driver;

    public CategoryPage (WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    private By headerCategoryPage = By.xpath("//h1[normalize-space()='All categories']");


    public void verifyToCategoryPage(){
        Assert.assertTrue(WebUI.checkElementExist(headerCategoryPage), "the category page is not display");
        Assert.assertEquals(WebUI.getElementText(headerCategoryPage), "All categories", "The category header page not match.");
    }
}
