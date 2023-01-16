import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

    // SearchTests nasledjuje BaseTest jer je BaseTest osnovna klasa za testiranje, u njoj se nalazi metoda za otvaranje drajvera
public class SearchTests extends BaseTest {

        /**
         * In search type in "Samsung" text and show offer.
         * Steps:
         * 1.Navigate to Home page
         * 2.In search field type "Samsung" text
         * 3.Click on search
         * expected result is Samsung offer
         */
    // Search test metod koja vraca rezultat pretrage
    // InterruptedException je izuzetak ako nemoze da pauzira pauzu od 3000ms i tu je zbog thread.sleep!!!
    @Test
    public void search() throws InterruptedException {
    // Metod koji otvara Chrome drajver
        ChromeDriver driver = openChromeDriver();
    // Pozivanje konstruktora klase HeaderPage preko koga kreiramo objekat kom pristupamo
    // HeaderPage je varijabla koja pokazuje na objekat klase HeaderPage
        HeaderPage headerPage = new HeaderPage(driver);
    // Poziv metode koja pretrazuje tekst koji smo prosledili
        headerPage.searchText("Samsung");
        Thread.sleep(10000);
        assert driver.findElement(By.xpath("//h1[@class='cms-template-product-listing__headline--above-product-listing ng-star-inserted']")) != null : "Pronasao je Samsung";
        driver.quit();
    }

        /**
         * Find Article "Harman" in Search field and click on 5. element in "Harman" offer.
         * Steps:
         * 1.Navigate to Home page
         * 2.Type in "Harman" in search field
         * 3.Click on search
         * 4.Go to fifth element in offer field and click.
         * expected result: fifth element is shown.*
         */
    @Test
    public void findArticle() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        HeaderPage headerPage = new  HeaderPage(driver);
        Thread.sleep(3000);
        headerPage.searchText("Harman");
        Thread.sleep(5000);
        int ordinalNumber = 2;
        WebElement article = headerPage.getArticle(Constants.articleXpath,ordinalNumber);
        article.click();
        Thread.sleep(5000);
        assert driver.findElement(By.xpath("//h1[@data-ta = productname-text]")) != null: "Prikazan je  artikal " + ordinalNumber;
        driver.quit();
    }

        /**
         * Adding Article to the Chart using searh menu.
         * Steps:
         * 1.Navigate to Home page
         * 2.Type in "Harman" in the search field
         * 3.Click on search
         * 4.Go to fifth element in offer field and click
         * 5.Add to Chart
         * expected result: the fifth article is in the chart.
         */
    @Test
    public void addToChartAfterSearch() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        try {
            HeaderPage headerPage = new HeaderPage(driver);
            Thread.sleep(5000);
            headerPage.searchText("HARMAN");
            Thread.sleep(5000);
            WebElement article = headerPage.getArticle(Constants.articleXpath, 5);
            article.click();
            Thread.sleep(5000);
    // To je dugme za dodavanje u korpu
            WebElement addToChartButton = driver.findElement(By.xpath(Constants.addToCartButtonXpath));
    // Metoda za skrolovanje do add to cart dugmeta, bez ovoga nije moglo da pronadje element na stranici
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToChartButton);
            Thread.sleep(3000);
            addToChartButton.click();
            Thread.sleep(5000);
    // Ovo je dugme za zatvaranje extra popUp prozora pri dodavanju u korpu
            WebElement closeButtonExtraPopUp = driver.findElement(By.xpath(Constants.closeButtonExtraPopUp));
            closeButtonExtraPopUp.click();
            assert driver.findElement(By.xpath("//span[@class = 'minicart-button__quantity']")) != null : "Prikazan je broj artikala u korpi";
        }finally {
            driver.quit();
        }
    }
}