package dto;

import javax.swing.plaf.synth.SynthScrollBarUI;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Currency {
	private String name;
	private double exchangeRate;
	private double difficulty;
	private boolean isBlock;
	
	//deklaration Currency
	public Currency(String name, double exchangeRate, double difficulty, boolean isBlock) {
		this.name = name;
		this.exchangeRate = exchangeRate;
		this.difficulty = difficulty;
		this.isBlock = isBlock;
	}

	//getters und setters
	public String getName() {
		return name;
	}
	public double getExchangerate() {
		return exchangeRate;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public boolean isBlock() {
		return isBlock;
	}
}
