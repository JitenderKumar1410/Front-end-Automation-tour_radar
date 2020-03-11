package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import com.tourRadar.pages.SortFeaturePage;
import com.tourRadar.util.BaseClass;
import com.tourRadar.util.BaseUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SortFeatureCase extends BaseClass {
	SortFeaturePage sortPage;

	@Before
	public void open_web_application() {
		BaseClass.initialization();
		sortPage = new SortFeaturePage();
	}

	@After
	public void close_web_application() {
		driver.quit();
	}

	@Given("^You are are on a home page$")
	public void you_are_are_on_a_home_page() {
		String title = sortPage.validatePageTitle();
		Assert.assertEquals(BaseUtil.pageTitle, title);
	}

	@When("^Scroll down page to \"(.*)\" pixel$")
	public void scroll_down_page_to_pixel(int arg1) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + arg1 + ")");
	}

	@Then("^Check the visibility of sort filter$")
	public void check_the_visibility_of_sort_filter() {
		boolean flag = sortPage.elementVisible();
		Assert.assertTrue(flag);
	}

	@Then("^Verify the default value is in sort filter$")
	public void verify_the_default_value_is_in_sort_filter() {
		String defaultSortValue = sortPage.defaultValueOfSortFilter();
		Assert.assertEquals(defaultSortValue, BaseUtil.defaultSortValue);
	}

	@Then("^Verify all of the options are correct in dropdown of sort filter$")
	public void verify_all_of_the_options_are_correct_in_dropdown_of_sort_filter() {
		sortPage.checkOptionsInSortFilter();
	}

	@When("^Select the \"([^\"]*)\" parameter from the options$")
	public void select_the_parameter_from_the_options(String arg1) {
		boolean flag = sortPage.selectOptionInSortFilter(arg1);
		Assert.assertTrue(flag);
	}

	@Then("^Wait for the list to get updated$")
	public void wait_for_the_list_to_get_updated() {
		boolean flag = sortPage.listUpdated();
		Assert.assertTrue(flag);
	}

	@Then("^Verify list is updated correctly according to selected parameter$")
	public void verify_list_is_updated_correctly_according_to_selected_parameter() {
		sortPage.verifyItemsInUpdatedList();
	}

}
