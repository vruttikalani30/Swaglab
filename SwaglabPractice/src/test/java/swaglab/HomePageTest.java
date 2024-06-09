package swaglab;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import utilities.Constants;

public class HomePageTest extends BaseTest {

    /*Test 1: Verify that user can click on moreMenu options */
    @Test
    public void verifyThatUserCanClickOnMoreMenuOptions() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Enter login credentials and click on login button");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3: Verify that the menu icon is displayed on homepage");
        Assert.assertTrue(homepage.isMoreMenuIconPresent(), "more menu icon is not present");

        Reporter.log("Step 4: Click on moreMenu icon");
        homepage.clickOnMoreMenuOptions();

        Reporter.log("Step 5 : Verify that the 'AllItems' option is displayed");
        Assert.assertTrue(homepage.isAllItemsOptionPresent(), "'AllItems' option is not present");

        Reporter.log("Step 6: Click on  All Items option");
        homepage.clickOnAllItemsOption();

        Reporter.log("Step 7 : Verify that the 'About' option is displayed");
        Assert.assertTrue(homepage.isAboutOptionPresent(), "About option is not present");

        Reporter.log("Step 8: Click on about option");
        homepage.clickOnAboutOption();

        Reporter.log("Step 9 : Verify that user navigated to 'SAUCELABS' about webpage");
        Assert.assertTrue(homepage.isAboutPageHeaderTextPresent(), "HeaderText is not present");
        driver.navigate().back();

        Reporter.log("Step 10: Verify that user is navigated back to the home page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText is not present");

        Reporter.log("Step 11 : Click on 'Add to Cart' button");
        String buttonName = "Add to cart";
        homepage.clickOnAddToCartButton(buttonName);

        Reporter.log("Step 12: Verify that badge count is present");
        Assert.assertTrue(homepage.isBadgePresent(), "badge count is not present");

        Reporter.log("Step 13 : Verify that the resetApp State Option is displayed");
        Assert.assertTrue(homepage.isResetAppStatePresent(), "'ResetAppState' option is not present");

        Reporter.log("Step 14 : Click on reset app state option");
        homepage.clickOnResetAppStateOption();

        Reporter.log("Step 15:  Verify that cart-icon badge is removed");
        Assert.assertTrue(homepage.isBadgePresent(), "Count does not matched");

        Reporter.log("Step 16: Verify that logout option is displayed");
        Assert.assertTrue(homepage.isLogoutOptionPresent(), "Logout option is not present");

        Reporter.log("Step 17 : Click on logout option");
        homepage.clickOnLogoutOption();

        Reporter.log("Step 18 : Verify that user navigated to login page");
        driver.getCurrentUrl();
        Assert.assertTrue(homepage.isLoginButtonPresent(), "login button is not present");
    }

    /*Test 2: Verify that user can apply product filters   */
    @Test
    public void verifyThatUserCanApplyProductFilters() throws InterruptedException {
        HomePagePO homepage = new HomePagePO(driver);
        LoginPO login = new LoginPO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Enter login credentials and click on login button");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3 : Verify that the filter button is present");
        Assert.assertTrue(homepage.isFilterButtonPresent(), "Filter button is not present");

        Reporter.log("Step 4: Verify the filter text 'Name (A to Z)' is present");
        Assert.assertTrue(homepage.isFilterTextPresent("Name (A to Z)"), " 'NameAToZ' text does not present");

        Reporter.log("Step 5: Verify the product is present");
        String productName = "Sauce Labs Backpack";
        Assert.assertTrue(homepage.isProductPresent(productName), "product is not present");

        Reporter.log("Step 6: Click on the 'Name(Z to A)' filter button ");
        String filterButtonName = "Name (Z to A)";
        homepage.clickOnZtoAFilterButton(filterButtonName);

        Reporter.log("Step 7: Verify the filter text 'Name (Z to A)' is present");
        Assert.assertTrue(homepage.isFilterTextPresent(filterButtonName), "NameZToA text does not present");

        Reporter.log("Step 8: Verify the product is present");
        String testProductName = "Test.allTheThings() T-Shirt (Red)";
        Assert.assertTrue(homepage.isProductPresent(testProductName), "product is not present");

        Reporter.log("Step 9: Click on the 'priceLowToHigh' button");
        String priceFilterButton = "Price (low to high)";
        homepage.clickOnPriceLowTohHighFilterButton(priceFilterButton);

        Reporter.log("Step 10: Verify the filter text 'Price (low to high)' is present");
        Assert.assertTrue(homepage.isFilterTextPresent(priceFilterButton), "Price (low to high) text is not present ");

        Reporter.log("Step 11: Verify the product price");
        String productPrice = "7.99";
        Assert.assertTrue(homepage.isProductPricePresent(productPrice), "product price does not present");

        Reporter.log("Step 12: Click on the 'priceHighToLow' button");
        String testPriceFilterButton = "Price (high to low)";
        homepage.clickOnPriceHighToLowFilterButton(testPriceFilterButton);

        Reporter.log("Step 13: Verify the filter text 'Price (high to low)' is present");
        Assert.assertTrue(homepage.isFilterTextPresent(testPriceFilterButton), "price(high to low) text is not present");

        Reporter.log("Step 14: Verify the product price");
        String testProductPrice = "49.99";
        Assert.assertTrue(homepage.isProductPricePresent(testProductPrice), "product price does not present");
    }

    /*Test 3: Verify that user can add and remove the products  */
    @Test
    public void verifyThatUserCanAddAndRemoveTheProducts() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Enter login credentials and click on login button");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3: Verify that the all products are displayed");
        String[] product = {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)"};
        Assert.assertTrue(homepage.isAllProductPresent(product), "product is not present");

        Reporter.log("Step 4: Click on the all 'Add to Cart' button");
        homepage.clickOnAllCartButton(product);

        Reporter.log("Step 5: Verify the badge icon is present");
        String count = "6";
        Assert.assertTrue(homepage.isCountPresent(count), "badge icon is not present");

        Reporter.log("Step 6: Click on the all 'Remove' button");
        homepage.clickOnAllCartButton(product);

        Reporter.log("Step 7: Verify the badge icon");
        Assert.assertTrue(homepage.isBadgePresent(), "badge is present");
    }

    /*Test 4: Verify that user can click on footer buttons */
    @Test
    public void verifyThatUserCanClickOnFooterButtons() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Enter login credentials and click on login button");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3: Verify that 'Twitter' button is present");
        String twitterButton = "Twitter";
        Assert.assertTrue(homepage.isFooterButtonPresent(twitterButton), "button not present");

        Reporter.log("Step 4: Click on the 'Twitter' button");
        homepage.clickOnFooterButton(twitterButton);

        Reporter.log("Step 5: Verify that 'Facebook' button is present ");
        String facebookButton = "Facebook";
        Assert.assertTrue(homepage.isFooterButtonPresent(facebookButton), "facebook button is not present");

        Reporter.log("Step 6: Click on the 'Facebook' button");
        homepage.clickOnFooterButton(facebookButton);

        Reporter.log("Step 7: Verify that 'Linkedin' button is present");
        String linkedinButton = "LinkedIn";
        Assert.assertTrue(homepage.isFooterButtonPresent(linkedinButton), "button not present");

        Reporter.log("Step 8: Click on the 'Linkedin' button");
        homepage.clickOnFooterButton(linkedinButton);

        Reporter.log("Step 9: Verify that the user is navigated to the linkedin page");
        Assert.assertTrue(homepage.isLinkedinHeaderTextPresent(), "HeaderText is not present");
    }
}