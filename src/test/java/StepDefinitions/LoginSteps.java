package StepDefinitions;

import static org.junit.Assert.assertArrayEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.application.base.BaseTest;
import com.application.common.utils.IDriverFactory.BrowserType;
import com.application.common.utils.IDriverFactory.LocatorType;
import com.application.common.utils.SeleniumUtilities;
import com.application.constants.Constants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginSteps extends BaseTest {
	SeleniumUtilities seleniumUtilities;
	LoginPage loginpage = new LoginPage();
	Assert asserts;

	@Given("Browser is Open and User is On Login Page")
	public void Browser_is_Open_and_User_is_On_Login_Page() throws Exception {
		loginpage.BroswerLaunch();

	}

	@When("User Enters {string} and {string}")
	public void User_Enters_username_and_Password(String username, String password) {
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
	}

	@And("Click on Login button")
	public void Click_on_Login_button() throws Exception {
		loginpage.ClickLogin();
		
		
		  WebElement homepage =
		  driver.findElement(By.xpath("//a[text()='Find a Doctor']")); if
		  (homepage.isDisplayed() == true) { asserts.assertEquals(homepage, "Sign in");
		  System.out.println("Valid_UserName_Valid_Password " +
		  Thread.currentThread().getId() + "Passed");
		  
		  }
		 
		 
	}

	@Then("user navigates to the Homepage")
	public void user_navigates_to_the_Homepage() {
		loginpage.ClickLogout();
		System.out.println("Inside Steps - user navigates	to the Homepage");
	}

}
