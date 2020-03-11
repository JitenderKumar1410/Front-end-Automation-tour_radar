package com.tourRadar.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tourRadar.util.BaseClass;

/**
 * This page contains state and the behaviour of filter departure test case
 * 
 * @author jitenderkumar01
 *
 */
public class FilterDepartureDatePage extends BaseClass {

	@FindBy(xpath = "//aside[@id='params']//div[4]//h5")
	WebElement depatureDate;

	@FindBy(xpath = "//div[@class='list']/ul")
	WebElement itemListElement;

	/*
	 * Initializing the page factory with driver
	 */
	public FilterDepartureDatePage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * Verifying element is visible on webpage
	 */
	public boolean elementVisible() {
		return depatureDate.isDisplayed();
	}

	/*
	 * Pass value at run time to select the available value from the filter
	 */
	public void clickOnFilter(String arg1) {
		WebElement dp = driver.findElement(
				By.xpath("//aside[@id='params']//div[4]//div[@class='c']//ul//li[@data-pid='" + arg1 + "']"));
		dp.isDisplayed();
		dp.click();
	}

	/*
	 * Get the list of all of the filtered results and Verify all of them are
	 * according to the selected filter only
	 */
	public void verifyDepartureDate(String arg1) {
		WebElement item = itemListElement;
		List<WebElement> itemList = item.findElements(By.tagName("li"));
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < itemList.size(); i++) {
			list.add(driver.findElement(By.xpath("//div[@class='list']//ul//li[" + i
					+ "]//td[@class='br__availability-wrapper-table-column'][1]//div[@class='br__availability-wrapper-date']"))
					.getText());
			Assert.assertTrue(list.get(i - 1).contains(arg1));
		}
	}

}
