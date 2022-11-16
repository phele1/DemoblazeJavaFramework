package Tests;

import PageObjects.CartPage;
import PageObjects.HomePage;
import Utils.BrowserFactory;
import Utils.ReadTestData;
import Utils.TakeScreenshot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BaseTests {
    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("firefox", " https://www.demoblaze.com/index.html");
    //CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadTestData readTestData;

    {
        try {
            readTestData = new ReadTestData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
