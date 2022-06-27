package azure.rest;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class Controller {

	@GetMapping(path="/test", produces = "application/json")
	public Message test() {
		LocalDateTime start = LocalDateTime.now();
		log.info("Request received - {}", start);
		Message response = new Message("Hellow world");
		try {
			Thread.sleep((long) (Math.random()*1000.0));
		} catch (InterruptedException e) {
			//just ignore
		}
		log.info("Response - {}", response);
		LocalDateTime end = LocalDateTime.now();
		log.info("Request end - {} -  elapsed time {} ms", end, DurationFormatUtils.formatDuration(Duration.between(start, end).toMillis(), "s.S"));
		return response;
	}
}