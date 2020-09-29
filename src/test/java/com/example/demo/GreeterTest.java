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
	void shouldGreetGoodMorningAt6am() throws Exception {
		
		assertEquals("Good morning Bob", greeterAtTimeOfDay(6, 0).greet("bob"));
	}

	@Test
	void shouldGreetGoodMorningAt1159am() throws Exception {
		
		assertEquals("Good morning Bob", greeterAtTimeOfDay(11, 59).greet("bob"));
	}

	@Test
	void shouldGreetGoodEveningAt8pm() throws Exception {
		
		assertEquals("Good evening Bob", greeterAtTimeOfDay(18, 0).greet("bob"));
	}

	@Test
	void shouldGreetGoodEveningAt959pm() throws Exception {
		
		assertEquals("Good evening Bob", greeterAtTimeOfDay(21, 59).greet("bob"));
	}

	@Test
	void shouldGreetGoodnightAt10pm() throws Exception {
		
		assertEquals("Good night Bob", greeterAtTimeOfDay(22, 0).greet("bob"));
	}

	@Test
	void shouldGreetGoodnightAt559am() throws Exception {
		
		assertEquals("Good night Bob", greeterAtTimeOfDay(5, 59).greet("bob"));
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
