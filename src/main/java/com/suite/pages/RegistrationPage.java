package com.suite.pages;

import com.suite.base.Base;
import com.suite.commonactions.Commonactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends Base {

    @FindBy(linkText="Create an Account")
    private WebElement clickCreateAcc;

    @FindBy(id="firstname")
    private WebElement enterFirstName;

    @FindBy(id="lastname")
    private WebElement enterLastName;

    @FindBy(id="email_address")
    private WebElement enterEmailAddress;

    @FindBy(id="password")
    private WebElement enterPassword;

    @FindBy(id="password-confirmation")
    private WebElement enterConfirmPassword;

    @FindBy(css=".submit")
    private WebElement clickCreateAccountButton;

    @FindBy(xpath="/html/body/div[1]/header/div[1]/div/ul/li[1]")
    private WebElement correctName;

    @FindBy(xpath="//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span")
    private WebElement myAccount;

    public RegistrationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickOnCreateAccount() {
        Commonactions.waitForElement(getDriver(), clickCreateAcc);

        clickCreateAcc.click();

    }

    public void enterFirstName(String firstName) {
        Commonactions.waitForElement(getDriver(), enterFirstName);
        enterFirstName.sendKeys(firstName);

    }

    public void enterLastName(String lastName) {
        Commonactions.waitForElement(getDriver(), enterLastName);
        enterLastName.sendKeys(lastName);

    }

    public void enterEmailAddress(String email) {
        Commonactions.waitForElement(getDriver(), enterEmailAddress);
        enterEmailAddress.sendKeys(email);

    }

    public void enterPassword(String password) {
        Commonactions.waitForElement(getDriver(), enterPassword);
        enterPassword.sendKeys(password);

    }

    public void enterConfirmPassword(String confirmPass) {
        Commonactions.waitForElement(getDriver(), enterConfirmPassword);
        enterConfirmPassword.sendKeys(confirmPass);

    }

    public void clickOnCreateAnAccount() {
        Commonactions.waitForElement(getDriver(), clickCreateAccountButton);

        clickCreateAccountButton.click();

    }
    public Boolean isMyAccountDisplay() {
        Commonactions.pageLoadTimeOut(getDriver(), 120);
        return Commonactions.waitForElement(getDriver(), myAccount).isDisplayed();

    }

    public String getVerifyName() throws InterruptedException {
        Commonactions.waitForElement(getDriver(), correctName);
        return Commonactions.getText(correctName);
    }
}
