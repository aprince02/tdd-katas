package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GreeterTest {

	@Test
	void shouldThrowExceptionOnNull() {
		assertThrows(IllegalArgumentException.class, () -> new Greeter().greet(null));
	}
	
	@Test
	void shouldThrowExceptionOnEmpty() {
		assertThrows(IllegalArgumentException.class, () -> new Greeter().greet(""));
	}
	
	@Test
	void shouldThrowExceptionOnBlank() {
		assertThrows(IllegalArgumentException.class, () -> new Greeter().greet(" "));
	}
	
	@Test
	void shouldGreetHelloName() {

		assertEquals("Hello Bob", new Greeter().greet("Bob"));
	}
	
	@Test
	void shouldTrimInput() throws Exception {
		
		assertEquals("Hello Bob", new Greeter().greet(" Bob "));
	}

	@Test
	void shouldCapitaliseFirstLetter() throws Exception {
		
		assertEquals("Hello Bob", new Greeter().greet("bob"));
	}

}
