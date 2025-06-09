package Baitap.BT06.testcases;

import Baitap.BT02.SetupDriver;
import Baitap.BT05.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends SetupDriver {

    LoginPage loginPage;

    @Test(priority = 1)
    public void loginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void loginFailWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test(priority = 3)
    public void loginFailWithPasswordInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCMS("admin@example.com", "123");
        loginPage.verifyLoginFail();
    }
}
