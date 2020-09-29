package com.defy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.defy.spring.core.Bus;
import com.defy.spring.core.Car;
import com.defy.spring.core.SingletonService;
import com.defy.spring.core.Vehicle;

@SpringBootApplication
@EnableEurekaServer
@RestController
@RequestMapping("/api")
public class DiscoveryApplication {

	@Autowired
	List<Vehicle> vehicles;
	
	@Autowired
	private SingletonService singletonService;
	
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}
	
	@GetMapping("/check")
	List<String> check() {
		
		return vehicles.stream().map(x -> x.getDistance()).collect(Collectors.toList());
	}
	
	@Bean("car")
	Car car() {
		Car car = new Car("Car moved");
		car.moveDistance(50);
		return car;
	}
	
	@Bean("bus")
	Bus bus() {
		Bus bus = new Bus("Bus moved");
		bus.moveDistance(100);
		return bus;
	}
	
	@GetMapping("/prototype")
	public List<String> checkProto() throws InterruptedException{
		String first = singletonService.getMethod();
		Thread.sleep(2000);
		String second = singletonService.getMethod();
		return Arrays.asList(first, second);
	}
	

}
