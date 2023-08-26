package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import net.bytebuddy.asm.Advice.Enter;

public class Linkedin {
    WebDriver driver;
    public  Linkedin(){
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
    public void linke_Din() throws InterruptedException{
      //Navigate to the Url "https://in.linkedin.com/ "  
      driver.get("https://in.linkedin.com/");
      // Enter email id or phone number Using Locator "Name" sendKeys("email") |//input[@name='session_key']
      WebElement emailId = driver.findElement(By.id("session_key"));
      emailId.sendKeys("vermaeti123@gmail.com");
      
      // Using Locator "Name" sendKeys("password') | //input[@name='session_password']
      WebElement passWord = driver.findElement(By.id("session_password"));
      //   sendKeys("password') | //input[@name='session_password']
      passWord.sendKeys("Ajay.230892");
      
      // Click on Sign in button Using Locator "XPath" //button[contains(text(),'Sign in')] |//button[normalize-space()='Sign in']
      WebElement signBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
      signBtn.click();
      Thread.sleep(2000);
      // Print the count of "Who viewed your profile" Using Locator "XPath" //span[1][contains(text(),'6 profile views')]
      //WebElement profileView = driver.findElement(By.xpath("//span[contains(text(),'your profile.')][1]"))  ;     
      
      // Print the count of "Impression on your post" Using Locator "XPath" (//span/strong)[1]
      //WebElement impressCount = driver.findElement(By.xpath("(//span/strong)[1]"));
      // Create a post Using Locator "XPath" //span[text()='Start a post']
      WebElement createPost = driver.findElement(By.xpath("//span[text()='Start a post']"));
      // Click on the create a post button Using Locator "XPath" //span[text()='Start a post']
      createPost.click();
      
      
      // Click on "Post to everyone" Using Locator "XPath" sendKeys.click() | //div[@id='ember466']
      WebElement clickEveryBtn = driver.findElement(By.xpath("//button[contains(@class,'entry-button')]"));
      clickEveryBtn.click();
      // Select Connections only Using Locator "ID" CONNECTIONS_ONLY
      WebElement choose = driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']"));
      choose.click();
      Thread.sleep(2000);
      // Now click on Done button Using Locator "XPath" //span[text()='Done']
      WebElement doneBtn = driver.findElement(By.xpath("//span[text()='Done']"));
      doneBtn.click();
      // Write or create a post  Using Locator "XPath" //div[contains(@data-placeholder,'talk about?')]
      WebElement postShare = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
      // Write something  Using Locator "XPath" sendKeys("hello everyone.........") |//div[@class='ql-editor']
      Thread.sleep(2000);
      postShare.sendKeys("I wish this post will solve my worry.");
      // Now click on POST button Using Locator "XPath" //span[text()='Post']
      WebElement postBtn = driver.findElement(By.xpath("//span[text()='Post']"));
      postBtn.click();
      Thread.sleep(2000);
     // Able to see "Post Successful" msg appered Using Locator "XPath" //span[text()='Post successful.']
     WebElement postDone = driver.findElement(By.xpath("//span[text()='Post successful.']"));
     // Click on view post to confirm Using Locator "XPath" //span[text()='View post']
     Thread.sleep(2000);
     WebElement viewPost = driver.findElement(By.xpath("//a[@class='artdeco-toast-item__cta']"));
     viewPost.click();
     // Post is taking time to load  use wait thread.sleep(3000)
     
     Thread.sleep(2000);
    
     // Verify that New Post is visible or not Using Locator "XPath" //section[@class="fixed-full"]
     WebElement postVisible = driver.findElement(By.xpath("//section[@class='fixed-full']"));
      // Post is visible  sendKeys(visible
      postVisible.isDisplayed();////span[contains(text(),'solve my worry.')] 
}
    
    
}
