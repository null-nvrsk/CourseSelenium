import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class FirstClassTest {

    @Test
    public void testSearchGoogle(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

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

        driver.quit();
    }
}
