package br.scodewr.integroq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegroqApplication {

	private IntegroqApplication(){}
	static void main(String[] args) {
		SpringApplication.run(IntegroqApplication.class, args);
	}

}
