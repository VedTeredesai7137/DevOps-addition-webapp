import org.testng.annotations.Test;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdditionTest {

    @Test
    public void testAddition() throws InterruptedException {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Chrome options for Jenkins / CI environments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {

            // Open local HTML page
            driver.get("file:///C:/Users/5023166/addition-webapp/src/main/webapp/index.html");

            // Locate input fields
            WebElement num1 = driver.findElement(By.id("num1"));
            WebElement num2 = driver.findElement(By.id("num2"));

            // Locate Add button
            WebElement button = driver.findElement(By.tagName("button"));

            // Enter numbers
            num1.sendKeys("5");
            num2.sendKeys("7");

            // Click Add button
            button.click();

            // Wait for result
            Thread.sleep(3000);

            // Get result element
            WebElement result = driver.findElement(By.id("result"));

            // Capture result text
            String text = result.getText();

            // TestNG assertion
            Assert.assertEquals(text, "Result: 12");

        } finally {

            // Close browser safely
            driver.quit();

        }
    }
}
