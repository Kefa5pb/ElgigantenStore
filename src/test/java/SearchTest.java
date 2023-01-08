import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// SearchTest nasledjuje BaseTest jer je BaseTest osnovna klasa za testiranje, u njoj se nalazi metoda za otvaranje drajvera
public class SearchTest extends BaseTest {

    // Search test metod koja vraca rezultat pretrage
    // InterruptedException je izuzetak ako nemoze da pauzira pauzu od 3000ms i tu je zbog thread.sleep!!!
    @Test
    public void search() throws InterruptedException {
        // Metod koji otvara Chrome drajver
        ChromeDriver driver = openChromeDriver();

        // Pozivanje konstruktora klase HeaderPage preko koga kreiramo objekat kom pristupamo
        // headerPage je varijabla koja pokazuje na objekat klase HeaderPage
        HeaderPage headerPage = new HeaderPage(driver);

        // poziv metode koja pretrazuje tekst koji smo prosledili
        headerPage.searchText("Samsung");
        Thread.sleep(10000);
        assert driver.findElement(By.xpath("//h1[@class='cms-template-product-listing__headline--above-product-listing ng-star-inserted']")) != null : "Pronasao je Samsung";
        driver.quit();
    }

    @Test
    public void findArticle() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        HeaderPage headerPage = new  HeaderPage(driver);
        headerPage.searchText("Harman");
        Thread.sleep(10000);
        WebElement article = headerPage.getArticle(Constants.articleXpath,5);
        article.click();
        Thread.sleep(10000);
        assert driver.findElement(By.xpath("//h1[@data-ta = 'productname-text']")) != null: "Prikazan je 5. artikal";
        driver.quit();
    }


    @Test
    public void addToCardAfterSearch() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        HeaderPage headerPage = new  HeaderPage(driver);
        headerPage.searchText("Harman");
        Thread.sleep(10000);
        WebElement article = headerPage.getArticle(Constants.articleXpath,5);
        article.click();
        Thread.sleep(10000);
        WebElement addToCartButton = driver.findElement(By.xpath(Constants.addToCartButtonXpath));
        Thread.sleep(15000);
        addToCartButton.click();

    }
}
