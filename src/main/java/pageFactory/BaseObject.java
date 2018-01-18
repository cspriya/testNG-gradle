package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class BaseObject {

    public DecimalFormatSymbols separatorSymbol;
    public DecimalFormat df;
    public DecimalFormat df3;
    public DecimalFormat dftz;

    protected WebDriver driver;

    public BaseObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        separatorSymbol = new DecimalFormatSymbols();
        separatorSymbol.setDecimalSeparator('.');
        df = new DecimalFormat("0.00", separatorSymbol);
        df3 = new DecimalFormat("0.000", separatorSymbol);
        dftz = new DecimalFormat("0.###", separatorSymbol);
    }
}
