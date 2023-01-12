import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogInTest  extends BaseTest{

    @Test
    public void logInTest(){
        ChromeDriver driver = openChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

    }

}
