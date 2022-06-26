package test.rest;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Message {
	private final String message;
	private final LocalDateTime time = LocalDateTime.now();	
}
