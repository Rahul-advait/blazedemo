package PageClasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class Vacation extends BasePage {

    WebDriver driver;
    private String URL = "vacation";

    public Vacation(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return getUrl().contains(URL);
    }
}
