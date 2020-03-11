package stepDefinations;

import com.tourRadar.pages.ContactInformationTestPage;
import com.tourRadar.util.BaseUtil;

import cucumber.api.java.en.Then;

public class ContactInformationTestCase extends BaseUtil {

	ContactInformationTestPage contactPage;

	@Then("^Verify the contact number on the web site$")
	public void verify_the_contact_number_on_the_web_site() {
		contactPage = new ContactInformationTestPage();
		contactPage.verifyContactNumber();
	}

	@Then("^Click on the contact number$")
	public void click_on_the_contact_number() {
		contactPage.clickContactNumber();
	}

	@Then("^Verify contact page loaded successfully$")
	public void verify_contact_page_loaded_successfully() {
		contactPage.verifyContactPage();
	}

}
