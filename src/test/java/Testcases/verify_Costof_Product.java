package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class verify_Costof_Product {
    public WebDriver driver=null;
    @BeforeTest
    public void setup(){
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void Testcase(){
        try {
            driver.get("https://clicks.aweber.com/y/ct/?l=GoDhLn&m=mcNYuYFeLUQLjy9&b=h5T4l2fu1DOGeQSqXkdkzQ");
            driver.findElement(By.linkText("MOBILE")).click();
            String rate1 = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]")).getText();
            driver.findElement(By.cssSelector("a[title='Xperia']")).click();
            String rate2 = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span")).getText();
            SoftAssert softAssert = new SoftAssert();
            try {
                softAssert.assertEquals(rate1, rate2);
            } catch (AssertionError e) {
                e.printStackTrace();
            }
            softAssert.assertAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
