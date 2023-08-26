package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

//import java.util.List;

public class SearchAmazon {
    WebDriver driver;
    public SearchAmazon(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void search_Amazon() throws InterruptedException{
        //Navigate to google.com 
        driver.get("https://www.google.com/");
       //Send keys in the search text area Using Locator "Name" q| sendKeys ("amazon") |//textarea[@name='q']
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("amazon");
        Thread.sleep(2000);
       //In search area/field press enter key Using Locator "Name" q | sendKeys(keys.Return)
       driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
       //Verify that amazon.in is visible Using Locator "XPath" //span[text()='Amazon.in' or text()='Amazon.com']
       driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']"));
       Thread.sleep(2000);
       WebElement amazonVisible = driver.findElement(By.xpath("//span[text()='Amazon.in']"));
       amazonVisible.isDisplayed();
       System.out.println("Amazon.in is visible:::"+ amazonVisible);
    }


    
}