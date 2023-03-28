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
public class RegisterUserPage extends Base {
	
	public RegisterUserPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(linkText = "Sign Up")
	private WebElement signUpLink;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(name= "given_name")
	private WebElement firstName;
	
	@FindBy(name = "family_name")
	private WebElement lastName;
		
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "/html/body/app-root/section/verify-email/div/div/h1")
	private WebElement home;
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"inbox_field\"]")
	 private WebElement inputBtn;
	 
	
		/*
		 * @FindBy(xpath=
		 * "//*[@id=\"root\"]/div/div[1]/div[1]/nav/div[2]/form/div/input") private
		 * WebElement inputBtn;
		 */
	
	
	  @FindBy(xpath="//*[@id=\"inbox_pane\"]/div[1]/div[5]/button") 
	  private WebElement searchBtn;
	 
		/*
		 * @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div[1]/nav/div[2]/form/button")
		 * private WebElement searchBtn;
		 */
	
		/*
		 * @FindBy(xpath="//*[@class=\"messagelist-row\"]/a/div[3]/span") private
		 * WebElement mailBody;
		 */
	
	
	  
	@FindBy(xpath = "/html/body/div/main/div[2]/div[3]/div/div[4]/div/div/table/tbody/tr/td[2]")
	private WebElement mailBody;
	
	@FindBy(css= ".messagelist-row > div > iframe")
	private WebElement frame;
	
	@FindBy(tagName = "iframe")
	private List<WebElement> iframe;
	
	@FindBy(xpath="//a[text()='Confirm my account']")
	private WebElement confirmationlink;
	
	
	@FindBy(xpath="//p[text()='Thank you for signing up. Please verify your email address by clicking the following link:']")
	private WebElement thankyouMessage;
	
	@FindBy(xpath="//*[@type='checkbox']")
	private WebElement checkboxSelection;
	
	@FindBy(xpath="//button[@class='primary-btn']")
	private WebElement clickOnSubmitBtn;
	
	
	/**
	 * 
	 */
	public void clickLoginBtn() {
		Commonactions.waitForElement(getDriver(), loginBtn);

		loginBtn.click();
	}

	/**
	 * 
	 */
	public void clickOnSignUp() {
		Commonactions.waitForElement(getDriver(), signUpLink);

		signUpLink.click();

	}

	public void enterEmail(String username) {
		Commonactions.waitForElement(getDriver(), userName);

		userName.sendKeys(username);
	}

	public void enterPassword(String passWord) {
		Commonactions.waitForElement(getDriver(), password);

		password.sendKeys(passWord);
	}

	public void enterFirstName(String firstname) {
		Commonactions.waitForElement(getDriver(), firstName);

		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		Commonactions.waitForElement(getDriver(), lastName);

		lastName.sendKeys(lastname);
	}

	/**
	 * 
	 */
	public void clickSubmitBtn() {
		Commonactions.waitForElement(getDriver(), submitBtn);

		submitBtn.click();

	}

	/**
	 * @param text
	 * @return
	 */
	public String getVerifyMail(String text) {
		// TODO Auto-generated method stub
		return Commonactions.getText(home);
	}

	/**
	 * 
	 */
	public void getMailNotification() {

		Commonactions.getDriver().get("https://www.mailinator.com/v4/public/inboxes.jsp");
		// Commonactions.getDriver().get("https://maildrop.cc/");

	}

	/**
	 * @param email
	 */
	public void enterMail(String email) {
		Commonactions.waitForElement(getDriver(), inputBtn);

		inputBtn.sendKeys(email);

	}


	/**
	 * 
	 */
	public void clickOnSubmitBtn() {
		Commonactions.waitForElement(getDriver(), clickOnSubmitBtn);
		Commonactions.clickingElementJS(getDriver(), clickOnSubmitBtn);

	}

	/**
	 * 
	 */
	public void clickOnSearchBtn() {
		Commonactions.waitForElement(getDriver(), searchBtn);

		searchBtn.click();
		
	}

	/**
	 * 
	 */
	public void clickOnInboxList() {
		Commonactions.waitForElement(getDriver(), mailBody);

		mailBody.click();
		
	}

	/**
	 * @param frameid
	 */
	public void switchToFrame(String frameid) {
		Commonactions.getDriver().switchTo().frame(frameid);
		
	}

	/**
	 * 
	 */
	public void clickOnConfirmationLink() {
		Commonactions.waitForElement(getDriver(), confirmationlink);
		confirmationlink.click();
		
	}
	
	public void getThankYouMsg()
	{
		
		String str = Commonactions.getText(thankyouMessage);
		System.out.println(str);
	}

	/**
	 * 
	 */
	public void redirectOnLoginPage() {
		Commonactions.getDriver().get("https://euapidevportdwbapp01.azurewebsites.net/home");
		
	}
	

	/**
	 * 
	 */
	public void selectTermsandCondition() {
		Commonactions.waitForElement(getDriver(), checkboxSelection);
		Commonactions.clickingElementJS(getDriver(), checkboxSelection);


	}
}
