package swaglab;

import base.BaseTest;
import datafactory.CheckoutYourInformationData;
import dataobjects.CheckoutYourInformation;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.checkoutoverview.CheckoutOverviewPO;
import pageobjects.checkoutyourinformation.CheckoutYourInformationPO;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.productDetail.ProductDetailPO;
import pageobjects.yourcart.YourCartPO;
import utilities.Constants;

public class CheckoutOverviewTest extends BaseTest {

    /*Test 1: Verify that user can checkout the product successfully*/
    @Test
    public void VerifyThatUserCanCheckoutTheProductSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);
        CheckoutYourInformation checkout = new CheckoutYourInformationData().checkoutInformationData();
        CheckoutOverviewPO checkoutOverview = new CheckoutOverviewPO(driver);
        YourCartPO yourCart = new YourCartPO(driver);
        ProductDetailPO productDetail = new ProductDetailPO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Login successfully");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3 : Click on AddToCart Button");
        String buttonName = "Add to cart";
        homepage.clickOnAddToCartButton(buttonName);

        Reporter.log("Step 4: Verify that badge count is present");
        Assert.assertTrue(homepage.isBadgePresent(), "badge count is not present");

        Reporter.log("Step 5: Click on the Your cart icon");
        checkoutYourInformation.clickOnYourCartIcon();

        Reporter.log("Step 6 : Verify that user is navigated to the 'Your cart' page");
        String cartPageHeaderText = "YOUR CART";
        Assert.assertEquals(yourCart.getTheHeaderText(), cartPageHeaderText, "headerText does not matched");

        Reporter.log("Step 7: Click on the 'Checkout' button");
        yourCart.clickOnCheckoutButton();

        Reporter.log("Step 8: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");

        Reporter.log("Step 9 : Enter the valid data in all the fields");
        checkoutYourInformation.enterTheValidData(checkout);

        Reporter.log("Step 10: Verify that firstname is present in field");
        String firstname = "Test";
        Assert.assertTrue(checkoutYourInformation.isFirstnamePresent(firstname), "data is not present");

        Reporter.log("Step 11: Click on Continue button");
        checkoutYourInformation.clickOnContinueButton();

        Reporter.log("Step 12: Verify that the user is navigated to the 'Checkout:Overview' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");

        Reporter.log("Step 13: Verify the product name is present");
        String productName = "Sauce Labs Backpack";
        Assert.assertTrue(productDetail.isProductTextPresent(productName), "Product name does not matched");

        Reporter.log("Step 14 : Verify the product total price with the product final price");
        double price = 29.99;
        Assert.assertEquals(checkoutOverview.getItemTotalPrice(), checkoutOverview.getProductPrice(price), "price not matched");

        Reporter.log("Step 15: Verify the total price of the product");
        double totalPrice = 32.39;
        Assert.assertEquals(checkoutOverview.getActualTotalPrice(), checkoutOverview.getExpectedTotalPrice(totalPrice), "Price total does not matched");
    }

    /*Test 2: Verify that user can cancel the product successfully*/
    @Test
    public void VerifyThatUserCanCancelTheProductSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);
        CheckoutYourInformation checkout = new CheckoutYourInformationData().checkoutInformationData();
        YourCartPO yourCart = new YourCartPO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Login successfully");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3 : Click on AddToCart Button");
        String buttonName = "Add to cart";
        homepage.clickOnAddToCartButton(buttonName);

        Reporter.log("Step 4: Verify that badge count is present");
        Assert.assertTrue(homepage.isBadgePresent(), "badge count is not present");

        Reporter.log("Step 5: Click on the Your cart icon");
        checkoutYourInformation.clickOnYourCartIcon();

        Reporter.log("Step 6 : Verify that user is navigated to the 'Your cart' page");
        String cartPageHeaderText = "YOUR CART";
        Assert.assertEquals(yourCart.getTheHeaderText(), cartPageHeaderText, "headerText does not matched");

        Reporter.log("Step 7: Click on the 'Checkout' button");
        yourCart.clickOnCheckoutButton();

        Reporter.log("Step 8: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");

        Reporter.log("Step 9 : Enter the valid data in all the fields");
        checkoutYourInformation.enterTheValidData(checkout);

        Reporter.log("Step 10: Verify that firstname is present in field");
        String firstname = "Test";
        Assert.assertTrue(checkoutYourInformation.isFirstnamePresent(firstname), "data is not present");

        Reporter.log("Step 11: Click on Continue button");
        checkoutYourInformation.clickOnContinueButton();

        Reporter.log("Step 12: Verify that the user is navigated to the 'Checkout:Overview' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");

        Reporter.log("Step 13: Click on the 'cancel' button");
        String cancelButton = "Cancel";
        checkoutYourInformation.clickOnCancelButton(cancelButton);

        Reporter.log("Step 14: Verify that the user navigated back to home page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");
    }

    /*Test 3: Verify that user can click on the finish button successfully*/
    @Test
    public void VerifyThatUserCanClickOnTheFinishButtonSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);
        CheckoutYourInformation checkout = new CheckoutYourInformationData().checkoutInformationData();
        YourCartPO yourCart = new YourCartPO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Login successfully");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3 : Click on AddToCart Button");
        String buttonName = "Add to cart";
        homepage.clickOnAddToCartButton(buttonName);

        Reporter.log("Step 4: Verify that badge count is present");
        Assert.assertTrue(homepage.isBadgePresent(), "badge count is not present");

        Reporter.log("Step 5: Click on the Your cart icon");
        checkoutYourInformation.clickOnYourCartIcon();

        Reporter.log("Step 6 : Verify that user is navigated to the 'Your cart' page");
        String cartPageHeaderText = "YOUR CART";
        Assert.assertEquals(yourCart.getTheHeaderText(), cartPageHeaderText, "headerText does not matched");

        Reporter.log("Step 7: Click on the 'Checkout' button");
        yourCart.clickOnCheckoutButton();

        Reporter.log("Step 8: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");

        Reporter.log("Step 9 : Enter the valid data in all the fields");
        checkoutYourInformation.enterTheValidData(checkout);

        Reporter.log("Step 10: Verify that firstname is present in field");
        String firstname = "Test";
        Assert.assertTrue(checkoutYourInformation.isFirstnamePresent(firstname), "data is not present");

        Reporter.log("Step 11: Click on Continue button");
        checkoutYourInformation.clickOnContinueButton();

        Reporter.log("Step 12: Verify that the user is navigated to the 'Checkout:Overview' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");

        Reporter.log("Step 13: Click on 'Finish' button");
        String finishButton = "Finish";
        checkoutYourInformation.clickOnFinishButton(finishButton);

        Reporter.log("Step 14: Verify that user is navigated to the 'Checkout:Complete' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");
    }

    /*Test 4: Verify that user can click on the back home button successfully*/
    @Test
    public void VerifyThatUserCanClickOnTheBackHomeButtonSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);
        CheckoutYourInformation checkout = new CheckoutYourInformationData().checkoutInformationData();
        YourCartPO yourCart = new YourCartPO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Login successfully");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3 : Click on AddToCart Button");
        String buttonName = "Add to cart";
        homepage.clickOnAddToCartButton(buttonName);

        Reporter.log("Step 4: Verify that badge count is present");
        Assert.assertTrue(homepage.isBadgePresent(), "badge count is not present");

        Reporter.log("Step 5: Click on the Your cart icon");
        checkoutYourInformation.clickOnYourCartIcon();

        Reporter.log("Step 6 : Verify that user is navigated to the 'Your cart' page");
        String cartPageHeaderText = "YOUR CART";
        Assert.assertEquals(yourCart.getTheHeaderText(), cartPageHeaderText, "headerText does not matched");

        Reporter.log("Step 7: Click on the 'Checkout' button");
        yourCart.clickOnCheckoutButton();

        Reporter.log("Step 8: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");

        Reporter.log("Step 9 : Enter the valid data in all the fields");
        checkoutYourInformation.enterTheValidData(checkout);

        Reporter.log("Step 10: Verify that firstname is present in field");
        String firstname = "Test";
        Assert.assertTrue(checkoutYourInformation.isFirstnamePresent(firstname), "data is not present");

        Reporter.log("Step 11: Click on Continue button");
        checkoutYourInformation.clickOnContinueButton();

        Reporter.log("Step 12: Verify that the user is navigated to the 'Checkout:Overview' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");

        Reporter.log("Step 13: Click on 'Finish' button");
        String finishButton = "Finish";
        checkoutYourInformation.clickOnFinishButton(finishButton);

        Reporter.log("Step 14: Verify that user is navigated to the 'Checkout:Complete' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");

        Reporter.log("Step 15 : Click on Back Home button");
        checkoutYourInformation.clickOnBackHomeButton();

        Reporter.log("Step 16: Verify that user is navigated to the home page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText is not present");
    }
}
