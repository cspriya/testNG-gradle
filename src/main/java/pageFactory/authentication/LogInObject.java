package pageFactory.authentication;

import helpers.Handler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.BaseObject;
import pageFactory.ErrorsAndMessages;
import testData.TestData;

/**
 * Created by N.Khmurych on 09.06.2017.
 */
public class LogInObject extends BaseObject {

    private Handler handler = new Handler(driver);
    private ErrorsAndMessages messages = new ErrorsAndMessages(driver);
    private TestData testData = new TestData(driver);

    public final String incorrectLOGIN = "n.khmu rych";

    @FindBy(className = "login")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='ui-lightbox-container']")
    public WebElement loginForm;

    @FindBy(name = "login[username]")
    public WebElement loginField;

    @FindBy(xpath = "//ul[@class='submenu shadow account-dropdown']/li/a[contains(text(),'Log out')]")
    public WebElement logOut;

    @FindBy(name = "login[password]")
    public WebElement passwordField;

    @FindBy(xpath = "//form[@class='styled-form login ajax_form']/descendant::button[contains(text(),'Login')]")
    public WebElement logInButton;

    @FindBy(xpath = "//ul[@class='menu']/li/a[contains(@class,'account')]")
    public WebElement accountDropDown;

    @FindBy(xpath = "//li[@class='menu-item account-name']/a")
    public WebElement accountLogin;

    @FindBy(xpath = "//div[@class='ui-lightbox-container']/descendant::a[text()='Login']")
    public WebElement loginTab;


    public void checkLoginPage(String url, String loginPageTitle) {
        handler.checkUrl(url, loginPageTitle);
        handler.waitForElementDisplayed(signInButton);
    }

    public void logOut() {
        handler.mouseOverOnElement(accountDropDown);
        handler.waitForElementDisplayed(logOut);
        handler.clickOnElement(logOut);
    }

    public void logIn(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        handler.clickAndWaitForJQuery(logInButton);

    }

    public void switchToLoginForm() {
        handler.clickOnElement(signInButton);
        handler.switchTo(loginForm);

    }

    public void logInFormValidation(String logInValue, String passwordValue, String summaryErrorText,
                                    WebElement errorTitle, String attribute, String message) {
        handler.typeToField(loginField, logInValue);
        handler.typeToField(passwordField, passwordValue);
        handler.clickOnElement(logInButton);
        handler.mouseOverOnElement(loginField);
        handler.assertAttributeHasValue(errorTitle, attribute, message);
        handler.checkElementHasText(messages.summaryError, summaryErrorText);
        handler.clickOnElement(testData.closeAuthForm);
    }

    public LogInObject(WebDriver driver) {
        super(driver);
    }

}