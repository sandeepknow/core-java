package com.defy.spring.core;

public class Car implements Vehicle {

	String msg;
	int distance;
	
	public Car(String msg){
		this.msg = msg;
	}
	
	@Override
	public void moveDistance(int distance) {
		this.distance = distance;

	}

	@Override
	public String getDistance() {
		return msg + " : " + distance + "km";

	}

}
