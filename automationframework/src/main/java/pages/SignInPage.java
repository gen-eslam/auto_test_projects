package pages;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;


    public SignInPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;
    @FindBy(id = "email_create")
    private WebElement emailSingUpField;
    @FindBy(id = "SubmitCreate")
    private WebElement signUpButton;

    public void LogIn(String email,String passwd){
        emailField.sendKeys(email);
        password.sendKeys(passwd);
        signInButton.click();
    }
    public void SignUp(String email){
        emailSingUpField.sendKeys(email);
        signUpButton.click();
    }

}
