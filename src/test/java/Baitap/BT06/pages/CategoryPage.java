package Baitap.BT06.pages;

import Baitap.keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryPage extends basePage {

    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    private By headerCategoryPage = By.xpath("//h1[normalize-space()='All categories']");
    private By titleCategory = By.xpath("//h1[normalize-space()='All categories']");
    private By headerCategory = By.xpath("//h5[normalize-space()='Category Information']");
    private By inputName = By.xpath("//input[@id='name']");
    private By buttonParentCategory = By.xpath("//button[@aria-owns='bs-select-1']");
    private By inputParentCategory = By.xpath("//button[@title='No Parent']/following-sibling::div/child::div[1]/input");
    private By itemLaptopMSI = By.xpath("//span[normalize-space()='Laptop MSI']");
    private By inputOrderLevel = By.xpath("//input[@id='order_level']");
    private By buttonType = By.xpath("//button[@aria-owns='bs-select-2']");
    private By itemPhysical = By.xpath("//span[normalize-space()='Physical']");
    private By browseBanner = By.xpath("(//div[contains(text(),'Browse')])[1]");
    private By imageBannerLaptopMSI = By.xpath("//div[@title='LaptopMSI.webp']//img[@class='img-fit']");
    private By addFilesBanner = By.xpath("//button[normalize-space()='Add Files']");
    private By browseIcon = By.xpath("(//div[contains(text(),'Browse')])[2]");
    private By imageIconLaptop = By.xpath("//div[@title='iconLaptop.png']//img[@class='img-fit']");
    private By addFilesIcon = By.xpath("(//button[normalize-space()='Add Files'])[1]");
    private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By textareaMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By buttonFilteringAttributes = By.xpath("//button[@aria-owns='bs-select-3']");
    private By itemSize = By.xpath("//span[normalize-space()='Size']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");

    //trang list Category
    private By searchCategory = By.xpath("//input[@id='search']");
    private By firstItem = By.xpath("//div[@class='card-body']/descendant::tbody/tr[1]/td[2]");
    private By editFirstItem = By.xpath("//tbody/tr[1]/td[10]/a[1]");
    private By deleteItem = By.xpath("//i[@class='las la-trash']");
    private By deleteConfirmation = By.xpath("//a[@id='delete-link']");

    public void verifyToCategoryPage() {
        Assert.assertTrue(WebUI.checkElementExist(headerCategoryPage), "the category page is not display");
        Assert.assertEquals(WebUI.getElementText(headerCategoryPage), "All categories", "The category header page not match.");
    }
}
