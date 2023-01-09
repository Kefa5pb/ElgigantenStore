import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// SearchTest nasledjuje HamburgerMenuTest a on nasledjuje jer je BaseTest osnovna klasa za testiranje, u njoj se nalazi metoda za otvaranje drajvera
public class HamburgerMenuTest extends BaseTest{

    // Test
    @Test
    public void OpenAndCloseHamburgerMenu() throws InterruptedException {
        // Metod koji otvara Chrome drajver
        ChromeDriver driver = openChromeDriver();
        // Pozivanje konstruktora klase MenuPage preko koga kreiramo objekat kom pristupamo
        // menuPage je varijabla koja pokazuje na objekat klase MenuPage
        HamburgerMenuPage hamburgerMenuPage = new HamburgerMenuPage(driver);
        // poziv metode za otvaranje hamburger menija
        hamburgerMenuPage.openHamburgerMenu();
        // dohvatanje elementa sa prve sekcije menija koja ima text koji prosledjuemo
        WebElement element1 = hamburgerMenuPage.getMeniItem(Constants.section1Xpath, "Gaming");
        // dohvatanje elementa sa druge sekcije menija koja ima text koji prosledjuemo
        WebElement element2 = hamburgerMenuPage.getMeniItem(Constants.section2Xpath,"Spelkonsoler & Tillbehör");
        // dohvatanje elementa sa trece sekcije menija koja ima text koji prosledjuemo
        WebElement element3 = hamburgerMenuPage.getMeniItem(Constants.section3Xpath, "Retro gaming");
        // poziv metode preko koje se klikne na element trece sekcije
        element3.click();
        // pauziramo program na 3 sekunde dok se ucita stranica nakon klika
        Thread.sleep(3000);
        // Proveravamo da li smo dobili element na stranici nakon klika, time cemo proveriti da li je test validan
        assert driver.findElement(By.xpath("//h1[@class='cms-template-product-listing__headline--above-product-listing ng-star-inserted']")) != null : "Pronasao je Retro gaming";
        // metod na osnovu koga zatvaramo Chrome drajver
        driver.quit();
    }

}
