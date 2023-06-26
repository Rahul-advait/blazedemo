package PageClasses;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reserve extends BasePage {
    WebDriver driver;

    public Reserve(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private String getPRICE(int i, int j) {
        String PRICE_ROW = String.format("xpath=>//tbody/tr[%d]/td[%d]", i, j);
        return PRICE_ROW;
    }

    private String getButton(int i, int j) {
        String CHOOSE_FLT_BTN = String.format("xpath=>//tbody/tr[%d]/td[%d]/input", i, j);
        return CHOOSE_FLT_BTN;
    }

    public Purchase selectLowestPrice() {
        int rowCount = searchLowestPrice();
        elementClick(getButton(rowCount, 1), "CHOOSE_FLT_BTN");
        return new Purchase(driver);
    }


    private int searchLowestPrice() {
        double min = 0;
        int count = 0;
        for (int i = 1; i < 6; i++) {
            WebElement element = getElement(getPRICE(i, 6), "PRICE_ROW");
            String value = element.getText().substring(1).trim();
            double intValue = Double.parseDouble(value);
            if (min > intValue || min == 0) {
                min = intValue;
                count = i;
            }
        }
        return count;
    }


}
