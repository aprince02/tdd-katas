package com.example.demo;

public class Greeter {

	public Object greet(String name) {

		if (name == null) {
			throw new IllegalArgumentException("'name' cannot be null");
		}
		if (name.isBlank()) {
			throw new IllegalArgumentException("'name' cannot be empty");
		}
		
		String greeting = name.trim();
		greeting = greeting.substring(0, 1).toUpperCase() + greeting.substring(1);
				
		return "Hello " + greeting;
	}

}
