package ua.kharkov.komunalka;

public class Bill {
	
	public static Float ElectricityBill() {
		final int preferential = 75;//количество льготных кв
		final int low_kv = 25;
		Float usedPower;
		Float bill = null;
		// если не ввели сколько использовали
		if (FrameView.spentElectricityTextField.getText() == "") {
			usedPower = 0.0f;
			System.out.println(FrameView.spentElectricityTextField.getText());
		} else {
			System.out.println("ddd " + FrameView.spentElectricityTextField.getText());
			usedPower = Float.parseFloat(FrameView.spentElectricityTextField.getText());
			System.out.println("textFieldValue " + usedPower);

			if (usedPower <= 100) {
				bill = TariffElectricity.tariffElectricity * usedPower;
				System.out.println("price " + bill);
			} else {
				bill = (preferential*(TariffElectricity.tariffElectricity))/2;
				bill = bill + low_kv * (TariffElectricity.tariffElectricity);
				//все остальное по повышенной ставке
				usedPower = usedPower - 100;				
				bill = (float) (bill + (usedPower * TariffElectricity.tariffElectricity2));				
			}
		}
		return bill;
	}
	
	public static Float GasBill() {
		//кубов со скидкой
		final int lowGas = 18;
		Float usedGas= Float.parseFloat(FrameView.spentGasTextField.getText());
		Float bill = null;
		System.out.println("газа истрачено" + usedGas);
		bill = (lowGas * TariffGas.GetTariffGasFromSite())/2;
		usedGas = usedGas - lowGas;
		bill = bill + usedGas * TariffGas.GetTariffGasFromSite();
		return bill;		
	}
	
	public static Float usedWater;
	public static Float WaterBill() {
		Float bill = null;
		usedWater= Float.parseFloat(FrameView.spentWaterTextField.getText());
		bill = usedWater * TariffWater.GetTariffWaterFromSite();
		return bill;		
	}
	
	public static Float SewerageBill() {
		Float bill = null;
		bill = usedWater * TariffSewerage.GetTariffSewerageFromSite();
		return bill;		
	}

}
