package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

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

		assertEquals("Hello Bob", greeterAtTimeOfDay(12, 0).greet("Bob"));
	}
	
	@Test
	void shouldTrimInput() throws Exception {
		
		assertEquals("Hello Bob", greeterAtTimeOfDay(12, 0).greet(" Bob "));
	}

	@Test
	void shouldCapitaliseFirstLetter() throws Exception {
		
		assertEquals("Hello Bob", greeterAtTimeOfDay(12, 0).greet("bob"));
	}
	
	@Test
	void shouldGreetGoodMorning() throws Exception {
		
		assertEquals("Good morning Bob", greeterAtTimeOfDay(6, 0).greet("bob"));
	}

	private Greeter greeterAtTimeOfDay(int hours, int minutes) {
		
		Clock clock = clockAtTimeOfDay(hours, minutes);
		return new Greeter(clock);
	}

	private Clock clockAtTimeOfDay(int hours, int minutes) {
		return Clock.fixed(
				LocalDateTime.of(LocalDate.now(), LocalTime.of(hours, minutes)).atZone(ZoneId.systemDefault()).toInstant(), 
				ZoneId.systemDefault());
	}

}
