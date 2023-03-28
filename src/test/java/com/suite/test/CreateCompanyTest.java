package com.suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.suite.base.Base;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.CreateCompanypage;
import com.suite.pages.LoginDevPortalPage;
import com.suite.pages.RegisterUserPage;
import com.suite.testdata.TestData;
import com.suite.utility.ExtentManager;
import com.suite.utility.Log;

public class CreateCompanyTest extends Base{

	LoginDevPortalPage login;
	CreateCompanypage company;
	RegisterUserTest reg;

	public CreateCompanyTest() {
		super();
	}
	
	
  @Test(priority = 1,groups= {"Smoke", "E2E"}, dataProvider = "CreateCompany", dataProviderClass = Dataproviders.class)
  public void verifyCreateCompanyProfile(String email, String password, String name, String address, String city, String zipcode, String phoneNumber, String url, String emailDomain, String description) {
	  
	  company = new CreateCompanypage();
	 
		
		company.clickLoginBtn();
		company.enterEmailAddress(email);
		company.enterPassword(password);
		company.clickSubmitBtn();
		 
		company.clickOnNewCompanyBtn();
		
		company.enterComapnyName(name);
		company.enterCorprateAdd(address);
		company.selectCountry();
		company.enterCity(city);
		company.enterPostalCode(TestData.ZIP_CODE);
		company.companyPhone(TestData.COMPANY_PHONE_NUMBER);
		company.companyUrl(url);
		company.companyEmailDomain(emailDomain);
		company.companyDescription(description);
		
		company.clickOnCreateBtn();
		
		String actual = company.getVerifyProgramAccess();
		
		Assert.assertEquals(actual, TestData.PROGRAM_ACCESS_TEXT);
	  }
  
  @Test(priority = 0, groups = { "Sanity", "E2E", "Smoke" }, dataProvider = "AddUser", dataProviderClass = Dataproviders.class)
	public void userAcceptTermsandCondition(String email, String password, String firstName,String lastName, String text) {
	  
	  RegisterUserPage	registerPage = new RegisterUserPage();
		
		registerPage.clickLoginBtn();
		registerPage.enterEmail(email); 
		registerPage.enterPassword(password);
		registerPage.clickSubmitBtn();
		registerPage.selectTermsandCondition();
		registerPage.clickOnSubmitBtn();
	}
  
  @Test(priority = -1, groups = { "Sanity", "E2E", "Smoke" }, dataProvider = "AddUser", dataProviderClass = Dataproviders.class)
 	public void userRegistration(String email, String password, String firstName,String lastName, String text) {
 	  
 	  RegisterUserPage	registerPage = new RegisterUserPage();
 
		Log.startTestCase("Create New User");
		Log.info("Verifying New User Functionality");
		ExtentManager.test.log(Status.INFO, "Verifying New User Functionality");

		// email= "user+" + Commonactions.getCurrentTime() + "@mailinator.com";

		registerPage.clickLoginBtn();
		registerPage.clickOnSignUp();
		registerPage.enterEmail(email);
		registerPage.enterPassword(password);
		registerPage.enterFirstName(firstName);
		registerPage.enterLastName(lastName);
		registerPage.clickSubmitBtn();

		String actual = registerPage.getVerifyMail(text);
		Assert.assertEquals(actual, text);

		registerPage.getMailNotification();
		registerPage.enterMail(email);
		registerPage.clickOnSearchBtn();
		registerPage.clickOnInboxList();
		registerPage.switchToFrame(TestData.FrameID);
		registerPage.clickOnConfirmationLink();
		registerPage.redirectOnLoginPage();
		Log.info("Verified New User Functionality");
		ExtentManager.test.log(Status.PASS, "Verifying New User Functionality working successfully");
		Log.endTestCase("Created New User");
 	}
}
