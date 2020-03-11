package stepDefinations;

import com.tourRadar.pages.NegativeTestLoginPage;
import com.tourRadar.util.BaseClass;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NegativeTestLoginCase extends BaseClass {

	NegativeTestLoginPage loginPage;

	@When("^Click on home and click on Log In button$")
	public void click_on_home_and_click_on_Log_In_button() {
		loginPage = new NegativeTestLoginPage();
		loginPage.clickOnHomeButton();
		loginPage.clickOnLoginOption();
	}

	@Then("^Wait and verify page load successfully$")
	public void wait_and_verify_page_load_successfully() {
		loginPage.correctPageLoaded();
	}

	@Then("^Enter wrong username and password and try to login$")
	public void enter_wrong_username_and_password_and_try_to_login(DataTable credentials) {
		loginPage.enterUserAndPassAndLogin(credentials);
	}

	@Then("^Check the visibility of forget password link$")
	public void check_the_visibility_of_forget_password_link() {
		loginPage.forgetPassword();
	}
}
