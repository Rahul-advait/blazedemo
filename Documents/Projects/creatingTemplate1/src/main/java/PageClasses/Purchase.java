package PageClasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

public class Purchase extends BasePage {
    WebDriver driver;
    private String TOTAL_COST = "xpath=>//div[@class='container']/p[5]";
    private String URL = "purchase";
    private String PRICE = "cssSelector=>em";

    public Purchase(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen() {
        return isOpen(URL);
    }

    public boolean isTotalCostPresent() {

        boolean isCost = isDisplayed(TOTAL_COST, "Total Cost");
        boolean isFormatCorrect = checkFormat(PRICE, "Price");
        return isCost && isFormatCorrect;
    }

    private boolean checkFormat(String locator, String info) {
        String pattern = "\\d{3}\\.\\d{2}";
        String costValue = getElement(PRICE, info).getText();
        return Pattern.matches(pattern, costValue);
    }
}
