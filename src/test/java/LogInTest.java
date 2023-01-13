import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogInTest  extends BaseTest{

    @Test
    public void logInTest() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openLogInPage();
            loginPage.login("kefa5_pb@hotmail.com");
            Thread.sleep(8000);
            assert driver.findElement(By.xpath("//a[@href = '#']")) != null : "Prikazano je dugme za slanje koda za logovanje";
            driver.quit();
    }
}