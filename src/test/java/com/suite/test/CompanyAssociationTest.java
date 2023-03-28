package com.suite.test;

import org.testng.annotations.Test;

import com.suite.base.Base;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.AppRegistrationPage;
import com.suite.pages.CompanyAssociationPage;


public class CompanyAssociationTest extends Base{
	
	AppRegistrationPage addApp;
	CompanyAssociationPage compayAssociate;
	
	public CompanyAssociationTest() {
		super();
	}
	
	@Test(enabled = false, priority = 0, groups = { "Smoke","E2E" }, dataProvider = "AddApplication", dataProviderClass = Dataproviders.class)
	public void verifyAssociateComapnyMember(String email, String passWord, String appName, String appDescription,
			String callbackUrl, String landingPageUrl) throws Exception {

		addApp = new AppRegistrationPage();

		login(email, passWord);
		compayAssociate= new CompanyAssociationPage();
		
		compayAssociate.clickOnEditCompany();
		compayAssociate.getCompanyInformation();
		compayAssociate.clickOnMembers();
		compayAssociate.clickOnAssociateMembers();
		compayAssociate.getTextOfAssociateMember();
		compayAssociate.clickOnAssignLink();
		
		String actual= compayAssociate.getSuccessMessage();
		System.out.println(actual);
  }
	@Test(enabled = true, priority = 0, groups = { "Smoke","E2E" }, dataProvider = "AddApplication", dataProviderClass = Dataproviders.class)
	public void verifyDeAssociateComapnyMember(String email, String passWord, String appName, String appDescription,
			String callbackUrl, String landingPageUrl) throws Exception {

		addApp = new AppRegistrationPage();

		login(email, passWord);
		compayAssociate= new CompanyAssociationPage();
		
		compayAssociate.clickOnEditCompany();
		compayAssociate.getCompanyInformation();
		compayAssociate.clickOnMembers();
		compayAssociate.clickOnDisassociateLink();
		compayAssociate.clickOnConfirmBtn();
		String actual= compayAssociate.getSuccessMessageDisassociation();
		System.out.println(actual);
	  
  }
	
	
  private void login(String userName, String passWord) {
	  addApp.clickLoginBtn();
	  addApp.enterEmailAddress(userName);
	  addApp.enterPassword(passWord);
	  addApp.clickSubmitBtn();
	  addApp.clickBtnlogin();
	}
}
