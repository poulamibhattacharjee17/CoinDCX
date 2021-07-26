package testScenarios;

import org.testng.annotations.Test;

import businessComponent.FunctionalComponents;
import generalComponent.GeneralFunctions;

public class TS02_Market_Tab_Scenarios {

	GeneralFunctions gf = new GeneralFunctions();
	FunctionalComponents fc = new FunctionalComponents();

	@Test
	public void TC01_CoinDCX_Market_Tab_Validation() {

		fc.validateMarket();
	}


}
