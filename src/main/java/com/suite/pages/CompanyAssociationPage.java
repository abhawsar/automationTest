package com.suite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.suite.base.Base;
import com.suite.commonactions.Commonactions;

public class CompanyAssociationPage extends Base{
	
	@FindBy(css = "div > ul > div > li:nth-child(2) > a")
	private WebElement selectEditCompany;
	
	@FindBy(xpath = "//button[contains(.,'Members')]")
	private WebElement companyMember;
	
	@FindBy(linkText = "Associate Company Member")
	private WebElement linkofAssociateMember;
	
	@FindBy(xpath = "//h5[contains(.,'Associate Company Member')]")
	private WebElement associateCompnayText;
	
	@FindBy(xpath = "//a[contains(text(),'Assign')]")
	private WebElement assignLink;
	
	@FindBy(xpath="//p[contains(.,'User has been associated successfully!')]")
	private WebElement associateSuccessMsg;
	
	@FindBy(xpath="//a[contains(text(),'Disassociate')]")
	private WebElement disassociateLink;
	
	@FindBy(xpath="//button[contains(.,'Confirm')]")
	private WebElement confirmBtn;
	
	@FindBy(xpath="//p[contains(.,'User has been disassociated successfully!')]")
	private WebElement disassociateSuccessMsg;
	
	@FindBy(xpath = "//*[@id=\"Company Information\"]/div/h1")
	private WebElement verifyTextOfCompInfo;
  
	public CompanyAssociationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clickOnEditCompany() {
		Commonactions.waitForElement(getDriver(), selectEditCompany);
		Commonactions.click(getDriver(), selectEditCompany);

		
	}

	public void clickOnMembers() {
		Commonactions.explicitWait(getDriver(), companyMember, 20);
		//Commonactions.waitForElement(getDriver(), companyMember);
		Commonactions.clickingElementJS(getDriver(), companyMember);
		
	}

	public void clickOnAssociateMembers() {
		Commonactions.waitForElement(getDriver(), linkofAssociateMember);
		Commonactions.click(getDriver(), linkofAssociateMember);
		
	}

	public String getTextOfAssociateMember() {
	
		return Commonactions.getText(associateCompnayText);
		
	}

	public void clickOnAssignLink() {
		Commonactions.waitForElement(getDriver(), assignLink);
		Commonactions.click(getDriver(), assignLink);
		
	}

	public String getSuccessMessage() {
		
		return Commonactions.getText(associateSuccessMsg);
	}

	public void clickOnDisassociateLink() {
		Commonactions.waitForElement(getDriver(), disassociateLink);
		Commonactions.click(getDriver(), disassociateLink);
		
	}

	public void clickOnConfirmBtn() {
		Commonactions.waitForElement(getDriver(), confirmBtn);
		Commonactions.click(getDriver(), confirmBtn);
		
	}

	public String getSuccessMessageDisassociation() {
		// TODO Auto-generated method stub
		return Commonactions.getText(disassociateSuccessMsg);
	}
	
	public String getCompanyInformation() {
		return Commonactions.getText(verifyTextOfCompInfo);
		
	}
}
