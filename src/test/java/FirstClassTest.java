import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class FirstClassTest {

    @Test
    public void testSearchGoogle(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1800, 900));
        driver.manage().window().setPosition(new Point(100, 55));

//        driver.get("http://www.google.com");
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ибонех");
//        searchBox.submit();

        driver.get("https://github.com/null-nvrsk");
//        Cookie authCookie = new Cookie("user_session", "RVZCkyPzULbQxSNkACqiBDdln-7SNB0CElQp4mqFmbAQv-a9");
//        driver.manage().addCookie(authCookie);
//        driver.navigate().refresh();

//        Set<Cookie> cookies = driver.manage().getCookies();
//        System.out.println("cookies = " + cookies);

//        Cookie tzCookie = driver.manage().getCookieNamed("tz");
//        System.out.println("tz - " + tzCookie);

        driver.manage().deleteCookieNamed("tz");
        System.out.println("deleteOneCookie - " + driver.manage().getCookies());

        driver.manage().deleteAllCookies();
        System.out.println("allCookies - " + driver.manage().getCookies());

//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
        System.out.println("getSize = " + driver.manage().window().getSize());
        System.out.println("getPosition = " + driver.manage().window().getPosition());

        Set<String> allLogsType = driver.manage().logs().getAvailableLogTypes();
        System.out.println("allLogsType = " + allLogsType);

        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logs)
            System.out.println("logs = " + entry);

        driver.quit();
    }

    @Test
    public void testFacebookLogin(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.facebook.com/login/");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginbutton']"));
        loginButton.click();

//        WebElement signupLink = driver.findElement(By.xpath("//a[contains(@href,'r.php')]"));
//        signupLink.click();

        driver.quit();
    }

    @Test
    public void testHiddenModalDialog(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1800, 900));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/hidden");
        driver.switchTo().frame("frame_examples");

        WebElement buttonOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okButton']")));
        buttonOk.click();

        WebElement textWelcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='awesome']/h1")));
        Assert.assertEquals("Thanks!", textWelcome.getText());

        driver.quit();
    }

    @Test
    public void testJavascriptInfoAlert(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://javascript.info/alert-prompt-confirm");

        // alert
        WebElement runButton = driver.findElement(By.xpath("(//a[@data-action='run'])[1]"));
        runButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        runButton.click();
        System.out.println("Text from alert = " + alert.getText());
        alert.accept();

        // confirm
        WebElement confirmButton = driver.findElement(By.xpath("(//a[@data-action='run'])[5]"));
        confirmButton.click();

        Alert confirm = driver.switchTo().alert();
        confirm.dismiss();
        confirm.accept();

        // prompt
        WebElement promptButton = driver.findElement(By.xpath("(//a[@data-action='run'])[2]"));
        promptButton.click();

        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("123");
        confirm.accept();
        confirm.accept();

        driver.quit();
    }

    @Test
    public void testIframe(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // <label for="SeleniumCourse">number of lecture</label>
        // <input type="number" id="seleniumId" min="10" max="100">
        driver.get("https://jsbin.com/bigubugosu/edit?html,output");

        WebElement mainFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='stretch']")));
        driver.switchTo().frame(mainFrame);

        WebElement childFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name='JS Bin Output ']")));
        driver.switchTo().frame(childFrame);

        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='seleniumId']")));
        inputField.sendKeys("66");

        driver.quit();
    }
}
