package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']" )
    WebElement lastNameField;

    @CacheLookup
    @FindBy(xpath ="//input[@placeholder='Post Code']" )
    WebElement postcodeField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    public void clickOnAddCustomer(){
        Reporter.log("Clink on add customer" + addCustomer.toString());
        clickOnElement(addCustomer);
        CustomListeners.test.log(Status.PASS,"Clink on add customer");
    }

    public void enterFirstName(String firstName){
        Reporter.log("Enter First name" + firstName + "into first name field"+firstNameField.toString());
        sendTextToElement(firstNameField,firstName);
        CustomListeners.test.log(Status.PASS,"Enter First name into first name field");
    }
    public void enterLastName(String lastName){
        Reporter.log("Enter last name" + lastName + "into last name field"+lastNameField.toString());
        sendTextToElement(lastNameField,lastName);
        CustomListeners.test.log(Status.PASS,"Enter last name into last name field");
    }
    public void enterPostcode(String postcode){
        Reporter.log("Enter postcode" + postcode + "into postcode field" + postcodeField.toString());
        sendTextToElement(postcodeField,postcode);
        CustomListeners.test.log(Status.PASS,"Enter postcode into postcode field");
    }
    public void clickOnAddCustomer1(){
        Reporter.log("Clink on add customer" + submit.toString());
        clickOnElement(submit);
        CustomListeners.test.log(Status.PASS,"Clink on add customer");
    }
    public void verifyAddCustomerSuccessfullyMessage(){
        Reporter.log("Getting success add customer message");
        String expectedText = "Customer added successfully with customer id :6";
        String actualText = getTextFromAlert();
        Assert.assertEquals(actualText,expectedText);
        CustomListeners.test.log(Status.PASS,"Verify Customer added successfully message");
    }
    public void clickOnOkFromPopupMessage(){
        Reporter.log("Click on ok from popup message");
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Click on ok from popup message");

    }

}
