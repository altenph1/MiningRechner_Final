package bl;

import dto.CalculatorDTO;

public class CalculatorBlock extends CryptoCurrency{
	public CalculatorBlock(CalculatorDTO calcDTO) {
		super(calcDTO);
	}
	
	//Rechnung des Betrages (mit Block)
	public double rechneBetrag() {
		return rechnePercentage()*10;
	}
	//Rechnung des Prozentanteils (mit Block)
	public double rechnePercentage() {
		return (calcDTO.getExchangerate() + calcDTO.getHashvalue() + calcDTO.getDifficulty() + calcDTO.getkWhKosten()) * calcDTO.getGpuAnzahl();
	}

}
