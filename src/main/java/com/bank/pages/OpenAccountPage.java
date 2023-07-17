package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameDropDown;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Process']" )
    WebElement processButton;

    public void searchCustomerName(){
        Reporter.log("Search Customer name" + customerNameDropDown.toString());
        selectByVisibleTextFromDropDown(customerNameDropDown,"Harry Potter");
        CustomListeners.test.log(Status.PASS,"Search customer name from drop down");
    }

    public void selectCurrencyPound(){
        Reporter.log("Select currency Pound" + currencyDropDown.toString());
        selectByVisibleTextFromDropDown(currencyDropDown,"Pound");
        CustomListeners.test.log(Status.PASS,"Select pound from currency drop down");
    }
    public void clickOnProcessButton(){
        Reporter.log("Click on process button" + processButton.toString());
        clickOnElement(processButton);
        CustomListeners.test.log(Status.PASS,"Click on process button");
    }
    public void verifyAccountCreateSuccessfullyMessage(){
        Reporter.log("Getting success add customer message");
        String expectedText = "Account created successfully with account Number :1016";
        String actualText = getTextFromAlert();
        Assert.assertEquals(actualText,expectedText);
        CustomListeners.test.log(Status.PASS,"Verify account create successfully message");
    }
    public void clickOnOkFromPopupMessage(){
        Reporter.log("Click on ok from popup message");
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Click on ok from popup message");
    }
}
