package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImdbRatings {
    WebDriver driver;
    public ImdbRatings(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    
    public void Imdb_Ratings() throws InterruptedException{
        //Navigate to Url   https://www.imdb.com/chart/top
        driver.get(" https://www.imdb.com/chart/top");

         Select drpSelect = new Select(driver.findElement(By.id("sort-by-selector")));
		 //select.selectByVisibleText("Release date");
        //Click on the DropDown button Using Locator "XPath" //*[@id="sort-by-selector"]
        // WebElement click_On_DropdnBtn = driver.findElement(By.xpath("//*[@id=\"sort-by-selector\"]"));
        // click_On_DropdnBtn.click();
        
        //Select the IMDb rating option Using Locator "XPath" //*[@id="sort-by-selector"]/option[3]
         //WebElement ImdbOption = driver.findElement(By.xpath("//*[@id="sort-by-selector"]option[3]"));
        drpSelect.selectByVisibleText("IMDb rating");
        //Verify the "Highest rated movie on IMDb" Using Locator "XPath" //h3[text()='1. The Shawshank Redemption']
        WebElement highestRated = driver.findElement(By.xpath("//h3[text()='1. The Shawshank Redemption']"));
        System.out.println("Highest rated movie::" + highestRated.getText());
        Thread.sleep(2000);
        
       //"Verify total number of movies in the table Using Locator ""XPath"" //h3[1][contains(text(),'250.')]|//ul[contains(@class,'compact-list-view')]|| //ul[contains(@class,'ipc-metadata-list--base')] | list.size()"
        List<WebElement> totalMovies = driver.findElements(By.xpath("//li[@class='ipc-metadata-list-summary-item sc-bca49391-0 eypSaE cli-parent']"));
        System.out.println("Total movies on the table::" + totalMovies.size());
        Thread.sleep(2000);
       //Verify the Oldest Movie on the list Using Locator "XPath" //h3[contains(text(),'The Kid')] |1921
        WebElement old_One_Movie = driver.findElement(By.xpath("//h3[contains(text(),'The Kid')]"));
        System.out.println("Oldest Movie::" + old_One_Movie.getText());
        Thread.sleep(2000);
        //Verify the latest movie on the list Using Locator "XPath" //h3[contains(text(),'Oppenheimer')]
        drpSelect.selectByVisibleText("Release date");
        WebElement latest_Movie = driver.findElement(By.xpath("//h3[contains(text(),'Oppenheimer')]"));
        System.out.println("Latest movie::"+ latest_Movie.getText());
        Thread.sleep(2000);
        //Verify the most user rating movie Using Locator "XPath" //h3[contains(text(),'The Shawshank Redemption')]
        drpSelect.selectByVisibleText("Number of ratings");
        WebElement most_User_Rating = driver.findElement(By.xpath("//h3[contains(text(),'The Shawshank Redemption')]"));
        System.out.println("Most Highest user rating movie::" + most_User_Rating.getText());
    }
    public void endTest(){
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
}
