package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreeterTest {

	@Test
	void shouldGreetHelloName() {

		assertEquals("Hello Bob", new Greeter().greet("Bob"));
	}

}
