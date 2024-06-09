package pageobjects.checkoutyourinformation;

import dataobjects.CheckoutYourInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class CheckoutYourInformationPO extends BasePO {
    public CheckoutYourInformationPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    @FindBy(css = ".error-button")
    private WebElement crossButton;

    @FindBy(css = ".error-message-container error")
    private WebElement errorMessageContainer;

    @FindBy(xpath = "//div[@class='shopping_cart_container']//descendant::a")
    private WebElement yourCartIcon;

    @FindBy(xpath = "//div[@class='form_group'][1]//child::input")
    private WebElement firstnameField;

    @FindBy(xpath = "//div[@class='form_group'][2]//child::input")
    private WebElement lastnameField;

    @FindBy(xpath = "//div[@class='form_group'][3]//child::input")
    private WebElement zipcodeField;


    /**
     * Enter the data in Fields
     *
     * @param checkoutData test
     */
    public void enterTheValidData(CheckoutYourInformation checkoutData) {
        selenium.enterText(firstnameField, checkoutData.getFirstname(), true);
        selenium.enterText(lastnameField, checkoutData.getLastname(), true);
        selenium.enterText(zipcodeField, checkoutData.getZipcode(), true);
    }

    /**
     * Enter the data in firstname & zipcode Field
     *
     * @param checkoutData test
     */
    public void enterTheFirstNameAndZipCode(CheckoutYourInformation checkoutData) {
        selenium.enterText(firstnameField, checkoutData.getFirstname(), true);
        selenium.enterText(zipcodeField, checkoutData.getZipcode(), true);
    }

    /**
     * Click on Finish Button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnFinishButton(String finishButton) throws InterruptedException {
        String xpath = "//*[text()='" + finishButton + "']";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Click on Checkout Button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnCheckoutButton(String checkoutButton) throws InterruptedException {
        String xpath = "//*[text()='" + checkoutButton + "']";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Click on cancel Button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnCancelButton(String cancelButton) throws InterruptedException {
        String xpath = "//*[text()='" + cancelButton + "']";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Is validation message present
     *
     * @return true of false
     */
    public boolean isValidationMessagePresent(String errorText) {
        String Xpath = "//*[text()='" + errorText + "']";
        return selenium.isElementPresent(By.xpath(Xpath));
    }

    /**
     * Is  first name present?
     *
     * @return true or false
     */
    public boolean isFirstnamePresent(String firstName) {
        String xpath = "//input[@value='" + firstName + "']";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * Click on BackHome Button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnBackHomeButton() throws InterruptedException {
        selenium.clickOn(backHomeButton);
    }

    /**
     * Click on yourCart Icon
     *
     * @throws InterruptedException Exception
     */
    public void clickOnYourCartIcon() throws InterruptedException {
        selenium.clickOn(yourCartIcon);
    }

    /**
     * Click on Continue Icon
     *
     * @throws InterruptedException Exception
     */
    public void clickOnContinueButton() throws InterruptedException {
        selenium.clickOn(continueButton);
    }
}
