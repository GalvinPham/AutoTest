package PhucTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaiTapLinh {

    WebDriver driver;
    Select select;
    Random rd;
    @Test
    public void nopcommerce(){
        System.out.println("Start");
        rd = new Random();
        WebDriverManager.chromedriver().setup();

        System.out.println("Start");
        driver = new ChromeDriver();
        String S = "Mở trang: ";
        driver.get("https://demoqa.com/automation-practice-form");
        System.out.println(S + driver.getTitle());


        System.out.println("---> Nhập FirstName");
        driver.findElement(By.id("firstName")).sendKeys("Hoàng");
        System.out.println("---> Nhập LastName");
        driver.findElement(By.id("lastName")).sendKeys("Phúc");

        System.out.println("---> Nhập email");
        String email = "Hagoromo" + rd.nextInt(99999) + "@email.com";
        driver.findElement(By.cssSelector("input#userEmail")).sendKeys(email);

        System.out.println("---> Chọn giới tính");
        WebElement a = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        a.click();

        System.out.println("---> Nhập số điện thoại");
        String sdt = "039" + rd.nextInt(99999999);
        driver.findElement(By.cssSelector("input#userNumber")).sendKeys(sdt);

        WebElement b = driver.findElement(By.id("dateOfBirthInput"));
        b.click();
        select = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        select.selectByVisibleText("2000");
        select = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        select.selectByVisibleText("July");
        /*select = new Select(driver.findElement(By.className("react-datepicker__month")));
        select.selectByVisibleText("27");*/
        WebElement c = driver.findElement(By.className("react-datepicker__month"));
        c.click();

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.sendKeys("History");
        subjects.sendKeys(Keys.chord(Keys.ENTER));
        subjects.sendKeys("Maths");
        subjects.sendKeys(Keys.chord(Keys.ENTER));

        WebElement d = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        d.click();

        WebElement uploadEle = driver.findElement(By.id("uploadPicture"));
        uploadEle.sendKeys("E:\\images\\Husky.jpg");

        System.out.println("---> Nhập địa chỉ");
        driver.findElement(By.id("currentAddress")).sendKeys("Paradise");

        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("Haryana");
        state.sendKeys(Keys.chord(Keys.ENTER));

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Karnal");
        city.sendKeys(Keys.chord(Keys.ENTER));

        WebElement e = driver.findElement(By.id("submit"));
        e.submit();
    }
}
