package Baitap.BT06.pages;

import Baitap.keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By headerPage = By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']");
    private By  inputEmail = By.xpath( "//input[@id='email']");
    private By  inputPassword = By.xpath("//input[@id='password']");
    private By  buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class, 'alert-danger')]/span");

    public void enterEmail(String email){
        WebUI.setText(inputEmail, email);
    }

    public void enterPassword(String password){
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton(){
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("login"), "FAIL. Vẫn còn ở trang Login");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid login credentials", "Content of error massage NOT match.");
    }

    public void loginCMS(String email, String password) {
        WebUI.openURL("https://cms.anhtester.com/login");
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);

    }

    public DashboardPage loginCMS() {
        WebUI.openURL("https://cms.anhtester.com/login");
        WebUI.setText(inputEmail, "admin@example.com");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);
        verifyLoginSuccess();
        return new DashboardPage(driver);
    }
}
