package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BookingPage;
import pages.HotelArea;

public class BookingSteps{
    String location;
    String hotelName;
    BookingPage bookingPage;
    HotelArea hotelArea;

    @Before
    public void init() {
        bookingPage = new BookingPage();
        hotelArea = new HotelArea();
    }

    @Given("User is looking for hotel in city {string}")
    public void userIsLookingForHotelInCity(String location) {
        this.location = location;
    }

    @When("User does search")
    public void userDoesSearch() {
        bookingPage
                .openPage()
                .isPageOpened()
                .search(location);
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelShouldBeOnTheFirstPage(String expectedName) {
        hotelName = expectedName;
        Assert.assertTrue(hotelArea.
                isPageOpened()
                .hotelNameList()
                .contains(expectedName));
    }

    @And("Rating of the hotel is {string}")
    public void ratingOfTheHotelIs(String expectedRate) {
        Assert.assertTrue(hotelArea
                .isPageOpened()
                .hotelRateList(hotelName).equals(expectedRate));
    }

}
