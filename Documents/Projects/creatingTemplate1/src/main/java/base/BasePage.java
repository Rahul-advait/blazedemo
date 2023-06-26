package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends CustomDriver {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

//    public void waitForElement(By element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(element));
//
//    }

    public void waitForElementToClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void dropdwnSelect(String locator, String info, String city) {
        WebElement element = getElement(locator, info);
        Select select = new Select(element);
        waitForElement(element, info);
        select.selectByValue(city);
    }

    public boolean isOpen(String URL){
        return driver.getCurrentUrl().contains(URL);
    }

}
