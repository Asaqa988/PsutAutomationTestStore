package loginPage;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

	Random rand = new Random();

	String TheUserName;
	String firstName;
	String ThePassword = "Test@1234";

	@BeforeTest
	public void mySetup() {
		driver.get(theURL);

		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = true)
	public void Signup() throws InterruptedException {

		String ConfirmationMessage = "Your Account Has Been Created!";
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
		WebElement agreebox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector("button[title='Continue']"));
		WebElement CountrySelect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateSelect = driver.findElement(By.id("AccountFrm_zone_id"));
		// data

		String[] fristNames = { "amira", "rogina", "dana", "mais", "dareen" };
		int randomIndexForFirstName = rand.nextInt(fristNames.length);

		String randomFirstName = fristNames[randomIndexForFirstName];

		firstName = randomFirstName;
		String[] lastNames = { "alaa", "saif", "abduallah", "hamzeh", "marwan", "abedalrahman", "omar" };
		int randomIndexForLastName = rand.nextInt(lastNames.length);
		String randomLastName = lastNames[randomIndexForLastName];

		int randomNumberForTheEmail = rand.nextInt(7000);
		String email = randomFirstName + randomLastName + randomNumberForTheEmail + "@gmail.com";
		String telephone = "9624545455";
		String fax = "9624545755";
		String company = "abc";
		String address1 = "Amman tlaaelAli";
		String address2 = "Amman ShafaBadran";
		String city = "Amman";
		String PostalCode = "3817";

		// actions

		TheUserName = randomFirstName + randomLastName + randomNumberForTheEmail;

		firstnameInput.sendKeys(randomFirstName);
		lastNameInput.sendKeys(randomLastName);
		emailInput.sendKeys(email);
		teleInput.sendKeys(telephone);
		faxInput.sendKeys(fax);
		companyInput.sendKeys(company);
		address1Input.sendKeys(address1);
		address2Input.sendKeys(address2);
		cityInput.sendKeys(city);

		Select mySelectForTheCountry = new Select(CountrySelect);

		int TotalCountries = CountrySelect.findElements(By.tagName("option")).size();

		int randomCountry = rand.nextInt(1, TotalCountries);

		mySelectForTheCountry.selectByIndex(randomCountry);

		Thread.sleep(2000);

		;

		int numberOfOptions = StateSelect.findElements(By.tagName("option")).size();

		System.out.println(numberOfOptions);

		Select mySelectForTheState = new Select(StateSelect);
		int randomStateIndex = rand.nextInt(1, numberOfOptions);
		mySelectForTheState.selectByIndex(randomStateIndex);

//		Select mySelectForTheState = new Select(StateSelect);
//		int randomStateIndex = rand.nextInt(1, numberOfOptions);
//		mySelectForTheState.selectByValue("1705");

		PostalCodeInput.sendKeys(PostalCode);
		loginNameInput.sendKeys(TheUserName);

		passwordInput.sendKeys(ThePassword);
		passwordConfirmInput.sendKeys(ThePassword);
		agreebox.click();

		ContinueButton.click();

		Thread.sleep(3000);

		boolean ActualResult = driver.getPageSource().contains(ConfirmationMessage);

		Assert.assertEquals(ActualResult, true, "this is to test that the account has been created");

	}

	@Test(priority = 2, enabled = true)
	public void Logout() throws InterruptedException {

		String confirmationMessage = "You have been logged off your account. It is now safe to leave the computer.";
		WebElement LogoutButton = driver.findElement(By.linkText("Logoff"));

		LogoutButton.click();

		Thread.sleep(1000);

		WebElement continueButton = driver.findElement(By.linkText("Continue"));
		// continueButton.click();
		boolean ActualResult = driver.getPageSource().contains(confirmationMessage);
		Assert.assertEquals(ActualResult, true, "this is to test that the account has logged out");

		// optional

		boolean ActualResult2 = driver.getCurrentUrl()
				.equals("https://automationteststore.com/index.php?rt=account/logout");
		boolean expectedResult2 = true;
		Assert.assertEquals(ActualResult2, expectedResult2);
	}

	@Test(priority = 3, enabled = true)
	public void Login() throws InterruptedException {
		WebElement LoginAndRegisterButton = driver.findElement(By.partialLinkText("Login or register"));

		LoginAndRegisterButton.click();

		WebElement Loginname = driver.findElement(By.id("loginFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("loginFrm_password"));
		Loginname.sendKeys(TheUserName);
		passwordInput.sendKeys(ThePassword);

		WebElement LoginButton = driver.findElement(By.xpath("//button[@title='Login']"));
		LoginButton.click();

		Thread.sleep(1000);
		boolean ActualResult = driver.findElement(By.id("customernav")).getText().contains(firstName);

		Assert.assertEquals(ActualResult, true);

		// optional

		String ActualResult2 = driver.findElement(By.id("customernav")).getText();
		String ExpectedResult2 = "Welcome back " + firstName;

		Assert.assertEquals(ActualResult2, ExpectedResult2);

	}

	@Test(priority = 4, invocationCount = 1, enabled = false)

	public void AddtoCart() throws InterruptedException {
		driver.navigate().to(theURL);

		Thread.sleep(1000);
		List<WebElement> theListOfItems = driver.findElements(By.className("prdocutname"));

		int TotalNumberOfItems = theListOfItems.size();

		int RandomItemIndex = rand.nextInt(theListOfItems.size());

		theListOfItems.get(RandomItemIndex).click();
		;

		Thread.sleep(3000);
		WebElement AddToCartButton = driver.findElement(By.className("productpagecart"));

		if (AddToCartButton.getText().equals("Out of Stock")) {
			driver.navigate().back();

			System.out.println("sorry the item out of the stock");
		} else {

			if (driver.getCurrentUrl().contains("product_id=116")) {
				driver.findElement(By.xpath("//label[@for='option344747']")).click();
			}

			AddToCartButton.click();
			WebElement CheckOutButton = driver.findElement(By.linkText("Checkout"));
			CheckOutButton.click();
		}

	}

}
