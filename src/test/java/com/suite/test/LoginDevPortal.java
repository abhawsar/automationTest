package com.suite.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.suite.base.Base;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.LoginDevPortalPage;
import com.suite.testdata.TestData;
import com.suite.utility.ExtentManager;
import com.suite.utility.Log;


public class LoginDevPortal extends Base {
	
	LoginDevPortalPage login;
	
  
  
	@Test(dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void loginToDeveloperPortal(String userName, String passWord, String roles) {

		login = new LoginDevPortalPage();
		Log.info("Verifying Login functionality");
		login.clickLoginBtn();
		login.enterEmailAddress(userName);
		login.enterPassword(passWord);
		login.clickSubmitBtn();
		login.clickBtnlogin();
		login.editProfile();
		
		
		if(roles.contains("Admin"))
		{
			ExtentManager.test.log(Status.INFO, "Checking for Visibility Of Site Admin");
			Assert.assertTrue(login.checkVisibilityOfSiteAdmin());
			ExtentManager.test.log(Status.PASS, "Site Admin role displayed successfully");
		}
		else if(roles.contains("Account Owner"))
		{
			String actual= login.getRolesName();
			System.out.println(actual);
			ExtentManager.test.log(Status.INFO, "Checking for Account Owner Role");
			Assert.assertEquals(actual, TestData.ROLES_ACCOUNT_OWNER);
			ExtentManager.test.log(Status.PASS, "Account Owner role displayed successfully");
		}
		else if(roles.contains("Developer")) {
			
			String actual= login.getRolesName();
			System.out.println(actual);
			ExtentManager.test.log(Status.INFO, "Checking for Developer role");
			Assert.assertEquals(actual, TestData.ROLES_DEVELOPER);
			ExtentManager.test.log(Status.PASS, "Developer role displayed successfully");
			
		}

	}

	@Test(priority = 1, enabled = true)
	public void resetPassword() {

		login = new LoginDevPortalPage();
		login.clickLoginBtn();
		Log.info("Verifying Forgot Password functionality");
		login.clickOnForgotPasswordLink();
		login.enterEmailAddress(TestData.RESET_PASSWORD);
		login.clickSubmitBtn();
		String actual = login.getResetMessage();
		System.out.println(actual);
		Assert.assertEquals(actual, TestData.RESET_MESSAGE);
		Log.info("Verified Forgot Password functionality");
		ExtentManager.test.log(Status.PASS, "Reset Message working successfully");
	}

}
  
