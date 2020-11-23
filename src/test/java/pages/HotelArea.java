package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class HotelArea extends BasePage{
    public static String HOTELS_CSS = ".sr-hotel__name ";
    public static String RATE_PATH = "//*[contains(text(),'%s')]/ancestor::*[@class='sr_property_block_main_row']/descendant::*[@class='bui-review-score__badge']";

    public HotelArea isPageOpened() {
        $(HOTELS_CSS).waitUntil(Condition.visible, 10000);
        return this;
    }

    public ArrayList<String> hotelNameList() {
       return populateArrayWithValues($$(HOTELS_CSS));
    }

    public String hotelRateList(String hotelName) {
        return $(By.xpath(String.format(RATE_PATH, hotelName))).getText();
    }

    private ArrayList<String> populateArrayWithValues(ElementsCollection list) {
        ArrayList<String> hotelValues = new ArrayList<>();
        for (SelenideElement hotel : list) {
            hotelValues.add(hotel.getText());
        }
        return hotelValues;
    }

}
