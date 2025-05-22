package Baitap.BT03_2;

import Baitap.BT01.Locators;
import Baitap.BT02.SetupDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class testAssert2 extends SetupDriver {

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
        driver.findElement(By.xpath(Locators.inputName)).sendKeys("Laptop MSI GEN 13");
        driver.findElement(By.xpath(Locators.buttonParentCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.inputParentCategory)).sendKeys("Laptop MSI");
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.itemLaptopMSI)).click();

        //check input parent Category
        softAssert.assertEquals(driver.findElement(By.xpath(Locators.buttonParentCategory)).getAttribute("title"), "Laptop MSI", "Parent Category không phù hợp");

        // check orderlevel
        driver.findElement(By.xpath(Locators.inputOrderLevel)).sendKeys("211");
        softAssert.assertEquals(driver.findElement(By.xpath(Locators.inputOrderLevel)).getAttribute("value"), "211", "Sai order level");

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

        driver.findElement(By.xpath(Locators.inputMetaTitle)).sendKeys("Laptop MSI GEN 13");
        //check meta title
        softAssert.assertEquals(driver.findElement(By.xpath(Locators.inputMetaTitle)).getAttribute("value"), "Laptop MSI GEN 13", "Sai meta title");

        driver.findElement(By.xpath(Locators.textareaMetaDescription)).sendKeys("Laptop MSI GEN 13 cải tiến chất lượng");
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
        softAssert.assertTrue(driver.findElement(By.xpath(Locators.firstItem)).getText().contains("Laptop MSI GEN 13"), "Tên item không khớp");

        // Tổng hợp tất cả assert
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Edit Category with Assert")
    public void editCategory() throws InterruptedException {
        // Tìm kiếm category cần sửa
        driver.findElement(By.xpath(Locators.searchCategory)).clear();
        driver.findElement(By.xpath(Locators.searchCategory)).sendKeys("Laptop MSI GEN 13", Keys.ENTER);
        Thread.sleep(1500);

        // Nhấn nút Edit (icon hình bút)
        driver.findElement(By.xpath(Locators.editFirstItem)).click();
        Thread.sleep(1000);

        // Sửa tên category
        WebElement inputName = driver.findElement(By.xpath(Locators.inputName));
        inputName.clear();
        inputName.sendKeys("Laptop MSI GEN 13_1");

        // Sửa Meta Title
        WebElement metaTitle = driver.findElement(By.xpath(Locators.inputMetaTitle));
        metaTitle.clear();
        metaTitle.sendKeys("Laptop MSI GEN 13_1");

        // Nhấn Save
        driver.findElement(By.xpath(Locators.buttonSave)).click();
        Thread.sleep(2000);

        // Kiểm tra thông báo cập nhật thành công
        String toastMsg = driver.findElement(By.xpath("//span[normalize-space(text())='Category has been updated successfully']")).getText();
        softAssert.assertEquals(toastMsg, "Category has been updated successfully", "Không có thông báo cập nhật");

        // Kiểm tra lại tên mới trong danh sách
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.searchCategory)).clear();
        driver.findElement(By.xpath(Locators.searchCategory)).sendKeys("Laptop MSI GEN 13_1", Keys.ENTER);
        Thread.sleep(1000);
        softAssert.assertTrue(driver.findElement(By.xpath(Locators.firstItem)).getText().contains("Laptop MSI GEN 13_1"), "Tên sau khi sửa không khớp");

        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Delete Category with Assert")
    public void deleteCategory() throws InterruptedException {

        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);
        // Tìm kiếm category để xóa
        driver.findElement(By.xpath(Locators.searchCategory)).clear();
        driver.findElement(By.xpath(Locators.searchCategory)).sendKeys("Laptop MSI GEN 7", Keys.ENTER);
        Thread.sleep(1500);

        // Nhấn nút Delete
        driver.findElement(By.xpath(Locators.deleteItem)).click();
        Thread.sleep(1000);

        // Xác nhận xóa (alert popup)
        driver.findElement(By.xpath(Locators.deleteConfirmation)).click(); // Nếu có alert trình duyệt xác nhận
        Thread.sleep(2000);

        // Kiểm tra thông báo xóa thành công
        String toastMsg = driver.findElement(By.xpath("//span[normalize-space(text())='Category has been deleted successfully']")).getText();
        softAssert.assertEquals(toastMsg, "Category has been deleted successfully", "không xóa được item");

        // Tìm lại để chắc chắn item đã xóa
        driver.findElement(By.xpath(Locators.searchCategory)).clear();
        driver.findElement(By.xpath(Locators.searchCategory)).sendKeys("Laptop MSI GEN 7", Keys.ENTER);
        Thread.sleep(1500);

        // Kiểm tra không còn hiển thị item đã xóa
        List<WebElement> results = driver.findElements(By.xpath(Locators.firstItem));
        softAssert.assertTrue(results.isEmpty(), "Vẫn tìm thấy item sau khi xóa");

        softAssert.assertAll();
    }



}
