package dto;

import java.util.ArrayList;

public class GPU {
	private String manufacturer;
	private String model;
	private double hashvalue;

	//deklaration GPU
	public GPU(String manufacturer, String model, double hashvalue) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.hashvalue = hashvalue;
	}
	
	//getters und setters
	public String getManufacturer() {
		return manufacturer;
	}
	public String getModel() {
		return model;
	}
	
	public double getHashvalue() {
		return hashvalue;
	}
}
