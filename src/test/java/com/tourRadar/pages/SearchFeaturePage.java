package com.tourRadar.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tourRadar.util.BaseClass;
import com.tourRadar.util.BaseUtil;

import org.junit.Assert;

/**
 * This page contains state and the behaviour of search feature test case
 * 
 * @author jitenderkumar01
 *
 */
public class SearchFeaturePage extends BaseClass {

	@FindBy(className = "tagln-search")
	WebElement searchBox;

	@FindBy(className = "search")
	WebElement search;

	@FindBy(className = "tagln")
	WebElement defaultTextOfSearchBox;

	@FindBy(id = "search-input")
	WebElement textInSearchBox;

	@FindBy(xpath = "//input[@type='text']")
	WebElement entryInSearchBox;

	/*
	 * Initializing the page factory with driver
	 */
	public SearchFeaturePage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * Verifying element is visible returing boolean value
	 */
	public boolean elementVisible() {
		return searchBox.isDisplayed();
	}

	/*
	 * Get the text from the search box
	 */
	public String getText() {
		return defaultTextOfSearchBox.getText();
	}

	/*
	 * Click in the search box
	 */
	public void clickInSearchBox() {
		Assert.assertTrue(search.isDisplayed());
		search.click();
	}

	/*
	 * Takes an input from the feature file and pass arguments to enter value in
	 * search box
	 */
	public void enterPlaceinSearchBox(String arg1) {
		entryInSearchBox.isDisplayed();
		Assert.assertTrue(entryInSearchBox.isEnabled());
		try {
			Thread.sleep(BaseUtil.smallWaitInMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		entryInSearchBox.sendKeys(arg1);
	}

	/*
	 * Code to perform keyboard action like press ENTER
	 */
	public void keyboardAction(String arg1) {
		Assert.assertTrue(entryInSearchBox.isEnabled());
		try {
			Thread.sleep(BaseUtil.smallWaitInMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		entryInSearchBox.sendKeys(Keys.ENTER);
	}

	/*
	 * Asserting correct page is loaded using search functionality
	 */
	public void waitAndVerifyPage(String arg1) {
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains(arg1));
	}
}
