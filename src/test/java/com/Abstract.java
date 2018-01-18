package com;

import pageFactory.authentication.LogInObject;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pageFactory.ErrorsAndMessages;
import helpers.Handler;
import org.openqa.selenium.WebDriver;
import utils.selenium.DriverManager;
import testData.TestData;
import utils.Listners.Listner;
import utils.selenium.DriverFactory;

import javax.mail.NoSuchProviderException;


/**
 * Created by N.Khmurych on 09.06.2017.
 */
@Listeners(Listner.class)
public class Abstract {

    public String LOGIN;
    public String PASSWORD;

    protected ErrorsAndMessages messages;
    protected Handler handler;
    protected TestData testData;

    protected LogInObject logIn;

    private DriverFactory driverFactory = new DriverFactory();


    public WebDriver getDriver() {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + DriverManager.getDriver().hashCode());
        return DriverManager.getDriver();
    }

    private void initPageFactory() throws NoSuchProviderException {
        handler = new Handler(getDriver());
        messages = new ErrorsAndMessages(getDriver());
        testData = new TestData(getDriver());

        logIn = new LogInObject(getDriver());
    }

    @BeforeClass
    public void setUp(){
        try {
            System.out.println("================================================");
            System.out.println(System.getProperty("browser"));
            System.out.println("================================================");
            DriverManager.setWebDriver(driverFactory.getDriver(System.getProperty("browser")));
            getDriver().manage().window().maximize();
            initPageFactory();
            this.LOGIN = System.getProperty("login");
            this.PASSWORD = System.getProperty("pass");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(ITestContext result) throws Exception {
        WebDriver driver = DriverManager.getDriver();
        driverFactory.quitDriver(driver);

    }
}
