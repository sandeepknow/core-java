package com.defy.spring.core;

public class Bus implements Vehicle {

	String msg;
	int distance;

	public Bus(String msg) {
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
