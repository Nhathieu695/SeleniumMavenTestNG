package Baitap.BT01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class addCategory extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        createDriver();

        loginCRM();

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        driver.findElement(By.xpath(Locators.inputName)).sendKeys("Laptop MSI GEN 5");
        driver.findElement(By.xpath(Locators.buttonParentCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.inputParentCategory)).sendKeys("Laptop MSI");
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.itemLaptopMSI)).click();

        driver.findElement(By.xpath(Locators.inputOrderLevel)).sendKeys("25");
        driver.findElement(By.xpath(Locators.buttonType)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.itemPhysical)).click();

        driver.findElement(By.xpath(Locators.browseBanner)).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath(Locators.imageBannerLaptopMSI)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.addFilesBanner)).click();

        driver.findElement(By.xpath(Locators.browseIcon)).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath(Locators.imageIconLaptop)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.addFilesIcon)).click();

        driver.findElement(By.xpath(Locators.inputMetaTitle)).sendKeys("Laptop MSI GEN 5");
        driver.findElement(By.xpath(Locators.textareaMetaDescription)).sendKeys("Laptop MSI GEN 5 cải tiến chất lượng");

        driver.findElement(By.xpath(Locators.buttonFilteringAttributes)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators.itemSize)).click();

        driver.findElement(By.xpath(Locators.buttonSave)).click();
        Thread.sleep(2000);

        // check data Category
        driver.findElement(By.xpath(Locators.searchCategory)).sendKeys("Laptop", Keys.ENTER);
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.xpath(Locators.firstItem)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(Locators.firstItem)).getText());

        driver.findElement(By.xpath(Locators.editFirstItem)).click();
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.xpath(Locators.inputName)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(Locators.buttonParentCategory)).getAttribute("title"));
        System.out.println(driver.findElement(By.xpath(Locators.inputOrderLevel)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(Locators.buttonType)).getAttribute("title"));
        System.out.println(driver.findElement(By.xpath("//div[@title='LaptopMSI.webp']")).getAttribute("title"));
        System.out.println(driver.findElement(By.xpath("//div[@title='iconLaptop.png']")).getAttribute("title"));
        System.out.println(driver.findElement(By.xpath(Locators.inputMetaTitle)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(Locators.textareaMetaDescription)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(Locators.buttonFilteringAttributes)).getAttribute("title"));

        closeDriver();
    }
}
