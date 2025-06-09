package Baitap.BT06.pages;

import Baitap.BT04_2.ValueProduct;
import Baitap.keyword.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static Baitap.keyword.WebUI.waitForElementVisible;

public class ProductPage extends basePage {

    private WebDriver driver;

    public ProductPage (WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);

    }

    private By headerProductPage = By.xpath("//h1[normalize-space()='All products']");
    // Product
   private By linkAddNewProduct =By.xpath("//span[normalize-space()='Add New Product']");
   private By inputProduct =By.xpath("//input[@placeholder='Product Name']");
    //Dropdown Category
   private By buttonCategory =By.xpath("//button[@aria-owns='bs-select-1']");
   private By inputCategory =By.xpath("//button[@aria-owns='bs-select-1']/following-sibling::div/div/input");
   private By itemLaptop =By.xpath("(//span[@class='text'][normalize-space()='-- Laptop MSI Generation'][1])[1]");
    //Dropdown Brand
   private By buttonBrand =By.xpath("//button[@aria-owns='bs-select-2']");
   private By inputBrand =By.xpath("//button[@aria-owns='bs-select-2']/following-sibling::div/div/input");
   private By itemMSI =By.xpath("//span[normalize-space()='MSI']");
   private By inputUnit =By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
   private By inputWeight =By.xpath("//input[@placeholder='0.00']");
   private By inputMPQ =By.xpath("//input[@name='min_qty']");
   private By inputTags =By.xpath("//span[@role='textbox']");
   private By inputTagLaptop = By.xpath("//span[@class='tagify__tag-text']");
   private By inputBarcode =By.xpath("//input[@placeholder='Barcode']");
    //Product Image
   private By browseGallery =By.xpath("(//div[contains(text(),'Browse')])[1]");
   private By imageGallery =By.xpath("//div[@title='LaptopMSI.webp']//img[@class='img-fit']");
   private By addFileGallery =By.xpath("//button[normalize-space()='Add Files']");
   private By browseThumnails =By.xpath("(//div[contains(text(),'Browse')])[2]");
   private By imageThumnails =By.xpath("//div[@title='iconLaptop.png']//img[@class='img-fit']");
   private By addFileThumnails =By.xpath("(//button[normalize-space()='Add Files'])[1]");
    //Product Variation
   private By adjustCursor =By.xpath("//input[@name='colors_active']");
   private By buttonColors =By.xpath("//button[@aria-owns='bs-select-4']/child::div/div/div");
   private By inputColors =By.xpath("//input[contains(@aria-controls,'bs-select-4')]");
   private By itemAquamarine =By.xpath("//a[@id='bs-select-4-3']");
   private By itemBlueViolet =By.xpath("//a[@id='bs-select-4-10']");
    //Product price + stock
   private By inputUnitPrice =By.xpath("//input[@placeholder='Unit price']");
   private By inputDiscountDateRange =By.xpath("//input[@placeholder='Select Date']");
   private By inputDiscount =By.xpath("//input[@placeholder='Discount']");
   private By buttonUnitDiscount =By.xpath("//button[@aria-owns='bs-select-6']");
   private By itemPercent =By.xpath("(//span[@class='text'][normalize-space()='Percent'])[1]");
    private By itemFlat =By.xpath("(//span[@class='text'][normalize-space()='Flat'])[1]");
   private By inputQuantity =By.xpath("//input[@placeholder='Quantity']");
    //ProductDescription
   private By textAreaDescription =By.xpath("//div[@role='textbox']");
    //Seo Meta Data
   private By inputMetaTitleProd =By.xpath("//input[@placeholder='Meta Title']");
   private By textAreaDescriptionProd =By.xpath("//textarea[@name='meta_description']");
   private By buttonSaveAndPublish =By.xpath("//button[normalize-space()='Save & Publish']");

   private By alertSuccessMessage = By.xpath("//div[contains(@class, 'alert-success')]");
   private By searchProduct = By.xpath("//input[@id='search']");

   private By itemFirst = By.xpath("//div[@class='card-body']/descendant::tbody/tr[1]/td[2]/div/div[2]/span");
   private By buttonViewItemFirst = By.xpath("//div[@class='card-body']/descendant::tbody/tr[1]/td[9]/a[@title='View']");
   private By buttonEditItemFirst = By.xpath("//div[@class='card-body']/descendant::tbody/tr[1]/td[9]/a[@title='Edit']");
   private By valueSlug = By.xpath("//input[@id='slug']");
   private By buttonUpdateProduct = By.xpath("//button[normalize-space()='Update Product']");
   private By alertEditSuccessMessage = By.xpath("//span[normalize-space(text())='Product has been updated successfully']");



    public void verifyToProductPage(){
        Assert.assertTrue(WebUI.checkElementExist(headerProductPage),"the product page is not display");
        Assert.assertEquals(WebUI.getElementText(headerProductPage),"All products","The product header page not match.");
    }

    public void clickElementButtonAddNewProduct(){
        WebUI.clickElement(linkAddNewProduct);
    }

    public void submitDataForNewProduct() throws AWTException {

        Actions action = new Actions(driver);
        Robot robot = new Robot();
        WebUI.setText(inputProduct, ValueProduct.PRODUCT_NAME);

        WebUI.clickElement(buttonCategory);
        WebUI.sleep(1);
        WebUI.setText(inputCategory, ValueProduct.CATEGORY_NAME);
        WebUI.clickElement(itemLaptop);

        WebUI.clickElement(buttonBrand);
        WebUI.sleep(1);
        WebUI.setText(inputBrand, ValueProduct.BRAND_NAME);
        WebUI.clickElement(itemMSI);

        WebUI.setText(inputUnit, ValueProduct.UNIT_NAME);
        WebUI.clearText(inputWeight);
        WebUI.setText(inputWeight, ValueProduct.WEIGHT);
        WebUI.clearText(inputMPQ);
        WebUI.setText(inputMPQ, ValueProduct.MIN_PURCHASE_QTY);
        WebUI.setText(inputTags, ValueProduct.TAGS);
        WebUI.sleep(1);
        WebUI.setText(inputBarcode, ValueProduct.BARCODE);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[normalize-space()='Product Images']")));

        WebUI.clickElement(browseGallery);
        WebUI.clickElement(imageGallery);
        WebUI.clickElement(addFileGallery);

        WebUI.clickElement(browseThumnails);
        WebUI.clickElement(imageThumnails);
        WebUI.clickElement(addFileThumnails);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[normalize-space()='Product Variation']")));

        // Toggle colors
        WebElement toggleColors = driver.findElement(adjustCursor);
        if (!toggleColors.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggleColors);
        }
        Assert.assertTrue(toggleColors.isSelected(), "Toggle Colors chưa được bật thành công.");

        WebUI.clickElement(buttonColors);
        WebUI.sleep(1);
        WebUI.setText(inputColors, ValueProduct.COLOR_1);
        WebElement aquamarine = driver.findElement(itemAquamarine);
        action.moveToElement(aquamarine).click().perform();
        WebUI.clickElement(buttonColors);
        WebUI.sleep(1);
        // Xóa ô chọn màu
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);

        WebUI.setText(inputColors, ValueProduct.COLOR_2);
        WebElement blueViolet = driver.findElement(itemBlueViolet);
        action.moveToElement(blueViolet).click().perform();

        robot.mouseMove(1084, 313);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        String totalColors = driver.findElement(By.xpath("//button[@aria-owns='bs-select-4']")).getAttribute("title");
        Assert.assertEquals(totalColors, "2 items selected", "chưa chọn được 2 màu");

        WebUI.setText(inputUnitPrice, ValueProduct.UNIT_PRICE);
        WebUI.clickElement(inputDiscountDateRange);
        WebUI.sleep(1);
        WebElement selectToday = driver.findElement(By.xpath("(//table[@class='table-condensed'])[1]/tbody/tr[4]/td[5]"));
        selectToday.click();
        WebUI.sleep(0.3);
        WebElement selectnextMonth = driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/tbody/tr[4]/td[5]"));
        selectnextMonth.click();
        WebUI.sleep(0.3);
        driver.findElement(By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']")).click();
        robot.mouseMove(1089, 200);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        WebUI.clearText(inputDiscount);
        WebUI.setText(inputDiscount, ValueProduct.DISCOUNT);
        WebUI.clickElement(buttonUnitDiscount);
        WebUI.sleep(0.5);
        WebUI.clickElement(itemPercent);

        WebUI.setText(textAreaDescription, ValueProduct.DESCRIPTION);
        WebUI.setText(inputMetaTitleProd, ValueProduct.META_TITLE);
        WebUI.setText(textAreaDescriptionProd, ValueProduct.META_DESCRIPTION);
        WebUI.clickElement(buttonSaveAndPublish);

    }

    public void verifyAllertSuccess(){
        Assert.assertTrue(driver.findElement(alertSuccessMessage).isDisplayed(), "Message is not displayed");
        Assert.assertEquals(driver.findElement(alertSuccessMessage).getText(), "Product has been inserted successfully", "Alert message not match");
    }

    public void verifyNavigateToAllProduct() {
        Assert.assertTrue(WebUI.checkElementExist(headerProductPage), "The product ơage header page not display.");
        Assert.assertEquals(WebUI.getElementText(headerProductPage), "All products", "The product page header page not match.");
    }

    public void searchAndCheckProductInTable(){
        WebUI.clickElement(searchProduct);
        WebUI.setText(searchProduct, ValueProduct.PRODUCT_NAME);
        WebUI.sleep(2);
        String productNameInTable = WebUI.getElementText(itemFirst);
        System.out.println(productNameInTable);
        Assert.assertEquals(productNameInTable, ValueProduct.PRODUCT_NAME, "The product name in table not match");
    }

    public void searchAndCheckProductInTable(String text){
        WebUI.clickElement(searchProduct);
        setText(searchProduct, text);
        WebUI.sleep(2);
        String productNameInTable = WebUI.getElementText(itemFirst);
        System.out.println(productNameInTable);
        Assert.assertEquals(productNameInTable, text, "The product name in table not match");
    }

    public void clickbuttonEditFirstProduct(){
        WebUI.clickElement(buttonEditItemFirst);
    }

    public void verifyAddNewProductSuccess(){

        clickbuttonEditFirstProduct();
        Assert.assertEquals(driver.findElement(inputProduct).getAttribute("value"), ValueProduct.PRODUCT_NAME, "The product name not match");
        Assert.assertEquals(driver.findElement(buttonCategory).getAttribute("title"), "-- "+ValueProduct.CATEGORY_NAME, "The category name not match");
        Assert.assertEquals(driver.findElement(buttonBrand).getAttribute("title"), ValueProduct.BRAND_NAME, "The brand name not match");
        Assert.assertEquals(driver.findElement(inputUnit).getAttribute("value"), ValueProduct.UNIT_NAME, "The unit not match");
        Assert.assertEquals(driver.findElement(inputWeight).getAttribute("value"), ValueProduct.WEIGHT, "The weight not match");
        Assert.assertEquals(driver.findElement(inputMPQ).getAttribute("value"), ValueProduct.MIN_PURCHASE_QTY, "The MPQ not match");
        Assert.assertEquals(driver.findElement(inputTagLaptop).getText(), ValueProduct.TAGS, "The tags not match");
        Assert.assertEquals(driver.findElement(inputBarcode).getAttribute("value"), ValueProduct.BARCODE, "The barcode not match");
        //Assert.assertEquals(driver.findElement(By.xpath("//div[@title='LaptopMSI.webp']//img[@class='img-fit']")).getAttribute("title"), "LaptopMSI.webp", "The gallery images not match");
        //Assert.assertEquals(driver.findElement(By.xpath("(//div[@title='iconLaptop.png']//img[@class='img-fit'])[1]")).getAttribute("title"), "iconLaptop.png", "The gallery images not match");
        WebElement galleryImage = driver.findElement(By.cssSelector("div[title='LaptopMSI.webp'] img.img-fit"));
        WebElement thumbImage = driver.findElement(By.cssSelector("div[title='iconLaptop.png'] img.img-fit"));

        Assert.assertTrue(galleryImage.isDisplayed(), "Image gallery not display");
        Assert.assertTrue(thumbImage.isDisplayed(), "Image thumbnail not display");

        String totalColors = driver.findElement(By.xpath("//button[@aria-owns='bs-select-4']")).getAttribute("title");
        Assert.assertEquals(totalColors, "2 items selected", "choose two colors not yet");

        Assert.assertEquals(driver.findElement(inputUnitPrice).getAttribute("value"), "1200.00", "The unit priec not match");
        Assert.assertEquals(driver.findElement(inputDiscountDateRange).getAttribute("value"), "19-06-2025 00:00:00 to 24-07-2025 23:59:00", "The Date not match");
        Assert.assertEquals(driver.findElement(inputDiscount).getAttribute("value"), ValueProduct.DISCOUNT, "The disocunt not math");
        Assert.assertEquals(driver.findElement(inputMetaTitleProd).getAttribute("value"), ValueProduct.META_TITLE, "The meta title not match");
        Assert.assertEquals(driver.findElement(textAreaDescriptionProd).getText(), ValueProduct.META_DESCRIPTION, "The meta description not match");
        //Assert.assertEquals(driver.findElement(valueSlug).getAttribute("value"), "laptop-pro-game-B", "The value slug not match");
    }

    public void submitDataForEditProduct(){
        searchAndCheckProductInTable("Laptop pro game C");
        clickbuttonEditFirstProduct();
        WebUI.clearText(inputProduct);
        WebUI.setText(inputProduct, "Laptop Edit 1C");
        WebUI.clearText(inputWeight);
        WebUI.setText(inputWeight, "150");
        WebUI.clearText(inputMPQ);
        WebUI.setText(inputMPQ, "10");
        WebUI.clearText(inputDiscount);
        WebUI.setText(inputDiscount, "20");
        WebUI.clickElement(buttonUnitDiscount);
        WebUI.sleep(0.5);
        WebUI.clickElement(itemFlat);
        WebUI.clearText(valueSlug);
        WebUI.setText(valueSlug, "Laptop-pro-game-edit-1C");
        WebUI.clickElement(buttonUpdateProduct);
    }

    public void verifyAllertEditSuccess(){
        Assert.assertTrue(driver.findElement(alertEditSuccessMessage).isDisplayed(), "Message is not displayed");
        Assert.assertEquals(driver.findElement(alertEditSuccessMessage).getText(), "Product has been updated successfully", "Alert message not match");
    }

    public void verifyEditProduct(){
        clickbuttonEditFirstProduct();
        Assert.assertEquals(driver.findElement(inputProduct).getAttribute("value"), "Laptop Edit 1C", "The product name not match");
        Assert.assertEquals(driver.findElement(inputWeight).getAttribute("value"), "150.00", "The weigt not match");
        Assert.assertEquals(driver.findElement(inputMPQ).getAttribute("value"), "10", "The MPQ not match");
        Assert.assertEquals(driver.findElement(inputDiscount).getAttribute("value"), "20.00", "The discount not match");
        Assert.assertEquals(driver.findElement(buttonUnitDiscount).getAttribute("title"), "Flat", "The unit discount not match");
       // Assert.assertEquals(driver.findElement(valueSlug).getAttribute("value"), "Laptop-pro-game-edit-1B", "The value slug not match");
    }

    public  void  setText(By by, String text){
        System.out.println("Set text " + text + "on element " + by);
        waitForElementVisible(by);
        driver.findElement(by).sendKeys(text, Keys.ENTER);
    }
}
