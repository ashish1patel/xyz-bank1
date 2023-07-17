package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")  WebElement yourNameDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']") WebElement loginButton;


    public void searchCustomerName(){
        Reporter.log("Search Customer name" + yourNameDropDown.toString());
        selectByVisibleTextFromDropDown(yourNameDropDown,"Harry Potter");
        CustomListeners.test.log(Status.PASS,"Search customer name from drop down");
    }

    public void clickOnLoginButton(){
        Reporter.log("Click on log in button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on log in button");
    }
}
