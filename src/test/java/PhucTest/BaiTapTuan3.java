package PhucTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
public class BaiTapTuan3 {
    Select select;
    static Logger log = LogManager.getLogger(BaiTapTuan3.class.getName());
    WebDriver driver;

    @Test
    public void OpenTGDD() {
        try {
            log.info("Start");

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            //System.out.println("Mở trang: ");
            //String S = "Mở trang: ";
            driver.get("https://www.thegioididong.com/");
            driver.manage().window().maximize();
            //driver.get("https://newstaging.thegioididong.com/");
            log.info("Mở trang: " + driver.getTitle());
            log.info("--> Tìm phần khung search");
            WebElement a = driver.findElement(By.id("skw"));
            log.info("--> Click vào khung search");
            a.click();
            log.info("--> Nhập từ khoá tìm kiếm: iphone");
            a.sendKeys("iphone");
            driver.findElement(By.className("icon-search")).submit();
            log.info("--> Click tìm kiếm");
            WebElement c = driver.findElement(By.partialLinkText("14"));
            String T1 = c.getText();
            log.info("--> Lọc " + T1);
            c.click();

            log.info("--> Chọn IPhone 14 Pro Max 128GB " + T1);
            driver.findElement(By.xpath("//img[@alt='iPhone 14 Pro Max 128GB']")).click();

        /*
        //Chọn màu khi không thanh toán qua vnpay
        log.info("--> Chọn màu đen " + T1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('id_of_element').click();");*/

            Boolean isSelected = driver.findElement(By.xpath("//figure[@class='vnpayqr']//i")).isSelected();
            if (isSelected == false) {
                driver.findElement(By.xpath("//figure[@class='vnpayqr']//i")).click();
                log.info("--> Chọn thanh toán qua VNPAY");
            } else {
                log.info("--> Thanh toán qua VNPAY đã được chọn");
            }

            log.info("--> Chọn mua ngay");
            driver.findElement(By.xpath("//a[normalize-space()='MUA NGAY QUA VNPAYQR']")).click();

            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector(\"body > div:nth-child(9) > section:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(1) > span:nth-child(2) > i:nth-child(1)\").click();");
            log.info("---> Chọn giới tính Nam");

            driver.findElement(By.cssSelector("#cusName")).sendKeys("It Test");
            log.info("---> Nhập tên");

            driver.findElement(By.cssSelector("#cusPhone")).sendKeys("0938727300");
            log.info("---> Nhập số điện thoại");

            /*//Case nhận hàng tại siêu thị
            js.executeScript("document.querySelector(\"div[class='choose-link'] i[class='cartnew-choose']\").click();");
            log.info("---> Chọn nhận hàng tại siêu thị ");
            */


            //Chọn địa chỉ nhận hàng
            driver.findElement(By.cssSelector("form[class='active'] div[class='btn-click country'] button[type='button']")).click();
            Thread.sleep(500);
            js.executeScript("document.querySelector(\"form[class='active'] div[class='btn-click country'] button[type='button']\").click()");
            log.info("---> Chọn tỉnh thành");

            driver.findElement(By.cssSelector("form[class='active'] div[class='btn-click district'] button[type='button']")).click();
            Thread.sleep(500);
            js.executeScript("document.querySelector(\"div[class='btn-click district'] aside:nth-child(1) span:nth-child(1)\").click()");
            log.info("---> Chọn quận, huyện");

            Thread.sleep(1500);
            driver.findElement(By.cssSelector("form[class='active'] div[class='wards'] button[type='button']")).click();
            Thread.sleep(500);
            js.executeScript("document.querySelector(\"div[class='wards'] aside:nth-child(1) span:nth-child(1)\").click()");
            log.info("---> Chọn phường xã");

            driver.findElement(By.id("cusAddr")).sendKeys("It Testtttttt");
            log.info("---> Nhập số nhà, tên đường");

            log.info("End");
            driver.quit();
        }catch(Exception error){
                System.out.println(error.toString());
            }

    }
    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}