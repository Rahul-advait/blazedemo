package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reserve {
    WebDriver driver;

    public Reserve(WebDriver driver) {
        this.driver = driver;
    }

    private String getPRICE(int i, int j) {
        return String.format("//tbody/tr[%d]/td[%d]", i, j);
    }

    private String getButton(int i, int j) {
        return String.format("//tbody/tr[%d]/td[%d]/input", i, j);
    }
    public Purchase selectLowestPrice() {
        int rowCount = searchLowestPrice();
        WebElement element = driver.findElement(By.xpath(getPRICE(rowCount, 1)));
        element.click();
        return new Purchase(driver);
    }



    private int searchLowestPrice(){
        double min = 0;
        int count = 0;
        for (int i = 1; i < 6; i++) {
            WebElement element = driver.findElement(By.xpath(getPRICE(i, 6)));
            String inputValue = element.getText();
            String value = inputValue.substring(1).trim();
            double intValue = Double.parseDouble(value);
            System.out.println(intValue);
            if (min > intValue || min == 0) {
                min = intValue;
                count = i;
            }
        }
        return count;
    }


}
