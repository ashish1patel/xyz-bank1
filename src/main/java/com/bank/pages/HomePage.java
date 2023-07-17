package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    //By customerLoginLink = By.xpath("//button[normalize-space()='Customer Login']");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLoginLink;

    public void clickOnCustomerLogin(){
        Reporter.log("Click on customer login" + customerLoginLink.toString());
        clickOnElement(customerLoginLink);
        CustomListeners.test.log(Status.PASS,"Click on customer login");
    }
}
