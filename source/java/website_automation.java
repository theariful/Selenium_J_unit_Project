import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class website_automation {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void form_fill_up() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-reject-all-handler")).click();

        driver.findElement(By.id("edit-name")).sendKeys("Mohan Lok");
        driver.findElement(By.id("edit-number")).sendKeys("63514");
        driver.findElement(By.xpath("//label[normalize-space()='20-30']")).click();
        driver.findElement(By.id("edit-date")).sendKeys("01/10/2023");

        driver.findElement(By.id("edit-email")).sendKeys("MohanLoker@gmail.com");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I am novel man. Trying to get Novel Prize.");
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/Joker.jpg");

        Scroll();

        Thread.sleep(3500);

        driver.findElement(By.id("edit-age")).click();
        driver.findElement(By.id("edit-submit")).click();

        String text=driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your submission!']")).getText();
        Assertions.assertTrue (text.contains("Thank you for your submission"));

        driver.quit();

    }
    public void Scroll(){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,900)");
    }

}
