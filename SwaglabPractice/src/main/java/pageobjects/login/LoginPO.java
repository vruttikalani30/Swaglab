package pageobjects.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class LoginPO extends BasePO {
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(id = "user-name")
    private WebElement usernameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(@d,'M242')]")
    private WebElement crossButton;

    @FindBy(xpath = "//div[@class='error-message-container']")
    private WebElement errorBox;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement headerText;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement errorText;

    /**
     * Enter the login data
     *
     * @param username username
     * @param password password
     * @throws InterruptedException Exception
     */
    public void enterLoginData(String username, String password) throws InterruptedException {
        selenium.enterText(usernameTextBox, username, true);
        selenium.enterText(passwordTextBox, password, true);
        selenium.clickOn(loginButton);
    }

    /**
     * Click on cross button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnCrossButton() throws InterruptedException {
        selenium.clickOn(crossButton);
    }

    /**
     * Is headerText present?
     *
     * @return true or false
     */
    public boolean isHeaderTextPresent() {
        return selenium.isElementPresent(headerText);
    }

    /**
     * Is errorText present?
     *
     * @return true or false
     */
    public boolean isErrorTextPresent() {
        return selenium.isElementPresent(errorText);
    }
}