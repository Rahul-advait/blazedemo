package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomDriver {

    private static Logger log = LogManager.getLogger(CustomDriver.class.getName());
    private WebDriver driver;

    public CustomDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String locator, String info) {
        By byType = getByType(locator, info);
        if (byType == null) {
            log.error("Found null byType");
        }
        WebElement element = null;
        try {
            element = driver.findElement(byType);
            log.info("Found element: " + locator);
        } catch (Exception e) {
            log.error("Unable to getElement : " + locator);
            log.error(e.getMessage());
        }
        return element;
    }

    public WebElement getElement(By byType, String info) {
        if (byType == null) {
            log.error("Found null byType");
        }
        WebElement element = null;
        try {
            element = driver.findElement(byType);
            log.info("Found element: " + byType);
        } catch (Exception e) {
            log.error("Unable to getElement : " + byType);
            log.error(e.getMessage());
        }
        return element;
    }

    private By getByType(String locator, String info) {
        String[] location = locator.split("=>");
        By byType = null;
        try {
            byType = switch (location[0]) {
                case "xpath" -> By.xpath(location[1]);
                case "id" -> By.id(location[1]);
                case "cssSelector" -> By.cssSelector(location[1]);
                case "name" -> By.name(location[1]);
                case "linkText" -> By.linkText(location[1]);
                case "partialLinkText" -> By.partialLinkText(location[1]);
                case "className" -> By.className(location[1]);
                case "tagName" -> By.tagName(location[1]);
                default -> null;
            };
            log.info("Found byType :" + locator);
        } catch (Exception e) {
            log.error("Element by type error " + "locator ");
            log.error(e.getMessage());
        }
        return byType;
    }

    public void waitClick(String locator, String info) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By byType = getByType(locator, info);
        WebElement element = null;
        try {
            log.info("Waiting for element to be clickable: " + locator);
            wait.until(ExpectedConditions.elementToBeClickable(byType));
            log.info("Wait is over for element: " + locator);
            element = getElement(byType, info);
            element.click();
            log.info("Clicked element");
        } catch (Exception e) {
            log.error("Element wait error " + "locator ");
            log.error(e.getMessage());
        }
    }

    public void waitForElement(String locator, String info) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By byType = getByType(locator, info);
        try {
            log.info("Waiting for element presence: " + locator);
            wait.until(ExpectedConditions.presenceOfElementLocated(byType));
            log.info("Wait is over for element: " + locator);
        } catch (Exception e) {
            log.error("Element wait error " + "locator ");
            log.error(e.getMessage());
        }
    }

    public void waitForElement(WebElement element, String info) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            log.info("Waiting for element presence: " + element);
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info("Wait is over for element: " + element);
        } catch (Exception e) {
            log.error("Element wait error " + "locator ");
            log.error(e.getMessage());
        }
    }

    public void elementClick(String locator, String info) {
        WebElement element = getElement(locator, info);
        try {
            element.click();
            log.info("Clicked element");
        } catch (Exception e) {
            System.out.println("Unable to click: " + locator);
            log.error(e.getMessage());
        }
    }

    public boolean isDisplayed(String locator, String info){
        WebElement element = getElement(locator, info);
        System.out.println(element.getText());
        return element.isDisplayed();
    }

}
