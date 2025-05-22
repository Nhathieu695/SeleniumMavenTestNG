package Baitap.BT03_1;

import Baitap.BT01.Locators;
import Baitap.BT02.SetupDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testAssert extends SetupDriver {

    // khai báo đối tượng của SoftAssert

    SoftAssert softAssert = new SoftAssert();
    @Test(priority = 1, description = "Login")
    public void testLogin() throws InterruptedException {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(Locators.inputEmail)).clear();
        driver.findElement(By.xpath(Locators.inputPassword)).clear();
        driver.findElement(By.xpath(Locators.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(Locators.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(Locators.buttonLogin)).click();
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
        driver.findElement(By.xpath(Locators.inputName)).sendKeys("Laptop MSI GEN 12");
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
        softAssert.assertTrue(driver.findElement(By.xpath(Locators.firstItem)).getText().contains("Laptop MSI GEN 12"), "Tên item không khớp");

        // Tổng hợp tất cả assert
        softAssert.assertAll();
    }

}
