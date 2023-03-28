/**
 * @author gaurav.wani
 *
 */
package com.suite.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suite.base.Base;
import com.suite.commonactions.Commonactions;

/**
 * @author amrita.bhawsar
 *
 */
public class LoginDevPortalPage extends Base{
	
	
	
	//Web Elements
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(css="#dropdownMenuButton")
	private WebElement userNameBtn;
	
	@FindBy(css="#navbarSupportedContent > div > ul > div > li")
	List<WebElement> dropdownMenuBtn;
	
	@FindBy(linkText = "Don't remember your password?")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//div[@class='auth0-global-message auth0-global-message-success']/span[1]/span")
	private WebElement resetMessage;
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/div/ul/div/li[1]/a")
	private WebElement selectEditprofile;
	
	@FindBy(xpath="//*[@id=\"UserInformation\"]/form/div[1]/div/span")
	private WebElement rolesName;
	
	@FindBy(xpath="//*[@id=\"UserInformation\"]/form/div[2]/div/label")
	private WebElement siteAdminLable;
		
	public LoginDevPortalPage() {
		PageFactory.initElements(getDriver(), this);

	}


	/**
	 * click on login btn
	 */
	public void clickLoginBtn() {
		Commonactions.waitForElement(getDriver(), loginBtn);

		//loginBtn.click();
		Commonactions.click(getDriver(), loginBtn);
	}

	/**
	 * Enter email id
	 */
	public void enterEmailAddress(String userEmailAdd) {
		Commonactions.waitForElement(getDriver(), userName);
		Commonactions.type(userName, userEmailAdd);

		//userName.sendKeys(userEmailAdd);
		
	}

	/**
	 * enter password
	 */
	public void enterPassword(String userPassword) {
		Commonactions.waitForElement(getDriver(), password);
		Commonactions.type(password, userPassword);

		//password.sendKeys(userPassword);
		
	}

	/**
	 * click on submit btn
	 */
	public void clickSubmitBtn() {
		Commonactions.waitForElement(getDriver(), submitBtn);

		submitBtn.click();

	}
	
	/**
	 * click on login btn with user name
	 */

	public void clickBtnlogin() {
		Commonactions.waitForElement(getDriver(), userNameBtn);

		userNameBtn.click();

	}

	/**
	 * verifying the list of items that display after login
	 */
	public List<WebElement> verifyLoginFunctionality() {
		Commonactions.waitForElements(getDriver(), dropdownMenuBtn);

		for (int i = 0; i < dropdownMenuBtn.size(); i++)

			System.out.println("CNH Home page is displayed " + dropdownMenuBtn.get(i).getText());

		return dropdownMenuBtn;

	}

	/**
	 * Current url validating
	 */
	public String validateLoginUrl() {

		return getDriver().getCurrentUrl();
	}

	/**
	 * click on forgot password link
	 */
	public void clickOnForgotPasswordLink() {
		Commonactions.waitForElement(getDriver(), forgotPassword);

		forgotPassword.click();

	}

	/**
	 * verifying reset message
	 */
	public String getResetMessage() {

		return Commonactions.waitForElement(getDriver(), resetMessage).getText();
	}


	public void editProfile() {
		Commonactions.waitForElement(getDriver(), selectEditprofile);
		Commonactions.click(getDriver(), selectEditprofile);
	}


	public String getRolesName() {
		// TODO Auto-generated method stub
		return Commonactions.waitForElement(getDriver(), rolesName).getText();
	}


	public boolean checkVisibilityOfSiteAdmin() {
		
		return Commonactions.waitForElement(getDriver(), siteAdminLable).isDisplayed();
	}




	


	


	
	

}
