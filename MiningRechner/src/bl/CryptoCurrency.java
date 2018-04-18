package bl;

import dto.CalculatorDTO;

public abstract class CryptoCurrency {
	//Vorgabe der Klassen
	public abstract double rechneBetrag();
	public abstract double rechnePercentage();
	protected CalculatorDTO calcDTO;
	
	public CryptoCurrency(CalculatorDTO calcDTO) {
		this.calcDTO = calcDTO;
	}
}
