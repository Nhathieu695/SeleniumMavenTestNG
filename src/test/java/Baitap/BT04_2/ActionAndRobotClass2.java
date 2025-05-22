package Baitap.BT04_2;

import Baitap.BT01.Locators;
import Baitap.BT02.SetupDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ActionAndRobotClass2 extends SetupDriver {

    SoftAssert softAssert = new SoftAssert();
    @Test(priority = 1, description = "Login")
    public void testLogin() throws InterruptedException {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(Locators.inputEmail)).clear();
        driver.findElement(By.xpath(Locators.inputPassword)).clear();
        WebElement email = driver.findElement(By.xpath(Locators.inputEmail));
        WebElement password = driver.findElement(By.xpath(Locators.inputPassword));

        Actions action = new Actions(driver);
        action.sendKeys(email, "admin@example.com").perform();
        action.sendKeys(password, "123456").perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
    }

    @Test(priority = 2,description = "add Category")
    public void addCategory() throws InterruptedException {

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);
        //check title Category
        String pageTitle = driver.findElement(By.xpath(Locators.titleCategory)).getText();
        Assert.assertTrue(pageTitle.contains("All categories"), "không ở trang Category");
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        //check tiêu đề trang Add Category
        softAssert.assertEquals(driver.findElement(By.xpath(Locators.headerCategory)).getText() , "Category Information", "sai tiêu đề trang Add Category");
        driver.findElement(By.xpath(Locators.inputName)).sendKeys(ValueProduct.CATEGORY_NAME);
        driver.findElement(By.xpath(Locators.buttonParentCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.inputParentCategory)).sendKeys("Laptop MSI");
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.itemLaptopMSI)).click();

        //check input parent Category
        softAssert.assertEquals(driver.findElement(By.xpath(Locators.buttonParentCategory)).getAttribute("title"), "Laptop MSI", "Parent Category không phù hợp");

        // check orderlevel
        driver.findElement(By.xpath(Locators.inputOrderLevel)).sendKeys("200");
        softAssert.assertEquals(driver.findElement(By.xpath(Locators.inputOrderLevel)).getAttribute("value"), "200", "Sai order level");

        driver.findElement(By.xpath(Locators.buttonType)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.itemPhysical)).click();
        //check type
        String selectedType = driver.findElement(By.xpath(Locators.buttonType)).getAttribute("title");
        softAssert.assertEquals(selectedType, "Physical", "Sai kiểu sản phẩm");

        driver.findElement(By.xpath(Locators.browseBanner)).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath(Locators.imageBannerLaptopMSI)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.addFilesBanner)).click();
        Thread.sleep(1000);
        //check image Banner
        Assert.assertEquals(driver.findElement(By.xpath("//div[@title='LaptopMSI.webp']")).getAttribute("title"), "LaptopMSI.webp", "image không hợp lệ");

        driver.findElement(By.xpath(Locators.browseIcon)).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath(Locators.imageIconLaptop)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.addFilesIcon)).click();
        //check image icon
        Assert.assertEquals(driver.findElement(By.xpath("//div[@title='iconLaptop.png']")).getAttribute("title"), "iconLaptop.png", "image không hợp lệ");

        driver.findElement(By.xpath(Locators.inputMetaTitle)).sendKeys("Laptop MSI GEN 12");
        //check meta title
        softAssert.assertEquals(driver.findElement(By.xpath(Locators.inputMetaTitle)).getAttribute("value"), "Laptop MSI GEN 12", "Sai meta title");

        driver.findElement(By.xpath(Locators.textareaMetaDescription)).sendKeys("Laptop MSI GEN 12 cải tiến chất lượng");
        //check descriptions
        String metaDesc = driver.findElement(By.xpath(Locators.textareaMetaDescription)).getAttribute("value");
        softAssert.assertTrue(metaDesc.contains("cải tiến"), "Sai meta description");

        driver.findElement(By.xpath(Locators.buttonFilteringAttributes)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.itemSize)).click();
        //Check attribute
        String selectedAttr = driver.findElement(By.xpath(Locators.buttonFilteringAttributes)).getAttribute("title");
        softAssert.assertEquals(selectedAttr, "Size", "Sai thuộc tính lọc");

        driver.findElement(By.xpath(Locators.buttonSave)).click();
        Thread.sleep(2000);

        //check dialog Add Category
        String toastMsg = driver.findElement(By.xpath("//span[normalize-space(text())='Category has been inserted successfully']")).getText();
        softAssert.assertEquals(toastMsg, "Category has been inserted successfully", "Không hiện thông báo thêm thành công!");

        // Kiểm tra item vừa thêm có trong danh sách
        driver.findElement(By.xpath(Locators.searchCategory)).sendKeys("Laptop", Keys.ENTER);
        Thread.sleep(1000);
        softAssert.assertTrue(driver.findElement(By.xpath(Locators.firstItem)).isDisplayed(), "Không tìm thấy item vừa thêm");
        softAssert.assertTrue(driver.findElement(By.xpath(Locators.firstItem)).getText().contains(ValueProduct.CATEGORY_NAME), "Tên item không khớp");

        // Tổng hợp tất cả assert
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Add Product")
    public void addProduct () throws InterruptedException, AWTException {
        Actions action = new Actions(driver);
        Robot robot = new Robot();

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath(Locators.linkProduct)).click();
        driver.findElement(By.xpath(Locators.inputProduct)).sendKeys(ValueProduct.PRODUCT_NAME);

        driver.findElement(By.xpath(Locators.buttonCategory)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators.inputCategory)).sendKeys(ValueProduct.CATEGORY_NAME);
        Thread.sleep(300);
        driver.findElement(By.xpath(Locators.itemLaptop)).click();

        driver.findElement(By.xpath(Locators.buttonBrand)).click();
        Thread.sleep(500); // Dropdown brand
        driver.findElement(By.xpath(Locators.inputBrand)).sendKeys(ValueProduct.BRAND_NAME);
        Thread.sleep(300);
        driver.findElement(By.xpath(Locators.itemMSI)).click();

        driver.findElement(By.xpath(Locators.inputUnit)).sendKeys(ValueProduct.UNIT_NAME);
        driver.findElement(By.xpath(Locators.inputWeight)).sendKeys(ValueProduct.WEIGHT);
        driver.findElement(By.xpath(Locators.inputMPQ)).sendKeys(ValueProduct.MIN_PURCHASE_QTY);
        driver.findElement(By.xpath(Locators.inputTags)).sendKeys(ValueProduct.TAGS);
        driver.findElement(By.xpath(Locators.inputBarcode)).sendKeys(ValueProduct.BARCODE);

        driver.findElement(By.xpath(Locators.browseGallery)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.imageGallery)).click();
        Thread.sleep(300);
        driver.findElement(By.xpath(Locators.addFileGallery)).click();

        driver.findElement(By.xpath(Locators.browseThumnails)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.imageThumnails)).click();
        Thread.sleep(300);
        driver.findElement(By.xpath(Locators.addFileThumnails)).click();

        // Toggle colors
        WebElement toggleColors = driver.findElement(By.xpath(Locators.adjustCursor));
        if (!toggleColors.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggleColors);
            Thread.sleep(300);
        }
        Assert.assertTrue(toggleColors.isSelected(), "Toggle Colors chưa được bật thành công.");

        driver.findElement(By.xpath(Locators.buttonColors)).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath(Locators.inputColors)).sendKeys(ValueProduct.COLOR_1);
        Thread.sleep(1500);
        WebElement itemAquamarine = driver.findElement(By.xpath(Locators.itemAquamarine));
        action.moveToElement(itemAquamarine).click().perform();
        Thread.sleep(300);

        driver.findElement(By.xpath(Locators.buttonColors)).click();
        Thread.sleep(1500);
        // Xóa ô chọn màu
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);

        driver.findElement(By.xpath(Locators.inputColors)).sendKeys(ValueProduct.COLOR_2);
        Thread.sleep(1500);
        WebElement itemBlueViolet = driver.findElement(By.xpath(Locators.itemBlueViolet));
        action.moveToElement(itemBlueViolet).click().perform();
        Thread.sleep(300);


        robot.mouseMove(1084, 313);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000); // đợi xử lý chọn màu

        String totalColors = driver.findElement(By.xpath("//button[@aria-owns='bs-select-4']")).getAttribute("title");
        Assert.assertEquals(totalColors, "2 items selected", "chưa chọn được 2 màu");

        driver.findElement(By.xpath(Locators.inputUnitPrice)).sendKeys(ValueProduct.UNIT_PRICE);
        driver.findElement(By.xpath(Locators.inputDiscountDateRange)).click();
        Thread.sleep(1000);
        WebElement selectToday = driver.findElement(By.xpath("(//table[@class='table-condensed'])[1]/tbody/tr[4]/td[5]"));
        selectToday.click();
        Thread.sleep(300);
        WebElement selectnextMonth = driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/tbody/tr[4]/td[5]"));
        selectnextMonth.click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']")).click();
        robot.mouseMove(1089, 200);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        driver.findElement(By.xpath(Locators.inputDiscount)).clear();
        driver.findElement(By.xpath(Locators.inputDiscount)).sendKeys(ValueProduct.DISCOUNT);
        driver.findElement(By.xpath(Locators.buttonUnitDiscount)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators.itemPercent)).click();
        Thread.sleep(300);

//        driver.findElement(By.xpath(Locators.inputQuantity)).clear();
//        driver.findElement(By.xpath(Locators.inputQuantity)).sendKeys("100");
        driver.findElement(By.xpath(Locators.textAreaDescription)).sendKeys(ValueProduct.DESCRIPTION);
        driver.findElement(By.xpath(Locators.inputMetaTitleProd)).sendKeys(ValueProduct.META_TITLE);
        driver.findElement(By.xpath(Locators.textAreaDescriptionProd)).sendKeys(ValueProduct.META_DESCRIPTION);
        driver.findElement(By.xpath(Locators.buttonSaveAndPublish)).click();
        Thread.sleep(1000);
    }


}
