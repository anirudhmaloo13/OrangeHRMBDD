package com.brillio.stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginSteps {

	WebDriver driver;
	
	@Given("I have browser with orangehrm application")
	public void i_have_browser_with_orangehrm_application() {
		WebDriverManager.chromedriver().setup();
		
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
	}
	@When("I click on login")
	public void i_click_on_login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	@Then("I should get the access to the portal with title as {string}")
	public void i_should_get_the_access_to_the_portal_with_title_as(String expectedTitle) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Assert.assertEquals(expectedTitle, driver.getTitle());
		
	}
	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedError) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.partialLinkText("Invalid")));
	   String actualError = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
	   Assert.assertEquals(expectedError, actualError);
	  // Assert.assertTrue("Assertion on invalid cred", actualError.contains(expectedError));
	}

}
