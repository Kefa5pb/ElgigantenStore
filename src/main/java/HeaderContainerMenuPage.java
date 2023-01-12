import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderContainerMenuPage extends BasePage{
    //Element kontejner menija na header stranici, jedva sam ga nasao...
    @FindBy (xpath = "//elk-image-slider//elk-carousel[@class = 'carousel ng-star-inserted']//div[@class = 'carousel__scroll-container']//swiper[@class = 'swiper swiper-initialized swiper-horizontal swiper-pointer-events swiper-backface-hidden']//div[@class = 'swiper-wrapper']")
    WebElement headerContainerMenu;
    HeaderContainerMenuPage(ChromeDriver driver) {
        super(driver);
        print("Menu page, nalazi se na Kontejner meniju Header stranice");
    // Linijom ispod se ucitavaju svi web elementi koji su definisani u klasi
        PageFactory.initElements(driver,this);
    }
    // Metod koji ima dva parametra, xpath koji sadrzi putanju elementa u nasem slucaju sekcije i textItem koji predstavlja naziv na stavki menija
    // Metod vraca element koji nadje
    public WebElement getMeniItem(String textItem) {
    // Lista elemenata koji se nalaze na sekciji u meniji
    // Ovo je nacin dohvatanje liste menija preko elementa koji je definisan u klasi a to je HEADER CONTAINER MENU element
        List<WebElement> elements = headerContainerMenu.findElements(By.xpath("./div/elk-image-title-element/a"));
    // Prolazak kroz listu elemenata i pronalazak trazenih elementa po tekstu koji se nalazi na njemu
        for (WebElement element : elements) {
    // If uslov ako postoji element sa tim tekstom da udje i uslov i da postavi kursor na taj element i da ga vrati
            if (element.getText().contains(textItem)) {
                print("Element je nadjen: " + textItem);
    // Postavlja kursor na element koji je pronadjen
                hoverOverElement(element);
    // Vraca pronadjeni element
                return element;
            }
        }
    // Vraca null - nista ,ako nije pronasao element po tekstu
        return null;
    }
}
