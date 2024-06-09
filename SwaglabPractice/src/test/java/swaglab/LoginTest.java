package swaglab;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.login.LoginPO;
import utilities.Constants;

public class LoginTest extends BaseTest {

    /*Test 1: Verify that user can login successfully */
    @Test
    public void verifyThatUserCanLoginSuccessfully() throws InterruptedException {
        LoginPO login = new LoginPO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Enter login credentials and click on login button");
        login.enterLoginData(Constants.UserName, Constants.Password);

        Reporter.log("Step 3 : Verify that user navigated to Home page");
        Assert.assertTrue(login.isHeaderTextPresent(), "HeaderText is not present");
    }

    /*Test 2: Verify that validation message is shown when user enters invalid data */
    @Test
    public void verifyTheValidationMessageIsShownWhenUserEntersInvalidData() throws InterruptedException {
        LoginPO login = new LoginPO(driver);

        Reporter.log("Step 1 : Navigate to URL");
        selenium.navigateToPage(Constants.URL);

        Reporter.log("Step 2: Enter invalid data in Username and Password Field");
        login.enterLoginData("Test", "User123");

        Reporter.log("Step 3: Verify that error message is displayed");
        Assert.assertTrue(login.isErrorTextPresent(), "error message is not displayed");

        Reporter.log("Step 4 : Click on cross button");
        login.clickOnCrossButton();

        Reporter.log("Step 5: Verify that no error message is displayed");
        Assert.assertFalse(login.isErrorTextPresent(), "no error message is displayed");
    }
}