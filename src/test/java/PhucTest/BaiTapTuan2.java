package PhucTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaiTapTuan2 {

    Select select;

    WebDriver driver;
    @Test
    public void  OpenTGDD () {
        System.out.println("Start");

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
        /*------------------------ Phần làm mới -----------------------------*/
        WebElement e = driver.findElement(By.xpath("//img[@alt='iPhone 14 Pro Max 128GB']"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        e.click();

        WebElement f = driver.findElement(By.xpath("//a[normalize-space()='MUA NGAY']"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        f.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"body > section:nth-child(7) > div:nth-child(5) > div:nth-child(2) > div:nth-child(3) > div:nth-child(4) > div:nth-child(10) > section:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(3) > li:nth-child(2) > i:nth-child(2)\").click()");

        WebElement g = driver.findElement(By.xpath("//button[contains(text(),'Đặt mua')]"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        g.click();

        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        WebElement h = driver.findElement(By.xpath("(//i[@class='cartnew-choose'])[1]"));
        h.click();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input#cusName")).sendKeys("IT test");
        driver.findElement(By.cssSelector("input#cusPhone")).sendKeys("0938727300");

        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        select = new Select(driver.findElement(By.xpath("//form[@class='active']//button[@type='button'][contains(text(),'Hồ Chí Minh')]")));
        select.selectByVisibleText("Bình Dương");




        /*driver.quit();
        System.out.println("Đóng trình duyệt google chrome");*/
    }
}
