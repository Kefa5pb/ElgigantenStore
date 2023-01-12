import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//button[@data-ta = 'login-button__loggedOut']")
    WebElement logInButton;


    public LoginPage(ChromeDriver driver) {
        super(driver);
        print("Login Page");
        PageFactory.initElements(driver,this);
        print("Click on login button");
        logInButton.click();
    }
}
