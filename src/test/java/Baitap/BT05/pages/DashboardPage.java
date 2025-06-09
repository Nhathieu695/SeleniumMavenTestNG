package Baitap.BT05.pages;

import Baitap.keyword.WebUI;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends basePage  {

    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

}
