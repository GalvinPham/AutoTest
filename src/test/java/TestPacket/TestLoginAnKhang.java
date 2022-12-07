package TestPacket;

import PhucTest.BaiTapTuan3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLoginAnKhang {

    WebDriver driver;

    static Logger log = LogManager.getLogger(TestLoginAnKhang.class.getName());
    @Test
    public void login(){
        log.info("Start_Login_AnKhang");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        String S = "Mở trang: ";
        driver.get("https://staging.nhathuocankhang.com/");
        //driver.get("https://staging.dienmayxanh.com/");
        log.info("---> Click lịch sử đơn hàng: ");
        driver.findElement(By.className("login-lsmh")).click();
        //driver.findElement(By.className("name-order")).click();
        log.info("---> Nhập số điện thoại: ");
        driver.findElement(By.id("txtPhoneNumber")).sendKeys("0336727019");
        log.info("---> Click tiếp tục: ");
        driver.findElement(By.xpath("//form[@id='frmGetVerifyCode']//button[@type='submit'][contains(text(),'Tiếp tục')]")).click();
        log.info("---> Nhập mã xác nhận: ");
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        sleep(1000);
        driver.findElement(By.name("txtOTP")).sendKeys("2106");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.querySelector(\"input[placeholder='Nhập mã xác nhận gồm 4 chữ số']\").setAttribute('numeric','2601')");
        log.info("---> Click tiếp tục: ");
        driver.findElement(By.xpath("//form[@id='frmSubmitVerifyCode']//button[@type='submit'][contains(text(),'Tiếp tục')]")).submit();
        log.info("Start_Login_AnKhang");
    }
    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
