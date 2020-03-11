package stepDefinations;

import org.junit.Assert;

import com.tourRadar.pages.FilterDepartureDatePage;
import com.tourRadar.util.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FilterDepartureDateCase extends BaseClass {
	FilterDepartureDatePage deaprturePage;

	@Then("^Verify the visibility of departure date$")
	public void verify_the_visibility_of_departure_date() {
		deaprturePage = new FilterDepartureDatePage();
		boolean flag = deaprturePage.elementVisible();
		Assert.assertTrue(flag);
	}

	@When("^Click on \"([^\"]*)\" from the filter$")
	public void click_on_from_the_filter(String arg1) {
		deaprturePage.clickOnFilter(arg1);
	}

	@Then("^Verify list is filtered correctly according to \"([^\"]*)\" of departure filter$")
	public void verify_list_is_filtered_correctly_according_to_departure_filter(String arg1) {
		deaprturePage.verifyDepartureDate(arg1);
	}

}
