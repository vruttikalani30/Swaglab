package pageobjects.checkoutoverview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class CheckoutOverviewPO extends BasePO {
    public CheckoutOverviewPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement itemTotalPrice;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement tax;


    /**
     * Get product price
     *
     * @return product price
     */
    public double getProductPrice(double price) {
        String Xpath = "//*[text()='" + price + "']//parent::div[@class='inventory_item_price']";
        String priceWithDollar = selenium.getText(By.xpath(Xpath));
        String priceWithoutDollar = priceWithDollar.replace("$", "");
        double productPrice = Double.parseDouble(priceWithoutDollar);
        return productPrice;
    }

    /**
     * Get item total price
     *
     * @return item total price
     */
    public double getItemTotalPrice() {
        String priceWithDollar = selenium.getText(itemTotalPrice);
        String priceWithoutDollar = priceWithDollar.replace("Item total: $", "");
        double price = Double.parseDouble(priceWithoutDollar);
        return price;
    }

    /**
     * Get tax
     *
     * @return tax
     */
    public double getTax() {
        String priceWithDollar = selenium.getText(tax);
        selenium.waitTillElementIsVisible(tax);
        String priceWithoutDollar = priceWithDollar.replace("Tax: $", "");
        double tax = Double.parseDouble(priceWithoutDollar);
        return tax;

    }

    /**
     * Get actual total price
     *
     * @return total price
     */
    public double getActualTotalPrice() {
        double price = getItemTotalPrice() + getTax();
        return price;
    }

    /**
     * Get expected total price
     *
     * @return total price
     */
    public double getExpectedTotalPrice(double finalTotal) {
        String Xpath = "//*[text()='" + finalTotal + "']//parent::div[@class='summary_total_label']";
        String priceWithDollar = selenium.getText(By.xpath(Xpath));
        String priceWithoutDollar = priceWithDollar.replace("Total: $", "");
        double price = Double.parseDouble(priceWithoutDollar);
        return price;
    }
}



