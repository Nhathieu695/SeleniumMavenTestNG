package Baitap.BT07.pages;

import Baitap.BT04_2.ValueCategory;
import Baitap.BT04_2.ValueProduct;
import Baitap.keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private By buttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By titleCategory = By.xpath("//h1[normalize-space()='All categories']");
    private By headerCategory = By.xpath("//h5[normalize-space()='Category Information']");
    private By inputName = By.xpath("//input[@id='name']");
    private By buttonParentCategory = By.xpath("//button[@aria-owns='bs-select-1']");
    private By inputParentCategory = By.xpath("//button[@title='No Parent']/following-sibling::div/child::div[1]/input");
    private By itemLaptop = By.xpath("//span[normalize-space()='Laptop']");
    private By inputOrderLevel = By.xpath("//input[@id='order_level']");
    private By buttonType = By.xpath("//button[@aria-owns='bs-select-2']");
    private By itemPhysical = By.xpath("//span[normalize-space()='Physical']");
    private By itemDigital = By.xpath("//span[normalize-space()='Digital']");
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
    private By allertAddCategorySuccess = By.xpath("//span[normalize-space(text())='Category has been inserted successfully']");
    private By allertEditCategorySuccess = By.xpath("//span[normalize-space(text())='Category has been updated successfully']");
    private By checkImageBanner = By.xpath("//div[@title='LaptopMSI.webp']");
    private By checkImageIcon = By.xpath("//div[@title='iconLaptop.png']");
    private By inputSlug = By.xpath("//input[@id='slug']");
    private By buttonSaveEditCategory = By.xpath("//button[normalize-space()='Save']");

    public void verifyToCategoryPage() {
        Assert.assertTrue(WebUI.checkElementExist(headerCategoryPage), "the category page is not display");
        //Assert.assertEquals(WebUI.getElementText(headerCategoryPage), "All categories", "The category header page not match.");
        WebUI.assertEquals(WebUI.getElementText(headerCategoryPage), "All categories", "The category header page not match.");
    }

    public void clickElementAddNewCategory() {
        WebUI.clickElement(buttonAddNewCategory);
    }

    public void verifyToAddNewCategory() {
        Assert.assertTrue(WebUI.checkElementExist(headerCategory), "The header category is not display");
        WebUI.assertEquals(WebUI.getElementText(headerCategory), "Category Information", "Add new category header not match");
    }

    public void submitDataForNewCategory() {
        WebUI.setText(inputName, ValueCategory.CATEGORY_NAME);
        WebUI.clickElement(buttonParentCategory);
        WebUI.sleep(1);
        WebUI.setText(inputParentCategory, ValueCategory.PARENT_CATEGORY);
        WebUI.sleep(1);
        WebUI.clickElement(itemLaptop);
        WebUI.setText(inputOrderLevel, ValueCategory.ORDER_LEVEL);
        WebUI.clickElement(buttonType);
        WebUI.sleep(1);
        WebUI.clickElement(itemPhysical);
        WebUI.clickElement(browseBanner);
        WebUI.sleep(1);
        WebUI.clickElement(imageBannerLaptopMSI);
        WebUI.clickElement(addFilesBanner);
        WebUI.clickElement(browseIcon);
        WebUI.sleep(1);
        WebUI.clickElement(imageIconLaptop);
        WebUI.clickElement(addFilesIcon);
        WebUI.setText(inputMetaTitle, ValueCategory.META_TITLE);
        WebUI.setText(textareaMetaDescription, ValueCategory.META_DESCRIPTION);
        WebUI.clickElement(buttonFilteringAttributes);
        WebUI.sleep(1);
        WebUI.clickElement(itemSize);
        WebUI.clickElement(buttonSave);
    }

    public void verifyAddCategorySuccess() {
        Assert.assertTrue(WebUI.checkElementExist(allertAddCategorySuccess), "The allert message is not display");
        WebUI.assertEquals(WebUI.getElementText(allertAddCategorySuccess), "Category has been inserted successfully", "The message not match");
    }

    public void searchDataInTable(String text) {
        WebUI.clickElement(searchCategory);
        WebUI.setTextAndKey(searchCategory, text, Keys.ENTER);
        WebUI.sleep(2);
        System.out.println(WebUI.getElementText(firstItem));
        WebUI.assertEquals(WebUI.getElementText(firstItem), text, "The category name in table not match");

    }

    public void searchDataInTable() {
        WebUI.clickElement(searchCategory);
        WebUI.setTextAndKey(searchCategory, ValueCategory.CATEGORY_NAME, Keys.ENTER);
        WebUI.sleep(2);
        System.out.println(WebUI.getElementText(firstItem));
        WebUI.assertEquals(WebUI.getElementText(firstItem), ValueCategory.CATEGORY_NAME, "The category name in table not match");

    }

    public void clickbuttonEditFirstCategory() {
        WebUI.clickElement(editFirstItem);
    }

    public void verifyAddNewCategorySuccess() {
        WebUI.assertEquals(WebUI.getElementAttribute(inputName, "value"), ValueCategory.CATEGORY_NAME, "The category name not match");
        WebUI.assertEquals(WebUI.getElementAttribute(buttonParentCategory, "title"), ValueCategory.PARENT_CATEGORY, "The parent category not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputOrderLevel, "value"), ValueCategory.ORDER_LEVEL, "The order level not match");
        WebUI.assertEquals(WebUI.getElementAttribute(buttonType, "title"), ValueCategory.TYPE, "The type not match");
        WebUI.assertEquals(WebUI.getElementAttribute(checkImageBanner, "title"), ValueCategory.BANNER_IMAGE_NAME, "The image banner not match");
        WebUI.assertEquals(WebUI.getElementAttribute(checkImageIcon, "title"), ValueCategory.ICON_IMAGE_NAME, "The image icon not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputMetaTitle, "value"), ValueCategory.META_TITLE, "The meta title not match");
        WebUI.assertEquals(WebUI.getElementAttribute(textareaMetaDescription, "value"), ValueCategory.META_DESCRIPTION, "The meta description not match");
        WebUI.assertEquals(WebUI.getElementAttribute(buttonFilteringAttributes, "title"), ValueCategory.FILTER_ATTRIBUTE, "The filter not match");

    }

    public void submitEditCategory(String text) {
        WebUI.clearText(inputName);
        WebUI.setText(inputName, text);
        WebUI.clearText(inputOrderLevel);
        WebUI.setText(inputOrderLevel, "250");
        WebUI.clickElement(buttonType);
        WebUI.sleep(1);
        WebUI.clickElement(itemDigital);
        WebUI.clearText(inputSlug);
        WebUI.setText(inputSlug, text);
        WebUI.clickElement(buttonSaveEditCategory);
    }

    public void verifyEditCategorySuccess() {
        Assert.assertTrue(WebUI.checkElementExist(allertEditCategorySuccess), "The allert message is not display");
        WebUI.assertEquals(WebUI.getElementText(allertEditCategorySuccess), "Category has been updated successfully", "The message not match");
    }

    public void verifyEditNewCategorySuccess(String text) {
        WebUI.assertEquals(WebUI.getElementAttribute(inputName, "value"), text, "The category name not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputOrderLevel, "value"), "250", "The order level not match");
        WebUI.assertEquals(WebUI.getElementAttribute(buttonType, "title"), ValueCategory.Digital, "The digital not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputSlug , "value"), text.toLowerCase(), "The slug not match");

    }


}
