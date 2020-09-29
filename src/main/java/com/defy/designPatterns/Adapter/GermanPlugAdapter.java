package com.defy.designPatterns.Adapter;

public class GermanPlugAdapter implements USPlugConnector{

	GermanPlugConnector germanPlugConnector;
	
	GermanPlugAdapter(GermanPlugConnector germanPlugConnector){
		super();
		this.germanPlugConnector = germanPlugConnector;
	}
	
	@Override
	public void giveElectricity() {
		germanPlugConnector.provideElectricity();
		
	}

}
