package com.tourRadar.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tourRadar.util.BaseClass;
import com.tourRadar.util.BaseUtil;

/**
 * This page contains state and the behaviour of contact information test case
 * 
 * @author jitenderkumar01
 *
 */
public class ContactInformationTestPage extends BaseClass {

	@FindBy(xpath = "/html/body/header/div/ul/li[6]")
	WebElement home;

	/*
	 * Initialising the page factory with driver
	 */
	public ContactInformationTestPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * Get and verify contact number on page
	 */
	public void verifyContactNumber() {
		boolean flag = home.isDisplayed();
		Assert.assertTrue(flag);
		String actualMobileNumber = home.getText();
		Assert.assertEquals(BaseUtil.expectedContactNumber, actualMobileNumber);
	}

	/*
	 * Click on contact number
	 */
	public void clickContactNumber() {
		home.click();
	}

	/**
	 * Verify correct contact page is opening in window
	 */
	public void verifyContactPage() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		boolean flag = wait.until(ExpectedConditions.titleContains(BaseUtil.contactPageTitle));
		Assert.assertTrue(flag);
	}
}
