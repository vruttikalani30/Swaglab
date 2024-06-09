package pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

import java.util.ArrayList;
import java.util.List;

public class HomePagePO extends BasePO {
    public HomePagePO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */
    @FindBy(id = "react-burger-menu-btn")
    private WebElement moreMenu;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsOption;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutOption;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutOption;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateOption;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h1[@class='supertitle ']")
    private WebElement headerText;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement filterButton;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(css = ".shopping_cart_link")
    private WebElement emptyCartBadge;

    @FindBy(xpath = "//h1[@class='authwall-join-form__title']")
    private WebElement linkedinHeaderText;

    /**
     * Is Footer button present?
     *
     * @return true or false
     */
    public boolean isFooterButtonPresent(String footerButton) {
        String xpath = "//a[text()='" + footerButton + "']";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * Click on Footer Button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnFooterButton(String footerButton) throws InterruptedException {
        String xpath = "//a[contains(text(),'" + footerButton + "')]";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * is count present?
     *
     * @return true or false
     */
    public Boolean isCountPresent(String count) {
        String xpath = "//span[contains(text(),'" + count + "')]";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * click on AddToCart button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnAddToCartButton(String headerText) throws InterruptedException {
        String xpath = "//button[contains(text(),'" + headerText + "')]";
        selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Click on All cart Button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnAllCartButton(String[] button) throws InterruptedException {
        List<String> cart = new ArrayList<>(List.of(button));
        for (String cartButton : cart) {
            String xpath = "//div[contains(text(),'" + cartButton + "')]//parent::a//parent::div//following-sibling::div[@class='pricebar']//button";
            selenium.clickOn(By.xpath(xpath));
        }
    }

    /**
     * Is All Product present?
     *
     * @return true of false
     */
    public boolean isAllProductPresent(String[] productName) {
        List<String> products = new ArrayList<>(List.of(productName));
        for (String product : products) {
            String xpath = "//*[text()='" + product + "']";
            selenium.isElementPresent(By.xpath(xpath));
        }
        return true;
    }

    /**
     * is product present?
     *
     * @return true or false
     */
    public Boolean isProductPresent(String productName) {
        String xpath = "//div[contains(text(),'" + productName + "')]";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * is product price present
     *
     * @return product price
     */
    public boolean isProductPricePresent(String productPrice) {
        String xpath = "//*[text()='" + productPrice + "']";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * Is filter text present?
     *
     * @return true or false
     */
    public boolean isFilterTextPresent(String nameAtoZ) {
        String xpath = "//span[contains(text(),'" + nameAtoZ + "')]";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * Click on Z to A Filter Button
     *
     * @throws InterruptedException Exception
     * @Param NAME Z TO A
     */
    public void clickOnZtoAFilterButton(String nameZTOA) throws InterruptedException {
        selenium.clickOn(filterButton);
        selenium.selectDropDownValueByText(filterButton, nameZTOA);
    }

    /**
     * Click on Price low to high Filter Button
     *
     * @throws InterruptedException Exception
     * @Param Price low to high
     */
    public void clickOnPriceLowTohHighFilterButton(String priceLowToHigh) throws InterruptedException {
        selenium.clickOn(filterButton);
        selenium.selectDropDownValueByText(filterButton, priceLowToHigh);
    }

    /**
     * Click on Price high to low Filter Button
     *
     * @throws InterruptedException Exception
     * @Param Price high to low
     */
    public void clickOnPriceHighToLowFilterButton(String priceHighToLow) throws InterruptedException {
        selenium.clickOn(filterButton);
        selenium.selectDropDownValueByText(filterButton, priceHighToLow);
    }

    /**
     * is linkedin headerText present?
     *
     * @return true or false
     */
    public Boolean isLinkedinHeaderTextPresent() {
        return selenium.isElementPresent(linkedinHeaderText);
    }


    /**
     * Click on MoreMenu options
     *
     * @throws InterruptedException Exception
     */
    public void clickOnMoreMenuOptions() throws InterruptedException {
        selenium.clickOn(moreMenu);
    }

    /**
     * Is more menu icon present?
     *
     * @return true or false
     */
    public boolean isMoreMenuIconPresent() {
        return selenium.isElementPresent(moreMenu);
    }

    /**
     * Click on AllItems Option
     *
     * @throws InterruptedException Exception
     */
    public void clickOnAllItemsOption() throws InterruptedException {
        selenium.clickOn(allItemsOption);
    }

    /**
     * Is  AllItems option present?
     *
     * @return true or false
     */
    public boolean isAllItemsOptionPresent() {
        return selenium.isElementPresent(allItemsOption);
    }

    /**
     * Click on about Option
     *
     * @throws InterruptedException Exception
     */
    public void clickOnAboutOption() throws InterruptedException {
        selenium.clickOn(aboutOption);
    }

    /**
     * Is About option present?
     *
     * @return true or false
     */
    public boolean isAboutOptionPresent() {
        return selenium.isElementPresent(aboutOption);
    }

    /**
     * Is about page header text present?
     *
     * @return true or false
     */
    public boolean isAboutPageHeaderTextPresent() {
        return selenium.isElementPresent(headerText);
    }

    /**
     * Click on logout Option
     *
     * @throws InterruptedException Exception
     */
    public void clickOnLogoutOption() throws InterruptedException {
        selenium.clickOn(logoutOption);
    }

    /**
     * Is  Logout option present?
     *
     * @return true or false
     */
    public boolean isLogoutOptionPresent() {
        return selenium.isElementPresent(logoutOption);
    }

    /**
     * Click on resetAppStateOption
     *
     * @throws InterruptedException Exception
     */
    public void clickOnResetAppStateOption() throws InterruptedException {
        selenium.clickOn(resetAppStateOption);
    }

    /**
     * Is  resetAppState option present?
     *
     * @return true or false
     */
    public boolean isResetAppStatePresent() {
        return selenium.isElementPresent(resetAppStateOption);
    }

    /**
     * Click on Continue Shopping button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnContinueShoppingButton() throws InterruptedException {
        selenium.clickOn(continueShoppingButton);
    }

    /**
     * Is  Filter button present?
     *
     * @return true or false
     */
    public boolean isFilterButtonPresent() {
        return selenium.isElementPresent(filterButton);
    }

    /**
     * Click on product
     *
     * @throws InterruptedException Exception
     */
    public String clickOnTheProduct(String productName) throws InterruptedException {
        String xpath = "//a[@href='#']//div[contains(text(),'" + productName + "')]";
        return selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Click on Remove Button
     *
     * @throws InterruptedException Exception
     */
    public String clickOnRemoveButton(String removeButton) throws InterruptedException {
        String xpath = "//*[text()='" + removeButton + "']";
        return selenium.clickOn(By.xpath(xpath));
    }

    /**
     * Is product present?
     *
     * @return true or false
     */
    public boolean isCartItemPresent(String productPresent) {
        String xpath = "//*[text()='" + productPresent + "']";
        return selenium.isElementPresent(By.xpath(xpath));
    }

    /**
     * Get badge count
     *
     * @return badge count
     */

    public int getBadgeCount() {
        return Integer.parseInt(selenium.getText(shoppingCartBadge));
    }

    /**
     * Is badge present?
     *
     * @return true or false
     */
    public boolean isBadgePresent() {
        return selenium.isElementPresent(emptyCartBadge);
    }

    /**
     * Is Login button present?
     *
     * @return true or false
     */
    public boolean isLoginButtonPresent() {
        return selenium.isElementPresent(loginButton);
    }
}