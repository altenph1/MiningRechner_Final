package bl;

import dto.CalculatorDTO;

public class CalculatorDirect extends CryptoCurrency{
	public CalculatorDirect(CalculatorDTO calcDTO) {
		super(calcDTO);
	}
	
	//Rechnung des Betrages (ohne Block)
	public double rechneBetrag() {
		return (calcDTO.getExchangerate() + calcDTO.getHashvalue() + calcDTO.getDifficulty() + calcDTO.getkWhKosten()) * calcDTO.getGpuAnzahl();
	}
	
	//Rechnung des Prozentanteils (ohne Block)
	public double rechnePercentage() {
		return rechneBetrag()*2;
	}

}
