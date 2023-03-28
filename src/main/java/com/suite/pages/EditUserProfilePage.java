
package com.suite.pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suite.base.Base;
import com.suite.commonactions.Commonactions;

/**
 * @author amrita.bhawsar
 *
 */
public class EditUserProfilePage extends Base {

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/div/ul/div/li[1]/a")
	private WebElement selectEditprofile;

	@FindBy(xpath = "//*[@id=\"Officephone\"]")
	private WebElement editPhoneNo;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updateBtn;

	@FindBy(xpath = "//button[@class='btn mr-4 secondary-btn']")
	private WebElement cancelBtn;

	@FindBy(css = "div.alert.alert-dismissable.alert-success>div.p-3>p")
	private WebElement verifySuccessMsg;

	@FindBy(xpath = "//*[@id=\"carouselExampleCaptions\"]/div/div/div/h1")
	private WebElement verifyHomeTitle;

	@FindBy(xpath = "//*[@id=\"UserInformation\"]/div/button")
	private WebElement downloadBtn;

	@FindBy(xpath = "//*[@id=\"UserInformation\"]/div/p")
	private WebElement verifyText;

	@FindBy(css = "div.tab > button:nth-child(2)")
	private WebElement clickOnLogs;

	@FindBy(xpath = "//*[@id=\"Logs\"]/h1")
	private WebElement verifyLogText;

	public EditUserProfilePage() {
		PageFactory.initElements(getDriver(), this);
	}

	/**
	 * select edit profile
	 */
	public void clickOnEditProfile() {
		Commonactions.waitForElement(getDriver(), selectEditprofile);
		Commonactions.click(getDriver(), selectEditprofile);

	}

	/**
	 * enter phone no.
	 */
	public EditUserProfilePage enterPhoneDeatils(String phoneNo) {

		Commonactions.waitForElement(getDriver(), editPhoneNo);
		editPhoneNo.clear();
		editPhoneNo.sendKeys(phoneNo);
		return this;

	}

	/**
	 * click on Update button
	 */
	public void clickOnUpdateBtn() {
		Commonactions.waitForElement(getDriver(), updateBtn);
		Commonactions.click(getDriver(), updateBtn);
	}

	/**
	 * @return Success Message
	 */
	public String getSuccessfulEditMsg() {

		return Commonactions.getText(verifySuccessMsg);
	}

	/**
	 * click on cancel button
	 */
	public void clickOnCancelBtn() {

		Commonactions.clickingElementJS(getDriver(), cancelBtn);
	}

	/**
	 * @return redirect to home page
	 */
	public void redirectToHomePage() {
		Commonactions.getDriver().navigate().back();
	}

	/**
	 * @return get title of home page
	 */
	public String getHomePageTitle() {

		return Commonactions.getTitle(getDriver());
	}

	/**
	 * @throws Exception click on download button
	 */
	public void clickOnDownloadBtn() throws Exception {

		Commonactions.clickingElement(getDriver(), downloadBtn);
		Commonactions.waitForElement(getDriver(), downloadBtn);

	}

	/**
	 * @return verifying the downloading text 
	 */
	public String getVerifyText() {

		Commonactions.waitForElement(getDriver(), verifyText);
		return Commonactions.getText(verifyText);

	}

	/**
	 * click on logs details
	 */
	public void clickOnlogs() {
		Commonactions.waitForElement(getDriver(), clickOnLogs);
		Commonactions.click(getDriver(), clickOnLogs);
	}

	/**
	 * @return return log text
	 */
	public String getVerifyLogText() {
		return Commonactions.getText(verifyLogText);
	}

	public boolean isFileDownloaded(String downloadPath, String fileExt) {

		boolean flag = false;
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if (files[i].getName().contains(fileExt)) {
				flag = true;
			}
		}
		return flag;

	}

}
