package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
	
	@Before
	public void beforeScenario()
	{
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("This is Before Scenario Hook.");
	}
	
	@Given("Open chrome and start application and check base page of {string}")
	public void open_chrome_and_start_application_and_check_base_page(String url) {
		driver.get(url);
		if(driver.getTitle().equalsIgnoreCase("GTPL Bank Home Page"))
		{
			System.out.println("Correct Base page.");
		}
		else
			System.out.println("Incorrect Base Page.");
	}

	@When("^I enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_username_and_password(String uname,String pass) throws Throwable {
		driver.findElement(By.name("uid")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
		
	}

	@Then("^I verify the \"([^\"]*)\" of the page$")
	public void i_verify_the_of_the_page(String status) throws Exception{
		driver.findElement(By.name("btnLogin")).click();
		try {
			driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			
		}
		
		if(driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage"))
		{
			System.out.println("Logged In Successfully with status : " + status);
		}
		else
			System.out.println("Log In UnSuccessfull with status : " + status);
	}
	
	@After
	public void afterScenario()
	{
		System.out.println("This is After Scenario Hook.");
		driver.manage().deleteAllCookies();
		driver.close();
	}
	

}
