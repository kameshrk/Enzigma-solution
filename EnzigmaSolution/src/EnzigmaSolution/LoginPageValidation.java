package EnzigmaSolution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageValidation {


    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://app.nokodr.com/");
   
            WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
            emailInput.sendKeys("kameshrupnar4@gmail.com");
        
            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
            passwordInput.sendKeys("Kamesh@123");
            
            WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@id='rememberMe']"));
            if (!rememberMeCheckbox.isSelected()) {
                rememberMeCheckbox.click();
            }
            

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']/abx-mergetext/div"));
            loginButton.click();
          
            // Assuming successful login, print a success message
            System.out.println("You are logged in successfully.");

        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        } finally {
            
            driver.quit();
        }
    }
}
