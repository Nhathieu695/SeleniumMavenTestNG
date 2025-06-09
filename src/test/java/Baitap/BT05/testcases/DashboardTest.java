package Baitap.BT05.testcases;

import Baitap.BT02.SetupDriver;
import Baitap.BT05.pages.DashboardPage;
import Baitap.BT05.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends SetupDriver {

    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void goToCategoryPage(){
        LoginPage loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCMS();

    }
}
