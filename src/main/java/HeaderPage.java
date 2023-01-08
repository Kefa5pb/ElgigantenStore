import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Header stranica naslodjuje Base page, jer nam je BasePage osnovna klasa koja sadrzi osnovne metode
public class HeaderPage extends BasePage {

    // web elementi
    @FindBy(xpath = "//input[@id = 'query-header']")
    WebElement searchInputLocator;

    @FindBy(xpath = "//button[@data-ta = 'productSearch-button-header']")
    WebElement searchButton;

    @FindBy(xpath = "//button[@data-ta = 'login-button__loggedOut']")
    WebElement loginButton;

    @FindBy(xpath = "//button[@data-ta = 'miniCart-button']")
    WebElement miniCartButton;

    // Konstruktor koji ima jedan parametar
    HeaderPage(ChromeDriver driver){
        // super znaci da se nadklasi prosledjuje drajver jer to zahteva konstruktor nadkalse
        super(driver);
        print("Home page");
        // Drajver se cuva u ovoj klasi jer nam je potreban za pristup elementima
        super.driver = driver;
        // Linijom ispod se ucitavaju svi web elementi koji su definisani u klasi
        PageFactory.initElements(driver, this);
    }

    // Metoda preko koje cemo da kliknemo na search polje i da unesemo text
    public void searchText(String text){
        print("Click and insert text: " + "text");
        // Poziv metode preko koje pronadjemo element i sacekamo 2 sekunde
        waitForElement(searchInputLocator, 2);
        // klik na search polje
        searchInputLocator.click();
        // Poziv metode preko koje pronadjemo element i sacekamo 2 sekunde
        waitForElement(searchInputLocator, 2);
        // Poziv metode preko koje unosimo tekst u search polje
        searchInputLocator.sendKeys(text);
        // klik na lupicu
        searchButton.click();
    }
}
