package utils.Reporter;

/**
 * Created by N.Khmurych on 12.06.2017.
 */

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import com.Abstract;
import utils.Listners.Listner;

import java.util.Objects;
import java.util.Set;

public abstract class Reporter {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Listner.class);

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((Abstract) currentClass).getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Error log", type = "text/plain")
    public static String getBrowserLog(ITestResult result) {
        StringBuilder trace = new StringBuilder();
        Object currentClass = result.getInstance();
        WebDriver driver = ((Abstract) currentClass).getDriver();
        Set<String> log = driver.manage().logs().getAvailableLogTypes();
        for (String l : log) {
            String str = String.valueOf(driver.manage().logs().get(l).getAll());
            if (str != null && !str.isEmpty() && !Objects.equals(str, "[]")) {
                trace.append(l.toUpperCase()).append(" LOG\n").append(str).append("\n");
            }
        }
        return trace.toString();

    }

}