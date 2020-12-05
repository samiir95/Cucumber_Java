package com.tau.steps;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tau.base.BaseUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseUtil{

	private WebDriver driver;
	private BaseUtil baseUtil;
	
	public Steps(BaseUtil util)
	{
		this.baseUtil = util;
	}

	@Given("I am in the login page")
	@Given("I am in the login page of the Para Bank Application")
	public void i_am_in_the_login_page_of_the_Para_Bank_Application() {

		driver.get("http://parabank.parasoft.com/parabank/index.htm");
	}

//	@When("I enter valid {string} and {string}")
//	public void i_enter_valid_credentials(String userName, String password) {
//
//		driver.findElement(By.name("username")).sendKeys(userName);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.name("username")).submit();
//	}
	
	@When("I enter valid {string} and {string} with {string}")
	public void i_enter_valid_credentials(String userName, String password, String userFullName1) {

		baseUtil.userFullName = userFullName1;
		
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("username")).submit();
	}
	
//	@When("I enter valid credentials")
//	public void i_enter_valid_credentials(DataTable table) {
//
//		List<String> loginForm = table.asList();
//		driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
//		driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
//		driver.findElement(By.name("username")).submit();
//	}

	@Then("I should be taken to the overview page")
	public void i_should_be_taken_to_the_overview_page() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rightPanel']/div/div/h1")));
		driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
		
		String actualuserFullName = driver.findElement(By.className("smallText")).getText();
		assertTrue(actualuserFullName.contains(baseUtil.userFullName));
		
		driver.findElement(By.linkText("Log Out")).click();
	}

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void afterMethod() {
		driver.close();
	}
}
