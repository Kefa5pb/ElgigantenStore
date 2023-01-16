import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    // Web element
    @FindBy(xpath = "//button[@data-ta = 'login-button__loggedOut']")
    WebElement logInButton;

    // Konstruktori LoginPage stranice
    public LoginPage(ChromeDriver driver) throws InterruptedException {
        super(driver);
        print("Login Page");
        PageFactory.initElements(driver,this);
        print("Click on login button");
    }

    // Metoda za za otvaranje login stranice i klikanje
    public void openLogInPage(){
    waitForElement(logInButton, 5);
    logInButton.click();
    }

    // Metoda za upisivanje emaila i metoda  klikanje na login dugme
    public void login(String email) throws InterruptedException {
        Thread.sleep(5000);
        WebElement inputEmail = driver.findElement(By.xpath(Constants.logInMail));
        waitForElement(inputEmail,5);
        inputEmail.sendKeys(email);
        WebElement logInButton = driver.findElement(By.xpath(Constants.logInButton));
        waitForElement(logInButton,5);
        logInButton.click();
    }
}