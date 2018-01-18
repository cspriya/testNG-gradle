package helpers;
/**
 * Created by N.Khmurych on 09.06.2017.
 */

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.If;
import org.python.jline.internal.Log;
import pageFactory.BaseObject;
import testData.TestData;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.beans.ExceptionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Handler extends BaseObject{

    private TestData testData = new TestData(driver);

    private Logger logger = Logger.getLogger(Log.class.getName());

    private Integer numberTabToSwitch = 0;

    private static final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String emailLexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String numbers = "0123456789";
    private final java.util.Random rand = new java.util.Random();

    public String randomString(Integer length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(lexicon.charAt(rand.nextInt(lexicon.length())));
        }
        return sb.toString();
    }

    public String getRandomValue(String[] array) {
        return array[rand.nextInt(array.length)];
    }

    public String getRandomEmail() {
        StringBuilder sb = new StringBuilder();
        StringBuilder domain = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(emailLexicon.charAt(rand.nextInt(emailLexicon.length())));
        }
        for (int i = 0; i < 4; i++) {
            domain.append(lexicon.charAt(rand.nextInt(lexicon.length())));
        }

        return sb.toString().toLowerCase() + "@" + domain.toString().toLowerCase() + ".com";
    }

    /*From 1 to max*/
    public Integer randomNumber(Integer max) {
        return (int)(Math.random()*max+1);
    }

    /*From 0 to max*/
    public Integer randomInt(Integer max) {
        return rand.nextInt(max);
    }

    /*From 0 to max*/
    public String randomLongNumber(Integer length) {
        StringBuilder phoneNumber = new StringBuilder();
        Integer i=0;
        while (i < length) {
            phoneNumber.append(rand.nextInt(numbers.length()));
            i++;
        }
        return phoneNumber.toString();

    }

    public Integer countOfChildNodes(String xpath) {
        driver.manage().timeouts().implicitlyWait(0, SECONDS);
        List<WebElement> allElements = driver.findElements(By.xpath(xpath));
        return allElements.size();
    }

    public WebElement getRandomElement(String xpath) {
        Integer randomIndex = this.randomInt(this.countOfChildNodes(xpath));
        WebElement elements[] = driver.findElements(By.xpath(xpath)).toArray(new WebElement[0]);
        return elements[randomIndex];
    }

    public WebElement[] getAllElements(String xpath) {
        return driver.findElements(By.xpath(xpath)).toArray(new WebElement[0]);
    }

    public WebElement findElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findRandomElement(String xpath, Integer index) {
        WebElement elements[] = driver.findElements(By.xpath(xpath)).toArray(new WebElement[0]);
        return elements[index];
    }

    private void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    private Integer getHttpStatus(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        return connection.getResponseCode();

    }

    public void openPage(String url) throws IOException {
        deleteCookies();
        driver.get(url);
        Assert.assertEquals(Integer.valueOf("200"), getHttpStatus(url));
    }

    public void openNewPage(String url) {
        driver.get(url);
    }

    public void checkCurrentUrl(String url) {
        waitForPageLoad(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void checkUrl(String url, String title) {
        WebDriverWait wait = new WebDriverWait(driver, 30, 2000);
        wait.until(ExpectedConditions.urlToBe(url));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void changeUrl(String newURL) {
        driver.get(driver.getCurrentUrl() + newURL);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void findAndClick(String xpath) {
        clickOnElement(findElement(xpath));
    }


    public void clickAndWaitForJQuery(WebElement element) {
        waitForElementDisplayed(element);
        element.click();
        waitForJQuery();
    }

    public void switchTo(WebElement element) {
        driver.switchTo().window(driver.getWindowHandle());
        this.waitForElementDisplayed(element);
    }

    public boolean waitForElementDisplayed(WebElement element) {
        boolean resultFlag = false;
        for (int second = 0; second <= 1; second++) {
            if (second > 1) {
                this.sleepTest(1);
            }
            try {
                if (element.isDisplayed() && element.isEnabled()) {
                    resultFlag = true;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultFlag;
    }

    public boolean waitWhileElementDisplayed(String xpath) {
        boolean resultFlag = false;
        for (int second = 0; second <= 30; second++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 1);
                resultFlag = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
                if (resultFlag) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultFlag;

    }

    public boolean waitForPageLoad(String url) {
        boolean resultFlag = false;
        for (int second = 0; second <= 30; second++) {
            if (second > 0) {
                sleepTest(1);
            }
            if (this.driver.getCurrentUrl().equals(url)) {
                resultFlag = true;
                break;
            }
        }
        return resultFlag;
    }

    public void checkElementHasText(WebElement element, String text) {
        Assert.assertEquals(this.waitForElementDisplayed(element), true);
        String value = element.getText();
        Assert.assertEquals(value, text);
    }

    public void typeToField(WebElement element, String text) {
        waitForElementDisplayed(element);
        element.clear();
        element.sendKeys(text);
    }

    public void mouseOverOnElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void mouseOverAndCheck(WebElement elementTarget, WebElement elementAppeared) {
        Actions action = new Actions(driver);
        action.moveToElement(elementTarget).build().perform();
        this.waitForElementDisplayed(elementAppeared);
    }

    public void sleepTest(int timeInSeconds) {
        try {
            SECONDS.sleep(timeInSeconds);
        } catch (InterruptedException ex) {
            System.err.println("An InterruptedException was caught: " + ex.getMessage());
        }
    }

    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public String getElementText(WebElement element) {
        return element.getAttribute("innerText");
    }

    public String getText(WebElement element) {
        Assert.assertEquals(assertWebElementExists(element), true);
        return element.getText();
    }

    public String getSelectorInnerHTML(String selector) {
        return driver.findElement(By.xpath(selector)).getAttribute("innerHTML");
    }

    public String getSelectorText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public void assertAttributeHasValue(WebElement element, String attribute, String value) {
        Assert.assertEquals(getAttributeValue(element, attribute), value);
    }

    public void assertElementHasText(WebElement element, String text) {
        Assert.assertEquals(text, element.getText());
    }

    public void assertNotEqualsIntegers(Integer intBefore, Integer intAfter) {
        Assert.assertNotEquals(intBefore, intAfter);
    }

    public void assertElementIsEnabled(String xpath) {
        Assert.assertEquals(driver.findElement(By.xpath(xpath)).isEnabled(), true);
    }

    public void assertElementIsDisabled(String xpath) {
        Assert.assertEquals(driver.findElement(By.xpath(xpath)).isEnabled(), false);
    }

    public void assertElementIsNotDisplayed(WebElement element) {
        Assert.assertFalse(element.isDisplayed());
    }

    public boolean assertElementIsDisplayed(String selector) {
        return driver.findElement(By.xpath(selector)).isDisplayed();
    }

    public void scrollPage(String selector) {
        WebElement element = driver.findElement(By.xpath(selector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void refreshPage() {
        this.driver.navigate().refresh();
    }

    public void stopPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return window.stop");
    }

    public void waitForJQuery() {
        try {
            this.waitForJQueryStart();
            this.waitForJQueryEnd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean waitForJQueryEnd() {
        return new WebDriverWait(driver, 2).until((ExpectedCondition<Boolean>) driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            assert js != null;
            return (Boolean) js.executeScript("return jQuery.active == 0");
        });
    }

    public Boolean waitForJQueryStart() {
        return new WebDriverWait(driver, 2).until((ExpectedCondition<Boolean>) driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            assert js != null;
            return (Boolean) js.executeScript("return jQuery.active == 1");
        });
    }

    public boolean assertElementExists(String xpath) {
        Boolean result;
        try {
            driver.manage().timeouts().implicitlyWait(0, SECONDS);
            driver.findElement(By.xpath(xpath)).isDisplayed();
            result = true;
        } catch (NoSuchElementException ex) {
            result = false;
        }
        return result;
    }

    public boolean assertWebElementExists(WebElement element) {
        Boolean result = false;
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                result = true;
            }
        } catch (NoSuchElementException ex) {
            logger.trace("------ WebElement --" + element + "------not found------- " + ex);
        }
        return result;
    }

    public boolean assertElementNotExists(String xpath) {
        Boolean bool = false;
        try {
            driver.manage().timeouts().implicitlyWait(0, SECONDS);
            driver.findElement(By.xpath(xpath)).isDisplayed();
            bool = false;
        } catch (NoSuchElementException ex) {
            bool = true;
        }
        return bool;
    }

    public void tabHandler(String job) {
        try {
            Robot action = new Robot();
            switch (job) {
                case "open":
                    numberTabToSwitch++;
                    action.keyPress(KeyEvent.VK_CONTROL);
                    action.keyPress(KeyEvent.VK_T);
                    action.keyRelease(KeyEvent.VK_CONTROL);
                    action.keyRelease(KeyEvent.VK_T);
                    this.switchToTab(numberTabToSwitch);
                    openPage(testData.URL);
                    checkCurrentUrl(testData.URL);
                    break;
                case "close":
                    numberTabToSwitch--;
                    action.keyPress(KeyEvent.VK_CONTROL);
                    action.keyPress(KeyEvent.VK_W);
                    action.keyRelease(KeyEvent.VK_CONTROL);
                    action.keyRelease(KeyEvent.VK_W);
                    this.switchToTab(numberTabToSwitch);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void switchToTab (Integer tabNumber) {
        int i=0;
        while (i< 30){
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            if (tab.size() > tabNumber) {
                driver.switchTo().window(tab.get(tabNumber));
                break;
            }
            sleepTest(1);
            i++;
        }
    }

    public Handler(WebDriver driver) {
        super(driver);
    }

}