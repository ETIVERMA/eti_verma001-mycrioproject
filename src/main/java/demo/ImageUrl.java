package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUrl {
    WebDriver driver;
    public  ImageUrl(){
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
    public void Img_Url() throws InterruptedException{
     //Navigate to the Url  "https://in.bookmyshow.com/explore/home/chennai"
     driver.get("https://in.bookmyshow.com/explore/home/chennai");			
     //Search for the all image url Using Locator "XPath" //h2[contains(text(),'Recommended Movies')]/../../../following-sibling::div//a//img			
     //Verify that the image link count Using Locator "XPath" 5 | //h2[contains(text(),'Recommended Movies')]/../../../following-sibling::div//a//img			
     List<WebElement> imgUrlCount = driver.findElements(By.xpath("//h2[contains(text(),'Recommended Movies')]/../../../following-sibling::div//a//img"));
     imgUrlCount.size();
     System.out.println("Total image url count::"+imgUrlCount.size());
      Thread.sleep(2000);
     //Navigate to the home page and   Scroll down use javascript method
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,950)", "Premiere");
     Thread.sleep(2000);
     //Scroll down to the Premiere Using Locator "XPath" //h2[contains(text(),'Premieres')]
     //WebElement secondItem = driver.findElement(By.xpath("//h2[contains(text(),'Premieres')]/../../../following-sibling::div/div/div/a[2]/div[1]"));		
     //Search the second item name Using Locator "XPath" getText() | //h2[contains(text(),'Premieres')]/../../../following-sibling::div/div/div/div[2]//div/div[3]/div[1]			
     
     WebElement name = driver.findElement(By.xpath("//h2[contains(text(),'Premieres')]/../../../following-sibling::div/div/div/a[2]/div/div[3]/div[1]"));
     name.getText();
     //Search the second item language Using Locator "XPath" getText() | //h2[contains(text(),'Premieres')]/../../../following-sibling::div/div/div/div[2]//div/div[3]/div[2			
     Thread.sleep(2000);
     
     WebElement language = driver.findElement(By.xpath("//h2[contains(text(),'Premieres')]/../../../following-sibling::div/div/div/a[2]/div/div[3]/div[2]"));
     language.getText();
     //Browser closed Using Locator "ID"  driver.close()			
    }
    
}
