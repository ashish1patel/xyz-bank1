package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomersPage extends Utility {

    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Deposit']" )
    WebElement depositTab;

    public void clickOnDepositTab(){
        Reporter.log(" click on deposit tab" + depositTab.toString());
        clickOnElement(depositTab);
        CustomListeners.test.log(Status.PASS, "click on deposit tab");
    }

}
