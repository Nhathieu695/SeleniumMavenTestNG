package Baitap.BT06.testcases;

import Baitap.BT02.SetupDriver;
import Baitap.BT04_2.ValueProduct;
import Baitap.BT06.pages.DashboardPage;
import Baitap.BT06.pages.LoginPage;
import Baitap.BT06.pages.ProductPage;
import org.testng.annotations.Test;

import java.awt.*;

public class ProductTest extends SetupDriver {

   Baitap.BT06.pages.LoginPage loginPage;
   DashboardPage dashboardPage;
   ProductPage productPage;

    @Test(priority = 1)
    public void testAddNewProduct() throws AWTException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
        productPage = dashboardPage.clickmenuProduct();
        productPage.verifyToProductPage();
        productPage.clickElementButtonAddNewProduct();
        productPage.submitDataForNewProduct();
        productPage.verifyAllertSuccess();
        productPage.verifyNavigateToAllProduct();
    }

    @Test(priority = 2)
    public void testAddNewProduct_SearchInTable(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
        productPage = dashboardPage.clickmenuProduct();
        productPage.verifyToProductPage();
        productPage.searchAndCheckProductInTable();
        productPage.verifyAddNewProductSuccess();
    }

    @Test(priority = 3)
    public void testEditProduct() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
        productPage = dashboardPage.clickmenuProduct();
        productPage.verifyToProductPage();
        productPage.submitDataForEditProduct();
        productPage.verifyAllertEditSuccess();
    }

    @Test(priority = 4)
    public void testEditProduct_SearchInTable(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
        productPage = dashboardPage.clickmenuProduct();
        productPage.verifyToProductPage();
        productPage.searchAndCheckProductInTable("Laptop Edit 1C");
        productPage.verifyEditProduct();

    }
}
