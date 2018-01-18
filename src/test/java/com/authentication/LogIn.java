package com.authentication;

/**
 * Created by N.Khmurych on 09.06.2017.
 */

import com.Abstract;
import org.testng.annotations.Test;
import testData.dataProvider.DataProviders;

import java.io.IOException;

public class LogIn extends Abstract {

    @Test(priority = 1)
    public void tryLogin() throws IOException {
        handler.openPage(testData.URL);
        logIn.checkLoginPage(testData.URL, testData.MAIN_PAGE_TITLE);
        logIn.switchToLoginForm();
        logIn.logIn(LOGIN, PASSWORD);
        logIn.logOut();
        handler.waitForElementDisplayed(logIn.accountLogin);
    }

    @Test(priority = 2)
    public void tryCloseLoginForm() {
        logIn.switchToLoginForm();
        handler.clickOnElement(testData.closeAuthForm);
    }

    @Test(priority = 3, dataProvider = "testLoginBlank", dataProviderClass = DataProviders.class)
    public void testRequiredFields(String login, String pass) {
        logIn.switchToLoginForm();
        logIn.logInFormValidation(
                login,
                pass,
                messages.errorSummaryBlank,
                messages.errorLoginTitleElement,
                testData.attrOriginalTitle,
                messages.errorTitleBlank
        );
    }

    @Test(priority = 4, dataProvider = "testLoginIncorrect", dataProviderClass = DataProviders.class)
    public void testIncorrectValues(String login, String pass) {
        logIn.switchToLoginForm();
        logIn.logInFormValidation(
                login,
                pass,
                messages.errorSummaryIncorrect,
                messages.errorLoginTitleElement,
                testData.attrTitle,
                messages.errorTitleIncorrect
        );
    }

    @Test(priority = 5)
    public void testIncorrectPassword() {
        logIn.switchToLoginForm();
        logIn.logInFormValidation(
                LOGIN,
                PASSWORD + "1",
                messages.errorSummaryWrongPass,
                messages.errorLoginTitleElement,
                testData.attrTitle,
                messages.errorTitleIncorrect
        );

    }

    @Test(priority = 6)
    public void testIncorrectUserName() {
        logIn.switchToLoginForm();
        logIn.logInFormValidation(
                logIn.incorrectLOGIN,
                PASSWORD,
                messages.errorSummaryBlank,
                messages.errorLoginTitleElement,
                testData.attrTitle,
                messages.errorTitleWrongUserName
        );
    }

    @Test(priority = 7)
    public void testBigValues() {
        logIn.switchToLoginForm();
        logIn.logInFormValidation(
                handler.randomString(testData.fieldsUnLimit),
                handler.randomString(testData.fieldsUnLimit),
                messages.errorSummaryIncorrect,
                messages.errorLoginTitleElement,
                testData.attrTitle,
                messages.errorTitleIncorrect
        );
    }

}