package datafactory;

import dataobjects.CheckoutYourInformation;
public class CheckoutYourInformationData {
    public CheckoutYourInformation checkoutInformationData() {

        CheckoutYourInformation checkoutYourInformation = new CheckoutYourInformation();
        checkoutYourInformation.setFirstname("Test");
        checkoutYourInformation.setLastname("User");
        checkoutYourInformation.setZipcode("123546");
        return checkoutYourInformation;
    }
}