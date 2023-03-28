
package com.suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.suite.base.Base;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.EditCompanyDetailsPage;
import com.suite.pages.LoginDevPortalPage;
import com.suite.testdata.TestData;
import com.suite.utility.ExtentManager;
import com.suite.utility.Log;

/**
 * @author amrita.bhawsar
 *
 */
public class EditCompanyDetailsTest extends Base {
	
	LoginDevPortalPage login;
	EditCompanyDetailsPage edit;
	
	
	public EditCompanyDetailsTest() {
		super();
	}
	
	@Test(priority=0,groups= {"Smoke", "E2E"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void editCompanyProfile(String userName, String passWord, String roles) throws Exception {
		
		login = new LoginDevPortalPage();

		Log.info("Login DevPortal with user " + roles);
		
		if(roles.contains("Admin") || roles.contains("Account Owner")) 
		{
			
		extracted(userName, passWord);

		edit = new EditCompanyDetailsPage();
		edit.clickOnEditCompany();
		edit.getCompanyInformation();
		edit.enterCompanyData(TestData.COMPANY_EMAIL_DOMAIN);
		edit.clickOnUpdateBtn();
		
		
		String actual = edit.getSuccessfulEditMsg();
		System.out.println(actual);
		Assert.assertEquals(actual, TestData.EXPECTED_SUCCESS_MEG);
		ExtentManager.test.log(Status.PASS, "Company Profile Updated Successfully");
		 
		
		}
		
		else {
			
			Log.info("Developer can only view the company details");
		}
	}
	
	@Test(priority=1,groups= {"Smoke", "E2E"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void verifyCancelFunctionality(String userName, String passWord, String roles) {
		
		login = new LoginDevPortalPage();

		Log.info("Login DevPortal with user " + roles);
		
		extracted(userName, passWord);

		edit = new EditCompanyDetailsPage();
		edit.clickOnEditCompany();
		edit.clickOnCancelBtn();

		edit.redirectPage();
		
		String actual = edit.getCompanyInformation();

		System.out.println(actual);

		Assert.assertEquals(actual, TestData.EXPECTED_COMPANY_INFORMATION);
		
		ExtentManager.test.log(Status.PASS, "Cancel Functionality for all roles are working."); 
		Log.endTestCase("Cancled Functionality working for all roles");
	}
	
	@Test(priority=2,groups= {"Smoke", "E2E"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void verifyDeleteCompany(String userName, String passWord, String roles) {
		
		login = new LoginDevPortalPage();

		Log.info("Login DevPortal with user" + roles);
		
		if(roles.contains("Admin")) 
		{
			
		extracted(userName, passWord);
		
		edit = new EditCompanyDetailsPage();
		edit.clickOnEditCompany();
		edit.clickOnDeleteBtn();
		//edit.clickOnConfirmBtn();
		
		String actual = edit.getConfirmationWindow();

		System.out.println(actual);

		Assert.assertEquals(actual, TestData.EXPECTED_CONFIRMATION_MSG);
		ExtentManager.test.log(Status.PASS, "Company Deleted Functionality working.");
		}
		
		else {
			
			Log.info("Only Admin can Delete the Company");
		}
		
	}

	private void extracted(String userName, String passWord) {
		login.clickLoginBtn();
		login.enterEmailAddress(userName);
		login.enterPassword(passWord);
		login.clickSubmitBtn();
		login.clickBtnlogin();
	}
	
	

}
