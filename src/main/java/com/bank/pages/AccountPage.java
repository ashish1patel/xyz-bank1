package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logout;

    @CacheLookup
    @FindBy(xpath = "//span[@class='fontBig ng-binding']")
    WebElement nameText;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountBox;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawalTab;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawAmount;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawButton;

    public void verifyNameText() {
        Reporter.log("Verify customer Name");
        String expectedText = "Harry Potter";
        String actualText = getTextFromElement(nameText);
        Assert.assertEquals(actualText, expectedText);
        CustomListeners.test.log(Status.PASS, "Verify customer name");
    }

    public void verifyLogoutText() {
        Reporter.log("Getting logout text");
        String expectedText = "Logout";
        String actualText = getTextFromElement(logout);
        Assert.assertEquals(actualText, expectedText);
        CustomListeners.test.log(Status.PASS, "Get logout text");
    }

    public void clickOnLogoutButton() {
        Reporter.log("Click on logout button" + logout.toString());
        clickOnElement(logout);
        CustomListeners.test.log(Status.PASS, "Click on logout button");
    }

    public void enterAmount(String amount) {
        Reporter.log("Enter amount " + amount + "into amount field " + amountBox.toString());
        sendTextToElement(amountBox, amount);
        CustomListeners.test.log(Status.PASS, "Enter amount into amount field");
    }

    public void clickOnDeposit() {
        Reporter.log("Click on deposit button" + depositButton.toString());
        clickOnElement(depositButton);
        CustomListeners.test.log(Status.PASS, "Click on deposit button");
    }

    public String verifyTheSuccessMessage() {
        Reporter.log("Verify customer Name");
        String message = getTextFromElement(successMessage);
        CustomListeners.test.log(Status.PASS, "Verify customer name");
        return message;
    }

    public void clickOnWithdrawalTab() {
        Reporter.log("Click on withdrawal Tab" + withdrawalTab.toString());
        clickOnElement(withdrawalTab);
        CustomListeners.test.log(Status.PASS, "Click on withdrawal button");
    }

    public void enterWithdrawalAmount(String amount){
        Reporter.log("Enter withdrawal amount" + amount + "into amount field" + withdrawAmount.toString());
        clickOnElement(withdrawAmount);
       // sendTextToElement(withdrawAmount, amount);
        CustomListeners.test.log(Status.PASS, "Enter withdrawal amount into amount field");
    }
    public void m1(String amount){
        sendTextToElement(withdrawAmount, amount);

    }

    public void clickOnWithdrawButton() {
        Reporter.log("Click on withdrawal button" + withdrawButton.toString());
        clickOnElement(withdrawButton);
        CustomListeners.test.log(Status.PASS, "Click on withdrawal button");
    }

}
