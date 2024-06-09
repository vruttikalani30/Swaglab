package swaglab;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.productDetail.ProductDetailPO;
import utilities.Constants;

public class ProductDetailTest extends BaseTest {

    /*Test 1: Verify that user can add the product to the cart   */
    @Test
    public void verifyThatUserCanAddTheProductToTheCart() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        ProductDetailPO productDetail = new ProductDetailPO(driver);
        HomePagePO homepage = new HomePagePO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Enter login credentials and click on login button");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3 : Verify that user navigated to the home screen");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText is not present");

        Reporter.log("Step 4: Click on the product");
        String productName = "Sauce Labs Backpack";
        homepage.clickOnTheProduct(productName);

        Reporter.log("Step 5 : Verify that user navigated to product detail screen");
        String headerText = "Back to products";
        Assert.assertTrue(productDetail.isHeaderTextPresent(headerText), "headerText does not matched");

        Reporter.log("Step 6: Verify the product name of 'product detail' screen");
        Assert.assertTrue(productDetail.isProductTextPresent(productName), "Product name does not matched");

        Reporter.log("Step 7: Verify the product price of 'product detail' screen");
        double productPrice = 29.99;
        Assert.assertTrue(productDetail.isProductPricePresent(productPrice), "price does not matched");

        Reporter.log("Step 8: Click on 'Add to Cart' button");
        String buttonName = "Add to cart";
        homepage.clickOnAddToCartButton(buttonName);

        Reporter.log("Step 9: Verify the badge on cart icon");
        int badgeCount = 1;
        Assert.assertEquals(homepage.getBadgeCount(), badgeCount, "badge count does not matched");

        Reporter.log("Step 10: Click on the 'Remove' button");
        String removeButton = "Remove";
        homepage.clickOnRemoveButton(removeButton);

        Reporter.log("Sep 11: Verify that no badge present on cart icon");
        Assert.assertTrue(homepage.isBadgePresent(), "badge is present");

        Reporter.log("Step 12: Verify that the 'BackToProduct' button is present");
        String backToProductButton = "Back to products";
        Assert.assertTrue(productDetail.isBackToProductButtonPresent(backToProductButton), "'BackToProduct' button is not present");

        Reporter.log("Step 13 : Click on BackToProduct button");
        productDetail.clickOnBackToProductButton(backToProductButton);

        Reporter.log("Step 14 : Verify that user navigated to the home screen");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText is not present");
    }
}
