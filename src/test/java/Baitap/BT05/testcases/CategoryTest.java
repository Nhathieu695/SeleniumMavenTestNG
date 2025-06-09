package Baitap.BT05.testcases;

import Baitap.BT02.SetupDriver;
import Baitap.BT05.pages.CategoryPage;
import Baitap.BT05.pages.DashboardPage;
import Baitap.BT05.pages.LoginPage;
import Baitap.BT05.pages.ProductPage;
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
    }
}
