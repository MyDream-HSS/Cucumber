package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepdef{

	WebDriver driver;
	public WebElement username1;
	public WebElement username2;
	public WebElement password1;
	public WebElement password2;
	

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page(){
		driver.get("https://www.freecrm.com/index.html");
		System.out.println("Entered into Login Page");
	}


	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM(){
		String title = driver.getTitle();
		System.out.println("Title:"+title);
		Assert.assertEquals("Free CRM in the cloud software boosts sales", title);
	}

	//Reg Exp:
	//1. \"([^\"]*)\"
	//2. \"(.*)\"

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		Thread.sleep(2000);
		WebElement username1=driver.findElement(By.name("username"));
		//username1.getText();
		username1.sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn =
				driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}


	@Then("^user is on home page$")
	public void user_is_on_hopme_page(){
		String title = driver.getTitle();
		System.out.println("Home Page title ::"+ title);
		Assert.assertEquals("CRMPRO", title);
	}

	@Then("^user moves to new contact page$")
	public void user_moves_to_new_contact_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();

	}


	@Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void user_enters_contacts_details(String firstname, String lastname, String position){
		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.findElement(By.id("surname")).sendKeys(lastname);
		driver.findElement(By.id("company_position")).sendKeys(position);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	}


	@Then("^Close the browser$")
	public void close_the_browser(){
		System.out.println("Close the browser");
	}
	}
