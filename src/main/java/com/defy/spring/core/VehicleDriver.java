package com.defy.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class VehicleDriver {

	@Autowired
	Vehicle vehicle;
	
	@Bean
	Car car() {
		Car car = new Car("Car is moving");
		car.moveDistance(50);
		return car;
	}
	
	@Bean
	Bus bus() {
		Bus bus = new Bus("Bus is moving");
		bus.moveDistance(100);
		return bus;
	}
	
	public static void main(String[] args) {

		VehicleDriver driver= new VehicleDriver();
		driver.vehicle.getDistance();
	}

}
