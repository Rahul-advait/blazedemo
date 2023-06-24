package PageClasses;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public WebDriver driver;
    private String DESTINATION_LINK = "destination of the week! The Beach!";
    private String DEST_CITY = "fromPort";
    private String DEP_CITY = "toPort";
    private String FIND_FLIGHT_BTN = "input";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Vacation clickDestinationLink() {
        driver.findElement(By.linkText(DESTINATION_LINK)).click();
        return new Vacation(driver);
    }

    public void selectDepartureCity(String city){
        WebElement element = driver.findElement(By.name(DEST_CITY));
        element.click();

        Select select = new Select(element);
        waitForElement(By.name(DEST_CITY));
        select.selectByValue(city);
    }

    public void selectDestinationCity(String city){
        WebElement element = driver.findElement(By.name(DEP_CITY));
        element.click();

        Select select = new Select(element);
        waitForElement(By.name(DEP_CITY));
        select.selectByValue(city);
    }

    public Reserve clickFindFlights(){
        System.out.println("hello");
        WebElement element = driver.findElement(By.cssSelector(FIND_FLIGHT_BTN));
        waitForElementToClickable(By.cssSelector(FIND_FLIGHT_BTN));

        element.click();
        return new Reserve(driver);
    }
}
