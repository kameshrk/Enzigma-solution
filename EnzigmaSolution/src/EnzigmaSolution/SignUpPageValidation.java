package EnzigmaSolution;

import java.util.Scanner;
import java.util.Set;
import  org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpPageValidation {

public static void main(String[] args) throws InterruptedException {
		
		// Open the browser
		ChromeDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");

		// Click on Sign up
		WebElement sign_up = driver.findElement(By.xpath("//a[text()='Sign up']"));
		sign_up.click();

		// Write email in Email text field
		WebElement email = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		email.sendKeys("kameshrupnar4@gmail.com");

		// Select check box
		WebElement checkbox = driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']"));
		checkbox.click();
				
		// Click on Proceed button
		WebElement proceed = driver.findElement(By.xpath("//div[text()='Proceed']"));
		proceed.click();
		Thread.sleep(2000);

		String error = "User already exists";
		String verifyCodeSent = "Verification code sent successfully";

		WebElement message = driver.findElement(By.xpath("//h2[text()='Verification code sent successfully']"));
		String txt = message.getText();

		if (txt.contains(error)) {
			System.out.println("user is already exist");
		} else if (txt.contains(verifyCodeSent)) {
				System.out.println("Verification code sent successfully'");

				driver.findElement(By.xpath("//input[@placeholder='Enter Code']"));
				System.out.println("Enter the OTP manually on the web page");

		// Pause the script for manual OTP entry
		System.out.println("After entered the OTP, press Enter here to continue...");
		Scanner scanner = new Scanner(System.in); 
		scanner.nextLine(); 
		
		WebElement verifyCode = driver.findElement(By.xpath("//div[text()='Verify Code']"));
		verifyCode.click();	

		WebElement first_Name = driver.findElement(By.xpath("//input[@name='firstName']"));
		first_Name.sendKeys("Kamesh");
		
		WebElement Last_Name = driver.findElement(By.xpath("//input[@name='lastName']"));
		Last_Name.sendKeys("rupnar");
		
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[2]"));
		password.sendKeys("Kamesh@123");

		WebElement Confirm_password = driver.findElement(By.xpath("//input[@name='password-confirmpassword']"));
		Confirm_password.sendKeys("Kamesh@123");

		WebElement register = driver.findElement(By.xpath("//div[text()='Register']"));
		register.click();
		

		}

	}
		
	}


