package utils.Browsers;

/**
 * Created by N.Khmurych on 09.06.2017.
 */

import com.Abstract;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class UseBrowser extends Abstract{

//    public static void getChrome() {
//        ChromeDriverManager.getInstance().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments(
//                "--no-sandbox",
//                "--window-size=1920,1080",
//                "--disable-extensions"
//        );
//
//        driver = new ChromeDriver(options);
//    }
//
//    public static void getFireFox() {
//        FirefoxDriverManager.getInstance().setup();
//        final FirefoxProfile firefoxProfile = new FirefoxProfile();
//        firefoxProfile.setPreference(
//                "xpinstall.signatures.required",
//                false
//        );
//
//        driver = new FirefoxDriver(firefoxProfile);
//    }
//
//    public static void getIE() {
//        InternetExplorerDriverManager.getInstance().setup();
//
//        driver = new InternetExplorerDriver();
//    }
//
//    public static void getOpera() {
//        OperaDriverManager.getInstance().version("2.27").setup();
//
//        OperaOptions operaOptions = new OperaOptions();
//        operaOptions.setBinary("/usr/bin/opera");
//        System.setProperty(
//                "webdriver.opera.driver",
//                "build/webdriver/operadriver/linux64/2.27/operadriver_linux64/operadriver"
//        );
//        driver = new OperaDriver(operaOptions);
//    }
//
//    public static void getEdge() {
//        EdgeDriverManager.getInstance().setup();
//
//        driver = new EdgeDriver();
//    }
}
