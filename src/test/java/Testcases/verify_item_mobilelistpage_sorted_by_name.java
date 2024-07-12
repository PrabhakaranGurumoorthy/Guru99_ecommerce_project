package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class verify_item_mobilelistpage_sorted_by_name {
    static WebDriver driver=null;
    public static void main(String[] args) {
        try{
            driver=new FirefoxDriver();
            driver.get("https://clicks.aweber.com/y/ct/?l=GoDhLn&m=mcNYuYFeLUQLjy9&b=h5T4l2fu1DOGeQSqXkdkzQ");
            String homepagetittle=driver.getTitle();
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertEquals(homepagetittle,"THIS IS DEMO SITE");
            driver.findElement(By.linkText("MOBILE")).click();
            String mobilepagatittle=driver.getTitle();
            softAssert.assertEquals(mobilepagatittle,"Mobile");
            Select select=new Select(driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
            select.selectByVisibleText("Name");
            List <WebElement>elementsnamelist=driver.findElements(By.xpath("//h2[@class='product-name']//a"));
            List namelist= new ArrayList<>();
            for(WebElement e:elementsnamelist) {
                String name=e.getText();
                namelist.add(name);
            }
            List newnamelist= new ArrayList<>(namelist);
            Collections.sort(newnamelist);
            softAssert.assertEquals(namelist,newnamelist);
            softAssert.assertAll();
            System.out.println("All Products are Sorted ");
        }
        catch (AssertionError e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }



    }
}
