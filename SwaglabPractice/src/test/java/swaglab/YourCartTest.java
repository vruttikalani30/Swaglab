package swaglab;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.checkoutyourinformation.CheckoutYourInformationPO;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.productDetail.ProductDetailPO;
import pageobjects.yourcart.YourCartPO;
import utilities.Constants;

public class YourCartTest extends BaseTest {

    /*Test 1: Verify that user can checkout the items successfully */
    @Test
    public void verifyThatUserCanCheckoutTheProductSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        YourCartPO yourCart = new YourCartPO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);

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

        Reporter.log("Step 7 : Verify the checkout button is present");
        String checkoutButton = "Checkout";
        Assert.assertTrue(yourCart.isCheckoutButtonPresent(checkoutButton), "checkout button is not present");

        Reporter.log("Step 8: Click on the 'Checkout' button");
        yourCart.clickOnCheckoutButton();

        Reporter.log("Step 9: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");
    }

    /*Test 2: Verify that user can remove the product successfully */
    @Test
    public void verifyThatUserCanRemoveTheProductSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        YourCartPO yourCart = new YourCartPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);

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

        Reporter.log("Step 7 : click on remove button");
        String removeButton = "Remove";
        homepage.clickOnRemoveButton(removeButton);

        Reporter.log("Step 8 : Verify that the cart item is empty ");
        String productName = "Sauce Labs Backpack";
        Assert.assertFalse(homepage.isCartItemPresent(productName), "cart item is not empty");

        Reporter.log("Step 9: Verify the badge count");
        String count = "";
        Assert.assertEquals(yourCart.getTheBadgeCount(), count, "count does not matched");
    }

    /*Test 3: Verify that user can continue to shopping the products successfully */
    @Test
    public void verifyThatUserCanContinueToShoppingTheProductsSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        YourCartPO yourCart = new YourCartPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);

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

        Reporter.log("Step 7: Click on Continue Shopping Button");
        homepage.clickOnContinueShoppingButton();

        Reporter.log("Step 8: Verify that user navigated to home page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText is not present");

        Reporter.log("Step 9 : Add more products to the Cart");
        String[] product = {"Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light"};
        homepage.clickOnAllCartButton(product);

        Reporter.log("Step 10: Verify the count of badge");
        int badgeCount = 3;
        Assert.assertEquals(homepage.getBadgeCount(), badgeCount, "badge count does not matched");

        Reporter.log("Step 11 : Click on the 'cart' icon");
        yourCart.clickOnYourCartIcon();

        Reporter.log("Step 12: Verify that added products are present in the 'cart' page");
        Assert.assertTrue(homepage.isAllProductPresent(product), "product is not present");
    }

    /*Test 4: Verify that the product is successfully added to the cart*/
    @Test
    public void verifyThatTheProductIsSuccessfullyAddedToTheCart() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        YourCartPO yourCart = new YourCartPO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);
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

        Reporter.log("Step 7: Verify that the product is present");
        String productName = "Sauce Labs Backpack";
        Assert.assertTrue(productDetail.isProductTextPresent(productName), "Product name does not matched");

        Reporter.log("Step 8: Verify the product price is present");
        double productPrice = 29.99;
        Assert.assertTrue(productDetail.isProductPricePresent(productPrice), "price does not matched");
    }
}
