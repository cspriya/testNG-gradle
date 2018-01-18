package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by N.Khmurych on 14.06.2017.
 */
public class ErrorsAndMessages extends BaseObject{

    public ErrorsAndMessages(WebDriver driver) {
        super(driver);
    }

    public final String errorSummaryBlank = "Please, fill in all the required fields correctly. Thank you!";
    public final String errorSummaryIncorrect = "Incorrect username or password";
    public final String errorSummaryWrongPass =
            "The password you’ve entered is not valid. To restore it click Forgot Password? link.";



    public final String errorTitleBlank = "This field cannot be blank";
    public final String errorTitleIncorrect = "Incorrect username or password";
    public final String errorTitleWrongUserName = "Incorrect username";


//    LOGIN

    @FindBy(xpath = "//form[@class='styled-form login ajax_form']/table/descendant::input[contains(@class,'error')]")
    public WebElement errorLoginTitleElement;

    @FindBy(xpath = "//div[@class='form-summary error']")
    public WebElement summaryError;

}
