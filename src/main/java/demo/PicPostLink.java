package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PicPostLink {
    WebDriver driver;
    public PicPostLink(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void pic_postLink() throws InterruptedException{
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

        // Create a post Using Locator "XPath" //span[text()='Start a post']
        WebElement createPost = driver.findElement(By.xpath("//span[text()='Start a post']"));
        // Click on the create a post button Using Locator "XPath" //span[text()='Start a post']
        createPost.click();

        // Click on "Post to everyone" Using Locator "XPath" sendKeys.click() | //button[contains(@class,'entry-button')]
        WebElement clickEveryBtn = driver.findElement(By.xpath("//button[contains(@class,'entry-button')]"));
        clickEveryBtn.click();
        // Select Connections only Using Locator "ID" CONNECTIONS_ONLY
         WebElement choose = driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']"));
         choose.click();
        Thread.sleep(2000);
        // Now click on Done button Using Locator "XPath" //span[text()='Done']
        WebElement doneBtn = driver.findElement(By.xpath("//span[text()='Done']"));
        doneBtn.click();
        Thread.sleep(2000);
        WebElement mediaBtn = driver.findElement(By.xpath("//button[@aria-label='Add media']"));
        mediaBtn.click();
        WebElement inputBtn = driver.findElement(By.xpath("//label[text()='Upload from computer']"));
        inputBtn.click();
        String imgPath = "C:\\Users\\Ajay\\OneDrive\\Pictures\\WhatsApp Image 2023-08-23 at 23.53.05.jpg";
        inputBtn.sendKeys(imgPath);
        Thread.sleep(2000);
        WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));
        nextBtn.click();
        Thread.sleep(2000);
        WebElement writeText = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
        writeText.sendKeys("The India Moment!");

        WebElement postBtn = driver.findElement(By.xpath("//span[text()='Post']"));
        postBtn.click();
        Thread.sleep(2000);

        // Able to see "Post Successful" msg appered Using Locator "XPath" //span[text()='Post successful.']
        WebElement postDone = driver.findElement(By.xpath("//span[text()='Post successful.']"));
    
        Thread.sleep(2000);
        WebElement viewPost = driver.findElement(By.xpath("//a[@class='artdeco-toast-item__cta']"));
        viewPost.click();
        // Verify that New Post is visible or not Using Locator "XPath" //section[@class="fixed-full"]
        WebElement postVisible = driver.findElement(By.xpath("//section[@class='fixed-full']"));
        // Post is visible  sendKeys(visible
        postVisible.isDisplayed();
    
    
    
    
    }
    public void endTest(){
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
}
