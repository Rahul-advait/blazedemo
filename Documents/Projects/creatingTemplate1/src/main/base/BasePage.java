package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void waitForElement(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

    }

    public void waitForElementToClickable(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
}