package businessComponent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import generalComponent.GeneralFunctions;
import objectLibrary.HomePage;
import objectLibrary.MarketTab;
import objectLibrary.SignUpPage;

public class FunctionalComponents extends GeneralFunctions {

	GeneralFunctions gf = new GeneralFunctions();

	public void coinDCXSignUp() {

		try {

			initializeAndroidDriver();
			waitUntilDisplayedWithXpath(HomePage.menu);
			driver.findElementByXPath(HomePage.menu).click();
			waitUntilDisplayedWithXpath(HomePage.signUp);
			driver.findElementByXPath(HomePage.signUp).click();
			waitUntilDisplayedWithId(SignUpPage.firstname);
			driver.findElementById(SignUpPage.firstname).sendKeys(getData("FirstName"));
			driver.findElementById(SignUpPage.lastname).sendKeys(getData("LastName"));
			driver.findElementById(SignUpPage.email).sendKeys(getData("Email"));
			driver.findElementById(SignUpPage.password).sendKeys(getData("Password"));
			driver.findElementById(SignUpPage.next).click();
			assertTrue(waitUntilDisplayedWithId(SignUpPage.country));
			driver.findElementById(SignUpPage.country).sendKeys(getData("Country"));
			driver.findElementById(SignUpPage.phoneNumber).sendKeys(getData("PhoneNumber"));
			driver.findElementById(SignUpPage.register).click();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void validateInvalidOTP() {
		try {

			driver.findElementById(SignUpPage.emailOTP).sendKeys("123456");
			driver.findElementById(SignUpPage.PhoneOTP).sendKeys("123456");
			driver.findElementById(SignUpPage.submit).click();
			waitUntilDisplayedWithId(SignUpPage.otpError);
			assertEquals(driver.findElementById(SignUpPage.otpError).getText(),
					"Enter the OTPs sent to poulami1708@gmail.com and 9474000000");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void validateMarket() {
		try {

			initializeAndroidDriver();
			waitUntilDisplayedWithXpath(HomePage.market);
			driver.findElementByXPath(HomePage.market).click();
			driver.findElementByXPath(MarketTab.BTC).click();
			assertNotNull(driver.findElementByXPath(MarketTab.percentage).getText(), "percenatge null");
			System.out.println(driver.findElementByXPath(MarketTab.percentage).getText());
			assertNotNull(driver.findElementByXPath(MarketTab.volume).getText(), "volume null");
			assertNotNull(driver.findElementByXPath(MarketTab.price).getText(), "price null");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
