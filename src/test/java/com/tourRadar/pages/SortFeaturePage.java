package com.tourRadar.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tourRadar.util.BaseClass;
import com.tourRadar.util.BaseUtil;

/**
 * This page contains state and the behaviour of sort feature test case
 * 
 * @author jitenderkumar01
 *
 */
public class SortFeaturePage extends BaseClass {

	Select select;

	@FindBy(className = "sort")
	WebElement sortFiler;

	@FindBy(xpath = "//select[1]")
	WebElement dropDown;

	@FindBy(className = "list")
	WebElement listUpdate;

	@FindBy(xpath = "//div[@class='list']/ul")
	WebElement itemListElement;

	/*
	 * Initializing the page factory with driver
	 */
	public SortFeaturePage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * Returning the title of the page
	 */
	public String validatePageTitle() {
		return driver.getCurrentUrl();
	}

	/*
	 * Returning boolean value that the element is visible or not
	 */
	public boolean elementVisible() {
		return sortFiler.isDisplayed();
	}

	/*
	 * Returning string value as the default value of the sort filter
	 */
	public String defaultValueOfSortFilter() {
		select = new Select(dropDown);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;
	}

	/*
	 * Asserting all of the options are coming correct in filter
	 */
	public void checkOptionsInSortFilter() {
		{
			java.util.List<WebElement> options = select.getOptions();
			int k = 0;
			for (WebElement opt : options) {
				Assert.assertTrue(opt.getText().equals(BaseUtil.expectedSortValue[k]));
				k = k + 1;
			}
		}
	}

	/*
	 * Pass an argument from the feature file and pass here as an argument to select
	 * the required sort option from all of the options in filter
	 * 
	 * Returning boolean
	 */
	public boolean selectOptionInSortFilter(String arg1) {
		dropDown.click();
		select.selectByVisibleText(arg1);
		select.selectByVisibleText(arg1);
		return true;
	}

	/*
	 * Returning boolean value list is updated or not
	 */
	public boolean listUpdated() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list']")));
		return listUpdate.isDisplayed();
	}

	/*
	 * Asserting item is updated according to the selected option
	 */
	public void verifyItemsInUpdatedList() {
		WebElement item = itemListElement;
		List<WebElement> itemList = item.findElements(By.tagName("li"));
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 1; i <= itemList.size(); i++) {
			String sortAmount = driver.findElement(By.xpath("//div[@class='list']//ul//li[" + i
					+ "]//span[@class='js-br__price-wrapper-price-description-value br__price-wrapper-price-description-value']"))
					.getText().replace("₹", "");
			sortAmount = sortAmount.replace(",", "");
			list.add(sortAmount);
		}
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size() - 1) {
				Assert.assertTrue(Integer.parseInt(list.get(i)) <= Integer.parseInt(list.get(i + 1)));
			}
		}
	}
}
