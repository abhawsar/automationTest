package com.suite.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.suite.base.Base;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.AppRegistrationPage;
import com.suite.testdata.TestData;
import com.suite.utility.Log;

public class AppRegistrationTest extends Base {
	
	AppRegistrationPage addApp;
	SoftAssert softAssert =new SoftAssert();
	
	public AppRegistrationTest() {
		super();
	}
	
  @Test(enabled=true, priority=0,groups= {"Smoke", "E2E"}, dataProvider = "AddApplication", dataProviderClass = Dataproviders.class)
  public void verifyAddApplicationLink(String email, String passWord, String appName, String appDescription, String callbackUrl, String landingPageUrl) throws Exception {
	  
	  
	  addApp=new AppRegistrationPage();

	  login(email, passWord);
	  
	  addApp.clickOnDashboard();
	  Boolean actual= addApp.isAddLinkDisplay();
	  
	  if(actual==true)
	  {
		  
		  addApp.clickOnAddApplication();
		  addApp.enterAppName(appName);
		  addApp.selectProduct();
		  addApp.enterAppDescription(appDescription);
		  addApp.uploadImgIcon();
		  addApp.selectRegion();
		  addApp.clickOnCheckboxRegion();
		  addApp.clickOnSelectTag();
		  addApp.selectAllTag();
		  addApp.enterFMISAuthzUrl(callbackUrl);
		  addApp.enterFMISLandingPageUrl(landingPageUrl);
		  
		  addApp.clickOnProfileQA();
		  addApp.clickOnQuetsionFirst();
		  addApp.clickOnQuestionSecond();
		  addApp.clickOnQuestionThird();
		  addApp.clickOnQuestionFourth();
		  
			/*
			 * addApp.clickOnAdditionalInformation();
			 * 
			 * addApp.enterComment(TestData.COMMENT);
			 */
		  
		  addApp.clickOnSubmit();
		  
		  String message = addApp.getSuccessMessage();
		  softAssert.assertEquals(message, TestData.SUCCESS_MSG_APP_REGISTERED);
		  softAssert.assertAll();
	  }
	  
	  else
	  {
		  Log.error("Your Company currently has No access to AG DATA and Offline Programs");
	  }
	  
  }
  
  @Test(enabled=true, priority=1,groups= {"Smoke", "E2E"}, dataProvider = "AddApplication", dataProviderClass = Dataproviders.class)
  public void editAddApplication(String email, String passWord, String appName, String appDescription, String callbackUrl, String landingPageUrl) throws Exception {
	  
	  
	  addApp=new AppRegistrationPage();

	  login(email, passWord);
	  
	  addApp.clickOnDashboard();
	  Boolean actual= addApp.isAppLinkDisplay();
	  
	  if(actual==true)
	  {
		  
		  addApp.clickOnAppRegistration();
		  addApp.clickOnAppName();
		  addApp.isDescriptionDisplay(TestData.EDIT_DESCRIPTION);
		  addApp.clickOnSubmitBtn();
		  
		  System.out.println("clicked on Submit button");
		  
			
			String message = addApp.getSuccessUpdateMessage();
			softAssert.assertEquals(message, TestData.SUCCESS_MSG_APP_REGISTERED);
			softAssert.assertAll();
			 
		  
	  }
  }
  
  @Test(enabled=true,priority=2,groups= {"Smoke", "E2E"}, dataProvider = "AddApplication", dataProviderClass = Dataproviders.class)
  public void verifySubmitForTestingApp(String email, String passWord, String appName, String appDescription, String callbackUrl, String landingPageUrl) throws Exception {
	  
	  
		addApp = new AppRegistrationPage();

		login(email, passWord);

		addApp.clickOnDashboard();
		Boolean actual = addApp.isAppLinkDisplay();

		if (actual == true) {

			addApp.clickOnAppRegistration();
			addApp.selectPendingStatus();
			addApp.clickOnPendingApp();
			addApp.isStatusDisplayPending();
			addApp.clickOnSubmitForTesting();

			String message = addApp.getSuccessSubmitTestingMsg();
			softAssert.assertEquals(message, TestData.SUCCESS_MSG_SUBMIT_TESTINGSTATUS);
			softAssert.assertAll();

		}
  }
  
  
  @Test(enabled=true, groups= {"Smoke", "E2E"}, dataProvider = "AddApplication", dataProviderClass = Dataproviders.class)
  public void verifyApproveStatus(String email, String passWord, String appName, String appDescription, String callbackUrl, String landingPageUrl) throws Exception {
	  
	  
		addApp = new AppRegistrationPage();

		login(email, passWord);

		addApp.clickOnDashboard();
		Boolean actual = addApp.isAppLinkDisplay();

		if (actual == true) {

			addApp.clickOnAppRegistration();
			addApp.selectApprovalStatus();
			addApp.clickOnPendingApp();
			addApp.isStatusDisplayPending();
			addApp.clickOnApproveButton();
			addApp.clickOnConfirmButton();

			String message = addApp.getSuccessSubmitTestingMsg();
			softAssert.assertEquals(message, TestData.SUCCESS_MSG_APPROVED);
			softAssert.assertAll();
 
		}
  }
  
  @Test(enabled=true, groups= {"Smoke", "E2E"}, dataProvider = "AddApplication", dataProviderClass = Dataproviders.class)
  public void verifyDeleteApplication(String email, String passWord, String appName, String appDescription, String callbackUrl, String landingPageUrl) throws Exception {
	  
	  
		addApp = new AppRegistrationPage();

		login(email, passWord);

		addApp.clickOnDashboard();
		Boolean actual = addApp.isAppLinkDisplay();

		if (actual == true) {

			addApp.clickOnAppRegistration();
			addApp.selectPendingStatus();
			addApp.clickOnPendingApp();
			addApp.isStatusDisplayPending();
			addApp.clickOnDeleteBtn();
			addApp.clickOnConfirmButton();

			String message = addApp.getSuccessSubmitTestingMsg();
			softAssert.assertEquals(message, TestData.SUCCESS_MSG_ARCHIVED);
			softAssert.assertAll();
			 
		}
  }
  
  private void login(String userName, String passWord) {
	  addApp.clickLoginBtn();
	  addApp.enterEmailAddress(userName);
	  addApp.enterPassword(passWord);
	  addApp.clickSubmitBtn();
	  addApp.clickBtnlogin();
	}
  
}
