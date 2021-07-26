package generalComponent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralFunctions {

	public AndroidDriver<MobileElement> driver;
	public DesiredCapabilities capabilities = null;
	public URL url = null;

	public void initializeAndroidDriver() throws MalformedURLException {

		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		url = new URL(URL_STRING);
		capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 6T");
		capabilities.setCapability("appPackage", "com.coindcx");
		capabilities.setCapability("appActivity", "com.coindcx.security.ScreenLock");
		
		

		driver = new AndroidDriver<MobileElement>(url, capabilities);

	}

	public String getData(String key) throws IOException {
		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TestData.properties");

		Properties p = new Properties();
		p.load(reader);

		return p.getProperty(key);

	}

	public boolean waitUntilDisplayedWithId(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		return true;
	}

	public boolean waitUntilDisplayedWithXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return true;
	}

	public boolean waitUntilDisplayedWithAccesibilityId(String accessibilityId) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accessibilityId)));
		return true;
	}

}
