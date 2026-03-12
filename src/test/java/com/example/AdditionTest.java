import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {

    @Test
    public void testAddition() throws InterruptedException {

        // Automatically download and configure ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open the local HTML file
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

        // Wait for result to appear
        Thread.sleep(15000);

        // Locate result element
        WebElement result = driver.findElement(By.id("result"));

        // Capture result text
        String text = result.getText();

        // Validate output
        assertEquals("Result: 12", text);

        // Close browser
        driver.quit();
    }
}