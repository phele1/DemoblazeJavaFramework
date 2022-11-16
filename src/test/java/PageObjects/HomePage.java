package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
public class HomePage {



    WebDriver driver = null;

        @FindBy(xpath = "//a[contains(@id,'nava')]")
        WebElement product_store_xpath;

        @FindBy(xpath = "//a[@href='#'][contains(.,'Laptops')]")
        WebElement laptops_xpath;

        @FindBy(xpath = "//a[@href='prod.html?idp_=11'][contains(.,'MacBook air')]")
        WebElement select_laptop_xpath;

        @FindBy(xpath = "//a[@href='#'][contains(.,'Add to cart')]")
        WebElement add_to_cart_xpath;

        Alert alert = driver.switchTo().alert();

        String alertMessage = driver.switchTo().alert().getText();

        @FindBy(xpath = "//a[@href='cart.html']")
        WebElement cart_xpath;


    public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        public HomePage verifySuccessfulHomepageLoading () {
            Assert.assertEquals(product_store_xpath.getText(), "PRODUCT STORE!");
            return this;
        }

        public HomePage clickLaptopsButton () {
            laptops_xpath.click();
            return this;
        }
        public HomePage selectLaptop () {
            select_laptop_xpath.click();
            return this;
        }

        public HomePage clickAddToCartButton () {
            add_to_cart_xpath.click();
            return this;
        }
        public void  productAddedPopUp () throws InterruptedException {
        Thread.sleep(3000);
            Alert alert = driver.switchTo().alert();
            Thread.sleep(3000);

        }
    public HomePage clickOkOnPopUp() {
        alert.accept();
        return this;

    }
        public HomePage verifyPopupMessage () {
            Assert.assertEquals(alertMessage, "Product Added");
            return this;

        }
        public HomePage clickCartButton () {
            cart_xpath.click();
            return this;
        }
    }
