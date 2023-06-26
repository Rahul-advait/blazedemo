package PageClasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public WebDriver driver;
    private final String DESTINATION_LINK = "linkText=>destination of the week! The Beach!";
    private String DEST_CITY = "name=>toPort";
    private String DEP_CITY = "name=>fromPort";
    private String FIND_FLIGHT_BTN = "cssSelector=>input";

    public WebElement getDESTINATION_LINK() {
        return getElement(DESTINATION_LINK, "DESTINATION_LINK");
    }

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Vacation clickDestinationLink() {
        elementClick(DESTINATION_LINK, "DESTINATION_LINK");
        return new Vacation(driver);
    }

    public void selectDepartureCity(String city) {
        elementClick(DEP_CITY, "DEP_CITY");
        dropdwnSelect(DEP_CITY, "DEP_CITY", city);
    }

    public void selectDestinationCity(String city) {
        elementClick(DEST_CITY, "DEST_CITY");
        dropdwnSelect(DEST_CITY, "DEST_CITY", city);
    }

    public Reserve clickFindFlights() {
        waitClick(FIND_FLIGHT_BTN, "FIND_FLIGHT_BTN");
        return new Reserve(driver);
    }
}
