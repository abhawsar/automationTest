package com.suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.suite.base.Base;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.LoginDevPortalPage;
import com.suite.pages.OfflinePluginsPage;
import com.suite.testdata.TestData;
import com.suite.utility.ExtentManager;

public class OfflinePluginsTest extends Base {
	
	LoginDevPortalPage login;
	OfflinePluginsPage plugins;
	
	SoftAssert softAssert= new SoftAssert();

	public OfflinePluginsTest() {
		super();
	}
	
	@Test(enabled=true, groups= {"E2E", "Smoke", "Sanity"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void testOfflineProgramsUI(String userName, String passWord, String roles) {
		
		login = new LoginDevPortalPage();
		extracted(userName,passWord );
		
		plugins=new OfflinePluginsPage();
		
		plugins.clickOnOfflineProgram();
		
		//Verify Dashboard Header UI
		ExtentManager.test.log(Status.INFO, "Checking for Visibility Of Offline Programs for role " +roles);
		softAssert.assertTrue(plugins.adaptPluginVisibility());
		ExtentManager.test.log(Status.PASS, "Adapt Plugin option displayed successfully");
		
		//Verify Dashboard Header UI
		ExtentManager.test.log(Status.INFO, "Checking for Visibility Of Offline Programs for role " +roles);
		softAssert.assertTrue(plugins.voyagerPluginVisibility());
		softAssert.assertAll();
		ExtentManager.test.log(Status.PASS, "Voyager Plugin option displayed successfully");
		
				
	}
	
	@Test(enabled=true, groups= {"E2E", "Smoke", "Sanity"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void verifyDownloadPlugins(String userName, String passWord, String roles) {
		
		login = new LoginDevPortalPage();
		extracted(userName,passWord );
		
		String plugin_adapt= TestData.ADAPT;
		String plugin_voyager= TestData.VOYAGER;
		
		plugins=new OfflinePluginsPage();
		
		
		if (plugin_adapt.contains("ADAPT Plugin")) {
			plugins.clickOnOfflineProgram();
			plugins.clickOnAdaptPlugin();

			// Verify Download ADAPT Plugin
			ExtentManager.test.log(Status.INFO, "Checking for Visibility Of download Adapt plugin for " + roles);
			softAssert.assertTrue(plugins.downloadAdaptPluginVisibility());
			ExtentManager.test.log(Status.PASS, "Download Adapt Plugin Enabled");

		}

		if (plugin_voyager.contains("Voyager Plugin")) {
			plugins.clickOnOfflineProgram();
			plugins.clickOnVoyagerPlugin();

			// Verify Download Voyager Plugin
			ExtentManager.test.log(Status.INFO, "Checking for Visibility Of download Voyager plugin for " + roles);
			softAssert.assertTrue(plugins.downloadVoyagerPluginVisibility());
			softAssert.assertAll();
			ExtentManager.test.log(Status.PASS, "Download Voyager 2 SDK Plugin Enabled");
			}
			
	}
	
	@Test(enabled=true,groups= {"E2E", "Smoke", "Sanity"}, dataProvider = "credentials", dataProviderClass = Dataproviders.class)
	public void verifyReadDocuments(String userName, String passWord, String roles) {
		
		login = new LoginDevPortalPage();
		extracted(userName,passWord );
		
		String plugin_adapt= TestData.ADAPT;
		String plugin_voyager= TestData.VOYAGER;
		
		plugins=new OfflinePluginsPage();
		
		
		if (plugin_adapt.contains("ADAPT Plugin")) {
			plugins.clickOnOfflineProgram();
			plugins.clickOnAdaptPlugin();
			plugins.clickOnReadDocuments();

			String actual = plugins.getverifyOverviewText();
			softAssert.assertEquals(actual, TestData.ADAPT_HEADER);

		}
		if (plugin_voyager.contains("Voyager Plugin")) {
			plugins.clickOnOfflineProgram();
			plugins.clickOnVoyagerPlugin();
			plugins.clickOnReadDocuments();

			String actual = plugins.getverifyMessage();
			softAssert.assertEquals(actual, TestData.VOYAGER_HEADER);
			softAssert.assertAll();

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
