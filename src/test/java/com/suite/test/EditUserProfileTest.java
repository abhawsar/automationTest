/**
 * @author gaurav.wani
 *
 */
package com.suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.suite.base.Base;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.EditUserProfilePage;

import com.suite.pages.LoginDevPortalPage;


import com.suite.testdata.TestData;
import com.suite.utility.ExtentManager;
import com.suite.utility.Log;

/**
 * @author amrita.bhawsar
 *
 */
public class EditUserProfileTest extends Base{
	
	
	LoginDevPortalPage log = new LoginDevPortalPage();
	EditUserProfilePage edit = new EditUserProfilePage();
	
	public EditUserProfileTest() {
		super();
	}
	
	@Test(enabled=true,priority=0,groups= {"Smoke", "E2E"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void editProfile(String userName, String passWord, String roles) {
		
		log= new LoginDevPortalPage();
		Log.info("Login DevPortal with user " + roles);
		login(userName, passWord);
		
		edit=new EditUserProfilePage();
		edit.clickOnEditProfile();
		edit.enterPhoneDeatils(TestData.PHONE_NUMBER);
		edit.clickOnUpdateBtn();

		String actual = edit.getSuccessfulEditMsg();
		Assert.assertEquals(actual, TestData.EXPECTED_SUCCESS_MEG);
		
		ExtentManager.test.log(Status.PASS, "User profile updated Successfully for "+ roles);
	}
	
	
	@Test(enabled=true,priority=1, groups= {"Smoke", "E2E"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void verifyCancelFunctionality(String userName, String passWord, String roles) {
		
		log= new LoginDevPortalPage();
		
		
		if(roles.contains("Admin") || roles.contains("Account Owner") || roles.contains("Developer"))
		{
			Log.info("Login DevPortal with user " + roles);

		login(userName, passWord);
		
		edit=new EditUserProfilePage();
		edit.clickOnEditProfile();
		edit.clickOnCancelBtn();

		//edit.redirectToHomePage();
		String actual= edit.getHomePageTitle();
		
		System.out.println(actual);
		
		Assert.assertEquals(actual, TestData.EXPECTED_HOMEPAGE_TITLE);
		
		ExtentManager.test.log(Status.PASS, "Verified Cancel functionality Successfully for "+ roles);
	}
		else {
			
			Log.error("this role is not defined" +roles);
		}
	}
	
	
	@Test(enabled=true,priority=2, groups= {"Smoke", "E2E"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void downloadProfile(String userName, String passWord, String roles) throws Exception {
		
		log= new LoginDevPortalPage();
		Log.info("Login DevPortal with user " + roles);
		login(userName, passWord);
		
		edit=new EditUserProfilePage();
		edit.clickOnEditProfile();
		edit.clickOnDownloadBtn();
		String actual=edit.getVerifyText(); 
		System.out.println(actual);
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		System.out.println(downloadPath);
		Assert.assertTrue(edit.isFileDownloaded(downloadPath, ".json"));
		 
		System.out.println("Json File Downloaded");
		
		  
		 
		ExtentManager.test.log(Status.PASS, "User profile details gets downloaded Successfully for "+ roles);
	}
	
	
	@Test(enabled=true,priority=3,groups= {"Smoke", "E2E"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void logDetails(String userName, String passWord, String roles) throws Exception {
		
		log= new LoginDevPortalPage();
		Log.info("Login DevPortal with user " + roles);
		login(userName, passWord);
		
		edit=new EditUserProfilePage();
		edit.clickOnEditProfile();
		edit.clickOnlogs();
		edit.getVerifyLogText();
		
		ExtentManager.test.log(Status.PASS, "Verified log details Successfully for "+ roles);
		
	}
	private void login(String userName, String passWord) {
		log.clickLoginBtn();
		log.enterEmailAddress(userName);
		log.enterPassword(passWord);
		log.clickSubmitBtn();
		log.clickBtnlogin();
	}
		 
	  
		 
	

}
