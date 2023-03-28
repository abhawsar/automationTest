package com.suite.pages;

/**
 * @author amrita.bhawsar
 *
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suite.base.Base;
import com.suite.commonactions.Commonactions;


public class CreateCompanypage extends Base {
	
	// Web Elements
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/button")
	private WebElement loginBtn;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(css = "div.header.mb-2 > button.primary-btn.active")
	private WebElement newCompanyBtn;
	
	@FindBy(css = "div.header.mb-2 > button.primary-btn.active")
	private WebElement companyRegistrtaionText;
	
	@FindBy(css = "div.create-form-div >form > div:nth-child(1) > div:nth-child(1) > input")
	private WebElement companyName;
	
	@FindBy(css = "div.create-form-div > form > div:nth-child(1) > div:nth-child(2) > input")
	private WebElement companyAddress;
	
	@FindBy(css = "company-create > div > div > div.create-form-div > form > div:nth-child(2) > div:nth-child(1) > select")
	private WebElement selectCountry;
	
	@FindBy(css = "company-create > div > div > div.create-form-div > form > div:nth-child(2) > div:nth-child(3) > input")
	private WebElement selectCity;
	
	@FindBy(css = "company-create > div > div > div.create-form-div > form > div:nth-child(3) > div:nth-child(2) > input")
	private WebElement postalCode;
	
	@FindBy(css = "company-create > div > div > div.create-form-div > form > div:nth-child(3) > div:nth-child(3) > input")
	private WebElement phoneNumber;
	
	@FindBy(css = "company-create > div > div > div.create-form-div > form > div:nth-child(4) > div:nth-child(1) > input")
	private WebElement compnyUrl;
	
	@FindBy(css = "company-create > div > div > div.create-form-div > form > div:nth-child(4) > div:nth-child(2) > input")
	private WebElement companyEmail;
	
	@FindBy(css = "company-create > div > div > div.create-form-div > form > div:nth-child(5) > div > textarea")
	private WebElement companyDescription;
	
	@FindBy(css = "div.create-form-div > form > div.form-row.text-right > div > button.primary-btn")
	private WebElement clickOnCreateBtn;

	@FindBy(css = "div.new-company-text>p")
	private WebElement verifyText;
	
	
	public CreateCompanypage() {
		PageFactory.initElements(getDriver(), this);
	}

	/**
	 * click on login btn
	 */
	public void clickLoginBtn() {
		Commonactions.waitForElement(getDriver(), loginBtn);
		Commonactions.click(getDriver(), loginBtn);
	}

	/**
	 * Enter email id
	 * @param email 
	 */
	public void enterEmailAddress(String email) {
		Commonactions.waitForElement(getDriver(), userName);

		userName.sendKeys(email);

	}

	/**
	 * enter password
	 * @param pass 
	 */
	public void enterPassword(String pass) {
		Commonactions.waitForElement(getDriver(), password);

		password.sendKeys(pass);

	}

	/**
	 * click on submit btn
	 */
	public void clickSubmitBtn() {
		Commonactions.waitForElement(getDriver(), submitBtn);
		Commonactions.click(getDriver(), submitBtn);

	}

	public void clickOnNewCompanyBtn() {
		Commonactions.waitForElement(getDriver(), newCompanyBtn);
		Commonactions.click(getDriver(), newCompanyBtn);
		
	}

	public String getCompanyRegistrationMsg() {
		return Commonactions.getText(companyRegistrtaionText);
		
	}

	public void enterComapnyName(String nameOfCompany) {
		Commonactions.waitForElement(getDriver(), companyName);
		Commonactions.type(companyName, nameOfCompany);
		//companyName.sendKeys(nameOfCompany);
	}

	public void enterCorprateAdd(String cororateAddress) {
		Commonactions.waitForElement(getDriver(), companyAddress);
		Commonactions.type(companyAddress, cororateAddress);
		//companyAddress.sendKeys(cororateAddress);
		
	}

	public void selectCountry() {
		Commonactions.selectByVisibleText("India", selectCountry);
		//Commonactions.selectByIndex(selectCountry, 1);
		
	}

	public void enterCity(String city) {
		Commonactions.waitForElement(getDriver(), selectCity);
		Commonactions.type(selectCity, city);
		//selectCity.sendKeys(city);
		
	}

	public void enterPostalCode(String zipCode) {
		Commonactions.waitForElement(getDriver(), postalCode);
		Commonactions.type(postalCode, zipCode);
		//postalCode.sendKeys(zipCode);
		
	}

	public void companyPhone(String companyNumber) {
		Commonactions.waitForElement(getDriver(), phoneNumber);
		Commonactions.type(phoneNumber, companyNumber);
		//phoneNumber.sendKeys(companyNumber);
		
	}

	public void companyUrl(String url) {
		Commonactions.waitForElement(getDriver(), compnyUrl);
		Commonactions.type(compnyUrl, url);
		//compnyUrl.sendKeys(url);
		
	}

	public void companyEmailDomain(String companyEmailDomain) {
		Commonactions.waitForElement(getDriver(), companyEmail);
		Commonactions.type(companyEmail, companyEmailDomain);
		//companyEmail.sendKeys(companyEmailDomain);
		
	}

	public void companyDescription(String description) {
		Commonactions.waitForElement(getDriver(), companyDescription);
		Commonactions.type(companyDescription, description);
		//companyDescription.sendKeys(description);
		
	}

	public void clickOnCreateBtn() {
		Commonactions.waitForElement(getDriver(), clickOnCreateBtn);
		Commonactions.clickingElementJS(getDriver(), clickOnCreateBtn);
		
	}

	public String getVerifyProgramAccess() {
		// TODO Auto-generated method stub
		return Commonactions.getText(verifyText);
	}

}
