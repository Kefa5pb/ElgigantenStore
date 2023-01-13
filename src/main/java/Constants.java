
    // Interfejs sluzi za ispisivanje konstanti i odredjenih metoda.
    // Nad interfejsom se ne moze kreirati objekat
    public interface Constants {

    // Konstanta za home url sajta koji se testira
    String HOME_URL = "https://www.elgiganten.se/";

    // Konstanta koja predstavlja xpath prve sekcije hamburger menija
    String section1Xpath = "//section[@id = 'CRO70section01']/ul[@class='is-open']//a";

    // Konstanta koja predstavlja xpath druge sekcije hamburger menija
    String section2Xpath = "//section[@id = 'CRO70section02']/ul[@class='is-open']//a";

    // Konstanta koja predstavlja xpath trece sekcije hamburger menija
    String section3Xpath = "//section[@id = 'CRO70section03']/ul[@class='is-open']//a";

    // Konstanta koja predstavlja xpath liste artikala u search
    String articleXpath = "//a[@class='product-tile__link kps-link']";

    // Konstanta za dugme koje dodaje artikal u korpu
    String addToCartButtonXpath = "//button[@elk-ta='addToCart-button']";

    // Konstanta za kontejner menu na header stranici
    String headerContainerMenu = "//div[@style = 'transition-duration: 0ms; transform: translate3d(80px, 0px, 0px);']//a";

    //Konstanta za zatvaranje extra popup prozora pri dodavanju proizvoda u korpu
    String closeButtonExtraPopUp = "//button[@class='close-button extra-popup__close-btn']";

    // Konstanta za potrosacku korpu, DUGME
    String shopingCartButton = "//button[@data-ta = 'miniCart-button']";

    //Konstanta za upisivanje maila kod logovanja
        String logInMail = "//input[@data-ta = 'loginEmail-input']";


    // Konstanta za click kod logovanja
        String logInButton = "//button[@data-ta = 'login-button']";

    // Konstanta za dugme za slanje koda na mail kod logovanja
        String sendCodeButton = "//button[@id = 'email_ver_but_send']";
}