package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareLaneTest {
//1. Open browser, site https://www.sharelane.com/cgi-bin/register.py
//2. Enter value in ZIP field
//3. click 'continue' button

    @Test
    public void fillZipCodeFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("55555");
        driver.findElement(By.xpath("//*[@value=\"Continue\"]")).click();

        driver.findElement(By.name("first_name")).sendKeys("Anastasiya");
        driver.findElement(By.name("last_name")).sendKeys("Shevtsova");
        driver.findElement(By.name("email")).sendKeys("ashevtsova888@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("123456789");
        driver.findElement(By.name("password2")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@value=\"Register\"]")).click();

        String expectedResult = "Account is created!";
        String actualResult = driver.findElement(By.xpath("//*[@class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
//        driver.quit();
    }
}
