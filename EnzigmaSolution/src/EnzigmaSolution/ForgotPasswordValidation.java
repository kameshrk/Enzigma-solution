package EnzigmaSolution;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPasswordValidation {


    public static void main(String[] args) throws InterruptedException {
     
        WebDriver driver = new ChromeDriver();

        try {
             driver.manage().window().maximize();
             
            driver.get("https://app.nokodr.com/");
            driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();

            // Handle multiple windows
            String parentHandle = driver.getWindowHandle();
            Set<String> allHandles = driver.getWindowHandles();

            for (String handle : allHandles) {
                if (!handle.equals(parentHandle)) {
                    driver.switchTo().window(handle); // Switch to the new window
                }
            }

            // Validate input fields
            WebElement emailInputField = driver.findElement(By.xpath("//input[@type='email']"));

            // Test valid input: Registered email
            emailInputField.clear();
            emailInputField.sendKeys("kameshrupnar4@gmail.com");
            System.out.println("Entered registered email.");
            
            driver.findElement(By.xpath("//div[text()='Proceed']")).click();
            Thread.sleep(2000); 

            System.out.println("Reset link sent to your email.");

            // Test invalid input: Non-registered email
            emailInputField.clear();
            emailInputField.sendKeys("kameshrupnar1234@gmail.com");
            System.out.println("Entered non-registered email.");
           
            driver.findElement(By.xpath("//div[text()='Proceed']")).click();
            Thread.sleep(2000); 

            System.out.println("Error message displayed for non-registered email.");

            // Test invalid input: Incorrect email format
            emailInputField.clear();
            emailInputField.sendKeys("kameshrupnargmail.com");
            System.out.println("Entered invalid email format.");
          

            driver.findElement(By.xpath("//div[text()='Proceed']")).click();
            Thread.sleep(2000); 

            System.out.println("Error message displayed for invalid email format.");

            // Test blank input
            emailInputField.clear();
            emailInputField.sendKeys("");
            System.out.println("Entered blank email.");
          
            driver.findElement(By.xpath("//div[text()='Proceed']")).click();
        
            System.out.println("Error message displayed for blank email field.");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            
            driver.quit();
        }
    }
}



}
