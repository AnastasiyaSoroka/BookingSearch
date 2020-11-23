package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BookingPage extends BasePage {

    public static final String URL = "https://www.booking.com/searchresults.en-gb.html";

    public static String SEARCH_BTN = ".sb-searchbox__button ";
    public static By SEARCH_INPUT = By.id("ss");

    public BookingPage search(String location) {
        $(SEARCH_INPUT).sendKeys(location);
        $(SEARCH_INPUT).click();
        $(SEARCH_BTN).click();
        return this;
    }

    public BookingPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public BookingPage isPageOpened() {
        $(SEARCH_BTN).waitUntil(Condition.visible, 10000);
        return this;
    }

}
