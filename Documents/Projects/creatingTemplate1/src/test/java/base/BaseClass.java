package base;

import PageClasses.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.Constants;

public class BaseClass {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUP() {
        driver = WebDriverFactory.useChrome();
        driver.get(Constants.BASE_URL);
        homePage = new HomePage(driver);
        if (!homePage.getDESTINATION_LINK().isDisplayed()){
            driver.navigate().refresh();
        }
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
