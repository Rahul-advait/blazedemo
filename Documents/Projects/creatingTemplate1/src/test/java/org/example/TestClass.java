package org.example;

import PageClasses.Purchase;
import PageClasses.Reserve;
import PageClasses.Vacation;
import base.BaseClass;
import base.Checklist;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.Constants;

import static org.testng.Assert.assertTrue;

public class TestClass extends BaseClass {
    Reserve reservePage;
    Purchase purchase;

    @AfterMethod
    public void navigateToHomepage() {
        driver.navigate().to(Constants.BASE_URL);
    }

    @Test
    public void verifyDestinationLink() {
        Vacation vacation = homePage.clickDestinationLink();
        boolean result = vacation.isOpen();
        assertTrue(result);
    }

    @Test
    public void verifyPurchasePage() throws InterruptedException {
        homePage.selectDepartureCity("Mexico City");
        homePage.selectDestinationCity("London");
        reservePage = homePage.clickFindFlights();
        purchase = reservePage.selectLowestPrice();
        boolean result = purchase.isOpen();
        Checklist.mark("Purchase is open", result);

        boolean totalCost = purchase.isTotalCostPresent();
        Checklist.markFinal("Total cost present and correct formata", totalCost);
    }
}
