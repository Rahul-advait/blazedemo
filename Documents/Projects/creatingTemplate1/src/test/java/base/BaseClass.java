package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import resources.Constants;

public class BaseClass {
    public WebDriver driver;

    @BeforeClass
    public void setUP() {
        driver = CustomDriver.useChrome();
        driver.get(Constants.BASE_URL);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
