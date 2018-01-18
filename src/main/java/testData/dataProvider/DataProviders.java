package testData.dataProvider;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import pageFactory.BaseObject;

/**
 * Created by N.Khmurych on 13.06.2017.
 */

public class DataProviders extends BaseObject {

    public DataProviders(WebDriver driver) {
        super(driver);
    }

    @DataProvider(name = "testLoginBlank")
    private static Object[][] testLoginBlank() {
        return new Object[][]{
                {"", ""},
                {"testLogin", ""},
                {"", "testLogin"}
        };
    }

    @DataProvider(name = "testLoginIncorrect")
    private static Object[][] testLoginIncorrect() {
        return new Object[][]{
                {"testLogin", "sgsgsg"},
                {"testLogin", "qwerty123456"},
                {"!@#$%^&*()_+=`~/", "qwerty123456"},
        };
    }

}
