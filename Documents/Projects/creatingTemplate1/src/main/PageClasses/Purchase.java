package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Purchase {
    WebDriver driver;
    private String TOTAL_COST = "em";

    public Purchase(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen(){
        return driver.getCurrentUrl().contains("purchase");
    }

    public boolean isTotalCostPresent(){
        WebElement element = driver.findElement(By.cssSelector(TOTAL_COST));
        return element.isDisplayed();
    }
}
