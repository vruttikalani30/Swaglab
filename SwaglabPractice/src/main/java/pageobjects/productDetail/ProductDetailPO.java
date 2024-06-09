package pageobjects.productDetail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.base.BasePO;

public class ProductDetailPO extends BasePO {
    public ProductDetailPO(WebDriver driver) {
        super(driver);
    }
    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    /**
     * Is product price is present?
     *
     * @return true or false
     */
    public boolean isProductPricePresent(double price) {
        String xpath = "//*[text()='" + price + "']";
        return selenium.isElementPresent(By.xpath(xpath));

    }

    /**
     * Is product text is present?
     *
     * @return true or false
     */
    public boolean isProductTextPresent(String productName) {
        String xpath = "//div[contains(text(),'" + productName + "')]";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * Is backToProduct button present?
     *
     * @return true or false
     */
    public boolean isBackToProductButtonPresent(String buttonName) {
        String xpath = "//button[contains(text(),'" + buttonName + "')]";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * Click on BackToProduct Button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnBackToProductButton(String productButton) throws InterruptedException {
        String xpath = "//button[contains(text(),'" + productButton + "')]";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Is Header text present?
     *
     * @return true or false
     */
    public boolean isHeaderTextPresent(String textName) {
        String xpath = "//*[text()='" + textName + "']";
        return selenium.isElementPresent(By.xpath(xpath));
    }
}