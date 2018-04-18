package dto;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bl.CryptoCurrency;

public class CalculatorDTO {
	private String selectedCurrency;
	private String selectedGpuModel;
	private int GpuAnzahl;
	private double kWhKosten;
	private double profitPercentage;
	private double profitBetrag;
	//Arrays
	private Currency[] currencies;
	private GPU[] gpus;
	
	public CalculatorDTO() { 
		//hinzufügen der currencies
		currencies = new Currency[8];
		currencies[0] = new Currency("BTC", 1, 1, false);
		currencies[1] = new Currency("ETH", 2, 2, true);
		currencies[2] = new Currency("ETC", 3, 3, false);
		currencies[3] = new Currency("XMR", 4, 4, true);
		currencies[4] = new Currency("ZEC", 5, 5, false);
		currencies[5] = new Currency("PASC", 6, 6, true);
		currencies[6] = new Currency("DASH", 7, 7, false);
		currencies[7] = new Currency("LTC", 8, 8, true);
		//hinzufügen der Grafikkarten
		gpus = new GPU[6];
		gpus[0] = new GPU("Nvidia", "GTX 1080", 1.0);
		gpus[1] = new GPU("Nvidia", "GTX 1080Ti", 2.0);
		gpus[2] = new GPU("Nvidia", "GTX 1070", 3.0);
		gpus[3] = new GPU("Nvidia", "GTX 1070Ti", 4.0);
		gpus[4] = new GPU("Nvidia", "GTX 1060Ti", 5.0);
		gpus[5] = new GPU("Nvidia", "GTX 1060", 6.0);
			
	}
	//zuweisung des index currency
	private int getIndex(Currency[] array, String key) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				continue;
			}
			if (array[i].getName().equals(key)) {
				index = i;
				break;
			}
		}
		return index;
	}
	//zuweisung des index gpu
	private int getIndex(GPU[] array, String key) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				continue;
			}
			if (array[i].getModel().equals(key)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	//getters und setters
	public double getExchangerate() {
		int index = getIndex(currencies, selectedCurrency);
		return currencies[index].getExchangerate();
	}
	
	public double getDifficulty() {
		int index = getIndex(currencies, selectedCurrency);
		return currencies[index].getDifficulty();
	}

	public Currency getSelectedCurrency() {
		int index = getIndex(currencies, selectedCurrency);
		return currencies[index];
	}

	public void setSelectedCurrency(String currency) {
		this.selectedCurrency = currency;
	}
	
	public double getHashvalue() {
		int index = getIndex(gpus, selectedGpuModel);
		return gpus[index].getHashvalue();
	}
	
	public void getSelectedGpuModel(String model) {
		this.selectedGpuModel = model;
	}

	public void setSelectedGpuModel(String selectedGpuModel) {
		this.selectedGpuModel = selectedGpuModel;
	}

	public int getGpuAnzahl() {
		return GpuAnzahl;
	}

	public void setGpuAnzahl(int gpuAnzahl) {
		GpuAnzahl = gpuAnzahl;
	}

	public double getkWhKosten() {
		return kWhKosten;
	}
	
	public void setkWhKosten(double kWhKosten) {
		this.kWhKosten = kWhKosten;
	}


	public void setProfitPercentage(double profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

	public double getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitBetrag(double profitBetrag) {
		this.profitBetrag = profitBetrag;
	}
	
	public double getProfitBetrag() {
		return profitBetrag;
	}
	
	
}
