package PhucTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaiTapTuan1 {

    @Test
    public void  OpenTGDD () {
        System.out.println("Start");
        WebDriver driver;

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        //System.out.println("Mở trang: ");
        String S = "Mở trang: ";
        driver.get("https://www.thegioididong.com/");
        System.out.println(S + driver.getTitle());
        System.out.println("--> Tìm phần khung search");
        WebElement a = driver.findElement(By.id("skw"));
        System.out.println("--> Click vào khung search");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        a.click();
        System.out.println("--> Nhập từ khoá tìm kiếm: iphone");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        a.sendKeys("iphone");
        WebElement b = driver.findElement(By.className("icon-search"));
        System.out.println("--> Click tìm kiếm");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        b.submit();
        WebElement c = driver.findElement(By.partialLinkText("14"));
        String T1 = c.getText();
        System.out.println("--> Lọc " + T1);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        c.click();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.quit();
        System.out.println("Đóng trình duyệt google chrome");
    }
}
