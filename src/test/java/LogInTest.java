import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogInTest  extends BaseTest{

    /**
     * Log in on Elgiganten page
     * 1. Navigate to Home page
     * 2. Click on Login button
     * 3. Type in text in email field
     * 4. Click on förtsätt button
     * expected result: "Tillbaka till inloggning" button is shown.
     */
    @Test
    public void logInTest() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openLogInPage();
            loginPage.login("kefa5_pb@hotmail.com");
            Thread.sleep(8000);
            assert driver.findElement(By.xpath("//a[@href = '#']")) != null : "Prikazan je link za povratak na Home page";
            driver.quit();
    }
}