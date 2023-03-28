
package com.suite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.suite.base.Base;
import com.suite.commonactions.Commonactions;

/**
 * @author amrita.bhawsar
 *
 */

public class EditCompanyDetailsPage extends Base {

	@FindBy(css = "div > ul > div > li:nth-child(2) > a")
	private WebElement selectEditCompany;
	
	@FindBy(xpath = "//*[@id=\"Company Information\"]/div/h1")
	private WebElement verifyTextOfCompInfo;
	
	@FindBy(xpath = "//input[@name=\"emailDomain\"]")
	private WebElement enterComData;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement updateBtn;
	
	@FindBy(xpath="//*[@id=\"Company Information\"]/form/div[7]/div/button[1]")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//*[@id=\"Company Information\"]/form/div[7]/div/button[2]")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//*[@id=\"Company Information\"]/form/div[7]/div/button[2]")
	private WebElement confirmBtn;
	
	@FindBy(css="div.alert.alert-dismissable.alert-success>div.p-3>p.p-0")
	private WebElement verifySuccessMsg;
	
	@FindBy(css="div.popover-content.popover-body>p")
	private WebElement verifyConfirmationMsg;

	public EditCompanyDetailsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	/**
	 * click on edit company 
	 */
	public void clickOnEditCompany() {
		Commonactions.waitForElement(getDriver(), selectEditCompany);

		selectEditCompany.click();
		
	}

	/**
	 * @return company information
	 */
	public String getCompanyInformation() {
		return Commonactions.getText(verifyTextOfCompInfo);
		
	}

	/**
	 * enter valid company data
	 */
	public void enterCompanyData(String Data) {
		Commonactions.waitForElement(getDriver(), enterComData);
		
		enterComData.clear();
		enterComData.sendKeys(Data);
		
	}
	
	/**
	 * click on update button
	 */
	public void clickOnUpdateBtn() {
		Commonactions.clickingElementJS(getDriver(), updateBtn);
		
		Commonactions.waitForElement(getDriver(), updateBtn);
		
	}
	
	/**
	 * @return success message
	 */
	public String getSuccessfulEditMsg() {
		Commonactions.waitForElement(getDriver(), verifySuccessMsg);
		return Commonactions.getText(verifySuccessMsg);
	}
	
	/**
	 * click on cancel button
	 */
	public void clickOnCancelBtn() {
		Commonactions.clickingElementJS(getDriver(), cancelBtn);
		
		
	}

	/**
	 * navigate to forward page
	 */
	public void redirectPage() {
		Commonactions.getDriver().navigate().forward();
		
	}
	
	/**
	 * click on delete button
	 */

	public void clickOnDeleteBtn() {
		Commonactions.clickingElementJS(getDriver(), deleteBtn);
		
	}
	
	/**
	 * @return confirmation message while on delete company
	 */

	public String getConfirmationWindow() {
		return Commonactions.getText(verifyConfirmationMsg);
		
	}
	
	/**
	 * click on confirm button 
	 */

	public void clickOnConfirmBtn() {
		Commonactions.clickingElementJS(getDriver(), confirmBtn);
		
	}

}
