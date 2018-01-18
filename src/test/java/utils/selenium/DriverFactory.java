package utils.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
	public WebDriver webdriver;

	public final String operatingSystem = System.getProperty("os.name").toUpperCase();
	public final String systemArchitecture = System.getProperty("os.arch");

	public WebDriver getDriver(String browser) throws Exception {
		if (null == webdriver) {
			instantiateWebDriver(browser);
		}
		webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		return webdriver;
	}

	public void quitDriver(WebDriver driver) {
		if (null != driver) {
			driver.quit();
		}
	}

	public final String[][] proxyList = new String[][]{
				{"276", "5.9.28.243", "3128", "Germany"},
				{"840", "149.56.6458", "80", "USA"}
};

	public void instantiateWebDriver(String browser) throws MalformedURLException {
		System.out.println(" ");
		System.out.println("Current Operating System: " + operatingSystem);
		System.out.println("Current Architecture: " + systemArchitecture);
		System.out.println(" ");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		switch (browser) {
			case "Firefox":
				FirefoxDriverManager.getInstance().setup();
				final FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("xpinstall.signatures.required",false);

				webdriver = new FirefoxDriver(firefoxProfile);
				break;

			case "Firefox with proxy":
				System.out.println("I'm here ==================================== ");
				FirefoxDriverManager.getInstance().setup();
				final FirefoxProfile ffProxyProfile = new FirefoxProfile();
				ffProxyProfile.setPreference("xpinstall.signatures.required",false);
				ffProxyProfile.setPreference("network.proxy.type", 1);
				ffProxyProfile.setPreference("network.proxy.http", "103.253.211.219");
				ffProxyProfile.setPreference("network.proxy.http_port", 53281);
				ffProxyProfile.setPreference("network.proxy.ssl", "103.253.211.219");
				ffProxyProfile.setPreference("network.proxy.ssl_port", 53281);

				webdriver = new FirefoxDriver(ffProxyProfile);
				System.out.println("I'm here ==================================== ");
				break;

			case "IE":
				InternetExplorerDriverManager.getInstance().setup();

				webdriver = new InternetExplorerDriver();
				break;

			case "Opera":
				OperaDriverManager.getInstance().version("2.27").setup();

				OperaOptions operaOptions = new OperaOptions();
				operaOptions.setBinary("/usr/bin/opera");
				System.setProperty(
						"webdriver.opera.driver",
						"build/webdriver/operadriver/linux64/2.27/operadriver_linux64/operadriver"
				);
				webdriver = new OperaDriver(operaOptions);
				break;

			default :
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ChromeDriverManager.getInstance().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments(
						"--no-sandbox",
						"--window-size=1920,1080",
						"--disable-extensions",
						"--ignore-certificate-errors"
//						"--proxy-server=http://" + "54.167.184.222:3128"
				);

				webdriver = new ChromeDriver(capabilities);
				break;
		}
	}
}