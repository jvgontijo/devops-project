package br.edu.ifg.sistemaleilao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SistemaleilaoApplication {

	final static Logger logger = LoggerFactory.getLogger(SistemaleilaoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SistemaleilaoApplication.class, args);
	}

	@GetMapping("/something")
	public ResponseEntity<String> something() {
		logger.warn("just checking");
		return ResponseEntity.ok("All ok");
	}

}
