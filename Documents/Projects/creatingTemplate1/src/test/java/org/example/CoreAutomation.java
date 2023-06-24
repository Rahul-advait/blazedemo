package org.example;

import PageClasses.HomePage;
import PageClasses.Vacation;
import base.BaseClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CoreAutomation extends BaseClass {
    HomePage homePage;
    @Test
    public void verifyDestinationLink(){
        homePage = new HomePage(driver);
        Vacation vacation = homePage.clickDestinationLink();
        boolean result = vacation.isOpen();
        assertTrue(result);
    }
}
