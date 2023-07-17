package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {

    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;

    @BeforeMethod
    public void inIt(){
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();
    }

   @Test(groups = {"Sanity","Smoke","Regression"})
   @Parameters({"firstName","lastName", "postCode"})
    public void bankManagerShouldAddCustomerSuccessfully( String firstName,String lastName,String postCode){
       //    click On "Bank Manager Login" Tab
       bankManagerLoginPage.clickOnBankManagerLogin();

       //	click On "Add Customer" Tab
       addCustomerPage.clickOnAddCustomer();

       //	enter FirstName
       addCustomerPage.enterFirstName(firstName);

       //	enter LastName
       addCustomerPage.enterLastName(lastName);

       //	enter PostCode
       addCustomerPage.enterPostcode(postCode);

       //	click On "Add Customer" Button
       addCustomerPage.clickOnAddCustomer1();

       //	popup display
       //verify message "Customer added successfully"
       addCustomerPage.verifyAddCustomerSuccessfullyMessage();

       //	click on "ok" button on popup.
       addCustomerPage.clickOnOkFromPopupMessage();
   }
    @Test(groups = {"Smoke","Regression"})
   public void  bankManagerShouldOpenAccountSuccessfully(){
        //click On "Bank Manager Login" Tab
       bankManagerLoginPage.clickOnBankManagerLogin();

       //	click On "Open Account" Tab
      bankManagerLoginPage.clickOnOpenAccount();

       //	Search customer that created in first test
openAccountPage.searchCustomerName();

       //	Select currency "Pound"
      openAccountPage.selectCurrencyPound();

       //	click on "process" button
      openAccountPage.clickOnProcessButton();

       //	popup displayed
       //	verify message "Account created successfully"
      openAccountPage.verifyAccountCreateSuccessfullyMessage();

       //	click on "ok" button on popup.
      openAccountPage.clickOnOkFromPopupMessage();
   }
    @Test(groups = {"Regression"})
    public void customerShouldLoginAndLogoutSuccessfully(){
        //click on "Customer Login" Tab
       homePage.clickOnCustomerLogin();

       //	search customer that you created.
       customerLoginPage.searchCustomerName();

       //	click on "Login" Button
       customerLoginPage.clickOnLoginButton();

       //	verify "Your Name" text displayed.
       accountPage.verifyNameText();

       //	verify "Logout" Tab displayed.
       accountPage.verifyLogoutText();

       //	click on "Logout"
       accountPage.clickOnLogoutButton();
   }

    @Test(groups = {"Regression"})
    public void customerShouldDepositMoneySuccessfully(){
       SoftAssert softAssert = new SoftAssert();
        //click on "Customer Login" Tab
       homePage.clickOnCustomerLogin();

       //	search customer that you created.
       customerLoginPage.searchCustomerName();

       //	click on "Login" Button
       customerLoginPage.clickOnLoginButton();

       //	click on "Deposit" Tab
       customersPage.clickOnDepositTab();

       //	Enter amount 100
       accountPage.enterAmount("100");

       //	click on "Deposit" Button
       accountPage.clickOnDeposit();

       //	verify message "Deposit Successful"
       String actualDepositMessage = accountPage.verifyTheSuccessMessage();
       Assert.assertEquals(actualDepositMessage,"Deposit Successful");
   }
    @Test(groups = {"Regression"})
    public void customerShouldWithdrawMoneySuccessfully(){
        //click on "Customer Login" Tab
       homePage.clickOnCustomerLogin();

       //	search customer that you created.
       customerLoginPage.searchCustomerName();

       //	click on "Login" Button
       customerLoginPage.clickOnLoginButton();

       //	click on "Deposit" Tab
       customersPage.clickOnDepositTab();

       //	Enter amount 100
       accountPage.enterAmount("100");

       //	click on "Deposit" Button
       accountPage.clickOnDeposit();

       //	click on "Withdrawal" Tab
       accountPage.clickOnWithdrawalTab();

       //	Enter amount 50
       accountPage.enterWithdrawalAmount("50");
       accountPage.m1("50");

       //	click on "Deposit" Button
      // accountPage.clickOnWithdrawButton();

       //	verify message "Transaction Successful"
      // String actualDepositMessage = accountPage.verifyTheSuccessMessage();
      // Assert.assertEquals(actualDepositMessage,"Transaction Successful");
   }
}
