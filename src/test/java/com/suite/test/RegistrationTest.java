package com.suite.test;

import com.suite.base.Base;
import com.suite.dataprovider.Dataproviders;
import com.suite.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends Base {

    RegistrationPage registerPage;

    @Test(dataProvider = "CreateAccount", dataProviderClass = Dataproviders.class)
    public void registerNewUser(String firstName,String lastName, String email, String password, String confirmPass) throws InterruptedException {
        registerPage = new RegistrationPage();
        String mailAddress = "email+" + System.currentTimeMillis() + "@mailinator.com";
        registerPage.clickOnCreateAccount();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmailAddress(mailAddress);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPass);
        registerPage.clickOnCreateAnAccount();
        registerPage.isMyAccountDisplay();

        String actual = registerPage.getVerifyName();
        System.out.println(actual);

        /*String expected= "Welcome, " + firstName + " " +lastName + "!";
        System.out.println(expected);*/

        Assert.assertEquals(actual,"Welcome, ABC Testt!");
    }


}
