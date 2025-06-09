package Baitap.BT07.testcases;

import Baitap.BT02.SetupDriver;
import Baitap.BT04_2.ValueCategory;
import Baitap.BT07.pages.CategoryPage;
import Baitap.BT07.pages.DashboardPage;
import Baitap.BT07.pages.LoginPage;
import Baitap.BT07.pages.ProductPage;
import org.testng.annotations.Test;

public class CategoryTest extends SetupDriver {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;
    ProductPage productPage;

    @Test(priority = 1)
    public void testNavigationToCategoryPage(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
        categoryPage = dashboardPage.clickmenuCategory();
        categoryPage.verifyToCategoryPage();
        categoryPage.clickElementAddNewCategory();
        categoryPage.verifyToAddNewCategory();
        categoryPage.submitDataForNewCategory();
        categoryPage.verifyAddCategorySuccess();
    }

    @Test(priority = 2)
    public void testAddNewCategory_SearchInTable(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
        categoryPage = dashboardPage.clickmenuCategory();
        categoryPage.verifyToCategoryPage();
        categoryPage.searchDataInTable();
        categoryPage.clickbuttonEditFirstCategory();
        categoryPage.verifyAddNewCategorySuccess();
    }

    @Test(priority = 3)
    public void testEditCategory(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
        categoryPage = dashboardPage.clickmenuCategory();
        categoryPage.verifyToCategoryPage();
        categoryPage.searchDataInTable();
        categoryPage.clickbuttonEditFirstCategory();
        categoryPage.submitEditCategory("Laptop Zenbook 2");
        categoryPage.verifyEditCategorySuccess();
    }

    @Test(priority = 4)
    public void testEditCategory_SearchInTable(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();
        categoryPage = dashboardPage.clickmenuCategory();
        categoryPage.verifyToCategoryPage();
        categoryPage.searchDataInTable("Laptop Zenbook 2");
        categoryPage.clickbuttonEditFirstCategory();
        categoryPage.   verifyEditNewCategorySuccess("Laptop Zenbook 2");
    }

}
