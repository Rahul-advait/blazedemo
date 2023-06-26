package PageClasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends BasePage {
    private WebDriver driver;
    private String URL = "confirmation";
    private String ID = "xpath=>//tr[1]/td[2]";
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen() {
        boolean check = isOpen(URL);
        return check;
    }

    public void storeId(){
        WebElement element = getElement(ID, "id");
        String id = element.getText();
        System.out.println(id);
    }


}
