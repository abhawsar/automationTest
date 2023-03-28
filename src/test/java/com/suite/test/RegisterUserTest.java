
package com.suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.suite.base.Base;
import com.suite.commonactions.Commonactions;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.RegisterUserPage;
import com.suite.testdata.TestData;
import com.suite.utility.ExtentManager;
import com.suite.utility.Log;

/**
 * @author amrita.bhawsar
 *
 */
public class RegisterUserTest extends Base {
	
	RegisterUserPage registerPage;

		@Test(enabled=true, groups = { "Sanity", "E2E", "Smoke" },dataProvider = "AddUser", dataProviderClass = Dataproviders.class)
		public void registerNewUser(String email,String password, String firstName,String lastName, String text) {
			registerPage = new RegisterUserPage();
			Log.startTestCase("Create New User");
			Log.info("Verifying New User Functionality");
			ExtentManager.test.log(Status.INFO, "Verifying New User Functionality");
			
			//email= "user+" + Commonactions.getCurrentTime() + "@mailinator.com"; 
					
			
			
			  registerPage.clickLoginBtn(); registerPage.clickOnSignUp();
			  registerPage.enterEmail(email); registerPage.enterPassword(password);
			  registerPage.enterFirstName(firstName); registerPage.enterLastName(lastName);
			  registerPage.clickSubmitBtn();
			  
			  String actual = registerPage.getVerifyMail(text);
			  Assert.assertEquals(actual,text);
			 
			
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
		

		
		@Test(enabled=false, groups = { "Sanity", "E2E", "Smoke" }, dataProvider = "AddUser", dataProviderClass = Dataproviders.class)
		public void userAcceptTermsandCondition(String email, String password, String firstName,String lastName, String text) {
			registerPage = new RegisterUserPage();
			
			//registerPage.redirectOnLoginPage();
			registerPage.clickLoginBtn();
			registerPage.enterEmail(email); 
			registerPage.enterPassword(password);
			registerPage.clickSubmitBtn();
			registerPage.selectTermsandCondition();
			registerPage.clickOnSubmitBtn();
		}

}
