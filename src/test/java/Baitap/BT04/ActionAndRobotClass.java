package Baitap.BT04;

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

public class ActionAndRobotClass extends SetupDriver {

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

    @Test(priority = 2, description = "Add Product")
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
