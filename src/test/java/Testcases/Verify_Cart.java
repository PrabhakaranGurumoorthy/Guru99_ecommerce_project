package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Verify_Cart {
    WebDriver driver=null;
    @BeforeTest
    public void setup(){
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void Verify(){
        try {
            driver.get("https://clicks.aweber.com/y/ct/?l=GoDhLn&m=mcNYuYFeLUQLjy9&b=h5T4l2fu1DOGeQSqXkdkzQ");
            driver.findElement(By.linkText("MOBILE")).click();
            driver.findElement(By.xpath("//li[3]//div[1]//div[3]//button[1]")).click();
            driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("1000");
            driver.findElement(By.xpath("//button[@title='Update']")).click();
            String message1 = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div/div/ul/li/ul/li/span")).getText();
            if (message1.equals("Some of the products cannot be ordered in requested quantity.")) {
                System.out.println("The Error Message is Displayed");
            } else {
                System.out.println("The Error Message is Not Displayed");
            }
            driver.findElement(By.cssSelector("#empty_cart_button")).click();
            String message2 = driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart is Empty']")).getText();
            if (message2.equals("SHOPPING CART IS EMPTY")) {
                System.out.println("The Cart is Empty Message is Displayed");
            } else {
                System.out.println("The Cart is Empty Message is Not Displayed");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
