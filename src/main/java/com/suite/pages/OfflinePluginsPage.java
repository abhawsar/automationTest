package com.suite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suite.base.Base;
import com.suite.commonactions.Commonactions;
import com.suite.utility.Log;

public class OfflinePluginsPage extends Base {

	@FindBy(linkText =  "Offline Programs")
	private WebElement clickOnOfflinelink;
	
	@FindBy(xpath =  "//a[text()='ADAPT Plugin']")
	private WebElement adaptPlugin;
	
	@FindBy(xpath =  "//a[text()='Voyager2 SDK']")
	private WebElement voyagerPlugin;
	
	@FindBy(linkText ="ADAPT Plugin")
	private WebElement clickOnAdaptPlugin;
	
	@FindBy(linkText ="Voyager2 SDK")
	private WebElement clickOnVoyagerPlugin;
	
	@FindBy(xpath ="//a[text()='Download ADAPT Plugin']")
	private WebElement downloadAdaptPlugin;
	
	@FindBy(xpath ="//a[text()='Download Voyager2 SDK']")
	private WebElement downloadVoyagerPlugin;
	
	@FindBy(css ="div.button-container > button")
	private WebElement readDocuments;
	
	@FindBy(xpath ="//*[@id=\"ckeditor\"]/P[1]")
	private WebElement overviewMessage;
	
	@FindBy(xpath ="//*[@id=\"ckeditor\"]/P[1]")
	private WebElement overviewVoyagerMessage;

	public OfflinePluginsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean adaptPluginVisibility() {
		Log.info("Verifying Offline Program ADAPT Plugin visibility");
		return Commonactions.waitForElement(getDriver(), adaptPlugin).isDisplayed();
	}

	public void clickOnOfflineProgram() {
		
		Commonactions.click(getDriver(), clickOnOfflinelink);
		
	}

	public boolean voyagerPluginVisibility() {
		Log.info("Verifying Offline Program Voyager2 SDK Plugin visibility");
		return Commonactions.waitForElement(getDriver(), voyagerPlugin).isDisplayed();
	}

	public void clickOnAdaptPlugin() {
		Commonactions.waitForElement(getDriver(), clickOnAdaptPlugin);
		Commonactions.click(getDriver(), clickOnAdaptPlugin);
		
	}

	public void clickOnVoyagerPlugin() {
		Commonactions.waitForElement(getDriver(), clickOnVoyagerPlugin);
		Commonactions.click(getDriver(), clickOnVoyagerPlugin);
		
	}

	public boolean downloadAdaptPluginVisibility() {
		Log.info("Verifying download button visibility for ADAPT");
		return Commonactions.waitForElement(getDriver(), downloadAdaptPlugin).isEnabled();
	}
	
	public boolean downloadVoyagerPluginVisibility() {
		Log.info("Verifying download button visibility for Voyager");
		return Commonactions.waitForElement(getDriver(), downloadVoyagerPlugin).isEnabled();
	}

	public void clickOnReadDocuments() {
		Commonactions.waitForElement(getDriver(), readDocuments);
		Commonactions.clickingElementJS(getDriver(), readDocuments);
		
	}

	public String getverifyOverviewText() {
		
		return Commonactions.getText(overviewMessage);
	}

	public String getverifyMessage() {
		// TODO Auto-generated method stub
		return Commonactions.getText(overviewVoyagerMessage);
	}

}
