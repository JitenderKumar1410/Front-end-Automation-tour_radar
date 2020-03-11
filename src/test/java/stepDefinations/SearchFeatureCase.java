package stepDefinations;

import org.junit.Assert;
import com.tourRadar.pages.SearchFeaturePage;
import com.tourRadar.util.BaseClass;
import com.tourRadar.util.BaseUtil;

import cucumber.api.java.en.Then;

public class SearchFeatureCase extends BaseClass {

	SearchFeaturePage searchFeaturePage;

	@Then("^Verify the visibility of search box$")
	public void verify_the_visibility_of_search_box() {
		searchFeaturePage = new SearchFeaturePage();
		boolean flag = searchFeaturePage.elementVisible();
		Assert.assertTrue(flag);
	}

	@Then("^Verfiy the default text coming in search box$")
	public void verfiy_the_default_text_coming_in_search_box() {
		String defaultTextOfSerachBox = searchFeaturePage.getText();
		Assert.assertTrue(BaseUtil.defaultTextOfSearchBox.contains(defaultTextOfSerachBox));
	}

	@Then("^Click in the search box$")
	public void click_in_the_search_box() {
		searchFeaturePage.clickInSearchBox();
	}

	@Then("^Enter the place where you want to go like \"(.*)\"$")
	public void enter_the_place_where_you_want_to_go_like_india(String arg1) {
		searchFeaturePage.enterPlaceinSearchBox(arg1);
	}

	@Then("^Press \"(.*)\" from the keyboard$")
	public void press_Enter_from_the_keyboard(String arg1) {
		searchFeaturePage.keyboardAction(arg1);
	}

	@Then("^Verify for \"(.*)\" tour page to get loaded successfully$")
	public void verify_for_tour_page_to_get_loaded_successfully(String arg1) {
		searchFeaturePage.waitAndVerifyPage(arg1);
	}

}
