package testScenarios;

import org.testng.annotations.Test;

import businessComponent.FunctionalComponents;
import generalComponent.GeneralFunctions;

public class TS01_SignUp_Scenarios {
	
	GeneralFunctions gf = new GeneralFunctions();
	FunctionalComponents fc = new FunctionalComponents();
	
		
	@Test(priority=1)
	public void TC01_CoinDCX_SignUp_Valid_Data() throws InterruptedException {
		fc.coinDCXSignUp();
		
	}
	
	@Test(priority=1)
	public void TC02_CoinDCX_SignUp_InValid_OTP() {
		fc.coinDCXSignUp();
		fc.validateInvalidOTP();
	}
	

}
