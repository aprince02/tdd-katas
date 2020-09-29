package com.example.demo;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Greeter {

	private static final LocalDateTime MORNING_BEGINS = localDateTime(6, 0);
	private static final LocalDateTime AFTERNOON_BEGINS = localDateTime(12, 0);
	private static final LocalDateTime EVENING_BEGINS = localDateTime(18, 0);
	private static final LocalDateTime NIGHT_BEGINS = localDateTime(22, 0);
	
	private static LocalDateTime localDateTime(int hours, int minutes) {
		return LocalDateTime.of(LocalDate.now(), LocalTime.of(hours, minutes));
	}

	private Clock clock;
	
	public Greeter() {
		this(Clock.systemDefaultZone());
	}
	public Greeter(Clock clock) {
		this.clock = clock;
	}

	public Object greet(String name) {

		if (name == null) {
			log.warn("null passed to greet");
			throw new IllegalArgumentException("'name' cannot be null");
		}
		if (name.isBlank()) {
			log.warn("blank passed to greet");
			throw new IllegalArgumentException("'name' cannot be empty");
		}
		
		String properName = name.trim();
		properName = properName.substring(0, 1).toUpperCase() + properName.substring(1);
		
		String greeting = greeting();
		
		log.info("{}{}", greeting, properName);
		
		return greeting + properName;
	}
	
	private String greeting() {
		if (LocalDateTime.now(clock).isBefore(MORNING_BEGINS)) {
			return "Good night ";
		}
		if (LocalDateTime.now(clock).isBefore(AFTERNOON_BEGINS)) {
			return "Good morning ";
		}
		if (LocalDateTime.now(clock).isBefore(EVENING_BEGINS)) {
			return "Hello ";
		}
		if (LocalDateTime.now(clock).isBefore(NIGHT_BEGINS)) {
			return "Good evening ";
		}
		return "Good night ";
	}

}
