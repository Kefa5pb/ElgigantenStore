import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogInTest  extends BaseTest{

    @Test
    public void logInTest() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openLogInPage();
            loginPage.login("kefa5_pb@hotmail.com");
            assert driver.findElement(By.xpath("//button[@id = 'email_ver_but_send']")) != null : "Prikazano je dugme za slanje koda za logovanje";
        }finally {
            driver.quit();
        }
    }
}