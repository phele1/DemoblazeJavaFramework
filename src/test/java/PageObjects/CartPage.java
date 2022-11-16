package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {

    WebDriver driver = null;

    @FindBy(xpath = "//td[contains(.,'MacBook air')]")
    WebElement added_laptop_xpath;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Place Order')]")
    WebElement place_order_xpath;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Purchase')]")
    WebElement purchase_without_info_xpath;

// popup element needed

    @FindBy(xpath = "//input[@id='name']")
    WebElement name_xpath;

    @FindBy(xpath = "//input[contains(@id,'country')]")
    WebElement country_xpath;

    @FindBy(xpath = "//input[contains(@id,'city')]")
    WebElement city_xpath;

    @FindBy(xpath = "//input[contains(@id,'card')]")
    WebElement credit_card_xpath;

    @FindBy(xpath = "//input[contains(@id,'month')]")
    WebElement month_xpath;

    @FindBy(xpath = "//input[contains(@id,'year')]")
    WebElement year_xpath;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Purchase')]")
    WebElement purchase_with_info_xpath;

    @FindBy(xpath = "//h2[contains(.,'Thank you for your purchase!')]")
    WebElement successful_purchase_xpath;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Purchase')]")
    WebElement ok_xpath;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage verifyAddedLaptopIsAvailable() {
        Assert.assertEquals(added_laptop_xpath.getText(), "MacBook air");
        return this;
    }

    public CartPage clickPlaceOrderButton() {
        place_order_xpath.click();
        return this;
    }

    public CartPage clickPurchaseWithoutInfo() {
        purchase_without_info_xpath.click();
        return this;
    }
// assertion for error message popup
//clicking of ok button

    public CartPage enterName(String name) {
        name_xpath.sendKeys(name);
        return this;
    }

    public CartPage enterCountry(String country) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(name_xpath));
        country_xpath.sendKeys(country);
        return this;
    }

    public CartPage enterCity(String city) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(country_xpath));
        city_xpath.sendKeys(city);
        return this;
    }

    public CartPage enterCreditCard(String creditcard) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(city_xpath));
        credit_card_xpath.sendKeys(creditcard);
        return this;
    }

    public CartPage enterMonth(String month) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(credit_card_xpath));
        month_xpath.sendKeys(month);
        return this;
    }

    public CartPage enterYear(String year) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(month_xpath));
        year_xpath.sendKeys(year);
        return this;
    }

    public CartPage clickPurchaseButton() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(year_xpath));
        purchase_with_info_xpath.click();
        return this;
    }

    public CartPage verifySuccessfulPurchase() {
        Assert.assertEquals(successful_purchase_xpath.getText(), "Thank you for your purchase!");
        return this;
    }

    public CartPage clickOkButton() {
        ok_xpath.click();
        return this;
    }

}
