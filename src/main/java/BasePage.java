import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    // Web elementi
    @FindBy(xpath = "//a[@class = 'logo__link kps-link']")
    WebElement logoLink;
    @FindBy(xpath = "//button[@class = 'coi-banner__accept']")
    WebElement cookieAcceptButton;
    // Varijabla drajvera
    ChromeDriver driver;
    // Konstruktor BasePage klase
    public BasePage(ChromeDriver driver) {
        print("Base page");
    // drajver se cuva u ovoj klasi da bi se mogao koristiti za pristupanje elementima na stranici
        this.driver = driver;
    // Svi web elemnti koje smo dodali u ovo klasi se ovom linijom ispod ucitavaju
        PageFactory.initElements(driver, this);
    // pozivamo metodu koja ce da prihvati cookies
        clickAcceptInCookie();
    }
    // Metod koji nam sluzi za prihvatanje cookies - kolacica na stranici
    public void clickAcceptInCookie() {
        print("Accept cookies ");
        // Metod koji pronalazi element preko kursora, u ovom slucaju da bi se prikazao prozor za cookies
        hoverOverElement(logoLink);
        // metod za cekanje elementa 5 sekundi
        waitForElement(cookieAcceptButton, 8);
        // pozivanje metode za klik na dugme
        print("Click on Cookie Accept");
        cookieAcceptButton.click();

    }
    // Metod preko kog dolazimo do elementa koji je prosledjen sa kursorom
    public void hoverOverElement(WebElement element) {
        print("Hover over Element");
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    // Metoda koja nam sluzi da se pronadje element na stranici i da saceka za vreme koje je proslidjeno
    public void waitForElement(WebElement element, int time){
        print("Wait element: " + element.getText());
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    // Metoda za nalezenje nekog u listi po rednom broju
    public WebElement getArticle(String xpath, int ordinalNumber){
        print("Get article metoda");
        print("xpath: " + xpath + ",ordinal number = " + ordinalNumber);
        List<WebElement> webElements = driver.findElements(By.xpath(xpath));
        return webElements.get(ordinalNumber - 1);
    }
    // Metod za prikaz testa u konzoli
    public void print(String text) {
        System.out.println(text);
    }
}
