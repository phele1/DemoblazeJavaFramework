package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class PurchaseLaptop extends BaseTests {

    @Test
    public void VerifyProductStorePage() throws InterruptedException {
        //takeScreenshot.takeSnapshot(driver, "ProductStorePage");
        homePage
                .verifySuccessfulHomepageLoading();

    }

    @Test
    public void HomePageNavigationToCart() throws InterruptedException {
        homePage
                .clickLaptopsButton()
                .selectLaptop()
                .clickAddToCartButton()
                .productAddedPopUp();
        takeScreenshot.takeSnapshot(driver, "LaptopAddedToCart");

        homePage
                .verifyPopupMessage()
                .clickOkOnPopUp()
                .clickCartButton();

        Thread.sleep(5000);

    }

//    @Test
//    public void VerifyAddedLaptopInCart() {
//        takeScreenshot.takeSnapshot(driver, "LaptopInCart");
//        cartPage
//                .verifyAddedLaptopIsAvailable()
//                .clickPlaceOrderButton();
//    }
//
//    @Test
//    public void PurchaseWithoutFillingInformation() {
//        cartPage
//                .clickPurchaseWithoutInfo();
//
//    }
//
//    @Test
//    public void VerificationOfErrorMessage() {
//        takeScreenshot.takeSnapshot(driver, "PurchaseError");
//    }
//
//    @Test
//    public void PurchaseWithInfo() throws InterruptedException {
//        cartPage
//                .enterName(readTestData.name)
//                .enterCountry(readTestData.country)
//                .enterCity(readTestData.city)
//                .enterCreditCard(readTestData.creditcard)
//                .enterMonth(readTestData.month)
//                .enterYear(readTestData.year)
//                .clickPurchaseButton();
//
//
//        takeScreenshot.takeSnapshot(driver, "SuccessfulPurchase");
//        cartPage
//                .verifySuccessfulPurchase()
//                .clickOkButton();
//
//        Thread.sleep(5000);
//
//    }


    @AfterTest
    public void closeBrowser() {
        browserFactory.teardown();
    }

}
