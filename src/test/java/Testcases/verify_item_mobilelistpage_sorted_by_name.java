package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class verify_item_mobilelistpage_sorted_by_name {
    public WebDriver driver=null;
    @BeforeTest
    public void setup(){
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public  void Testcase() {
        try{
            driver.get("https://clicks.aweber.com/y/ct/?l=GoDhLn&m=mcNYuYFeLUQLjy9&b=h5T4l2fu1DOGeQSqXkdkzQ");
            String homepagetittle=driver.getTitle();
            SoftAssert softAssert=new SoftAssert();
            Boolean tittle1=homepagetittle.equals("THIS IS DEMO SITE");
            if (tittle1.equals(Boolean.TRUE)){
                System.out.println("The HOME PAGE tittle is present");
            }else {
                System.out.println("The tittle is Not Present");
            }
            driver.findElement(By.linkText("MOBILE")).click();
            String mobilepagatittle=driver.getTitle();
            try{
                softAssert.assertEquals(mobilepagatittle,"Mobile");
            }catch (AssertionError e){
                e.printStackTrace();
            }
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
            try{
                softAssert.assertEquals(namelist,newnamelist);
            }catch (AssertionError e){
                e.printStackTrace();
            }
            softAssert.assertAll();
            System.out.println("All Products are Sorted ");
        }
        catch (AssertionError e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
