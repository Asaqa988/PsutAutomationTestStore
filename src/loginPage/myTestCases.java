package loginPage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

	Random rand = new Random();

	@BeforeTest
	public void mySetup() {
		driver.get(theURL);

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void Signup() {

		driver.navigate().to(SignupPage);

		// elements
		WebElement firstnameInput = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
		WebElement lastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement emailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement teleInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement faxInput = driver.findElement(By.id("AccountFrm_fax"));
		WebElement companyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement address1Input = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement address2Input = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement cityInput = driver.findElement(By.id("AccountFrm_city"));

		WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement passwordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));

		
		
		
		
		// data

		String[] fristNames = { "amira", "rogina", "dana", "mais", "dareen"};
		int randomIndexForFirstName = rand.nextInt(fristNames.length);
		
		String randomFirstName = fristNames[randomIndexForFirstName]; 
	
		
		String[] lastNames = {"alaa","saif","abduallah","hamzeh", "marwan", "abedalrahman","omar"};
		int randomIndexForLastName = rand.nextInt(lastNames.length);
		String randomLastName = lastNames[randomIndexForLastName]; 
		
		
		int randomNumberForTheEmail = rand.nextInt(7000);
		String email = randomFirstName+randomLastName+randomNumberForTheEmail+"@gmail.com";
		String telephone = "9624545455";
		String fax = "9624545755";
		String company = "abc";
		String address1 = "Amman tlaaelAli";
		String address2 = "Amman ShafaBadran";
		String city = "Amman";
		String PostalCode = "3817";
		String password = "Test@1234";

		
		
		// actions
		
		
		
		
		firstnameInput.sendKeys(randomFirstName);
		lastNameInput.sendKeys(randomLastName);
		emailInput.sendKeys(email);
		teleInput.sendKeys(telephone);
		faxInput.sendKeys(fax);
		companyInput.sendKeys(company);
		address1Input.sendKeys(address1);
		address2Input.sendKeys(address2);
		cityInput.sendKeys(city);
		PostalCodeInput.sendKeys(PostalCode);
		loginNameInput.sendKeys(randomFirstName+randomLastName+randomNumberForTheEmail);
		
		passwordInput.sendKeys(password);
		passwordConfirmInput.sendKeys(password);
	}

}
