package pages;

import com.application.base.BaseTest;
import com.application.common.utils.SeleniumUtilities;
import com.application.common.utils.IDriverFactory.BrowserType;
import com.application.common.utils.IDriverFactory.LocatorType;
import com.application.constants.Constants;

public class LoginPage extends BaseTest {
	SeleniumUtilities seleniumUtilities;

	public void BroswerLaunch() {
		seleniumUtilities = new SeleniumUtilities(BrowserType.chrome, Constants.Voltus_Url, 30);
		System.out.println("Inside Step - User is On Login Page");
		System.out.println("titile of the page-------" + driver.getTitle());

	}

	public void enterUserName(String Username) {
		System.out.println("Inside step - User Enters username ");
		seleniumUtilities.EnterText("UserID", LocatorType.id, Username);
	}

	public void enterPassWord(String Password) {
		System.out.println("Inside step - User Enters Password");
		seleniumUtilities.EnterText("Password", LocatorType.id, Password);
	}

	public void ClickLogin() {
		System.out.println("Inside Step - Click	on Login button");
		seleniumUtilities.Click("//button[@type='submit']", LocatorType.xpath);
	}

	public void ClickLogout() {
		seleniumUtilities.CloseWindow();
	}

}
