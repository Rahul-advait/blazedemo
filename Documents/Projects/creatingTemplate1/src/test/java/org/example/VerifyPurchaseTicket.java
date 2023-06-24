package org.example;

import PageClasses.HomePage;
import PageClasses.Purchase;
import PageClasses.Reserve;
import base.BaseClass;
import base.Checklist;
import org.testng.annotations.Test;

public class VerifyPurchaseTicket extends BaseClass {
    HomePage homePage;
    Reserve reservePage;
    Purchase purchase;
    @Test
    public void verifyPurchasePage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.selectDepartureCity("Mexico City");
        homePage.selectDestinationCity("London");
        reservePage = homePage.clickFindFlights();
        purchase = reservePage.selectLowestPrice();
        boolean result = purchase.isOpen();
        Checklist.mark("Purchase is open", result);

        boolean totalCost = purchase.isTotalCostPresent();
        Checklist.markFinal("Total cost present", totalCost);


    }

}
