import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("http://automationpractice.com");
        HomePage page = new HomePage();
        page.addFirstElementToCart();
        page.addSecondElementToCart();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.goToCheckout();
        SignInPage signInPage = new SignInPage();
        signInPage.LogIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWired();
        checkoutPage.confirmFinalOrder();
        if(checkoutPage.checkFinalStatus())
            System.out.println("TestCaseCompleted");

        driver.quit();

    }
}
