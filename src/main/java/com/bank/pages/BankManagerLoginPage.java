package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {

    //  By login = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement login;

    // By openAccount = By.xpath("//button[normalize-space()='Open Account']");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccount;


    public void clickOnBankManagerLogin(){
        Reporter.log("Click on manager login button" + login.toString());
        clickOnElement(login);
        CustomListeners.test.log(Status.PASS,"Click on manager login");
    }
    public void clickOnOpenAccount(){
        Reporter.log("Click on open account button" + openAccount.toString());
        clickOnElement(openAccount);
        CustomListeners.test.log(Status.PASS,"Click on open account button");
    }

}
