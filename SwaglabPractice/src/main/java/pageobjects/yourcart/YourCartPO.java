package pageobjects.yourcart;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class YourCartPO extends BasePO {
    public YourCartPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='shopping_cart_container']//descendant::a")
    private WebElement yourCartIcon;

    @FindBy(xpath = "//div[@class='inventory_item'][2]//preceding::button[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@id='continue-shopping']//following-sibling::button")
    private WebElement checkoutButton;

    @FindBy(xpath = "//span[text()='Your Cart']")
    private WebElement headerText;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    /**
     * Is checkout button present?
     *
     * @return true or false
     */
    public boolean isCheckoutButtonPresent(String CheckoutButton) {
        String xpath = "//*[text()='" + CheckoutButton + "']";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * is checkout page header text present?
     *
     * @return true or false
     */
    public boolean isCheckoutPageHeaderTextPresent(String headerText) {
        String xpath = "//*[text()='" + headerText + "']";
        return selenium.isElementPresent(By.xpath(xpath));
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
     * Click on Checkout Button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnCheckoutButton() throws InterruptedException {
        selenium.clickOn(checkoutButton);
    }

    /**
     * Get header text
     *
     * @return header text
     */

    public String getTheHeaderText() {
        return selenium.getText(headerText);
    }

    /**
     * Get badge count
     *
     * @return badge count
     */
    public String getTheBadgeCount() {
        return selenium.getText(cartIcon);
    }
}
