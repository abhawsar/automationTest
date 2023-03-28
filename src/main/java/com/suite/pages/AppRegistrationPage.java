package com.suite.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.suite.base.Base;
import com.suite.commonactions.Commonactions;

/**
 * @author amrita.bhawsar
 *
 */
public class AppRegistrationPage extends Base{
  
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/button")
	private WebElement loginBtn;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(css = "div > ul > div > li:nth-child(3) > a")
	private WebElement selectAccountDashboard;
	
	@FindBy(xpath = "//a[text()=' Add Application']")
	private WebElement addApplicationLink;
	
	@FindBy(xpath = "//a[text()=' App Registrations']")
	private WebElement addAppRegistration;
	
	@FindBy(css="#dropdownMenuButton")
	private WebElement userNameBtn;
	
	@FindBy(xpath="//input[@id='appName' and @class='form-control ng-untouched ng-pristine ng-invalid']")
	private WebElement applicationName;
	
	@FindBy(css="#collapseGeneral > div > div:nth-child(2) > div > textarea.form-control.ng-untouched.ng-pristine.ng-invalid")
	private WebElement appText;
	
	@FindBy(css="#collapseGeneral > div > div:nth-child(5) > div:nth-child(1) > textarea")
	private WebElement authzUrl;
	
	@FindBy(css="#collapseGeneral > div > div:nth-child(5) > div:nth-child(2) > textarea")
	private WebElement urlCTA;
	
	@FindBy(css="#collapseGeneral > div > div:nth-child(1) > div:nth-child(2) > select.form-control.ng-untouched.ng-pristine.ng-invalid")
	private WebElement selectProduct;
	
	@FindBy(css="#collapseGeneral > div > div:nth-child(3) > div.form-group.col > ng-multiselect-dropdown.ng-untouched.ng-dirty.ng-invalid > div > div:nth-child(1) > span.dropdown-btn>span:nth-child(1)")
	private WebElement selectRegion;
	
	@FindBy(css="#collapseGeneral > div > div:nth-child(3) > div.form-group.col > ng-multiselect-dropdown.ng-untouched.ng-dirty.ng-invalid > div > div.dropdown-list > ul.item1 > li.multiselect-item-checkbox > div")
	private WebElement clickOnCheckBox;
	
	@FindBy(xpath="//*[@id=\"file\"]")
	private WebElement uploadImg;
	
	//@FindBy(xpath="/html/body/app-root/section/app-dashboard-home/div/div/div[2]/application-create/div/div[1]/form/div[1]/div/div[2]/div/span")
	@FindBy(xpath="//span[contains(.,'Profile Questionnaire')]")
	private WebElement collapseProfileQA;
	
	@FindBy(xpath="(//input[@name='question_1'])[2]")
	private WebElement questionOne;
	
	@FindBy(xpath="(//input[@name='question_2'])[2]")
	private WebElement questionSecond;
	
	@FindBy(xpath="(//input[@name='question_3'])[2]")
	private WebElement questionThird;
	
	@FindBy(xpath="(//input[@name='question_5'])[2]")
	private WebElement questionFourth;
	
	@FindBy(css=".app-create-form .card:nth-child(3) > .card-header > span")
	private WebElement addInformation;
	
	@FindBy(xpath="//*[@id=\"collapseGeneral\"]/div/div[4]/div/ng-multiselect-dropdown/div[@class='multiselect-dropdown']/div/span/span[1]")
	private WebElement clickTag;
	
	/*
	 * @FindBy(
	 * xpath="//div[@id='Application Information']//form[@class='ng-untouched ng-dirty ng-invalid']//div//div[@class='col-12']//div[@class='card accordianCard']//div[@id='collapseAdditional']//div//div[@class='row']//div[@class='form-group col-6']//ng-multiselect-dropdown//div[@class='multiselect-dropdown']//div[@class='dropdown-list']//ul[@class='item1']//li[@class='multiselect-item-checkbox']//input"
	 * ) private WebElement selectTag;
	 */

	@FindBy(xpath="//*[@id=\"collapseGeneral\"]/div/div[4]/div/ng-multiselect-dropdown/div[@class='multiselect-dropdown']/div[@class='dropdown-list']/ul[@class='item1']/li[@class='multiselect-item-checkbox']/input")
	private WebElement selectTag;
	
	@FindBy(xpath="/html/body/app-root/section/app-dashboard-home/div/div/div[2]/application-create/div/div[1]/form/div[2]/button")
	private WebElement submitAppBtn;

	@FindBy(css="div.alert.alert-dismissable.alert-success>div.p-3>p.p-0")
	private WebElement successMessage;
	
	@FindBy(xpath="//*[@id=\"collapseAdditional\"]/div/div[2]/div/textarea")
	private WebElement comment;
	
	@FindBy(xpath="/html/body/app-root/section/app-dashboard-home/div/div/div[2]/application-create/div/div[1]/form/div[1]/div/div[3]/div[2]/div/div[1]/div[1]/ng-multiselect-dropdown/div/div[2]")
	private WebElement selectAll;
	
	@FindBy(xpath="//div[@class='app-create-form']//form[@name='form']//div[@class='row']//div[@class='col-12']//div[@class='card accordianCard']//div[@id='collapseGeneral']//div//div[@class='row']//div[@class='form-group col']//ng-multiselect-dropdown[@name='region']//div[@class='multiselect-dropdown']//div[@class='dropdown-list']")
	private WebElement removeHiddenEle;
	
	@FindBy(xpath="//*[@id=\"collapseGeneral\"]/div/div[4]/div/ng-multiselect-dropdown/div[@class='multiselect-dropdown']/div[@class='dropdown-list']")
	private WebElement removeHiddenTagEle;
	
	@FindBy(xpath="//div[@class='companyRecords']//h4")
	private WebElement companyRecord;
	
	@FindBy(xpath="//tr[@class='ng2-smart-row selected']//app-render-component//span")
	private WebElement appName;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement editAppDescription;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitEditBtn;
	
	@FindBy(xpath="//th[7]/ng2-smart-table-filter/div/default-table-filter/select-filter/select")
	private WebElement pendingStatus;
	
	@FindBy(xpath="/html/body/app-root/section/app-dashboard-home/div/div/div[2]/application-list/div/div/div/ng2-smart-table/table/tbody/tr/td/ng2-smart-table-cell/table-cell-view-mode/div/custom-view-component/app-render-component/span")
	private List<WebElement> listOfAllPendingApp;
	
	@FindBy(xpath="//div[@class='tabs-container']//div[@class='w-100']//div[@class='App-details']//div[3]//h4")
	private WebElement status;
	
	@FindBy(xpath="//button[contains(.,'Submit For Testing')]")
	private WebElement submitTesting;
	
	@FindBy(xpath="//button[contains(.,'Approve')]")
	private WebElement clickOnApprove;
	
	@FindBy(xpath="//button[contains(.,'Confirm')]")
	private WebElement clickOnConfirmButton;
	
	@FindBy(xpath="//button[contains(.,'Delete')]")
	private WebElement clickOnDelete;
	
	@FindBy(css="div.alert.alert-dismissable.alert-success>div.p-3>p.p-0")
	private WebElement successMssgSubmitTesting;
	
	public AppRegistrationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	public void clickOnDashboard() {
		Commonactions.waitForElement(getDriver(), selectAccountDashboard);
		Commonactions.click(getDriver(), selectAccountDashboard);
		

	}


	public Boolean isAddLinkDisplay() {
		Commonactions.pageLoadTimeOut(getDriver(), 20);
		return Commonactions.waitForElement(getDriver(), addApplicationLink).isDisplayed();
		// TODO Auto-generated method stub
		
	}


	public void clickOnAddApplication() {
		
		//Commonactions.waitForElement(getDriver(), addApplicationLink);
		Commonactions.explicitWait(getDriver(), companyRecord, 20);
		Commonactions.click(getDriver(), addApplicationLink);
	}
	
	public void clickOnAppRegistration() {

		//Commonactions.waitForElement(getDriver(), addAppRegistration);
		Commonactions.explicitWait(getDriver(), companyRecord, 20);
		Commonactions.click(getDriver(), addAppRegistration);
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
		Commonactions.type(userName, email);

	}

	/**
	 * enter password
	 * @param pass 
	 */
	public void enterPassword(String passWord) {
		Commonactions.waitForElement(getDriver(), password);
		Commonactions.type(password, passWord);

		
	}

	/**
	 * click on submit btn
	 */
	public void clickSubmitBtn() {
		Commonactions.waitForElement(getDriver(), submitBtn);
		Commonactions.click(getDriver(), submitBtn);

	}


	/**
	 * click on login btn with user name
	 */

	public void clickBtnlogin() {
		Commonactions.waitForElement(getDriver(), userNameBtn);
		Commonactions.clickingElementJS(getDriver(), userNameBtn);

	}


	public void enterAppName(String appName) {
		Commonactions.waitForElement(getDriver(), applicationName);
		Commonactions.type(applicationName, appName);

		
	}


	public void enterAppDescription(String appDescription) {
		Commonactions.waitForElement(getDriver(), appText);
		Commonactions.type(appText, appDescription);
		
	}


	public void enterFMISAuthzUrl(String callbackUrl) {
		Commonactions.waitForElement(getDriver(), authzUrl);
		Commonactions.type(authzUrl, callbackUrl);
		
	}


	public void enterFMISLandingPageUrl(String landingPageUrl) {
		Commonactions.waitForElement(getDriver(), urlCTA);
		Commonactions.type(urlCTA, landingPageUrl);
		
	}


	public void selectProduct() {
		Commonactions.selectByVisibleText("AgData", selectProduct);
		
	}


	public void selectRegion() {
		Commonactions.waitForElement(getDriver(), selectRegion);
		Commonactions.click(getDriver(), selectRegion);
		
	}


	public void clickOnCheckboxRegion() {
		
		Commonactions.hiddendDropDownList(getDriver(),removeHiddenEle);
		
		Commonactions.clickingElementJS(getDriver(), clickOnCheckBox);
		
	}
	
	/**
	 * Upload Image: hidden element
	 */

	public void uploadImgIcon() throws Exception {
		Commonactions.UploadHiddenBtn(getDriver(), uploadImg);
		Commonactions.type(uploadImg, System.getProperty("user.dir")+"/src/main/resources/logo.png");
		
				
	}


	public void clickOnProfileQA() {
		Commonactions.moveToElement(getDriver(), collapseProfileQA);
		Commonactions.clickingElement(getDriver(), collapseProfileQA);
		
	}


	public void clickOnQuetsionFirst() {
		Commonactions.moveToElement(getDriver(), questionOne);
		Commonactions.clickingElement(getDriver(), questionOne);
		
	}


	public void clickOnQuestionSecond() {
		Commonactions.moveToElement(getDriver(), questionSecond);
		Commonactions.clickingElement(getDriver(), questionSecond);
	}


	public void clickOnQuestionThird() {
		Commonactions.moveToElement(getDriver(), questionThird);
		Commonactions.clickingElement(getDriver(), questionThird);
	}
	
	public void clickOnQuestionFourth() {
		Commonactions.moveToElement(getDriver(), questionFourth);
		Commonactions.clickingElement(getDriver(), questionFourth);
	}


	public void clickOnAdditionalInformation() {
		Commonactions.moveToElement(getDriver(), addInformation);
		Commonactions.clickingElement(getDriver(), addInformation);
	}


	public void clickOnSelectTag() {
		Commonactions.moveToElement(getDriver(), clickTag);
		Commonactions.clickingElementJS(getDriver(), clickTag);
		
	}


	public void selectAllTag() throws Exception {
		//Commonactions.moveToElement(getDriver(), selectTag);
		Commonactions.hiddendDropDownList(getDriver(), removeHiddenTagEle);
		Thread.sleep(20000);
		Commonactions.clickingElementJS(getDriver(), selectTag);
		
	}


	public void clickOnSubmit() {
		Commonactions.moveToElement(getDriver(), submitAppBtn);
		Commonactions.clickingElement(getDriver(), submitAppBtn);
		
	}


	public String getSuccessMessage() {
		Commonactions.waitForElement(getDriver(), successMessage);
		return Commonactions.getText(successMessage);
	}


	public void enterComment(String commentMessage) {
		Commonactions.moveToElement(getDriver(), comment);
		Commonactions.type(comment, commentMessage);
		
	}


	public Boolean isAppLinkDisplay() {
		
		return Commonactions.waitForElement(getDriver(), addAppRegistration).isDisplayed();
	}


	public void clickOnAppName() {
		
		Commonactions.waitForElement(getDriver(), appName);
		Commonactions.click(getDriver(), appName);
		
	}


	public void isDescriptionDisplay(String editDescription) {

		Commonactions.pageLoadTimeOut(getDriver(), 20);
		boolean actual = Commonactions.waitForElement(getDriver(), editAppDescription).isDisplayed();

		if (actual == true) {
			Commonactions.type(editAppDescription, editDescription);

		} else {
			System.out.println("element not display: Description Box");
		}

	}


	public void clickOnSubmitBtn() {
		
		Commonactions.moveToElement(getDriver(), submitEditBtn);
		Commonactions.clickingElementJS(getDriver(), submitEditBtn);
		
	}


	public String getSuccessUpdateMessage() {
		Commonactions.waitForElement(getDriver(), successMessage);
		return Commonactions.getText(successMessage);
	}


	public void selectPendingStatus() {
		Commonactions.waitForElement(getDriver(), pendingStatus);
		Commonactions.selectByValue(pendingStatus, "Pending");
		
	}
	
	public void selectApprovalStatus() {
		Commonactions.waitForElement(getDriver(), pendingStatus);
		Commonactions.selectByValue(pendingStatus, "In Testing");
		
	}


	public void clickOnPendingApp() {
		
		Commonactions.waitForElement(getDriver(), appName);
		Commonactions.click(getDriver(), appName);
		/*
		 * List<WebElement> lis=Commonactions.waitForElements(getDriver(),
		 * listOfAllPendingApp);
		 * 
		 * for(WebElement e : lis) { System.out.println(e.getText());
		 * 
		 * }
		 */
		
	}


	public void isStatusDisplayPending() {
		
		Commonactions.pageLoadTimeOut(getDriver(), 20);
		boolean actual = Commonactions.waitForElement(getDriver(), status).isDisplayed();

		if (actual == true) {
			System.out.println("Application status is Pending click on Submit for Testing");

		} else {
			System.out.println("Status is not present for this registered app");
		}

		
	}


	public void clickOnSubmitForTesting() {
		Commonactions.waitForElement(getDriver(), submitTesting);
		Commonactions.click(getDriver(), submitTesting);
		
	}
	
	public void clickOnApproveButton() {
		Commonactions.waitForElement(getDriver(), clickOnApprove);
		Commonactions.click(getDriver(), clickOnApprove);
		
	}


	public String getSuccessSubmitTestingMsg() {
		Commonactions.waitForElement(getDriver(), successMssgSubmitTesting);
		return Commonactions.getText(successMssgSubmitTesting);
	}


	public void clickOnConfirmButton() {
		Commonactions.waitForElement(getDriver(), clickOnConfirmButton);
		Commonactions.click(getDriver(), clickOnConfirmButton);
		
	}


	public void clickOnDeleteBtn() {
		Commonactions.waitForElement(getDriver(), clickOnDelete);
		Commonactions.click(getDriver(), clickOnDelete);
		
	}
}
