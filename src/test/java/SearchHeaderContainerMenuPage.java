import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchHeaderContainerMenuPage extends BaseTest {

    @Test

    public void SearchHeaderContainerMenu()  {
        ChromeDriver driver = openChromeDriver();

        HeaderContainerMenuPage headerContainerMenuPage = new HeaderContainerMenuPage(driver);

        WebElement containermenu = headerContainerMenuPage.getMeniItem("VITVAROR");

        containermenu.click();
    }

}
