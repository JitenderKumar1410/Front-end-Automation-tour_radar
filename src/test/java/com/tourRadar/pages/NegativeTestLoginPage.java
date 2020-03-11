package com.tourRadar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tourRadar.util.BaseClass;
import com.tourRadar.util.BaseUtil;

import cucumber.api.DataTable;

import java.util.Map;

import org.junit.Assert;

/**
 * This page contains state and the behaviour of login page test case
 * 
 * @author jitenderkumar01
 *
 */
public class NegativeTestLoginPage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	WebElement login;

	@FindBy(id = "g_email")
	WebElement usernameBox;

	@FindBy(id = "g_password")
	WebElement passwordBox;

	@FindBy(id = "g_send")
	WebElement loginButton;

	@FindBy(id = "message-sign-in")
	WebElement errorMessage;

	@FindBy(xpath = "/html/body/header/div/ul/li[5]")
	WebElement home;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgetPasswordLink;

	/*
	 * Initializing the page factory with driver
	 */
	public NegativeTestLoginPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * Click on login button
	 */
	public void clickOnLoginOption() {
		login.click();
	}

	/*
	 * Asserting correct login page is loaded
	 */
	public void correctPageLoaded() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		boolean flag = wait.until(ExpectedConditions.titleContains(BaseUtil.loginPageTitle));
		Assert.assertTrue(flag);
	}

	/*
	 * Take input from the feature file and pass into this method as an datatable
	 * argument. Then run test for available values under datatable.
	 */
	public void enterUserAndPassAndLogin(DataTable credentials) {
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {

			usernameBox.sendKeys(data.get("username"));
			passwordBox.sendKeys(data.get("password"));
			try {
				loginButton.click();
				Thread.sleep(BaseUtil.smallWaitInMs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			errorMessage.isDisplayed();
			Assert.assertTrue(errorMessage.getText().equals(BaseUtil.errorMessage));
			usernameBox.clear();
			passwordBox.clear();
		}
	}

	/*
	 * Clicking on home button
	 */
	public void clickOnHomeButton() {
		home.click();
	}

	/*
	 * Asserting forgetPassword link
	 */
	public void forgetPassword() {
		boolean flag = forgetPasswordLink.isDisplayed();
		Assert.assertTrue(flag);
	}
}
