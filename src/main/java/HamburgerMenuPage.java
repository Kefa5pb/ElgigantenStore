import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// MenuPage nasledjuje BasePage jer je BasePage osnovna klasa koja sadrzi osnovne metoge
public class HamburgerMenuPage extends BasePage {

    //Elementi hamburger menija
    @FindBy(xpath = "//button[@data-ta = 'categoryMenu-button__closed']")
    WebElement hamburgerMenuClosed;


    // Konstruktor sa jednim parametrom
    HamburgerMenuPage(ChromeDriver driver) {
        super(driver);
        print("Menu page, nalazi se na hamburger meniju");
        // Linijom ispod se ucitavaju svi web elementi koji su definisani u klasi
        PageFactory.initElements(driver,this);
    }

    // Metoda za otvaranje hamburger menija
    public void openHamburgerMenu(){
        waitForElement(hamburgerMenuClosed, 10);
        hamburgerMenuClosed.click();
    }

    // Metod koji ima dva parametra, xpath koji sadrzi putanju elementa u nasem slucaju sekcije i textItem koji predstavlja naziv na stavki menija
    // Metod vraca element koji nadje
    public WebElement getMeniItem(String xpath, String textItem) {
        // Lista elemenata koji se nalaze na sekciji u meniji
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        // Prolazak kroz listu elemenata i pronalazak trazenih elementa po tekstu koji se nalazi na njemu
        for (WebElement element: elements) {
            // If uslov ako postoji element sa tim tekstom da udje i uslov i da postavi kursor na taj element i da ga vrati
            if(element.getText().contains(textItem)) {
                print("Element je nadjen: " + textItem);
                // POstavlja kursor na element koji je pronadjen
                hoverOverElement(element);
                // Vraca pronadjeni element
                return element;
            }
        }
        // Vraca null - nista, ako nije pronasao element po tekstu
        return null;
    }
}
