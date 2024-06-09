package swaglab;

import base.BaseTest;
import datafactory.CheckoutYourInformationData;
import dataobjects.CheckoutYourInformation;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.checkoutyourinformation.CheckoutYourInformationPO;
import pageobjects.homepage.HomePagePO;
import pageobjects.login.LoginPO;
import pageobjects.yourcart.YourCartPO;
import utilities.Constants;

public class CheckoutYourInformationTest extends BaseTest {

    /*Test 1: Verify that user can enter the valid data in 'checkout your information' page */
    @Test
    public void VerifyThatUserCanEnterTheValidDataInCheckoutYourInformationPage() throws InterruptedException {
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

        Reporter.log("Step 7 : Verify the checkout button is present");
        String checkoutButton = "Checkout";
        Assert.assertTrue(yourCart.isCheckoutButtonPresent(checkoutButton), "checkout button is not present");

        Reporter.log("Step 8: Click on the 'Checkout' button");
        yourCart.clickOnCheckoutButton();

        Reporter.log("Step 9: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");

        Reporter.log("Step 10 : Enter the valid data in all the fields");
        checkoutYourInformation.enterTheValidData(checkout);

        Reporter.log("Step 11: Verify that firstname is present in field");
        String firstName = "Test";
        Assert.assertTrue(checkoutYourInformation.isFirstnamePresent(firstName), "data is not present");
    }

    /*Test 2: Verify that validation message is displayed when user put the fields empty */
    @Test
    public void verifyTheValidationMessageWhenUserPutTheFieldsEmpty() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);
        CheckoutYourInformation checkoutData = new CheckoutYourInformationData().checkoutInformationData();
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

        Reporter.log("Step 7 : Click on Checkout Button");
        String checkoutButton = "Checkout";
        checkoutYourInformation.clickOnCheckoutButton(checkoutButton);

        Reporter.log("Step 8: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");

        Reporter.log("Step 9 : Clicking on 'continue' button with empty fields");
        checkoutYourInformation.clickOnContinueButton();

        Reporter.log("Step 10: Verify that the validation message is displayed");
        String validationMessage = "Error: First Name is required";
        Assert.assertTrue(checkoutYourInformation.isValidationMessagePresent(validationMessage), "Validation message does not matched");

        Reporter.log("Step 11: Enter the firstname & zipcode");
        checkoutYourInformation.enterTheFirstNameAndZipCode(checkoutData);

        Reporter.log("Step 12: Verify that firstname is present in field");
        String firstName = "Test";
        Assert.assertTrue(checkoutYourInformation.isFirstnamePresent(firstName), "data is not present");

        Reporter.log("Step 13: Click on the continue button");
        checkoutYourInformation.clickOnContinueButton();

        Reporter.log("Step 14: Verify that the user is navigated to the 'Checkout:Overview' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");
    }

    /*Test 3: Verify that user can cancel the checked out product successfully  */
    @Test
    public void verifyTheUserCanCancelTheCheckedOutProductSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        HomePagePO homepage = new HomePagePO(driver);
        CheckoutYourInformationPO checkoutYourInformation = new CheckoutYourInformationPO(driver);
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

        Reporter.log("Step 7 : Click on Checkout Button");
        String checkoutButton = "Checkout";
        checkoutYourInformation.clickOnCheckoutButton(checkoutButton);

        Reporter.log("Step 8: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");

        Reporter.log("Step 9: Click on the 'cancel' button");
        String cancelButton = "Cancel";
        checkoutYourInformation.clickOnCancelButton(cancelButton);

        Reporter.log("Step 10: Verify that the user navigated back to 'Your cart' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");
    }

    /*Test 4: Verify that user can continue to checked out product successfully  */
    @Test
    public void verifyTheUserCanContinueTheCheckedOutProductSuccessfully() throws InterruptedException {
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

        Reporter.log("Step 7 : Verify the checkout button is present");
        String checkoutButton = "Checkout";
        Assert.assertTrue(yourCart.isCheckoutButtonPresent(checkoutButton), "checkout button is not present");

        Reporter.log("Step 8: Click on the 'Checkout' button");
        yourCart.clickOnCheckoutButton();

        Reporter.log("Step 9: Verify that user is navigated to 'checkout:your information' page");
        String pageTitle = "Checkout: Your Information";
        Assert.assertTrue(yourCart.isCheckoutPageHeaderTextPresent(pageTitle), "HeaderText does not matched");

        Reporter.log("Step 10 : Enter the valid data in all the fields");
        checkoutYourInformation.enterTheValidData(checkout);

        Reporter.log("Step 11: Verify that firstname is present in field");
        String firstName = "Test";
        Assert.assertTrue(checkoutYourInformation.isFirstnamePresent(firstName), "data is not present");

        Reporter.log("Step 12: Click on Continue button");
        checkoutYourInformation.clickOnContinueButton();

        Reporter.log("Step 13: Verify that the user navigated back to 'Checkout:Overview' page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText does not matched");
    }
}
