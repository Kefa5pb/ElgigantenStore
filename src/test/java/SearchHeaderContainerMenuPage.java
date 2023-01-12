import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchHeaderContainerMenuPage extends BaseTest {

    /**
     * Find "Vitvaror" elements using Header Container Menu.
     * 1.Navigate to Home page
     * 2.On the Header Container Page click on "Vitvaror" element
     * expected result: Vitvaror elements is shown.
     */
    @Test
    public void SearchHeaderContainerMenu() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        try {
            HeaderContainerMenuPage headerContainerMenuPage = new HeaderContainerMenuPage(driver);
            Thread.sleep(3000);
            WebElement container = headerContainerMenuPage.getMeniItem("VITVAROR");
            print("Pronasao je element " + container.getText());
            container.click();
            Thread.sleep(3000);
            assert driver.findElement(By.xpath("//h1[@class = 'hero-text__headline first-headline ng-star-inserted']")) != null : "Element je prikazan";
        }finally {
        driver.quit();
        }
    }
}