package demo;

//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFramesAutomation {
    WebDriver driver;
    public  NestedFramesAutomation(){
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
    public void Nested_Frames() throws InterruptedException{
       //Navigate to the url  https://the-internet.herokuapp.com/nested_frames
       driver.get("https://the-internet.herokuapp.com/nested_frames");
       //Maximize the window  driver.manage().window().maximize();
       driver.manage().window().maximize();
       //Switch to the top frame (driver.switchTo.parant()) //frameset//frame[@name='frame-top']
       driver.switchTo().frame("frame-top");
       Thread.sleep(2000);
       
       //Now switch to the frame Left   //frameset[@name='frameset-middle']//frame[1]
       driver.switchTo().frame("frame-left");
       WebElement leftframe = driver.findElement(By.xpath("//body[1]"));
       //Thread.sleep(2000);
       //Now get text  getText() | 'LEFT'
       System.out.println(leftframe.getText());

       //Now switch to the parent frameset (driver.switchTo.parant()) //frameset[@name='frameset-middle']
       driver.switchTo().parentFrame();
       Thread.sleep(2000);
       //Now switch to the middle frame (By.tagName("body")) //frameset[@name='frame-middle']//frame[2]
       driver.switchTo().frame("frame-middle");
       WebElement midFrame = driver.findElement(By.tagName("body"));
       //Now get text  getText() |  'MIDDLE'
       System.out.println(midFrame.getText());
      
      //Now switch to the parent frameset (driver.switchTo.parant()) //frameset[@name='frameset-middle']
      driver.switchTo().parentFrame();
      //Now switch to the right frame  //frameset[@name='frame-middle']//frame[3]
      driver.switchTo().frame("frame-right");
      WebElement rightFrame = driver.findElement(By.tagName("body"));
      //Now get text  getText() | 'RIGHT'
      System.out.println(rightFrame.getText());
    
      // Now switch to the parent frameset (driver.switchTo.parant()) //frameset[@name='frameset-middle']
      driver.switchTo().parentFrame();
      Thread.sleep(2000);
      // Now switch to the Default frame  driver.switchTo().defaultContent(frameset),
      driver.switchTo().defaultContent();
      // Now switch to the bottom frame  //frameset//frame[@name='frame-bottom']
      driver.switchTo().frame("frame-bottom");
      WebElement btmFrame = driver.findElement(By.tagName("body"));
      // Now get text  getText() | 'BOTTOM'
      System.out.println(btmFrame.getText());
      Thread.sleep(2000);
      // Now switch to the main frame  driver.switchTo().defaultContent(frameset),
      driver.switchTo().defaultContent();
    }
    
}
