import driver.DriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SearchTests {
    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CheckoutPage checkoutPage;
    static String inputString;
    static Boolean expectedResult;

    @BeforeClass
    public static void initializeObject() {
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
    }

    public SearchTests(String inputString, Boolean expectedResult) {
        this.inputString = inputString;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection searchOptions() {
        return Arrays.asList(new Object[][]{
                {"Shirt", true},
                {"Blouse", true},
                {"Dress", true},
                {"", false},
                {"test", false}
        });
    }

    @Test
    public void testingSearch() {
        driver.get(Constants.URL);
        assertEquals(expectedResult, homePage.searchElement(inputString));
    }

    @AfterClass
    public static void closeObject() {
        driver.close();
    }


}
